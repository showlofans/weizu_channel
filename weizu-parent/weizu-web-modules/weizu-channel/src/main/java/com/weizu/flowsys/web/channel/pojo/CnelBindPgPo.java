package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 通道包体绑定实体
 * @projectName:weizu-channel
 * @className:CnelBindPgPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年9月16日 上午10:39:46
 * @version 1.0
 */
@TableName(name="cnel_bind_pg")
public class CnelBindPgPo extends Po {
	private Long id;
	private Long channelId;
	private Integer pgId;
	private String channelName;
	private String pgName;
	
	public CnelBindPgPo(Long channelId, Integer pgId,
			String channelName, String pgName) {
		super();
		this.channelId = channelId;
		this.pgId = pgId;
		this.channelName = channelName;
		this.pgName = pgName;
	}
	public CnelBindPgPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getPgName() {
		return pgName;
	}
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}
}
