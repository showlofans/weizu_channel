package com.weizu.flowsys.web.agency.url;

import com.weizu.flowsys.web.base.BaseURL;

public class BankAccountURL extends BaseURL {
	/**
	 * Controller模块 URL
	 */
	public static final String MODEL_NAME = "/flowsys/bankAccount";
	/**
	 * 银行卡列表
	 * <br>/flowsys/bankAccount/bank_list.do
	 */
	public static final String BANK_LIST = "/bank_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 添加银行卡页面
	 * <br> /flowsys/bankAccount/add_bank_page.do
	 */
	public static final String ADD_BANK_PAGE = "/add_bank_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 添加银行卡
	 * <br>/flowsys/bankAccount/add_bank.do
	 */
	public static final String ADD_BANK = "/add_bank" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 银行卡编辑页面
	 * <br>/flowsys/bankAccount/edit_bank_page.do
	 */
	public static final String EDIT_BANK_PAGE = "/edit_bank_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 银行卡编辑
	 * <br> /flowsys/bankAccount/edit_bank.do
	 */
	public static final String EDIT_BANK = "/edit_bank" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 银行卡删除
	 * <br> /flowsys/bankAccount/del_bank.do
	 */
	public static final String DEL_BANK = "/del_bank" + DYNAMIC_WEB_SUFFIX;
}
