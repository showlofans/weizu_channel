package com.weizu.flowsys.api.singleton;

/**
 * @description: 统一的充值返回实体（页面需要的结果）
 * @projectName:weizu-channel
 * @className:ChargeDTO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月16日 下午3:57:27
 * @version 1.0
 */
public class ChargeDTO {
	private String orderIdApi;			//充值之后上游返回的订单
	private int orderStatus;			//正常提单，提单失败

	public String getOrderIdApi() {
		return orderIdApi;
	}

	public void setOrderIdApi(String orderIdApi) {
		this.orderIdApi = orderIdApi;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
}
