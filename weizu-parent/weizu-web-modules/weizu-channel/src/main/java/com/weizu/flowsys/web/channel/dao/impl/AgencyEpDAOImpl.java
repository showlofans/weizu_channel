package com.weizu.flowsys.web.channel.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.weizu.web.foundation.core.dao.impl.DaoImpl;

import com.weizu.flowsys.web.channel.dao.IAgencyEpDAO;
import com.weizu.flowsys.web.channel.pojo.AgencyEpPo;

/**
 * @description: 代理商平台连接DAO层接口实现类
 * @projectName:crud
 * @className:AgencyEpDAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 下午1:19:48
 * @version 1.0
 */
@Repository(value = "agencyEpDAO")
public class AgencyEpDAOImpl extends DaoImpl<AgencyEpPo, Long> implements IAgencyEpDAO {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description:通过代理商ID获得所有平台列表
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午1:19:21
	 */
	@Override
	public List<AgencyEpPo> getAgencyEpByAgencyId(int agencyId) {
		
		return sqlSessionTemplate.selectList("getAgencyEpByAgencyId", agencyId);
	}

}
