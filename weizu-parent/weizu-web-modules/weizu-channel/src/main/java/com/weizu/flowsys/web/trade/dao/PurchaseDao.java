package com.weizu.flowsys.web.trade.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.pojo.TotalResult;

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
	int updatePurchaseState(PurchasePo purchasePo1);
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
	long countPurchase(Map<String,Object> paramsMap);
	
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
	
	/**
	 * @description: 查询代理商消费订单
	 * @param map
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午6:53:24
	 */
	PurchasePo getMyPurchase(int agnecyId,Long purchaseId);
	
	/**
	 * @description: 任意一个条件查询是否存在重复订单,需要有一个为空
	 * @param orderId
	 * @param orderIdApi
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月19日 下午4:16:30
	 */
	PurchasePo hasDoublePurchase(String orderId, String orderIdApi);
	
	/**
	 * @description: 查询统计信息
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月21日 下午5:24:33
	 */
	TotalResult getTotalResultFromSuccess(Map<String,Object> map);
	
	/**
	 * @description: 获得该号码最新的订单
	 * @param chargeTel
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月7日 下午1:41:48
	 */
	PurchasePo getLatestOneByTel(String chargeTel,Integer purchaseFor);
	
	/**
	 * @description:获得该号码是否在改时间之后有订单
	 * @param chargeTel
	 * @param purchaseFor
	 * @param highTime
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月29日 上午10:38:36
	 */
	PurchasePo getLatestOneByTel(String chargeTel,Integer purchaseFor, Long highTime);
	
}
