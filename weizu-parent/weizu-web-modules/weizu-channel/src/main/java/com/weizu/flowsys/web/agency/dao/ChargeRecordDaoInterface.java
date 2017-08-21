package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;

public interface ChargeRecordDaoInterface extends Dao<ChargeRecordPo, Long> {
	
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
	
	/**
	 * @description: 查询消费列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 下午5:10:29
	 */
	List<ConsumeRecordPo> getConsume(Map<String, Object> paramsMap);
	
	/**
	 * @description: 获得消费记录总数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 下午5:11:01
	 */
	int countConsume(Map<String, Object> paramsMap);

	/**
	 * @description: 批量添加充值记录
	 * @param recordPoList
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月21日 上午9:50:23
	 */
	int crt_addList(List<ChargeRecordPo> recordPoList);
	
}
