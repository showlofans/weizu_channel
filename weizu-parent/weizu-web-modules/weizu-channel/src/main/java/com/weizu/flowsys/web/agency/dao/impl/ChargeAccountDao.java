package com.weizu.flowsys.web.agency.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.AccountBalanceSumPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;

@Repository("chargeAccountDao")
public class ChargeAccountDao extends DaoImpl<ChargeAccountPo, Integer> implements ChargeAccountDaoInterface {

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
	public ChargeAccountPo selectByAgencyId(int agencyId, int billType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agencyId", agencyId);
		map.put("billType", billType);
		return sqlSessionTemplate.selectOne("selectByAgencyId", map);
	}
	
	@Override
	public ChargeAccountPo getRootAccountById(int id, int billType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("billType", billType);
		return sqlSessionTemplate.selectOne("getRootAccountById", map);
	}

	/**
	 * @description: 查询父级代理商的相关账户
	 * @param agencyId
	 * @param billType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月3日 下午2:48:33
	 */
//	@Override
//	public ChargeAccountPo selectRootAccountByAgencyId(int agencyId,
//			int billType) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("agencyId", agencyId);
//		map.put("billType", billType);
//		return sqlSessionTemplate.selectOne("selectRootAccountByAgencyId", map);
//	}
	
	/**
	 * @description:通过agencyId更新账户信息
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午4:26:09
	 */
	@Override
	public int updateById(Map<String, Object> map) {
		return sqlSessionTemplate.update("updateById", map);
	}

	@Override
	public ChargeAccountPo getAccountByTransferId(Long transferId,String type) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("bankType", type);
		map.put("fromBankId", "fromBankId");
		map.put("id", transferId);
		return sqlSessionTemplate.selectOne("getAccountByTransferId", map);
	}

	@Override
	public int updateAccountBalance(Double accountBalance, Integer accountId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("accountBalance", accountBalance);
		map.put("id", accountId);
		return sqlSessionTemplate.update("updateAccountBalance", map);
	}

	@Override
	public List<AccountBalanceSumPo> getBalanceSum(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("getBalanceSum", params);
	}

	


}
