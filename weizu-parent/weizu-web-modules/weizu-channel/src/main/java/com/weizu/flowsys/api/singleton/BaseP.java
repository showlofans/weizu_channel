package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;

/**
 * @description: 对接上游自己系统能够提供的参数
 * @projectName:weizu-channel
 * @className:BaseParams.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 上午11:32:52
 * @version 1.0
 */
public class BaseP {
//	private String productCode;		//产品编码
	private  Long orderId;			//订单号
	private String orderIdApi;		//订单查询订单好
	private  String chargeTel;		//手机号
//	private  Long productCodeId;		//产品编码id(业务类型)
	private ExchangePlatformPo epo;		//平台信息
	private ProductCodePo productCodePo;	//产品编码信息
	private String otherParams;			//其他参数
	
	public BaseP() {
		super();
	}
	
	public BaseP(ProductCodePo productCodePo, String orderIdApi, String chargeTel,
			 ExchangePlatformPo epo,String otherParams) {
		super();
//		this.productCode = productCode;
		this.orderIdApi = orderIdApi;
		this.chargeTel = chargeTel;
		this.productCodePo = productCodePo;
//		this.productCodeId = productCodeId;
		this.otherParams = otherParams;
		this.epo = epo;
	}
	public BaseP(ProductCodePo productCodePo,Long orderId,String chargeTel,ExchangePlatformPo epo,String otherParams) {
//		this.epDTO = epDTO;
		this.epo = epo;
//		this.productCode = productCode;
		this.orderId = orderId;
		this.productCodePo = productCodePo;
		this.chargeTel = chargeTel;
		this.otherParams = otherParams;
//		this.productCodeId = productCodeId;
	}
	
	public String getOtherParams() {
		return otherParams;
	}

	public void setOtherParams(String otherParams) {
		this.otherParams = otherParams;
	}

	public String getOrderIdApi() {
		return orderIdApi;
	}
//	public String getAddParams() {
//		return addParams;
//	}
//	public void setAddParams(String addParams) {
//		this.addParams = addParams;
//	}
//	public  String getProductCode() {
//		return productCode;
//	}
	public  Long getOrderId() {
		return orderId;
	}
	public  String getChargeTel() {
		return chargeTel;
	}
	
//	public Long getProductCodeId() {
//		return productCodeId;
//	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public  ExchangePlatformPo getEpo() {
		return epo;
	}

	public ProductCodePo getProductCodePo() {
		return productCodePo;
	}
}	
