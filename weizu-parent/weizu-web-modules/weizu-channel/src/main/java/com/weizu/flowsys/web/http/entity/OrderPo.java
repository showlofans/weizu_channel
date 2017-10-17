package com.weizu.flowsys.web.http.entity;

/**
 * @description: 返给下游的订单详情
 * @projectName:weizu-channel
 * @className:OrderPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年9月2日 上午9:29:42
 * @version 1.0
 */
public class OrderPo {
	private Long orderId;				//上级订单号(接口订单号)(或者下游提单就是系统的订单号)
	private String userOrderId;				//下级订单号(接口订单号)(或者下游提单就是用户的订单号)
	private String number;						//充值号码
	private Integer pgSize;					//包体大小
	private Double chargeFee;					//充值价格
	private String createdAt;					//返回的充值时间
	private Integer status;							//订单状态
	private String statusMSg;					//订单状态描述
	
	public OrderPo(Long orderId, String userOrderId, String number,
			Integer pgSize, Double chargeFee, String createdAt,  Integer status,
			String statusMSg) {
		super();
		this.orderId = orderId;
		this.userOrderId = userOrderId;
		this.number = number;
		this.pgSize = pgSize;
		this.chargeFee = chargeFee;
		this.createdAt = createdAt;
		this.status = status;
		this.statusMSg = statusMSg;
	}
	
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "transaction_id:"+ this.transaction_id + "\tuser_order_id:"+this.user_order_id
//				+ "\tnumber:"+this.number+ "\tflowsize:"+this.flowsize
//				+ "\tcharge_fee:"+this.charge_fee+ "\tcreated_at:"+this.created_at
//				+ "\tstatus:"+this.status+ "\tstatusMSg:"+this.statusMSg;
//	}


	public OrderPo() {
		super();
	}
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(String userOrderId) {
		this.userOrderId = userOrderId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getPgSize() {
		return pgSize;
	}
	public void setPgSize(Integer pgSize) {
		this.pgSize = pgSize;
	}

	public Double getChargeFee() {
		return chargeFee;
	}

	public void setChargeFee(Double chargeFee) {
		this.chargeFee = chargeFee;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public  Integer getStatus() {
		return status;
	}
	public void setStatus( Integer status) {
		this.status = status;
	}
	public String getStatusMSg() {
		return statusMSg;
	}
	public void setStatusMSg(String statusMSg) {
		this.statusMSg = statusMSg;
	}
}
