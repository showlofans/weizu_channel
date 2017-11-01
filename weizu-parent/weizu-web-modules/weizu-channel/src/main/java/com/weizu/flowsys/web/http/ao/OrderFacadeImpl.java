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
import com.weizu.flowsys.web.channel.dao.impl.OperatorPgDao;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.http.entity.Order;
import com.weizu.flowsys.web.http.entity.OrderPo;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.dao.AccountPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.DateUtil;
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
//	@Resource
//	private AccountPurchaseDao accountPurchaseDao;
	
	/**
	 * @description:查询订单详情
	 * @param orderParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午6:04:40
	 */
	@Override
	public Order getOrder(QueryOrderParams orderParams) {
		AgencyBackwardPo agencyPo = valiUser.findAgency(orderParams.getUserName(), orderParams.getSign());
		Order order = null;
		PurchasePo purchasePo = null;
		OrderStateCheckEnum oscEnum = null;
//		if(StringHelper.isEmpty(orderParams.getOrderId()))
//		{
//			oscEnum = OrderStateCheckEnum.ORDERID_ISNULL;
//			return new OrderDTO(null, oscEnum.getValue(), oscEnum.getDesc());
//		}
		
		if(agencyPo == null)
		{
			oscEnum = OrderStateCheckEnum.AUTHENTICATION_FAILURE;
			order = new Order(null,oscEnum.getValue(), oscEnum.getDesc());
		}else{
			if(orderParams.getOrderId() == null)
			{
				oscEnum = OrderStateCheckEnum.ORDERID_ISNULL;
				return new Order(null, oscEnum.getValue(), oscEnum.getDesc());
			}
			purchasePo = purchaseDAO.getMyPurchase(agencyPo.getId(), orderParams.getOrderId());
			if(purchasePo == null)
			{
				oscEnum = OrderStateCheckEnum.ORDER_NOT_FOUND;
				order = new Order(null,oscEnum.getValue(), oscEnum.getDesc());
			}
			else if(orderParams.getNumber() != null && !purchasePo.getChargeTel().equals(orderParams.getNumber())){
				oscEnum = OrderStateCheckEnum.TELPHONE_ERROR;
				order = new Order(null,oscEnum.getValue(), oscEnum.getDesc());
			}
			else{//通过api更新订单状态
				oscEnum = OrderStateCheckEnum.PARAMS_SUCCESS;
				PgDataPo pgPo = operatorPgDao.get(purchasePo.getPgId());
//			AgencyPurchasePo agencyPurPo = accountPurchaseDao.get(new WherePrams("agency_id", "=", agencyPo.getId()).and("purchase_id", "=", purchasePo.getOrderId()));
				if(pgPo != null){
					String orderArriveTime = DateUtil.formatAll(purchasePo.getOrderArriveTime());
					OrderPo orderPo = new OrderPo(purchasePo.getOrderId(), purchasePo.getOrderIdFrom(), purchasePo.getChargeTel(), pgPo.getPgSize(), purchasePo.getOrderAmount(), orderArriveTime, purchasePo.getOrderResult(), purchasePo.getOrderResultDetail());
					order = new Order(orderPo, oscEnum.getValue(), oscEnum.getDesc());
//					OrderIn orderIn = new OrderIn(purchasePo.getOrderId()+"", purchasePo.getOrderIdFrom(), purchasePo.getChargeTel(), pgPo.getPgSize()+"", purchasePo.getOrderAmount()+"", purchasePo.getOrderArriveTime(),purchasePo.getOrderResult(), purchasePo.getOrderResultDetail());
//					orderDTO = new OrderDTO(orderIn,oscEnum.getValue(), oscEnum.getDesc());
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
		} 
		return order;
	}

}
