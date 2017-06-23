package com.weizu.flowsys.web.trade.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

/**
 * @description: 订单管理
 * @projectName:crud
 * @className:PurchaseDaoImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月13日 上午10:55:13
 * @version 1.0
 */
@Repository(value="purchaseDAO")
public class PurchaseDaoImpl extends DaoImpl<PurchasePo, Long> implements PurchaseDao {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description: 添加订单
	 * @param po
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 上午10:55:03
	 */
	@Transactional
	@Override
	public int addPurchase(PurchasePo po) {
		return sqlSessionTemplate.insert("addPurchase", po);
	}

	/**
	 * @description:计算订单列表总数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:47:58
	 */
	@Override
	public int countPurchase(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectOne("countPurchase", paramsMap);
	}

	/**
	 * @description: 查询订单列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:48:16
	 */
	@Override
	public List<PurchaseVO> getPurchase(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("getPurchase", paramsMap);
	}

	/**
	 * @description: 更新订单状态
	 * @param purchaseParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月21日 下午3:14:35
	 */
	@Override
	public int updatePurchaseState(PurchaseStateParams purchaseParams) {
		return sqlSessionTemplate.update("updatePurState", purchaseParams);
	}

}
