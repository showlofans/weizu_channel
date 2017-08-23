package com.weizu.flowsys.web.channel.pojo;

/**
 * @description: 平台包体，折扣查询
 * @projectName:weizu-channel
 * @className:SuperPurchaseParam.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月23日 下午4:40:01
 * @version 1.0
 */
public class SuperPurchaseParam {
	private String carrier;
	private String serviceType;
	private String epEngId;
	private Long channelId;
	private Integer pgId;

	private String scopeCityCode;
	private Integer operatorType;
	private Integer serType;
	
	/** 第一次查询
	 * @param carrier
	 * @param serviceType
	 * @param epEngId
	 */
	public SuperPurchaseParam(String carrier, String serviceType, String epEngId) {
		super();
		this.carrier = carrier;
		this.serviceType = serviceType;
		this.epEngId = epEngId;
	} 
	/** 第二次查询
	 * @param carrier
	 * @param serviceType
	 * @param epEngId
	 * @param channelId
	 * @param pgId
	 */
	public SuperPurchaseParam(String carrier, String serviceType,
			String epEngId, Long channelId, Integer pgId) {
		super();
		this.carrier = carrier;
		this.serviceType = serviceType;
		this.epEngId = epEngId;
		this.channelId = channelId;
		this.pgId = pgId;
	}

	public SuperPurchaseParam() {
		super();
	}
	
	public String getScopeCityCode() {
		return scopeCityCode;
	}
	public void setScopeCityCode(String scopeCityCode) {
		this.scopeCityCode = scopeCityCode;
	}
	public Integer getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}
	public Integer getSerType() {
		return serType;
	}
	public void setSerType(Integer serType) {
		this.serType = serType;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public Integer getPgId() {
		return pgId;
	}
	public void setPgId(Integer pgId) {
		this.pgId = pgId;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getEpEngId() {
		return epEngId;
	}
	public void setEpEngId(String epEngId) {
		this.epEngId = epEngId;
	}
}
