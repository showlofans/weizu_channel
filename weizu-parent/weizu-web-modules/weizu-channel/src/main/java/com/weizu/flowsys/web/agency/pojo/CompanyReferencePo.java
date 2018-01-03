package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 客户基本信息实体（客户关系管理模块）
 * @projectName:weizu-channel
 * @className:CompanyReferencePo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月3日 下午2:00:50
 * @version 1.0
 */
@TableName(name="company_reference")
public class CompanyReferencePo extends Po {
/**基本信息*/
	private Integer id;					//公司编号
	private String crmName;				//公司名称
	private String crmForwardDesc;		//上游描述
	private String crmBackwardDesc;		//下游描述（客户分析）
	private String crmGroupMark;		//群名备注
	private Integer crmPlatformTag;		//是否已对接系统 AgencyTagEnum
	private Long lastAccess;			//最后更新时间
	
	private Integer agencyId;			//代理商id（下游）
	private Integer epId;				//平台id（上游）
	@TempField
	private String lastAccessStr;		//展示更新时间
	
	public CompanyReferencePo(String crmName, String crmForwardDesc,
			String crmBackwardDesc, String crmGroupMark,
			Integer crmPlatformTag, Long lastAccess) {
		super();
		this.crmName = crmName;
		this.crmForwardDesc = crmForwardDesc;
		this.crmBackwardDesc = crmBackwardDesc;
		this.crmGroupMark = crmGroupMark;
		this.crmPlatformTag = crmPlatformTag;
		this.lastAccess = lastAccess;
	}
	public CompanyReferencePo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getLastAccessStr() {
		return lastAccessStr;
	}
	public void setLastAccessStr(String lastAccessStr) {
		this.lastAccessStr = lastAccessStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCrmName() {
		return crmName;
	}
	public void setCrmName(String crmName) {
		this.crmName = crmName;
	}
	public String getCrmForwardDesc() {
		return crmForwardDesc;
	}
	public void setCrmForwardDesc(String crmForwardDesc) {
		this.crmForwardDesc = crmForwardDesc;
	}
	public String getCrmBackwardDesc() {
		return crmBackwardDesc;
	}
	public void setCrmBackwardDesc(String crmBackwardDesc) {
		this.crmBackwardDesc = crmBackwardDesc;
	}
	public String getCrmGroupMark() {
		return crmGroupMark;
	}
	public void setCrmGroupMark(String crmGroupMark) {
		this.crmGroupMark = crmGroupMark;
	}
	public Integer getCrmPlatformTag() {
		return crmPlatformTag;
	}
	public void setCrmPlatformTag(Integer crmPlatformTag) {
		this.crmPlatformTag = crmPlatformTag;
	}
	public Long getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Long lastAccess) {
		this.lastAccess = lastAccess;
	}
	public Integer getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}
	public Integer getEpId() {
		return epId;
	}
	public void setEpId(Integer epId) {
		this.epId = epId;
	}
	
}
