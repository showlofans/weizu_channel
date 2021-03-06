package org.weizu.api.outter.pojo.charge;

/**
 * @description: 充值返回的对象
 * @projectName:weizu-web-api
 * @className:ChargeResult.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:30:11
 * @version 1.0
 */
public class ChargeDTO {
	
	private int tipCode;				//提示信息编码
	private String tipMsg;				//提示信息
	private ChargeOrder chargeOrder;	//充值形成的订单对象
	public ChargeDTO() {
		super();
	}
	public ChargeDTO(int tipCode, String tipMsg, ChargeOrder chargeOrder) {
		super();
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
		this.chargeOrder = chargeOrder;
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
	public ChargeOrder getChargeOrder() {
		return chargeOrder;
	}
	public void setChargeOrder(ChargeOrder chargeOrder) {
		this.chargeOrder = chargeOrder;
	}
	
	
}
