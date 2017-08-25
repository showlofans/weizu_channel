package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.api.base.test.Singleton;

/**
 * @description: 自己系统能够提供的参数
 * @projectName:weizu-channel
 * @className:BaseParams.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 上午11:32:52
 * @version 1.0
 */
public class BaseP {
	private static BaseP instance = new BaseP();
	private static String productCode;		//产品编码
	private static String orderId;			//订单号
	private static String chargeTel;		//手机号
	private static Integer serviceType;		//业务类型
	private static EpDTO epDTO;				//平台信息
	public BaseP() {
		super();
	}
	public static BaseP getInstance(String productCode,String orderId,String chargeTel,Integer serviceType,EpDTO epDTO) {
		BaseP.epDTO = epDTO;
		BaseP.productCode = productCode;
		BaseP.orderId = orderId;
		BaseP.chargeTel = chargeTel;
		BaseP.serviceType = serviceType;
		return instance;
	}
	
	public static String getProductCode() {
		return productCode;
	}
	public static String getOrderId() {
		return orderId;
	}
	public static String getChargeTel() {
		return chargeTel;
	}
	public static Integer getServiceType() {
		return serviceType;
	}
	public static EpDTO getEpDTO() {
		return epDTO;
	}
}	
