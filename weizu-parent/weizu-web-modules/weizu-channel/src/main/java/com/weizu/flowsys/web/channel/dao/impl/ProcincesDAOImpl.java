package com.weizu.flowsys.web.channel.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.channel.dao.IProcincesDAO;
import com.weizu.flowsys.web.channel.pojo.Provinces;

@Service("procincesDAO")
public class ProcincesDAOImpl extends DaoImpl<Provinces, Integer> implements IProcincesDAO {

	@Resource
	private SqlSessionTemplate sqlSessionTemplateASS;
	
	@Override
	public List<Provinces> getProvinces() {
		return sqlSessionTemplateASS.selectList("getProvinces");
	}

}
