package org.weizu.api.outter.pojo.charge;

/**
 * @description: 充值形成的订单对象
 * @projectName:weizu-web-api
 * @className:ChargeOrder.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:32:29
 * @version 1.0
 */
public class ChargeOrder {
	private String orderId;			//订单号
	private String number;			//充值手机号
	private String pgSize;			//流量大小
	private Integer billType;		//是否带票 0-不带，1-带票
	
	public ChargeOrder(String orderId, String number, String pgSize, Integer billType) {
		super();
		this.orderId = orderId;
		this.number = number;
		this.pgSize = pgSize;
		this.billType = billType;
	}
	public ChargeOrder(Long orderId, String number, int pgSize, Integer billType) {
		super();
		this.orderId = orderId+"";
		this.number = number;
		this.pgSize = pgSize+"";
		this.billType = billType;
	}
	
	public ChargeOrder() {
		super();
	}

	public Integer getBillType() {
		return billType;
	}
	public void setBillType(Integer billType) {
		this.billType = billType;
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
	
	
}
