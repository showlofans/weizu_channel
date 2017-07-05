package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

@TableName(name="rate_discount")
public class RateDiscountPo extends Po {
    private Long id;

    private Integer operatorType;

    private String scopeCityCode;

    private Double activeDiscount;

    private Long activeChannelId;

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

    public Long getActiveChannelId() {
        return activeChannelId;
    }

    public void setActiveChannelId(Long activeChannelId) {
        this.activeChannelId = activeChannelId;
    }
}