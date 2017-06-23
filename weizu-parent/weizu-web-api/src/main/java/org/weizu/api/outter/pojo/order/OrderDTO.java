package org.weizu.api.outter.pojo.order;

/**
 * @description: 订单详情接口实体
 * @projectName:weizu-web-api
 * @className:OrderDTO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午6:02:16
 * @version 1.0
 */
public class OrderDTO {
	private int tipCode;				//提示信息编码
	private String tipMsg;				//提示信息
	private OrderIn orderIn;			//订单信息
	
	public OrderDTO(int tipCode, String tipMsg, OrderIn orderIn) {
		super();
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
		this.orderIn = orderIn;
	}
	public OrderDTO() {
		super();
	}
	public int getTipCode() {
		return tipCode;
	}
	public void setTipCode(int tipCode) {
		this.tipCode = tipCode;
	}
	public String getTipMsg() {
		return tipMsg;
	}
	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
	public OrderIn getOrderIn() {
		return orderIn;
	}
	public void setOrderIn(OrderIn orderIn) {
		this.orderIn = orderIn;
	}
	
	
}
