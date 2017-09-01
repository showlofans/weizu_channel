package com.weizu.flowsys.web.http.ao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeParams;
import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
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
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
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
	private ExchangePlatformDao exchangePlatformDao;
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
	
	private Logger logger = Logger.getLogger("ChargeImpl");
	
	@Override
	public ChargeDTO charge(ChargeParams chargeParams) {
		String chargeTel = chargeParams.getNumber();
		Map<String, Object> resMap = PurchaseUtil.getOperatorsByTel(chargeTel);
		Map<String, Object> sqlMap = getParamsExceptioin(chargeParams,resMap);
		if(sqlMap.get("chargeDTO") == null){//说明sqlMap中的其他参数都不为空
			
			//重新定义backDTO
			AgencyBackwardPo backPo = (AgencyBackwardPo)sqlMap.get("backPo");
			PgDataPo pgData = (PgDataPo)sqlMap.get("pgData");
			RateDiscountPo ratePo = (RateDiscountPo)sqlMap.get("ratePo");
			ChannelChannelPo channelPo = (ChannelChannelPo)sqlMap.get("channelPo");
			int agencyId = backPo.getId();
			int orderPath = OrderPathEnum.CHARGE_SOCKET.getValue();
			int billType = chargeParams.getBillType();
			ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyId, billType);
			/**充值前余额*/
			Double agencyBeforeBalance = accountPo.getAccountBalance();
			/**充值额（）*/
			Double orderPrice = NumberTool.mul(ratePo.getActiveDiscount(), pgData.getPgPrice());
			accountPo.addBalance(orderPrice,-1);
			/** 更新登录用户账户信息**/
			int accountRes = chargeAccountAO.updateAccount(accountPo);
			int purResult = 0;
			Long orderId = null;
			PurchasePo purchasePo = null;
			Boolean canCharge = true;
			if(accountRes > 0){
				try {
					OrderUril ou1 = new OrderUril(1);
					orderId = ou1.nextId();
					String chargeTelDetail = resMap.get("chargeTelDetail").toString();
					String chargeTelCity = resMap.get("chargeTelCity").toString();
					
					Double agencyAfterBalance = accountPo.getAccountBalance();
					
					int orderState = OrderStateEnum.CHARGING.getValue();
					String orderStateDetail = OrderStateEnum.CHARGING.getDesc(); 
					if(agencyAfterBalance < 0){
						orderState = OrderStateEnum.DAICHONG.getValue();
						orderStateDetail = ChargeStatusEnum.LACK_OF_BALANCE.getDesc();
						canCharge = false;
					}
					purchasePo = new PurchasePo(orderId, chargeParams.getOrderIdFrom(), agencyId, chargeTel, pgData.getId(), 
							System.currentTimeMillis(), chargeTelDetail, chargeTelCity, orderState, channelPo.getId(), 
							orderStateDetail, orderPrice, billType);
					purResult = purchaseDAO.addPurchase(purchasePo);
					if(canCharge){//可以通过接口充值
						ExchangePlatformPo epPo = exchangePlatformDao.get(channelPo.getEpId());
						String scopeCityCode = PurchaseUtil.getScopeCityByCarrier(chargeTelDetail).get("scopeCityCode").toString();
						ProductCodePo pc = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), pgData.getId()));
						if(pc != null){
							BaseInterface bi = SingletonFactory.getSingleton(epPo.getEpEngId(), new BaseP(pc.getProductCode(),orderId+"",chargeTel,chargeParams.getScope(),epPo));
							ChargeDTO chargeDTO = bi.charge();
						}else{
							logger.config("产品编码未配置");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}else{
			return (ChargeDTO) sqlMap.get("chargeDTO");
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
		
		ChargeDTO chargeDTO = null;
		AgencyBackwardPo backPo = valiUser.findAgency(chargeParams.getUsername(), chargeParams.getSign());
		
		//验证包体：运营商类型，业务范围，包体大小，包体
		int otype = -1;
		otype = Integer.parseInt(resMap.get("operatorType").toString());
		PgDataPo pgData = valiUser.findPg(chargeParams.getScope(), chargeParams.getFlowsize(),otype);//
		
		if(pgData == null)
		{
			chargeEnum = ChargeStatusEnum.PG_NOT_FOUND;
			chargeDTO =  new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), null);
			sqlMap.put("chargeDTO", chargeDTO);
			return sqlMap;
		}else{
			sqlMap.put("pgData", pgData);
		}
		int billType = chargeParams.getBillType();
		//验证billType是否正确
		BillTypeEnum billTypeE = BillTypeEnum.getEnum(billType);
		if(billTypeE == null){
			chargeEnum = ChargeStatusEnum.INVALID_BILL_TYPE;
			chargeDTO = new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), null);
			sqlMap.put("chargeDTO", chargeDTO);
			return sqlMap;
		}
		//充值用户不合法
		if(backPo == null)
		{
			chargeEnum = ChargeStatusEnum.AUTHENTICATION_FAILURE;
			chargeDTO = new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), null);
			sqlMap.put("chargeDTO", chargeDTO);
			return sqlMap;
		}else{
			ChargeAccountPo accountPo =  chargeAccountAO.getAccountByAgencyId(backPo.getId(), billType);
			if(accountPo == null){
				chargeEnum = ChargeStatusEnum.INVALID_BILL_TYPE;
				chargeDTO = new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc()+":没有开通该业务", null);
				sqlMap.put("chargeDTO", chargeDTO);
				return sqlMap;
			}else{
				sqlMap.put("backPo", backPo);
				String chargeTelDetail = resMap.get("chargeTelDetail").toString();
				//折扣是忽略包体大小的
				RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(chargeParams.getScope(), chargeTelDetail, backPo.getId(), billType);
				if(ratePo == null){
					chargeEnum = ChargeStatusEnum.SCOPE_RATE_UNDEFINED;
					chargeDTO = new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), null);
					sqlMap.put("chargeDTO", chargeDTO);
					return sqlMap;
				}else{
					ChannelChannelPo channelPo = channelChannelDao.get(new WherePrams("id", "=", ratePo.getChannelId()));
					boolean isChannelUseStateStoped = channelPo.getChannelUseState() == ChannelUseStateEnum.CLOSE.getValue();//通道状态停止
					if(isChannelUseStateStoped){//通道使用状态暂停，不能提单
						chargeEnum = ChargeStatusEnum.CHANNEL_CLOSED;
						chargeDTO = new ChargeDTO(chargeEnum.getValue(),chargeEnum.getDesc(), null);
						sqlMap.put("chargeDTO", chargeDTO);
						return sqlMap;
					}else{
						sqlMap.put("ratePo", ratePo);
						sqlMap.put("channelPo", channelPo);
					}
				}
			}
		}
		return sqlMap;
	}

}
