package com.weizu.flowsys.web.http.entity;

/**
 * @description: 统一的充值返回实体（页面需要的结果）
 * @projectName:weizu-channel
 * @className:ChargeTel.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年3月20日 下午2:55:29
 * @version 1.0
 */
public class ChargeTel {
	private int tipCode;				//提示信息编码:正常提单0-，提单失败1-
	private String tipMsg;				//提示信息
	private ChargeTelPo chargeTelPo;	//充值订单详情
	
	public ChargeTel(int tipCode, String tipMsg, ChargeTelPo chargeTelPo) {
		super();
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
		this.chargeTelPo = chargeTelPo;
	}
	public ChargeTel() {
		super();
	}
	public int getTipCode() {
		return tipCode;
	}
	public void setTipCode(int tipCode) {
		this.tipCode = tipCode;
	}
	public String getTipMsg() {
		return tipMsg;
	}
	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
	public ChargeTelPo getChargeTelPo() {
		return chargeTelPo;
	}
	public void setChargeTelPo(ChargeTelPo chargeTelPo) {
		this.chargeTelPo = chargeTelPo;
	}
	
}
