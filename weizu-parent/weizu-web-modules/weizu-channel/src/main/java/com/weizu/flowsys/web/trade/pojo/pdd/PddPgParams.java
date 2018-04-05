package com.weizu.flowsys.web.trade.pojo.pdd;

import com.weizu.flowsys.core.annotation.po.TempField;

public class PddPgParams extends PddParams{
//	private PddParams pddParams;
	
	private String outOrderNo; 
	private String proNo;
	private Integer amount; 
	private String mobile; 
	private String notifyUrl; 
	
	private Integer resType; 
	private Integer dataFloat;
	private Integer expireDay;
	@TempField
	private String requestIp;
	
	public PddPgParams(String outOrderNo, String proNo, Integer amount,
			String mobile, String notifyUrl, Integer resType,
			Integer dataFloat, Integer expireDay,String mctNo, String sign, String signType) {
		super(mctNo, sign, signType);
		this.outOrderNo = outOrderNo;
		this.proNo = proNo;
		this.amount = amount;
		this.mobile = mobile;
		this.notifyUrl = notifyUrl;
		this.resType = resType;
		this.dataFloat = dataFloat;
		this.expireDay = expireDay;
	}
	
	public PddPgParams(String mctNo, String sign, String signType,
			String outOrderNo, String proNo, Integer amount, String mobile,
			String notifyUrl) {
		super(mctNo, sign, signType);
		this.outOrderNo = outOrderNo;
		this.proNo = proNo;
		this.amount = amount;
		this.mobile = mobile;
		this.notifyUrl = notifyUrl;
	}



	public PddPgParams() {
		super();
	}

	public PddPgParams(String mctNo, String sign, String signType) {
		super(mctNo, sign, signType);
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getOutOrderNo() {
		return outOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	public String getProNo() {
		return proNo;
	}
	public void setProNo(String proNo) {
		this.proNo = proNo;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public Integer getResType() {
		return resType;
	}
	public void setResType(Integer resType) {
		this.resType = resType;
	}
	public Integer getDataFloat() {
		return dataFloat;
	}
	public void setDataFloat(Integer dataFloat) {
		this.dataFloat = dataFloat;
	}
	public Integer getExpireDay() {
		return expireDay;
	}
	public void setExpireDay(Integer expireDay) {
		this.expireDay = expireDay;
	}
	
	
	
	
}
