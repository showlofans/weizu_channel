package com.weizu.flowsys.web.trade.url;

import com.weizu.flowsys.web.base.BaseURL;

/**
 * @description: 微信小程序数据接口
 * @projectName:weizu-channel
 * @className:WeChatURL.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月15日 下午2:41:03
 * @version 1.0
 */
public class WeChatURL extends BaseURL {
	/**
	 * 小程序模块
	 */
	public static final String MODEL_NAME="/flowsys/wechat";
	
	/**
	 * 小程序首页初始化数据
	 * <br>/flowsys/wechat/init_first_page.do
	 */
	public static final String INIT_FIRST_PAGE = "/init_first_page" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 根据归属地和业务类型获得小程序可以充值的包体
	 * <br>/flowsys/wechat/getpg_for_purchase.do
	 */
	public static final String GETPG_FOR_PURCHASE = "/getpg_for_purchase" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 生成订单，根据参数调用微信接口获得预支付id
	 * <br>/flowsys/wechat/getPrepayId.do
	 */
	public static final String GETPREPAYID = "/getPrepayId" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 支付成功后的服务器回调url
	 * <br>/flowsys/wechat/wxNotify.do
	 */
	public static final String WXNOTIFY = "/wxNotify" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 订单失败退款
	 * <br>/flowsys/wechat/failByMe.do
	 */
	public static final String FAILBYME = "/failByMe" + DYNAMIC_WEB_SUFFIX;
	
	
	
	
}
