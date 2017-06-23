package org.weizu.api.facet.orderState;

/**
 * @description:page的order对象
 * @projectName:testHttpInterface
 * @className:PageOrder.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午9:53:50
 * @version 1.0
 */
public class PageOrder {

	private String transaction_id;
	private String user_order_id;
	private String number;
	private String flowsize;
	private String charge_fee;
	private String created_at;
	private int status;
	private String msg;
	
	public PageOrder(String transaction_id, String user_order_id,
			String number, String flowsize, String charge_fee,
			String created_at, int status, String msg) {
		super();
		this.transaction_id = transaction_id;
		this.user_order_id = user_order_id;
		this.number = number;
		this.flowsize = flowsize;
		this.charge_fee = charge_fee;
		this.created_at = created_at;
		this.status = status;
		this.msg = msg;
	}
	public PageOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
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
