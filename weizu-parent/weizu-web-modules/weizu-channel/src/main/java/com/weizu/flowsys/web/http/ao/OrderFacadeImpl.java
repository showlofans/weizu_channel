//package com.weizu.flowsys.web.http.ao;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//import org.weizu.api.facet.orderState.OrderStateBase;
//import org.weizu.api.facet.orderState.OrderStateFactory;
//import org.weizu.api.facet.orderState.PageOrder;
//import org.weizu.api.facet.orderState.impl.OrderStateParamsPage;
//import org.weizu.api.facet.orderState.impl.OrderStateResultPage;
//import org.weizu.api.outter.enums.OrderStateCheckEnum;
//import org.weizu.api.outter.facade.OrderFacade;
//import org.weizu.api.outter.pojo.order.OrderDTO;
//import org.weizu.api.outter.pojo.order.OrderIn;
//import org.weizu.api.outter.pojo.order.OrderParams;
//import org.weizu.web.foundation.DateUtil;
//import org.weizu.web.foundation.String.StringHelper;
//
//import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
//import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
//import com.weizu.flowsys.web.channel.ao.ChannelForwardAO;
//import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
//import com.weizu.flowsys.web.channel.dao.impl.OperatorPgDao;
//import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
//import com.weizu.flowsys.web.trade.ao.PurchaseAO;
//import com.weizu.flowsys.web.trade.dao.PurchaseDao;
//import com.weizu.flowsys.web.trade.pojo.PurchasePo;
//import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;
//
///**
// * @description: 查询订单详情接口实现类
// * @projectName:weizu-channel
// * @className:OrderFacadeImpl.java
// * @author:POP产品研发部 宁强
// * @createTime:2017年6月23日 下午6:04:27
// * @version 1.0
// */
//@Service("orderFacade")
//public class OrderFacadeImpl implements OrderFacade {
//
//	@Resource
//	private ValiUser valiUser;
//	
//	@Resource
//	private PurchaseAO purchaseAO;
//	@Resource
//	private PurchaseDao purchaseDAO;
//	
//	@Resource
//	private OperatorPgDao operatorPgDao;
//	@Resource
//	private ChannelForwardAO channelForwardAO;
//	
//	/**
//	 * @description:查询订单详情
//	 * @param orderParams
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月23日 下午6:04:40
//	 */
//	@Override
//	public OrderDTO checkOrder(OrderParams orderParams) {
//		AgencyBackwardPo agencyPo = valiUser.findAgency(orderParams.getUserName(), orderParams.getSign());
//		OrderDTO orderDTO = null;
//		PurchasePo purchasePo = null;
//		OrderStateCheckEnum oscEnum = null;
//		if(StringHelper.isEmpty(orderParams.getOrderId()))
//		{
//			oscEnum = OrderStateCheckEnum.ORDERID_ISNULL;
//			return new OrderDTO(oscEnum.getValue(), oscEnum.getDesc(), null);
//		}else{
//			Long orderId = Long.parseLong(orderParams.getOrderId());
//			purchasePo = purchaseAO.getOnePurchase(orderId);
//		}
//		
//		if(agencyPo == null)
//		{
//			oscEnum = OrderStateCheckEnum.AUTHENTICATION_FAILURE;
//			orderDTO = new OrderDTO(oscEnum.getValue(), oscEnum.getDesc(), null);
//		}else if(purchasePo == null)
//		{
//			oscEnum = OrderStateCheckEnum.ORDER_NOT_FOUND;
//			orderDTO = new OrderDTO(oscEnum.getValue(), oscEnum.getDesc(), null);
//		}else if(!purchasePo.getChargeTel().equals(orderParams.getNumber())){
//			oscEnum = OrderStateCheckEnum.TELPHONE_ERROR;
//			orderDTO = new OrderDTO(oscEnum.getValue(), oscEnum.getDesc(), null);
//		}else{//通过api更新订单状态
//			//获取通道所属平台信息
////			ExchangePlatformPo epPo = channelForwardAO.getEpByChannelId(purchasePo.getChannelId());
////			//查看订单状态
////			OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(epPo.getEpName());
////			OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(epPo.getPgdataCheckIp(), purchasePo.getOrderIdApi(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey()));
////			
////			PageOrder pageOrder = osrp.getPageOrder();
////			if(purchasePo.getOrderResult() != pageOrder.getStatus())
////			{
////				purchasePo.setOrderResult(pageOrder.getStatus());
////				if(StringHelper.isEmpty(pageOrder.getMsg())){
////					for (OrderStateEnum enumt : OrderStateEnum.values()) {
////						if(pageOrder.getStatus() == enumt.getValue())
////						{
////							purchasePo.setOrderResultDetail(enumt.getDesc());
////							break;
////						}
////					}
////				}else{
////					purchasePo.setOrderResultDetail(pageOrder.getMsg());
////				}
////				String created_at_api = pageOrder.getCreated_at();
////				purchasePo.setOrderBackTime(DateUtil.strToDate(created_at_api, null).getTime());
////				purchaseDAO.updatePurchaseState(new PurchaseStateParams(purchasePo.getOrderId(), DateUtil.strToDate(created_at_api, "").getTime() , purchasePo.getOrderResult(), purchasePo.getOrderResultDetail(),pageOrder.getTransaction_id()));
////			}
////			
////			int pgSize = operatorPgDao.get(purchasePo.getPgId()).getPgSize();
////			String createdAt = DateUtil.formatAll(purchasePo.getOrderArriveTime());
////			oscEnum = OrderStateCheckEnum.PARAMS_SUCCESS;
////			orderDTO = new OrderDTO(oscEnum.getValue(), oscEnum.getDesc(), new OrderIn(purchasePo.getOrderId()+"", orderParams.getNumber(), pgSize+"", purchasePo.getOrderAmount()+"", createdAt , osrp.getPageOrder().getStatus(), purchasePo.getOrderResultDetail()));
//		}
//		return orderDTO;
//	}
//
//}
