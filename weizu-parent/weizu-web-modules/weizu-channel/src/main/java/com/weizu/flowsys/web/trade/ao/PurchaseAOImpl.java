package com.weizu.flowsys.web.trade.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.api.facet.charge.ChargeBase;
import org.weizu.api.facet.charge.ChargeFactory;
import org.weizu.api.facet.charge.ChargePageOrder;
import org.weizu.api.facet.charge.impl.ChargeParamsPage;
import org.weizu.api.facet.charge.impl.ChargeResultPage;
import org.weizu.api.facet.orderState.OrderStateBase;
import org.weizu.api.facet.orderState.OrderStateFactory;
import org.weizu.api.facet.orderState.PageOrder;
import org.weizu.api.facet.orderState.impl.OrderStateParamsPage;
import org.weizu.api.facet.orderState.impl.OrderStateResultPage;
import org.weizu.api.outter.enums.ChargeStatusEnum;
import org.weizu.api.outter.facade.ChargeFacade;
import org.weizu.web.foundation.DateUtil;
import org.weizu.web.foundation.String.StringHelper;
import org.weizu.web.foundation.http.HttpRequest;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelForwardDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.http.ParamsEntityWeiZu;
import com.weizu.flowsys.web.http.ao.ChargeFacadeImpl;
import com.weizu.flowsys.web.http.weizu.OrderStateResult;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

@Service(value="purchaseAO")
public class PurchaseAOImpl implements PurchaseAO {

	@Resource
	private PurchaseDao purchaseDAO;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeRecordDao chargeRecordDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;
//	@Resource
//	private ChannelForwardAO channelForwardAO;
//	@Resource
//	private ChannelForwardDaoInterface channelForwardDao;
	@Resource
	private ChannelChannelDao channelChannelDao; 
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private OperatorPgAO operatorPgAO;
	@Resource
	private ProductCodeAO productCodeAO;
	@Resource
	private RateDiscountAO rateDiscountAO;
	@Resource
	private RateDiscountDao rateDiscountDao; 
	
	@Resource
	private AgencyPurchaseDao agencyPurchaseDao;
	
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
	public Integer purchase(PgChargeVO pcVO) {
		/****************完成对所有上级代理商包括自己的订单与代理商的绑定********************/
		//已经当前登陆用户余额充足，开始充值流程
		//在订单信息完全添加完之后，再调用接口进行充值
		//先添加一个基本的，再批量添加父级代理商和订单的绑定
		PurchasePo purchasePo = initPurchase(pcVO);
		int agencyId = pcVO.getAgencyId();		//订单产生方代理商
		int orderResult = OrderStateEnum.CHARGING.getValue();		//默认订单状态
		int aapAddRes = 0;
		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(pcVO.getServiceType(), pcVO.getChargeTelDetail(), agencyId);
		int chargeRes = -1;			//充值状态
		if(ratePo != null){
			int billType = ratePo.getBillType();//票务全部使用费率配置的票务
			//更新消费记录表（先更新账户余额，再更新记录）
			ChargeAccountPo accountPo = chargeAccountAO.getAccountByAgencyId(agencyId, billType);
			/**充值前余额*/
			double agencyBeforeBalance = accountPo.getAccountBalance();
			/**充值额（）*/
			Double pgPrice = pcVO.getPgPrice();
			Double orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), pgPrice);
			accountPo.addBalance(orderAmount,-1);
			/** 更新登录用户账户信息**/
			int recordRes = chargeAccountAO.updateAccount(accountPo);
			if(recordRes > 0){
				/** 向消费记录表插入登陆用户数据 */
				Long nextIdRecord = chargeRecordDao.nextId();
				Long currentTime = System.currentTimeMillis();
				chargeRecordDao.add(new ChargeRecordPo(currentTime, orderAmount,
						agencyBeforeBalance, accountPo.getAccountBalance(), 
						billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId,1));
				Long rateDiscountId = ratePo.getId();			//折扣id
				try {
					OrderUril ou1 = new OrderUril(1);
					Long orderId = ou1.nextId();
					purchasePo.setOrderId(orderId);//设置订单号
					purchasePo.setAgencyId(agencyId);
					purchasePo.setOrderArriveTime(currentTime);
					purchasePo.setOrderResult(orderResult);
					purchasePo.setChannelId(ratePo.getChannelId());
//					Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
//					 String chargeTelCity = null;
//					 if(telMap != null)
//					{
//						chargeTelCity = telMap.get("chargeTelCity").toString();
//					}
//					purchasePo.setChargeTelCity(chargeTelCity);
					int purResult = purchaseDAO.addPurchase(purchasePo);
					
					/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
					int orderPath = OrderPathEnum.WEB_PAGE.getValue();
					AgencyPurchasePo app = new AgencyPurchasePo(agencyId, orderId, rateDiscountId, orderAmount, billType, nextIdRecord, orderResult,orderPath);
					aapAddRes = agencyPurchaseDao.add(app);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				logger.config("更新账户表失败");
			}
			
			//批量添加父级代理商和订单的绑定
			if(aapAddRes > 0){//第一级代理商和订单添加好了
				chargeRes = OrderResultEnum.SUCCESS.getCode();		//在全部上级都添加完了之后返回成功;
				List<AgencyPurchasePo> apPoList = new LinkedList<AgencyPurchasePo>();
				int whileStop = 0;
				while(ratePo.getActiveId() != null){//没有找到第二级代理商，开始添加代理商和订单
					ratePo = rateDiscountDao.get(ratePo.getActiveId());		//重置ratePo为父级费率折扣;不为空
					billType = ratePo.getBillType();		//重置票务
					accountPo  = chargeAccountDao.selectRootAccountByAgencyId(agencyId, billType);//重置为父级代理商的账户
					agencyId = accountPo.getAgencyId();//重置代理商id为父级代理商的id
					
					/**业务判断和添加**/
					/**充值额（）*/
					orderAmount = NumberTool.mul(ratePo.getActiveDiscount(), pgPrice);
					if(orderAmount > accountPo.getAccountBalance()){
						orderResult = OrderStateEnum.DAICHONG.getValue();	//欠费等待
						whileStop = 1;
					}else{
						orderResult = OrderStateEnum.CHARGING.getValue();		//充值进行
					}
					Long rateDiscountId = ratePo.getId();			//折扣id
					
					if(whileStop == 1){//可以向上提单，但是不扣上面的款
						int orderPath = OrderPathEnum.CHARGE_SOCKET.getValue();
						AgencyPurchasePo app = new AgencyPurchasePo(agencyId, purchasePo.getOrderId(), null, null, billType, null, orderResult,orderPath);
						apPoList.add(app);
						break;
					}else{
						/**充值前余额*/
						agencyBeforeBalance = accountPo.getAccountBalance();
						accountPo.addBalance(orderAmount,-1);
						/** 更新登录用户账户信息**/
						recordRes = chargeAccountAO.updateAccount(accountPo);
						if(recordRes > 0){
							/** 向消费记录表插入登陆用户数据 */
							Long nextIdRecord = chargeRecordDao.nextId();
							Long currentTime = System.currentTimeMillis();
							chargeRecordDao.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
									agencyBeforeBalance, accountPo.getAccountBalance(), 
									billType,AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), agencyId,1));
							
							int orderPath = OrderPathEnum.CHARGE_SOCKET.getValue();
							AgencyPurchasePo app = new AgencyPurchasePo(agencyId, purchasePo.getOrderId(), rateDiscountId, orderAmount, billType, nextIdRecord, orderResult,orderPath);
							apPoList.add(app);
						}
					}
					//最后再循环一次，保证欠费等待的单子父级代理商能够看到，但是不能扣父级代理商的款和消费记录
//					if(whileStop > 0){//欠费等待
//						whileStop++ ;
//					}
				}
				if(apPoList.size() > 0){
					int batchAddApp = agencyPurchaseDao.ap_addList(apPoList);		//批量添加
//					if(batchAddApp > 0 && dataPo.getProductCode()  != null){//订单信息完成之后，马上利用接口把订单通过通道传到上游
//						ChannelChannelPo channelPo = channelChannelDao.get(ratePo.getChannelId());
//						ExchangePlatformPo epPo = exchangePlatformAO.getEpById(channelPo.getEpId());
//						if(epPo != null){
//							ChargeBase chargeBase = ChargeFactory.getChargeBase(epPo.getEpName());
//							//
//							ChargeResultPage chargeResultPage = chargeBase.charge(new ChargeParamsPage(epPo.getEpPurchaseIp(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey(), purchasePo.getChargeTel(), dataPo.getProductCode()));
//							
//							//初始化订单结果
//							ChargePageOrder chargePageOrder = chargeResultPage.getChargePageOrder();
//							if(chargePageOrder != null)
//							{
//								PurchasePo ppo = new PurchasePo();
////							ppo.setOrderId(purchasePo.getOrderId());
//								ppo.setOrderBackTime(chargePageOrder.getOrderBackTime());//订单充值返回时间
//								ppo.setOrderIdApi(chargePageOrder.getTransaction_id());	//接口订单号
//								ppo.setOrderResultDetail(chargeResultPage.tipMsg); 		//结果描述
//								purchaseDAO.updateLocal(ppo, new WherePrams("order_id", "=", purchasePo.getOrderId()));
//							}
//						}
//					}
				}
			}else{//第一批代理商和订单没有添加成功
				chargeRes = OrderStateEnum.UNCHARGE.getValue();
			}
		}
		
		return chargeRes;
		
		
		
		
		/****************修改登陆用户的对私账户********************/
		
		
//		channelPo.setChannelTotalUse();
//		channelPo.addTotalUse();
//		channelPo.addTotalAmount(orderAmount);
//		int channelRes = channelForwardDao.update(channelPo);
		
		
//		/**订单信息添加*/
//		OrderUril ou1 = new OrderUril(1);
//		try {
//			purchasePo.setOrderId(ou1.nextId());//设置订单号
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		purchasePo.setOrderPlatformPath(OrderPathEnum.WEB_PAGE.getValue());
//		if(recordRes + channelRes -1 >0 && productCode  != null){
//			
//			ChargeBase chargeBase = ChargeFactory.getChargeBase(epPo.getEpName());
//			//
//			ChargeResultPage chargeResultPage = chargeBase.charge(new ChargeParamsPage(epPo.getEpPurchaseIp(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey(), purchasePo.getChargeTel(), productCode));
//			
//			//初始化订单结果
//			ChargePageOrder chargePageOrder = chargeResultPage.getChargePageOrder();
//			if(chargePageOrder != null)
//			{
//				purchasePo.setOrderBackTime(chargePageOrder.getOrderBackTime());
//				purchasePo.setOrderIdApi(chargePageOrder.getTransaction_id());
//				//查看订单状态
//				OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(epPo.getEpName());
//				OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(epPo.getPgdataCheckIp(), chargePageOrder.getTransaction_id(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey()));
//				purchasePo.setOrderResult(osrp.getPageOrder().getStatus());
//				purchasePo.setOrderResultDetail(osrp.getPageOrder().getMsg());
//				if(osrp == null){
////					Log
//					System.out.println("没有添加该公司代码");
//				}
//				System.out.println(osrp.getPageOrder().getCreated_at());
//				System.out.println(osrp.getPageOrder().getCharge_fee());
//				System.out.println(osrp.getPageOrder().getStatus());
//				//将订单状态写入充值状态中
////				chargePageOrder.getTransaction_id()
//			}
//			
////			OrderStateResult osr =  purchaseByWeizuAPI(new ParamsEntityWeiZu(epPo.getEpUserName(), purchasePo.getChargeTel(), product.getProductCode(), epPo.getEpApikey()));
//			
//			
//			purchasePo.setRootAgencyId(accountPo.getAgencyId());//设为当前登陆账户的订单
//			 Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
//			 String chargeTelCity = null;
//			 if(telMap != null)
//			{
//				chargeTelCity = telMap.get("chargeTelCity").toString();
//			}
//			purchasePo.setChargeTelCity(chargeTelCity);
//			purchasePo.setRecordId(nextIdRecord);
//			//更新订单表
//			int purResult = purchaseDAO.addPurchase(purchasePo);
////			purchasePo
//			
//			/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
//			if(purResult > 0){
//				return OrderResultEnum.SUCCESS.getCode();
//			}else{
//				return OrderResultEnum.ERROR.getCode();
//			}
//		}else{
//			return OrderResultEnum.ERROR.getCode();
//		}
		
//		if(purResult + recordRes + channelRes - 2 > 0){
//			return OrderResultEnum.SUCCESS.getCode();
//		}else{
//			return OrderResultEnum.ERROR.getCode();
//		}
		
		
	}

	/**
	 * @description: 封装查询参数
	 * @param purchaseVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:53:34
	 */
	@Override
	public Map<String, Object> getMapByPojo(PurchaseVO purchaseVO) {
		
		if(purchaseVO != null){
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			if(StringHelper.isNotEmpty(purchaseVO.getChargeTel())){
				paramsMap.put("chargeTel", purchaseVO.getChargeTel());
			}
			if(purchaseVO.getRootAgencyId() != null){
				paramsMap.put("agencyId", purchaseVO.getRootAgencyId());
			}
			if(purchaseVO.getBillType() != null){
				paramsMap.put("billType", purchaseVO.getBillType());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getAgencyName())){
				paramsMap.put("agencyName", purchaseVO.getAgencyName());
			}
			if(purchaseVO.getOrderId() != null){
				paramsMap.put("orderId", purchaseVO.getOrderId());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getChargeTelDetail())){
				paramsMap.put("chargeTelDetail", purchaseVO.getChargeTelDetail());
			}
			if(purchaseVO.getOperatorType() != null){
				paramsMap.put("operatorType", purchaseVO.getOperatorType());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getArriveStartTimeStr())){
				paramsMap.put("startTime", DateUtil.strToDate(purchaseVO.getArriveStartTimeStr(), null).getTime());
			}
			if(StringHelper.isNotEmpty(purchaseVO.getArriveEndTimeStr())){
				paramsMap.put("endTime", DateUtil.strToDate(purchaseVO.getArriveEndTimeStr(), null).getTime());
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
	public Pagination<PurchaseVO> getPurchase(PurchaseVO purchaseVO,
			PageParam pageParam) {
		
		Map<String, Object> paramsMap = getMapByPojo(purchaseVO);
		int totalRecord = purchaseDAO.countPurchase(paramsMap);
		if(pageParam != null){
			int pageSize = pageParam.getPageSize();
			int pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1) * pageSize);
			paramsMap.put("end", pageSize);
			List<PurchaseVO> records = purchaseDAO.getPurchase(paramsMap);
			if(records != null){
				//遍历每一个订单，查看它的订单状态
				for (PurchaseVO purchaseVO2 : records) {//格式化展示时间
//					ExchangePlatformPo purchaseEp = purchaseVO2.getEp();
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
//					if(purchaseVO2.getOrderBackTime() != null)
//					{
//						purchaseVO2.setOrderBackTimeStr(DateUtil.formatAll(purchaseVO2.getOrderBackTime()));
//					}
//					
					if(purchaseVO2.getOrderArriveTime() != null){
						purchaseVO2.setOrderArriveTimeStr(DateUtil.formatAll(purchaseVO2.getOrderArriveTime()));
					}
				}
			}
			
			return new Pagination<PurchaseVO>(records, totalRecord, pageNo, pageSize);
		}
		return null;
		
		
		
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
	 * @description:   更新查看订单状态
	 * @param pageOrder
	 * @param purchaseVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午12:57:18
	 */
	@Override
	public int checkOrderState(PageOrder pageOrder, PurchaseVO purchaseVO) {
		int updateRes = 0;
		if(purchaseVO.getOrderResult() != pageOrder.getStatus())
		{
			purchaseVO.setOrderResult(pageOrder.getStatus());
			//如果过
			if(StringHelper.isEmpty(pageOrder.getMsg())){
				for (OrderStateEnum enumt : OrderStateEnum.values()) {
					if(pageOrder.getStatus() == enumt.getValue())
					{
						purchaseVO.setOrderResultDetail(enumt.getDesc());
						break;
					}
				}
			}else{
				purchaseVO.setOrderResultDetail(pageOrder.getMsg());
			}
			String created_at_api = pageOrder.getCreated_at();
			purchaseVO.setOrderBackTimeStr(created_at_api);
			updateRes = purchaseDAO.updatePurchaseState(new PurchaseStateParams(purchaseVO.getOrderId(), DateUtil.strToDate(created_at_api, "").getTime() , purchaseVO.getOrderResult(), purchaseVO.getOrderResultDetail(),pageOrder.getTransaction_id()));
		}
		return updateRes;
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

	

}
