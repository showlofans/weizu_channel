package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description: 自己系统能够提供的参数
 * @projectName:weizu-channel
 * @className:BaseParams.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 上午11:32:52
 * @version 1.0
 */
public class BaseP {
//	private static BaseP instance = new BaseP();
	private String productCode;		//产品编码
	private  String orderId;			//订单号
	private  String chargeTel;		//手机号
	private  Integer serviceType;		//业务类型
//	private  EpDTO epDTO;				//平台信息
	private ExchangePlatformPo epo;		//平台信息
//	private String addParams;		//特殊的参数s=1&s2=3 
	
	public BaseP() {
		super();
	}
	public BaseP(String productCode,String orderId,String chargeTel,Integer serviceType,ExchangePlatformPo epo) {
//		this.epDTO = epDTO;
		this.epo = epo;
		this.productCode = productCode;
		this.orderId = orderId;
		this.chargeTel = chargeTel;
		this.serviceType = serviceType;
	}
	
//	public String getAddParams() {
//		return addParams;
//	}
//	public void setAddParams(String addParams) {
//		this.addParams = addParams;
//	}
	public  String getProductCode() {
		return productCode;
	}
	public  String getOrderId() {
		return orderId;
	}
	public  String getChargeTel() {
		return chargeTel;
	}
	public  Integer getServiceType() {
		return serviceType;
	}
	public  ExchangePlatformPo getEpo() {
		return epo;
	}
}	
