package com.weizu.flowsys.web.channel.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.web.channel.dao.ICnelBindPgDao;
import com.weizu.flowsys.web.channel.pojo.CnelBindPgPo;
@Repository(value="cnelBindPgDao")
public class ICnelBindPgDaoImpl implements ICnelBindPgDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int batchAddBind(List<CnelBindPgPo> list) {
		return sqlSessionTemplate.insert("batchAddBind",list);
	}

}
