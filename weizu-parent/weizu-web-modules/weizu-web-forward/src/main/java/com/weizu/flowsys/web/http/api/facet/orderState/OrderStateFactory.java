package com.weizu.flowsys.web.http.api.facet.orderState;

public class OrderStateFactory {
	
	/**
	 * @description:获得状态对象
	 * @param epName
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月20日 上午9:36:34
	 */
	public static OrderStateBase getOrderStateBase(String epName){
		OrderStateBase osb = null;
		if("wzkj".equals(epName)){
			osb = new com.weizu.flowsys.web.http.api.forward.weizu.OrderState();
		}
		
		return osb;
	}
}
