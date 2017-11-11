package com.weizu.flowsys.web.channel.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 话费通道地址
 * @projectName:weizu-channel
 * @className:TelChannelURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月10日 下午4:38:50
 * @version 1.0
 */
public class TelChannelURL extends BaseURL {
	
	/**
	 * 话费通道controller模块
	 */
	public static final String MODOE_NAME = "/flowsys/tel_channel";
	
	/**
	 * 话费通道添加页面
	 * <br>/flowsys/tel_channel/telchannel_add_page.do
	 */
	public static final String TELCHANNEL_ADD_PAGE = "/telchannel_add_page" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 话费通道添加
	 * <br>/flowsys/tel_channel/telchannel_add.do
	 */
	public static final String TELCHANNEL_ADD = "/telchannel_add" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 话费充值页面：异步加载话费其他业务类型
	 * <br>/flowsys/tel_channel/ajax_get_params.do
	 */
	public static final String AJAX_GET_PARAMS = "/ajax_get_params" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 话费通道列表
	 * <br>/flowsys/tel_channel/telchannel_list.do
	 */
	public static final String TELCHANNEL_LIST = "/telchannel_list" + DYNAMIC_WEB_SUFFIX;
	
	
}
