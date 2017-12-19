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
import com.weizu.flowsys.web.agency.pojo.TransferMsgVo;

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

	@Override
	public List<TransferMsgVo> getTransferMsg(Integer toAgencyId,Integer confirmState) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("toAgencyId", toAgencyId);
		params.put("confirmState", confirmState);
		return sqlSessionTemplateASS.selectList("getTransferMsg", params);
	}

	@Override
	public int changePolarity(Integer agencyId,Integer billType, Integer originalPolarity,
			Integer newPolarity, Integer inUseState) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("agencyId", agencyId);
		params.put("billType", billType);
		params.put("inUseState", inUseState);
		params.put("originalPolarity", originalPolarity);
		params.put("newPolarity", newPolarity);
		return sqlSessionTemplateASS.update("changeToNew", params);
	}

	@Override
	public int changePolarity(Map<String,Object> params) {
		return sqlSessionTemplateASS.update("changeToOrinianl", params);
	}

	@Override
	public List<BankAccountPo> getOriginalBankA(Map<String, Object> paramsMap) {
		return sqlSessionTemplateASS.selectList("getOriginalBankA", paramsMap);
	}
	

//	@Override
//	public int delBank(String remmitanceBankAccount, Integer agencyId) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
