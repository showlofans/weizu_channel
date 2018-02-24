package com.weizu.flowsys.web.http.ao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.api.weizu.charge.ChargeParams;
import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.AgencyForwardEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.EpEncodeTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
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
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.http.entity.Charge;
import com.weizu.flowsys.web.http.entity.ChargePo;
import com.weizu.flowsys.web.http.entity.PurchaseLog;
import com.weizu.flowsys.web.system_base.ao.SystemConfAO;
import com.weizu.flowsys.web.system_base.pojo.SystemConfPo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.AccountPurchaseDao;
import com.weizu.flowsys.web.trade.dao.ChargeLogDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseLogDao;
import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

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
//	@Resource
//	private AgencyBackwardDao agencyBackwardDao;
	@Resource
	private AgencyAO agencyAO;
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
	private AccountPurchaseDao accountPurchaseDao;
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private PurchaseLogDao purchaseLogDao;
	@Resource
	private ChargeLogDao chargeLogDao;
	
	@Resource
	private SystemConfAO systemConfAO;
	
	
//	private Logger logger = Logger.getLogger("ChargeImpl");
	
	@Transactional
	@Override
	public Charge charge(ChargeParams chargeParams) throws Exception {
		String chargeTel = chargeParams.getNumber();
		Map<String, Object> resMap = PurchaseUtil.getOperatorsByTel(chargeTel);//调用接口得到电话的归属地
		Map<String, Object> sqlMap = getParamsExceptioin(chargeParams,resMap);
		Charge charge = null;
		if(sqlMap.get("exceptionDTO") == null){//说明sqlMap中的其他参数都不为空
			AgencyBackwardPo backPo = (AgencyBackwardPo)sqlMap.get("backPo");
			ChargeAccountPo accountPo = (ChargeAccountPo)sqlMap.get("accountPo");
			PgDataPo pgData = (PgDataPo)sqlMap.get("pgData");
			RateDiscountPo ratePo = (RateDiscountPo)sqlMap.get("ratePo");
			ChannelChannelPo channelPo = (ChannelChannelPo)sqlMap.get("channelPo");
			boolean isChannelStateClose = channelPo.getChannelState() == ChannelStateEnum.CLOSE.getValue();//通道关闭
			int accountId = accountPo.getId();
			int orderPath = OrderPathEnum.CHARGE_SOCKET.getValue();
			int billType = chargeParams.getBillType();
			
			int orderState = OrderStateEnum.CHARGING.getValue();
			String orderStateDetail = OrderStateEnum.CHARGING.getDesc(); 
			int orderResult = OrderStateEnum.CHARGING.getValue();
			String orderResultDetail = OrderStateEnum.CHARGING.getDesc(); 
			
			int purResult = 0;
			/**超管参数列表*/
			ChannelDiscountPo cdPo = null;
			Integer superAgencyId = null;
			ChargeAccountPo superAccountPo = null;
			/**超管充值前余额*/
			Double superAgencyBeforeBalance = null;
			/**超管充值额（）*/
			Double superOrderAmount = null;
				/**更新超管的账户信息*/
				cdPo = channelDiscountDao.get(ratePo.getChannelDiscountId());
				AgencyBackwardPo superAgencyPo = agencyAO.getRootAgencyById(backPo.getId());
				if(superAgencyPo != null){
					superAgencyId = superAgencyPo.getId();
					superAccountPo = chargeAccountAO.getAccountByAgencyId(superAgencyId, cdPo.getBillType());
					/**超管充值前余额*/
					superAgencyBeforeBalance = superAccountPo.getAccountBalance();
					/**超管充值额（）*/
					superOrderAmount = NumberTool.mul(cdPo.getChannelDiscount(), pgData.getPgPrice());
				}
			/**充值前余额*/
			Double agencyBeforeBalance = accountPo.getAccountBalance();
			/**充值额（）*/
			Double orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), pgData.getPgPrice());
			Long orderId = null;
			PurchasePo purchasePo = null;
			
			Integer supperRecAddTag = OrderResultEnum.ERROR.getCode();
			Integer recAddTag = OrderResultEnum.ERROR.getCode();
			//提单失败-余额不足
			Double agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount); //简单的结果运算
//			int orderResultStatus = ChargeStatusEnum.CHARGE_SUCCESS.getValue();
			String chargeTelDetail = resMap.get("chargeTelDetail").toString();
			Charge chargeOne = null;//日志订单充值实体
			if(agencyAfterBalance < 0){//只记录下游日志,同时给下游返回认证失败，余额不足的错误
				orderResult = OrderStateEnum.UNCHARGE.getValue();
				orderResultDetail = chargeParams.getUserName()+ "下游余额不足，未扣款直接失败"; 
				//在日志中用5002来查余额不足的提单请求
				chargeOne = new Charge(ChargeStatusEnum.LACK_OF_BALANCE.getValue(), orderResultDetail, new ChargePo(null, chargeParams.getNumber(), chargeParams.getFlowsize(), chargeParams.getBillType()));
				String accountDesc = "超管账户更新："+ OrderResultEnum.getEnum(supperRecAddTag).getMsg() + ",传单账户更新："+ OrderResultEnum.getEnum(recAddTag).getMsg();
				ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), chargeOne.toString(), null, chargeParams.getNumber(), chargeOne.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":"+accountDesc);
				chargeLogDao.add(chargeLog);
				charge = new Charge(ChargeStatusEnum.LACK_OF_BALANCE.getValue(), ChargeStatusEnum.LACK_OF_BALANCE.getDesc(), null);
			}else{
				//开始正常扣款
				//记录上下游日志，添加订单记录和扣款
				try {
					OrderUril ou1 = new OrderUril(1);
					orderId = ou1.nextId();
					String chargeTelCity = resMap.get("chargeTelCity").toString();
					purchasePo = new PurchasePo(orderId, chargeParams.getOrderIdFrom(), accountId, chargeTel, pgData.getId().toString(), 
							pgData.getPgPrice(),System.currentTimeMillis(), chargeTelDetail, chargeTelCity, orderResult, channelPo.getChannelName(), 
							orderResultDetail, orderAmount, billType,PgServiceTypeEnum.PGCHARGE.getValue());
					if(StringHelper.isNotEmpty(chargeParams.getReportUrl())){//
						purchasePo.setAgencyCallIp(chargeParams.getReportUrl());
					}else{//传单没有传回调地址,使用系统固定的回调地址
						purchasePo.setAgencyCallIp(backPo.getCallBackIp());
					}
					purchasePo.setEpId(channelPo.getEpId());
					//增加订单
					purResult = purchaseDAO.addPurchase(purchasePo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				long recordId = 0l;
				long supperRecordId = 0l;
				//添加消费记录
				int recAddRes = 0;
				int supperRecAddRes = 0;
				int apAddRes = 0;
				int supperApAddRes = 0;
				/** 更新登录用户账户信息**/
				accountPo.addBalance(orderAmount,-1);
				int accountRes = chargeAccountAO.updateAccount(accountPo);		//账户最后的结果
				if(accountRes > 0){
					//添加消费记录
					recAddRes = chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
							agencyBeforeBalance, accountPo.getAccountBalance(), 
							AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), PgServiceTypeEnum.PGCHARGE.getValue() , orderId));
					recordId = chargeRecordDao.nextId() -1;
					if(recordId != 0){
						recAddTag = OrderResultEnum.SUCCESS.getCode();
						AccountPurchasePo app = new AccountPurchasePo(accountId, orderId,ratePo.getChannelDiscountId(), orderAmount,accountId,recordId, orderAmount, backPo.getUserName(), orderPath, orderState);
						app.setOrderStateDetail(orderStateDetail);
						apAddRes = accountPurchaseDao.add(app);
					}
				}
				/** 通道暂停也更新超管账户信息**/
				superAccountPo.addBalance(superOrderAmount, -1);
				int superAccountRes = chargeAccountAO.updateAccount(superAccountPo);
				
				if(superAccountRes > 0){
					//添加消费记录
					supperRecAddRes = chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), superOrderAmount,
							superAgencyBeforeBalance, superAccountPo.getAccountBalance(), 
							AccountTypeEnum.DECREASE.getValue(), superAccountPo.getId(), 1 , orderId));
					supperRecordId = chargeRecordDao.nextId() -1 ;
					if(supperRecordId != 0){
						supperRecAddTag = OrderResultEnum.SUCCESS.getCode();
						AccountPurchasePo superApp = new AccountPurchasePo(superAccountPo.getId(), orderId,cdPo.getId(), superOrderAmount, accountPo.getId(),supperRecordId, orderAmount, backPo.getUserName(), orderPath, orderResult);
						superApp.setOrderStateDetail(orderResultDetail);
						supperApAddRes = accountPurchaseDao.add(superApp);
					}
				}
				//记录下游日志
				charge = new Charge(ChargeStatusEnum.CHARGE_SUCCESS.getValue(), ChargeStatusEnum.CHARGE_SUCCESS.getDesc(), new ChargePo(purchasePo.getOrderId(), chargeParams.getNumber(), chargeParams.getFlowsize(), chargeParams.getBillType()));
				String accountDesc = "超管账户更新："+ OrderResultEnum.getEnum(supperRecAddTag).getMsg() + ",传单账户更新："+ OrderResultEnum.getEnum(recAddTag).getMsg();
				ChargeLog chargeLogBack = new ChargeLog(chargeParams.toString(), charge.toString(), orderId, chargeParams.getNumber(), charge.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":"+accountDesc);
				chargeLogDao.add(chargeLogBack);
				
				ExchangePlatformPo epPo = exchangePlatformDao.get(channelPo.getEpId());
				ProductCodePo pc = null;
				if(EpEncodeTypeEnum.WITH_CODE.getValue().equals(epPo.getEpEncodeType())){
					String scopeCityCode = StringHelper.isNotEmpty(chargeTelDetail)?PurchaseUtil.getScopeCityByCarrier(chargeTelDetail).get("scopeCityCode").toString():null;
					pc = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), pgData.getId()));
				}else{
					pc = productCodeAO.getOneProductCodeByPg(pgData.getId());
				}
				//设置日志信息，根据上游充值状态，设置自己的订单结果状态
				String logInContent = chargeParams.toString();
				String logOutContent = "";
				int tipCode = -1;
				boolean canChargeByBI =  pc != null && purResult > 0 && supperApAddRes > 0 && supperRecAddRes > 0 && recAddRes > 0 && apAddRes > 0;
				if(canChargeByBI){//可以通过接口充值(自己系统里有了订单，才去向上提单)
					if(!isChannelStateClose){//canCharge：余额足够
						BaseInterface bi = SingletonFactory.getSingleton(epPo.getEpEngId(), new BaseP(pc,orderId,chargeTel,epPo,DateUtil.formatPramm(purchasePo.getOrderArriveTime(), "yyyy-MM-dd")));
						ChargeDTO chargeDTO = bi.charge();
						if(chargeDTO == null){
							orderResult = OrderStateEnum.DAICHONG.getValue();
							orderResultDetail = ChargeStatusEnum.API_ERROR.getDesc();
							purchasePo.setOrderResult(orderResult);
							purchasePo.setOrderResultDetail(orderResultDetail);
							chargeOne = new Charge(ChargeStatusEnum.API_ERROR.getValue(), "chargeDTO为空", new ChargePo(purchasePo.getOrderId(), chargeParams.getNumber(), chargeParams.getFlowsize(), chargeParams.getBillType()));
							logOutContent = chargeOne.toString();
							tipCode = chargeOne.getTipCode();
						}else{
							//上有接口充值返回异常
							if(OrderResultEnum.SUCCESS.getCode().equals(chargeDTO.getTipCode())){
								ChargeOrder co = chargeDTO.getChargeOrder();
								String orderIdApi = co.getOrderIdApi();
								//logger.config("上游返回的订单号："+ orderIdApi);//防止自己系统向上提单了，而自己数据库又没有最新的数据。以便核实订单结果
								purchasePo.setOrderIdApi(orderIdApi);
								orderResultDetail = chargeDTO.getTipMsg();
								chargeOne = getChargeByDTO(chargeDTO,chargeParams,purchasePo);
							}else{
								orderResult = OrderStateEnum.DAICHONG.getValue();
								orderResultDetail = chargeDTO.getTipMsg();
								purchasePo.setOrderResult(orderResult);
								purchasePo.setOrderResultDetail(orderResultDetail);
								chargeOne = new Charge(OrderResultEnum.ERROR.getCode(), orderResultDetail,null);
							}
							//返回参数
							StringBuffer sb = new StringBuffer();
							sb.append("tipCode:"+chargeDTO.getTipCode()+",");
							sb.append("tipMsg:"+chargeDTO.getTipMsg()+",jsonStr:");
							sb.append(chargeDTO.getJsonStr());
							
							logInContent = "编码："+pc.getProductCode()+"，平台名称:"+epPo.getEpName();
							logOutContent = sb.toString();
							tipCode = chargeDTO.getTipCode();
						}
					}else{
						orderResult = OrderStateEnum.DAICHONG.getValue();
						orderResultDetail = ChargeStatusEnum.CHANNEL_CLOSED.getDesc();
						purchasePo.setOrderResult(orderResult);
						purchasePo.setOrderResultDetail(orderResultDetail);
						chargeOne = new Charge(ChargeStatusEnum.CHANNEL_CLOSED.getValue(), orderResultDetail, new ChargePo(purchasePo.getOrderId(), chargeParams.getNumber(), chargeParams.getFlowsize(), chargeParams.getBillType()));
						logOutContent = chargeOne.toString();
						tipCode = chargeOne.getTipCode();
					}
				}else{
					chargeOne = new Charge(-1, "产品编码未配置,pc:"+(pc == null), new ChargePo(purchasePo.getOrderId(), chargeParams.getNumber(), chargeParams.getFlowsize(), chargeParams.getBillType()));
					logOutContent = chargeOne.toString();
					tipCode = chargeOne.getTipCode();
					//logger.config(orderStateDetail + ":没有通过接口充值，不产生接口订单号");
				}
				purchaseDAO.updatePurchaseState(purchasePo);
//				//增加订单
//				purResult = purchaseDAO.addPurchase(purchasePo);
				//需要在添加订单之后，再添加账户订单关联记录
				
				//记录上游日志
				ChargeLog chargeLog = new ChargeLog(logInContent, logOutContent, purchasePo.getOrderId(), purchasePo.getChargeTel(), tipCode, System.currentTimeMillis(), AgencyForwardEnum.FOWARD.getValue(), epPo.getEpPurchaseIp());
				chargeLogDao.add(chargeLog);
			}
		}else{
			charge = (Charge) sqlMap.get("exceptionDTO");
			ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), charge.toString(), null, chargeParams.getNumber(), charge.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":异常-没有生成订单！");
			chargeLogDao.add(chargeLog);
		}
		return charge;
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
			Charge charge = new Charge(ChargeStatusEnum.CHARGE_SUCCESS.getValue(), ChargeStatusEnum.CHARGE_SUCCESS.getDesc(), new ChargePo(purchasePo.getOrderId(), chargeParams.getNumber(), chargeParams.getFlowsize(), chargeParams.getBillType()));
			return charge;
		}
		else{
			Charge charge = new Charge(OrderStateEnum.UNCHARGE.getValue(), OrderStateEnum.UNCHARGE.getDesc(), new ChargePo(purchasePo.getOrderId(), chargeParams.getNumber(), chargeParams.getFlowsize(), chargeParams.getBillType()));
			return charge;
		}
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
		AgencyBackwardPo backPo = valiUser.findAgency(chargeParams.getUserName(), chargeParams.getSign());
		//充值用户不合法
		if(backPo == null)
		{
			chargeEnum = ChargeStatusEnum.AUTHENTICATION_FAILURE;
			charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc() , null);
			sqlMap.put("exceptionDTO", charge);
			return sqlMap;
		}
		sqlMap.put("backPo", backPo);
		//合法用户传的错误日志，选择记录(只检查入参有没有配置)
//		ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), null, null, chargeParams.getNumber(), charge.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":"+accountDesc);
//		chargeLogDao.add(chargeLog);
		
		//验证包体：运营商类型，业务范围，包体大小，包体
		int otype = -1;
		if(resMap == null){
			chargeEnum = ChargeStatusEnum.CITY_NOT_FOUND;
			charge =  new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
//			ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), charge.toString(), null, chargeParams.getNumber(), charge.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":调用归属地接口异常");
//			chargeLogDao.add(chargeLog);
			sqlMap.put("exceptionDTO", charge);
			return sqlMap;
		}else{
			otype = Integer.parseInt(resMap.get("operatorType").toString());
			PgDataPo pgData = valiUser.findPg(new PgDataPo(otype,  chargeParams.getFlowsize(), chargeParams.getScope(), chargeParams.getPgType(), chargeParams.getPgValidity(),chargeParams.getChannelType()));//,,,PgServiceTypeEnum.PGCHARGE.getValue()
			
			if(pgData == null)
			{
				chargeEnum = ChargeStatusEnum.PG_NOT_FOUND;
				charge =  new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
//				ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), charge.toString(), null, chargeParams.getNumber(), charge.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":"+chargeEnum.getDesc());
//				chargeLogDao.add(chargeLog);
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
//			String doubleMsg = ""; 
			if(chargeParams.getOrderIdFrom() != null){
				PurchasePo purPo = purchaseDAO.hasDoublePurchase(null, chargeParams.getOrderIdFrom());//下游传重复订单号过来
				boolean hasD = purPo != null;
				if(hasD && purPo.getChargeTel().equals(chargeParams.getNumber())){
					chargeEnum = ChargeStatusEnum.HAS_DOUBLE_PURCHAE;
					charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
//					ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), charge.toString(), null, chargeParams.getNumber(), charge.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":下游循环传一样的订单");
//					chargeLogDao.add(chargeLog);
					sqlMap.put("exceptionDTO", charge);
					return sqlMap;
				}
			}
			Long highTime = System.currentTimeMillis() - 1000*60;//一分钟之前的时间
			PurchasePo latestPurchasePo = purchaseDAO.getLatestOneByTel(chargeParams.getNumber(), PgServiceTypeEnum.PGCHARGE.getValue(), highTime);
			if(latestPurchasePo != null){
				chargeEnum = ChargeStatusEnum.HAS_DOUBLE_PURCHAE;
				charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
//				ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), charge.toString(), null, chargeParams.getNumber(), charge.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":一分钟内多次传的可疑订单");
//				chargeLogDao.add(chargeLog);
				sqlMap.put("exceptionDTO", charge);
				return sqlMap;
			}
			ChargeAccountPo accountPo =  chargeAccountAO.getAccountByAgencyId(backPo.getId(), billType);
			if(accountPo == null){
				chargeEnum = ChargeStatusEnum.INVALID_BILL_TYPE;
				charge = new Charge(chargeEnum.getValue(),backPo.getUserName() +":没有开通该账户", null);
				sqlMap.put("exceptionDTO", charge);
				return sqlMap;
			}else{
				sqlMap.put("accountPo", accountPo);
				String chargeTelDetail = resMap.get("chargeTelDetail").toString();
				//折扣是忽略包体大小的
				RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(new ChargeChannelParamsPo(chargeTelDetail, chargeParams.getScope(), chargeParams.getPgType(), chargeParams.getPgValidity(), chargeParams.getChannelType(),chargeParams.getFlowsize()), accountPo.getId(),false);
				if(ratePo == null){
					chargeEnum = ChargeStatusEnum.SCOPE_RATE_UNDEFINED;
					charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
					sqlMap.put("exceptionDTO", charge);
//					ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), charge.toString(), null, chargeParams.getNumber(), charge.getTipCode(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+":产品未配置");
//					chargeLogDao.add(chargeLog);
					return sqlMap;
				}else{
//					boolean canChargeTel = valiUser.checkChargeTel(chargeParams.getNumber(), accountPo.getId());
//					if(!canChargeTel){
//						
//					}
					ChannelChannelPo channelPo = channelChannelDao.get(new WherePrams("id", "=", ratePo.getChannelId()));
//					boolean isChannelUseStateStoped = channelPo.getChannelUseState() == ChannelUseStateEnum.CLOSE.getValue();//通道状态停止
//					if(isChannelUseStateStoped){//通道使用状态暂停，不能提单
//						chargeEnum = ChargeStatusEnum.CHANNEL_CLOSED;
//						charge = new Charge(chargeEnum.getValue(),chargeEnum.getDesc(), null);
//						sqlMap.put("exceptionDTO", charge);
//						return sqlMap;
//					}else{
						sqlMap.put("ratePo", ratePo);
						sqlMap.put("channelPo", channelPo);
//					}
				}
			}
		}
		return sqlMap;
	}

}
