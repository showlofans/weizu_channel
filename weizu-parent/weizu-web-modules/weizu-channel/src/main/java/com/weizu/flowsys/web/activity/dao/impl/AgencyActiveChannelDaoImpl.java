package com.weizu.flowsys.web.activity.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.activity.dao.AgencyActiveChannelDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;

@Repository(value="agencyActiveChannelDao")
public class AgencyActiveChannelDaoImpl extends DaoImpl<AgencyActiveChannelPo, Long> implements
		AgencyActiveChannelDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description: 查询代理商参与的活动通道
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:09:51
	 */
	@Override
	public List<AgencyActiveChannelPo> listActive(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("listActive",paramsMap);
	}

	/**
	 * @description: 根据参数获得总记录数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:12:04
	 */
	@Override
	public int countActive(AgencyActiveChannelPo activePo) {
		return sqlSessionTemplate.selectOne("countActive", activePo);
	}

	/**
	 * @description: 查询代理商参与的活动通道(不分页)
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 下午7:09:00
	 */
	@Override
	public List<AgencyActiveChannelPo> listActiveDiscount(
			Map<String, Object> paramsMap) {
		
		return sqlSessionTemplate.selectList("listActiveDiscount",paramsMap);
	}
	
	
}
