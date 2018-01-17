package com.weizu.flowsys.web.trade.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;

public interface ChargeLogDao extends Dao<ChargeLog, Long> {
	
	Long countChargeLog(Map<String,Object> params);
	
	/**
	 * @description: 查询接口冲单日志列表
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月13日 下午1:59:17
	 */
	List<ChargeLog> listChargeLog(Map<String,Object> params);
	
	/**
	 * @description: 根据条件删除日志信息
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月13日 下午4:14:05
	 */
	int delChargeLog(Map<String,Object> params);
}
