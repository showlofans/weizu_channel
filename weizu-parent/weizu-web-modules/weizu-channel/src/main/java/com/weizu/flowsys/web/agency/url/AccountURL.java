package com.weizu.flowsys.web.agency.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description:代理商账户管理-账户URL
 * @projectName:crud
 * @className:AccountURL.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月2日 上午9:59:58
 * @version 1.0
 */
public class AccountURL extends BaseURL {
	/**
	 * 模块URL
	 */
	public static final String MODEL_NAME = "/flowsys/account";
	/**
	 * 账户充值页面
	 */
	public static final String ADD_CHARGE_PAGE = "/add_charge_page" + DYNAMIC_WEB_SUFFIX;
	
	///weizu/account/add_charge_page.do
	/**
	 * 账户充值
	 */
	public static final String ADD_CHARGE = "/add_charge" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 账户充值记录
	 */
	public static final String CHARGE_LIST = "/charge_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 账户消费记录
	 */
	public static final String CONSUME_LIST = "/consume_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 开通对公账户页面
	 */
	public static final String OPEN_COMPANY_ACCOUNT_PAGE = "/open_company_account_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 审核对公账户页面
	 * <br>/flowsys/account/confirm_company_account_page.do
	 */
	public static final String CONFIRM_COMPANY_ACCOUNT_PAGE = "/confirm_company_account_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 开通对公账户
	 * <br>/flowsys/account/open_company_account.do
	 */
	public static final String OPEN_COMPANY_ACCOUNT = "/open_company_account" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 账户信息
	 * <br>/flowsys/account/account_info.do
	 */
	public static final String ACCOUNT_INFO = "/account_info" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 账户信息更新
	 * <br>/flowsys/account/account_info_edit.do
	 */
	public static final String ACCOUNT_INFO_EDIT = "/account_info_edit" + DYNAMIC_WEB_SUFFIX;
	/**
	 *图片上传
	 * <br>/flowsys/account/upload_img_file.do
	 */
	public static final String UPLOAD_IMG_FILE = "/upload_img_file" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 审核认证
	 * <br>/flowsys/account/verify_credentials.do
	 */
	public static final String VERIFY_CREDENTIALS = "/verify_credentials" + DYNAMIC_WEB_SUFFIX;
	
	
}
