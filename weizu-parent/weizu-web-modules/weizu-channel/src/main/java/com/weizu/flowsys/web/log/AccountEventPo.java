package com.weizu.flowsys.web.log;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 账户管理日志
 * @projectName:weizu-channel
 * @className:AccountEventPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月8日 下午4:33:27
 * @version 1.0
 */
@TableName(name="account_event")
public class AccountEventPo extends Po {
	
	private Long id;					//id
	
	private Integer agencyId;			//事件代理商id
	
	private Integer eventType;			//事件类型 eventTypeEnum
	
	private Long eventTime;				//发生时间
	
	private String eventLocation;		//发生地点
	
	private String eventIp;				//来源ip
	
	private Integer eventState;			//事件类型 loginStateEnum
	
	private Integer billType;			//事件账户类型

	public AccountEventPo(Integer agencyId, Integer eventType, Long eventTime,
			String eventLocation, String eventIp, Integer eventState) {
		super();
		this.agencyId = agencyId;
		this.eventType = eventType;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.eventIp = eventIp;
		this.eventState = eventState;
	}
	public AccountEventPo(Integer agencyId, Integer eventType, Long eventTime,
			String eventLocation, String eventIp, Integer eventState,
			Integer billType) {
		super();
		this.agencyId = agencyId;
		this.eventType = eventType;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.eventIp = eventIp;
		this.eventState = eventState;
		this.billType = billType;
	}


	public AccountEventPo() {
		super();
		// TODO Auto-generated constructor stub
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

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	public Long getEventTime() {
		return eventTime;
	}

	public void setEventTime(Long eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventIp() {
		return eventIp;
	}

	public void setEventIp(String eventIp) {
		this.eventIp = eventIp;
	}

	public Integer getEventState() {
		return eventState;
	}

	public void setEventState(Integer eventState) {
		this.eventState = eventState;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}
}
