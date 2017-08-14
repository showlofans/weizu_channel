package com.weizu.flowsys.web.trade.pojo;

/**
 * @description: 页面单个号码流量充值参数
 * @projectName:weizu-channel
 * @className:PgChargeVO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年8月4日 下午3:06:17
 * @version 1.0
 */
public class PgChargeVO {
	
	private Long channelId; 				//通道id
	
	private String chargeTel; 				//手机号码
	
	private String chargeTelDetail; 		//手机号码归属地
	
	private String productCode; 			//产品编码
	
	private Double orderAmount;				//充值额 
	
	private Double pgPrice; 				//面值
	
	private Integer pgId;					//充值包体id
	
	private Integer serviceType;			//业务类型 
	
	private Long rateId;					//费率id
	
	private Integer agencyId;				//当前登录用户id
	
	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getChargeTel() {
		return chargeTel;
	}

	public void setChargeTel(String chargeTel) {
		this.chargeTel = chargeTel;
	}

	public String getChargeTelDetail() {
		return chargeTelDetail;
	}

	public void setChargeTelDetail(String chargeTelDetail) {
		this.chargeTelDetail = chargeTelDetail;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getPgPrice() {
		return pgPrice;
	}

	public void setPgPrice(Double pgPrice) {
		this.pgPrice = pgPrice;
	}

	public Integer getPgId() {
		return pgId;
	}

	public void setPgId(Integer pgId) {
		this.pgId = pgId;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
}
