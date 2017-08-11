package com.weizu.flowsys.web.trade.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.web.foundation.core.dao.Dao;

/**
 * @description:订单管理
 * @projectName:crud
 * @className:PurchaseDao.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月13日 上午10:52:59
 * @version 1.0
 */
public interface PurchaseDao extends Dao<PurchasePo, Long> {
	/**
	 * @description: 更新订单状态
	 * @param purchaseParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 上午10:52:50
	 */
	int updatePurchaseState(PurchaseStateParams purchaseParams);
	/**
	 * @description: 添加订单
	 * @param purchasePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 上午10:52:50
	 */
	int addPurchase(PurchasePo purchasePo);
	
	/**
	 * @description: 计算订单列表总数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:46:13
	 */
	int countPurchase(Map<String,Object> paramsMap);
	
	/**
	 * @description: 查询订单列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:47:09
	 */
	List<PurchaseVO> getPurchase(Map<String,Object> paramsMap);
	
	/**
	 * @description: 通过订单号查询订单
	 * @param orderId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午12:08:31
	 */
	PurchasePo getOnePurchase(Long orderId);

}
