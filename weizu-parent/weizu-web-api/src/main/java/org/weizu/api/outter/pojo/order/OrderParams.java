package org.weizu.api.outter.pojo.order;

/**
 * @description: 订单查询接口参数
 * @projectName:weizu-web-api
 * @className:OrderParams.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午5:57:47
 * @version 1.0
 */
public class OrderParams {
	private String username;			//用户账号
	private String sign;				//密钥
	private String order_id;			//充值订单号
	private String number;				//充值号码
	
	public OrderParams(String username, String sign, String order_id) {
		super();
		this.username = username;
		this.sign = sign;
		this.order_id = order_id;
	}
	public OrderParams() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
