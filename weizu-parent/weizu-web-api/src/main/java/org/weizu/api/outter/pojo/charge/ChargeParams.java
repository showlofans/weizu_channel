package org.weizu.api.outter.pojo.charge;

/**
 * @description: 下级代理充值api参数
 * @projectName:weizu-web-api
 * @className:ChargeParams.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:27:07
 * @version 1.0
 */
public class ChargeParams {
	
	private String username;			//用户账号
	private String number;				//充值号码
	private String flowsize;			//流量大小
	private String scope;				//流量范围
	private String sign;				//密钥
	
	public ChargeParams(String scope, String username, String number, String flowsize,
			String sign) {
		super();
		this.username = username;
		this.number = number;
		this.flowsize = flowsize;
		this.scope = scope;
		this.sign = sign;
	}
	public ChargeParams() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
