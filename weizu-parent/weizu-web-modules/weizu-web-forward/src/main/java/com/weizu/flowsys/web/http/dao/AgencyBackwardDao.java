package com.weizu.flowsys.web.http.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.weizu.web.foundation.core.dao.impl.DaoImpl;

import com.weizu.flowsys.web.http.pojo.AgencyBackwardPo;

/**
 * @description:代理商DAO层实现类
 * @projectName:crud
 * @className:AgencyBackwardDao.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月25日 下午12:44:25
 * @version 1.0
 */
@Repository("agencyBackwardDao")
public class AgencyBackwardDao extends DaoImpl<AgencyBackwardPo, Integer> implements AgengcyBackwardDaoInterface {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplateASS;
	
}