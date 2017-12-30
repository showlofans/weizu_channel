package com.weizu.flowsys.web.activity.url;

import com.weizu.flowsys.web.base.BaseURL;


/**
 * @description: 通道展示-URL管理
 * @projectName:weizu-channel
 * @className:ShowURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月30日 上午10:02:38
 * @version 1.0
 */
public class ShowRateURL extends BaseURL {
	
	/**
	 * 通道展示模块
	 */
	public static final String MODOE_NAME = "/flowsys/showRate";
	/**
	 * 展示通道添加页面
	 * <br>/flowsys/showRate/showRate_add_page.do
	 */
	public static final String SHOWRATE_ADD_PAGE = "/showRate_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 展示通道编辑页面
	 * <br>/flowsys/showRate/showRate_edit_page.do
	 */
	public static final String SHOWRATE_EDIT_PAGE = "/showRate_edit_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 展示通道添加
	 * <br> /flowsys/showRate/showRate_add.do
	 */
	public static final String SHOWRATE_ADD = "/showRate_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 展示通道列表
	 * 
	 * <br>/flowsys/showRate/showRate_list.do
	 */
	public static final String SHOWRATE_LIST = "/showRate_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 展示通道编辑<br>
	 * /flowsys/showRate/showRate_edit.do
	 */
	public static final String SHOWRATE_EDIT = "/showRate_edit" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 删除折扣
	 * <br> /flowsys/showRate/del_showRate.do
	 */
	public static final String DEL_SHOWRATE = "/del_showRate" + DYNAMIC_WEB_SUFFIX;
	
}
