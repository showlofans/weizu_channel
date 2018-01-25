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
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.EpEncodeTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
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
//	@Resource
//	private ChannelForwardAO channelForwardAO;
//	@Resource
//	private ChannelForwardDaoInterface channelForwardDao;
	@Resource
	private ChannelChannelDao channelChannelDao; 
	
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;
//	@Resource
//	private OperatorPgAO operatorPgAO;
	@Resource
	private OperatorPgDaoInterface operatorPgDao;
	@Resource
	private ProductCodeAO productCodeAO;
	@Resource
	private RateDiscountAO rateDiscountAO;
	@Resource
	private RateDiscountDao rateDiscountDao; 
//	@Resource
//	private AgencyBackwardDao agencyBackwardDao;
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
	
	private Logger logger = Logger.getLogger("PurchaseAOImpl");
//	@Resource
//	private ChargeFacade chargeFacade;
	
	/**
	 * @description: 根据页面订单参数初始化订单实体
	 * @param pcVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月4日 下午3:16:02
	 */
	private PurchasePo initPurchase(PgChargeVO pcVO) {
		return new PurchasePo(pcVO.getChargeTel(), pcVO.getPgId().toString(), pcVO.getChargeTelDetail());
	}
	private PurchasePo initPurchase(TelChargeVO tcVO) {
		return new PurchasePo(tcVO.getChargeTel(), tcVO.getTelProductId().toString(), tcVO.getChargeTelDetail());
	}
	
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
		PurchasePo purchasePo = initPurchase(tcVO);
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
//		ChannelChannelPo channel = channelChannelDao.get(new WherePrams("id", "=", pcVO.getChannelId()));
		ExchangePlatformPo epPo = null;
		TelProductPo dataPo = telProductDao.get(tcVO.getTelProductId());
		if(dataPo == null){
			logger.config("编码未配置");
			System.out.println("编码未配置");
			return "产品待更新，产品暂不支持购买！！";
		}else if (telchannel == null){
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
			return "订单添加异常";
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
		String operatorNameDesc = OperatorNameEnum.getDescBy(desct);			//运营商名称
		purchasePo.setChargeTelCity(chargeTelDetail);
		Boolean isChannelStateCanceled = telchannel.getTelchannelState() == ChannelStateEnum.CLOSE.getValue();
		if(isChannelStateCanceled){
			orderResult = OrderStateEnum.DAICHONG.getValue();
			orderResultDetail = "通道暂停等待";
		}else{//通道没有暂停
//			chargeDTO = chargeByBI(epPo, orderId, tcVO.getChargeTel(),dataPo.getId(), dataPo.getTelCode());
//			if(chargeDTO != null){
//				if(chargeDTO.getTipCode().equals(OrderResultEnum.SUCCESS.getCode()) ){
//					orderResult = OrderStateEnum.CHARGING.getValue();
//					orderResultDetail = OrderStateEnum.CHARGING.getDesc();
//					ChargeOrder co = chargeDTO.getChargeOrder();
//					if(co != null){
//						purchasePo.setOrderIdApi(co.getOrderIdApi());
//					}
//				}else{
//					orderResult = OrderStateEnum.DAICHONG.getValue();
//					orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+chargeDTO.getTipMsg();
//				}
//			}else{
//				orderResult = OrderStateEnum.DAICHONG.getValue();
//				orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+"平台直接返失败";
//			}
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
					chargeAccountPo.setAccountBalance(agencyAfterBalance);
					chargeAccountAO.updateAccount(chargeAccountPo);
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
				orderAmount = NumberTool.mul(telRatePo.getActiveDiscount(), chargeValue);
				chargeAccountPo.addBalance(orderAmount,-1);
				/** 更新登录用户账户信息**/
				recordRes = chargeAccountAO.updateAccount(chargeAccountPo);
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
					ap_accountPo.addBalance(balance,1);
					/** 更新父级代理商账户信息**/
					recordRes = chargeAccountAO.updateAccount(ap_accountPo);
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
				agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
				superAccountPo.setAccountBalance(agencyAfterBalance);
				chargeAccountAO.updateAccount(superAccountPo);
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
		PurchasePo purchasePo = initPurchase(pcVO);
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
//			boolean isChannelUseStateStoped = channel.getChannelUseState() == ChannelUseStateEnum.CLOSE.getValue();//通道状态停止
//			if(isChannelUseStateStoped){//通道使用状态暂停，不能提单
//				logger.config("通道使用状态暂停");
//				System.out.println("通道使用状态暂停");
//				return "产品待更新，产品暂不支持购买！！";
//			}else{
				if(EpEncodeTypeEnum.WITH_CODE.getValue().equals(epPo.getEpEncodeType())){
					String scopeCityCode = ScopeCityEnum.QG.getValue();
					if(!pcVO.getServiceType().equals(ServiceTypeEnum.NATION_WIDE.getValue())){
						Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(purchasePo.getChargeTelDetail());
						scopeCityCode = scopeMap.get("scopeCityCode").toString();
					}
//					String scopeCityCode = StringHelper.isNotEmpty(chargeTelDetail)?PurchaseUtil.getScopeCityByCarrier(chargeTelDetail).get("scopeCityCode").toString():null;
					dataPo = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), Integer.parseInt(purchasePo.getPgId())));
				}else{
					dataPo = productCodeAO.getOneProductCodeByPg(Integer.parseInt(purchasePo.getPgId()));
				}
//				dataPo = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode,channel.getEpId(), Integer.parseInt(purchasePo.getPgId())));
				if(dataPo == null){
					logger.config("编码未配置");
					System.out.println("编码未配置");
					return "产品待更新，产品暂不支持购买！！";
				}
//			}
		}else{
			logger.config("通道不存在");
			System.out.println("通道不存在");
			return "产品待更新，产品暂不支持购买！！";
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
		Boolean isChannelStateCanceled = channel.getChannelState() == ChannelStateEnum.CLOSE.getValue();
		if(isChannelStateCanceled){
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
					chargeAccountPo.setAccountBalance(agencyAfterBalance);
					chargeAccountAO.updateAccount(chargeAccountPo);
					int addRec = chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
							agencyBeforeBalance, agencyAfterBalance, 
							AccountTypeEnum.DECREASE.getValue(), accountId, pcVO.getChargeFor() , orderId));
//					purchasePo.setOrderResult(OrderStateEnum.CHARGING.getValue());
//					purchasePo.setOrderResultDetail(OrderStateEnum.CHARGING.getDesc());
					purResult = purchaseDAO.addPurchase(purchasePo);
					if(addRec > 0){
						Long recordId = chargeRecordDao.nextId() -1;
//						orderResult = OrderStateEnum.CHARGING.getValue();
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
				recordRes = chargeAccountAO.updateAccount(chargeAccountPo);
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
					ap_accountPo  = chargeAccountDao.getRootAccountById(contextAccountId, apBillType) ;//重置为父级代理商的账户（无论是对公和对私都是有的）
					apAccountId = ap_accountPo.getId();
					
					/**业务判断和添加**/
					/**充值额（）*/
					/**充值前余额*/
					agencyBeforeBalance = ap_accountPo.getAccountBalance();
					/**父费率减去子费率乘以价格，就是差价*/
					balance = NumberTool.mul(NumberTool.sub(ratePo1.getActiveDiscount(), activeRatePo.getActiveDiscount()), chargeValue);
					ap_accountPo.addBalance(balance,1);
					/** 更新父级代理商账户信息**/
					recordRes = chargeAccountAO.updateAccount(ap_accountPo);
					if(recordRes > 0){
						/** 向消费记录表插入登陆用户数据 */
						Double plusAmount = NumberTool.mul(ratePo1.getActiveDiscount(),chargeValue);
						Double minusAmount = NumberTool.mul(activeRatePo.getActiveDiscount(),chargeValue);
						agencyBeforeBalance = NumberTool.add(plusAmount, agencyBeforeBalance);	//重置充值前的余额为补款后的余额
						agencyAfterBalance = NumberTool.sub(agencyBeforeBalance,minusAmount);
						recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), minusAmount,
								agencyBeforeBalance, agencyAfterBalance, 
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
				//把超级管理员的记录加上
//						if(rootAgencyPo == null){
//							rootAgencyPo = agencyVODao.getRootAgencyById(contextAgencyId);
//							ap_agency_id = rootAgencyPo.getId();
//						}else{
//							ap_agency_id = rootAgencyPo.getRootAgencyId();
//						}
				String fromAgencyName = from_accountPo.getAgencyName();
				ChannelDiscountPo cdisPo = channelDiscountDao.get(ratePo1.getChannelDiscountId());
				billType = cdisPo.getBillType();
				
				ChargeAccountPo superAccountPo = chargeAccountDao.getRootAccountById(from_accountPo.getId(), billType);
				
				agencyBeforeBalance = superAccountPo.getAccountBalance();
				Double orderPrice = NumberTool.mul(chargeValue, ratePo1.getActiveDiscount());//价格
				orderAmount = NumberTool.mul(chargeValue, cdisPo.getChannelDiscount());//成本
				agencyBeforeBalance = NumberTool.add(agencyBeforeBalance, orderPrice);//之前加上价格
				agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
				superAccountPo.setAccountBalance(agencyAfterBalance);
				chargeAccountAO.updateAccount(superAccountPo);
				recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
						agencyBeforeBalance, agencyAfterBalance, 
						AccountTypeEnum.DECREASE.getValue(), superAccountPo.getId(),  pcVO.getChargeFor() , orderId));
				/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
				int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
				//ChannelDiscountPo cdPo = channelDiscountDao.get(ratePo.getChannelDiscountId());
				AccountPurchasePo app = new AccountPurchasePo(superAccountPo.getId(), orderId, cdisPo.getId(), orderAmount,from_accountPo.getId(),recordId, orderPrice, fromAgencyName, orderPath, orderState);
				app.setOrderStateDetail(orderStateDetail);
				app.setApDiscount(cdisPo.getChannelDiscount());
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
	
	@Transactional
	@Override
	public String ajaxCommitOrder(Long orderId,Integer accountId,String chargeTelDetail) {
		String res = "error";
		
//		ChannelDiscountPo cd = channelDiscountDao.getCDbyAP(orderId, accountId);
		
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
				//AgencyBackwardPo rootAgencyPo = agencyVODao.getRootAgencyById(accountPo.getAgencyId()) ;
				//默认都是二级代理商
				//boolean ifLackBalance = ;//rootAgencyPo != null
				//Long currentTime = System.currentTimeMillis();
				//int orderPath = OrderPathEnum.CHARGE_SOCKET.getValue();
				Integer orderResult = null;
				if(orderAmount > accountPo.getAccountBalance()){//订单价格大于余额
					logger.config("余额不足或者不是接口用户，下单失败");
					return "余额不足，下单失败";
//			resultMap.put("referURL", "/flowsys/chargePg/purchase_list.do?orderResult=2");
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
//					ChargeAccountPo superAccountPo = chargeAccountAO.getAccountByAgencyId(superAgencyId, cd.getBillType());
//					Double superOrderAmount = superApPo.getOrderAmount();//超管的成本
//					Double superAgencyBeforeBalance = superAccountPo.getAccountBalance();
//					/** 更新超管账户信息**/
//					superAccountPo.addBalance(superOrderAmount, -1);
//					int superAccountRes = chargeAccountAO.updateAccount(superAccountPo);
//					if(superAccountRes > 0){
//						//添加消费记录
//						chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), superOrderAmount,
//								superAgencyBeforeBalance, superAccountPo.getAccountBalance(), 
//								cd.getBillType(),AccountTypeEnum.DECREASE.getValue(), superAccountPo.getId(), superAgencyId, 1 , orderId));
//					}
//					charge = getChargeByDTO(chargeDTO,chargeParams,purchasePo);
//					if(charge!= null){
//						orderResultDetail = charge.getTipMsg();
//					}
						superApPo.setChannelDiscountId(cd.getId());//ap中的通道折扣id只对超级管理员有用
						superApPo.setApDiscount(cd.getChannelDiscount());
						superApPo.setOrderState(OrderStateEnum.CHARGING.getValue());
						superApPo.setOrderStateDetail(OrderStateEnum.CHARGING.getDesc());
						accountPurchaseDao.update(superApPo);
						logger.config("通道暂停后，再次提交");
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
				
//			if(!channelPo.getChannelState() == ChannelStateEnum.CLOSE.getValue()){
				ChargeDTO chargeDTO= null;
				String orderResultDetail = null;
//				Long lastOrderId = purchasePo.getOrderId();
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
				
//			BaseInterface bi = SingletonFactory.getSingleton(epPo.getEpEngId(), new BaseP(pc.getProductCode(),orderId,purchasePo.getChargeTel(),cd.getServiceType(),epPo));
//			ChargeDTO chargeDTO = bi.charge();
//			String orderIdApi = chargeDTO.getChargeOrder().getOrderIdApi();
//			logger.config("上游返回的订单号："+ orderIdApi);//防止自己系统向上提单了，而自己数据库又没有最新的数据。以便核实订单结果
//			purchasePo.setOrderIdApi(orderIdApi);
//			purchasePo.setOrderArriveTime(currentTime);
			}//费率存在
		}
			
		return res;
	}
	
//	@Override
//	public void purchaseByRate(Long rateId, Integer agencyId,
//			String fromAgencyName) {
//		// TODO Auto-generated method stub
//		
//	}
	
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
		}else if(PgServiceTypeEnum.TELCHARGE.getValue().equals(epFor)){
			bi = HSingletonFactory.getSingleton(epEngId, new BaseP(pc,purchasePo.getOrderId(),purchasePo.getChargeTel(),epPo,DateUtil.formatPramm(purchasePo.getOrderArriveTime(), "yyyy-MM-dd")));
		}
		
		if(bi != null){
//		long hourTimes = 60*60*1000;//小时/毫秒
//		long eighteenth = DateUtil.getEndTime().getTime() - hourTimes * 6 ;//当天18:00的毫秒数
//		if(System.currentTimeMillis())
//		System.out.println(DateUtil.formatAll(eighteenth));//当天的18:00
			
//			bi.getBalance()
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
//				PurchasePo purPo = new PurchasePo();
//				purPo.setOrderId(purchasePo.getOrderId());
//				purPo.setOrderIdApi(chargeDTO.getChargeOrder().getOrderIdApi());
//				purchaseDAO.updatePurchaseState(purPo);
				
				if(chargeDTO.getChargeOrder() != null){
//					System.out.println(chargeDTO.getChargeOrder().getOrderIdApi());//测试打印出对应平台的提单地址
					//logger.config("上游返回的订单号："+ chargeDTO.getChargeOrder().getOrderIdApi());//防止自己系统向上提单了，而自己数据库又没有最新的数据。以便核实订单结果
				}
			}
		}
//		ChargeDTO chargeDTO = bi.charge();
//		if(chargeDTO != null){
//			System.out.println(chargeDTO.getChargeOrder().getOrderIdApi());//测试打印出对应平台的提单地址
//			logger.config("上游返回的订单号："+ chargeDTO.getChargeOrder().getOrderIdApi());//防止自己系统向上提单了，而自己数据库又没有最新的数据。以便核实订单结果
////			int upRes = 0;
////			if(upRes > 0){
////			if(chargeDTO.getTipCode().equals(OrderStateEnum.CHARGING.getValue())){
////				updatePurchase(chargeDTO, orderId);
////			}
////				return "订单添加成功";
////			}
//		}
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
			
			
//			Long startTime = null;
//			Long endTime = null;
//			Long dateUtilStartTime = DateUtil.getStartTime().getTime();
//			Long dateUtilEndTime = DateUtil.getEndTime().getTime();
			if(isCharged){
				if(StringHelper.isNotEmpty(purchaseVO.getBackStartTimeStr())){
					long startTime = DateUtil.strToDate(purchaseVO.getBackStartTimeStr(), null).getTime();
					paramsMap.put("startTimeBack", startTime);
				}
				if(StringHelper.isNotEmpty(purchaseVO.getBackEndTimeStr())){
					long endTime = DateUtil.strToDate(purchaseVO.getBackEndTimeStr(), null).getTime();
					paramsMap.put("endTimeBack", endTime);
				}
			}else{
				if(StringHelper.isNotEmpty(purchaseVO.getArriveStartTimeStr())){
					long startTime = DateUtil.strToDate(purchaseVO.getArriveStartTimeStr(), null).getTime();
					paramsMap.put("startTime", startTime);
				}
				if(StringHelper.isNotEmpty(purchaseVO.getArriveEndTimeStr())){
					long endTime = DateUtil.strToDate(purchaseVO.getArriveEndTimeStr(), null).getTime();
					paramsMap.put("endTime", endTime);
				}
			}
			
//			if(isCharged){//充值成功列表使用充值时间查询
////				if(purchaseVO.getBackStartTimeStr() == null){//默认打开列表
////					paramsMap.put("startTimeBack", dateUtilStartTime);
////				}else if("".equals(purchaseVO.getBackStartTimeStr())){
////					paramsMap.put("startTimeBack", dateUtilStartTime);
////				}
//				
//				if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){
//					paramsMap.put("startTimeBack", dateUtilStartTime);
//				}
//				else{
//					startTime = DateUtil.strToDate(purchaseVO.getBackStartTimeStr(), null).getTime();
//					paramsMap.put("startTimeBack", startTime);
//				}
//				
//				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){//默认打开列表
//					paramsMap.put("endTimeBack", dateUtilEndTime);
//				}else{
//					endTime = DateUtil.strToDate(purchaseVO.getBackEndTimeStr(), null).getTime();
//					paramsMap.put("endTimeBack", endTime);
//				}
//			}else{//其他状态使用订单到达时间
////				if(purchaseVO.getArriveStartTimeStr() == null){//默认打开列表
////					paramsMap.put("startTime", dateUtilStartTime);
////				}else if("".equals(purchaseVO.getArriveStartTimeStr())){
////					paramsMap.put("startTime", null);
////				}
//				if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){
//					paramsMap.put("startTime", dateUtilStartTime);
//				}
//				else{
//					startTime = DateUtil.strToDate(purchaseVO.getArriveStartTimeStr(), null).getTime();
//					//System.out.println(purchaseVO.getArriveStartTimeStr());
//					paramsMap.put("startTime", startTime);
//				}
//				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){//默认打开列表
//					paramsMap.put("endTime", dateUtilEndTime);
//				}else{
//					endTime = DateUtil.strToDate(purchaseVO.getArriveEndTimeStr(), null).getTime();
//					paramsMap.put("endTime", endTime);
//				}
//			}
////			paramsMap.put("isCharged", isCharged);
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
//						if(purchaseEp == null){
//							purchaseEp = exchangePlatformDao.getEpByCDiscountId(purchaseVO2.getChannelDiscountId());
//						}
						if(purchaseEp != null){
							boolean negCallBack = CallBackEnum.NEGATIVE.getValue().equals(purchaseEp.getEpCallBack());
							if(negCallBack){//不支持回调就用主动查询，查询订单状态
								//BaseInterface bi = SingletonFactory.getSingleton(purchaseEp.getEpEngId(), new BaseP(null,purchaseVO2.getOrderIdApi(),purchaseVO2.getChargeTel(),null,purchaseEp));//查订单状态用api订单号对象去查
								BaseInterface bi = null;
								Integer epFor = purchaseEp.getEpFor();
								String epEngId = purchaseEp.getEpEngId();
								Long orderId = purchaseVO2.getOrderId();
								if(PgServiceTypeEnum.PGCHARGE.getValue().equals(epFor)){//调用流量接口仓库
//									PurchasePo purPo = new PurchasePo();
//									purPo.setOrderId(purchaseVO2.getOrderId());
//									purPo.setOrderIdApi(purchaseVO2.getOrderIdApi());
//									purPo.setChargeTel(purchaseVO2);
									BaseP baseP = new BaseP(null,purchaseVO2.getOrderIdApi(),purchaseVO2.getChargeTel(),purchaseEp,DateUtil.formatPramm(purchaseVO2.getOrderArriveTime(), "yyyy-MM-dd"));
									baseP.setOrderId(orderId);
									bi = SingletonFactory.getSingleton(epEngId, baseP);
								}else if(PgServiceTypeEnum.TELCHARGE.getValue().equals(epFor)){
									bi = HSingletonFactory.getSingleton(epEngId, new BaseP(null,purchaseVO2.getOrderIdApi(),purchaseVO2.getChargeTel(),purchaseEp,DateUtil.formatPramm(purchaseVO2.getOrderArriveTime(), "yyyy-MM-dd")));
								}
								
//								OrderDTO orderDTO = bi.getOrderState();
								//是否需要更新订单状态条件
								if(bi != null){
									if(bi.getOrderState() == null){
										//更新订单表
										purchaseDAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, System.currentTimeMillis(), null, null, ChargeStatusEnum.API_ERROR.getDesc()+"查询状态"));//purchaseVO2.getOrderId(), System.currentTimeMillis(), orderIn.getStatus(), orderIn.getMsg(), null
									}else{
										OrderDTO orderDTO = bi.getOrderState();
										OrderIn orderIn = orderDTO.getOrderIn();
										boolean updateCondition = orderIn!= null && !purchaseVO2.getOrderResult().equals(orderIn.getStatus());
										if(updateCondition){
											//更新订单状态//返回状态和原先数据库状态不相符
	//										Long ts = orderIn.getCreated_at_time();
											Long ts = System.currentTimeMillis();
											
											int orderState = orderIn.getStatus();
											String orderStateDetail = orderIn.getMsg();
		//									if(agencyAO.getRootAgencyByAccountId(purchaseVO.getAccountId()) != null){//不是超管,重置订单状态
		//										OrderIn cloneOrderIn = orderIn.clone();
		//										resetPurchaseState(cloneOrderIn);
		//										orderState = cloneOrderIn.getStatus();
		//										orderStateDetail = cloneOrderIn.getMsg();
		//									}
											purchaseVO2.setOrderBackTimeStr(DateUtil.formatAll(ts));
											purchaseVO2.setOrderState(orderState);
											purchaseVO2.setOrderStateDetail(orderStateDetail);
											String res = accountPurchaseAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, ts, orderState, null, orderStateDetail));//purchaseVO2.getOrderId(), orderState, orderStateDetail,ts
											System.out.println("更新订单状态数据库结果："+res);
											//把查询的结果利用接口推给下游
	//										AgencyBackwardPo agencyPo = agencyAO.getAgencyByAccountId(accountId);
	//										if(agencyPo != null && StringHelper.isNotEmpty(agencyPo.getCallBackIp())){//下游有回调地址的情况下，按照回调地址推送
	//											String callBackRes = sendCallBack.sendCallBack(new ResponseJsonDTO(purchaseVO2.getOrderId(), purchaseVO2.getOrderIdFrom(), orderState, orderStateDetail, ts), agencyPo.getCallBackIp());
	//											System.out.println(agencyPo.getUserName() + "：" +purchaseVO2.getOrderId() + "：" +  callBackRes);
	//										}
											//更新订单表
											purchaseDAO.updatePurchaseState(new PurchasePo(purchaseVO2.getOrderId(), null, System.currentTimeMillis(), orderIn.getStatus(), OrderResultEnum.SUCCESS.getCode(), orderIn.getMsg()));//purchaseVO2.getOrderId(), System.currentTimeMillis(), orderIn.getStatus(), orderIn.getMsg(), null
										}
	//										accountPurchaseAO.updatePurchaseState(purchaseVO2.getOrderId(), orderIn.getStatus(), orderIn.getMsg(),System.currentTimeMillis());
										
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
//				if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){
//					paramsMap.put("startTimeBack",null);
//				}
				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(currentTime));
					paramsMap.put("endTimeBack", currentTime);
				}
			}else{//其他列表
				paramsMap.put("startTime",null);
				purchaseVO.setArriveStartTimeStr("");
//				if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){
//					paramsMap.put("startTime",null);
//					//purchaseVO.setArriveStartTimeStr(null);
//				}
				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
					paramsMap.put("endTime", currentTime);
					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(currentTime));
				}
			}
			totalRecord = purchaseDAO.countPurchase(paramsMap);//重置订单数量
		}
//		else{//有记录条件下，设置页面参数
//			Long dateUtilStartTime = null;
//			Long dateUtilEndTime = null;
//			if(isCharged){
////				if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){
////					dateUtilStartTime = Long.parseLong(paramsMap.get("startTimeBack").toString());
////					purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
////				}
//				if(purchaseVO.getBackStartTimeStr() == null){
//					dateUtilStartTime = Long.parseLong(paramsMap.get("startTimeBack").toString());
//					purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//				}else if("".equals(purchaseVO.getBackStartTimeStr().trim())){
////					paramsMap.put("startTimeBack", dateUtilStartTime);
////					dateUtilStartTime = DateUtil.getStartTime().getTime();
////					purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//					paramsMap.put("startTimeBack",null);
//				}
//				//purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
////				if(purchaseVO.getBackStartTimeStr() == null){
////					dateUtilStartTime = Long.parseLong(paramsMap.get("startTimeBack").toString());
////					purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
////				}else if("".equals(purchaseVO.getBackStartTimeStr().trim())){
////					//为空或者值重新设置	
////					paramsMap.put("startTimeBack", null);
////					totalRecord = purchaseDAO.countPurchase(paramsMap);
////				}
//				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
//					dateUtilEndTime = Long.parseLong(paramsMap.get("endTimeBack").toString());
//					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
//				}
//			}else{
////				if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){
////					dateUtilStartTime = Long.parseLong(paramsMap.get("startTime").toString());
////					purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
////				}
//				if(purchaseVO.getArriveStartTimeStr() == null){
//					dateUtilStartTime = Long.parseLong(paramsMap.get("startTime").toString());
//					purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//				}else if("".equals(purchaseVO.getArriveStartTimeStr().trim())){
////					dateUtilStartTime = DateUtil.getStartTime().getTime();
////					paramsMap.put("startTime", dateUtilStartTime);
////					purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//					paramsMap.put("startTime",null);
//				}
////				else{
//					//为空或者值重新设置:什么都不需要做，因为已经有记录，并且在第一次搜索的时候，就已经重置了搜索条件
////					if("".equals(purchaseVO.getArriveStartTimeStr().trim())){
////						//paramsMap.put("startTime", null);
////						totalRecord = purchaseDAO.countPurchase(paramsMap);
////					}
////				}
//				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
//					dateUtilEndTime = Long.parseLong(paramsMap.get("endTime").toString());
//					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
//				}
//			}
//			totalRecord = purchaseDAO.countPurchase(paramsMap);
//		}
		return totalRecord;
	}

	/** 初始化页面查询参数
	 * @param purchaseVO 初始化对象
	 * @param paramsMap 初始化数据源
	 */
//	private void initVO(PurchaseVO purchaseVO, Map<String, Object> paramsMap) {
//		Boolean isChargedList =  purchaseVO.getOrderResult() != null && purchaseVO.getOrderResult() == OrderStateEnum.CHARGED.getValue();
//		Long dateUtilStartTime = null;
//		Long dateUtilEndTime = null;
//		if(isChargedList){
//			if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){
//				dateUtilStartTime = Long.parseLong(paramsMap.get("startTimeBack").toString());
//				purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//			}
//			if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
//				dateUtilEndTime = Long.parseLong(paramsMap.get("endTimeBack").toString());
//				purchaseVO.setBackEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
//			}
//		}else{
//			if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){
//				dateUtilStartTime = Long.parseLong(paramsMap.get("startTime").toString());
//				purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
//			}
//			if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
//				dateUtilEndTime = Long.parseLong(paramsMap.get("endTime").toString());
//				purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(dateUtilStartTime));
//			}
//		}
//	}

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
	 * @description:   更新查看订单状态
	 * @param pageOrder
	 * @param purchaseVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午12:57:18
	 */
//	@Override
//	public int checkOrderState(PageOrder pageOrder, PurchaseVO purchaseVO) {
//		int updateRes = 0;
//		if(purchaseVO.getOrderResult() != pageOrder.getStatus())
//		{
//			purchaseVO.setOrderResult(pageOrder.getStatus());
//			//如果过
//			if(StringHelper.isEmpty(pageOrder.getMsg())){
//				for (OrderStateEnum enumt : OrderStateEnum.values()) {
//					if(pageOrder.getStatus() == enumt.getValue())
//					{
//						purchaseVO.setOrderResultDetail(enumt.getDesc());
//						break;
//					}
//				}
//			}else{
//				purchaseVO.setOrderResultDetail(pageOrder.getMsg());
//			}
//			String created_at_api = pageOrder.getCreated_at();
//			purchaseVO.setOrderBackTimeStr(created_at_api);
//			updateRes = purchaseDAO.updatePurchaseState(new PurchaseStateParams(purchaseVO.getOrderId(), DateUtil.strToDate(created_at_api, "").getTime() , purchaseVO.getOrderResult(), purchaseVO.getOrderResultDetail(),pageOrder.getTransaction_id()));
//		}
//		return updateRes;
//	}

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
		//searchMap.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
		List<ChargeChannelPo> channelList = channelChannelDao.list_charge_channel(searchMap);
//		if(channelList != null && channelList.size()==1){//只有一条通道的时候，可以默认加载这条通道的包体
//			Map<String, Object> objMap = new HashMap<String, Object>();
//			Long cId = channelList.get(0).getId();
//			objMap.put("cnelId", cId);
//			objMap.put("operatorType", ccpp.getOperatorType());
//			objMap.put("serviceType", ccpp.getServiceType());
//			List<OperatorPgDataPo> pgList = operatorPgDao.listPgListInPcode(objMap);
//			channelList.get(0).setList(pgList);
//		}
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
//		OperatorPgDataPo operatorPgPo = new OperatorPgDataPo();
//		operatorPgPo.setOperatorType(operatorType);
		objMap.put("operatorType", operatorType);
//		objMap.put("channelId", ccpp.getChannelId());
		
		if(ServiceTypeEnum.NATION_WIDE.getValue() != ccpp.getServiceType()){
			Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(carrier);
			if(scopeMap.get("scopeCityCode") != null){
				objMap.put("scopeCityCode", scopeMap.get("scopeCityCode").toString());
			}
		}
		objMap.put("serviceType", ccpp.getServiceType());
//		if(ccpp.getBillType() != null){
//			objMap.put("billType", ccpp.getBillType());
//		}
		
		List<OperatorPgDataPo> pgList = operatorPgDao.pgList_forPurchase(objMap);
//		List<OperatorPgDataPo> pgList = operatorPgDao.getPgByChanel(objMap);
		return pgList;
	}

	@Override
	public List<PgDataPo> getPgByChanel(ChargeChannelParamsPo ccpp) {
//		Map<String, Object> objMap = new HashMap<String, Object>();
//		String carrier = ccpp.getCarrier();
//		if(StringHelper.isNotEmpty(carrier)){
//			int operatorType = OperatorTypeEnum.getValueByDesc(carrier.substring(carrier.length()-2));
//			objMap.put("operatorType", operatorType);
//			if(ServiceTypeEnum.NATION_WIDE.getValue() != ccpp.getServiceType()){
//				Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(carrier);
//				if(scopeMap.get("scopeCityCode") != null){
//					objMap.put("scopeCityCode", scopeMap.get("scopeCityCode").toString());
//				}
//			}
//		}
//		if(ccpp.getChannelId() != null){
//			objMap.put("channelId", ccpp.getChannelId());
//		}
//		objMap.put("serviceType", ccpp.getServiceType());
//		List<PgDataPo> pgList = operatorPgDao.getPgByChanel(objMap);
//		return pgList;
		return null;
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
//		String res = "success";
//		while(res.equals("success")){
//			
//			res = ajaxCommitOrder(purchaseVO2.getOrderId(), purchaseVO2.getAccountId(), purchaseVO2.getChargeTelDetail());
//		}
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
//		String res = "success";
//		while(res.equals("success")){
//			
//			res = ajaxCommitOrder(purchaseVO2.getOrderId(), purchaseVO2.getAccountId(), purchaseVO2.getChargeTelDetail());
//		}
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
			List<PurchaseVO> records = new ArrayList<PurchaseVO>();
			if(dataMap.get("records") != null){
				records = (List<PurchaseVO>)dataMap.get("records");
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

//					else if (r.getTradeType().equals("2"))
//					{
//						tradeType = "补款";
//					}
					// 充值号码
					hRow.createCell(2).setCellValue(r.getChargeTel());
//
//					if (r.getTradeType().equals("2") || r.getTradeType().equals("3"))
//					{
//						tradeNo = r.getTradeId() + "";
//					}
//					else
//					{
//						tradeNo = r.getTradeNo();
//					}
					//包体大小
					hRow.createCell(3).setCellValue(r.getPgSize());

					//"面值", "折扣", "扣款金额" , "代理商订单号", "订单完成时间
				
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

//				hRow = hSheet.createRow(i + 1);
//
//				hRow.createCell(0).setCellValue("实付金额：" + returnMap.get("alreadyPayAmt"));
//				hRow.createCell(1).setCellValue("应付金额：" + returnMap.get("shouldPayAmt"));
//				hRow.createCell(2).setCellValue("冻结金额：" + returnMap.get("freezingAmount"));
//				hRow.createCell(3).setCellValue("金额期初：" + returnMap.get("preAmt"));
//				hRow.createCell(4).setCellValue("可用金额：" + returnMap.get("userfulAmount"));
//
//				Map<String, Object> params = new HashMap<String, Object>();
//				params.put("memberId", memberId);
//				Pagination<InvoiceAccount> invoiceAccountPage = invoiceAccountService.queryPageInvoiceAccount(new PageParam(1, 15), params);
//
//				if (invoiceAccountPage != null && invoiceAccountPage.getTotalCount() > 0)
//				{
//					InvoiceAccount a = invoiceAccountPage.getRecordList().get(0);
//					String preInvoiceRecord = VelocityTool.getPreInvoiceRecord(a.getMemberId());
//
//					hRow.createCell(5).setCellValue("应收票额：" + NumberTool.formatNumber(a.getPreBalance(), "###,###,##0.00"));
//					hRow.createCell(6).setCellValue("已收票额：" + NumberTool.formatNumber(NumberUtils.sub(a.getBalance(), NumberUtils.parseDouble(preInvoiceRecord)), "###,###,##0.00"));
//					hRow.createCell(7).setCellValue("票额期初：" + NumberTool.formatNumber(NumberUtils.parseDouble(preInvoiceRecord), "###,###,##0.00"));
//					hRow.createCell(8).setCellValue("欠票票额：" + NumberTool.formatNumber(NumberUtils.sub(a.getPreBalance(), a.getBalance()), "###,###,##0.00"));
//				}
			
			return hbook;
			}
	
}
