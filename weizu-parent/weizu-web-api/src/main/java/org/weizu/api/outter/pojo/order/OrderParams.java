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
	private String userName;			//用户账号
	private String sign;				//密钥
	private String orderId;			//充值订单号
	private String number;				//充值号码
	
	public OrderParams(String userName, String sign, String orderId) {
		super();
		this.userName = userName;
		this.sign = sign;
		this.orderId = orderId;
	}
	public OrderParams() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
