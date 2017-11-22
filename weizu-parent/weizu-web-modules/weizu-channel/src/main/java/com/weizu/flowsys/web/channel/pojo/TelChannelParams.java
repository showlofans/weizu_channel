package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 话费通道查询(页面)参数
 * @projectName:weizu-channel
 * @className:TelChannelParams.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月14日 下午4:59:59
 * @version 1.0
 */
public class TelChannelParams extends Po {

	private Long id;					//id
		
	private String epName;				//平台名称
		
	private String cityid;				//城市编码
	
	private Integer serviceType;		//业务类型
	
	private Integer operatorName;		//运营商
				
	private Integer chargeValue;		//话费价值
	
	private Boolean freeCharge;			// 话费类型（是否是任意充编码）
		
	private Integer chargeSpeed;		//充值速度
	
	private String limitDescription;	//限制描述
	
//	private String telCode;				//通道编码
	
	private Integer chargeLimitLow;		//最低限额
	
	private Integer chargeLimitHigh;	//最高限额
	
	private Integer telchannelState;			//通道状态

    private Integer telchannelUseState;			//通道使用状态
    
    private Integer billType;					//商务类型
	
	private String city;					//城市名称：页面参数
	
	private String province;				//省份名称：页面参数
	
	private String provinceid;				//省份名称：查询参数
	
	private Double telchannelDiscount;			//通道价
	
	//private Long lastAccess;					//更新时间
	
	public String getProvinceid() {
		return provinceid;
	}

	public Double getTelchannelDiscount() {
		return telchannelDiscount;
	}

	public void setTelchannelDiscount(Double telchannelDiscount) {
		this.telchannelDiscount = telchannelDiscount;
	}

	public Integer getTelchannelState() {
		return telchannelState;
	}

	public void setTelchannelState(Integer telchannelState) {
		this.telchannelState = telchannelState;
	}

	public Integer getTelchannelUseState() {
		return telchannelUseState;
	}

	public void setTelchannelUseState(Integer telchannelUseState) {
		this.telchannelUseState = telchannelUseState;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

//	public String getTelCode() {
//		return telCode;
//	}
//
//	public void setTelCode(String telCode) {
//		this.telCode = telCode;
//	}

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
