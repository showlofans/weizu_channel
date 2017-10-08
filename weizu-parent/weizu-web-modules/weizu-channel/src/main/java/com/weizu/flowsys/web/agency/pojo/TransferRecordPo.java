package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 转账审核记录实体
 * @projectName:weizu-channel
 * @className:TransferRecordPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月8日 上午11:17:54
 * @version 1.0
 */
@TableName(name="transfer_record")
public class TransferRecordPo extends Po {
	
	private Long id;				//记录id
	
	private Long fromBankId;		//打款方引用账户id
	
	private Long toBankId;			//收款方引用账户id
	
	private Double commitAmount;	//打款金额
	
	private Long commitTime;		//提交时间（系统生成）
	
	private Long realTime;			//真实打款时间
	
	private Long confirmTime;		//审核时间
	
	private Integer confirmState;	//审核状态
	
	private Integer fromAgencyId;	//打款方代理商id
	
	private Integer toAgencyId;		//收款方代理商id
	
	private Long transferSlip;		//转账凭条（在确认之后）

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFromBankId() {
		return fromBankId;
	}

	public void setFromBankId(Long fromBankId) {
		this.fromBankId = fromBankId;
	}

	public Long getToBankId() {
		return toBankId;
	}

	public void setToBankId(Long toBankId) {
		this.toBankId = toBankId;
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

	public Integer getConfirmState() {
		return confirmState;
	}

	public void setConfirmState(Integer confirmState) {
		this.confirmState = confirmState;
	}

	public Integer getFromAgencyId() {
		return fromAgencyId;
	}

	public void setFromAgencyId(Integer fromAgencyId) {
		this.fromAgencyId = fromAgencyId;
	}

	public Integer getToAgencyId() {
		return toAgencyId;
	}

	public void setToAgencyId(Integer toAgencyId) {
		this.toAgencyId = toAgencyId;
	}

	public Long getTransferSlip() {
		return transferSlip;
	}

	public void setTransferSlip(Long transferSlip) {
		this.transferSlip = transferSlip;
	}
	
}
