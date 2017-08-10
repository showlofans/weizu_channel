package com.weizu.flowsys.web.trade.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.weizu.web.foundation.core.beans.WherePrams;
import org.weizu.web.foundation.core.dao.impl.DaoImpl;

import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;

/**
 * @description: 代理商订单绑定Dao接口实现类
 * @projectName:weizu-channel
 * @className:AgencyPurchaseDaoImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年8月2日 下午5:46:08
 * @version 1.0
 */
@Repository(value="agencyPurchaseDao")
public class AgencyPurchaseDaoImpl extends DaoImpl<AgencyPurchasePo, Long> implements
		AgencyPurchaseDao {

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
	public int ap_addList(List<AgencyPurchasePo> list) {
		
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
	public int batchUpdateState(Long purchaseId, Integer orderResult, String orderResultDettail) {
		AgencyPurchasePo apPo = new AgencyPurchasePo();
		apPo.setOrderResult(orderResult);
		apPo.setOrderResultDetail(orderResultDettail);
		//apPo.setOrderBackTimeStr(DateUtil.formatAll(System.currentTimeMillis()));
		apPo.setOrderBackTime(System.currentTimeMillis());
		return updateLocal(apPo, new WherePrams("purchase_id", "=", purchaseId));
	}

}
