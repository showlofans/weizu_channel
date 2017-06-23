package com.weizu.flowsys.web.agency.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.agency.dao.ChargeRecordDaoInterface;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;

@Repository("chargeRecordDao")
public class ChargeRecordDao extends DaoImpl<ChargeRecordPo, Integer> implements ChargeRecordDaoInterface {

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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("countRecord", paramsMap);
	}
	
}
