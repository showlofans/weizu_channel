package com.weizu.flowsys.api.hsingleton.orderState;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 话费回调地址
 * @projectName:weizu-channel
 * @className:TelCallBackURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年3月19日 上午11:32:19
 * @version 1.0
 */
public class TelCallBackURL extends BaseURL {
	/**
	 * 回调模块
	 */
	public static final String MODOE_NAME = "/flowsys/telcallBack";
	
	/**
	 * 连城连回调
	 * <br>/flowsys/telcallBack/unicomAync
	 */
	public static final String UNICOMAYNC = "/unicomAync";
	
}
