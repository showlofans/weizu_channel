package com.weizu.flowsys.web.agency.dao.impl;

import java.util.List;

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
	public List<BankAccountPo> getBankList(Integer contextId) {
		return sqlSessionTemplateASS.selectList("getBankList", contextId);
	}

}
