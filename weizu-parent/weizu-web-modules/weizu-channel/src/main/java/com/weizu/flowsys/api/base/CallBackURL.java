package com.weizu.flowsys.api.base;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 对上接收回调结果地址
 * @projectName:weizu-channel
 * @className:CallBackUrl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月26日 上午10:17:54
 * @version 1.0
 */
public class CallBackURL extends BaseURL{
	/**
	 * 回调模块
	 */
	public static final String MODOE_NAME = "/flowsys/callBack";
	/**
	 * 微族科技回调接口<br>
	 * 真实地址：http://www.weizutec.top:28445/flowsys/callBack/weizu.do
	 */
	public static final String Weizu = "/weizu"+ DYNAMIC_WEB_SUFFIX;
	/**
	 * 微族科技回调接口<br>
	 * 真实地址：http://www.weizutec.top:28445/flowsys/callBack/li_rong.do
	 */
	public static final String LIRONG = "/li_rong"+ DYNAMIC_WEB_SUFFIX;
}
