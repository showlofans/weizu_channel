package org.weizu.api.forward.weizu;

import org.weizu.api.base.APIParams;
import org.weizu.api.base.APIResult;
import org.weizu.api.base.PageParams;
import org.weizu.api.base.PageResult;
import org.weizu.api.facet.orderState.OrderStateBase;
import org.weizu.api.facet.orderState.PageOrder;
import org.weizu.api.facet.orderState.impl.OrderStateParamsPage;
import org.weizu.api.facet.orderState.impl.OrderStateResultPage;
import org.weizu.web.foundation.http.HttpRequest;

import com.alibaba.fastjson.JSON;

/**
 * @description:订单状态对上接口
 * @projectName:testHttpInterface
 * @className:OrderState.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午9:19:47
 * @version 1.0
 */
public class OrderState implements OrderStateBase{

	/**
	 * @description:初始化参数
	 * @param pp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午6:12:51
	 */
	@Override
	public APIParams initParams(PageParams pp) {
		OrderStateParamsPage ospp = (OrderStateParamsPage)pp;
		OrderStateParamsAPI ospapi = new OrderStateParamsAPI(ospp.epUserName, ospp.getOrder_id(), ospp.apikey, ospp.requestUrl, ospp.epName);
		return ospapi;
	}

	/**
	 * @description:获得结果
	 * @param apir
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午6:13:06
	 */
	@Override
	public PageResult resetResult(APIResult apir) {
		OrderStateResultAPI osrapi = (OrderStateResultAPI)apir;
		Order order = osrapi.getOrder();//api orderd对象
		PageOrder pageOrder = null;
		if(order != null){
			pageOrder = new PageOrder(order.getTransaction_id(), order.getUser_order_id(), order.getNumber(), order.getFlowsize(), order.getCharge_fee(), order.getCreated_at(), order.getStatus(), order.getMsg());
		}
		OrderStateResultPage osrp = new OrderStateResultPage(osrapi.getErrcode(), osrapi.getErrmsg(),pageOrder);
		
		return osrp;
	}

	/**
	 * @description:获取订单状态
	 * @param ospp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月20日 上午9:27:37
	 */
	@Override
	public OrderStateResultPage getOrderState(OrderStateParamsPage ospp) {
		OrderStateParamsAPI ospapi = (OrderStateParamsAPI)initParams(ospp);
		String jsonStr = HttpRequest.sendGet(ospp.requestUrl, ospapi.toParams());
		System.out.println(ospapi.toParams());
		OrderStateResultAPI osrapi = JSON.parseObject(jsonStr, OrderStateResultAPI.class);
		OrderStateResultPage osrp = (OrderStateResultPage)resetResult(osrapi);
		return osrp;
	}

}
