package com.weizu.flowsys.web.trade.pojo.pdd;

/**
 * @description: 拼多多充值返回实体
 * @projectName:weizu-channel
 * @className:PDDChargePo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年4月2日 下午5:08:45
 * @version 1.0
 */
public class PDDChargeTelPo {
	private int resultCode;
	
	private String resultMsg;
	
	private PDDChargeTelInPo resultData;

	public PDDChargeTelPo(int resultCode, String resultMsg,
			PDDChargeTelInPo resultData) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultData = resultData;
	}
	

	public PDDChargeTelPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public PDDChargeTelInPo getResultData() {
		return resultData;
	}

	public void setResultData(PDDChargeTelInPo resultData) {
		this.resultData = resultData;
	}
	
}
