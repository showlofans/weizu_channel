package com.weizu.flowsys.web.trade.ao;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.OrderIn;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.api.singleton.orderState.ResponseJsonDTO;
import com.weizu.flowsys.api.singleton.orderState.SendCallBackUtil;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
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
import com.weizu.flowsys.web.channel.dao.OperatorPgDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.http.ParamsEntityWeiZu;
import com.weizu.flowsys.web.http.weizu.OrderStateResult;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.pojo.TotalResult;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

@Service(value="purchaseAO")
public class PurchaseAOImpl implements PurchaseAO {

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
//	@Resource
//	private AgencyAO agencyAO;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
	@Resource
	private AgencyPurchaseDao agencyPurchaseDao;
	@Resource
	private AgencyPurchaseAO agencyPurchaseAO;
	
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
		return new PurchasePo(pcVO.getChargeTel(), pcVO.getPgId(), pcVO.getChargeTelDetail());
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
	public String purchase(PgChargeVO pcVO, Integer ap_agency_id) {
		/****************完成对所有上级代理商包括自己的订单与代理商的绑定********************/
		//已经当前登陆用户余额充足，开始充值流程
		//在订单信息完全添加完之后，再调用接口进行充值
		//先添加一个基本的，再批量添加父级代理商和订单的绑定
		PurchasePo purchasePo = initPurchase(pcVO);
		int agencyId = pcVO.getAgencyId();		//订单产生方代理商
		int orderResult = OrderStateEnum.CHARGING.getValue();		//默认订单状态
		int purResult = 0;
//		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(pcVO.getServiceType(), pcVO.getChargeTelDetail(), agencyId);
		int chargeRes = -1;			//充值状态
		/**充值前余额*/
		double agencyBeforeBalance = 0d;
		/**充值额（）*/
		Double orderAmount = null;
		
		double agencyAfterBalance = 0d;
		
		/**包体原价*/
		Double pgPrice = pcVO.getPgPrice();
		ChannelChannelPo channel = channelChannelDao.get(new WherePrams("id", "=", pcVO.getChannelId()));
		ExchangePlatformPo epPo = null;
		ProductCodePo dataPo = null;
		String orderStateDetail = "";
		if(channel != null){
			boolean isChannelUseStateStoped = channel.getChannelUseState() == ChannelUseStateEnum.CLOSE.getValue();//通道状态停止
			if(isChannelUseStateStoped){//通道使用状态暂停，不能提单
				logger.config("通道使用状态暂停");
				return "产品待更新，产品暂不支持购买！！";
			}else{
				epPo = exchangePlatformAO.getEpById(channel.getEpId());
				Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(purchasePo.getChargeTelDetail());
				String scopeCityCode = scopeMap.get("scopeCityCode").toString();
				dataPo = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode,channel.getEpId(), purchasePo.getPgId()));
				if(dataPo == null){
					logger.config("编码未配置");
					return "产品待更新，产品暂不支持购买！！";
				}
			}
		}else{
			logger.config("通道不存在");
			return "产品待更新，产品暂不支持购买！！";
		}
		Long orderId = null;
		Long currentTime = System.currentTimeMillis();
		try {
			OrderUril ou1 = new OrderUril(1);
			orderId = ou1.nextId();
			purchasePo.setOrderId(orderId);//设置订单号
			purchasePo.setOrderAmount(pcVO.getOrderAmount());
			purchasePo.setAgencyId(pcVO.getAgencyId());
			purchasePo.setOrderArriveTime(currentTime);
			purchasePo.setOrderResult(orderResult);
			purchasePo.setChannelName(channel.getChannelName());;
			//					Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
			//					 String chargeTelCity = null;
			//					 if(telMap != null)
			//					{
			//						chargeTelCity = telMap.get("chargeTelCity").toString();
			//					}
			//					purchasePo.setChargeTelCity(chargeTelCity);
			purResult = purchaseDAO.addPurchase(purchasePo);
		} catch (Exception e) {
			e.printStackTrace();
			return "订单添加异常";
		}
//		if(pcVO.getRateId() == null && pcVO.getCdisId() == null){
//			//在测试通道页面上，充值通道暂停，就直接返回通道暂停
//			if(channel.getChannelState() == ChannelStateEnum.CLOSE.getValue()){
////				orderResult = OrderStateEnum.DAICHONG.getValue();
////				orderStateDetail = "通道暂停等待";
//				return "充值失败，通道暂停";
//			}
//			//通过通道折扣充值
//			String fromAgencyName = pcVO.getFromAgencyName();
//			/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
//			int orderPath = OrderPathEnum.WEB_PAGE.getValue();
//			int billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();//默认对私
//			ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyId, billType);
//			agencyBeforeBalance = accountPo.getAccountBalance();
//			orderAmount = pcVO.getOrderAmount();//成本
//			agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
//			accountPo.setAccountBalance(agencyAfterBalance);
//			chargeAccountAO.updateAccount(accountPo);
//			chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
//				agencyBeforeBalance, agencyAfterBalance, 
//				billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId, 1 , orderId));
//			
//			AgencyPurchasePo app = new AgencyPurchasePo(agencyId, orderId,null, orderAmount, billType, orderAmount, fromAgencyName, orderPath, orderResult);
//			int aarAdd = agencyPurchaseDao.add(app);
//			if(aarAdd > 0){
//				return chargeByBI(epPo, orderId, pcVO, dataPo.getProductCode());
//			}
//		}else 
		if(pcVO.getRateId() == null && pcVO.getCdisId() != null){//通过通道折扣充值
			String fromAgencyName = pcVO.getFromAgencyName();
			ChannelDiscountPo cdisPo = null;
			if(pcVO.getCdisId() != null){
				cdisPo = channelDiscountDao.get(pcVO.getCdisId());
			}else{
				logger.config("通道折扣缺失");
			}
			int billType = cdisPo.getBillType();
			/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
			int orderPath = OrderPathEnum.WEB_PAGE.getValue();
			if(channel.getChannelState() == ChannelStateEnum.CLOSE.getValue()){//通道暂停，把系统级用户的订单状态设置为充值等待
//				orderResult = OrderStateEnum.DAICHONG.getValue();
//				orderStateDetail = "通道暂停等待";
				return "充值失败，通道暂停";
			}else{
				ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyId, billType);
				agencyBeforeBalance = accountPo.getAccountBalance();
				orderAmount = NumberTool.mul(pgPrice, cdisPo.getChannelDiscount());//成本
				agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
				accountPo.setAccountBalance(agencyAfterBalance);
				chargeAccountAO.updateAccount(accountPo);
				chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
						agencyBeforeBalance, agencyAfterBalance, 
						billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId, 1 , orderId));
//					try {
//						OrderUril ou1 = new OrderUril(1);
//						orderId = ou1.nextId();
//						purchasePo.setOrderId(orderId);//设置订单号
//						purchasePo.setAgencyId(pcVO.getAgencyId());
//						purchasePo.setOrderArriveTime(currentTime);
//						purchasePo.setOrderResult(orderResult);
//						purchasePo.setChannelId(channel.getId());
//						//					Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
//						//					 String chargeTelCity = null;
//						//					 if(telMap != null)
//						//					{
//						//						chargeTelCity = telMap.get("chargeTelCity").toString();
//						//					}
//						//					purchasePo.setChargeTelCity(chargeTelCity);
//						purResult = purchaseDAO.addPurchase(purchasePo);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
			}
			AgencyPurchasePo app = new AgencyPurchasePo(agencyId, orderId,pcVO.getCdisId(), orderAmount, billType, orderAmount, fromAgencyName, orderPath, orderResult);
			int aarAdd = agencyPurchaseDao.add(app);
			if(aarAdd > 0){
				return chargeByBI(epPo, orderId, pcVO, dataPo.getProductCode());
			}
		}else{//页面通过费率折扣充值
//			RateDiscountPo ratePo2 = rateDiscountAO.getRateForCharge(pcVO.getServiceType(), pcVO.getChargeTelDetail(), agencyId);
			RateDiscountPo ratePo = rateDiscountDao.get(pcVO.getRateId());
			if(ratePo != null){
				int billType = ratePo.getBillType();//票务全部使用费率配置的票务
				//更新消费记录表（先更新账户余额，再更新订单，最后更新记录）
				ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyId, billType);
				
				/**账户信息的更新结果*/
				int recordRes = 0;
				
				boolean isSupperAgency = agencyVODao.getRootAgencyById(agencyId) != null ;//不是超管
				//在二级代理商的情况下才去判断余额
				boolean ifLackBalance = isSupperAgency && pcVO.getOrderAmount() > accountPo.getAccountBalance();
				if(ifLackBalance){//订单价格大于余额
					return "余额不足，下单失败";
//				resultMap.put("referURL", "/flowsys/chargePg/purchase_list.do?orderResult=2");
				}else{
					/**充值前余额*/
					agencyBeforeBalance = accountPo.getAccountBalance();
					/**充值额（）*/
					orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), pgPrice);
					accountPo.addBalance(orderAmount,-1);
					/** 更新登录用户账户信息**/
					recordRes = chargeAccountAO.updateAccount(accountPo);
					if(recordRes > 0){
//						try {
//							OrderUril ou1 = new OrderUril(1);
//							orderId = ou1.nextId();
//							purchasePo.setOrderId(orderId);//设置订单号
//							purchasePo.setAgencyId(pcVO.getAgencyId());
//							purchasePo.setOrderArriveTime(currentTime);
//							purchasePo.setOrderResult(orderResult);
//							purchasePo.setChannelId(ratePo.getChannelId());
//							//					Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
//							//					 String chargeTelCity = null;
//							//					 if(telMap != null)
//							//					{
//							//						chargeTelCity = telMap.get("chargeTelCity").toString();
//							//					}
//							//					purchasePo.setChargeTelCity(chargeTelCity);
//							purResult = purchaseDAO.addPurchase(purchasePo);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
						Long rateDiscountId = ratePo.getId();			//折扣id
						
						if(purResult > 0){//开始把第一个消费记录，连接加上，
							/** 向消费记录表插入登陆用户数据 */
//							Long nextIdRecord = chargeRecordDao.nextId();
							chargeRecordDao.add(new ChargeRecordPo(currentTime, orderAmount,
									agencyBeforeBalance, accountPo.getAccountBalance(), 
									billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId, 1 , orderId));
							/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
							int orderPath = OrderPathEnum.WEB_PAGE.getValue();
							AgencyPurchasePo app = new AgencyPurchasePo(ap_agency_id, orderId, rateDiscountId, orderAmount, billType, orderAmount, pcVO.getFromAgencyName(), orderPath, orderResult);
							int aapAddRes = agencyPurchaseDao.add(app);
						}
					}else{
						logger.config("更新账户表失败");
					}
					// 开始迭代添加父级代理商的账户扣款和消费记录，以及批量添加父级代理商和订单的绑定
					if(purResult > 0){//订单添加好了,开始迭代添加父级代理商的账户扣款和消费记录
						chargeRes = OrderResultEnum.SUCCESS.getCode();		//在全部上级都添加完了之后返回成功;
						List<AgencyPurchasePo> apPoList = new LinkedList<AgencyPurchasePo>();
						List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
						
						RateDiscountPo activeRatePo = null;		//父级费率对象
						RateDiscountPo ratePo1 = ratePo;		//子级费率对象
						
						AgencyBackwardPo rootAgencyPo = null;	//父级代理商实体
						AgencyBackwardPo agencyPo = null;	//子级代理商实体
						
						//得到当前代理商和折扣的绑定实体，
						//然后根据父级得到父级折扣
						int contextAgencyId = agencyId ;		//子级代理商id
						
						//得到当前代理商和折扣的绑定实体，
						//然后根据父级得到父级折扣
						int whileStop = 0;
//						Long orderId = purchasePo.getOrderId();
						Double balance = 0d;//差额:父费率减去子费率乘以价格
						while(ratePo1.getActiveId() != null){//没有找到第二级代理商，开始添加代理商和订单
							
							//重置ratePo为父级费率折扣;不为空
							//查询父级操作对象
							activeRatePo = rateDiscountDao.get(ratePo1.getActiveId());		
							rootAgencyPo = agencyVODao.getRootAgencyById(agencyId);
							ap_agency_id = rootAgencyPo.getId();
							agencyPo = agencyVODao.get(agencyId);
							String fromAgencyName = agencyPo.getUserName();
							accountPo  = chargeAccountDao.selectByAgencyId(rootAgencyPo.getId(), activeRatePo.getBillType());//重置为父级代理商的账户（无论是对公和对私都是有的）
							/**业务判断和添加**/
							/**充值额（）*/
							/**充值前余额*/
							agencyBeforeBalance = accountPo.getAccountBalance();
							/**父费率减去子费率乘以价格，就是差价*/
							balance = NumberTool.mul(NumberTool.sub(ratePo1.getActiveDiscount(), activeRatePo.getActiveDiscount()), pgPrice);
							accountPo.addBalance(balance,1);
							/** 更新父级代理商账户信息**/
							recordRes = chargeAccountAO.updateAccount(accountPo);
							if(recordRes > 0){
								/** 向消费记录表插入登陆用户数据 */
//							Long currentTime = System.currentTimeMillis();
								Double plusAmount = NumberTool.mul(ratePo1.getActiveDiscount(),pgPrice);
								Double minusAmount = NumberTool.mul(activeRatePo.getActiveDiscount(),pgPrice);
//							agencyAfterBalance = NumberTool.add(agencyBeforeBalance,plusAmount);
//							recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), plusAmount,
//									agencyBeforeBalance, agencyAfterBalance, 
//									ratePo1.getBillType(),AccountTypeEnum.Replenishment.getValue(), accountPo.getId(), ap_agency_id,1, orderId));
								agencyBeforeBalance = NumberTool.add(plusAmount, agencyBeforeBalance);	//重置充值前的余额为补款后的余额
								agencyAfterBalance = NumberTool.sub(agencyBeforeBalance,minusAmount);
								recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), minusAmount,
										agencyBeforeBalance, agencyAfterBalance, 
										activeRatePo.getBillType(),AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), ap_agency_id,1, orderId));	
								int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
								AgencyPurchasePo app = new AgencyPurchasePo(ap_agency_id, orderId, activeRatePo.getId(), minusAmount, activeRatePo.getBillType(), plusAmount, fromAgencyName, orderPath, orderResult);
								apPoList.add(app);
							}
							//由父变成子，进行迭代
							ratePo1 = activeRatePo;	
							agencyId = ap_agency_id;
						}
						
//						if(channel.getChannelState() == ChannelStateEnum.CLOSE.getValue()){//通道暂停，把系统级用户的订单状态设置为充值等待
//							orderResult = OrderStateEnum.DAICHONG.getValue();
//							orderStateDetail = "通道暂停等待";
//						}
						//把超级管理员的记录加上
						if(rootAgencyPo == null){
							rootAgencyPo = agencyVODao.getRootAgencyById(agencyId);
							ap_agency_id = rootAgencyPo.getId();
						}else{
							ap_agency_id = rootAgencyPo.getRootAgencyId();
						}
						String fromAgencyName = pcVO.getFromAgencyName();
						ChannelDiscountPo cdisPo = channelDiscountDao.get(ratePo1.getChannelDiscountId());
						billType = cdisPo.getBillType();
						
						accountPo = chargeAccountAO.getAccountByAgencyId(ap_agency_id, billType);
						agencyBeforeBalance = accountPo.getAccountBalance();
						Double orderPrice = NumberTool.mul(pgPrice, ratePo1.getActiveDiscount());//价格
						orderAmount = NumberTool.mul(pgPrice, cdisPo.getChannelDiscount());//成本
//					agencyAfterBalance = NumberTool.add(agencyBeforeBalance, orderPrice);
//					recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), orderPrice,
//							agencyBeforeBalance, agencyAfterBalance, 
//							billType,AccountTypeEnum.Replenishment.getValue(), accountPo.getId(), ap_agency_id, 1 , orderId));
						
						agencyBeforeBalance = NumberTool.add(agencyBeforeBalance, orderPrice);//之前加上价格
						//agencyBeforeBalance = agencyAfterBalance;//把加之后的价格转成之前的价格
						agencyAfterBalance = NumberTool.sub(agencyBeforeBalance, orderAmount);
						accountPo.setAccountBalance(agencyAfterBalance);
						chargeAccountAO.updateAccount(accountPo);
						recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
								agencyBeforeBalance, agencyAfterBalance, 
								billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), ap_agency_id, 1 , orderId));
						/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
						int orderPath = OrderPathEnum.CHILD_WEB_PAGE.getValue();
						Boolean isChannelStateCanceled = channel.getChannelState() == ChannelUseStateEnum.CLOSE.getValue();
						if(isChannelStateCanceled){
							orderResult = OrderStateEnum.DAICHONG.getValue();
							orderStateDetail = "通道暂停等待";
							logger.config("通道使用状态暂停");
						}
						
						AgencyPurchasePo app = new AgencyPurchasePo(ap_agency_id, orderId, ratePo1.getId(), orderAmount, billType, orderPrice, fromAgencyName, orderPath, orderResult);
						app.setOrderStateDetail(orderStateDetail);
						apPoList.add(app);
//					rootAgencyPo = agencyVODao.getRootAgencyById(agencyId);
						
						
						int batchAddApp = agencyPurchaseDao.ap_addList(apPoList);		//批量添加连接信息
						int batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加扣款记录信息
						//
						if(batchAddApp > 0 && batchAddCrt > 0 && !isChannelStateCanceled){//开始走接口
							
								
//								 String epEngId = StringUtil2.toUpperClass(epPo.getEpEngId());
//								 String classRealPath = "com.weizu.flowsys.api.weizu."+epPo.getEpEngId()+"Charge";	//包完整路径
//								Class onwClass = Class.forName(classRealPath);
//								Constructor constructor = onwClass.getConstructor(String.class,String.class,String.class,String.class);
//								IChargeFacet chargeFacet = (IChargeFacet)constructor.newInstance(epPo.getEpPurchaseIp(),epPo.getEpApikey(),epPo.getEpUserName(),dataPo.getProductCode());
//								ChargeDTO chargeDTO = chargeFacet.charge();
								
//							ChargeDTO chargeDTO = chargeByFacet(epPo,dataPo);
							
							return chargeByBI(epPo, orderId, pcVO, dataPo.getProductCode());
								//判断是否正常提单,
								
								//充值之后更新订单的orderIdApi
//								purchasePo.setOrderIdApi(chargeDTO.getOrderIdApi());
//								int updatePur = purchaseDAO.updateLocal(purchasePo, new WherePrams("order_id", "=", purchasePo.getOrderId()));
//								if()
						}
					}else{//第一批代理商和订单没有添加成功
//					chargeRes = OrderStateEnum.UNCHARGE.getValue();
						return "订单添加失败！";
					}
				}
			}//费率存在
		}
		return "添加成功";
	}
	
	@Transactional
	@Override
	public String ajaxCommitOrder(Long orderId,Integer agencyId,String chargeTelDetail,Integer billTypeRate) {
		ChannelDiscountPo cd = channelDiscountDao.getCDbyAP(orderId, agencyId);
		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(cd.getServiceType(), chargeTelDetail, agencyId, billTypeRate,true);
		PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
		if(ratePo != null){
			int billType = ratePo.getBillType();//票务全部使用费率配置的票务
			//更新消费记录表（先更新账户余额，再更新订单，最后更新记录）
			ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyId, billType);
			
			/**账户信息的更新结果*/
			int recordRes = 0;
			
			boolean isSecondAgency = agencyVODao.getSecondAgency(agencyId) != null ;
			/**充值额（）*/
			Double orderAmount = purchasePo.getOrderAmount();
			//在二级代理商的情况下才去判断余额
			boolean ifLackBalance = isSecondAgency && orderAmount < accountPo.getAccountBalance();
			Long currentTime = System.currentTimeMillis();
			int orderPath = OrderPathEnum.CHARGE_SOCKET.getValue();
			int orderResult = OrderStateEnum.CHARGING.getValue();
			if(!ifLackBalance){//订单价格大于余额
				logger.config("余额不足或者不是接口用户，下单失败");
				return "余额不足，下单失败";
//			resultMap.put("referURL", "/flowsys/chargePg/purchase_list.do?orderResult=2");
			}else{
				if(ChargeStatusEnum.LACK_OF_BALANCE.getDesc().equals(purchasePo.getOrderResultDetail())){
					/**充值前余额*/
					Double agencyBeforeBalance = accountPo.getAccountBalance();
					
					accountPo.addBalance(orderAmount,-1);
					/** 更新登录用户账户信息**/
					recordRes = chargeAccountAO.updateAccount(accountPo);
					if(recordRes > 0){
						Long rateDiscountId = ratePo.getId();			//折扣id
						
						//开始把第一个消费记录，连接加上，
						/** 向消费记录表插入登陆用户数据 */
//						Long nextIdRecord = chargeRecordDao.nextId();
						chargeRecordDao.add(new ChargeRecordPo(currentTime, orderAmount,
								agencyBeforeBalance, accountPo.getAccountBalance(), 
								billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId, 1 , orderId));
						/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
					}
					
				}else{//其他原因导致充值等待
					AgencyBackwardPo agnecyPo = agencyVODao.get(agencyId);
					int superAgencyId = agnecyPo.getRootAgencyId();
					AgencyPurchasePo superApPo = agencyPurchaseDao.get(new WherePrams("agency_id", "=", superAgencyId).and("purchase_id", "=", orderId));
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
					superApPo.setRateDiscountId(cd.getId());
					superApPo.setBillType(cd.getBillType());
					superApPo.setOrderState(orderResult);
					superApPo.setOrderStateDetail(OrderStateEnum.CHARGING.getDesc());
					agencyPurchaseDao.update(superApPo);
					logger.config("通道暂停后，再次提交");
				}
			}
//			AgencyPurchasePo apPo = agencyPurchaseDao.get(new WherePrams("agency_id", "=", agencyId).and("purchase_id", "=", orderId));
			AgencyPurchasePo apPo = new AgencyPurchasePo();
			 apPo.setRateDiscountId(ratePo.getId());
			 apPo.setBillType(billType);
//			 int aapUpdRes = agencyPurchaseDao.update(apPo);
			 int aapUpdRes = agencyPurchaseDao.updateLocal(apPo, new WherePrams("agency_id", "=", agencyId).and("purchase_id", "=", orderId));
			 
			ExchangePlatformPo epPo = channelChannelDao.getEpByChannelId(ratePo.getChannelId());
			String scopeCityCode = PurchaseUtil.getScopeCityByCarrier(chargeTelDetail).get("scopeCityCode").toString();
			ProductCodePo pc = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), purchasePo.getPgId()));
//			if(!channelPo.getChannelState() == ChannelStateEnum.CLOSE.getValue()){
			BaseInterface bi = SingletonFactory.getSingleton(epPo.getEpEngId(), new BaseP(pc.getProductCode(),orderId,purchasePo.getChargeTel(),cd.getServiceType(),epPo));
			ChargeDTO chargeDTO = bi.charge();
			String orderIdApi = chargeDTO.getChargeOrder().getOrderIdApi();
			logger.config("上游返回的订单号："+ orderIdApi);//防止自己系统向上提单了，而自己数据库又没有最新的数据。以便核实订单结果
			purchasePo.setOrderIdApi(orderIdApi);
			purchasePo.setOrderArriveTime(currentTime);
			int upResPur = purchaseDAO.updateLocal(purchasePo,new WherePrams("order_id", "=", orderId));
		}//费率存在
		else{
			return "error";
		}
		return "success";
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
	 * @description: 接口充值
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
	public String chargeByBI(ExchangePlatformPo epPo,Long orderId,PgChargeVO pcVO,String productCode) {
		BaseInterface bi = SingletonFactory.getSingleton(epPo.getEpEngId(), new BaseP(productCode,orderId,pcVO.getChargeTel(),pcVO.getServiceType(),epPo));
		ChargeDTO chargeDTO = bi.charge();
		if(chargeDTO != null){
			System.out.println(chargeDTO.getChargeOrder().getOrderIdApi());//测试打印出对应平台的提单地址
			if(updatePurchase(chargeDTO, orderId) > 0){
				return "订单添加成功";
			}
		}
		return "订单充值接口返回错误";
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
			if(purchaseVO.getAgencyId() != null){
				paramsMap.put("agencyId", purchaseVO.getAgencyId());
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
			if(purchaseVO.getOrderResult() != null){
				paramsMap.put("orderResult", purchaseVO.getOrderResult());
			}
			if(purchaseVO.getOrderState() != null){
				paramsMap.put("orderState", purchaseVO.getOrderState());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getChargeTelDetail())){
				paramsMap.put("chargeTelDetail", purchaseVO.getChargeTelDetail().trim());
			}
			if(purchaseVO.getOperatorType() != null){
				paramsMap.put("operatorType", purchaseVO.getOperatorType());
			}
			
			
			Long startTime = null;
			Long endTime = null;
			Long dateUtilStartTime = DateUtil.getStartTime().getTime();
			Long dateUtilEndTime = DateUtil.getEndTime().getTime();
			if(isCharged){//充值成功列表使用充值时间查询
				if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){//默认打开列表
					paramsMap.put("startTimeBack", dateUtilStartTime);
				}else{
					startTime = DateUtil.strToDate(purchaseVO.getBackStartTimeStr(), null).getTime();
					paramsMap.put("startTimeBack", startTime);
				}
				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){//默认打开列表
					paramsMap.put("endTimeBack", dateUtilEndTime);
				}else{
					endTime = DateUtil.strToDate(purchaseVO.getBackEndTimeStr(), null).getTime();
					paramsMap.put("endTimeBack", endTime);
				}
			}else{//其他状态使用订单到达时间
				if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){//默认打开列表
					paramsMap.put("startTime", dateUtilStartTime);
				}else{
					startTime = DateUtil.strToDate(purchaseVO.getArriveStartTimeStr(), null).getTime();
					paramsMap.put("startTime", startTime);
				}
				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){//默认打开列表
					paramsMap.put("endTime", dateUtilEndTime);
				}else{
					endTime = DateUtil.strToDate(purchaseVO.getArriveEndTimeStr(), null).getTime();
					paramsMap.put("endTime", endTime);
				}
			}
//			paramsMap.put("isCharged", isCharged);
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
		Boolean isCharged = purchaseVO.getOrderState() != null && (purchaseVO.getOrderState() == OrderStateEnum.CHARGED.getValue() ||purchaseVO.getOrderState() == OrderStateEnum.UNCHARGE.getValue());
		Map<String, Object> paramsMap = getMapByPojo(purchaseVO,isCharged);
		int totalRecord = purchaseDAO.countPurchase(paramsMap);//今天的订单数量
		//设置总记录数和页面参数和查询参数
		totalRecord = resetTotalRecord(purchaseVO,paramsMap,isCharged,totalRecord);
		
		int pageSize = pageParam.getPageSize();
		int pageNo = pageParam.getPageNo();
		paramsMap.put("start", (pageNo-1) * pageSize);
		paramsMap.put("end", pageSize);
		
		List<PurchaseVO> records = purchaseDAO.getPurchase(paramsMap);
		Boolean isPurchaseList = purchaseVO.getOrderState() == null;//订单列表判定
		if(records != null && records.size() > 0){
			//遍历每一个订单，查看它的订单状态
			for (PurchaseVO purchaseVO2 : records) {
				/**查询订单成本*/
				if(purchaseVO.getAgencyId() == purchaseVO2.getAgencyId()){//如果不是当前代理商的订单，就重新查一遍这个订单的成本
					Double orderAmount = agencyPurchaseDao.getOrderAmount(purchaseVO2.getOrderId(), purchaseVO.getAgencyId());
					if(orderAmount != null){
						purchaseVO2.setOrderAmount(orderAmount);
					}
				}
				
				/**订单列表，订单又不支持回调的时候**/
				if(isPurchaseList && purchaseVO2.getRateDiscountId() != null){//只能通过费率id，如果通道或者费率被删除，就得不到最新的订单状态
					ExchangePlatformPo purchaseEp = exchangePlatformDao.getEpByRateId(purchaseVO2.getRateDiscountId());
					if(purchaseEp == null){
						purchaseEp = exchangePlatformDao.getEpByCDiscountId(purchaseVO2.getRateDiscountId());
					}
					if(purchaseEp != null){
						boolean negCallBack = purchaseEp.getEpCallBack() != null && purchaseEp.getEpCallBack() == CallBackEnum.NEGATIVE.getValue();
						if(negCallBack){//不支持回调就用主动查询，查询订单状态
							BaseInterface bi = SingletonFactory.getSingleton(purchaseEp.getEpEngId(), new BaseP(null,purchaseVO2.getOrderIdApi(),purchaseVO2.getChargeTel(),null,purchaseEp));//查订单状态用api订单号对象去查
							OrderDTO orderDTO = bi.getOrderState();
							if(orderDTO == null){
								logger.config("接口查询订单状态有误");
								continue;
							}
							OrderIn orderIn = orderDTO.getOrderIn();
							if(orderIn != null){
								//更新订单状态
								if(orderIn.getStatus() != purchaseVO2.getOrderState()){//返回状态和原先数据库状态不相符
									Long ts = orderIn.getCreated_at_time();
									
									int orderState = orderIn.getStatus();
									String orderStateDetail = orderIn.getMsg();
									if(agencyVODao.getRootAgencyById(purchaseVO.getAgencyId()) != null){//不是超管,重置订单状态
										OrderIn cloneOrderIn = orderIn.clone();
										resetPurchaseState(cloneOrderIn);
										orderState = cloneOrderIn.getStatus();
										orderStateDetail = cloneOrderIn.getMsg();
									}
									purchaseVO2.setOrderBackTimeStr(DateUtil.formatAll(ts));
									purchaseVO2.setOrderState(orderState);
									purchaseVO2.setOrderStateDetail(orderStateDetail);
									agencyPurchaseAO.updatePurchaseState(purchaseVO2.getOrderId(), orderState, orderStateDetail,ts);
									//把查询的结果利用接口推给下游
									AgencyBackwardPo agencyPo = agencyVODao.get(purchaseVO2.getAgencyId());
									if(StringHelper.isNotEmpty(agencyPo.getCallBackIp())){//下游有回调地址的情况下，按照回调地址推送
										String callBackRes = SendCallBackUtil.sendCallBack(new ResponseJsonDTO(purchaseVO2.getOrderId(), purchaseVO2.getOrderIdFrom(), orderState, orderStateDetail, ts), agencyPo);
										System.out.println(agencyPo.getUserName() + "：" +purchaseVO2.getOrderId() + "：" +  callBackRes);
									}
								}
							}else{
								logger.config(orderDTO.getRspCode() + ":" + orderDTO.getRspMsg());
							}
						}
					}else{
						System.out.println("未找到相关平台信息");
					}
				}
					
	//					
	//					OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(purchaseEp.getEpName());
	//					
	//					OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(purchaseEp.getPgdataCheckIp(), purchaseVO2.getOrderIdApi(), purchaseEp.getEpName(), purchaseEp.getEpUserName(), purchaseEp.getEpApikey()));
	//					//更新加载的订单状态信息
	//					//判断是否与数据库中的数据相等,如果不相等，就更新页面和数据库信息
	//					PageOrder pageOrder = osrp.getPageOrder();
	//					//如果失败，把等待状态转换成未充状态
	//					pageOrder.setStatus(ChargeFacadeImpl.getStatusByStatus(pageOrder.getStatus())); 
	//					
	//					//更新查看订单状态
	//					checkOrderState(pageOrder, purchaseVO2);
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
		resultMap.put("searchParams", purchaseVO);	//查询参数放入返回参数
		return new Pagination<PurchaseVO>(records, totalRecord, pageNo, pageSize);
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
    	case 0://未充值
//    		orderState = OrderStateEnum.WEICHONG.getValue();
//    		break;
    	case 1://等待充值
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
	private int resetTotalRecord(PurchaseVO purchaseVO,
			Map<String, Object> paramsMap, Boolean isCharged, int totalRecord) {
		//在没有记录的情况下重置查询条件和查询参数
		if(totalRecord == 0){
			Long currentTime = System.currentTimeMillis();
			if(isCharged){
				if(StringHelper.isEmpty(purchaseVO.getBackStartTimeStr())){
					paramsMap.put("startTimeBack",null);
				}
				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(currentTime));
					paramsMap.put("endTimeBack", currentTime);
				}
			}else{//其他列表
				if(StringHelper.isEmpty(purchaseVO.getArriveStartTimeStr())){
					paramsMap.put("startTime",null);
				}
				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
					paramsMap.put("endTime", currentTime);
					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(currentTime));
				}
			}
			totalRecord = purchaseDAO.countPurchase(paramsMap);//重置订单数量
		}else{//有记录条件下，设置页面参数
			Long dateUtilStartTime = null;
			Long dateUtilEndTime = null;
			if(isCharged){
				if(purchaseVO.getBackStartTimeStr() == null){
					dateUtilStartTime = Long.parseLong(paramsMap.get("startTimeBack").toString());
					purchaseVO.setBackStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
				}else if("".equals(purchaseVO.getBackStartTimeStr().trim())){
					//为空或者值重新设置	
					paramsMap.put("startTimeBack", null);
					totalRecord = purchaseDAO.countPurchase(paramsMap);
				}
				if(StringHelper.isEmpty(purchaseVO.getBackEndTimeStr())){
					dateUtilEndTime = Long.parseLong(paramsMap.get("endTimeBack").toString());
					purchaseVO.setBackEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
				}
			}else{
				if(purchaseVO.getArriveStartTimeStr() == null){
					dateUtilStartTime = Long.parseLong(paramsMap.get("startTime").toString());
					purchaseVO.setArriveStartTimeStr(DateUtil.formatAll(dateUtilStartTime));
				}else{
					//为空或者值重新设置
					if("".equals(purchaseVO.getArriveStartTimeStr().trim())){
						paramsMap.put("startTime", null);
						totalRecord = purchaseDAO.countPurchase(paramsMap);
					}
				}
				if(StringHelper.isEmpty(purchaseVO.getArriveEndTimeStr())){
					dateUtilEndTime = Long.parseLong(paramsMap.get("endTime").toString());
					purchaseVO.setArriveEndTimeStr(DateUtil.formatAll(dateUtilEndTime));
				}
			}
		}
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
		List<ChargeChannelPo> channelList = channelChannelDao.list_charge_channel(searchMap);
		if(channelList != null && channelList.size()==1){//只有一条通道的时候，可以默认加载这条通道的包体
			Map<String, Object> objMap = new HashMap<String, Object>();
			Long cId = channelList.get(0).getId();
			objMap.put("cnelId", cId);
			objMap.put("operatorType", ccpp.getOperatorType());
			objMap.put("serviceType", ccpp.getServiceType());
			List<OperatorPgDataPo> pgList = operatorPgDao.listPgListInPcode(objMap);
			channelList.get(0).setList(pgList);
		}
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
		Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(carrier);
		if(scopeMap != null)
		{
			String scopeCityCode = scopeMap.get("scopeCityCode").toString();
			searchMap.put("scopeCityCode", scopeCityCode);
		}
		if(ccpp.getServiceType() != null){
			searchMap.put("serviceType", ccpp.getServiceType());
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
	public List<OperatorPgDataPo> getPgByChanel(ChargeChannelParamsPo ccpp) {
		Map<String, Object> objMap = new HashMap<String, Object>();
		String carrier = ccpp.getCarrier();
		if(StringHelper.isNotEmpty(carrier)){
			int operatorType = OperatorTypeEnum.getValueByDesc(carrier.substring(carrier.length()-2));
			objMap.put("operatorType", operatorType);
			if(ServiceTypeEnum.NATION_WIDE.getValue() != ccpp.getServiceType()){
				Map<String,Object> scopeMap = PurchaseUtil.getScopeCityByCarrier(carrier);
				if(scopeMap.get("scopeCityCode") != null){
					objMap.put("scopeCityCode", scopeMap.get("scopeCityCode").toString());
				}
			}
		}
		if(ccpp.getChannelId() != null){
			objMap.put("channelId", ccpp.getChannelId());
		}
		objMap.put("serviceType", ccpp.getServiceType());
		List<OperatorPgDataPo> pgList = operatorPgDao.getPgByChanel(objMap);
		return pgList;
	}

}
