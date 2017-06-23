package com.weizu.flowsys.web.http.weizu;

import com.weizu.flowsys.web.http.BaseResult;

/**
 * @description: 微族订单返回实体
 * @projectName:crud
 * @className:OrderStateResult.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月16日 下午5:57:20
 * @version 1.0
 */
public class OrderStateResult extends BaseResult{
	private int errcode;
	private String errmsg;
	private Order order;
	
	/**
	 * @return the errcode
	 */
	public int getErrcode() {
		return errcode;
	}
	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}
	/**
	 * @param errmsg the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
