package com.weizu.flowsys.web.activity.pojo;

import org.weizu.web.foundation.core.annotation.po.TableName;
import org.weizu.web.foundation.core.beans.Po;

/**
 * @description:流量包业务范围实体类<br>
 * @projectName:crud
 * @className:ServiceScope.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月26日 上午11:25:11
 * @version 1.0
 */
@TableName(name="service_scope")
public class ServiceScopePo extends Po {
	
    private String id;				//业务范围id

    private String scopeCityCode;		//包城市编码
    
    private Integer serviceType;		//业务类型（0-全国，1-省内，2-省漫游，3-转赠,4-红包）
    
    private Integer operatorType;		//运营商类型（0-移动，1-联通，电信）

    private String operatorName;		//运营商名称

    private String scopeCityName;		//城市名
    
    
    public ServiceScopePo() {
		super();
	}

	public ServiceScopePo(String id, String scopeCityCode, Integer serviceType,
			Integer operatorType, String operatorName, String scopeCityName) {
		super();
		this.id = id;
		this.scopeCityCode = scopeCityCode;
		this.serviceType = serviceType;
		this.operatorType = operatorType;
		this.operatorName = operatorName;
		this.scopeCityName = scopeCityName;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getScopeCityCode() {
        return scopeCityCode;
    }

    public void setScopeCityCode(String scopeCityCode) {
        this.scopeCityCode = scopeCityCode == null ? null : scopeCityCode.trim();
    }

    public String getScopeCityName() {
        return scopeCityName;
    }

    public void setScopeCityName(String scopeCityName) {
        this.scopeCityName = scopeCityName == null ? null : scopeCityName.trim();
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

}