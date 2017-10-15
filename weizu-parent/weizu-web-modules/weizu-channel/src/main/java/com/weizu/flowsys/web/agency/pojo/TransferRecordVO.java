package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 转账审核记录实体
 * @projectName:weizu-channel
 * @className:TransferRecordPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月8日 上午11:17:54
 * @version 1.0
 */
public class TransferRecordVO extends Po {
	
	private Long id;				//记录id
	
//	private Long fromBankId;		//打款方引用账户id
//	
//	private Long toBankId;			//收款方引用账户id
	
	private Double commitAmount;	//打款金额
	
	private Long commitTime;		//提交时间（系统生成）
	
	private String commitTimeStr;	
	
	private Long realTime;			//真实打款时间
	
	private String realTimeStr;		//真实打款时间
	
	private Long confirmTime;		//审核时间
	
	private String confirmTimeStr;	
	
	private Integer confirmState;				//审核状态
	
	private String fromRemittanceWay;			//打款方账户名称
	
	private String fromRemittanceBankAccount;	//打款方账户号
	
	private String toRemittanceWay;				//收款方账户名称
	
	private String toRemittanceBankAccount;		//收款方账户号
	
	private String fromAgencyName;				//输出来源代理商名称
	
	private Double transferAmount;				//入账金额
	
//	private Integer fromAgencyId;	//打款方代理商id
	
//	private Integer toAgencyId;		//收款方代理商id
	
//	private Long transferSlip;		//转账凭条（在确认之后）


	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}
	
	public String getFromAgencyName() {
		return fromAgencyName;
	}
	

	public void setFromAgencyName(String fromAgencyName) {
		this.fromAgencyName = fromAgencyName;
	}
	
	public String getRealTimeStr() {
		return realTimeStr;
	}


	public void setRealTimeStr(String realTimeStr) {
		this.realTimeStr = realTimeStr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCommitAmount() {
		return commitAmount;
	}

	public void setCommitAmount(Double commitAmount) {
		this.commitAmount = commitAmount;
	}

	public Long getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(Long commitTime) {
		this.commitTime = commitTime;
	}

	public String getCommitTimeStr() {
		return commitTimeStr;
	}

	public void setCommitTimeStr(String commitTimeStr) {
		this.commitTimeStr = commitTimeStr;
	}

	public Long getRealTime() {
		return realTime;
	}

	public void setRealTime(Long realTime) {
		this.realTime = realTime;
	}

	public Long getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Long confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getConfirmTimeStr() {
		return confirmTimeStr;
	}

	public void setConfirmTimeStr(String confirmTimeStr) {
		this.confirmTimeStr = confirmTimeStr;
	}

	public Integer getConfirmState() {
		return confirmState;
	}

	public void setConfirmState(Integer confirmState) {
		this.confirmState = confirmState;
	}

	public String getFromRemittanceWay() {
		return fromRemittanceWay;
	}

	public void setFromRemittanceWay(String fromRemittanceWay) {
		this.fromRemittanceWay = fromRemittanceWay;
	}

	public String getFromRemittanceBankAccount() {
		return fromRemittanceBankAccount;
	}

	public void setFromRemittanceBankAccount(String fromRemittanceBankAccount) {
		this.fromRemittanceBankAccount = fromRemittanceBankAccount;
	}

	public String getToRemittanceWay() {
		return toRemittanceWay;
	}

	public void setToRemittanceWay(String toRemittanceWay) {
		this.toRemittanceWay = toRemittanceWay;
	}

	public String getToRemittanceBankAccount() {
		return toRemittanceBankAccount;
	}

	public void setToRemittanceBankAccount(String toRemittanceBankAccount) {
		this.toRemittanceBankAccount = toRemittanceBankAccount;
	}
	
}
