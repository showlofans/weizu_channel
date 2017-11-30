package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;

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
    
    private Integer bindSide;					//绑定方向：CallBackEnum 0-反向绑定 1-正向绑定
    
    private Integer bindAgencyId;				//绑定人
    
    @TempField
    private String activeTimeStr;				//页面参数
//    @TempField
//    private String accountIds;					//页面参数：批量账户
//    @TempField
//    private String activeTimeStr;				//页面参数
//    
//    @TempField
//    private String agencyMark;					//代理商备注
//    @TempField
//    private Integer billType;					//查询参数：票务类型
    
//	public Integer getBillType() {
//		return billType;
//	}
//
//	public void setBillType(Integer billType) {
//		this.billType = billType;
//	}
//
//	public String getAgencyMark() {
//		return agencyMark;
//	}
//
//	public void setAgencyMark(String agencyMark) {
//		this.agencyMark = agencyMark;
//	}
//
//	public String getActiveTimeStr() {
//		return activeTimeStr;
//	}
//
//	public void setActiveTimeStr(String activeTimeStr) {
//		this.activeTimeStr = activeTimeStr;
//	}
    
    
    
	public Integer getBindSide() {
		return bindSide;
	}

	
	
	/** 更新话费绑定状态
	 * @param accountId
	 * @param telRateId
	 * @param activeTime
	 * @param bindState
	 */
	public TelrateBindAccountPo(Integer accountId, Long telRateId, Long activeTime,
		Integer bindState) {
		super();
		this.accountId = accountId;
		this.telRateId = telRateId;
		this.activeTime = activeTime;
		this.bindState = bindState;
	}
	
	

	public TelrateBindAccountPo(Integer accountId, String agencyName,
		Long telRateId, Long activeTime, Integer bindState, Integer bindSide,
		Integer bindAgencyId) {
	super();
	this.accountId = accountId;
	this.agencyName = agencyName;
	this.telRateId = telRateId;
	this.activeTime = activeTime;
	this.bindState = bindState;
	this.bindSide = bindSide;
	this.bindAgencyId = bindAgencyId;
}

	public TelrateBindAccountPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getActiveTimeStr() {
		return activeTimeStr;
	}

	public void setActiveTimeStr(String activeTimeStr) {
		this.activeTimeStr = activeTimeStr;
	}

	public void setBindSide(Integer bindSide) {
		this.bindSide = bindSide;
	}

//	public String getAccountIds() {
//		return accountIds;
//	}
//
//	public void setAccountIds(String accountIds) {
//		this.accountIds = accountIds;
//	}

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
