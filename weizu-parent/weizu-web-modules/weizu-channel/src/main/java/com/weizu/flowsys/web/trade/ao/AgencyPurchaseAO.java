package com.weizu.flowsys.web.trade.ao;

public interface AgencyPurchaseAO {
	/**
	 * @description: 向下推送订单结果
	 * @param orderId
	 * @param orderResult
	 * @param orderResultDetail
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月21日 下午4:11:21
	 */
	String updatePurchaseState(Long orderId,Integer orderResult, String orderResultDetail);
}
