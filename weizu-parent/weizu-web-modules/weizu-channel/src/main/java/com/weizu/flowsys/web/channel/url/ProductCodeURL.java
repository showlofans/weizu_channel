package com.weizu.flowsys.web.channel.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description:产品编码管理-URL管理
 * @projectName:crud
 * @className:ProductCodeURL.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 下午12:17:48
 * @version 1.0
 */
public class ProductCodeURL extends BaseURL{
	/**
	 * 产品编码controller模块
	 */
	public static final String MODOE_NAME = "/flowsys/productCode";
	/**
	 * 产品编码列表
	 */
	public static final String PRODUCT_CODE_LIST = "/product_code_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 添加产品编码
	 */
	public static final String PRODUCT_CODE_ADD = "/product_code_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 添加产品编码页面
	 */
	public static final String PRODUCTCODE_ADD_PAGE = "/productCode_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 初始化包体列表
	 */
	public static final String AJAX_PG_LIST = "/productCode_add_page/ajax_pg_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 验证通道下是否存在一样的编码
	 */
	public static final String PRODUCT_CODE_EXIST = "/product_code_exist" + DYNAMIC_WEB_SUFFIX;
}
