package com.weizu.flowsys.web.trade.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 冲单日志
 * @projectName:weizu-channel
 * @className:ChargeLogURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月13日 下午2:38:23
 * @version 1.0
 */
public class ChargeLogURL extends BaseURL {
	/**
	 * 冲单日志模块
	 */
	public static final String MODEL_NAME="/flowsys/chargeLog";
	
	/**
	 * 冲单日志列表 
	 * <br>/flowsys/chargeLog/charge_log_list.do
	 */
	public static final String CHARGE_LOG_LIST = "/charge_log_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 按条件清除日志
	 *  <br>/flowsys/chargeLog/del_charge_log.do
	 */
	public static final String DEL_CHARGE_LOG = "/del_charge_log" + DYNAMIC_WEB_SUFFIX;
	
	
}
