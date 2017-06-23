package org.weizu.api.facet.charge.impl;

import org.weizu.api.base.PageParams;
import org.weizu.api.base.ParamsPageBase;

/**
 * @description:充值参数page实体
 * @projectName:testHttpInterface
 * @className:ChargeParamsPage.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午10:12:10
 * @version 1.0
 */
public class ChargeParamsPage extends ParamsPageBase implements PageParams {
	
	private String number;				//充值号码
	private String flowsize;			//流量大小
	private String timestamp;			//充值时间戳
	private String user_order_id;		//系统生成的唯一订单
	
	/**基本数据
	 * @param requestUrl
	 * @param epName
	 * @param epUserName
	 * @param apikey
	 * @param number
	 * @param flowsize
	 */
	public ChargeParamsPage(String requestUrl, String epName,
			String epUserName, String apikey,String number,String flowsize) {
		super(requestUrl, epName, epUserName, apikey);
		this.number = number;
		this.flowsize = flowsize;
	}
	
	public ChargeParamsPage(String requestUrl, String epName,
			String epUserName, String apikey, String number, String flowsize,
			String timestamp, String user_order_id) {
		super(requestUrl, epName, epUserName, apikey);
		this.number = number;
		this.flowsize = flowsize;
		this.timestamp = timestamp;
		this.user_order_id = user_order_id;
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


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getUser_order_id() {
		return user_order_id;
	}


	public void setUser_order_id(String user_order_id) {
		this.user_order_id = user_order_id;
	}
	
	

}
