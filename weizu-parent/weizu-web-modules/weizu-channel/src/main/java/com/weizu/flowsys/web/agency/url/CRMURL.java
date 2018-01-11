package com.weizu.flowsys.web.agency.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 客户基本信息-URL管理
 * @projectName:weizu-channel
 * @className:CRMURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月3日 下午2:27:29
 * @version 1.0
 */
public class CRMURL extends BaseURL {
	
	/**
	 * 客户基本信息模块
	 */
	public static final String MODOE_NAME = "/flowsys/crm";
	/**
	 * 客户基本信息添加页面
	 * <br>/flowsys/crm/crm_add_page.do
	 */
	public static final String CRM_ADD_PAGE = "/crm_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 客户基本信息编辑页面
	 * <br>/flowsys/crm/crm_edit_page.do
	 */
	public static final String CRM_EDIT_PAGE = "/crm_edit_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 客户信息编辑页面
	 * <br>/flowsys/crm/crm_info_edit_page.do
	 */
	public static final String CRM_INFO_EDIT_PAGE = "/crm_info_edit_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 客户基本信息添加
	 * <br> /flowsys/crm/crm_add.do
	 */
	public static final String CRM_ADD = "/crm_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 客户基本信息列表
	 * 
	 * <br>/flowsys/crm/crm_list.do
	 */
	public static final String CRM_LIST = "/crm_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 客户基本信息编辑<br>
	 * /flowsys/crm/crm_edit.do
	 */
	public static final String CRM_EDIT = "/crm_edit" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 客户信息编辑<br>
	 * /flowsys/crm/crm_info_edit.do
	 */
	public static final String CRM_INFO_EDIT = "/crm_info_edit" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 删除客户基本信息
	 * <br> /flowsys/crm/del_crm.do
	 */
	public static final String DEL_CRM = "/del_crm" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 变更客户基本信息状态
	 * <br> /flowsys/crm/update_crm_state.do
	 */
	public static final String UPDATE_CRM_STATE = "/update_crm_state" + DYNAMIC_WEB_SUFFIX;
	
}
