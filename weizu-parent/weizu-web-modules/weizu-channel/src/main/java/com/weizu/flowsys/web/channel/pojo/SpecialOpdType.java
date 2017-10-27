package com.weizu.flowsys.web.channel.pojo;

/**
 * @description: 特殊包体类型实体
 * @projectName:weizu-channel
 * @className:SpecialOpdType.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月27日 上午10:08:57
 * @version 1.0
 */
public class SpecialOpdType {
	
	private Long channelId;
	
	private Integer pgType;
	
	private String pgValidity;

	/** 封装查询参数
	 * @param pgType
	 * @param pgValidity
	 */
	public SpecialOpdType(Integer pgType, String pgValidity) {
		super();
		this.pgType = pgType;
		this.pgValidity = pgValidity;
	}

	public SpecialOpdType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
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
	
}
