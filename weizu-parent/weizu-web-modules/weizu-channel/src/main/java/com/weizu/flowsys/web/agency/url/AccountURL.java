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
	
	
}
