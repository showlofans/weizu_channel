package com.weizu.flowsys.web.trade.dao;

import java.util.List;

import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;
import com.weizu.web.foundation.core.dao.Dao;

/**
 * @description: 代理商订单绑定Dao接口
 * @projectName:weizu-channel
 * @className:AgencyPurchaseDao.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年8月2日 下午5:43:59
 * @version 1.0
 */
public interface AgencyPurchaseDao extends Dao<AgencyPurchasePo, Long> {
	/**
	 * @description: 批量添加
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 下午5:44:46
	 */
	int ap_addList(List<AgencyPurchasePo> list);
	
	/**
	 * @description: 批量更新代理商订单状态（推送订单结果的时候）
	 * @param orderId
	 * @param state
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月3日 上午10:45:46
	 */
	int batchUpdateState(Long purchaseId, Integer orderResult, String orderResultDettail);
}
