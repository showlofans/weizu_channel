package com.weizu.flowsys.web.activity.pojo;

import java.util.List;

import org.weizu.web.foundation.core.annotation.po.TempField;

/**
 * @description:费率实体
 * @projectName:crud
 * @className:RateBackwardPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月17日 下午5:58:47
 * @version 1.0
 */
public class RateBackwardVo {
	
	@TempField
	private Integer agencyId;	//代理商id
	
	private Integer billType;	//票务类型
	
	private String rateName;	
	
	@TempField
	private List<OperatorDiscount> operatorDiscount;

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public List<OperatorDiscount> getOperatorDiscount() {
		return operatorDiscount;
	}

	public void setOperatorDiscount(List<OperatorDiscount> operatorDiscount) {
		this.operatorDiscount = operatorDiscount;
	}
	
}
