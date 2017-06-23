package com.weizu.flowsys.web.agency.ao;

import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;

/**
 * @description:账户管理业务
 * @projectName:crud
 * @className:ChargeAccountAo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月6日 上午10:43:48
 * @version 1.0
 */
public interface ChargeAccountAo {
	
	/**
	 * @description:创建一个账户
	 * @param chargeAccountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午10:43:09
	 */
	int createAccount(ChargeAccountPo chargeAccountPo);
	
	/**
	 * @description:更新账户
	 * @param chargeAccountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午10:43:21
	 */
	int updateAccount(ChargeAccountPo chargeAccountPo);
	
	/**
	 * @description:通过代理商id获得账户信息（包涵Id的简易账户信息）
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午11:09:48
	 */
	ChargeAccountPo getAccountByAgencyId(int agencyId);
	
	/**
	 * @description:删除账户
	 * @param chargeAccountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午10:43:40
	 */
//	int deleteAccount(ChargeAccountPo chargeAccountPo);

}
