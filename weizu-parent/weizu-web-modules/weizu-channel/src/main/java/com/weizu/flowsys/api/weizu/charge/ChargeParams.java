package com.weizu.flowsys.api.weizu.charge;

/**
 * @description: 下级代理充值api参数
 * @projectName:weizu-web-api
 * @className:ChargeParams.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:27:07
 * @version 1.0
 */
public class ChargeParams {
	
	private String userName;			//用户账号
	private String number;				//充值号码
	private Integer flowsize;			//流量大小
	private Integer scope;				//业务范围()
	private String sign;				//密钥
	private Integer billType;			//是否带票0-不带票，1-带票*******
	private String orderIdFrom;			//用户传过来的订单号***********
	private Long orderArriveTime;		//传单时间
	
	private Integer pgType;				//流量类型（1-流量包，2-流量池）*****
	private Integer channelType;		//通道类型（1-普通通道包，2-红包通道，3-转移包，4-共享包）********
    private String pgValidity;			//流量有效期(PgValidityEnum)********
    private String reportUrl;			//回调地址
    
    private String requestIp;			//请求地址
	
    
    
	public ChargeParams(Integer scope, Integer flowsize, Integer pgType,
			Integer channelType, String pgValidity) {
		super();
		this.scope = scope;
		this.flowsize = flowsize;
		this.pgType = pgType;
		this.channelType = channelType;
		this.pgValidity = pgValidity;
	}

	public ChargeParams(String userName, String number, Integer flowsize,
			Integer scope, String sign, Integer billType, Long orderArriveTime) {
		super();
		this.userName = userName;
		this.number = number;
		this.flowsize = flowsize;
		this.scope = scope;
		this.sign = sign;
		this.billType = billType;
		this.orderArriveTime = orderArriveTime;
	}
	
	public ChargeParams(String number, Integer flowsize, Integer billType) {
		super();
		this.number = number;
		this.flowsize = flowsize;
		this.billType = billType;
	}
	@Override
	public String toString() {
		return "ChargeParams [userName=" + userName + ", number=" + number
				+ ", flowsize=" + flowsize + ", scope=" + scope + ", sign="
				+ sign + ", billType=" + billType + ", orderIdFrom="
				+ orderIdFrom + ", pgType=" + pgType + ", channelType="
				+ channelType + ", pgValidity=" + pgValidity + ", reportUrl="
				+ reportUrl + "]";
	}
	
	
	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public Long getOrderArriveTime() {
		return orderArriveTime;
	}

	public void setOrderArriveTime(Long orderArriveTime) {
		this.orderArriveTime = orderArriveTime;
	}

	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	public Integer getChannelType() {
		return channelType;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	public Integer getPgType() {
		return pgType;
	}

	public void setPgType(Integer pgType) {
		this.pgType = pgType;
	}

	public String getPgValidity() {
		return pgValidity;
	}

	public void setPgValidity(String pgValidity) {
		this.pgValidity = pgValidity;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
