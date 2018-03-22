package com.weizu.flowsys.web.trade.ao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.api.hsingleton.HSingletonFactory;
import com.weizu.flowsys.api.hsingleton.TelBaseInterface;
import com.weizu.flowsys.api.hsingleton.TelBaseP;
import com.weizu.flowsys.api.hsingleton.TelOrderIn;
import com.weizu.flowsys.api.hsingleton.TelOrderStateDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.OrderIn;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.api.singleton.orderState.ResponseJsonDTO;
import com.weizu.flowsys.api.singleton.orderState.SendCallBackUtil;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.AgencyForwardEnum;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.EpEncodeTypeEnum;
import com.weizu.flowsys.operatorPg.enums.EventTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.LoginStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgSizeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.ao.TelRateAO;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.dao.ChargeRecordDaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.dao.ITelProductDao;
import com.weizu.flowsys.web.channel.dao.OperatorPgDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.channel.pojo.TelChannelPo;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.flowsys.web.http.ParamsEntityWeiZu;
import com.weizu.flowsys.web.http.ao.ValiUser;
import com.weizu.flowsys.web.http.weizu.OrderStateResult;
import com.weizu.flowsys.web.log.AccountEventPo;
import com.weizu.flowsys.web.log.dao.IAccountEventDao;
import com.weizu.flowsys.web.system_base.ao.SystemConfAO;
import com.weizu.flowsys.web.system_base.pojo.SystemConfPo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.AccountPurchaseDao;
import com.weizu.flowsys.web.trade.dao.ChargeLogDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.pojo.TelChargeVO;
import com.weizu.flowsys.web.trade.pojo.TotalResult;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.hash.Hash;
import com.weizu.web.foundation.http.HttpRequest;

@Service(value="purchaseAO")
public class PurchaseAOImpl implements PurchaseAO {
	//话费通道
	@Resource
	private ITelChannelDao telChannelDao;
	@Resource
	private TelRateAO telRateAO;
	@Resource
	private ITelRateDao telRateDao;
	@Resource
	private ITelProductDao telProductDao;

	@Resource
	private PurchaseDao purchaseDAO;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeRecordDaoInterface chargeRecordDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private ChannelChannelDao channelChannelDao; 
	
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;
	@Resource
	private OperatorPgDaoInterface operatorPgDao;
	@Resource
	private ProductCodeAO productCodeAO;
	@Resource
	private RateDiscountAO rateDiscountAO;
	@Resource
	private RateDiscountDao rateDiscountDao; 
	@Resource
	private AgencyAO agencyAO;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
	@Resource
	private AccountPurchaseDao accountPurchaseDao;
	@Resource
	private AccountPurchaseAO accountPurchaseAO;
	@Resource
	private SendCallBackUtil sendCallBack;
	@Resource
	private ChargeLogDao chargeLogDao;
	@Resource
	private SystemConfAO systemConfAO;
	@Resource
	private ValiUser valiUser;
	@Resource
	private IAccountEventDao accountEventDao;
	
	private Logger logger = Logger.getLogger("PurchaseAOImpl");
	
	@Override
	public String purchase(TelChargeVO tcVO, ChargeAccountPo chargeAccountPo) {
		/****************完成对所有上级代理商包括自己的订单与代理商的绑定********************/
		boolean isNotSupperAgency = agencyVODao.getRootAgencyById(chargeAccountPo.getAgencyId()) != null ;//不是超管
		//在二级代理商的情况下才去判断余额
		boolean ifLackBalance = isNotSupperAgency && tcVO.getOrderAmount() > chargeAccountPo.getAccountBalance();
		if(ifLackBalance){//订单价格大于余额
			return "余额不足，下单失败";
		}
		//已经当前登陆用户余额充足，开始充值流程
		//在订单信息完全添加完之后，再调用接口进行充值
		//先添加一个基本的，再批量添加父级代理商和订单的绑定
		PurchasePo purchasePo = new PurchasePo(tcVO.getChargeTel(), tcVO.getTelProductId().toString(), tcVO.getChargeTelDetail());
		purchasePo.setPurchaseFor(tcVO.getChargeFor());
		PurchasePo latestPurchasePo = purchaseDAO.getLatestOneByTel(tcVO.getChargeTel(), tcVO.getChargeFor());
		if(latestPurchasePo != null){
			int minutes = (int) ((System.currentTimeMillis() - latestPurchasePo.getOrderArriveTime()) / (1000*60));
			if(minutes <= 5){
				return "出现重复订单";
			}
		}
		int accountId = tcVO.getAccountId();		//订单产生方代理商
		Integer orderResult = null;		//默认订单状态
		String orderResultDetail = null;		//默认订单状态
		int purResult = 0;
		/**充值前余额*/
		double agencyBeforeBalance = 0d;
		/**充值额（）*/
		Double orderAmount = null;
		
		double agencyAfterBalance = 0d;
		/**话费原价*/
		Double chargeValue = tcVO.getChargeValue();
		TelChannelPo telchannel = telChannelDao.get(tcVO.getTelchannelId());
		ExchangePlatformPo epPo = null;
		TelProductPo dataPo = telProductDao.get(tcVO.getTelProductId());
		purchasePo.setEpId(dataPo.getEpId());
//		if(dataPo == null){
//			logger.config("编码未配置");
//			System.out.println("编码未配置");
//			return "产品待更新，产品暂不支持购买！！";
//		}else 
		if (telchannel == null){
			logger.config("通道不存在");
			System.out.println("通道不存在");
			return "产品待更新，产品暂不支持购买！！";
		}else if(dataPo != null && telchannel != null){
			epPo = exchangePlatformAO.getEpById(dataPo.getEpId());
			boolean isChannelUseStateStoped = telchannel.getTelchannelUseState() == ChannelUseStateEnum.CLOSE.getValue();//通道状态停止
			if(isChannelUseStateStoped){//通道使用状态暂停，不能提单
				logger.config("通道使用状态暂停");
				System.out.println("通道使用状态暂停");
				return "产品待更新，产品暂不支持购买！！";
			}else{
//				String scopeCityCode = ScopeCityEnum.QG.getValue();
//				if(!pcVO.getServiceType().equals(ServiceTypeEnum.NATION_WIDE.getValue())){
//					Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(purchasePo.getChargeTelDetail());
//					scopeCityCode = scopeMap.get("scopeCityCode").toString();
//				}
				
			}
		}
		
		Long orderId = null;
		Long currentTime = System.currentTimeMillis();
		ChargeDTO chargeDTO = null;
		try {
			OrderUril ou1 = new OrderUril(1);
			orderId = ou1.nextId();
			purchasePo.setOrderId(orderId);//设置订单号
		} catch (Exception e) {
			e.printStackTrace();
			return "订单号生成异常";
		}
		purchasePo.setChargeValue(chargeValue);
		purchasePo.setOrderAmount(tcVO.getOrderAmount());
		purchasePo.setAccountId(accountId);
		purchasePo.setOrderArriveTime(currentTime);
//		Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
//		String chargeTelCity = null;
//		if(telMap != null)
//		{
//			chargeTelCity = telMap.get("chargeTelCity").toString();
//		}else{
//			return "调用接口异常";
//		}
		String chargeTelDetail = tcVO.getChargeTelDetail();
		chargeTelDetail = chargeTelDetail.substring(0, chargeTelDetail.length()-2);//去掉运营商,得到归属地
		String desct = chargeTelDetail.substring(chargeTelDetail.length()-2);
//		String operatorNameDesc = OperatorNameEnum.getDescBy(desct);			//运营商名称
		purchasePo.setChargeTelCity(chargeTelDetail);
		Boolean isChannelStateCanceled = telchannel.getTelchannelState() == ChannelStateEnum.CLOSE.getValue();
		if(isChannelStateCanceled){
			orderResult = OrderStateEnum.DAICHONG.getValue();
			orderResultDetail = "通道暂停等待";
		}else{//通道没有暂停
			chargeDTO = chargeByBI(epPo, purchasePo, dataPo);
			if(chargeDTO != null){
				if(chargeDTO.getTipCode().equals(OrderResultEnum.SUCCESS.getCode()) ){
					orderResult = OrderStateEnum.CHARGING.getValue();
					orderResultDetail = OrderStateEnum.CHARGING.getDesc();
					ChargeOrder co = chargeDTO.getChargeOrder();
					if(co != null){
						purchasePo.setOrderIdApi(co.getOrderIdApi());
					}
				}else{
					orderResult = OrderStateEnum.DAICHONG.getValue();
					orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+chargeDTO.getTipMsg();
				}
			}else{
				orderResult = OrderStateEnum.DAICHONG.getValue();
				orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+"平台直接返失败";
			}
		}
		purchasePo.setOrderResult(orderResult);
		purchasePo.setOrderResultDetail(orderResultDetail);
		//话费通道名称组成规则：索朗 市内 话费
		String telChannelName = epPo.getEpName() + ServiceTypeEnum.getEnum(tcVO.getServiceType()).getDesc() + PgServiceTypeEnum.TELCHARGE.getDesc();
		purchasePo.setChannelName(telChannelName);
		if(tcVO.getTelRateId() == null && tcVO.getTelchannelId() != null){//通过通道折扣充值
			String fromAgencyName = tcVO.getFromAgencyName();
//			ChannelDiscountPo cdisPo = null;
//			
//			cdisPo = channelDiscountDao.get(tcVO.getCdisId());
			/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
			int orderPath = OrderPathEnum.WEB_PAGE.getValue();
			//一般不会出现
			if(telchannel.getTelchannelState() == ChannelStateEnum.CLOSE.getValue()){//通道暂停，把系统级用户的订单状态设置为充值失败
				purchasePo.setOrderResult(OrderStateEnum.UNCHARGE.getValue());
				purchasePo.setOrderResultDetail(OrderStateEnum.UNCHARGE.getDesc());
				purResult = purchaseDAO.addPurchase(purchasePo);
				return "充值失败，通道暂停";
			}else{
				
				if(chargeDTO == null ){//充值返充值进行
					//通道折扣充值，不去添加订单
					return "订单提交失败";
				}else{
					agencyBeforeBalance = chargeAccountPo.getAccountBalance();
					orderAmount = NumberTool.mul(chargeValue, telchannel.getTelchannelDiscount());//成本
					agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
//					chargeAccountPo.setAccountBalance(agencyAfterBalance);
					double editBalance = NumberTool.mul(orderAmount, -1);
					chargeAccountAO.updateAccount(chargeAccountPo.getId(), editBalance);
					int addRec = chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
							agencyBeforeBalance, agencyAfterBalance, 
							AccountTypeEnum.DECREASE.getValue(), accountId, tcVO.getChargeFor() , orderId));
//					purchasePo.setOrderResult(OrderStateEnum.CHARGING.getValue());
//					purchasePo.setOrderResultDetail(OrderStateEnum.CHARGING.getDesc());
					purResult = purchaseDAO.addPurchase(purchasePo);
					if(addRec > 0){
						Long recordId = chargeRecordDao.nextId() -1;
//						orderResult = OrderStateEnum.CHARGING.getValue();
						AccountPurchasePo app = new AccountPurchasePo(accountId, orderId,tcVO.getTelchannelId(), orderAmount,tcVO.getAccountId(), recordId, orderAmount, fromAgencyName, orderPath, orderResult);
						app.setOrderStateDetail(orderResultDetail);
						app.setApDiscount(telchannel.getTelchannelDiscount());
						int aarAdd = accountPurchaseDao.add(app);
						if(aarAdd > 0){
							return "success";
						}
					}
				}
			}
		}else{//页面通过费率折扣充值
			//先把订单加上
			int orderState = OrderStateEnum.CHARGING.getValue();
			String orderStateDetail = OrderStateEnum.CHARGING.getDesc();
			purResult = purchaseDAO.addPurchase(purchasePo);
			TelRatePo telRatePo = telRateDao.get(tcVO.getTelRateId());
			if(telRatePo != null){
//			RateDiscountPo ratePo = rateDiscountDao.get(tcVO.getRateId());
//			if(ratePo != null){
				int billType = telRatePo.getBillType();//票务全部使用费率配置的票务
				//更新消费记录表（先更新账户余额，再更新订单，最后更新记录）
				/**账户信息的更新结果*/
				int recordRes = 0;
				/**充值前余额*/
				agencyBeforeBalance = chargeAccountPo.getAccountBalance();
				/**充值额（）*/
				orderAmount = tcVO.getOrderAmount();
				chargeAccountPo.addBalance(orderAmount,-1);
				/** 更新登录用户账户信息**/
				double editBalance = NumberTool.mul(orderAmount, -1);
				recordRes = chargeAccountAO.updateAccount(chargeAccountPo.getId(), editBalance);
				if(recordRes > 0){
					Long telChannelId = telRatePo.getTelchannelId();			//折扣id
					if(recordRes > 0){//开始把第一个消费记录，连接加上，
						/** 向消费记录表插入登陆用户数据 */
						chargeRecordDao.add(new ChargeRecordPo(currentTime, orderAmount,
								agencyBeforeBalance, chargeAccountPo.getAccountBalance(), 
								AccountTypeEnum.DECREASE.getValue(), chargeAccountPo.getId(),  tcVO.getChargeFor() , orderId));
						/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
						int orderPath = OrderPathEnum.WEB_PAGE.getValue();
						Long recordId = chargeRecordDao.nextId() -1;
						AccountPurchasePo app = new AccountPurchasePo(accountId, orderId, telChannelId, orderAmount, tcVO.getAccountId(), recordId, orderAmount, tcVO.getFromAgencyName(), orderPath, orderState);
						app.setOrderStateDetail(orderStateDetail);
						app.setApDiscount(telRatePo.getActiveDiscount());
						int aapAddRes = accountPurchaseDao.add(app);
					}
				}else{
					logger.config("更新账户表失败");
				}
				// 开始迭代添加父级代理商的账户扣款和消费记录，以及批量添加父级代理商和订单的绑定
//				if(purResult > 0){//订单添加好了,开始迭代添加父级代理商的账户扣款和消费记录
				List<AccountPurchasePo> apPoList = new LinkedList<AccountPurchasePo>();
				List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
				
				TelRatePo activeRatePo = null;		//父级费率对象
				TelRatePo ratePo1 = telRatePo;		//子级费率对象
				ChargeAccountPo ap_accountPo = chargeAccountPo.clone();
				ChargeAccountPo from_accountPo = ap_accountPo;	//起始账户
				
				int contextAccountId = chargeAccountPo.getId();
				int apAccountId = contextAccountId;
				
				//得到当前代理商和折扣的绑定实体，
				//然后根据父级得到父级折扣
				Double balance = 0d;//差额:父费率减去子费率乘以价格
				long recordId = chargeRecordDao.nextId();//没添加的消费记录Id
				while(ratePo1.getActiveId() != null){//没有找到第二级代理商，开始添加代理商和订单
					//重置ratePo为父级费率折扣;不为空
					//查询父级操作对象
					activeRatePo = telRateDao.get(ratePo1.getActiveId());		
					String fromAgencyName = from_accountPo.getAgencyName();
					int apBillType = activeRatePo.getBillType();
					ap_accountPo  = chargeAccountDao.getRootAccountById(contextAccountId, apBillType) ;//重置为父级代理商的账户（无论是对公和对私都是有的）
					apAccountId = ap_accountPo.getId();
					
					/**业务判断和添加**/
					/**充值额（）*/
					/**充值前余额*/
					agencyBeforeBalance = ap_accountPo.getAccountBalance();
					/**父费率减去子费率乘以价格，就是差价*/
					balance = NumberTool.mul(NumberTool.sub(ratePo1.getActiveDiscount(), activeRatePo.getActiveDiscount()), chargeValue);
//					ap_accountPo.addBalance(balance,1);
					/** 更新父级代理商账户信息**/
					
					recordRes = chargeAccountAO.updateAccount(ap_accountPo.getId(), balance);
					if(recordRes > 0){
						/** 向消费记录表插入登陆用户数据 */
						Double plusAmount = NumberTool.mul(ratePo1.getActiveDiscount(),chargeValue);
						Double minusAmount = NumberTool.mul(activeRatePo.getActiveDiscount(),chargeValue);
						agencyBeforeBalance = NumberTool.add(plusAmount, agencyBeforeBalance);	//重置充值前的余额为补款后的余额
						agencyAfterBalance = NumberTool.sub(agencyBeforeBalance,minusAmount);
						recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), minusAmount,
								agencyBeforeBalance, agencyAfterBalance, 
								AccountTypeEnum.DECREASE.getValue(), apAccountId, tcVO.getChargeFor(), orderId));	
						int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
						AccountPurchasePo app = new AccountPurchasePo(apAccountId, orderId, activeRatePo.getTelchannelId(), minusAmount,from_accountPo.getId(), recordId, plusAmount, fromAgencyName, orderPath, orderState);
						recordId++;
						app.setOrderStateDetail(orderStateDetail);
						app.setApDiscount(activeRatePo.getActiveDiscount());
						apPoList.add(app);
					}
					//由父变成子，进行迭代
					ratePo1 = activeRatePo;	
//							contextAgencyId = ap_agency_id;
					accountId = apAccountId;
					from_accountPo = ap_accountPo;
				}
				//把超级管理员的记录加上
//						if(rootAgencyPo == null){
//							rootAgencyPo = agencyVODao.getRootAgencyById(contextAgencyId);
//							ap_agency_id = rootAgencyPo.getId();
//						}else{
//							ap_agency_id = rootAgencyPo.getRootAgencyId();
//						}
				String fromAgencyName = from_accountPo.getAgencyName();
//				ChannelDiscountPo cdisPo = channelDiscountDao.get(ratePo1.getChannelDiscountId());
				billType = telchannel.getBillType();
				
				ChargeAccountPo superAccountPo = chargeAccountDao.getRootAccountById(from_accountPo.getId(), billType);
				
				agencyBeforeBalance = superAccountPo.getAccountBalance();
				Double orderPrice = NumberTool.mul(chargeValue, ratePo1.getActiveDiscount());//价格
				orderAmount = NumberTool.mul(chargeValue, telchannel.getTelchannelDiscount());//成本
				agencyBeforeBalance = NumberTool.add(agencyBeforeBalance, orderPrice);//之前加上价格
//				agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
//				superAccountPo.setAccountBalance(agencyAfterBalance);
				double editSuperBalance =  NumberTool.mul(orderAmount, -1);
				chargeAccountAO.updateAccount(superAccountPo.getId(), editSuperBalance);
				recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
						agencyBeforeBalance, agencyAfterBalance, 
						AccountTypeEnum.DECREASE.getValue(), superAccountPo.getId(),  tcVO.getChargeFor() , orderId));
				/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
				int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
				//ChannelDiscountPo cdPo = channelDiscountDao.get(ratePo.getChannelDiscountId());
				AccountPurchasePo app = new AccountPurchasePo(superAccountPo.getId(), orderId, telchannel.getId(), orderAmount,from_accountPo.getId(),recordId, orderPrice, fromAgencyName, orderPath, orderState);
				app.setOrderStateDetail(orderStateDetail);
				app.setApDiscount(telchannel.getTelchannelDiscount());
				apPoList.add(app);
				
				int batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加扣款记录信息
				int batchAddApp = accountPurchaseDao.ap_addList(apPoList);		//批量添加连接信息
				if(batchAddApp + batchAddCrt > 1){
					return "success";
				}
//					if(batchAddApp > 0 && batchAddCrt > 0 && !isChannelStateCanceled){//开始走接口
//						return chargeByBI(epPo, orderId, pcVO.getChargeTel(),pcVO.getServiceType(), dataPo.getProductCode());
//							//判断是否正常提单,
//							
//							//充值之后更新订单的orderIdApi
//					}
//				}else{//第一批代理商和订单没有添加成功
//					return "订单添加失败！";
//				}
			}//费率存在
		}
		return "添加失败";
	}
	
	/**
	 * @description: 页面上充值
	 * @param purchasePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月12日 下午5:35:16
	 */
	@Transactional
	@Override
	public String purchase(PgChargeVO pcVO, ChargeAccountPo chargeAccountPo) {
		/****************完成对所有上级代理商包括自己的订单与代理商的绑定********************/
		boolean isNotSupperAgency = agencyVODao.getRootAgencyById(chargeAccountPo.getAgencyId()) != null ;//不是超管
		//在二级代理商的情况下才去判断余额
		boolean ifLackBalance = isNotSupperAgency && pcVO.getOrderAmount() > chargeAccountPo.getAccountBalance();
		if(ifLackBalance){//订单价格大于余额
			return "余额不足，下单失败";
		}
		PurchasePo latestPurchasePo = purchaseDAO.getLatestOneByTel(pcVO.getChargeTel(), pcVO.getChargeFor());
		if(latestPurchasePo != null){
			int minutes = (int) ((System.currentTimeMillis() - latestPurchasePo.getOrderArriveTime()) / (1000*60));
			if(minutes < 5){
				return "出现重复订单";
			}
		}
		
		//已经当前登陆用户余额充足，开始充值流程
		//在订单信息完全添加完之后，再调用接口进行充值
		//先添加一个基本的，再批量添加父级代理商和订单的绑定
//		PurchasePo purchasePo = initPurchase(pcVO);
		PurchasePo purchasePo = new PurchasePo(pcVO.getChargeTel(), pcVO.getPgId().toString(), pcVO.getChargeTelDetail());
		purchasePo.setPurchaseFor(pcVO.getChargeFor());
		int accountId = pcVO.getAccountId();		//订单产生方代理商
		Integer orderResult = null;		//默认订单状态
		String orderResultDetail = null;		//默认订单状态
		int purResult = 0;
		/**充值前余额*/
		double agencyBeforeBalance = 0d;
		/**充值额（）*/
		Double orderAmount = null;
		
		double agencyAfterBalance = 0d;
		
		/**包体原价*/
		Double chargeValue = pcVO.getChargeValue();
		ChannelChannelPo channel = channelChannelDao.get(new WherePrams("id", "=", pcVO.getChannelId()));
		ExchangePlatformPo epPo = null;
		ProductCodePo dataPo = null;
		if(channel != null){
			epPo = exchangePlatformAO.getEpById(channel.getEpId());
				if(EpEncodeTypeEnum.WITH_CODE.getValue().equals(epPo.getEpEncodeType())){
					String scopeCityCode = ScopeCityEnum.QG.getValue();
					if(!pcVO.getServiceType().equals(ServiceTypeEnum.NATION_WIDE.getValue())){
						Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(purchasePo.getChargeTelDetail());
						if(scopeMap != null){
							scopeCityCode = scopeMap.get("scopeCityCode").toString();
						}else{
							System.out.println("获得地区编码失败");
						}
					}
//					String scopeCityCode = StringHelper.isNotEmpty(chargeTelDetail)?PurchaseUtil.getScopeCityByCarrier(chargeTelDetail).get("scopeCityCode").toString():null;
					dataPo = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), Integer.parseInt(purchasePo.getPgId())));
				}else{
					dataPo = productCodeAO.getOneProductCodeByPg(Integer.parseInt(purchasePo.getPgId()));
				}
				if(dataPo == null){
					logger.config("编码未配置");
					System.out.println("编码未配置");
					return "产品待更新，产品暂不支持购买！！";
				}
		}else{
			logger.config("通道不存在");
			System.out.println("通道不存在");
			return "产品待更新，产品暂不支持购买！！";
		}
		Long orderId = null;
		Long currentTime = System.currentTimeMillis();
		try {
			OrderUril ou1 = new OrderUril(1);
			orderId = ou1.nextId();
			purchasePo.setOrderId(orderId);//设置订单号
		} catch (Exception e) {
			e.printStackTrace();
			return "订单添加异常";
		}
		purchasePo.setChargeValue(chargeValue);
		purchasePo.setOrderAmount(pcVO.getOrderAmount());
		purchasePo.setAccountId(accountId);
		purchasePo.setOrderArriveTime(currentTime);
		
		Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
		String chargeTelCity = null;
		if(telMap != null)
		{
			chargeTelCity = telMap.get("chargeTelCity").toString();
		}else{
			logger.config("调用接口异常，设置城市异常");
			return "调用接口异常，设置城市异常";
		}
		purchasePo.setChargeTelCity(chargeTelCity);
		Boolean isChannelStateCanceled = channel.getChannelState() == ChannelStateEnum.OPEN.getValue();
		ChargeDTO chargeDTO = null;
		if(!isChannelStateCanceled){
			orderResult = OrderStateEnum.DAICHONG.getValue();
			orderResultDetail = "通道暂停等待";
		}else{//通道没有暂停
			chargeDTO = chargeByBI(epPo, purchasePo,dataPo);
			if(chargeDTO != null){
				if(chargeDTO.getTipCode().equals(OrderResultEnum.SUCCESS.getCode()) ){
					orderResult = OrderStateEnum.CHARGING.getValue();
					orderResultDetail = OrderStateEnum.CHARGING.getDesc();
					ChargeOrder co = chargeDTO.getChargeOrder();
					if(co != null){
						purchasePo.setOrderIdApi(co.getOrderIdApi());
					}
				}else{
					orderResult = OrderStateEnum.DAICHONG.getValue();
					orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+chargeDTO.getTipMsg();
				}
			}else{
				orderResult = OrderStateEnum.DAICHONG.getValue();
				orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+"平台直接返失败";
			}
		}
		purchasePo.setOrderResult(orderResult);
		purchasePo.setOrderResultDetail(orderResultDetail);
		purchasePo.setChannelName(channel.getChannelName());
		
		if(pcVO.getRateId() == null && pcVO.getCdisId() != null){//通过通道折扣充值
			String fromAgencyName = pcVO.getFromAgencyName();
			ChannelDiscountPo cdisPo = null;
			cdisPo = channelDiscountDao.get(pcVO.getCdisId());
			/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
			int orderPath = OrderPathEnum.WEB_PAGE.getValue();
			//一般不会出现
			if(channel.getChannelState() == ChannelStateEnum.CLOSE.getValue()){//通道暂停，把系统级用户的订单状态设置为充值失败
				purchasePo.setOrderResult(OrderStateEnum.UNCHARGE.getValue());
				purchasePo.setOrderResultDetail(OrderStateEnum.UNCHARGE.getDesc());
				purResult = purchaseDAO.addPurchase(purchasePo);
				return "充值失败，通道暂停";
			}else{
				if(chargeDTO == null ){//充值返充值进行
					//通道折扣充值，不去添加订单
					return "订单提交失败";
				}else{
					agencyBeforeBalance = chargeAccountPo.getAccountBalance();
					orderAmount = NumberTool.mul(chargeValue, cdisPo.getChannelDiscount());//成本
					agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
//					chargeAccountPo.setAccountBalance(agencyAfterBalance);
					
					double editSuperBalance =  NumberTool.mul(orderAmount, -1);
					chargeAccountAO.updateAccount(chargeAccountPo.getId(), editSuperBalance);
//					chargeAccountAO.updateAccount(chargeAccountPo);
					int addRec = chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
							agencyBeforeBalance, agencyAfterBalance, 
							AccountTypeEnum.DECREASE.getValue(), accountId, pcVO.getChargeFor() , orderId));
//					purchasePo.setOrderResult(OrderStateEnum.CHARGING.getValue());
//					purchasePo.setOrderResultDetail(OrderStateEnum.CHARGING.getDesc());
					purResult = purchaseDAO.addPurchase(purchasePo);
					if(addRec > 0){
						Long recordId = chargeRecordDao.nextId() -1;
						AccountPurchasePo app = new AccountPurchasePo(accountId, orderId,pcVO.getCdisId(), orderAmount,pcVO.getAccountId(), recordId, orderAmount, fromAgencyName, orderPath, orderResult);
						app.setOrderStateDetail(orderResultDetail);
						app.setApDiscount(cdisPo.getChannelDiscount());
						int aarAdd = accountPurchaseDao.add(app);
						if(aarAdd > 0){
							return "success";
						}
					}
				}
			}
		}else{//页面通过费率折扣充值
			//先把订单加上
			int orderState = OrderStateEnum.CHARGING.getValue();
			String orderStateDetail = OrderStateEnum.CHARGING.getDesc();
			purResult = purchaseDAO.addPurchase(purchasePo);
			RateDiscountPo ratePo = rateDiscountDao.get(pcVO.getRateId());
			if(ratePo != null){
				int billType = ratePo.getBillType();//票务全部使用费率配置的票务
				//更新消费记录表（先更新账户余额，再更新订单，最后更新记录）
				/**账户信息的更新结果*/
				int recordRes = 0;
				/**充值前余额*/
				agencyBeforeBalance = chargeAccountPo.getAccountBalance();
				/**充值额（）*/
				orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), chargeValue);
				chargeAccountPo.addBalance(orderAmount,-1);
				/** 更新登录用户账户信息**/
//				recordRes = chargeAccountAO.updateAccount(chargeAccountPo);
				
				double editSuperBalance =  NumberTool.mul(orderAmount, -1);
				recordRes = chargeAccountAO.updateAccount(chargeAccountPo.getId(), editSuperBalance);
				if(recordRes > 0){
					Long channelDiscountId = ratePo.getChannelDiscountId();			//折扣id
					if(recordRes > 0){//开始把第一个消费记录，连接加上，
						/** 向消费记录表插入登陆用户数据 */
						chargeRecordDao.add(new ChargeRecordPo(currentTime, orderAmount,
								agencyBeforeBalance, chargeAccountPo.getAccountBalance(), 
								AccountTypeEnum.DECREASE.getValue(), chargeAccountPo.getId(),  pcVO.getChargeFor() , orderId));
						/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
						int orderPath = OrderPathEnum.WEB_PAGE.getValue();
						Long recordId = chargeRecordDao.nextId() -1;
						AccountPurchasePo app = new AccountPurchasePo(accountId, orderId, channelDiscountId, orderAmount, pcVO.getAccountId(), recordId, orderAmount, pcVO.getFromAgencyName(), orderPath, orderState);
						app.setOrderStateDetail(orderStateDetail);
						app.setApDiscount(ratePo.getActiveDiscount());
						int aapAddRes = accountPurchaseDao.add(app);
					}
				}else{
					logger.config("更新账户表失败");
				}
				// 开始迭代添加父级代理商的账户扣款和消费记录，以及批量添加父级代理商和订单的绑定
//				if(purResult > 0){//订单添加好了,开始迭代添加父级代理商的账户扣款和消费记录
				List<AccountPurchasePo> apPoList = new LinkedList<AccountPurchasePo>();
				List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
				
				RateDiscountPo activeRatePo = null;		//父级费率对象
				RateDiscountPo ratePo1 = ratePo;		//子级费率对象
				ChargeAccountPo ap_accountPo = chargeAccountPo.clone();
				ChargeAccountPo from_accountPo = ap_accountPo;	//起始账户
				
				int contextAccountId = chargeAccountPo.getId();
				int apAccountId = contextAccountId;
				
				//得到当前代理商和折扣的绑定实体，
				//然后根据父级得到父级折扣
				Double balance = 0d;//差额:父费率减去子费率乘以价格
				long recordId = chargeRecordDao.nextId();//没添加的消费记录Id
				while(ratePo1.getActiveId() != null){//没有找到第二级代理商，开始添加代理商和订单
					//重置ratePo为父级费率折扣;不为空
					//查询父级操作对象
					activeRatePo = rateDiscountDao.get(ratePo1.getActiveId());		
					String fromAgencyName = from_accountPo.getAgencyName();
					int apBillType = activeRatePo.getBillType();
					ap_accountPo  = chargeAccountDao.getRootAccountById(from_accountPo.getId(), apBillType) ;//重置为父级代理商的账户（无论是对公和对私都是有的）
					apAccountId = ap_accountPo.getId();
					
					/**业务判断和添加**/
					/**充值额（）*/
					/**充值前余额*/
					agencyBeforeBalance = ap_accountPo.getAccountBalance();
					/**父费率减去子费率乘以价格，就是差价*/
					balance = NumberTool.mul(NumberTool.sub(ratePo1.getActiveDiscount(), activeRatePo.getActiveDiscount()), chargeValue);
//					ap_accountPo.addBalance(balance,1);
					/** 更新父级代理商账户信息**/
					recordRes = chargeAccountAO.updateAccount(apAccountId, balance);
					
					//添加最新登陆日志
//					accountEventDao.add(new AccountEventPo(ap_accountPo.getAgencyId(), EventTypeEnum.CHILDREN_PURCHASE_REBACK.getValue(), System.currentTimeMillis(), address, eventIp, LoginStateEnum.ING.getValue()+""));
					
//					recordRes = chargeAccountAO.updateAccount(ap_accountPo);
					if(recordRes > 0){
						/** 向消费记录表插入登陆用户数据 */
						Double plusAmount = NumberTool.mul(ratePo1.getActiveDiscount(),chargeValue);//价格
						Double minusAmount = NumberTool.mul(activeRatePo.getActiveDiscount(),chargeValue);//成本
//						agencyBeforeBalance = NumberTool.add(plusAmount, agencyBeforeBalance);	//重置充值前的余额为补款后的余额
//						agencyAfterBalance = NumberTool.sub(agencyBeforeBalance,minusAmount);
						ChargeAccountPo accountAfterPo = chargeAccountAO.getAccountById(apAccountId);
						recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), balance,
								agencyBeforeBalance, accountAfterPo.getAccountBalance(), 
								AccountTypeEnum.DECREASE.getValue(), apAccountId, pcVO.getChargeFor(), orderId));	
						int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
						AccountPurchasePo app = new AccountPurchasePo(apAccountId, orderId, activeRatePo.getChannelDiscountId(), minusAmount,from_accountPo.getId(), recordId, plusAmount, fromAgencyName, orderPath, orderState);
						recordId++;
						app.setOrderStateDetail(orderStateDetail);
						app.setApDiscount(activeRatePo.getActiveDiscount());
						apPoList.add(app);
					}
					//由父变成子，进行迭代
					ratePo1 = activeRatePo;	
//							contextAgencyId = ap_agency_id;
					accountId = apAccountId;
					from_accountPo = ap_accountPo;
				}
				String fromAgencyName = from_accountPo.getAgencyName();
				ChannelDiscountPo cdisPo = channelDiscountDao.get(ratePo1.getChannelDiscountId());
				billType = cdisPo.getBillType();
				
				ChargeAccountPo superAccountPo = chargeAccountDao.getRootAccountById(from_accountPo.getId(), billType);
				
				agencyBeforeBalance = superAccountPo.getAccountBalance();
				Double orderPrice = NumberTool.mul(chargeValue, ratePo1.getActiveDiscount());//价格
				orderAmount = NumberTool.mul(chargeValue, cdisPo.getChannelDiscount());//成本
				agencyBeforeBalance = NumberTool.add(agencyBeforeBalance, orderPrice);//之前加上价格
				agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
//				superAccountPo.setAccountBalance(agencyAfterBalance);
				double editBalance =  NumberTool.mul(orderAmount, -1);
				
				chargeAccountAO.updateAccount(superAccountPo.getId(), editBalance);
//				chargeAccountAO.updateAccount(superAccountPo);
				recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
						agencyBeforeBalance, agencyAfterBalance, 
						AccountTypeEnum.DECREASE.getValue(), superAccountPo.getId(),  pcVO.getChargeFor() , orderId));
				/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
				int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
				AccountPurchasePo app = new AccountPurchasePo(superAccountPo.getId(), orderId, cdisPo.getId(), orderAmount,from_accountPo.getId(),recordId, orderPrice, fromAgencyName, orderPath, orderState);
				app.setOrderStateDetail(orderStateDetail);
				app.setApDiscount(cdisPo.getChannelDiscount());
				apPoList.add(app);
				
				int batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加扣款记录信息
				int batchAddApp = accountPurchaseDao.ap_addList(apPoList);		//批量添加连接信息
				if(batchAddApp + batchAddCrt > 1){
					return "success";
				}
			}//费率存在
			else{
				System.out.println("费率不存在");
			}
		}
		return "添加失败";
	}
	
	@Transactional
	@Override
	public String ajaxCommitOrder(Long orderId,Integer accountId,String chargeTelDetail) {
		String res = "error";
		PgDataPo pgDataPo =  operatorPgDao.getPgByOrderId(orderId);
		/**todo*///超管的单子是不会有充值等待的；只有下级代理商的单子才有充值等待
		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(new ChargeChannelParamsPo(chargeTelDetail, pgDataPo.getServiceType(), pgDataPo.getPgType(), pgDataPo.getPgValidity(), pgDataPo.getCirculateWay(),pgDataPo.getPgSize()) , accountId,true);
		
		if(ratePo != null){
			ChannelDiscountPo cd = channelDiscountDao.get(ratePo.getChannelDiscountId());
			ChannelChannelPo cnelPo = channelChannelDao.get(ratePo.getChannelId());
			if(cnelPo != null && cnelPo.getChannelState().equals(ChannelStateEnum.OPEN.getValue())){//通道是开启的
				PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
				//更新消费记录表（先更新账户余额，再更新订单，最后更新记录）
				ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
				
				/**账户信息的更新结果*/
				int recordRes = 0;
				/**重置充值额（）*/
				Double orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), purchasePo.getChargeValue());
				purchasePo.setOrderAmount(orderAmount);
				
				//在二级代理商的情况下才去判断余额
				Integer orderResult = null;
				if(orderAmount > accountPo.getAccountBalance()){//订单价格大于余额
					logger.config("余额不足或者不是接口用户，下单失败");
					return "余额不足，下单失败";
				}else{
					//接口订单出现欠费等待
					if(ChargeStatusEnum.LACK_OF_BALANCE.getDesc().equals(purchasePo.getOrderResultDetail())){//因为是超管提交订单，所以可以用订单表的状态
						//因为欠费而导致充值等待，提单不会扣款，再次提交的时候就需要把扣款加上（欠费用户或者授信用户才会出现的情况）
						/**充值前余额*/
						//Double agencyBeforeBalance = accountPo.getAccountBalance();
						//accountPo.addBalance(orderAmount,-1);
						/** 更新登录用户账户信息**/
						//recordRes = chargeAccountAO.updateAccount(accountPo);
						//if(recordRes > 0){
							//Long rateDiscountId = ratePo.getId();			//折扣id
							//开始把第一个消费记录，连接加上，
							/** 向消费记录表插入登陆用户数据 */
//						Long nextIdRecord = chargeRecordDao.nextId();
//							chargeRecordDao.add(new ChargeRecordPo(currentTime, orderAmount,
//									agencyBeforeBalance, accountPo.getAccountBalance(), 
//									AccountTypeEnum.DECREASE.getValue(), accountId, 1 , orderId));
							/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
//						}
						
					}else{//其他原因导致充值等待(因为下游还是显示充值进行，所以只需要更新)
						//超管绑定的账户类型，应该和通道折扣类型一样
						ChargeAccountPo superAccountPo = chargeAccountAO.getRootAccountById(accountId, cd.getBillType());
						AccountPurchasePo superApPo = accountPurchaseDao.get(new WherePrams("account_id", "=", superAccountPo.getId()).and("purchase_id", "=", orderId));
						superApPo.setChannelDiscountId(cd.getId());//ap中的通道折扣id只对超级管理员有用
						superApPo.setApDiscount(cd.getChannelDiscount());
						superApPo.setOrderState(OrderStateEnum.CHARGING.getValue());
						superApPo.setOrderStateDetail(OrderStateEnum.CHARGING.getDesc());
						accountPurchaseDao.update(superApPo);
					}
				}
				//重新设置某笔订单某个代理商相关的通道信息，以便通过正确的费率通道去查询最新的结果
				AccountPurchasePo apPo = new AccountPurchasePo();
				apPo.setChannelDiscountId(ratePo.getChannelDiscountId());
				int aapUpdRes = accountPurchaseDao.updateLocal(apPo, new WherePrams("account_id", "=", accountId).and("purchase_id", "=", orderId));
				
				ExchangePlatformPo epPo = channelChannelDao.getEpByChannelId(ratePo.getChannelId());
				ProductCodePo pc = null;
				if(EpEncodeTypeEnum.WITH_CODE.getValue().equals(epPo.getEpEncodeType())){
					String scopeCityCode = StringHelper.isNotEmpty(chargeTelDetail)?PurchaseUtil.getScopeCityByCarrier(chargeTelDetail).get("scopeCityCode").toString():null;
					pc = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), Integer.parseInt(purchasePo.getPgId())));
				}else{
					pc = productCodeAO.getOneProductCodeByPg(Integer.parseInt(purchasePo.getPgId()));
				}
				ChargeDTO chargeDTO= null;
				String orderResultDetail = null;
				boolean doFlag = false;////重新生成第二个订单号,重新提交
				do{
					doFlag = false;
					chargeDTO= chargeByBI(epPo, purchasePo,pc);
					if(chargeDTO != null){
						if(chargeDTO.getTipCode().equals(OrderResultEnum.SUCCESS.getCode()) ){
							orderResult = OrderStateEnum.CHARGING.getValue();
							orderResultDetail = OrderStateEnum.CHARGING.getDesc();
							ChargeOrder co = chargeDTO.getChargeOrder();
							if(co != null){
								purchasePo.setOrderIdApi(co.getOrderIdApi());
							}
							res = "success";
						}else{
							if(chargeDTO.getAjaxDoublePurchase()){//重新生成第二个订单号,重新提交(重复订单号)
								try {
									OrderUril ou1 = new OrderUril(1);
									Long secondOrderId = ou1.nextId();
									purchasePo.setSecondOrderId(secondOrderId);//设置订单号
									purchasePo.setOrderId(secondOrderId);//为了提单，暂时设置为第二订单号
									doFlag = true;//需要再循环调一次接口充值
								} catch (Exception e) {
									e.printStackTrace();
									res = "订单号生成失败";
									orderResult = OrderStateEnum.DAICHONG.getValue();
									orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+chargeDTO.getTipMsg();
								}
							}
							if(!doFlag){//如果没有成功生成新的订单号，设置为待冲
								orderResult = OrderStateEnum.DAICHONG.getValue();
								orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+chargeDTO.getTipMsg();
							}
						}
					}else{
						orderResult = OrderStateEnum.DAICHONG.getValue();
						orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+"chargeDTO为空，平台直接返失败";
					}
				}while(doFlag);
				purchasePo.setOrderId(orderId);//恢复原来的orderId,存入数据库
				purchasePo.setOrderResult(orderResult);
				purchasePo.setOrderResultDetail(orderResultDetail);
				purchaseDAO.updateLocal(purchasePo,new WherePrams("order_id", "=", orderId));
			}
		}//费率存在
		else{
			System.out.println("没找到费率");
		}
			
		return res;
	}
	
	/**
	 * @description: 根据上游返回的状态结果更新订单表信息
	 * @param chargeDTO
	 * @param orderId
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月29日 上午11:19:08
	 */
	public int updatePurchase(ChargeDTO chargeDTO,Long orderId){
		System.out.println(chargeDTO.getTipCode() + ":" + chargeDTO.getTipMsg());
		if(chargeDTO.getTipCode() == OrderResultEnum.SUCCESS.getCode()){
			PurchasePo purchase =  purchaseDAO.getOnePurchase(orderId);
			purchase.setOrderIdApi(chargeDTO.getChargeOrder().getOrderIdApi());
			purchase.setOrderResult(OrderStateEnum.CHARGING.getValue());
			purchase.setOrderResultDetail(OrderStateEnum.CHARGING.getDesc());
			return purchaseDAO.updateLocal(purchase, new WherePrams("order_id", "=", orderId));
		}
		return 0;
	}
	/**
	 * @description: 接口充值,更新订单状态
	 * @param epPo
	 * @param dataPo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月17日 下午5:36:19
	 */
	public ChargeDTO chargeByBI(ExchangePlatformPo epPo,PurchasePo purchasePo,ProductCodePo pc) {
		if(pc == null || purchasePo == null || epPo == null){
			return null;
		}
		
		BaseInterface bi = null;
		ChargeDTO chargeDTO = null;
		boolean canChargeTel = valiUser.checkChargeTel(purchasePo.getChargeTel(), purchasePo.getAccountId());
		if(!canChargeTel){
			chargeDTO = new ChargeDTO(-1, "提交次数与标准次数不匹配或者该号码还有未回调的订单", null);
			return chargeDTO;
		}
		
		Integer epFor = epPo.getEpFor();
		String epEngId = epPo.getEpEngId();
		//初始化平台密码
		String dataUserPass = Hash.BASE_UTIL.decode(epPo.getEpUserPass());
		epPo.setEpUserPass(dataUserPass);
		if(PgServiceTypeEnum.PGCHARGE.getValue().equals(epFor)){//调用流量接口仓库
			bi = SingletonFactory.getSingleton(epEngId, new BaseP(pc,purchasePo.getOrderId(),purchasePo.getChargeTel(),epPo,DateUtil.formatPramm(purchasePo.getOrderArriveTime(), "yyyy-MM-dd")));
		}
//		else if(PgServiceTypeEnum.TELCHARGE.getValue().equals(epFor)){
//			bi = HSingletonFactory.getSingleton(epEngId, new BaseP(pc,purchasePo.getOrderId(),purchasePo.getChargeTel(),epPo,DateUtil.formatPramm(purchasePo.getOrderArriveTime(), "yyyy-MM-dd")));
//		}
		
		if(bi != null){
			chargeDTO = bi.charge();
			if(chargeDTO != null){//在后面：更新返回的订单id，方便主动查询
				purchasePo.setEpId(epPo.getId());
				
				String params = "编码："+pc.getProductCode()+"，平台名称:"+epPo.getEpName();
				//返回参数
				StringBuffer sb = new StringBuffer();
				sb.append("tipCode:"+chargeDTO.getTipCode()+",");
				sb.append("tipMsg:"+chargeDTO.getTipMsg()+",jsonStr:");
				sb.append(chargeDTO.getJsonStr());
				
				
				ChargeLog chargeLog = new ChargeLog(params, sb.toString(), purchasePo.getOrderId(), purchasePo.getChargeTel(), chargeDTO.getTipCode(), System.currentTimeMillis(), AgencyForwardEnum.FOWARD.getValue(), epPo.getEpPurchaseIp()+":tipMsg:"+chargeDTO.getTipMsg());
				chargeLogDao.add(chargeLog);
			}
		}
		return chargeDTO;
	}
	/**
	 * @description: 通过话费统一接口向上提单
	 * @param epPo
	 * @param purchasePo
	 * @param telProductPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月17日 下午4:29:08
	 */
	public ChargeDTO chargeByBI(ExchangePlatformPo epPo,PurchasePo purchasePo,TelProductPo telProductPo) {
		if(telProductPo == null || purchasePo == null || epPo == null){
			return null;
		}
		
		TelBaseInterface bi = null;
		ChargeDTO chargeDTO = null;
		boolean canChargeTel = valiUser.checkChargeTel(purchasePo.getChargeTel(), purchasePo.getAccountId());
		if(!canChargeTel){
			chargeDTO = new ChargeDTO(-1, "提交次数与标准次数不匹配或者该号码还有未回调的订单", null);
			return chargeDTO;
		}
		
		Integer epFor = epPo.getEpFor();
		String epEngId = epPo.getEpEngId();
		//初始化平台密码
		String dataUserPass = Hash.BASE_UTIL.decode(epPo.getEpUserPass());
		epPo.setEpUserPass(dataUserPass);
		if(PgServiceTypeEnum.TELCHARGE.getValue().equals(epFor)){
			bi = HSingletonFactory.getSingleton(epEngId);
		}
		
		if(bi != null){
			chargeDTO = bi.chargeTel(new TelBaseP(purchasePo.getOrderId(), purchasePo.getChargeTel(), epPo, telProductPo, DateUtil.formatAll(System.currentTimeMillis()), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
			if(chargeDTO != null){//在后面：更新返回的订单id，方便主动查询
				purchasePo.setEpId(epPo.getId());
				
				String params = "编码："+telProductPo.getTelCode()+"，平台名称:"+epPo.getEpName();
				//返回参数
				StringBuffer sb = new StringBuffer();
				sb.append("tipCode:"+chargeDTO.getTipCode()+",");
				sb.append("tipMsg:"+chargeDTO.getTipMsg()+",jsonStr:");
				sb.append(chargeDTO.getJsonStr());
				
				ChargeLog chargeLog = new ChargeLog(params, sb.toString(), purchasePo.getOrderId(), purchasePo.getChargeTel(), chargeDTO.getTipCode(), System.currentTimeMillis(), AgencyForwardEnum.FOWARD.getValue(), epPo.getEpPurchaseIp()+":tipMsg:"+chargeDTO.getTipMsg());
				chargeLogDao.add(chargeLog);
			}
		}
		return chargeDTO;
	}

	/**
	 * @description: 封装查询参数
	 * @param purchaseVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:53:34
	 */
	@Override
	public Map<String, Object> getMapByPojo(PurchaseVO purchaseVO,Boolean isCharged) {
		//充值成功列表使用充值时间查询
		if(purchaseVO != null){
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			if(StringHelper.isNotEmpty(purchaseVO.getChargeTel())){
				paramsMap.put("chargeTel", purchaseVO.getChargeTel().trim());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getChannelName())){
				paramsMap.put("channelName", purchaseVO.getChannelName().trim());
			}
			Integer purchaseFor = purchaseVO.getPurchaseFor();
			if(purchaseFor != null){
				paramsMap.put("purchaseFor", purchaseFor);
			}
			if(purchaseVO.getChargeSpeed() != null){
				paramsMap.put("chargeSpeed", purchaseVO.getChargeSpeed());
			}
			if(purchaseVO.getOperatorName() != null){
				paramsMap.put("operatorName", purchaseVO.getOperatorName());
			}
//			Integer pgServiceType = purchaseVO.getPgServiceType();
			//默认查询流量订单
			Boolean isPgcharge = PgServiceTypeEnum.PGCHARGE.getValue().equals(purchaseFor) || purchaseFor == null;
			if(isPgcharge){
				paramsMap.put("pgcharge", PgServiceTypeEnum.PGCHARGE.getValue());
				paramsMap.put("purchaseFor", PgServiceTypeEnum.PGCHARGE.getValue());
			}
			if(purchaseVO.getAgencyId() != null){
				paramsMap.put("agencyId", purchaseVO.getAgencyId());
				//超管使用订单的orderResult进行分类查询
				AgencyBackwardPo agencyPo = agencyAO.getRootAgencyById(purchaseVO.getAgencyId());
				if(agencyPo == null && purchaseVO.getOrderState() != null){//用页面参数代理商订单状态当做订单表的状态参数来查
					paramsMap.put("orderResult", purchaseVO.getOrderState());
				}else{//不是超管的查询参数
					if(purchaseVO.getOrderResult() != null){
						paramsMap.put("orderResult", purchaseVO.getOrderResult());
					}
					if(purchaseVO.getOrderState() != null){
						paramsMap.put("orderState", purchaseVO.getOrderState());
					}
				}
			}
			if(purchaseVO.getAccountId() != null){
				paramsMap.put("accountId", purchaseVO.getAccountId());
			}
			if(purchaseVO.getBillType() != null){
				paramsMap.put("billType", purchaseVO.getBillType());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getAgencyName())){
				paramsMap.put("agencyName", purchaseVO.getAgencyName().trim());
			}
			if(purchaseVO.getOrderId() != null){
				paramsMap.put("orderId", purchaseVO.getOrderId());
			}
			
			
			if(StringHelper.isNotEmpty(purchaseVO.getChargeTelDetail())){
				paramsMap.put("chargeTelDetail", purchaseVO.getChargeTelDetail().trim());
			}
			if(purchaseVO.getOperatorType() != null){
				paramsMap.put("operatorType", purchaseVO.getOperatorType());
			}
			if(isCharged){
				String backStartTimeStr = purchaseVO.getBackStartTimeStr();
				if(StringHelper.isNotEmpty(backStartTimeStr)){
					long startTime = DateUtil.strToDate(backStartTimeStr, backStartTimeStr.trim().length() == 10?"yyyy-MM-dd":null).getTime();
					paramsMap.put("startTimeBack", startTime);
				}
				String backEndTimeStr = purchaseVO.getBackEndTimeStr();
				if(StringHelper.isNotEmpty(backEndTimeStr)){
					long endTime = DateUtil.strToDate(backEndTimeStr, backEndTimeStr.trim().length() == 10?"yyyy-MM-dd":null).getTime();
					paramsMap.put("endTimeBack", endTime);
				}
			}else{
				String arriveStartTimeStr = purchaseVO.getArriveStartTimeStr();
				if(StringHelper.isNotEmpty(arriveStartTimeStr)){
					long startTime = DateUtil.strToDate(arriveStartTimeStr, arriveStartTimeStr.trim().length() == 10?"yyyy-MM-dd":null).getTime();
					paramsMap.put("startTime", startTime);
				}
				String arriveEndTimeStr = purchaseVO.getArriveEndTimeStr();
				if(StringHelper.isNotEmpty(arriveEndTimeStr)){
					long endTime = DateUtil.strToDate(arriveEndTimeStr, arriveEndTimeStr.trim().length() == 10?"yyyy-MM-dd":null).getTime();
					paramsMap.put("endTime", endTime);
				}
			}
			return paramsMap;
		}
		return null;
	}

	/**
	 * @description: 查询订单列表
	 * @param purchaseVO
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:53:21
	 */
	@Override
	public Pagination<PurchaseVO> getPurchase(Map<String, Object> resultMap,PurchaseVO purchaseVO,
			PageParam pageParam) {
		Boolean isStateCharged = purchaseVO.getOrderState() != null && (purchaseVO.getOrderState() == OrderStateEnum.CHARGED.getValue() ||purchaseVO.getOrderState() == OrderStateEnum.UNCHARGE.getValue());
		Boolean isResultCharged = purchaseVO.getOrderResult() != null && (purchaseVO.getOrderResult() == OrderStateEnum.CHARGED.getValue() ||purchaseVO.getOrderResult() == OrderStateEnum.UNCHARGE.getValue());
		Boolean isCharged = isStateCharged || isResultCharged; 
		Map<String, Object> paramsMap = getMapByPojo(purchaseVO,isCharged);
		boolean isReset = false;
		Long dateUtilStartTime = DateUtil.getStartTime().getTime();
		Long dateUtilEndTime = DateUtil.getEndTime().getTime();
		if(isCharged){
			if(purchaseVO.getBackStartTimeStr() == null && purchaseVO.getBackEndTimeStr() == null){
				isReset = true;
				paramsMap.put("startTimeBack", dateUtilStartTime);
				paramsMap.put("endTimeBack", dateUtilEndTime);
			}
		}else{
			if(purchaseVO.getArriveStartTimeStr() == null && purchaseVO.getArriveEndTimeStr() == null){
				isReset = true;
				paramsMap.put("startTime", dateUtilStartTime);
				paramsMap.put("endTime", dateUtilEndTime);
			}
		}
		long totalRecord = purchaseDAO.countPurchase(paramsMap);//今天的订单数量
		if(isReset){
			if(totalRecord == 0){
				//设置总记录数和页面参数和查询参数
				totalRecord = resetTotalRecord(purchaseVO,paramsMap,isCharged,totalRecord);
			}else{
				if(isCharged){
					purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
				}else{
					purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));;
					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
				}
			}
		}
		
		int pageSize = pageParam.getPageSize();
		Long pageNoLong = pageParam.getPageNoLong();
		paramsMap.put("start", (pageNoLong-1) * pageSize);
		paramsMap.put("end", pageSize);
		
		List<PurchaseVO> records = purchaseDAO.getPurchase(paramsMap);
		Boolean isPurchaseList = purchaseVO.getOrderState() == null;//订单列表判定
		if(records != null && records.size() > 0){
			//遍历每一个订单，查看它的订单状态
			for (PurchaseVO purchaseVO2 : records) {
				/**查询订单成本*/
				int accountId = purchaseVO2.getAccountId();
				ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
				if(accountPo != null){
					//重新设定成本
					if(!accountPo.getAgencyId().equals(purchaseVO.getAgencyId())){//查一遍这个订单的成本(当前订单绑定的账户所属代理商和当前登陆代理商不是同一个)
						AccountPurchasePo ap = accountPurchaseDao.getAPByAccountType(purchaseVO2.getOrderId(), accountId,AccountTypeEnum.DECREASE.getValue());//得到了成本
						Double orderAmount = ap.getOrderAmount();
						if(orderAmount != null){
							purchaseVO2.setOrderAmount(orderAmount);
						}
					}
					//通道暂停保存的单子，不在加载列表的时候更新她的订单状态
					boolean canGetStateByAPI = purchaseVO2.getOrderResult() != null && purchaseVO2.getOrderResult().equals(OrderStateEnum.DAICHONG.getValue()) && "通道暂停等待".equals(purchaseVO2.getOrderResultDetail());
					Boolean hasCallBack = OrderResultEnum.SUCCESS.getCode().equals(purchaseVO2.getHasCallBack());
					/**订单列表，订单又不支持回调的时候**/
					if(!hasCallBack && isPurchaseList && purchaseVO2.getChannelDiscountId() != null && !canGetStateByAPI && purchaseVO2.getOrderResult() != null){//只能通过费率id，如果通道或者费率被删除，就得不到最新的订单状态//要求有充值回调记录
						ExchangePlatformPo purchaseEp = null;
						if(PgServiceTypeEnum.PGCHARGE.getValue().equals(purchaseVO2.getPurchaseFor())){
							purchaseEp = exchangePlatformDao.getEpByCDiscountId(purchaseVO2.getChannelDiscountId());
						}else{
							purchaseEp = exchangePlatformDao.getEpByTelchannelId(purchaseVO2.getChannelDiscountId());
						}
						if(purchaseEp != null){
							boolean negCallBack = CallBackEnum.NEGATIVE.getValue().equals(purchaseEp.getEpCallBack());
							if(negCallBack){//不支持回调就用主动查询，查询订单状态
								BaseInterface bi = null;
								TelBaseInterface tbi = null;
								Integer epFor = purchaseEp.getEpFor();
								String epEngId = purchaseEp.getEpEngId();
								Long orderId = purchaseVO2.getOrderId();
								if(PgServiceTypeEnum.PGCHARGE.getValue().equals(epFor)){//调用流量接口仓库
									BaseP baseP = new BaseP(null,purchaseVO2.getOrderIdApi(),purchaseVO2.getChargeTel(),purchaseEp,DateUtil.formatPramm(purchaseVO2.getOrderArriveTime(), "yyyy-MM-dd"));
									baseP.setOrderId(orderId);
									bi = SingletonFactory.getSingleton(epEngId, baseP);
								}
								else if(PgServiceTypeEnum.TELCHARGE.getValue().equals(epFor)){
									tbi = HSingletonFactory.getSingleton(epEngId);
								}
								//是否需要更新订单状态条件
								if(bi != null){
									OrderDTO orderDTO = bi.getOrderState();
									if(orderDTO == null){
										//更新订单表
										purchaseDAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, System.currentTimeMillis(), null, null, ChargeStatusEnum.API_ERROR.getDesc()+"查询状态"));//purchaseVO2.getOrderId(), System.currentTimeMillis(), orderIn.getStatus(), orderIn.getMsg(), null
									}else{
										OrderIn orderIn = orderDTO.getOrderIn();
										boolean updateCondition = orderIn!= null && !purchaseVO2.getOrderResult().equals(orderIn.getStatus());
										if(updateCondition){
											//更新订单状态//返回状态和原先数据库状态不相符
	//										Long ts = orderIn.getCreated_at_time();
											Long ts = System.currentTimeMillis();
											
											int orderState = orderIn.getStatus();
											String orderStateDetail = orderIn.getMsg();
											purchaseVO2.setOrderBackTimeStr(DateUtil.formatAll(ts));
											purchaseVO2.setOrderState(orderState);
											purchaseVO2.setOrderStateDetail(orderStateDetail);
											String res = accountPurchaseAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, ts, orderState, null, orderStateDetail));//purchaseVO2.getOrderId(), orderState, orderStateDetail,ts
											System.out.println("更新订单状态数据库结果："+res);
											//把查询的结果利用接口推给下游
											//更新订单表
											purchaseDAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, System.currentTimeMillis(), orderIn.getStatus(), OrderResultEnum.SUCCESS.getCode(), orderIn.getMsg()));//purchaseVO2.getOrderId(), System.currentTimeMillis(), orderIn.getStatus(), orderIn.getMsg(), null
										}
										
									}
								}else if(tbi != null){//话费主动查询订单状态
									TelBaseP telBaseP = new TelBaseP(purchaseVO2.getOrderIdApi(),purchaseVO2.getChargeTel(), purchaseEp, null, purchaseVO2.getOrderArriveTime().toString(), accountPo.getBillType());
									TelOrderStateDTO orderDTO = tbi.getTelOrderState(telBaseP);
									telBaseP.setOrderId(orderId);
									if(orderDTO == null){
										//更新订单表
										purchaseDAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, System.currentTimeMillis(), null, null, ChargeStatusEnum.API_ERROR.getDesc()+"查询状态"));//purchaseVO2.getOrderId(), System.currentTimeMillis(), orderIn.getStatus(), orderIn.getMsg(), null
									}else{
										TelOrderIn orderIn = orderDTO.getTelOrderIn();
//										TelOrderIn orderIn = orderDTO.getOrderIn();
										boolean updateCondition = orderIn!= null && !purchaseVO2.getOrderResult().equals(orderIn.getStatus());
										if(updateCondition){
											//更新订单状态//返回状态和原先数据库状态不相符
	//										Long ts = orderIn.getCreated_at_time();
											Long ts = System.currentTimeMillis();
											
											int orderState = orderIn.getStatus();
											String orderStateDetail = orderIn.getMsg();
											purchaseVO2.setOrderBackTimeStr(DateUtil.formatAll(ts));
											purchaseVO2.setOrderState(orderState);
											purchaseVO2.setOrderStateDetail(orderStateDetail);
											String res = accountPurchaseAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, ts, orderState, null, orderStateDetail));//purchaseVO2.getOrderId(), orderState, orderStateDetail,ts
											System.out.println("更新订单状态数据库结果："+res);
											//把查询的结果利用接口推给下游
											//更新订单表
											purchaseDAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, System.currentTimeMillis(), orderIn.getStatus(), OrderResultEnum.SUCCESS.getCode(), orderIn.getMsg()));//purchaseVO2.getOrderId(), System.currentTimeMillis(), orderIn.getStatus(), orderIn.getMsg(), null
										}
									}
								}
							}
						}else{
							System.out.println("未找到相关平台信息");
						}
					}
					//格式化展示时间
					if(purchaseVO2.getOrderBackTime() != null)
					{
						purchaseVO2.setOrderBackTimeStr(DateUtil.formatAll(purchaseVO2.getOrderBackTime()));
					}
					if(PgSizeEnum.getEnum(purchaseVO2.getPgSize()) != null){
						purchaseVO2.setPgSizeStr(PgSizeEnum.getEnum(purchaseVO2.getPgSize()).getDesc());
					}else{
						purchaseVO2.setPgSizeStr(purchaseVO2.getPgSize() + "M");
					}
					if(purchaseVO2.getOrderArriveTime() != null){
						purchaseVO2.setOrderArriveTimeStr(DateUtil.formatAll(purchaseVO2.getOrderArriveTime()));
					}
				}
			}
		}
		resultMap.put("searchParams", purchaseVO);	//查询参数放入返回参数
		return new Pagination<PurchaseVO>(records, totalRecord, pageNoLong, pageSize);
	}
	

	@Override
	public Map<String,Object> getPurchaseMap(PurchaseVO purchaseVO) {
		Boolean isStateCharged = purchaseVO.getOrderState() != null && (purchaseVO.getOrderState() == OrderStateEnum.CHARGED.getValue() ||purchaseVO.getOrderState() == OrderStateEnum.UNCHARGE.getValue());
		Boolean isResultCharged = purchaseVO.getOrderResult() != null && (purchaseVO.getOrderResult() == OrderStateEnum.CHARGED.getValue() ||purchaseVO.getOrderResult() == OrderStateEnum.UNCHARGE.getValue());
		Boolean isCharged = isStateCharged || isResultCharged; 
		
		Map<String, Object> paramsMap = getMapByPojo(purchaseVO,isCharged);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean isReset = false;
		Long dateUtilStartTime = DateUtil.getStartTime().getTime();
		Long dateUtilEndTime = DateUtil.getEndTime().getTime();
		if(isCharged){
			if(purchaseVO.getBackStartTimeStr() == null && purchaseVO.getBackEndTimeStr() == null){
				isReset = true;
				paramsMap.put("startTimeBack", dateUtilStartTime);
				paramsMap.put("endTimeBack", dateUtilEndTime);
			}
		}else{
			if(purchaseVO.getArriveStartTimeStr() == null && purchaseVO.getArriveEndTimeStr() == null){
				isReset = true;
				paramsMap.put("startTime", dateUtilStartTime);
				paramsMap.put("endTime", dateUtilEndTime);
			}
		}
		long totalRecord = purchaseDAO.countPurchase(paramsMap);//今天的订单数量
		if(isReset){
			if(totalRecord == 0){
				//设置总记录数和页面参数和查询参数
				totalRecord = resetTotalRecord(purchaseVO,paramsMap,isCharged,totalRecord);
			}else{
				if(isCharged){
					purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
				}else{
					purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));;
					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
				}
			}
		}
		resultMap.put("totalRecord", totalRecord);
		
		List<PurchaseVO> records = purchaseDAO.getPurchase(paramsMap);
		resultMap.put("records", records);
		
		return resultMap;
	}

	
	/**
	 * @description: 重置下级代理商的订单状态和订单详情
	 * @param orderIn
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月21日 下午12:05:52
	 */
	private void resetPurchaseState(OrderIn orderIn) {
		int orderState = orderIn.getStatus();
		String msg = orderIn.getMsg();
		switch (orderState) {
    	case 4://未充值
//    		orderState = OrderStateEnum.WEICHONG.getValue();
//    		break;
    	case 3://等待充值
    		orderState = OrderStateEnum.CHARGING.getValue();
    		msg = OrderStateEnum.CHARGING.getDesc();
//    		orderState = OrderStateEnum.DAICHONG.getValue();
//    		break;
//    	case 8://充值失败
//    		orderState = OrderStateEnum.UNCHARGE.getValue();
//    		break;
    	default:
    		break;
    	}
		orderIn.setStatus(orderState);
		orderIn.setMsg(msg);
	}

	/** 设置总记录数和页面参数和查询参数
	 * @param purchaseVO
	 * @param paramsMap
	 * @param isCharged
	 * @param totalRecord
	 * @return
	 */
	private long resetTotalRecord(PurchaseVO purchaseVO,
			Map<String, Object> paramsMap, Boolean isCharged, long totalRecord) {
		//在没有记录的情况下重置查询条件和查询参数
		if(totalRecord == 0){
			Long currentTime = System.currentTimeMillis();
			if(isCharged){
				paramsMap.put("startTimeBack",null);
				purchaseVO.setBackStartTimeStr("");
				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(currentTime));
					paramsMap.put("endTimeBack", currentTime);
				}
			}else{//其他列表
				paramsMap.put("startTime",null);
				purchaseVO.setArriveStartTimeStr("");
				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
					paramsMap.put("endTime", currentTime);
					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(currentTime));
				}
			}
			totalRecord = purchaseDAO.countPurchase(paramsMap);//重置订单数量
		}
//		}
		return totalRecord;
	}

	/**
	 * @description: 通过微族api充值
	 * @param paramsEntity
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:23:33
	 */
	@Override
	public OrderStateResult purchaseByWeizuAPI(ParamsEntityWeiZu paramsEntity) {
		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/sendOrder", paramsEntity.toString());
		OrderStateResult osr = JSON.parseObject(resMsg, OrderStateResult.class);
		
		return osr;
	}
	/**
	 * @description: 通过订单Id查询订单
	 * @param orderId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:05:03
	 */
	@Override
	public PurchasePo getOnePurchase(long orderId) {
		return purchaseDAO.getOnePurchase(orderId);
	}

	@Override
	public TotalResult getTotalResultFromSuccess(PurchaseVO purchaseVO) {
		Map<String,Object> map = getMapByPojo(purchaseVO, true);
		if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){
			map.put("startTimeBack",null);
		}
		if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
			purchaseVO.setBackEndTimeStr(DateUtil.formatAll(System.currentTimeMillis()));
			map.put("endTimeBack", System.currentTimeMillis());
		}
		return purchaseDAO.getTotalResultFromSuccess(map);
	}

	@Override
	public List<ChargeChannelPo> ajaxChargeChannel(ChargeChannelParamsPo ccpp) {
		Map<String,Object> searchMap = getSearachMap(ccpp);
		searchMap.put("channelState", ChannelStateEnum.OPEN.getValue());
		List<ChargeChannelPo> channelList = channelChannelDao.list_charge_channel(searchMap);
		return channelList;
	}
	
	/**
	 * @description: 获得查询参数
	 * @param ccpp
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月28日 下午4:07:08
	 */
	private Map<String,Object> getSearachMap(ChargeChannelParamsPo ccpp){
		Map<String,Object> searchMap = new HashMap<String, Object>();
		String carrier = ccpp.getCarrier();
		int operatorType = OperatorTypeEnum.getValueByDesc(carrier.substring(carrier.length()-2,carrier.length()-2));
		searchMap.put("operatorType", operatorType);
		ccpp.setOperatorType(operatorType);
		
		if(ccpp.getServiceType() != null){
			searchMap.put("serviceType", ccpp.getServiceType());
			if(! ccpp.getServiceType().equals(ServiceTypeEnum.NATION_WIDE.getValue())){
				Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(carrier);
				if(scopeMap != null)
				{
					String scopeCityCode = scopeMap.get("scopeCityCode").toString();
					searchMap.put("scopeCityCode", scopeCityCode);
				}
			}
		}
		if(ccpp.getPgSize() != null){
			searchMap.put("pgSize", ccpp.getPgSize());
		}
		if(ccpp.getPgType() != null){
			searchMap.put("pgType", ccpp.getPgType());
		}
		if(ccpp.getChannelType() != null){
			searchMap.put("channelType", ccpp.getChannelType());
		}
		if(StringHelper.isNotEmpty(ccpp.getPgValidity())){
			searchMap.put("pgValidity", ccpp.getPgValidity());
		}
		if(ccpp.getEpName() != null){
			searchMap.put("epName", ccpp.getEpName());
		}
		return searchMap;
	}

	@Override
	public List<OperatorPgDataPo> ajaxChargePg(ChargeChannelParamsPo ccpp) {
		Map<String, Object> objMap = new HashMap<String, Object>();
		String carrier = ccpp.getCarrier();
		int operatorType = OperatorTypeEnum.getValueByDesc(carrier.substring(carrier.length()-2));
		objMap.put("operatorType", operatorType);
//		objMap.put("channelId", ccpp.getChannelId());
		
		if(ServiceTypeEnum.NATION_WIDE.getValue() != ccpp.getServiceType()){
			Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(carrier);
			if(scopeMap.get("scopeCityCode") != null){
				objMap.put("scopeCityCode", scopeMap.get("scopeCityCode").toString());
			}
		}
		objMap.put("serviceType", ccpp.getServiceType());
		List<OperatorPgDataPo> pgList = operatorPgDao.pgList_forPurchase(objMap);
		return pgList;
	}
	@Override
	public List<PgDataPo> getPgByChanel(Long channelId) {
		Map<String, Object> objMap = new HashMap<String, Object>();
		if(channelId != null){
			objMap.put("channelId", channelId);
		}
		//objMap.put("pgServiceType", PgServiceTypeEnum.PGCHARGE.getValue());
		List<PgDataPo> pgList = operatorPgDao.getPgByChanel(objMap);
		return pgList;
	}

	
	@Override
	public String batchCommitOrder(PurchaseVO purchaseVO) {
		Map<String,Object> dataMap = getPurchaseMap(purchaseVO);
		List<PurchaseVO> records = new ArrayList<PurchaseVO>();
		if(dataMap.get("records") != null){
			records = (List<PurchaseVO>)dataMap.get("records");
		}
		int successTag = 0;
		int errorTag = 0;
		
		for (PurchaseVO purchaseVO2 : records) {
			String res = ajaxCommitOrder(purchaseVO2.getOrderId(), purchaseVO2.getFromAccountId(), purchaseVO2.getChargeTelDetail());
			if("success".equals(res)){
				successTag++;
			}else{
				errorTag++;
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("批量提交了 ");
		sb.append(successTag);
		sb.append("单,失败了 ");
		sb.append(errorTag);
		sb.append("单");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@Transactional
	@Override
	public String batchChangeOrderState(PurchaseVO purchaseVO) {
		int originalResult = purchaseVO.getOrderState();
		int newResult = purchaseVO.getOrderResult();
		purchaseVO.setOrderResult(originalResult);//重新设置查询参数，使得不为成功列表，方便调用下面的方法
		Map<String,Object> dataMap = getPurchaseMap(purchaseVO);
		List<PurchaseVO> records = new ArrayList<PurchaseVO>();
		if(dataMap.get("records") != null){
			records = (List<PurchaseVO>)dataMap.get("records");
		}
		purchaseVO.setOrderResult(newResult);
		int successTag = 0;
		int errorTag = 0;
		String orderResultDetail = "批量手动失败";
		if(purchaseVO.getOrderResult() == OrderStateEnum.CHARGED.getValue()){
			orderResultDetail = "批量手动成功";
		}
		
		for (PurchaseVO purchaseVO2 : records) {
			String updateRes = accountPurchaseAO.updatePurchaseStateByMe(purchaseVO2.getOrderId(), newResult, orderResultDetail,null);
			if("success".equals(updateRes)){
				successTag++;
			}else{
				errorTag++;
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("批量了 ");
		sb.append(successTag);
		sb.append("单,失败了 ");
		sb.append(errorTag);
		sb.append("单");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@Override
	public String batchPushOrder(PurchaseVO purchaseVO) {
		Map<String,Object> dataMap = getPurchaseMap(purchaseVO);
		List<PurchaseVO> records = new ArrayList<PurchaseVO>();
		if(dataMap.get("records") != null){
			records = (List<PurchaseVO>)dataMap.get("records");
		}
		
		int successTag = 0;
		int errorTag = 0;
		
		for (PurchaseVO purchaseVO2 : records) {
			String res = "error";
			if(StringHelper.isNotEmpty(purchaseVO2.getAgencyCallIp())){
				//推送订单结果
				res = sendCallBack.sendCallBack(new ResponseJsonDTO(purchaseVO2.getOrderId(), purchaseVO2.getOrderIdFrom(), purchaseVO.getOrderResult(), "（批量推送）"+purchaseVO2.getOrderResultDetail(), System.currentTimeMillis(),purchaseVO2.getChargeTel()), purchaseVO2.getAgencyCallIp());
			}else{
				successTag++;//没有回调ip，设置为回调成功
			}
			if("success".equals(res)){
				successTag++;
			}else{
				errorTag++;
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("批量推送成功了 ");
		sb.append(successTag);
		sb.append("单,失败了 ");
		sb.append(errorTag);
		sb.append("单");
		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * @description:
	 * @param purchaseVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月7日 下午2:48:26
	 */
	@Override
	public HSSFWorkbook exportChargedList(PurchaseVO purchaseVO,Integer agencyTag) {
		
			HSSFWorkbook hbook = null;
			Map<String,Object> dataMap = getPurchaseMap(purchaseVO);
			boolean isTel = PgServiceTypeEnum.TELCHARGE.getValue().equals(purchaseVO.getPurchaseFor());
			
			List<PurchaseVO> records = new ArrayList<PurchaseVO>();
			if(dataMap.get("records") != null){
				records = (List<PurchaseVO>)dataMap.get("records");
				if(isTel){//导出话费
					String[] header =
						{ "所属代理商", "订单号", "手机号", "业务类型", "面值", "折扣", "扣款金额(成本)" ,  "订单完成时间" };
					
					Boolean isDataUser = AgencyTagEnum.DATA_USER.getValue().equals(agencyTag);
					if(isDataUser){
						header=Arrays.copyOf(header, header.length+1);
						header[header.length-1] = "来源订单号";
					}
					
					hbook = new HSSFWorkbook();
					
					HSSFSheet hSheet = hbook.createSheet();
					
					hSheet.setColumnWidth(0, 35 * 100);
					hSheet.setColumnWidth(1, 35 * 150);
					hSheet.setColumnWidth(2, 35 * 100);
					hSheet.setColumnWidth(3, 35 * 100);
					hSheet.setColumnWidth(4, 35 * 100);
					hSheet.setColumnWidth(5, 35 * 100);
					hSheet.setColumnWidth(6, 35 * 100);
					hSheet.setColumnWidth(7, 35 * 200);
					if(isDataUser){
						hSheet.setColumnWidth(8, 35 * 200);
					}
					HSSFRow hRow = hSheet.createRow(0);
					
					HSSFCellStyle style = hbook.createCellStyle();
					style.setFillForegroundColor(HSSFColor.LIME.index);
					style.setFillBackgroundColor(HSSFColor.GREEN.index);
					for (int i = 0; i < header.length; i++)
					{
						HSSFCell hCell = hRow.createCell(i);
						hCell.setCellStyle(style);
						hCell.setCellType(HSSFCell.CELL_TYPE_STRING);
						hCell.setCellValue(header[i]);
					}
					
					int i = 0;
					//String tradeType = "";				// 台账类型
					//String tradeNo = "";				// 交易号
					for (PurchaseVO r : records)
					{
						i++;
						hRow = hSheet.createRow(i);
						//代理商名称
						hRow.createCell(0).setCellValue(r.getAgencyName());
						//订单号
						hRow.createCell(1).setCellValue(r.getOrderId().toString());
						// 充值号码
						hRow.createCell(2).setCellValue(r.getChargeTel());
						//业务类型
						hRow.createCell(3).setCellValue(TelServiceTypeEnum.getEnum(r.getServiceType()).getDesc());
						
						
						// 面值
						hRow.createCell(4).setCellValue(r.getChargeValue());
						
						// 折扣
						hRow.createCell(5).setCellValue(r.getApDiscount()==null?0d:r.getApDiscount());
						// 扣款金额
						hRow.createCell(6).setCellValue(NumberTool.round(r.getOrderAmount(), 3));
						// 订单完成时间
						hRow.createCell(7).setCellValue(DateUtil.formatAll(r.getOrderBackTime()));
						
						if(isDataUser){
							// 代理商订单号
							hRow.createCell(8).setCellValue(r.getOrderIdFrom());
						}
					}
				}else{
					String[] header =
						{ "所属代理商", "订单号", "手机号", "流量大小", "面值", "折扣", "扣款金额" ,  "订单完成时间" };
					
					Boolean isDataUser = AgencyTagEnum.DATA_USER.getValue().equals(agencyTag);
					if(isDataUser){
						header=Arrays.copyOf(header, header.length+1);
						header[header.length-1] = "来源订单号";
					}
					
					hbook = new HSSFWorkbook();
					
					HSSFSheet hSheet = hbook.createSheet();
					
					hSheet.setColumnWidth(0, 35 * 80);
					hSheet.setColumnWidth(1, 35 * 150);
					hSheet.setColumnWidth(2, 35 * 100);
					hSheet.setColumnWidth(3, 35 * 100);
					hSheet.setColumnWidth(4, 35 * 100);
					hSheet.setColumnWidth(5, 35 * 100);
					hSheet.setColumnWidth(6, 35 * 80);
					hSheet.setColumnWidth(7, 35 * 200);
					if(isDataUser){
						hSheet.setColumnWidth(8, 35 * 200);
					}
					HSSFRow hRow = hSheet.createRow(0);
					
					HSSFCellStyle style = hbook.createCellStyle();
					style.setFillForegroundColor(HSSFColor.LIME.index);
					style.setFillBackgroundColor(HSSFColor.GREEN.index);
					for (int i = 0; i < header.length; i++)
					{
						HSSFCell hCell = hRow.createCell(i);
						hCell.setCellStyle(style);
						hCell.setCellType(HSSFCell.CELL_TYPE_STRING);
						hCell.setCellValue(header[i]);
					}
					
					int i = 0;
					//String tradeType = "";				// 台账类型
					//String tradeNo = "";				// 交易号
					for (PurchaseVO r : records)
					{
						i++;
						hRow = hSheet.createRow(i);
						//代理商名称
						hRow.createCell(0).setCellValue(r.getAgencyName());
						//订单号
						hRow.createCell(1).setCellValue(r.getOrderId().toString());
						// 充值号码
						hRow.createCell(2).setCellValue(r.getChargeTel());
						//包体大小
						hRow.createCell(3).setCellValue(r.getPgSize());
						// 面值
						hRow.createCell(4).setCellValue(r.getChargeValue());
						
						// 折扣
						hRow.createCell(5).setCellValue(r.getApDiscount()==null?0d:r.getApDiscount());
						// 扣款金额
						hRow.createCell(6).setCellValue(NumberTool.round(r.getOrderAmount(), 3));
						// 订单完成时间
						hRow.createCell(7).setCellValue(DateUtil.formatAll(r.getOrderBackTime()));
						
						if(isDataUser){
							// 代理商订单号
							hRow.createCell(8).setCellValue(r.getOrderIdFrom());
						}
					}
					
				}
				
				
			}
			return hbook;
		}
	
}
