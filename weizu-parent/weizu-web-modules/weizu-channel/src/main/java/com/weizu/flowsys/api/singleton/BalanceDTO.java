package com.weizu.flowsys.api.singleton;

/**
 * @description: 统一余额返回实体
 * @projectName:weizu-channel
 * @className:BalanceDTO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 下午5:48:23
 * @version 1.0
 */
public class BalanceDTO {
	private Double accountBalance;		//账户余额
	private int rspCode;		//账户余额
	private String rspMsg;		//账户余额

	public BalanceDTO(Double accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}

	public BalanceDTO() {
		super();
	}

	public BalanceDTO(Double accountBalance, int rspCode, String rspMsg) {
		super();
		this.accountBalance = accountBalance;
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
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

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
