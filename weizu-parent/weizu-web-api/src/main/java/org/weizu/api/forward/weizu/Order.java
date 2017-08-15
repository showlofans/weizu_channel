package org.weizu.api.forward.weizu;

/**
 * @description: 微族订单返回实体
 * @projectName:crud
 * @className:Order.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月16日 下午5:55:39
 * @version 1.0
 */
public class Order {
	private String transaction_id;
	private String user_order_id;
	private String number;
	private String flowsize;
	private String charge_fee;
	private String created_at;
	private int status;
	private String msg;
	
	public Order() {
		super();
	}
	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}
	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	/**
	 * @return the user_order_id
	 */
	public String getUser_order_id() {
		return user_order_id;
	}
	/**
	 * @param user_order_id the user_order_id to set
	 */
	public void setUser_order_id(String user_order_id) {
		this.user_order_id = user_order_id;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the flowsize
	 */
	public String getFlowsize() {
		return flowsize;
	}
	/**
	 * @param flowsize the flowsize to set
	 */
	public void setFlowsize(String flowsize) {
		this.flowsize = flowsize;
	}
	/**
	 * @return the charge_fee
	 */
	public String getCharge_fee() {
		return charge_fee;
	}
	/**
	 * @param charge_fee the charge_fee to set
	 */
	public void setCharge_fee(String charge_fee) {
		this.charge_fee = charge_fee;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
