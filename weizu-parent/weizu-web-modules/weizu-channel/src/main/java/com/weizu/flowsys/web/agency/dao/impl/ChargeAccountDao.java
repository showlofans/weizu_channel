package com.weizu.flowsys.web.agency.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;

@Repository("chargeAccountDao")
public class ChargeAccountDao extends DaoImpl<ChargeAccountPo, Long> implements ChargeAccountDaoInterface {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description:通过代理商id获得账户信息（包涵Id的简易账户信息）
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月8日 上午9:44:24
	 */
	@Override
	public ChargeAccountPo selectByAgencyId(int agencyId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectByAgencyId", agencyId);
	}

	/**
	 * @description:通过agencyId更新账户信息
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午4:26:09
	 */
	@Override
	public int updateByAgencyId(ChargeAccountPo chargeAccountPo) {
		return sqlSessionTemplate.update("updateByAgencyId", chargeAccountPo);
	}

}
