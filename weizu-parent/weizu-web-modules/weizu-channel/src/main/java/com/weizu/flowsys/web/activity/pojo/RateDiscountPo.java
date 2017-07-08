package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 费率折扣
 * @projectName:weizu-channel
 * @className:RateDiscountPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月6日 下午6:12:52
 * @version 1.0
 */
@TableName(name="rate_discount")
public class RateDiscountPo extends Po {
    private Long id;
    
    private Integer serviceType;
    
    private Integer operatorType;

    private String scopeCityCode;

    private Double activeDiscount;

    private Long activeId;
    
    public RateDiscountPo() {
		super();
	}

	public RateDiscountPo(Integer serviceType, Integer operatorType,
			String scopeCityCode, Double activeDiscount, Long activeId) {
		super();
		this.serviceType = serviceType;
		this.operatorType = operatorType;
		this.scopeCityCode = scopeCityCode;
		this.activeDiscount = activeDiscount;
		this.activeId = activeId;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.scopeCityCode = scopeCityCode == null ? null : scopeCityCode.trim();
    }

    public Double getActiveDiscount() {
        return activeDiscount;
    }

    public void setActiveDiscount(Double activeDiscount) {
        this.activeDiscount = activeDiscount;
    }

	public Long getActiveId() {
		return activeId;
	}

	public void setActiveId(Long activeId) {
		this.activeId = activeId;
	}
}