package org.weizu.api.forward.weizu;

import java.io.UnsupportedEncodingException;

import org.weizu.api.base.APIParams;
import org.weizu.api.base.ParamsAPIBase;

import com.weizu.web.foundation.MD5;

/**
 * @description:微族充值api参数实体
 * @projectName:testHttpInterface
 * @className:ChargeParamsAPI.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午10:41:56
 * @version 1.0
 */
public class ChargeParamsAPI extends ParamsAPIBase implements APIParams {

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
	public ChargeParamsAPI(String requestUrl, String epName,
			String epUserName, String apikey,String number,String flowsize) {
		super(epUserName, apikey, requestUrl, epName);
		this.number = number;
		this.flowsize = flowsize;
	}
	
	public ChargeParamsAPI(String requestUrl, String epName,
			String epUserName, String apikey, String number, String flowsize,
			String timestamp, String user_order_id) {
		super(requestUrl, epName, epUserName, apikey);
		this.number = number;
		this.flowsize = flowsize;
		this.timestamp = timestamp;
		this.user_order_id = user_order_id;
	}
	
	@Override
	public String toParams() {
		String sign = null;
		try {
			sign = MD5.getMd5("username="+username+"&apikey="+apikey,null,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		return "username=" + username + "&number=" + number
				+ "&flowsize=" + flowsize + "&user_order_id=" + user_order_id
				+ "&sign=" + sign;
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
