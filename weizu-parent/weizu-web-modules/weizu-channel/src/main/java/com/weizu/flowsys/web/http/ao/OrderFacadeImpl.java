package com.weizu.flowsys.web.http.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.weizu.api.outter.enums.OrderStateCheckEnum;

import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.OrderIn;
import com.weizu.flowsys.api.weizu.facet.IOrderFacet;
import com.weizu.flowsys.api.weizu.order.QueryOrderParams;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.channel.ao.ChannelForwardAO;
import com.weizu.flowsys.web.channel.dao.impl.OperatorPgDao;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 查询订单详情接口实现类
 * @projectName:weizu-channel
 * @className:OrderFacadeImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午6:04:27
 * @version 1.0
 */
@Service("orderFacade")
public class OrderFacadeImpl implements IOrderFacet {

	@Resource
	private ValiUser valiUser;
	
	@Resource
	private PurchaseAO purchaseAO;
	@Resource
	private PurchaseDao purchaseDAO;
	
	@Resource
	private OperatorPgDao operatorPgDao;
	@Resource
	private ChannelForwardAO channelForwardAO;
	@Resource
	private AgencyPurchaseDao agencyPurchaseDao;
	
	/**
	 * @description:查询订单详情
	 * @param orderParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午6:04:40
	 */
	@Override
	public OrderDTO getOrderDTO(QueryOrderParams orderParams) {
		AgencyBackwardPo agencyPo = valiUser.findAgency(orderParams.getUserName(), orderParams.getSign());
		OrderDTO orderDTO = null;
		PurchasePo purchasePo = null;
		OrderStateCheckEnum oscEnum = null;
		if(StringHelper.isEmpty(orderParams.getOrderId()))
		{
			oscEnum = OrderStateCheckEnum.ORDERID_ISNULL;
			return new OrderDTO(null, oscEnum.getValue(), oscEnum.getDesc());
		}else{
			Long orderId = Long.parseLong(orderParams.getOrderId());
			purchasePo = purchaseAO.getOnePurchase(orderId);
		}
		
		if(agencyPo == null)
		{
			oscEnum = OrderStateCheckEnum.AUTHENTICATION_FAILURE;
			orderDTO = new OrderDTO(null,oscEnum.getValue(), oscEnum.getDesc());
		}else if(purchasePo == null)
		{
			oscEnum = OrderStateCheckEnum.ORDER_NOT_FOUND;
			orderDTO = new OrderDTO(null,oscEnum.getValue(), oscEnum.getDesc());
		}else if(!purchasePo.getChargeTel().equals(orderParams.getNumber())){
			oscEnum = OrderStateCheckEnum.TELPHONE_ERROR;
			orderDTO = new OrderDTO(null,oscEnum.getValue(), oscEnum.getDesc());
		}
		else{//通过api更新订单状态
			oscEnum = OrderStateCheckEnum.PARAMS_SUCCESS;
			PgDataPo pgPo = operatorPgDao.get(purchasePo.getPgId());
//			AgencyPurchasePo agencyPurPo = agencyPurchaseDao.get(new WherePrams("agency_id", "=", agencyPo.getId()).and("purchase_id", "=", purchasePo.getOrderId()));
			if(pgPo != null){
				orderDTO = new OrderDTO(new OrderIn(purchasePo.getOrderId()+"", purchasePo.getOrderIdFrom(), purchasePo.getChargeTel(), pgPo.getPgSize()+"", purchasePo.getOrderAmount()+"", purchasePo.getOrderArriveTime(),purchasePo.getOrderResult(), purchasePo.getOrderResultDetail()),oscEnum.getValue(), oscEnum.getDesc());
			}
			//获取通道所属平台信息
//			ExchangePlatformPo epPo = channelForwardAO.getEpByChannelId(purchasePo.getChannelId());
//			//查看订单状态
//			OrderStateBase orderStatePage = OrderStateFactory.getOrderStateBase(epPo.getEpName());
//			OrderStateResultPage osrp = orderStatePage.getOrderState(new OrderStateParamsPage(epPo.getPgdataCheckIp(), purchasePo.getOrderIdApi(), epPo.getEpName(), epPo.getEpUserName(), epPo.getEpApikey()));
//			
//			PageOrder pageOrder = osrp.getPageOrder();
//			if(purchasePo.getOrderResult() != pageOrder.getStatus())
//			{
//				purchasePo.setOrderResult(pageOrder.getStatus());
//				if(StringHelper.isEmpty(pageOrder.getMsg())){
//					for (OrderStateEnum enumt : OrderStateEnum.values()) {
//						if(pageOrder.getStatus() == enumt.getValue())
//						{
//							purchasePo.setOrderResultDetail(enumt.getDesc());
//							break;
//						}
//					}
//				}else{
//					purchasePo.setOrderResultDetail(pageOrder.getMsg());
//				}
//				String created_at_api = pageOrder.getCreated_at();
//				purchasePo.setOrderBackTime(DateUtil.strToDate(created_at_api, null).getTime());
//				purchaseDAO.updatePurchaseState(new PurchaseStateParams(purchasePo.getOrderId(), DateUtil.strToDate(created_at_api, "").getTime() , purchasePo.getOrderResult(), purchasePo.getOrderResultDetail(),pageOrder.getTransaction_id()));
//			}
//			
//			int pgSize = operatorPgDao.get(purchasePo.getPgId()).getPgSize();
//			String createdAt = DateUtil.formatAll(purchasePo.getOrderArriveTime());
//			oscEnum = OrderStateCheckEnum.PARAMS_SUCCESS;
//			orderDTO = new OrderDTO(oscEnum.getValue(), oscEnum.getDesc(), new OrderIn(purchasePo.getOrderId()+"", orderParams.getNumber(), pgSize+"", purchasePo.getOrderAmount()+"", createdAt , osrp.getPageOrder().getStatus(), purchasePo.getOrderResultDetail()));
		}
		return orderDTO;
	}

}
