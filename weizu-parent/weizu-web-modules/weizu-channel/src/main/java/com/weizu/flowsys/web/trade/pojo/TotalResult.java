package com.weizu.flowsys.web.trade.pojo;

/**
 * @description: 成功订单的统计信息
 * @projectName:weizu-channel
 * @className:TotalResult.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月21日 下午5:11:27
 * @version 1.0
 */
public class TotalResult {
	private Integer totalRecords;		//总记录数
	private Double totalPrice;			//原价
	private Double totalAmount;			//总扣款
	private Double totalCost;			//总扣款
	
	
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
