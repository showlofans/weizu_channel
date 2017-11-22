package com.weizu.flowsys.web.channel.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.channel.dao.ITelProductDao;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;

@Repository("telProductDao")
public class TelProductDaoImpl extends DaoImpl<TelProductPo, Long> implements ITelProductDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<TelProductPo> getTelProduct(Map<String, Object> params) {
		
		return sqlSessionTemplate.selectList("getTelProduct", params);
	}

	@Override
	public Long countTelPro(Map<String, Object> params) {
		
		return sqlSessionTemplate.selectOne("countTelPro", params);
	}

	

}
