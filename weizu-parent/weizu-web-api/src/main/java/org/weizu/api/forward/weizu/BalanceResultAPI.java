package org.weizu.api.forward.weizu;

import org.weizu.api.base.APIResult;

/**
 * @description:余额api结果
 * @projectName:testHttpInterface
 * @className:BalanceResultAPI.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午3:22:09
 * @version 1.0
 */
public class BalanceResultAPI extends APIResult {
	private int tipCode;
	private String tipMsg;
	private String balance;
	
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
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
}
