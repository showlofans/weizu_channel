package com.weizu.flowsys.web.http.entity;

/**
 * @description: 统一的充值返回实体（页面需要的结果）
 * @projectName:weizu-web-api
 * @className:ChargeResult.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:30:11
 * @version 1.0
 */
public class Charge {
	private int tipCode;				//提示信息编码:正常提单0-，提单失败1-
	private String tipMsg;				//提示信息
	private ChargePo chargePo;			//充值订单详情
	public Charge() {
		super();
	}
	public Charge(int tipCode, String tipMsg, ChargePo chargePo) {
		super();
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
		this.chargePo = chargePo;
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
	public ChargePo getChargeOrder() {
		return chargePo;
	}
	public void setChargeOrder(ChargePo chargePo) {
		this.chargePo = chargePo;
	}
	
	
}