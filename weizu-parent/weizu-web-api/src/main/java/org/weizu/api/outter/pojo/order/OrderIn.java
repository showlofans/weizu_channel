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
	private String chargeFee;
	private String createdAt;
	private int status;
	private String msg;
	
	public OrderIn(String orderId, String number, String pgSize,
			String chargeFee, String createdAt, int status, String msg) {
		super();
		this.orderId = orderId;
		this.number = number;
		this.pgSize = pgSize;
		this.chargeFee = chargeFee;
		this.createdAt = createdAt;
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
	public String getChargeFee() {
		return chargeFee;
	}
	public void setChargeFee(String chargeFee) {
		this.chargeFee = chargeFee;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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
