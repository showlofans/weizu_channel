package com.weizu.flowsys.api.hsingleton;

import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;

/**
 * @description: 上游话费接口基本传单参数
 * @projectName:weizu-channel
 * @className:TelBaseP.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年3月17日 下午2:16:16
 * @version 1.0
 */
public class TelBaseP {
	
	private  Long orderId;			//订单号
	private String orderIdApi;		//订单查询订单好
	private  String chargeTel;		//手机号
//	private  Long productCodeId;		//产品编码id(业务类型)
	private ExchangePlatformPo epo;		//平台信息
	private TelProductPo telProductPo;	//产品编码信息
	private String otherParams;			//其他参数:如订单提交时间
	private Integer billType;			//扣款票务
	
	public TelBaseP(Long orderId, String chargeTel, ExchangePlatformPo epo,
			TelProductPo telProductPo, String otherParams, Integer billType) {
		super();
		this.orderId = orderId;
		this.chargeTel = chargeTel;
		this.epo = epo;
		this.telProductPo = telProductPo;
		this.otherParams = otherParams;
		this.billType = billType;
	}
	public TelBaseP(String orderIdApi, String chargeTel,
			ExchangePlatformPo epo, TelProductPo telProductPo,
			String otherParams, Integer billType) {
		super();
		this.orderIdApi = orderIdApi;
		this.chargeTel = chargeTel;
		this.epo = epo;
		this.telProductPo = telProductPo;
		this.otherParams = otherParams;
		this.billType = billType;
	}
	public TelBaseP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderIdApi() {
		return orderIdApi;
	}
	public void setOrderIdApi(String orderIdApi) {
		this.orderIdApi = orderIdApi;
	}
	public String getChargeTel() {
		return chargeTel;
	}
	public void setChargeTel(String chargeTel) {
		this.chargeTel = chargeTel;
	}
	public ExchangePlatformPo getEpo() {
		return epo;
	}
	public void setEpo(ExchangePlatformPo epo) {
		this.epo = epo;
	}
	public TelProductPo getTelProductPo() {
		return telProductPo;
	}
	public void setTelProductPo(TelProductPo telProductPo) {
		this.telProductPo = telProductPo;
	}
	public String getOtherParams() {
		return otherParams;
	}
	public void setOtherParams(String otherParams) {
		this.otherParams = otherParams;
	}
	public Integer getBillType() {
		return billType;
	}
	public void setBillType(Integer billType) {
		this.billType = billType;
	}
	
}
