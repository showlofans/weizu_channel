package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 通道折扣实体
 * @projectName:weizu-channel
 * @className:ChannelDiscountPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月4日 下午4:04:00
 * @version 1.0
 */
@TableName(name="channel_discount")
public class ChannelDiscountPo extends Po {
	
    private Long id;

    private Long channelId;

    private String scopeCityCode;			//地区编码

    private Double channelDiscount;			//通道折扣
    
    private String channelName;			//通道名称
    
    private Integer operatorType;			//运营商类型

    
    public ChannelDiscountPo() {
		super();
	}

	public ChannelDiscountPo(Long channelId, String scopeCityCode,
			Double channelDiscount, String channelName, Integer operatorType) {
		super();
		this.channelId = channelId;
		this.scopeCityCode = scopeCityCode;
		this.channelDiscount = channelDiscount;
		this.channelName = channelName;
		this.operatorType = operatorType;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
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

    public String getScopeCityCode() {
        return scopeCityCode;
    }

    public void setScopeCityCode(String scopeCityCode) {
        this.scopeCityCode = scopeCityCode == null ? null : scopeCityCode.trim();
    }

    public Double getChannelDiscount() {
        return channelDiscount;
    }

    public void setChannelDiscount(Double channelDiscount) {
        this.channelDiscount = channelDiscount;
    }
}