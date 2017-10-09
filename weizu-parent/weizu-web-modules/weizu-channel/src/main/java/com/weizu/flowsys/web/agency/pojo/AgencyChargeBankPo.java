package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

@TableName(name="agency_charge_bank")
public class AgencyChargeBankPo extends Po {
	private Long id;					//绑定编号
	
	private Long bankAccountId;			//加款银行卡id
	
	private Integer agencyId;			//绑定代理商id
	
	private Integer billType;			//票务类型1-带票，0-不带票
	
	@TempField
	private String agencyIds;			//页面提交参数：批量代理商

	public String getAgencyIds() {
		return agencyIds;
	}

	public void setAgencyIds(String agencyIds) {
		this.agencyIds = agencyIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
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
	
	
}
