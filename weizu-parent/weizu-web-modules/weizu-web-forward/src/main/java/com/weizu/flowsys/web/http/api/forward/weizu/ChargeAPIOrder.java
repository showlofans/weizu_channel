package com.weizu.flowsys.web.http.api.forward.weizu;

/**
 * @description:充值结果订单api实体
 * @projectName:testHttpInterface
 * @className:ChargeOrderAPI.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午10:43:39
 * @version 1.0
 */
public class ChargeAPIOrder {

	
	private String transaction_id;
	
	private String number;
	
	private String flowsize;

	public ChargeAPIOrder() {
		super();
	}

	public ChargeAPIOrder(String transaction_id, String number, String flowsize) {
		super();
		this.transaction_id = transaction_id;
		this.number = number;
		this.flowsize = flowsize;
	}

	@Override
	public String toString() {
		return "chargeOrder[number:"+number +"flowsize:"+ flowsize+"transaction_id:"+transaction_id+"]";
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
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

}
