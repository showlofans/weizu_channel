package com.weizu.flowsys.web.agency.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.agency.dao.CompanyCredentialsDao;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;

/**
 * @description: 对公账户认证实体
 * @projectName:weizu-channel
 * @className:CompanyCredentialsDaoImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月21日 下午3:02:42
 * @version 1.0
 */
@Repository(value="companyCredentialsDao")
public class CompanyCredentialsDaoImpl extends DaoImpl<CompanyCredentialsPo, Integer> implements CompanyCredentialsDao {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * @description: 通过代理商id查看是否已经创建该认证
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月21日 下午3:20:04
	 */
	@Override
	public CompanyCredentialsPo checkCraatedByAgencyId(Integer agencyId) {
		CompanyCredentialsPo ccpo = get(new WherePrams("agency_id", "=", agencyId));
		return ccpo;
	}
	

}
