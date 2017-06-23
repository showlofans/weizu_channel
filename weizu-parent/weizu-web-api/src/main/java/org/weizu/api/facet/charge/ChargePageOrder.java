package org.weizu.api.facet.charge;

/**
 * @description: 充值返回page订单
 * @projectName:testHttpInterface
 * @className:ChargePageOrder.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午10:29:52
 * @version 1.0
 */
public class ChargePageOrder {
	
	private String transaction_id;
	
	private String number;
	
	private String flowsize;
	
	private long orderBackTime;

	public ChargePageOrder() {
		super();
	}

	public ChargePageOrder(String transaction_id, String number, String flowsize) {
		super();
		this.transaction_id = transaction_id;
		this.number = number;
		this.flowsize = flowsize;
		this.orderBackTime = System.currentTimeMillis();
	}

	@Override
	public String toString() {
		return "chargePageOrder[number:"+number +"flowsize:"+ flowsize+"transaction_id:"+transaction_id+"]";
	}
	
	
	public long getOrderBackTime() {
		return orderBackTime;
	}

	public void setOrderBackTime(long orderBackTime) {
		this.orderBackTime = orderBackTime;
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
