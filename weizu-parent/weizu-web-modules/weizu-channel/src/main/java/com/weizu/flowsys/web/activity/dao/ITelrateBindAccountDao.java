package com.weizu.flowsys.web.activity.dao;

import java.util.List;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountPo;

/**
 * @description: 话费折扣和账户绑定Dao
 * @projectName:weizu-channel
 * @className:ITelrateBindAccountDao.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午3:27:54
 * @version 1.0
 */
public interface ITelrateBindAccountDao extends Dao<TelrateBindAccountPo, Long> {
	
	/**
	 * @description: 批量添加话费折扣绑定实体
	 * @param tbapList
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月16日 下午3:30:28
	 */
	public int batchInsert(List<TelrateBindAccountPo> tbapList);
	
}
