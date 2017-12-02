package com.weizu.flowsys.web.trade.pojo;

/**
 * @description: 页面单个号码流量充值参数
 * @projectName:weizu-channel
 * @className:PgChargeVO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年8月4日 下午3:06:17
 * @version 1.0
 */
public class TelChargeVO {
	
	private Long telchannelId; 				//通道id
	
	private String chargeTel; 				//手机号码
	
	private String chargeTelDetail; 		//手机号码归属地
	
	private String telCode; 				//产品编码
	
	private Double orderAmount;				//充值额 
	
	private Double chargeValue; 				//面值
	
	private Long telProductId;			//充值包体id
	
	private Integer serviceType;			//业务类型 
	
	private String fromAgencyName;		//提单来源代理名称
	
	private Integer accountId;				//提单来源代理id
	
	private Long telRateId;					//话费折扣id
	
//	private Long telCdisId;					//通道折扣id
	
	private Integer chargeFor;				//PgServiceTypeEnum：充值业务类型
	
	public Integer getChargeFor() {
		return chargeFor;
	}

	public void setChargeFor(Integer chargeFor) {
		this.chargeFor = chargeFor;
	}

	
	
	public Long getTelchannelId() {
		return telchannelId;
	}

	public void setTelchannelId(Long telchannelId) {
		this.telchannelId = telchannelId;
	}

	public String getTelCode() {
		return telCode;
	}

	public void setTelCode(String telCode) {
		this.telCode = telCode;
	}

	public Double getChargeValue() {
		return chargeValue;
	}

	public void setChargeValue(Double chargeValue) {
		this.chargeValue = chargeValue;
	}

	public Long getTelProductId() {
		return telProductId;
	}

	public void setTelProductId(Long telProductId) {
		this.telProductId = telProductId;
	}

	public Long getTelRateId() {
		return telRateId;
	}

	public void setTelRateId(Long telRateId) {
		this.telRateId = telRateId;
	}

//	public Long getTelCdisId() {
//		return telCdisId;
//	}
//
//	public void setTelCdisId(Long telCdisId) {
//		this.telCdisId = telCdisId;
//	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getFromAgencyName() {
		return fromAgencyName;
	}

	public void setFromAgencyName(String fromAgencyName) {
		this.fromAgencyName = fromAgencyName;
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

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
}
