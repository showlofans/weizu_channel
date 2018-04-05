package com.weizu.flowsys.web.trade.pojo.pdd;

/**
 * @description: 拼多多公共参数
 * @projectName:weizu-channel
 * @className:PddParams.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年4月3日 下午12:02:57
 * @version 1.0
 */
public class PddParams {
	private String mctNo; 
	private String sign;
	private String signType;
	
	public PddParams(String mctNo, String sign, String signType) {
		super();
		this.mctNo = mctNo;
		this.sign = sign;
		this.signType = signType;
	}
	public PddParams() {
		super();
	}
	public String getMctNo() {
		return mctNo;
	}
	public void setMctNo(String mctNo) {
		this.mctNo = mctNo;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	
	
}
