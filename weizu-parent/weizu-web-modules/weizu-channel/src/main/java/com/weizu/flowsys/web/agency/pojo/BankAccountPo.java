package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 引用账户信息实体
 * @projectName:weizu-channel
 * @className:BankAccountPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月8日 上午11:10:45
 * @version 1.0
 */
@TableName(name="bank_account")
public class BankAccountPo extends Po {
	
	private Long id;
	
	private Integer accountId;			//待充值账户Id
	
	private String remittanceWay;		//汇款方式 
	
	private String remittancBankAccount;	//汇款账号
	
	private String accountName;				//汇款账号真实姓名
	
	private Double referenceBalance;		//对账余额
	
	private Integer agencyId;			//待充值账户所属代理商id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getRemittanceWay() {
		return remittanceWay;
	}

	public void setRemittanceWay(String remittanceWay) {
		this.remittanceWay = remittanceWay;
	}

	public String getRemittancBankAccount() {
		return remittancBankAccount;
	}

	public void setRemittancBankAccount(String remittancBankAccount) {
		this.remittancBankAccount = remittancBankAccount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getReferenceBalance() {
		return referenceBalance;
	}

	public void setReferenceBalance(Double referenceBalance) {
		this.referenceBalance = referenceBalance;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}
	
}
