package com.weizu.flowsys.web.channel.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 话费编码地址
 * @projectName:weizu-product
 * @className:TelproductURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月10日 下午4:38:50
 * @version 1.0
 */
public class TelProductURL extends BaseURL {
	
	/**
	 * 话费通道controller模块
	 */
	public static final String MODOE_NAME = "/flowsys/tel_product";
	
	/**
	 * 话费通道添加页面
	 * <br> /flowsys/tel_product/telproduct_add_page.do
	 */
	public static final String TELPRODUCT_ADD_PAGE = "/telproduct_add_page" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 话费通道添加
	 * <br> /flowsys/tel_product/telproduct_add.do
	 */
	public static final String TELPRODUCT_ADD = "/telproduct_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 验证该编码是否存在
	 * <br>/flowsys/tel_product/telproduct_exist.do
	 */
//	public static final String TELPRODUCT_EXIST = "/telproduct_exist" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 异步获得编码有编码的话费列表
	 * <br>/flowsys/tel_product/ajax_get_code.do
	 */
	public static final String AJAX_GET_CODE = "/ajax_get_code" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 话费编码列表
	 * <br>/flowsys/tel_product/telproduct_list.do
	 */
	public static final String TELPRODUCT_LIST = "/telproduct_list" + DYNAMIC_WEB_SUFFIX;
	
	
}
