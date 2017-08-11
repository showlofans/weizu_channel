package com.weizu.apiTest;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.web.http.api.facet.charge.ChargeBase;
import com.weizu.flowsys.web.http.api.facet.charge.ChargeFactory;
import com.weizu.flowsys.web.http.api.facet.charge.ChargePageOrder;
import com.weizu.flowsys.web.http.api.facet.charge.impl.ChargeParamsPage;
import com.weizu.flowsys.web.http.api.facet.charge.impl.ChargeResultPage;
import com.weizu.flowsys.web.http.api.facet.orderState.OrderStateFactory;
import com.weizu.flowsys.web.http.api.facet.orderState.PageOrder;
import com.weizu.flowsys.web.http.api.facet.orderState.impl.OrderStateParamsPage;
import com.weizu.flowsys.web.http.api.facet.orderState.impl.OrderStateResultPage;
import com.weizu.flowsys.web.http.api.forward.weizu.OrderState;



public class TestCharge {

//	public static void main(String[] args) {
//		ChargeBase cb = ChargeFactory.getChargeBase("weizu");
//		
//		ChargeParamsPage cpp = new ChargeParamsPage("http://139.224.70.161:32001/api/v1/sendOrder", "weizu", "CS111111", "722c16de0a83e5bd2f988e3c7bc9fee8", "15858343638", "500");
//		ChargeResultPage crp = cb.charge(cpp);
//		System.out.println(crp.tipCode+":" + crp.tipMsg);
//		ChargePageOrder cpo = crp.getChargePageOrder();
//		System.out.println(cpo.toString());;
//		
//		//充值完了马上根据返回的订单号，查看回调结果
//		
//		OrderStateParamsPage ospp = new OrderStateParamsPage("http://139.224.70.161:32001/api/v1/orderState", cpo.getTransaction_id(), "weizu", "CS111111", "722c16de0a83e5bd2f988e3c7bc9fee8");
//		OrderState orderState = (OrderState) OrderStateFactory.getOrderStateBase(ospp.epName);
//		OrderStateResultPage  osrp = orderState.getOrderState(ospp);
//		PageOrder pageOrder = osrp.getPageOrder();
//		if(pageOrder != null){
//			System.out.println(pageOrder.getStatus());
//			System.out.println(pageOrder.getCharge_fee());
//			System.out.println(pageOrder.getCreated_at());
//		}
//		System.out.println(osrp.tipCode + ":"+osrp.tipMsg);
//		
//		
//		
////		testAPIOrder();
//		
//	}

//	private static void testAPIOrder() {
//		JSON.parseObject("", clazz)
//	}

}
