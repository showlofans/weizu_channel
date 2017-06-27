package com.weizu.flowsys.web.channel.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description:上级通道管理
 * @projectName:crud
 * @className:ChannelURL.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月5日 上午10:58:38
 * @version 1.0
 */
public class ChannelURL extends BaseURL{
	/**
	 * 通道controller模块
	 */
	public static final String MODOE_NAME = "/flowsys/channel";
	/**
	 * 通道添加页面
	 */
	public static final String CHANNEL_ADD_PAGE = "/channel_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道添加
	 */
	public static final String CHANNEL_ADD = "/channel_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道列表
	 */
	public static final String CHANNEL_LIST = "/channel_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 获得相应服务类型和运营商类型所有流量包大小并合并成字符串返回
	 */
	public static final String CHANGE_CHANNEL_PGSIZE = "/change_channel_pgSize" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 平台搜索
	 */
	public static final String SEARCH_PLATFORM = "/search_platform"+ DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道使用状态更新
	 */
	public static final String CHANNEL_USE_STATE_UPDATE = "/channel_use_state_update"+ DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道状态更新
	 */
	public static final String CHANNEL_STATE_UPDATE = "/channel_state_update"+ DYNAMIC_WEB_SUFFIX;
}
