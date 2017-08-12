package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:费率折扣
 * @projectName:weizu-channel
 * @className:RateDiscountDTO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月29日 上午11:11:56
 * @version 1.0
 */
@TableName(name="rate_discount")
public class RateDiscountDTO extends Po {
	 private Long id;
	    
	 private Double activeDiscount;

	 private Long activeId;
    
	 private Long channelDiscountId;
    
	 private Integer billType;				//是否带票（0-一般不带票，1-带票高级）

	public RateDiscountDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getChannelDiscountId() {
		return channelDiscountId;
	}

	public void setChannelDiscountId(Long channelDiscountId) {
		this.channelDiscountId = channelDiscountId;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}
	 
}
