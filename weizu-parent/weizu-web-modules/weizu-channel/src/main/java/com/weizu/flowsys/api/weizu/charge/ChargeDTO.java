package com.weizu.flowsys.api.weizu.charge;

/**
 * @description: 统一的充值返回实体（页面需要的结果）
 * @projectName:weizu-web-api
 * @className:ChargeResult.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:30:11
 * @version 1.0
 */
public class ChargeDTO {
	
	private Integer tipCode;				//提示信息编码:正常提单0-，提单失败1-
	private String tipMsg;				//提示信息
	
	private String jsonStr;				//上游返回的json串
	private boolean ajaxDoublePurchase;	//异步提交出现重复订单，需要生成新的订单号标记
	
	private ChargeOrder chargeOrder;	//充值形成的订单对象
	public ChargeDTO() {
		super();
	}
	
	@Override
	public String toString() {
		if(chargeOrder != null){
			return "ChargeDTO [tipCode=" + tipCode + ", tipMsg=" + tipMsg
					+ ", chargeOrder=" + chargeOrder.toString() + "]";
		}else{
			return "ChargeDTO [tipCode=" + tipCode + ", tipMsg=" + tipMsg
					+ ", chargeOrder=" + null + "]";
		}
	}

	public ChargeDTO(int tipCode, String tipMsg, ChargeOrder chargeOrder) {
		super();
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
		this.chargeOrder = chargeOrder;
	}
	
	public boolean getAjaxDoublePurchase() {
		return ajaxDoublePurchase;
	}

	public void setAjaxDoublePurchase(boolean ajaxDoublePurchase) {
		this.ajaxDoublePurchase = ajaxDoublePurchase;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	public Integer getTipCode() {
		return tipCode;
	}
	public void setTipCode(Integer tipCode) {
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
