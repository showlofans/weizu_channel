package com.weizu.flowsys.web.trade.pojo;

/**
 * @description: 费率包体实体
 * @projectName:weizu-channel
 * @className:RatePgPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月18日 下午3:53:08
 * @version 1.0
 */
public class RatePgPo {
	
	private Integer pgId;					//包体id
	
	private Integer pgSize;					//包体大小
	
	private Long rateId;					//费率id
	
	private Long channelId; 				//通道id
	
	private Double pgPrice;					//包体原价
	
	private Double pgDiscountPrice;			//包体折扣价
	
	private Double activeDiscount;			//费率折扣

	public Integer getPgId() {
		return pgId;
	}

	public void setPgId(Integer pgId) {
		this.pgId = pgId;
	}

	public Integer getPgSize() {
		return pgSize;
	}

	public void setPgSize(Integer pgSize) {
		this.pgSize = pgSize;
	}

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Double getPgPrice() {
		return pgPrice;
	}

	public void setPgPrice(Double pgPrice) {
		this.pgPrice = pgPrice;
	}

	public Double getPgDiscountPrice() {
		return pgDiscountPrice;
	}

	public void setPgDiscountPrice(Double pgDiscountPrice) {
		this.pgDiscountPrice = pgDiscountPrice;
	}

	public Double getActiveDiscount() {
		return activeDiscount;
	}

	public void setActiveDiscount(Double activeDiscount) {
		this.activeDiscount = activeDiscount;
	}
	
}
