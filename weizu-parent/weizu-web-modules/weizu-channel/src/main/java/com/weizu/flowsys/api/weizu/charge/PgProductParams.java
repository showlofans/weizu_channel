package com.weizu.flowsys.api.weizu.charge;

public class PgProductParams {
	
	private String sign;
	
	private String userName;
	
	private Integer operaterType;

	public PgProductParams(String sign, String userName) {
		super();
		this.sign = sign;
		this.userName = userName;
	}

	public PgProductParams() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getOperaterType() {
		return operaterType;
	}

	public void setOperaterType(Integer operaterType) {
		this.operaterType = operaterType;
	}
	
}
