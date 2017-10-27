package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TempField;

/**
 * @description: 首页展示实体
 * @projectName:weizu-channel
 * @className:RateDiscountShowDTO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月19日 下午1:02:23
 * @version 1.0
 */
public class RateDiscountShowDTO {
	@TempField
    private DiscountPo discountPo;			//折扣
	
	private Integer billType;				//是否带票（0-一般不带票，1-带票高级）
	
	private Integer serviceType;			//业务范围
	@TempField
	private String discount;				//简化折扣
	
	private String specialTag;				//通道特殊类型
	
	public RateDiscountShowDTO(DiscountPo discountPo, Integer billType) {
		super();
		this.discountPo = discountPo;
		this.billType = billType;
	}
	
	public RateDiscountShowDTO(DiscountPo discountPo, Integer billType,
			Integer serviceType) {
		super();
		this.discountPo = discountPo;
		this.billType = billType;
		this.serviceType = serviceType;
//		this.specialTag = specialTag;
	}


	public RateDiscountShowDTO(Integer billType, String discount) {
		super();
		this.billType = billType;
		this.discount = discount;
	}

	public String getSpecialTag() {
		return specialTag;
	}

	public void setSpecialTag(String specialTag) {
		this.specialTag = specialTag;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public RateDiscountShowDTO() {
		super();
	}

	public DiscountPo getDiscountPo() {
		return discountPo;
	}
	
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public void setDiscountPo(DiscountPo discountPo) {
		this.discountPo = discountPo;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}
	
}
