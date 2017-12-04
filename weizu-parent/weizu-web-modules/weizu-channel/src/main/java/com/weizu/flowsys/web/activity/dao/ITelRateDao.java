package com.weizu.flowsys.web.activity.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.trade.pojo.GetTelRatePo;

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
	
	/**
	 * @description: : 异步获得的价格折扣信息
	 * @param map
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月1日 下午4:56:18
	 */
	List<GetTelRatePo> getTelRateForCharge(Map<String,Object> map);
	
	/**
	 * @description: 通过接口费率折扣得到，相应话费通道的平台折扣
	 * @param telRateId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月4日 下午4:59:20
	 */
	TelRatePo getPlatTelRateById(Long telRateId);
	
	
	
}
