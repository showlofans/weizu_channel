package com.weizu.flowsys.web.agency.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;

@Repository(value="bankAccountDao")
public class BankAccountDao extends DaoImpl<BankAccountPo, Long> implements
		BankAccountDaoInterface {
	@Resource
	private SqlSessionTemplate sqlSessionTemplateASS;

	@Override
	public List<BankAccountPo> getMyBankList(Map<String, Object> paramsMap) {
		return sqlSessionTemplateASS.selectList("getMyBankList", paramsMap);
	}

	@Override
	public List<BankAccountPo> getAttachBankList(Map<String, Object> paramsMap) {
		return sqlSessionTemplateASS.selectList("getAttachBankList", paramsMap);
	}

	@Override
	public BankAccountPo getMyOneBankAccount(Integer toAgencyId,
			String remmitanceBankAccount, Integer inUseState) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("agencyId", toAgencyId);
		map.put("inUseState", inUseState);
		map.put("remmitanceBankAccount", remmitanceBankAccount);
		return sqlSessionTemplateASS.selectOne("getMyOneBankAccount", map);
	}

}
