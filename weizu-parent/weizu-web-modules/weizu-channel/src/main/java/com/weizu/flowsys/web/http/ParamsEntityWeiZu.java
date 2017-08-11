package com.weizu.flowsys.web.http;

import com.weizu.web.foundation.MD5;

/**
 * @description:订购参数
 * @projectName:crud
 * @className:ParamsEntityWeiZu.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月16日 下午2:52:19
 * @version 1.0
 */
public class ParamsEntityWeiZu extends BaseParams {
	
	private String username;//用户账号
	private String number;//手机号
	private String flowsize;//流量大小
	private String user_order_id;//商户订单号
	private String sign;//签名
	private String apikey;	//apikey
	
	/** 必须参数
	 * @param username
	 * @param number
	 * @param flowsize
	 * @param sign
	 */
	public ParamsEntityWeiZu(String username, String number, String flowsize,
			String apikey) {
		super();
		this.username = username;
		this.number = number;
		this.flowsize = flowsize;
		this.sign = MD5.getMd5("username="+username+"&apikey="+apikey);;
	}
	
	
	
	@Override
	public String toString() {
		return "username=" + username + "&number=" + number
				+ "&flowsize=" + flowsize + "&user_order_id=" + user_order_id
				+ "&sign=" + sign;
	}



	public ParamsEntityWeiZu() {
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
	public String getUser_order_id() {
		return user_order_id;
	}
	public void setUser_order_id(String user_order_id) {
		this.user_order_id = user_order_id;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @return the apikey
	 */
	public String getApikey() {
		return apikey;
	}

	/**
	 * @param apikey the apikey to set
	 */
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	
}
