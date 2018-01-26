package com.weizu.flowsys.web.system_base.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 系统参数配置模块URL
 * @projectName:weizu-channel
 * @className:SystemConfURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月23日 下午3:21:16
 * @version 1.0
 */
public class SystemConfURL extends BaseURL {
	/**
	 * 参数配置模块
	 */
	public static final String MODEL_NAME="/flowsys/systemConf";
	
	/**
	 * 系统参数配置列表
	 * <br>/flowsys/systemConf/systemConf_list.do
	 */
	public static final String SYSTEMCONF_LIST = "/systemConf_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 系统参数配置页面
	 * <br>/flowsys/systemConf/systemConf_edit_page.do
	 */
	public static final String SYSTEMCONF_EDIT_PAGE = "/systemConf_edit_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 系统参数配置
	 * <br>/flowsys/systemConf/systemConf_edit.do
	 */
	public static final String SYSTEMCONF_EDIT = "/systemConf_edit" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 修改失败返回参数
	 * <br>/flowsys/systemConf/switch_fail_back.do
	 */
	public static final String SWITCH_FAIL_BACK = "/switch_fail_back" + DYNAMIC_WEB_SUFFIX;
	
	
	
	
}
