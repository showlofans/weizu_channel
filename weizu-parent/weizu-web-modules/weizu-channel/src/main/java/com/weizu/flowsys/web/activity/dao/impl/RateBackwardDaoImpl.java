package com.weizu.flowsys.web.activity.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.activity.dao.IRateBackwardDao;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;

/**
 * @description:费率列表
 * @projectName:crud
 * @className:RateBackwardDaoImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月20日 下午2:58:33
 * @version 1.0
 */
@Repository(value="rateBackwardDao")
public class RateBackwardDaoImpl extends DaoImpl<RateBackwardPo, Long> implements
		IRateBackwardDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * @description:查询费率列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月20日 下午2:58:28
	 */
	@Override
	public List<RateBackwardPo> selectByPagePo(Map<String,Object> paramsMap) {
		
		return sqlSessionTemplate.selectList("selectByPagePo",paramsMap);
	}
	/**
	 * @description:根据条件查询总记录数
	 * @param rateBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月20日 下午3:09:02
	 */
	@Override
	public int countByPo(Map<String,Object> paramsMap) {
		return sqlSessionTemplate.selectOne("countByPo",paramsMap);
	}
	
	/** 
	 * @description: 查询代理商全部费率 
	 * @param rootAgencyId
	 * @param billType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月30日 上午11:58:36
	 */
	@Override
	public List<RateBackwardPo> selectByRootId(Integer rootAgencyId,Integer billType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rootAgencyId", rootAgencyId);
		if(billType != null){
			map.put("billType", billType);
		}
		return sqlSessionTemplate.selectList("selectByRootId",map);
	}

}
