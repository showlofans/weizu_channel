package com.weizu.flowsys.web.channel.pojo;

/**
 * @description:查詢參數封裝
 * @projectName:crud
 * @className:OneCodePo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月10日 下午6:04:26
 * @version 1.0
 */
public class OneCodePo {
	
	private String scopeCityCode;
	
	private Integer pgSize;
	
	private Integer operatorType;
	
	private Integer serviceType;
	
	public OneCodePo() {
		super();
	}

	public OneCodePo(String scopeCityCode, Integer pgSize,
			Integer operatorType, Integer serviceType) {
		super();
		this.scopeCityCode = scopeCityCode;
		this.pgSize = pgSize;
		this.operatorType = operatorType;
		this.serviceType = serviceType;
	}

	public String getScopeCityCode() {
		return scopeCityCode;
	}

	public void setScopeCityCode(String scopeCityCode) {
		this.scopeCityCode = scopeCityCode;
	}

	public Integer getPgSize() {
		return pgSize;
	}

	public void setPgSize(Integer pgSize) {
		this.pgSize = pgSize;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	
	
	
}
