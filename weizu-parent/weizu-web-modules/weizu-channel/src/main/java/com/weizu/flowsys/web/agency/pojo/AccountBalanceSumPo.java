package com.weizu.flowsys.web.agency.pojo;

import java.io.Serializable;

/**
 * @description: 账户余额统计实体
 * @projectName:weizu-channel
 * @className:AccountBalanceSumPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年3月7日 下午2:41:34
 * @version 1.0
 */
public class AccountBalanceSumPo implements Serializable {
	private Integer agencyId;			//代理商账户id
	
	private Integer billType;			//账户类型
	
	private Double balanceSum;			//统计出来的余额
	
	private Double ableBalance;			//可支配余额(可提现余额)
	
	private Double unableBalance;		//无法支配余额(分配给下级代理商的余额)

	public AccountBalanceSumPo(Integer billType, Double balanceSum,
			Double ableBalance, Double unableBalance) {
		super();
		this.billType = billType;
		this.balanceSum = balanceSum;
		this.ableBalance = ableBalance;
		this.unableBalance = unableBalance;
	}
	
//	public AccountBalanceSumPo(Integer agencyId, Integer billType,
//			Double balanceSum, Double ableBalance, Double unableBalance) {
//		super();
//		this.agencyId = agencyId;
//		this.billType = billType;
//		this.balanceSum = balanceSum;
//		this.ableBalance = ableBalance;
//		this.unableBalance = unableBalance;
//	}

	public AccountBalanceSumPo() {
		super();
	}

	@Override
	public String toString() {
		return "AccountBalanceSumPo [agencyId=" + agencyId + ", billType="
				+ billType + ", balanceSum=" + balanceSum + ", ableBalance="
				+ ableBalance + ", unableBalance=" + unableBalance + "]";
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Double getBalanceSum() {
		return balanceSum;
	}

	public void setBalanceSum(Double balanceSum) {
		this.balanceSum = balanceSum;
	}

	public Double getAbleBalance() {
		return ableBalance;
	}

	public void setAbleBalance(Double ableBalance) {
		this.ableBalance = ableBalance;
	}

	public Double getUnableBalance() {
		return unableBalance;
	}

	public void setUnableBalance(Double unableBalance) {
		this.unableBalance = unableBalance;
	}
	
	
}
