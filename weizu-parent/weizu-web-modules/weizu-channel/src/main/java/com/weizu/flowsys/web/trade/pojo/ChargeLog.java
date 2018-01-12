package com.weizu.flowsys.web.trade.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 对上对下提单日志实体
 * @projectName:weizu-channel
 * @className:ChargeLog.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月11日 下午3:12:36
 * @version 1.0
 */
@TableName(name="charge_log")
public class ChargeLog extends Po {
	
	private Long id;
	
	private String logInContent;			//提单参数集
	
	private String logOutContent;			//提单结果集
	
	private Long orderId;
	
	private String chargeTel;
	
	private Integer chargeStatus;
	
	private String chargeDesc;				//提单结果描述
	
	private Long chargeTime;
	
	private Integer chargeDirection;		//提单方向 AgencyForwardEnum
	
	public ChargeLog() {
		super();
	}

	public ChargeLog(String logInContent, String logOutContent, Long orderId,
			String chargeTel, Integer chargeStatus, Long chargeTime,
			Integer chargeDirection,String chargeDesc) {
		super();
		this.logInContent = logInContent;
		this.logOutContent = logOutContent;
		this.orderId = orderId;
		this.chargeTel = chargeTel;
		this.chargeStatus = chargeStatus;
		this.chargeTime = chargeTime;
		this.chargeDirection = chargeDirection;
		this.chargeDesc = chargeDesc;
	}

	public String getChargeDesc() {
		return chargeDesc;
	}

	public void setChargeDesc(String chargeDesc) {
		this.chargeDesc = chargeDesc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogInContent() {
		return logInContent;
	}

	public void setLogInContent(String logInContent) {
		this.logInContent = logInContent;
	}

	public String getLogOutContent() {
		return logOutContent;
	}

	public void setLogOutContent(String logOutContent) {
		this.logOutContent = logOutContent;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getChargeTel() {
		return chargeTel;
	}

	public void setChargeTel(String chargeTel) {
		this.chargeTel = chargeTel;
	}

	public Integer getChargeStatus() {
		return chargeStatus;
	}

	public void setChargeStatus(Integer chargeStatus) {
		this.chargeStatus = chargeStatus;
	}

	public Long getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(Long chargeTime) {
		this.chargeTime = chargeTime;
	}

	public Integer getChargeDirection() {
		return chargeDirection;
	}

	public void setChargeDirection(Integer chargeDirection) {
		this.chargeDirection = chargeDirection;
	}
}
