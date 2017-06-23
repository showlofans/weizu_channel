package com.weizu.flowsys.web.trade.pojo;

/**
 * @description: 订单状态更新参数
 * @projectName:weizu-channel
 * @className:PurchaseStateParams.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月21日 下午3:11:41
 * @version 1.0
 */
public class PurchaseStateParams {
	private Long orderId;						//订单号
	private Long orderBackTime;					//充值时间（本平台获得返回结果，或者返回给下游平台结果的时间戳）
	private Integer orderResult;				//结果（enum:）
	private String orderResultDetail;			//结果描述
	public PurchaseStateParams() {
		super();
	}
	public PurchaseStateParams(Long orderId, Long orderBackTime,
			Integer orderResult, String orderResultDetail) {
		super();
		this.orderId = orderId;
		this.orderBackTime = orderBackTime;
		this.orderResult = orderResult;
		this.orderResultDetail = orderResultDetail;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getOrderBackTime() {
		return orderBackTime;
	}
	public void setOrderBackTime(Long orderBackTime) {
		this.orderBackTime = orderBackTime;
	}
	public Integer getOrderResult() {
		return orderResult;
	}
	public void setOrderResult(Integer orderResult) {
		this.orderResult = orderResult;
	}
	public String getOrderResultDetail() {
		return orderResultDetail;
	}
	public void setOrderResultDetail(String orderResultDetail) {
		this.orderResultDetail = orderResultDetail;
	}
}
