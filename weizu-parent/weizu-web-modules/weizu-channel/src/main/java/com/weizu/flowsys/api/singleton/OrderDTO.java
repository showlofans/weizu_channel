package com.weizu.flowsys.api.singleton;

/**
 * @description: 接口订单状态统一返回实体
 * @projectName:weizu-channel
 * @className:OrderDTO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 下午5:47:57
 * @version 1.0
 */
public class OrderDTO {
	private OrderIn orderIn;		//订单明细
	private int rspCode;			//返回状态
	private String rspMsg;			//返回状态描述
	
	public OrderDTO(OrderIn orderIn, int rspCode, String rspMsg) {
		super();
		this.orderIn = orderIn;
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}
	public OrderDTO() {
		super();
	}
	public OrderIn getOrderIn() {
		return orderIn;
	}
	public void setOrderIn(OrderIn orderIn) {
		this.orderIn = orderIn;
	}
	public int getRspCode() {
		return rspCode;
	}
	public void setRspCode(int rspCode) {
		this.rspCode = rspCode;
	}
	public String getRspMsg() {
		return rspMsg;
	}
	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}
	
	

	


}
