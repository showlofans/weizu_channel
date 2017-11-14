package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;

/**
 * @description: 话费编码接口
 * @projectName:weizu-channel
 * @className:ITelProductDao.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月11日 下午3:12:45
 * @version 1.0
 */
public interface ITelProductDao extends Dao<TelProductPo, Long> {
	
	/**
	 * @description:获得分页列表
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月13日 下午5:28:03
	 */
	List<TelProductPo>getTelProduct(Map<String,Object> params);
	
	/**
	 * @description: 获得话费列表总记录数
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月13日 下午5:28:42
	 */
	Long countTelPro(Map<String,Object> params);
	
}
