package com.weizu.flowsys.web.activity.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.activity.dao.AgencyActiveChannelDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRatePo;

@Repository(value="agencyActiveChannelDao")
public class AgencyActiveChannelDaoImpl extends DaoImpl<AgencyActiveRatePo, Long> implements
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
	public List<AgencyActiveRatePo> listActive(Map<String, Object> paramsMap) {
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
	public int countActive(AgencyActiveRatePo activePo) {
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
	public List<AgencyActiveRatePo> listActiveDiscount(
			Map<String, Object> paramsMap) {
		
		return sqlSessionTemplate.selectList("listActiveDiscount",paramsMap);
	}

	/**
	 * @description: 更新绑定状态
	 * @param activeId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午12:00:59
	 */
	@Override
	public int updateBindState(long activeId, int bindState) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("id", activeId);
		paramsMap.put("bindState", bindState);
		return sqlSessionTemplate.update("updateBindState", paramsMap);
	}

	/**
	 * @description: 查询分页费率列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午10:57:23
	 */
	@Override
	public List<AgencyActiveRatePo> listActiveRate(
			Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("listActiveRate", paramsMap);
	}

	/**
	 * @description: 查询费率记录数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午10:57:35
	 */
	@Override
	public Long countActiveRate(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectOne("countActiveRate", paramsMap);
	}

}
