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
	private Long transaction_id;				//上级订单号(接口订单号)(或者下游提单就是系统的订单号)
	private String user_order_id;				//下级订单号(接口订单号)(或者下游提单就是用户的订单号)
	private String number;						//充值号码
	private Integer flowsize;					//包体大小
	private Double charge_fee;					//充值价格
	private String created_at;					//返回的充值时间
	private Integer status;							//订单状态
	private String statusMSg;					//订单状态描述
	
	public OrderPo(Long transaction_id, String user_order_id, String number,
			Integer flowsize, Double charge_fee, String created_at,  Integer status,
			String statusMSg) {
		super();
		this.transaction_id = transaction_id;
		this.user_order_id = user_order_id;
		this.number = number;
		this.flowsize = flowsize;
		this.charge_fee = charge_fee;
		this.created_at = created_at;
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
	public Long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getUser_order_id() {
		return user_order_id;
	}
	public void setUser_order_id(String user_order_id) {
		this.user_order_id = user_order_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getFlowsize() {
		return flowsize;
	}
	public void setFlowsize(Integer flowsize) {
		this.flowsize = flowsize;
	}
	public Double getCharge_fee() {
		return charge_fee;
	}
	public void setCharge_fee(Double charge_fee) {
		this.charge_fee = charge_fee;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
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
