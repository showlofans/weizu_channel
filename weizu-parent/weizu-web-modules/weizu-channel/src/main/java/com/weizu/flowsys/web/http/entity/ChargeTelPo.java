package com.weizu.flowsys.web.http.entity;

/**
 * @description: 充值返回给下游的订单详情
 * @projectName:weizu-web-api
 * @className:ChargeOrder.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:32:29
 * @version 1.0
 */
public class ChargeTelPo {
	private Long orderId;			//返给下游的订单号
	private String number;			//充值手机号
	private Double chargeValue;		//话费价值
	private Double chargeAmount;		//实际扣款
	private Integer billType;		//是否带票 0-不带，1-带票
	
	/**
	 * @param orderIdApi Long类型
	 * @param number
	 * @param pgSize
	 * @param billType
	 */
	public ChargeTelPo(Long orderId, String number, Double chargeValue,
			Double chargeAmount, Integer billType) {
		super();
		this.orderId = orderId;
		this.number = number;
		this.chargeValue = chargeValue;
		this.billType = billType;
		this.chargeAmount = chargeAmount;
	}
	public ChargeTelPo() {
		super();
	}
	
	@Override
	public String toString() {
		return "ChargeTelPo [orderId=" + orderId + ", number=" + number
				+ ", chargeValue=" + chargeValue + ", chargeAmount="
				+ chargeAmount + ", billType=" + billType + "]";
	}
	public Integer getBillType() {
		return billType;
	}
	public void setBillType(Integer billType) {
		this.billType = billType;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getChargeValue() {
		return chargeValue;
	}
	public void setChargeValue(Double chargeValue) {
		this.chargeValue = chargeValue;
	}
	public Double getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(Double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	
}
