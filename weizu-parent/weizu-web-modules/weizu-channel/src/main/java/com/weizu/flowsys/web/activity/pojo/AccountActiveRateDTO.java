package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

@TableName(name="account_active_rate")
public class AccountActiveRateDTO extends Po {
	private Long id;

	private Integer accountId;					//代理商账户id
	
    private String agencyName;

    private Long rateDiscountId;
    
    private Long channelDiscountId;				//通道折扣id
    

    private Long activeTime;
    
    private Integer bindState;					//绑定状态：0-已绑定，1-已解绑，2-未绑定
    
    private Integer bindAgencyId;				//绑定人 
    
    @TempField
    private String agencyMark;					//代理商备注
    
    @TempField
    private String accountIds;					//代理商id
    
    @TempField
    private Integer agencyTag;					//代理商类型（0-平台用户，1,-接口用户）
    
	public AccountActiveRateDTO(
			Integer accountId, 
			String agencyName,
			Long rateDiscountId,Long channelDiscountId, Long activeTime, Integer bindState,
			Integer bindAgencyId) {
		super();
		this.accountId = accountId;
		this.agencyName = agencyName;
		this.rateDiscountId = rateDiscountId;
		this.activeTime = activeTime;
		this.bindState = bindState;
		this.bindAgencyId = bindAgencyId;
		this.channelDiscountId = channelDiscountId;
	}
	
	
	
	public Long getChannelDiscountId() {
		return channelDiscountId;
	}



	public void setChannelDiscountId(Long channelDiscountId) {
		this.channelDiscountId = channelDiscountId;
	}



	public String getAgencyMark() {
		return agencyMark;
	}

	public void setAgencyMark(String agencyMark) {
		this.agencyMark = agencyMark;
	}

	public Integer getAgencyTag() {
		return agencyTag;
	}

	public void setAgencyTag(Integer agencyTag) {
		this.agencyTag = agencyTag;
	}

	public AccountActiveRateDTO() {
		super();
	}

	public String getAccountIds() {
		return accountIds;
	}

	public void setAccountIds(String accountIds) {
		this.accountIds = accountIds;
	}

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
