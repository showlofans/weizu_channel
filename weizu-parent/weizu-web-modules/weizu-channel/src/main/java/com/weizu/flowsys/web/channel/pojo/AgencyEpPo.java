package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:代理商平台连接实体
 * @projectName:crud
 * @className:AgencyEpPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 下午1:05:41
 * @version 1.0
 */
@TableName(name = "agency_ep")
public class AgencyEpPo extends Po{
	
    private Long id;

    private Integer agencyId;

    private String agencyName;

    private Integer epId;

    private String epName;

    
    public AgencyEpPo() {
		super();
	}

	public AgencyEpPo(Integer agencyId, String agencyName,
			Integer epId, String epName) {
		super();
		this.agencyId = agencyId;
		this.agencyName = agencyName;
		this.epId = epId;
		this.epName = epName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName == null ? null : agencyName.trim();
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
        this.epName = epName == null ? null : epName.trim();
    }
}