package com.weizu.flowsys.web.channel.pojo;

import java.util.List;

import org.weizu.web.foundation.core.annotation.po.TableName;
import org.weizu.web.foundation.core.annotation.po.TempField;
import org.weizu.web.foundation.core.beans.Po;

import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

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
    
    private Integer serviceType;			//流量类型
    
    private Integer discountType;			//折扣类型（0-对上，1-对下）
    
    @TempField
    private String scopeCityName;			// 地区名字
    
    @TempField
    private Integer channelState;			//通道状态
    
    @TempField
    private Integer belongAgencyId;			//数据库查询字段
    
    private Integer billType;				//数据库返回字段
    
    @TempField
    private List<RateDiscountPo> rateList;		//数据库返回数据费率列表
    
    public ChannelDiscountPo() {
		super();
	}

	public ChannelDiscountPo(Long channelId, String scopeCityCode,
			Double channelDiscount, String channelName, Integer operatorType,
			Integer serviceType, Integer discountType) {
		super();
		this.channelId = channelId;
		this.scopeCityCode = scopeCityCode;
		this.channelDiscount = channelDiscount;
		this.channelName = channelName;
		this.operatorType = operatorType;
		this.serviceType = serviceType;
		this.discountType = discountType;
	}
	
	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public List<RateDiscountPo> getRateList() {
		return rateList;
	}

	public void setRateList(List<RateDiscountPo> rateList) {
		this.rateList = rateList;
	}

	public Integer getBelongAgencyId() {
		return belongAgencyId;
	}

	public void setBelongAgencyId(Integer belongAgencyId) {
		this.belongAgencyId = belongAgencyId;
	}

	public Integer getChannelState() {
		return channelState;
	}

	public void setChannelState(Integer channelState) {
		this.channelState = channelState;
	}

	public String getScopeCityName() {
		return scopeCityName;
	}

	public void setScopeCityName(String scopeCityName) {
		this.scopeCityName = scopeCityName;
	}

	public Integer getDiscountType() {
		return discountType;
	}

	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
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