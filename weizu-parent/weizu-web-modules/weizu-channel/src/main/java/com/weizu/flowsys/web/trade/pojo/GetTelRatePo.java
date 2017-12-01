package com.weizu.flowsys.web.trade.pojo;

import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 话费价格折扣实体（异步获得的）
 * @projectName:weizu-channel
 * @className:GetTelRatePo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月1日 下午4:24:21
 * @version 1.0
 */
public class GetTelRatePo extends Po {
	
	private Long id;						//话费折扣id
    
    private Double activeDiscount;			//折扣
    
    private Integer billType;				//是否带票（0-一般不带票，1-带票高级）
    
    private Integer chargeValue;			//话费价值
    
    private String telCode;					//话费产品编码

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

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Integer getChargeValue() {
		return chargeValue;
	}

	public void setChargeValue(Integer chargeValue) {
		this.chargeValue = chargeValue;
	}

	public String getTelCode() {
		return telCode;
	}

	public void setTelCode(String telCode) {
		this.telCode = telCode;
	}
}
