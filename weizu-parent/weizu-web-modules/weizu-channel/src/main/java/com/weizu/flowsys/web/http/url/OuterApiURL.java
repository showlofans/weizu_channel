package com.weizu.flowsys.web.http.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 拼多多接口对外访问地址
 * @projectName:weizu-channel
 * @className:OuterApiURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年4月2日 上午10:54:44
 * @version 1.0
 */
public class OuterApiURL extends BaseURL {
	/**
	 * 对外接口模块
	 */
	public static final String MODOE_NAME = "/flowsys/weizuAPI";
	/**
	 * 下游余额查询接口<br>
	 * 真实地址：http://www.91weizu.cn/weizuAPI/my_balance.do
	 */
	public static final String MY_BALANCE = "/my_balance";
	/**
	 * 下游话费余额查询接口<br>
	 * 真实地址：http://www.91weizu.cn/weizuAPI/mytel_balance.do
	 */
//	public static final String MYTEL_BALANCE = "/mytel_balance";
	/**
	 * 下游充值接口<br>
	 * 真实地址：http://www.91weizu.cn/weizuAPI/charge.do
	 */
	public static final String CHARGE = "/charge";
	/**
	 * 下游充值接口<br>
	 * 真实地址：http://www.91weizu.cn/weizuAPI/charge_tel.do
	 */
	public static final String CHARGE_TEL = "/charge_tel";
	/**
	 * 下游主动查询接口<br>
	 * 真实地址：http://www.91weizu.cn/weizuAPI/my_order_state.do
	 */
	public static final String MY_ORDER_STATE = "/my_order_states";
	/**
	 * 下游话费主动查询接口<br>
	 * 真实地址：http://www.91weizu.cn/weizuAPI/mytel_order_states.do
	 */
//	public static final String MYTEL_ORDER_STATES = "/mytel_order_states";
	/**
	 * 下游查询产品列表接口<br>
	 * 真实地址：http://www.91weizu.cn/weizuAPI/my_pgproduct_list.do
	 */
	public static final String MY_PGPRODUCT_LIST = "/my_pgproduct_list";
}
