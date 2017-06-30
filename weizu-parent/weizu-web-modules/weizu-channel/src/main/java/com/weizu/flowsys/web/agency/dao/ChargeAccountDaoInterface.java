package com.weizu.flowsys.web.agency.dao;

import java.util.Map;

import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;

public interface ChargeAccountDaoInterface {
	/**
	 * @description:通过代理商id获得账户信息（包涵Id的简易账户信息）
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午11:40:01
	 */
	ChargeAccountPo selectByAgencyId(int agencyId, int billType);
	
	/**
	 * @description:通过agencyId更新账户信息
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午4:25:12
	 */
	int updateByAgencyId(ChargeAccountPo chargeAccountPo);
}
