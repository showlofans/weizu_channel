package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TempField;


/**
 * @description: 通道充值页面查询参数
 * @projectName:weizu-channel
 * @className:ChargeChannelParamsPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月28日 下午3:52:40
 * @version 1.0
 */
public class ChargeChannelParamsPo {
    private Integer operatorType;			//运营商类型
    private String carrier;					//中国移动
    private String scopeCityCode;			//地区编码    
    private Integer serviceType;			//流量类型
//	private String epEngId;					//平台英文标志
    private String epName;					//平台名称
	private Long channelId;					//通道id（再次通过通道查询包体的时候参数）
//	private Integer agencyId;				//代理商id
	private Integer billType;				//是否带票
	
    private Integer pgType;				//流量类型（1-流量包，2-流量池）
    private String pgValidity;			//流量有效期(PgValidityEnum)
    private Integer channelType;						//通道类型（页面参数：1-普通通道包，2-红包通道，3-转移包，4-共享包）
	
	public ChargeChannelParamsPo(String carrier, String scopeCityCode,
			String epName) {
		super();
		this.carrier = carrier;
		this.scopeCityCode = scopeCityCode;
		this.epName = epName;
	}
	
	
	/** 代理商通过费率参数找到通道，再找到包体
	 * @param carrier
	 * @param serviceType
	 * @param channelId
	 */
	public ChargeChannelParamsPo(String carrier, Integer serviceType,
			 Long channelId) {
		super();
		this.carrier = carrier;
		this.serviceType = serviceType;
		this.channelId = channelId;
	}

	public Integer getPgType() {
		return pgType;
	}


	public void setPgType(Integer pgType) {
		this.pgType = pgType;
	}


	public String getPgValidity() {
		return pgValidity;
	}


	public void setPgValidity(String pgValidity) {
		this.pgValidity = pgValidity;
	}


	public Integer getChannelType() {
		return channelType;
	}


	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}


	public Long getChannelId() {
		return channelId;
	}


	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}


	public Integer getBillType() {
		return billType;
	}


	public void setBillType(Integer billType) {
		this.billType = billType;
	}


	public ChargeChannelParamsPo() {
		super();
	}

//	public Integer getAgencyId() {
//		return agencyId;
//	}
//	public void setAgencyId(Integer agencyId) {
//		this.agencyId = agencyId;
//	}

	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public Integer getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}
	public String getScopeCityCode() {
		return scopeCityCode;
	}
	public void setScopeCityCode(String scopeCityCode) {
		this.scopeCityCode = scopeCityCode;
	}
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	public String getEpName() {
		return epName;
	}


	public void setEpName(String epName) {
		this.epName = epName;
	}
}
