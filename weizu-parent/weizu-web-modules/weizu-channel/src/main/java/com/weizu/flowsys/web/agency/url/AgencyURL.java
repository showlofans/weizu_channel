package com.weizu.flowsys.web.agency.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 代理商管理
 * @projectName:crud
 * @className:AgencyURL.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月3日 上午11:32:59
 * @version 1.0
 */
public class AgencyURL extends BaseURL {
	/**
	 * Controller模块 URL
	 */
	public static final String MODEL_NAME = "/flowsys/agency";
	/**
	 * 代理商登陆
	 * <br>/flowsys/agency/home.do
	 */
	public static final String INDEX = "/home";
	/**
	 * 代理商登陆
	 */
	public static final String LOGIN = "/login";
	/**
	 * 跳转到代理商登陆页面
	 */
	public static final String LOGIN_PAGE = "/login_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 *  跳转到注册页面
	 */
	public static final String REGISTER_PAGE = "/register_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 注册平台代理商（账户）
	 */
	public static final String REGISTER = "/register" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 自己信息编辑页面（除费率，信用，余额）
	 */
	public static final String AGENCY_INFO = "/agency_info" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 退出当前登陆用户
	 */
	public static final String LOGOUT = "/logout" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 查询子代理商列表
	 */
	public static final String CHILD_AGENCY_LIST = "/child_agency_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * ajax验证注册用户名是否存在
	 */
	public static final String REGISTER_CHECK_NAME = "/register_check_name" + DYNAMIC_WEB_SUFFIX;
	/**
	 * ajax验证注册邀请码是否存在
	 */
	public static final String REGISTER_CHECK_CODE = "/register_check_code" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 查询自己的邀请码信息
	 */
	public static final String GET_VERIFY_CODE = "/get_verify_code" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 跳转到查询电话归属地页面
	 */
	public static final String GET_TEL_LOCATION = "/get_tel_location" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 修改代理商信息（自己和子代理商）
	 */
	public static final String AGENCY_EDIT = "/agency_edit" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 修改子代理商（费率，信用）信息页面
	 */
	public static final String CHILD_AGENCY_EDIT_PAGE = "/child_agency_edit_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 修改子代理商（费率，信用）信息
	 */
	public static final String CHILD_AGENCY_EDIT = "/child_agency_edit" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 首页展示信息
	 */
	public static final String WELCOME = "/welcome" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 重置密码页面
	 */
	public static final String RESET_PASS_PAGE = "/reset_pass_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 重置密码
	 */
	public static final String RESET_PASS = "/reset_pass" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 重置下级代理商密码
	 */
	public static final String RESET_CHILD_PASS = "/reset_child_pass" + DYNAMIC_WEB_SUFFIX;
}
