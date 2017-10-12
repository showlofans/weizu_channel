package com.weizu.flowsys.web.agency.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.agency.dao.ITransferRecDao;
import com.weizu.flowsys.web.agency.pojo.TransferRecordPo;
import com.weizu.flowsys.web.agency.pojo.TransferRecordVO;

@Repository(value="transferRecDao")
public class TransferRecDaoImpl extends DaoImpl<TransferRecordPo, Long> implements ITransferRecDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<TransferRecordVO> getInOutRecord(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("getInOutRecord", params);
	}

	@Override
	public Long countInOutRecord(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("countInOutRecord", params);
	}

	
}
