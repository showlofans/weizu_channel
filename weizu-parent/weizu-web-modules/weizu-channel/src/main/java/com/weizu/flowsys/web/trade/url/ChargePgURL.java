package com.weizu.flowsys.web.trade.url;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.web.base.BaseURL;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;

/**
 * @description:流量充值管理
 * @projectName:crud
 * @className:ChargePgURL.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月3日 上午11:15:46
 * @version 1.0
 */
public class ChargePgURL extends BaseURL {
	/**
	 * 流量充值模块
	 */
	public static final String MODEL_NAME="/flowsys/chargePg";
	
	/**
	 * 流量充值
	 */
	public static final String PG_CHARGE = "/pg_charge" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 获得流量充值的采购金额
	 */
	public static final String AJAX_PURCHASE_PRICE = "/ajax_purchase_price" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 获得流量充值所需的数据
	 */
	public static final String AJAX_PURCHASE_PG = "/ajax_purchase_pg" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 流量包购买列表
	 */
	public static final String PGLIST_FORPURCHASE = "/pgList_forPurchase" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 流量包购买页面
	 */
	public static final String PG_CHARGE_PAGE = "/pg_charge_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 查询订单列表
	 */
	public static final String PURCHASE_LIST = "/purchase_list" + DYNAMIC_WEB_SUFFIX;
	
}
