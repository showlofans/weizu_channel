package com.weizu.flowsys.web.http.weizu;

import com.weizu.flowsys.web.http.BaseParams;

/**
 * @description: 订单回调查询实体
 * @projectName:crud
 * @className:OrderStateParams.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月16日 下午5:41:32
 * @version 1.0
 */
public class OrderStateParams extends BaseParams{
	private String username;
	private String order_id;
	private String user_order_id;
	private String telphone;
	private String sign;
	
	public OrderStateParams(String username, String order_id, String telphone,
			String sign) {
		super();
		this.username = username;
		this.order_id = order_id;
		this.telphone = telphone;
		this.sign = sign;
	}
	/**必须构造函数
	 * @param username
	 * @param order_id
	 * @param sign
	 */
	public OrderStateParams(String username, String order_id, String sign) {
		super();
		this.username = username;
		this.order_id = order_id;
		this.sign = sign;
	}
	public OrderStateParams() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the order_id
	 */
	public String getOrder_id() {
		return order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	/**
	 * @return the user_order_id
	 */
	public String getUser_order_id() {
		return user_order_id;
	}
	/**
	 * @param user_order_id the user_order_id to set
	 */
	public void setUser_order_id(String user_order_id) {
		this.user_order_id = user_order_id;
	}
	/**
	 * @return the telphone
	 */
	public String getTelphone() {
		return telphone;
	}
	/**
	 * @param telphone the telphone to set
	 */
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	/**
	 * @description: 订单号order_id是必须的
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月16日 下午5:40:18
	 */
	@Override
	public String toString() {
		return "username="+username+"&order_id="+order_id+"&telphone"+telphone+"&sign="+sign;
	}

}
