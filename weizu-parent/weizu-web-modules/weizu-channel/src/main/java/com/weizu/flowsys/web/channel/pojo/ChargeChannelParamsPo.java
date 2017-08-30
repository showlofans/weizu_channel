package com.weizu.flowsys.web.channel.pojo;


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
	private String epEngId;					//平台英文标志
	private Long channelId;					//通道id（再次通过通道查询包体的时候参数）
	
	public ChargeChannelParamsPo(String carrier, String scopeCityCode,
			String epEngId) {
		super();
		this.carrier = carrier;
		this.scopeCityCode = scopeCityCode;
		this.epEngId = epEngId;
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


	public ChargeChannelParamsPo() {
		super();
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
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
	public String getEpEngId() {
		return epEngId;
	}
	public void setEpEngId(String epEngId) {
		this.epEngId = epEngId;
	}
}