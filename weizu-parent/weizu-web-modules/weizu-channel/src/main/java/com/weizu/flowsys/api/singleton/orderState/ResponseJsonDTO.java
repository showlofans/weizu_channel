package com.weizu.flowsys.api.singleton.orderState;

/**
 * @description: 向下游统一返回的回调结果实体
 * @projectName:weizu-channel
 * @className:ResponseJsonDTO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年9月4日 下午12:40:44
 * @version 1.0
 */
public class ResponseJsonDTO {
	private Long orderId;			//订单号
	private String orderIdFrom;		//接入方订单号
	private int status;				//返回订单状态
	private String statusDetail;		//失败原因
	private Long timeStamp;			//返回的时间戳
	private String chargeTel;		//充值手机号
	
	public ResponseJsonDTO(Long orderId, String orderIdFrom, int status,
			String statusDetail, Long timeStamp, String chargeTel) {
		super();
		this.orderId = orderId;
		this.orderIdFrom = orderIdFrom;
		this.status = status;
		this.statusDetail = statusDetail;
		this.timeStamp = timeStamp;
		this.chargeTel = chargeTel;
	}
	public ResponseJsonDTO(Long orderId, String orderIdFrom, Long timeStamp) {
		super();
		this.orderId = orderId;
		this.orderIdFrom = orderIdFrom;
		this.timeStamp = timeStamp;
	}

	public String getChargeTel() {
		return chargeTel;
	}
	public void setChargeTel(String chargeTel) {
		this.chargeTel = chargeTel;
	}
	public ResponseJsonDTO() {
		super();
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderIdFrom() {
		return orderIdFrom;
	}
	public void setOrderIdFrom(String orderIdFrom) {
		this.orderIdFrom = orderIdFrom;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusDetail() {
		return statusDetail;
	}
	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
