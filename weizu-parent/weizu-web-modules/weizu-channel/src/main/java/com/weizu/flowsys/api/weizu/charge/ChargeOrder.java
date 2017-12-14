package com.weizu.flowsys.api.weizu.charge;

/**
 * @description: 充值形成的订单对象
 * @projectName:weizu-web-api
 * @className:ChargeOrder.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:32:29
 * @version 1.0
 */
public class ChargeOrder {
	private String orderIdApi;			//充值之后上游返回的订单
	private String number;			//充值手机号
	private String pgSize;			//流量大小
	private Integer billType;		//是否带票 0-不带，1-带票
	
	/**
	 * @param orderIdApi String类型
	 * @param number
	 * @param pgSize
	 * @param billType
	 */
	public ChargeOrder(String orderIdApi, String number, String pgSize, Integer billType) {
		super();
		this.orderIdApi = orderIdApi;
		this.number = number;
		this.pgSize = pgSize;
		this.billType = billType;
	}
	/**
	 * @param orderIdApi Long类型
	 * @param number
	 * @param pgSize
	 * @param billType
	 */
	public ChargeOrder(Long orderIdApi, String number, int pgSize, Integer billType) {
		super();
		this.orderIdApi = orderIdApi+"";
		this.number = number;
		this.pgSize = pgSize+"";
		this.billType = billType;
	}
	
	@Override
	public String toString() {
		return "ChargeOrder [orderIdApi=" + orderIdApi + ", number=" + number
				+ ", pgSize=" + pgSize + ", billType=" + billType + "]";
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
	public String getOrderIdApi() {
		return orderIdApi;
	}
	public void setOrderIdApi(String orderIdApi) {
		this.orderIdApi = orderIdApi;
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
