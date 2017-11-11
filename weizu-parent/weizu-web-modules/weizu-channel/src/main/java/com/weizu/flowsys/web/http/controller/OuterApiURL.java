package com.weizu.flowsys.web.http.controller;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description:接口对外访问地址
 * @projectName:weizu-channel
 * @className:OuterApiURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月26日 上午11:03:24
 * @version 1.0
 */
public class OuterApiURL extends BaseURL {
	/**
	 * 对外接口模块
	 */
	public static final String MODOE_NAME = "/flowsys/weizuAPI";
	/**
	 * 下游余额查询接口<br>
	 * 真实地址：http://www.weizutec.top:28445/weizuAPI/my_balance.do
	 */
	public static final String MY_BALANCE = "/my_balance";
	/**
	 * 下游充值接口<br>
	 * 真实地址：http://www.weizutec.top:28445/weizuAPI/charge.do
	 */
	public static final String CHARGE = "/charge";
	/**
	 * 下游主动查询接口<br>
	 * 真实地址：http://www.weizutec.top:28445/weizuAPI/my_order_state.do
	 */
	public static final String MY_ORDER_STATE = "/my_order_state";
	/**
	 * 下游查询产品列表接口<br>
	 * 真实地址：http://www.weizutec.top:28445/weizuAPI/my_pgproduct_list.do
	 */
	public static final String MY_PGPRODUCT_LIST = "/my_pgproduct_list";
}
