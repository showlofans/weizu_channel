package com.weizu.flowsys.api.weizu.order;

public class QueryOrderParams {
	private String userName;			//用户账号
	private String sign;				//密钥
	private Long orderId;			//充值订单号
	private String number;				//充值号码
	
	public QueryOrderParams(String userName, String sign, Long orderId) {
		super();
		this.userName = userName;
		this.sign = sign;
		this.orderId = orderId;
	}
	public QueryOrderParams(String userName, String sign, Long orderId,
			String number) {
		super();
		this.userName = userName;
		this.sign = sign;
		this.orderId = orderId;
		this.number = number;
	}
	public QueryOrderParams() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}	
