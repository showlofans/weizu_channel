package com.weizu.flowsys.web.http.ao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeParams;
import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.http.entity.Charge;
import com.weizu.flowsys.web.http.entity.ChargePo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;

/**
 * @description: 下游充值接口实现（最新）
 * @projectName:weizu-channel
 * @className:ChargeImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月26日 下午3:44:40
 * @version 1.0
 */
@Service(value="chargeImpl")
public class ChargeImpl implements IChargeFacet {

	@Resource
	private ValiUser valiUser;
	@Resource
	private AgencyBackwardDao agencyBackwardDao;
	@Resource
	private ProductCodeAO productCodeAO;
	
	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;
	@Resource
	private PurchaseDao purchaseDAO;
	
	@Resource
	private ChargeAccountAo chargeAccountAO;
	
	@Resource
	private ChargeRecordDao chargeRecordDao;
	@Resource
	private RateDiscountDao rateDiscountDao;
	@Resource
	private RateDiscountAO rateDiscountAO;
	@Resource
	private ChannelChannelDao channelChannelDao;
	@Resource
	private AgencyPurchaseDao agencyPurchaseDao;
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	
	
	private Logger logger = Logger.getLogger("ChargeImpl");
	
	@Transactional
	@Override
	public Charge charge(ChargeParams chargeParams) throws Exception {
		String chargeTel = chargeParams.getNumber();
		Map<String, Object> resMap = PurchaseUtil.getOperatorsByTel(chargeTel);//调用接口得到电话的归属地
		Map<String, Object> sqlMap = getParamsExceptioin(chargeParams,resMap);
		if(sqlMap.get("exceptionDTO") == null){//说明sqlMap中的其他参数都不为空
			
			AgencyBackwardPo backPo = (AgencyBackwardPo)sqlMap.get("backPo");
			PgDataPo pgData = (PgDataPo)sqlMap.get("pgData");
			RateDiscountPo ratePo = (RateDiscountPo)sqlMap.get("ratePo");
			ChannelChannelPo channelPo = (ChannelChannelPo)sqlMap.get("channelPo");
			boolean isChannelStateClose = channelPo.getChannelState() == ChannelStateEnum.CLOSE.getValue();//通道关闭
			int agencyId = backPo.getId();
			int orderPath = OrderPathEnum.CHARGE_SOCKET.getValue();
			int billType = chargeParams.getBillType();
			
			int orderState = OrderStateEnum.CHARGING.getValue();
			String orderStateDetail = OrderStateEnum.CHARGING.getDesc(); 
			int orderResult = OrderStateEnum.CHARGING.getValue();
			String orderResultDetail = OrderStateEnum.CHARGING.getDesc(); 
			Boolean canCharge = true;
			ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyId, billType);
			/**充值前余额*/
			Double agencyBeforeBalance = accountPo.getAccountBalance();
			/**充值额（）*/
			Double orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), pgData.getPgPrice());
			Double agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount); //简单的结果运算
			if(agencyAfterBalance < 0){
				orderResult = OrderStateEnum.DAICHONG.getValue();
				orderResultDetail = ChargeStatusEnum.LACK_OF_BALANCE.getDesc();
				canCharge = false;
			}
			int purResult = 0;
			/**超管参数列表*/
			ChannelDiscountPo cdPo = null;
			Integer superAgencyId = null;
			ChargeAccountPo superAccountPo = null;
			/**超管充值前余额*/
			Double superAgencyBeforeBalance = null;
			/**超管充值额（）*/
			Double superOrderAmount = null;
//			if(!isChannelStateClose){
				/**更新超管的账户信息*/
				cdPo = channelDiscountDao.get(ratePo.getChannelDiscountId());
				superAgencyId = backPo.getRootAgencyId();
				superAccountPo = chargeAccountAO.getAccountByAgencyId(superAgencyId, cdPo.getBillType());
				/**超管充值前余额*/
				superAgencyBeforeBalance = superAccountPo.getAccountBalance();
				/**超管充值额（）*/
				superOrderAmount = NumberTool.mul(cdPo.getChannelDiscount(), pgData.getPgPrice());
//			}
//			Double superAgencyAfterBalance = NumberTool.sub(superAgencyBeforeBalance, superOrderAmount); //简单的结果运算
			Long orderId = null;
			PurchasePo purchasePo = null;
			String chargeTelDetail = resMap.get("chargeTelDetail").toString();
			try {
				OrderUril ou1 = new OrderUril(1);
				orderId = ou1.nextId();
				String chargeTelCity = resMap.get("chargeTelCity").toString();
				purchasePo = new PurchasePo(orderId, chargeParams.getOrderIdFrom(), agencyId, chargeTel, pgData.getId(), 
						System.currentTimeMillis(), chargeTelDetail, chargeTelCity, orderResult, channelPo.getId(), 
						orderResultDetail, orderAmount, billType);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ExchangePlatformPo epPo = exchangePlatformDao.get(channelPo.getEpId());
			String scopeCityCode = PurchaseUtil.getScopeCityByCarrier(chargeTelDetail).get("scopeCityCode").toString();
			ProductCodePo pc = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), pgData.getId()));
			Charge charge = null;
			if(canCharge && pc != null){//可以通过接口充值
				/** 更新登录用户账户信息**/
				accountPo.addBalance(orderAmount,-1);
				int accountRes = chargeAccountAO.updateAccount(accountPo);		//账户最后的结果
				if(accountRes > 0){
					//添加消费记录
					chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
							agencyBeforeBalance, accountPo.getAccountBalance(), 
							billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId, 1 , orderId));
				}
				if(!isChannelStateClose){
					/** 更新超管账户信息**/
					superAccountPo.addBalance(superOrderAmount, -1);
					int superAccountRes = chargeAccountAO.updateAccount(superAccountPo);
					if(superAccountRes > 0){
						//添加消费记录
						chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), superOrderAmount,
								superAgencyBeforeBalance, superAccountPo.getAccountBalance(), 
								cdPo.getBillType(),AccountTypeEnum.DECREASE.getValue(), superAccountPo.getId(), superAgencyId, 1 , orderId));
					}
					BaseInterface bi = SingletonFactory.getSingleton(epPo.getEpEngId(), new BaseP(pc.getProductCode(),orderId,chargeTel,chargeParams.getScope(),epPo));
					ChargeDTO chargeDTO = bi.charge();
					String orderIdApi = chargeDTO.getChargeOrder().getOrderIdApi();
					logger.config("上游返回的订单号："+ orderIdApi);//防止自己系统向上提单了，而自己数据库又没有最新的数据。以便核实订单结果
					purchasePo.setOrderIdApi(orderIdApi);
					charge = getChargeByDTO(chargeDTO,chargeParams,purchasePo);
					if(charge!= null){
						orderResultDetail = charge.getTipMsg();
					}
				}else{
					orderResult = OrderStateEnum.DAICHONG.getValue();
					orderResultDetail = ChargeStatusEnum.CHANNEL_CLOSED.getDesc();
				}
			}else if(pc == null){
				logger.config("产品编码未配置,没有通过接口充值，不产生接口订单号");
			}else{
				logger.config(orderStateDetail + ":没有通过接口充值，不产生接口订单号");
			}
			if(charge == null && !isChannelStateClose){
				throw new Exception("发送接口请求异常，接口调用失败");
			}
			purResult = purchaseDAO.addPurchase(purchasePo);
			AgencyPurchasePo app = new AgencyPurchasePo(agencyId, orderId,ratePo.getId(), orderAmount, billType, orderAmount, backPo.getUserName(), orderPath, orderState);
			app.setOrderStateDetail(orderStateDetail);
			agencyPurchaseDao.add(app);
//			if(!isChannelStateClose){
				AgencyPurchasePo superApp = new AgencyPurchasePo(superAgencyId, orderId,cdPo.getId(), superOrderAmount, cdPo.getBillType(), orderAmount, backPo.getUserName(), orderPath, orderResult);
				superApp.setOrderStateDetail(orderResultDetail);
				agencyPurchaseDao.add(superApp);
//			}
			return charge;
		}else{
			return (Charge) sqlMap.get("exceptionDTO");
		}
	}
	
	/**
	 * @description: 对上接口的充值返回对象转成对下接口的充值对象
	 * @param chargeDTO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @param purchasePo 
	 * @param chargeParams 
	 * @createTime:2017年9月2日 上午11:59:46
	 */
	private Charge getChargeByDTO(ChargeDTO chargeDTO, ChargeParams chargeParams, PurchasePo purchasePo) {
//		ChargeOrder order = chargeDTO.getChargeOrder();
		
		//最好把失败的单子卡下来
		if(chargeDTO != null){
			Charge charge = new Charge(chargeDTO.getTipCode(), chargeDTO.getTipMsg(), new ChargePo(purchasePo.getOrderId(), chargeParams.getNumber(), chargeParams.getFlowsize(), chargeParams.getBillType()));
			return charge;
		}
		return null;
	}

	/**
	 * @description:添加订单前先验证参数是否正确
	 * @param chargeParams
	 * @param resMap 通过号码接口得到的参数
	 * @return null-正确
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月26日 下午5:27:05
	 */
	private Map<String, Object> getParamsExceptioin(ChargeParams chargeParams,Map<String, Object> resMap){
		ChargeStatusEnum chargeEnum = null;
		Map<String, Object> sqlMap = new HashMap<String, Object>();
		
		Charge charge = null;
		AgencyBackwardPo backPo = valiUser.findAgency(chargeParams.getUsername(), chargeParams.getSign());
		
		//验证包体：运营商类型，业务范围，包体大小，包体
		int otype = -1;
		if(resMap == null){
			
		}else{
			otype = Integer.parseInt(resMap.get("operatorType").toString());
			PgDataPo pgData = valiUser.findPg(chargeParams.getScope(), chargeParams.getFlowsize(),otype);//
			
			if(pgData == null)
			{
				chargeEnum = ChargeStatusEnum.PG_NOT_FOUND;
				charge =  new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
				sqlMap.put("exceptionDTO", charge);
				return sqlMap;
			}else{
				sqlMap.put("pgData", pgData);
			}
			int billType = chargeParams.getBillType();
			//验证billType是否正确
			BillTypeEnum billTypeE = BillTypeEnum.getEnum(billType);
			if(billTypeE == null){
				chargeEnum = ChargeStatusEnum.INVALID_BILL_TYPE;
				charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
				sqlMap.put("exceptionDTO", charge);
				return sqlMap;
			}
			//充值用户不合法
			if(backPo == null)
			{
				chargeEnum = ChargeStatusEnum.AUTHENTICATION_FAILURE;
				charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
				sqlMap.put("exceptionDTO", charge);
				return sqlMap;
			}else{
				ChargeAccountPo accountPo =  chargeAccountAO.getAccountByAgencyId(backPo.getId(), billType);
				if(accountPo == null){
					chargeEnum = ChargeStatusEnum.INVALID_BILL_TYPE;
					charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc()+":没有开通该业务", null);
					sqlMap.put("exceptionDTO", charge);
					return sqlMap;
				}else{
					sqlMap.put("backPo", backPo);
					String chargeTelDetail = resMap.get("chargeTelDetail").toString();
					//折扣是忽略包体大小的
					RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(chargeParams.getScope(), chargeTelDetail, backPo.getId(), billType,false);
					if(ratePo == null){
						chargeEnum = ChargeStatusEnum.SCOPE_RATE_UNDEFINED;
						charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
						sqlMap.put("exceptionDTO", charge);
						return sqlMap;
					}else{
						ChannelChannelPo channelPo = channelChannelDao.get(new WherePrams("id", "=", ratePo.getChannelId()));
						boolean isChannelUseStateStoped = channelPo.getChannelUseState() == ChannelUseStateEnum.CLOSE.getValue();//通道状态停止
						if(isChannelUseStateStoped){//通道使用状态暂停，不能提单
							chargeEnum = ChargeStatusEnum.CHANNEL_CLOSED;
							charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
							sqlMap.put("exceptionDTO", charge);
							return sqlMap;
						}else{
							sqlMap.put("ratePo", ratePo);
							sqlMap.put("channelPo", channelPo);
						}
					}
				}
			}
		}
		return sqlMap;
	}

}
