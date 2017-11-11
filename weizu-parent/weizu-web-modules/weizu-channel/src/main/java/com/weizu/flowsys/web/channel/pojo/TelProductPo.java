package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 产品编码实体
 * @projectName:weizu-channel
 * @className:TelProductPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月11日 下午12:24:47
 * @version 1.0
 */
public class TelProductPo extends Po {

	private Long id;					//id
		
	private Integer epId;				//平台id
	
	private String epName;				//平台名称
		
	private String cityid;				//城市编码
	
	private Integer serviceType;		//业务类型
	
	private Integer operatorName;		//运营商
				
	private Integer chargeValue;		//话费价值
	
	private Boolean freeCharge;			// 话费类型（是否是任意充编码）
		
	private Integer chargeSpeed;		//充值速度
	
	private String limitDescription;	//限制描述
	
	private String telCode;				//通道编码
	
	private Integer chargeLimitLow;		//最低限额
	
	private Integer chargeLimitHigh;	//最高限额

	
	public String getTelCode() {
		return telCode;
	}

	public void setTelCode(String telCode) {
		this.telCode = telCode;
	}

	public Integer getChargeLimitLow() {
		return chargeLimitLow;
	}

	public void setChargeLimitLow(Integer chargeLimitLow) {
		this.chargeLimitLow = chargeLimitLow;
	}

	public Integer getChargeLimitHigh() {
		return chargeLimitHigh;
	}

	public void setChargeLimitHigh(Integer chargeLimitHigh) {
		this.chargeLimitHigh = chargeLimitHigh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEpId() {
		return epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public String getEpName() {
		return epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(Integer operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getChargeValue() {
		return chargeValue;
	}

	public void setChargeValue(Integer chargeValue) {
		this.chargeValue = chargeValue;
	}

	public Boolean getFreeCharge() {
		return freeCharge;
	}

	public void setFreeCharge(Boolean freeCharge) {
		this.freeCharge = freeCharge;
	}

	public Integer getChargeSpeed() {
		return chargeSpeed;
	}

	public void setChargeSpeed(Integer chargeSpeed) {
		this.chargeSpeed = chargeSpeed;
	}

	public String getLimitDescription() {
		return limitDescription;
	}

	public void setLimitDescription(String limitDescription) {
		this.limitDescription = limitDescription;
	}
	
}
