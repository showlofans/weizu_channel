package com.weizu.flowsys.api.hsingleton;

/**
 * @description: 查询订单状态实体
 * @projectName:weizu-channel
 * @className:TelOrderStateDTO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年3月17日 下午2:29:30
 * @version 1.0
 */
public class TelOrderStateDTO {
	private int rspCode;			//返回状态
	private String rspMsg;			//返回状态描述
	private TelOrderIn telOrderIn;	//话费订单状态详情
	
	public TelOrderStateDTO(int rspCode, String rspMsg, TelOrderIn telOrderIn) {
		super();
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
		this.telOrderIn = telOrderIn;
	}
	public TelOrderStateDTO() {
		super();
	}
	public int getRspCode() {
		return rspCode;
	}
	public void setRspCode(int rspCode) {
		this.rspCode = rspCode;
	}
	public String getRspMsg() {
		return rspMsg;
	}
	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}
	public TelOrderIn getTelOrderIn() {
		return telOrderIn;
	}
	public void setTelOrderIn(TelOrderIn telOrderIn) {
		this.telOrderIn = telOrderIn;
	}
	
	
}
