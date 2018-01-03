package com.weizu.flowsys.web.agency.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.agency.dao.CompanyReferenceDao;
import com.weizu.flowsys.web.agency.pojo.CompanyReferencePo;

/**
 * @description: 客户基本信息Dao层
 * @projectName:weizu-channel
 * @className:CompanyReferenceDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月3日 下午2:16:54
 * @version 1.0
 */
@Repository(value="companyReferenceDao")
public class CompanyReferenceDaoImpl extends DaoImpl<CompanyReferencePo, Integer> implements
		CompanyReferenceDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<CompanyReferencePo> listCRM(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("listCRM", params);
	}

	@Override
	public int countCRM(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("countCRM", params);
	}

}
