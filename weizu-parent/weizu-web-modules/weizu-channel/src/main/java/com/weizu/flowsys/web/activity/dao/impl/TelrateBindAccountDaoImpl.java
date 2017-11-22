package com.weizu.flowsys.web.activity.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.activity.dao.ITelrateBindAccountDao;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountPo;

/**
 * @description:
 * @projectName:weizu-channel
 * @className:TelrateBindAccountDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午3:29:03
 * @version 1.0
 */
@Repository(value="telrateBindAccountDao")
public class TelrateBindAccountDaoImpl extends DaoImpl<TelrateBindAccountPo, Long> implements
		ITelrateBindAccountDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int batchInsert(List<TelrateBindAccountPo> tbapList) {
		
		return sqlSessionTemplate.insert("batchInsertTBA", tbapList);
	}
	
	
}
