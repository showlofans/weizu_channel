package com.weizu.flowsys.api.singleton;

/**
 * @description: 订单状态统一返回实体
 * @projectName:weizu-channel
 * @className:OrderDTO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 下午5:47:57
 * @version 1.0
 */
public class OrderDTO {
	private String transaction_id;
	private String user_order_id;
	private String number;
	private String flowsize;
	private String charge_fee;
	private String created_at;
	private int status;
	private String msg;
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getUser_order_id() {
		return user_order_id;
	}
	public void setUser_order_id(String user_order_id) {
		this.user_order_id = user_order_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFlowsize() {
		return flowsize;
	}
	public void setFlowsize(String flowsize) {
		this.flowsize = flowsize;
	}
	public String getCharge_fee() {
		return charge_fee;
	}
	public void setCharge_fee(String charge_fee) {
		this.charge_fee = charge_fee;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
