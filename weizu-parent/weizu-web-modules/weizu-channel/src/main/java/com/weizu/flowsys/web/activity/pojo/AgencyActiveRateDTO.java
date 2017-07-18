package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

@TableName(name="agency_active_rate")
public class AgencyActiveRateDTO extends Po {
	private Long id;

    private Integer agencyId;					//子代理商id

    private String agencyName;

    private Long rateDiscountId;

    private Long activeTime;
    
    private Integer bindState;					//绑定状态：0-已绑定，1-已解绑，2-未绑定
    
    private Integer bindAgencyId;				//绑定人 
    
    @TempField
    private String agencyIds;					//代理商id
    
	public AgencyActiveRateDTO(Integer agencyId, String agencyName,
			Long rateDiscountId, Long activeTime, Integer bindState,
			Integer bindAgencyId) {
		super();
		this.agencyId = agencyId;
		this.agencyName = agencyName;
		this.rateDiscountId = rateDiscountId;
		this.activeTime = activeTime;
		this.bindState = bindState;
		this.bindAgencyId = bindAgencyId;
	}

	public AgencyActiveRateDTO() {
		super();
	}

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

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Long getRateDiscountId() {
		return rateDiscountId;
	}

	public void setRateDiscountId(Long rateDiscountId) {
		this.rateDiscountId = rateDiscountId;
	}

	public Long getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Long activeTime) {
		this.activeTime = activeTime;
	}

	public Integer getBindState() {
		return bindState;
	}

	public void setBindState(Integer bindState) {
		this.bindState = bindState;
	}

	public Integer getBindAgencyId() {
		return bindAgencyId;
	}

	public void setBindAgencyId(Integer bindAgencyId) {
		this.bindAgencyId = bindAgencyId;
	}
    
}
