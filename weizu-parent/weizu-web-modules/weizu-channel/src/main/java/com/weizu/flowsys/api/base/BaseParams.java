package com.weizu.flowsys.api.base;

/**
 * @description: 自己系统能够提供的参数
 * @projectName:weizu-channel
 * @className:BaseParams.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 上午11:32:52
 * @version 1.0
 */
public class BaseParams {
	protected String productCode;		//产品编码
	protected String orderId;			//订单号
	protected String chargeTel;			//手机号
	protected Integer serviceType;		//业务类型
	protected EpDTO epDTO;				//平台信息
	
	
	protected StringBuffer paramsBuffer = new StringBuffer();			//请求参数
	public BaseParams() {
		super();
	}
	public BaseParams(String productCode, String orderId, String chargeTel,
			Integer serviceType, EpDTO epDTO) {
		super();
		this.productCode = productCode;
		this.orderId = orderId;
		this.chargeTel = chargeTel;
		this.serviceType = serviceType;
		this.epDTO = epDTO;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getChargeTel() {
		return chargeTel;
	}
	public void setChargeTel(String chargeTel) {
		this.chargeTel = chargeTel;
	}
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}
	
	
}	
