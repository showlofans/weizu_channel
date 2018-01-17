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
	 * 流量包购买列表(超管)
	 */
	public static final String PGLIST_SUPER_FORPURCHASE = "/pgList_super_forPurchase" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 流量包购买页面
	 */
	public static final String PG_CHARGE_PAGE = "/pg_charge_page" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 流量包批量购买页面
	 */
	public static final String PG_BATCH_CHARGE_PAGE = "/pg_batch_charge_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 电话号码通过文本批量导入
	 */
	public static final String TEL_BATCH_IMPORT_TXT = "/tel_batch_import_txt" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 流量包批量购买
	 */
	public static final String PG_BATCH_CHARGE = "/pg_batch_charge" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 查询订单列表
	 */
	public static final String PURCHASE_LIST = "/purchase_list" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 查询订单流向的平台
	 * <br>/flowsys/chargePg/ep_in_purchase.do
	 */
	public static final String EP_IN_PURCHASE = "/ep_in_purchase" + DYNAMIC_WEB_SUFFIX;
	
	
	/**
	 * 查询成功订单列表
	 */
	public static final String PURCHASE_SUCCESS_LIST = "/purchase_success_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 更新订单状态
	 */
	public static final String UPDATE_PURCHASE_STATE = "/update_purchase_state" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 获得充值通道
	 */
	public static final String AJAX_CHARGE_CHANNEL = "/ajax_charge_channel" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 获得通道充值包体
	 */
	public static final String AJAX_CHARGE_PG = "/ajax_charge_pg" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 充值等待异步提交订单
	 */
	public static final String AJAX_COMMIT_ORDER = "/ajax_commit_order" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 充值等待批量提交订单
	 */
	public static final String BATCH_COMMIT_ORDER = "/batch_commit_order" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 导出充值成功订单
	 * <br>/flowsys/chargePg/export_charged_list.do
	 */
	public static final String EXPORT_CHARGED_LIST = "/export_charged_list" + DYNAMIC_WEB_SUFFIX;
	
	/**
	 * 批量推送结果
	 */
	public static final String BATCH_PUSH_ORDER = "/batch_push_order" + DYNAMIC_WEB_SUFFIX;
	
	
	
	
}
