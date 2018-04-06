package com.weizu.flowsys.web.http.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 拼多多接口对外访问地址
 * @projectName:weizu-channel
 * @className:OuterApiURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年4月2日 上午10:54:44
 * @version 1.0
 */
public class PDDApiURL extends BaseURL {
	/**
	 * 拼多多接口模块
	 */
	public static final String MODOE_NAME = "/mobileService";
	/**
	 * 流量订购<br>
	 * 真实地址：https://www.91weizu.cn/mobileService/orderDataFlow.do
	 */
	public static final String ORDER_DATA_FLOW = "/orderDataFlow";
	/**
	 * 快充话费订购接口<br>
	 * 真实地址：https://www.91weizu.cn/mobileService/orderTelFeeByPhone
	 */
	public static final String order_tel_fee_by_phone = "/orderTelFeeByPhone";
	/**
	 * 慢充话费充值接口<br>
	 * 真实地址：https://www.91weizu.cn/mobileService/orderTelFee
	 */
	public static final String ORDER_TEL_FEE = "/orderTelFee";
	
	/**
	 * 拼多多密钥
	 */
	public static final String API_KEY = "F0F3672F76D5B59C3783A795BDA39293";
	/**
	 * type固定值-pdd.virtual.mobile.charge.notify
	 */
	public static final String type = "pdd.virtual.mobile.charge.notify";
	/**
	 * access_token
	 */
	public static final String access_token = "F0F3672F76D5B59C3783A795BDA39293";
	/**
	 * client_id
	 */
	public static final String client_id = "1709112";
	/**
	 * sign_type
	 */
	public static final String sign_type = "MD5";
	/**
	 * pdd_host_url
	 */
	public static final String pdd_host_url = "MD5";
	/**
	 * agency_id
	 */
	public static final int agency_id = 302;
	
}
