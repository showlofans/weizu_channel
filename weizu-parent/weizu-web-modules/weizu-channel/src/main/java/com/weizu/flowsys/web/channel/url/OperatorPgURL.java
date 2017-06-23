package com.weizu.flowsys.web.channel.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description:流量包管理-URL管理
 * @projectName:crud
 * @className:OperatorPgURL.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月5日 上午11:05:15
 * @version 1.0
 */
public class OperatorPgURL extends BaseURL {
	/**
	 * 流量包controller模块
	 */
	public static final String MODOE_NAME = "/flowsys/operatorPg";
	/**
	 * 流量包列表
	 */
	public static final String OPERATORPG_LIST = "/operatorPg_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 跳转到流量包添加页面
	 */
	public static final String PG_ADD_PAGE = "/pg_add_page" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 流量包添加
	 */
	public static final String PG_ADD = "/pg_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 流量包删除
	 */
	public static final String PG_DELETE = "/pg_delete" + DYNAMIC_WEB_SUFFIX;
}
