package org.weizu.api.forward.weizu;

import org.weizu.api.base.APIResult;

/**
 * @description:订单状态api结果
 * @projectName:testHttpInterface
 * @className:OrderStateResultAPI.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午6:17:19
 * @version 1.0
 */
public class OrderStateResultAPI extends APIResult {
	private int errcode;
	private String errmsg;
	private Order order;
	
	
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
