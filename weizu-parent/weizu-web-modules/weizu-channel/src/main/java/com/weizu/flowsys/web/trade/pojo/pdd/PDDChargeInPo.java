package com.weizu.flowsys.web.trade.pojo.pdd;

public class PDDChargeInPo {
	
	private String status;//订购状态：ACCEPT-成功,PROCESS
	
	private String outOrderNo;	//拼多多订单号
	
	private String orderNo;
	
	private Long totalFee;		//内部订单总金额（分）
	
	private String mobile;
	
	private String prodNo;		//编码
	
	private Long crateTime;		//订单创建时间
	
	public PDDChargeInPo(String status, String outOrderNo, String orderNo,
			Long totalFee, String mobile, String prodNo, Long crateTime) {
		super();
		this.status = status;
		this.outOrderNo = outOrderNo;
		this.orderNo = orderNo;
		this.totalFee = totalFee;
		this.mobile = mobile;
		this.prodNo = prodNo;
		this.crateTime = crateTime;
	}
	
	

	public PDDChargeInPo() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOutOrderNo() {
		return outOrderNo;
	}

	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public Long getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Long crateTime) {
		this.crateTime = crateTime;
	}
	
	
}
