package com.weizu.flowsys.web.agency.pojo;

/**
 * @description: 代理商订单消费统计
 * @projectName:weizu-channel
 * @className:GroupAgencyPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月5日 下午1:56:54
 * @version 1.0
 */
public class GroupAgencyRecordVo {
	
	private String agencyName;
	
	private Integer accountId;
	
	private Integer billType;	
	
	private Long replenishmentNumb;				//补款总数（略小）
	
	private Long decreaseNumb;					//扣款总数（略小）
	
	private Double decreaseAmount;				//总扣款金额	
	
	private Double replenishmentAmount;			//总补款金额	
	
	private Long numb;							//实际扣款总数
	
	private Double totalAmount;					//实际扣款金额
	
	private Double realOrderPer;				//有效订单率
	
	public GroupAgencyRecordVo(String agencyName, Integer accountId,
			Integer billType, Long replenishmentNumb, Long decreaseNumb,
			Double decreaseAmount, Double replenishmentAmount, Long numb,
			Double totalAmount) {
		super();
		this.agencyName = agencyName;
		this.accountId = accountId;
		this.billType = billType;
		this.replenishmentNumb = replenishmentNumb;
		this.decreaseNumb = decreaseNumb;
		this.decreaseAmount = decreaseAmount;
		this.replenishmentAmount = replenishmentAmount;
		this.numb = numb;
		this.totalAmount = totalAmount;
	}
	
	public Double getRealOrderPer() {
		return realOrderPer;
	}

	public void setRealOrderPer(Double realOrderPer) {
		this.realOrderPer = realOrderPer;
	}

	public GroupAgencyRecordVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getReplenishmentNumb() {
		return replenishmentNumb;
	}

	public void setReplenishmentNumb(Long replenishmentNumb) {
		this.replenishmentNumb = replenishmentNumb;
	}

	public Long getDecreaseNumb() {
		return decreaseNumb;
	}

	public void setDecreaseNumb(Long decreaseNumb) {
		this.decreaseNumb = decreaseNumb;
	}

	public Double getDecreaseAmount() {
		return decreaseAmount;
	}

	public void setDecreaseAmount(Double decreaseAmount) {
		this.decreaseAmount = decreaseAmount;
	}

	public Double getReplenishmentAmount() {
		return replenishmentAmount;
	}

	public void setReplenishmentAmount(Double replenishmentAmount) {
		this.replenishmentAmount = replenishmentAmount;
	}

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
