package com.weizu.flowsys.web.http.entity;

/**
 * @description: 统一返给下游的订单状态
 * @projectName:weizu-channel
 * @className:Order.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年9月2日 上午9:37:23
 * @version 1.0
 */
public class Order {
	private OrderPo orderPo;		//订单详情
	private int tipCode;			//返回状态
	private String tipMsg;			//返回状态描述
	
	public Order() {
		super();
	}
	public Order(OrderPo orderPo, int tipCode, String tipMsg) {
		super();
		this.orderPo = orderPo;
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
	}

	public OrderPo getOrderPo() {
		return orderPo;
	}

	public void setOrderPo(OrderPo orderPo) {
		this.orderPo = orderPo;
	}
	public int getTipCode() {
		return tipCode;
	}
	public void setTipCode(int tipCode) {
		this.tipCode = tipCode;
	}
	public String getTipMsg() {
		return tipMsg;
	}
	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
}
