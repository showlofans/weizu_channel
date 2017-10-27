package com.weizu.flowsys.web.channel.pojo;

/**
 * @description: 特殊通道类型实体
 * @projectName:weizu-channel
 * @className:SpecialCnelType.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月27日 上午10:02:26
 * @version 1.0
 */
public class SpecialCnelType {
	
	private Long channelId;
	
	private Integer channelType;

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Integer getChannelType() {
		return channelType;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}
	
}
