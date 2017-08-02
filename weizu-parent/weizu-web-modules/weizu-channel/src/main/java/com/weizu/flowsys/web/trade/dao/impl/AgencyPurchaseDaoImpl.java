package com.weizu.flowsys.web.trade.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
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
public class AgencyPurchaseDaoImpl extends DaoImpl<AgencyPurchasePo, Long> implements
		AgencyPurchaseDao {

	/**
	 * @description: 批量添加
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 下午5:46:18
	 */
	@Override
	public int ap_addList(List<AgencyPurchasePo> list) {
		
		return 0;
	}

}
