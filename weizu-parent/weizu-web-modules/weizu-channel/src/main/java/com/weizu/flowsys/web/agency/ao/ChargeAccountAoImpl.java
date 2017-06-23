package com.weizu.flowsys.web.agency.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;

@Service("chargeAccountAO")
public class ChargeAccountAoImpl implements ChargeAccountAo {

	@Resource
	private ChargeAccountDao chargeAccountDao;
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int createAccount(ChargeAccountPo chargeAccountPo) {
		return chargeAccountDao.add(chargeAccountPo);
	}

	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int updateAccount(ChargeAccountPo chargeAccountPo) {

		return chargeAccountDao.updateByAgencyId(chargeAccountPo);
	}

	/**
	 * @description:通过代理商id获得账户信息（包涵Id的简易账户信息）
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月8日 上午9:43:55
	 */
	@Override
	public ChargeAccountPo getAccountByAgencyId(int agencyId) {
		
		return chargeAccountDao.selectByAgencyId(agencyId);
	}


}
