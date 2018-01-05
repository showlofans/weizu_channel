package com.weizu.flowsys.web.agency.pojo;

/**
 * @description: 代理商订单消费统计
 * @projectName:weizu-channel
 * @className:GroupAgencyPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月5日 下午1:56:54
 * @version 1.0
 */
public class GroupAgencyRecordPo {
	
	private String agencyName;
	
	private Integer accountId;
	
	private Integer billType;	
	
	private Long numb;					//订单消费总数（略小）
	
	private Double totalAmount;				//总扣款统计	

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Long getNumb() {
		return numb;
	}

	public void setNumb(Long numb) {
		this.numb = numb;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
