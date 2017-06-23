package org.weizu.api.outter.pojo.order;

/**
 * @description: 订单查询返回的订单
 * @projectName:weizu-web-api
 * @className:OrderIn.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午5:59:28
 * @version 1.0
 */
public class OrderIn {
	
	private String orderId;
	private String number;
	private String pgSize;
	private String charge_fee;
	private String created_at;
	private int status;
	private String msg;
	
	public OrderIn(String orderId, String number, String pgSize,
			String charge_fee, String created_at, int status, String msg) {
		super();
		this.orderId = orderId;
		this.number = number;
		this.pgSize = pgSize;
		this.charge_fee = charge_fee;
		this.created_at = created_at;
		this.status = status;
		this.msg = msg;
	}
	public OrderIn() {
		super();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPgSize() {
		return pgSize;
	}
	public void setPgSize(String pgSize) {
		this.pgSize = pgSize;
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
