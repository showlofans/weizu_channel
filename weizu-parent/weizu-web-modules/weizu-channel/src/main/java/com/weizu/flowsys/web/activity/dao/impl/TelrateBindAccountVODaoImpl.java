package com.weizu.flowsys.web.activity.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.activity.dao.ITelrateBindAccountVODao;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;

@Repository(value="telrateBindAccountVODao")
public class TelrateBindAccountVODaoImpl extends DaoImpl<TelrateBindAccountVO, Long> implements ITelrateBindAccountVODao {

//	@Resource
//	private SqlSessionTemplate sqlSessionTemplate;

//	@Override
//	public int batchInsert(List<TelrateBindAccountVO> tbapList) {
//		
//		return sqlSessionTemplate.insert("batchInsertTBA", tbapList);
//	}

}
