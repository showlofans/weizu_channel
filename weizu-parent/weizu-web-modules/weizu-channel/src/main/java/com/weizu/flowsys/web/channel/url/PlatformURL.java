package com.weizu.flowsys.web.channel.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description:平台管理
 * @projectName:crud
 * @className:PlatformURL.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月5日 下午12:10:03
 * @version 1.0
 */
public class PlatformURL extends BaseURL{
	/**
	 * 平台controller模块
	 */
	public static final String MODOE_NAME = "/flowsys/platform";
	/**
	 * 添加平台
	 */
	public static final String PLATFORM_ADD = "/platform_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 添加平台页面
	 */
	public static final String PLATFORM_ADD_PAGE = "/platform_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 清除平台
	 */
	public static final String PLATFORM_DEL = "/platform_del" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 平台编辑
	 */
	public static final String PLATFORM_EDIT = "/platform_edit" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 平台编辑页面
	 */
	public static final String PLATFORM_EDIT_PAGE = "/platform_edit_page" + DYNAMIC_WEB_SUFFIX;
	
	
	/**
	 * 平台列表
	 */
	public static final String PLATFORM_LIST = "/platform_list" + DYNAMIC_WEB_SUFFIX;
	
}
