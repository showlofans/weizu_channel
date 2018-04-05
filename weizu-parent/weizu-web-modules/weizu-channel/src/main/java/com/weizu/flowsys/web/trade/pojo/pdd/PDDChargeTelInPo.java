package com.weizu.flowsys.web.trade.pojo.pdd;

public class PDDChargeTelInPo {
	
	private String status;//订购状态：ACCEPT-成功,PROCESS
	
	private String outOrderNo;	//拼多多订单号
	
	private String orderNo;
	
	private Long totalFee;		//内部订单总金额（分）
	
	private String mobile;
	
	private Long crateTime;		//订单创建时间
	
	private String parPrice;	//充值面额
	
	private Integer parValue;	//充值面值
	

	public PDDChargeTelInPo() {
		super();
	}
	
	public PDDChargeTelInPo(String status, String outOrderNo, String orderNo,
			Long totalFee, String mobile, Long crateTime, String parPrice,
			Integer parValue) {
		super();
		this.status = status;
		this.outOrderNo = outOrderNo;
		this.orderNo = orderNo;
		this.totalFee = totalFee;
		this.mobile = mobile;
		this.crateTime = crateTime;
		this.parPrice = parPrice;
		this.parValue = parValue;
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

	public String getParPrice() {
		return parPrice;
	}

	public void setParPrice(String parPrice) {
		this.parPrice = parPrice;
	}

	public Integer getParValue() {
		return parValue;
	}

	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}

	public Long getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Long crateTime) {
		this.crateTime = crateTime;
	}
	
	
}
