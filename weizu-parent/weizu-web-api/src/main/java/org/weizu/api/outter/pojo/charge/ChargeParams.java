package org.weizu.api.outter.pojo.charge;

/**
 * @description: 下级代理充值api参数
 * @projectName:weizu-web-api
 * @className:ChargeParams.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:27:07
 * @version 1.0
 */
public class ChargeParams {
	
	private String username;			//用户账号
	private String number;				//充值号码
	private Integer flowsize;			//流量大小
	private Integer scope;				//流量范围
	private String sign;				//密钥
	private Integer billType;			//是否带票0-不带票，1-带票
	private String orderIdFrom;			//用户传过来的订单号
	
	public ChargeParams(String username, String number, Integer flowsize,
			Integer scope, String sign, Integer billType, String orderIdFrom) {
		super();
		this.username = username;
		this.number = number;
		this.flowsize = flowsize;
		this.scope = scope;
		this.sign = sign;
		this.billType = billType;
		this.orderIdFrom = orderIdFrom;
	}

	public String getOrderIdFrom() {
		return orderIdFrom;
	}

	public void setOrderIdFrom(String orderIdFrom) {
		this.orderIdFrom = orderIdFrom;
	}



	public Integer getFlowsize() {
		return flowsize;
	}

	public void setFlowsize(Integer flowsize) {
		this.flowsize = flowsize;
	}

	public Integer getScope() {
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public ChargeParams() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
