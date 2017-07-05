package com.weizu.flowsys.web.activity.pojo;

import java.util.List;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 通道连接代理商实体
 * @projectName:weizu-channel
 * @className:AgencyActiveChannelPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月5日 下午5:53:47
 * @version 1.0
 */
@TableName(name="agency_active_channel")
public class AgencyActiveChannelPo extends Po {
    private Long id;

    private Integer agencyId;

    private Integer channelId;

    private String agencyName;

    private String channelName;

    private Long activeTime;
    
    @TempField//插入的时候不添加进去
    private List<RateDiscountPo> rateList;

    public List<RateDiscountPo> getRateList() {
		return rateList;
	}

	public void setRateList(List<RateDiscountPo> rateList) {
		this.rateList = rateList;
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

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName == null ? null : agencyName.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Long getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Long activeTime) {
        this.activeTime = activeTime;
    }
}