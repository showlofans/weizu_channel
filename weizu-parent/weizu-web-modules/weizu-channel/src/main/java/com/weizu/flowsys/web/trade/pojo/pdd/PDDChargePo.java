package com.weizu.flowsys.web.trade.pojo.pdd;

/**
 * @description: 拼多多充值返回实体
 * @projectName:weizu-channel
 * @className:PDDChargePo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年4月2日 下午5:08:45
 * @version 1.0
 */
public class PDDChargePo {
	private int resultCode;
	
	private String resultMsg;
	
	private PDDChargeInPo resultData;

	public PDDChargePo(int resultCode, String resultMsg,
			PDDChargeInPo resultData) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultData = resultData;
	}
	

	public PDDChargePo() {
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

	public PDDChargeInPo getResultData() {
		return resultData;
	}

	public void setResultData(PDDChargeInPo resultData) {
		this.resultData = resultData;
	}
	
}
