package com.weizu.flowsys.web.system_base.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 参数配置实体
 * @projectName:weizu-channel
 * @className:SystemConfPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月23日 下午3:05:21
 * @version 1.0
 */
@TableName(name="system_conf")
public class SystemConfPo extends Po {
	
	private String confKey;
	private String confValue;
	private String confDesc;
	private Integer id;
	
	private Long lastAccess;
	@TempField
	private String lastAccessStr;
	
	/** 创建实体
	 * @param confKey 
	 * @param confValue
	 * @param confDesc
	 * @param lastAccess
	 */
	public SystemConfPo(String confKey, String confValue, String confDesc,
			Long lastAccess) {
		super();
		this.confKey = confKey;
		this.confValue = confValue;
		this.confDesc = confDesc;
		this.lastAccess = lastAccess;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public SystemConfPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getConfKey() {
		return confKey;
	}
	public void setConfKey(String confKey) {
		this.confKey = confKey;
	}
	public String getConfValue() {
		return confValue;
	}
	public void setConfValue(String confValue) {
		this.confValue = confValue;
	}
	public String getConfDesc() {
		return confDesc;
	}
	public void setConfDesc(String confDesc) {
		this.confDesc = confDesc;
	}
	public Long getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Long lastAccess) {
		this.lastAccess = lastAccess;
	}
	public String getLastAccessStr() {
		return lastAccessStr;
	}
	public void setLastAccessStr(String lastAccessStr) {
		this.lastAccessStr = lastAccessStr;
	}
}
