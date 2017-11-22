package com.weizu.flowsys.web.activity.dao;

import java.util.List;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;

/**
 * @description: 话费折扣Dao
 * @projectName:weizu-channel
 * @className:ITelRateDao.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午3:25:22
 * @version 1.0
 */
public interface ITelRateDao extends Dao<TelRatePo, Long> {

	/**
	 * @description: 通过通达oid和票务
	 * @param telchannelId
	 * @param billType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月16日 下午4:15:57
	 */
	List<TelRatePo> listByTelRatePo(TelRatePo telRatePo);
	
}
