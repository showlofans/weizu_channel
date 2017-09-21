package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

/**
 * @description: 接口返回订单明细
 * @projectName:weizu-channel
 * @className:OrderIn.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月31日 下午5:18:23
 * @version 1.0
 */
public class OrderIn implements Cloneable {
	private String transaction_id;				//上级订单号(接口订单号)(或者下游提单就是系统的订单号)
	private String user_order_id;				//下级订单号(接口订单号)(或者下游提单就是用户的订单号)
	private String number;
	private String flowsize;
	private String charge_fee;
	private String created_at;					//返回的充值时间
	private Long created_at_time;				//添加到数据库的时间
	private int status;							//订单状态
	private String msg;							//订单状态描述
	
	/** 数据库订单
	 * @param transaction_id
	 * @param user_order_id
	 * @param number
	 * @param flowsize
	 * @param charge_fee
	 * @param created_at_time
	 * @param status
	 * @param msg
	 */
	public OrderIn(String transaction_id, String user_order_id, String number,
			String flowsize, String charge_fee,Long created_at_time, int status, String msg) {
		super();
		this.transaction_id = transaction_id;
		this.user_order_id = user_order_id;
		this.number = number;
		this.flowsize = flowsize;
		this.charge_fee = charge_fee;
		this.created_at_time = created_at_time;
		this.status = status;
		this.msg = msg;
	}
	
	public OrderIn(String transaction_id, String user_order_id, String number,
			String flowsize, String charge_fee, String created_at, int status,
			String msg) {
		super();
		this.transaction_id = transaction_id;
		this.user_order_id = user_order_id;
		this.number = number;
		this.flowsize = flowsize;
		this.charge_fee = charge_fee;
		this.created_at = created_at;
		this.status = status;
		this.msg = msg;
	}


	public OrderIn() {
		super();
	}
	
	@Override
	public OrderIn clone() {
		// TODO Auto-generated method stub
		OrderIn orderIn = null;
    	try{  
    		orderIn = (OrderIn)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
		return orderIn;
	}

	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
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
	public String getFlowsize() {
		return flowsize;
	}
	public void setFlowsize(String flowsize) {
		this.flowsize = flowsize;
	}
	public String getCharge_fee() {
		return charge_fee;
	}
	public void setCharge_fee(String charge_fee) {
		this.charge_fee = charge_fee;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public Long getCreated_at_time() {
		return created_at_time;
	}
	public void setCreated_at_time(Long created_at_time) {
		this.created_at_time = created_at_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
