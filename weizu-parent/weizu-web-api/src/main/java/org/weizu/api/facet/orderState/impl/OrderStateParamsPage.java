package org.weizu.api.facet.orderState.impl;

import org.weizu.api.base.PageParams;
import org.weizu.api.base.ParamsPageBase;


/**
 * @description: 获得订单状态的page参数基类（页面需要传递的参数）
 * @projectName:testHttpInterface
 * @className:OrderStateParamsPage.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午5:59:26
 * @version 1.0
 */
public class OrderStateParamsPage extends ParamsPageBase implements PageParams {

	private String order_id;	//订单id
	
	//private String user_order_id; //商户订单id(从订单表中获得)
	
	public OrderStateParamsPage(String requestUrl,String order_id, String epName,
			String epUserName, String apikey) {
		super(requestUrl, epName, epUserName, apikey);
		this.order_id = order_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
}
