package com.weizu.flowsys.web.activity.dao;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * @description: 批量更新话费折扣绑定状态（根据折扣id，批量解除绑定）
	 * @param telRateId
	 * @param bindState
	 * @param accountIds
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午6:04:14
	 */
	int batchUpdateBindTelState(long telRateId, int bindState, int[] accountIds);

	
	/**
	 * @description: 删除折扣（根据折扣id，批量解除绑定）
	 * @param telRateId
	 * @param bindState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月24日 上午10:49:40
	 */
	int batchUpdateBindTelState(long telRateId, int bindState);
	
	/**
	 * @description: 根据条件更新绑定状态
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月8日 下午2:59:19
	 */
	int updateBindState(Map<String,Object> params);
	
	
	
	
	
	/**
	 * @description: 批量添加话费折扣
	 * @param int
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午6:13:19
	 */
//	int batch_bindTelList(List<TelrateBindAccountPo> list);
	
}
