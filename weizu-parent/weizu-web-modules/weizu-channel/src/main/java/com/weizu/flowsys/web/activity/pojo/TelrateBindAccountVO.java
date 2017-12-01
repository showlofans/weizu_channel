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
public class TelrateBindAccountVO extends Po {
	
	private Long id;

    private Integer accountId;					//子代理商账户id

    private String agencyName;					//子代理商名称

    private Long telRateId;						//话费费率id

    private Long activeTime;					//更新时间
    
    private Integer bindState;					//绑定状态：0-已绑定，1-已解绑，2-未绑定
    
    private Integer bindSide;					//绑定方向：CallBackEnum 0-反向绑定 1-正向绑定
    
    private Integer bindAgencyId;				//绑定人
    
    //其他参数
    private String accountIds;					//页面参数：批量账户
    
    private Integer serviceType;				//查询参数：业务类型：HuaServiceTypeEnum
    
    private Long telchannelId;					//查询参数：话费通道id
    
    private Integer billType;					//查询参数：话费票务类型
    
    private String activeTimeStr;				//页面参数
    
    private String agencyMark;					//代理商备注
    
    private String activeDiscount;				//页面显示参数:话费折扣
    
    private Integer rateFor;					//agencyTagEnum 接口，平台
    
	public Integer getRateFor() {
		return rateFor;
	}

	public void setRateFor(Integer rateFor) {
		this.rateFor = rateFor;
	}

	public Integer getBindSide() {
		return bindSide;
	}

	public void setBindSide(Integer bindSide) {
		this.bindSide = bindSide;
	}

	public String getActiveDiscount() {
		return activeDiscount;
	}

	public void setActiveDiscount(String activeDiscount) {
		this.activeDiscount = activeDiscount;
	}

	public String getActiveTimeStr() {
		return activeTimeStr;
	}

	public void setActiveTimeStr(String activeTimeStr) {
		this.activeTimeStr = activeTimeStr;
	}

	public String getAgencyMark() {
		return agencyMark;
	}

	public void setAgencyMark(String agencyMark) {
		this.agencyMark = agencyMark;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Long getTelchannelId() {
		return telchannelId;
	}

	public void setTelchannelId(Long telchannelId) {
		this.telchannelId = telchannelId;
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
