package com.weizu.flowsys.web.http.entity;

/**
 * @description: 充值返回给下游的订单详情
 * @projectName:weizu-web-api
 * @className:ChargeOrder.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:32:29
 * @version 1.0
 */
public class ChargePo {
	private Long orderId;			//返给下游的订单号
	private String number;			//充值手机号
	private Integer pgSize;			//流量大小
	private Integer billType;		//是否带票 0-不带，1-带票
	
	/**
	 * @param orderIdApi Long类型
	 * @param number
	 * @param pgSize
	 * @param billType
	 */
	public ChargePo(Long orderId, String number, Integer pgSize,
			Integer billType) {
		super();
		this.orderId = orderId;
		this.number = number;
		this.pgSize = pgSize;
		this.billType = billType;
	}
	public ChargePo() {
		super();
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
	public Integer getPgSize() {
		return pgSize;
	}

	public void setPgSize(Integer pgSize) {
		this.pgSize = pgSize;
	}

}
