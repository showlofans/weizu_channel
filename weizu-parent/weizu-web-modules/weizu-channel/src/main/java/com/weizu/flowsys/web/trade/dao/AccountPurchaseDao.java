package com.weizu.flowsys.web.trade.dao;

import java.util.List;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;

/**
 * @description: 代理商订单绑定Dao接口
 * @projectName:weizu-channel
 * @className:AgencyPurchaseDao.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年8月2日 下午5:43:59
 * @version 1.0
 */
public interface AccountPurchaseDao extends Dao<AccountPurchasePo, Long> {
	/**
	 * @description: 批量添加
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 下午5:44:46
	 */
	int ap_addList(List<AccountPurchasePo> list);
	
	/**
	 * @description: 批量更新代理商订单状态（推送订单结果的时候）
	 * @param orderId
	 * @param state
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月3日 上午10:45:46
	 */
	int batchUpdateState(Long purchaseId, Integer orderResult, String orderResultDettail);
	
	/**
	 * @description:根据代理商和订单号获得订单的成本
	 * @param purchaseId
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月20日 上午10:41:37
	 */
//	Double getOrderAmount(Long purchaseId, Integer agencyId, Integer accountType);
	
	/**
	 * @description: 根据订单号和代理商账户id找到accountPurchase的补/扣款记录
	 * @param purchaseId
	 * @param accountId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月14日 下午12:15:44
	 */
	AccountPurchasePo getAPByAccountType(Long purchaseId,Integer accountId,Integer accountType);
}
