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
public class RateURL extends BaseURL {
	
	/**
	 * 费率controller模块
	 */
	public static final String MODOE_NAME = "/flowsys/rate";
	/**
	 * 费率添加页面
	 */
	public static final String RATE_ADD_PAGE = "/rate_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 费率编辑页面
	 */
	public static final String RATE_EDIT_PAGE = "/rate_edit_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 费率添加
	 */
	public static final String RATE_ADD = "/rate_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 异步验证费率名称是否存在
	 */
	public static final String CHECK_RATE_NAME = "/check_rate_name" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 登录用户的费率列表
	 */
	public static final String RATE_LIST = "/rate_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 获得最优通道信息
	 */
	public static final String GET_BEST_CHANNEL = "/get_best_channel" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 获得可配置的简易通道信息
	 */
	public static final String GET_SIMPLE_CHANNEL = "/get_simple_channel" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 费率配置通道列表<br>
	 * /flowsys/rate/bind_channel_list.do
	 */
	public static final String BIND_CHANNEL_LIST = "/bind_channel_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道配置费率列表<br>
	 * /flowsys/rate/bind_agency_list.do
	 */
	public static final String BIND_AGENCY_LIST = "/bind_agency_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道配置费率页面
	 */
	public static final String BIND_CHANNEL_PAGE = "/bind_channel_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 通道配置费率<br>
	 * /flowsys/rate/bind_channel.do
	 */
	public static final String BIND_CHANNEL = "/bind_channel" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 更新绑定状态<br>
	 * /flowsys/rate/update_bind_state.do
	 */
	public static final String UPDATE_BIND_STATE = "/update_bind_state" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 更新绑定的折扣<br>
	 * /flowsys/rate/update_rate_discount.do
	 */
	public static final String UPDATE_RATE_DISCOUNT = "/update_rate_discount" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 查询统一配置的费率列表<br>
	 * /flowsys/rate/bind_rate_list.do
	 */
	public static final String BIND_RATE_LIST = "/bind_rate_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * js/json通过运营商类型获得折扣
	 * <br>/flowsys/rate/get_discount.do
	 */
	public static final String GET_DISCOUNT = "/get_discount" + DYNAMIC_WEB_SUFFIX;

}
