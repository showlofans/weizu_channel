package com.weizu.flowsys.api.weizu.charge;

/**
 * @description: 话充接口参数
 * @projectName:weizu-channel
 * @className:ChargeTelParams.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年3月20日 下午2:41:07
 * @version 1.0
 */
public class ChargeTelParams {
	
	private String number;
	private String userName; 
	private String sign;
	private Integer serviceType;
	private Integer billType;
	private Integer chargeSpeed;
	private String reportUrl;
	private String userOrderId;
	private Double chargeValue;
	
	 private String requestIp;			//请求地址
	
	public ChargeTelParams(String number, String userName, String sign,
			 Double chargeValue) {
		super();
		this.chargeValue = chargeValue;
		this.number = number;
		this.userName = userName;
		this.sign = sign;
	}
	
	public ChargeTelParams(String number, String userName, String sign,
			String reportUrl, String userOrderId, Double chargeValue) {
		super();
		this.number = number;
		this.userName = userName;
		this.sign = sign;
		this.reportUrl = reportUrl;
		this.userOrderId = userOrderId;
		this.chargeValue = chargeValue;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public Double getChargeValue() {
		return chargeValue;
	}


	public void setChargeValue(Double chargeValue) {
		this.chargeValue = chargeValue;
	}


	public ChargeTelParams() {
		super();
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	public Integer getBillType() {
		return billType;
	}
	public void setBillType(Integer billType) {
		this.billType = billType;
	}
	public Integer getChargeSpeed() {
		return chargeSpeed;
	}
	public void setChargeSpeed(Integer chargeSpeed) {
		this.chargeSpeed = chargeSpeed;
	}
	public String getReportUrl() {
		return reportUrl;
	}
	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}
	public String getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(String userOrderId) {
		this.userOrderId = userOrderId;
	}
	
	
}
