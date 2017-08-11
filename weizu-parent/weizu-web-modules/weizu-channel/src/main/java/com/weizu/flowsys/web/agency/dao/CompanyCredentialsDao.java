package com.weizu.flowsys.web.agency.dao;

import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;
import com.weizu.web.foundation.core.dao.Dao;

public interface CompanyCredentialsDao extends Dao<CompanyCredentialsPo, Integer> {
	/**
	 * @description: 通过代理商id查看是否已经创建该认证
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月21日 下午3:07:09
	 */
	CompanyCredentialsPo checkCraatedByAgencyId(Integer agencyId);
}
