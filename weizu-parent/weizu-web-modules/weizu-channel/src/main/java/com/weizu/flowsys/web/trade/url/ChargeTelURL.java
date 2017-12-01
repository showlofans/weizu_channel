package com.weizu.flowsys.web.trade.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 话费充值
 * @projectName:weizu-channel
 * @className:ChargeTelURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月30日 下午5:20:07
 * @version 1.0
 */
public class ChargeTelURL extends BaseURL {
	/**
	 * 话费充值模块
	 */
	public static final String MODEL_NAME="/flowsys/chargeTel";
	
	/**
	 * 话费充值页面
	 */
	public static final String TEL_CHARGE_PAGE = "/tel_charge_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 异步获得话费充值编码和折扣
	 */
	public static final String AJAX_CHARGE_TELPC = "/ajax_charge_telpc" + DYNAMIC_WEB_SUFFIX;
	
	
}
