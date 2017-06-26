package com.weizu.flowsys.web.trade.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
import org.weizu.web.foundation.DateUtil;
import org.weizu.web.foundation.String.StringHelper;
import org.weizu.web.foundation.http.HttpRequest;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.util.OrderUril;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ChannelForwardDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.http.ParamsEntityWeiZu;
import com.weizu.flowsys.web.http.weizu.OrderStateResult;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
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
	@Resource
	private ChannelForwardDaoInterface channelForwardDao;
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private OperatorPgAO operatorPgAO;
	@Resource
	private ProductCodeAO productCodeAO;
	
	/**
	 * @description: 页面上充值
	 * @param purchasePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月12日 下午5:35:16
	 */
	@Transactional
	@Override
	public Integer purchase(PurchasePo purchasePo,ChargeAccountPo accountPo) {
		
		/****************修改登陆账户********************/
		/**充值前余额*/
		double agencyBeforeBalance = accountPo.getAccountBalance();
		/**充值额（）*/
		Double orderAmount = purchasePo.getOrderAmount();
		/** 向消费记录表插入登陆用户数据 */
		chargeRecordDao.add(new ChargeRecordPo(System
				.currentTimeMillis(), orderAmount,
				agencyBeforeBalance, NumberTool.sub(agencyBeforeBalance, orderAmount), 
				BillTypeEnum.BUSINESS_INDIVIDUAL.getValue(),AccountTypeEnum.DECREASE.getValue(), accountPo.getId(), purchasePo.getAgencyId(),1));
		accountPo.addBalance(orderAmount,-1);
		/** 更新登录用户账户信息**/
		int recordRes = chargeAccountAO.updateAccount(accountPo);
		
		/****************更新通道交易总额和交易总单数********************/
		ChannelForwardPo channelPo = channelForwardDao.get(purchasePo.getChannelId());
		//获取通道所属平台信息
		ExchangePlatformPo epPo = exchangePlatformAO.getEpById(channelPo.getEpId());
		
		
		OperatorPgDataPo pgPo = operatorPgAO.getPgById(purchasePo.getPgId());//
		//通过归属地和包体获得产品编码
		Map<String, Object> scopeCityMap = PurchaseUtil.getScopeCityByCarrier(purchasePo.getChargeTelDetail());
		String scopeCityCode = scopeCityMap.get("scopeCityCode").toString();//地区编码
		ProductCodePo product =  productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, pgPo.getPgSize(), pgPo.getOperatorType(), pgPo.getServiceType(), channelPo.getEpId()));
		
		
		
//		channelPo.setChannelTotalUse();
		channelPo.addTotalUse();
		channelPo.addTotalAmount(orderAmount);
		int channelRes = channelForwardDao.update(channelPo);
		/**订单信息添加*/
		OrderUril ou1 = new OrderUril(1);
		try {
			purchasePo.setOrderId(ou1.nextId());//设置订单号
		} catch (Exception e) {
			e.printStackTrace();
		}
		purchasePo.setOrderPlatformPath(OrderPathEnum.WEB_PAGE.getValue());
		if(recordRes + channelRes -1 >0 && product  != null){
			
			ChargeBase chargeBase = ChargeFactory.getChargeBase(epPo.getEpName());
			//
			ChargeResultPage chargeResultPage = chargeBase.charge(new ChargeParamsPage(epPo.getEpPurchaseIp(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey(), purchasePo.getChargeTel(), product.getProductCode()));
			
			//初始化订单结果
			ChargePageOrder chargePageOrder = chargeResultPage.getChargePageOrder();
			if(chargePageOrder != null)
			{
				purchasePo.setOrderBackTime(chargePageOrder.getOrderBackTime());
				purchasePo.setOrderIdApi(chargePageOrder.getTransaction_id());
				//查看订单状态
				OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(epPo.getEpName());
				OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(epPo.getPgdataCheckIp(), chargePageOrder.getTransaction_id(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey()));
				purchasePo.setOrderResult(osrp.getPageOrder().getStatus());
				purchasePo.setOrderResultDetail(osrp.getPageOrder().getMsg());
				if(osrp == null){
//					Log
					System.out.println("没有添加该公司代码");
				}
				System.out.println(osrp.getPageOrder().getCreated_at());
				System.out.println(osrp.getPageOrder().getCharge_fee());
				System.out.println(osrp.getPageOrder().getStatus());
				//将订单状态写入充值状态中
//				chargePageOrder.getTransaction_id()
			}
			
//			OrderStateResult osr =  purchaseByWeizuAPI(new ParamsEntityWeiZu(epPo.getEpUserName(), purchasePo.getChargeTel(), product.getProductCode(), epPo.getEpApikey()));
			
			
			purchasePo.setRootAgencyId(accountPo.getAgencyId());//设为当前登陆账户的订单
			 Map<String, Object> telMap = PurchaseUtil.getOperatorsByTel(purchasePo.getChargeTel());
			 String chargeTelCity = null;
			 if(telMap != null)
			{
				chargeTelCity = telMap.get("chargeTelCity").toString();
			}
			purchasePo.setChargeTelCity(chargeTelCity);
			
			//更新订单表
			int purResult = purchaseDAO.addPurchase(purchasePo);
			
			/**再向下游返回回调，并更新数据库中订单表中返回时间和返回结果*/
			if(purResult > 0){
				return OrderResultEnum.SUCCESS.getCode();
			}else{
				return OrderResultEnum.ERROR.getCode();
			}
		}else{
			return OrderResultEnum.ERROR.getCode();
		}
		
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
				paramsMap.put("rootAgencyId", purchaseVO.getRootAgencyId());
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
					ExchangePlatformPo purchaseEp = purchaseVO2.getEp();
					
					OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(purchaseEp.getEpName());
					
					OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(purchaseEp.getPgdataCheckIp(), purchaseVO2.getOrderIdApi(), purchaseEp.getEpName(), purchaseEp.getEpUserName(), purchaseEp.getEpApikey()));
					//更新加载的订单状态信息
					//判断是否与数据库中的数据相等,如果不相等，就更新页面和数据库信息
					PageOrder pageOrder = osrp.getPageOrder();
					//更新查看订单状态
					checkOrderState(pageOrder, purchaseVO2);
					if(purchaseVO2.getOrderBackTime() != null)
					{
						purchaseVO2.setOrderBackTimeStr(DateUtil.formatAll(purchaseVO2.getOrderBackTime()));
					}
					
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
			updateRes = purchaseDAO.updatePurchaseState(new PurchaseStateParams(purchaseVO.getOrderId(), DateUtil.strToDate(created_at_api, "").getTime() , purchaseVO.getOrderResult(), purchaseVO.getOrderResultDetail()));
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
