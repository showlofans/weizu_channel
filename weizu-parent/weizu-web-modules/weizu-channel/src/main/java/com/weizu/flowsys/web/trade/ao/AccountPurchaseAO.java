package com.weizu.flowsys.web.trade.ao;

import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

public interface AccountPurchaseAO {
	/**
	 * @description: 上游推送订单结果
	 * @param orderId
	 * @param orderResult
	 * @param orderResultDetail
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月21日 下午4:11:21
	 */
	String updatePurchaseState(PurchasePo purchasePo);
	
	/**
	 * @description: 批量推送(更新)订单状态
	 * @param purchaseVO 查询参数
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月7日 下午4:40:31
	 */
//	String batchUpdatePurchaseState(PurchaseVO purchaseVO);
	/**
	 * @description:回调的时候，更新状态:成功返成功，失败返等待
	 * @param orderId 
	 * @param orderResult
	 * @param orderResultDetail
	 * @param realBackTime
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月16日 下午4:30:28
	 */
//	String updatePurchaseStateByApi(String orderIdApi, Long orderId,Integer orderResult, String orderResultDetail, Long realBackTime);
	
	/**
	 * @description: 手动推送结果
	 * @param orderId
	 * @param orderResult
	 * @param orderResultDetail
	 * @param realBackTime
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月28日 下午5:04:16
	 */
	String updatePurchaseStateByMe(Long orderId,Integer orderResult, String orderResultDetail, Long realBackTime);
	
	/**
	 * @description: 手动退款
	 * @param orderId
	 * @param orderResult
	 * @param orderResultDetail
	 * @param realBackTime
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月5日 上午9:18:20
	 */
	String refund(Long orderId,Integer orderResult, String orderResultDetail, Long realBackTime);
	
}
