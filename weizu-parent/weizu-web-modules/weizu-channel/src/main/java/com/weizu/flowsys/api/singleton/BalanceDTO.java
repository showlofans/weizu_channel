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
	private int tipCode;			//返回状态
	private String tipMsg;			//返回状态描述
	private int billType;		//账户类型

	public BalanceDTO(Double accountBalance, int tipCode, String tipMsg,
			int billType) {
		super();
		this.accountBalance = accountBalance;
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
		this.billType = billType;
	}

	public BalanceDTO(Double accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}

	public BalanceDTO() {
		super();
	}

	public int getBillType() {
		return billType;
	}

	public void setBillType(int billType) {
		this.billType = billType;
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

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
