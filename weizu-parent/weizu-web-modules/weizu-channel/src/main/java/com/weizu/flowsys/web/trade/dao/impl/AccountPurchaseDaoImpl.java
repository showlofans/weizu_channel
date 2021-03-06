package com.weizu.flowsys.web.trade.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.web.trade.dao.AccountPurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;
import com.weizu.web.foundation.hash.Hash;

/**
 * @description: 代理商订单绑定Dao接口实现类
 * @projectName:weizu-channel
 * @className:AgencyPurchaseDaoImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年8月2日 下午5:46:08
 * @version 1.0
 */
@Repository(value="accountPurchaseDao")
public class AccountPurchaseDaoImpl extends DaoImpl<AccountPurchasePo, Long> implements
		AccountPurchaseDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * @description: 批量添加
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 下午5:46:18
	 */
	@Override
	public int ap_addList(List<AccountPurchasePo> list) {
		
		return sqlSessionTemplate.insert("ap_addList", list);
	}

	/**
	 * @description: 批量更新代理商订单状态（推送订单结果的时候）
	 * @param purchaseId
	 * @param orderResult
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月3日 上午10:47:25
	 */
	@Override
	public int batchUpdateState(Long purchaseId, Integer orderState, String orderStateDetail) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderState", orderState);
		params.put("orderStateDetail", orderStateDetail);
		params.put("purchaseId", purchaseId);
		//apPo.setOrderBackTimeStr(DateUtil.formatAll(System.currentTimeMillis()));
//		apPo.setOrderBackTime(System.currentTimeMillis());
		return sqlSessionTemplate.update("batchUpdateState", params);
	}
	/**
	 * @description: 批量更新代理商订单状态（推送订单结果的时候）
	 * @param purchaseId
	 * @param orderResult
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月3日 上午10:47:25
	 */
	@Override
	public int batchUpdateState(List<Long> orderIds, Integer orderState, String orderStateDetail) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderState", orderState);
		params.put("orderStateDetail", orderStateDetail);
		params.put("orderIds", orderIds);
		//apPo.setOrderBackTimeStr(DateUtil.formatAll(System.currentTimeMillis()));
//		apPo.setOrderBackTime(System.currentTimeMillis());
		return sqlSessionTemplate.update("batchUpdateState", params);
	}

//	@Override
//	public Double getOrderAmount(Long purchaseId, Integer accountId,Integer) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("purchaseId", purchaseId);
//		params.put("accountId", accountId);
//		return sqlSessionTemplate.selectOne("getOrderAmount", params);
//	}

	@Override
	public AccountPurchasePo getAPByAccountType(Long purchaseId, Integer accountId,Integer accountType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("purchaseId", purchaseId);
		params.put("accountId", accountId);
		params.put("accountType", accountType);
		return sqlSessionTemplate.selectOne("getAPByAccountType", params);
	}

	@Override
	public List<AccountPurchasePo> selectByOrderIds(List<Long> orderIds) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderIds", orderIds);
		params.put("accountType", AccountTypeEnum.DECREASE.getValue());
		return sqlSessionTemplate.selectList("selectByOrderIds",params);
	}

	@Override
	public List<AccountPurchasePo> selectByOrderId(Long orderId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("accountType", AccountTypeEnum.DECREASE.getValue());
		return sqlSessionTemplate.selectList("selectByOrderIds",params);
	}

}
