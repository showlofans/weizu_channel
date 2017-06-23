package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;

public interface ChargeRecordDaoInterface {
	
	/**
	 * @description:查询充值列表 
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月9日 上午10:17:23
	 */
	List<ChargeRecordPo> listChargeRecord(Map<String, Object> paramsMap);
	
	/**
	 * @description:获得记录总数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月9日 上午11:03:44
	 */
	int countRecord(Map<String, Object> paramsMap);
}
