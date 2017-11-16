package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 代理商账户和话费折扣绑定实体
 * @projectName:weizu-channel
 * @className:TelrateBindAccount.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午3:03:33
 * @version 1.0
 */
@TableName(name="telrate_bind_account")
public class TelrateBindAccountPo extends Po {
	
	private Long id;

    private Integer accountId;					//子代理商账户id

    private String agencyName;					//子代理商名称

    private Long telRateId;						//话费费率id

    private Long activeTime;					//更新时间
    
    private Integer bindState;					//绑定状态：0-已绑定，1-已解绑，2-未绑定
    
    private Integer bindAgencyId;				//绑定人
    @TempField
    private String accountIds;					//页面参数：批量账户
    
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

	public Long getTelRateId() {
		return telRateId;
	}

	public void setTelRateId(Long telRateId) {
		this.telRateId = telRateId;
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
