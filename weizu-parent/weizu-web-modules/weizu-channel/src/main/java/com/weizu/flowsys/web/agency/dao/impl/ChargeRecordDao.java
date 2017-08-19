package com.weizu.flowsys.web.agency.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.agency.dao.ChargeRecordDaoInterface;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;

@Repository("chargeRecordDao")
public class ChargeRecordDao extends DaoImpl<ChargeRecordPo, Long> implements ChargeRecordDaoInterface {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
	 * @description:查询充值列表 
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月9日 上午10:18:22
	 */
	@Override
	public List<ChargeRecordPo> listChargeRecord(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("selectChargeList", paramsMap);
	}


	/**
	 * @description:获得记录总数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月9日 上午11:04:03
	 */
	@Override
	public int countRecord(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectOne("countRecord", paramsMap);
	}


	/**
	 * @description: 查询消费列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 下午5:11:40
	 */
	@Override
	public List<ConsumeRecordPo> getConsume(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("getConsume", paramsMap);
	}


	/**
	 * @description: 获得消费记录总数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 下午5:11:54
	 */
	@Override
	public int countConsume(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectOne("countConsume", paramsMap);
	}
	
}
