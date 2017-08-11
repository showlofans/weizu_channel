package com.weizu.flowsys.web.http.api.forward.weizu;

import com.weizu.flowsys.web.http.api.base.APIResult;


/**
 * @description: 充值结果api实体
 * @projectName:testHttpInterface
 * @className:ChargeResultAPI.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午10:47:25
 * @version 1.0
 */
public class ChargeResultAPI extends APIResult {
	
	private int tipCode;
	private String tipMsg;
	
	private ChargeAPIOrder order;		//api充值返回订单实体

	public ChargeResultAPI(int tipCode, String tipMsg, ChargeAPIOrder order) {
		super();
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
		this.order = order;
	}

	public ChargeResultAPI() {
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

	public ChargeAPIOrder getOrder() {
		return order;
	}

	public void setOrder(ChargeAPIOrder order) {
		this.order = order;
	}
}
