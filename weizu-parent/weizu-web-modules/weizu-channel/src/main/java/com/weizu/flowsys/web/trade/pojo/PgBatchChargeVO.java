package com.weizu.flowsys.web.trade.pojo;

/**
 * @description: 页面多个个号码流量充值参数
 * @projectName:weizu-channel
 * @className:PgBatchChargeVO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月19日 下午2:02:13
 * @version 1.0
 */
public class PgBatchChargeVO {
	
	private String chargeTelArray; 				//手机号码
	
	private String carrier; 				//手机号码归属地
	
	private Double orderAmount;				//总充值额 
	
	private Double chargeValue; 				//总面值
	
	private Integer pgId;					//充值包体id
	
	private Integer serviceType;			//业务类型 
	
	private Long rateId;					//费率id
	
	private Long cdisId;					//通道折扣id
	
	private Integer totalNum;				//PgServiceTypeEnum：充值业务类型
	
	public String getChargeTelArray() {
		return chargeTelArray;
	}

	public void setChargeTelArray(String chargeTelArray) {
		this.chargeTelArray = chargeTelArray;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Long getCdisId() {
		return cdisId;
	}

	public void setCdisId(Long cdisId) {
		this.cdisId = cdisId;
	}

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getChargeValue() {
		return chargeValue;
	}

	public void setChargeValue(Double chargeValue) {
		this.chargeValue = chargeValue;
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
