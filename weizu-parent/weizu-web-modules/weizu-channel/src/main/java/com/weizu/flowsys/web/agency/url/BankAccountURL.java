package com.weizu.flowsys.web.agency.url;

import com.weizu.flowsys.web.base.BaseURL;

public class BankAccountURL extends BaseURL {
	/**
	 * Controller模块 URL
	 */
	public static final String MODEL_NAME = "/flowsys/bankAccount";
	/**
	 * 我的银行卡列表
	 * <br>/flowsys/bankAccount/my_bank_list.do
	 */
	public static final String MY_BANK_LIST = "/my_bank_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 加款银行卡列表
	 * <br>/flowsys/bankAccount/plus_bank_list.do
	 */
	public static final String PLUS_BANK_LIST = "/plus_bank_list" + DYNAMIC_WEB_SUFFIX;
	
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
	/**
	 * 银行卡绑定删除
	 * <br> /flowsys/bankAccount/del_bank_bind.do
	 */
	public static final String DEL_BANK_BIND = "/del_bank_bind" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 银行卡绑定
	 * <br> /flowsys/bankAccount/attach_bank_page.do
	 */
	public static final String ATTACH_BANK_PAGE = "/attach_bank_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 银行卡绑定
	 * <br> /flowsys/bankAccount/attach_bank.do
	 */
	public static final String ATTACH_BANK = "/attach_bank" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 修改银行卡默认状态
	 * <br> /flowsys/bankAccount/change_bank_polarity.do
	 */
	public static final String CHANGE_BANK_POLARITY = "/change_bank_polarity" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 银行卡解绑
	 * <br> /flowsys/bankAccount/unattach_bank.do
	 */
	public static final String UNATTACH_BANK = "/unattach_bank" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 银行卡转账
	 * <br> /flowsys/bankAccount/transfer_bank.do
	 */
	public static final String TRANSFER_BANK = "/transfer_bank" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 转账记录页面
	 * <br> /flowsys/bankAccount/transfer_record.do
	 */
	public static final String TRANSFER_RECORD = "/transfer_record" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 转账审核页面
	 * <br> /flowsys/bankAccount/transfer_confirm_page.do
	 */
	public static final String TRANSFER_CONFIRM_PAGE = "/transfer_confirm_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 审核转账记录
	 * <br> /flowsys/bankAccount/transfer_confirm.do
	 */
	public static final String TRANSFER_CONFIRM = "/transfer_confirm" + DYNAMIC_WEB_SUFFIX;
	
	
	
}
