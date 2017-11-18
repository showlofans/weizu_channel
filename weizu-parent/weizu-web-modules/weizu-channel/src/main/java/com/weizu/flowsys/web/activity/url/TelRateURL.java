package com.weizu.flowsys.web.activity.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description:费率管理-URL管理
 * @projectName:crud
 * @className:RateURL.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月5日 上午10:37:05
 * @version 1.0
 */
public class TelRateURL extends BaseURL {
	
	/**
	 * 话费折扣模块
	 */
	public static final String MODOE_NAME = "/flowsys/telRate";
	/**
	 * 费率添加页面
	 */
	public static final String TELRATE_ADD_PAGE = "/telRate_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 费率编辑页面
	 */
	public static final String TELRATE_EDIT_PAGE = "/telRate_edit_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 费率添加
	 * <br> /flowsys/telRate/telRate_add
	 */
	public static final String TELRATE_ADD = "/telRate_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 异步验证费率名称是否存在
	 */
	public static final String CHECK_TELRATE_NAME = "/check_telRate_name" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 登录用户的费率列表
	 */
	public static final String TELRATE_LIST = "/telRate_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 获得最优通道信息
	 */
	public static final String GET_BEST_CHANNEL = "/get_best_channel" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 获得可配置的简易通道信息
	 */
	public static final String GET_SIMPLE_CHANNEL = "/get_simple_channel7897489" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 费率配置通道列表<br>
	 * /flowsys/teltelRate/bind_channel_list.do
	 */
	public static final String BIND_CHANNEL_LIST = "/bind_channel_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道配置费率列表<br>
	 * /flowsys/telRate/bind_agency_list.do
	 */
	public static final String BIND_AGENCY_LIST = "/bind_agency_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道配置费率页面
	 */
	public static final String BIND_CHANNEL_PAGE = "/bind_channel_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道配置费率<br>
	 * /flowsys/telRate/bind_channel.do
	 */
	public static final String BIND_CHANNEL = "/bind_channel" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 更新绑定状态<br>
	 * /flowsys/telRate/update_bind_state.do
	 */
	public static final String UPDATE_BIND_STATE = "/update_bind_state" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 批量更新绑定状态（根据折扣id，批量解除绑定）
	 * <br>/flowsys/telRate/batch_update_bind_state.do
	 */
	public static final String BATCH_UPDATE_BIND_STATE = "/batch_update_bind_state" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 更新绑定状态提示页面<br>
	 * /flowsys/telRate/update_bind_state_confirm.do
	 */
	public static final String UPDATE_BIND_STATE_CONFIRM = "/update_bind_state_confirm" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 更新绑定的折扣<br>
	 * /flowsys/telRate/update_telRate_discount.do
	 */
	public static final String UPDATE_TELRATE_DISCOUNT = "/update_telRate_discount" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 查询统一配置的费率列表<br>
	 * /flowsys/telRate/bind_telRate_list.do
	 */
	public static final String BIND_TELRATE_LIST = "/bind_telRate_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 绑定折扣添加页面
	 * <br>/flowsys/telRate/bind_telRate_add_page.do
	 */
	public static final String BIND_TELRATE_ADD_PAGE = "/telRate_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 绑定折扣添加
	 * <br>/flowsys/telRate/bind_telRate_add.do
	 */
	public static final String BIND_TELRATE_ADD = "/bind_telRate_add" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 绑定折扣编辑
	 *  <br>/flowsys/telRate/bind_telRate_edit.do
	 */
	public static final String BIND_TELRATE_EDIT = "/bind_telRate_edit" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * js/json通过参数获得折扣列表
	 * <br>/flowsys/telRate/get_discount.do
	 */
	public static final String GET_DISCOUNT = "/get_discount" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 通道绑定代理商页面
	 * <br>/flowsys/telRate/bind_agency_page.do
	 */
	public static final String BIND_AGENCY_PAGE = "/bind_agency_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道批量绑定代理商页面
	 * <br>/flowsys/telRate/batch_bind_agency_page.do
	 */
	public static final String BATCH_BIND_AGENCY_PAGE = "/batch_bind_agency_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道批量绑定代理商
	 * <br>/flowsys/telRate/batch_bind_agency.do
	 */
	public static final String BATCH_BIND_AGENCY = "/batch_bind_agency" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 欢迎界面
	 * <br>/flowsys/telRate/welcome.do
	 */
	public static final String WELCOME = "/welcome" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 费率配置列表
	 */
	public static final String MY_TELRATE_LIST = "/my_telRate_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 在费率下添加一个费率
	 */
	public static final String ADD_MY_TELRATE = "/add_my_telRate" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 删除代理商和通道的绑定
	 * <br>/flowsys/telRate/del_agency_active_telRate.do
	 */
	public static final String DEL_AGENCY_ACTIVE_TELRATE = "/del_agency_active_telRate" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 删除折扣
	 * <br> /flowsys/telRate/del_telRate.do
	 */
	public static final String DEL_TELRATE = "/del_telRate" + DYNAMIC_WEB_SUFFIX;
	
	
}
