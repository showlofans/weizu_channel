package org.weizu.api.forward.weizu;

import org.weizu.api.base.APIParams;
import org.weizu.api.base.ParamsAPIBase;
import org.weizu.api.util.MD5;


/**
 * @description:订单状态api参数
 * @projectName:testHttpInterface
 * @className:OrderStateParamsAPI.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午6:16:04
 * @version 1.0
 */
public class OrderStateParamsAPI extends ParamsAPIBase implements APIParams {
	
	private String order_id;
	
	private String telphone;
	
	private String user_order_id;
	
	/** 必须参数
	 * @param username
	 * @param order_id
	 * @param apikey
	 * @param url
	 * @param epName
	 */
	public OrderStateParamsAPI(String username,String order_id, String apikey, String url,
			String epName) {
		super(username, apikey, url, epName);
		this.order_id = order_id;
	}

	public OrderStateParamsAPI(String username, String apikey, String url,
			String epName, String order_id, String telphone,
			String user_order_id) {
		super(username, apikey, url, epName);
		this.order_id = order_id;
		this.telphone = telphone;
		this.user_order_id = user_order_id;
	}

	@Override
	public String toParams() {
		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
		return "username="+username+"&order_id="+ order_id +"&sign="+sign;
		//+"&telphone="+ telphone 不能传空值
	}
	
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getUser_order_id() {
		return user_order_id;
	}

	public void setUser_order_id(String user_order_id) {
		this.user_order_id = user_order_id;
	}
}
