package com.weizu.flowsys.web.activity.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.weizu.flowsys.web.activity.dao.IOperatorDiscountDao;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
import com.weizu.web.foundation.core.dao.impl.DaoImpl;

/**
 * @description:费率dao层
 * @projectName:crud
 * @className:OperatorDiscountDaoImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月18日 下午4:32:51
 * @version 1.0
 */
@Repository(value="operatorDiscountDao")
public class OperatorDiscountDaoImpl extends DaoImpl<OperatorDiscountPo, Long> implements
		IOperatorDiscountDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * @description:批量添加费率
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 下午4:32:40
	 */
	@Transactional
	@Override
	public int disccount_addList(List<OperatorDiscountPo> list) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setId(nextId());
		}
		return sqlSessionTemplate.insert("disccount_addList", list);
	}
	/**
	 * @description:通过登录用户id查询费率列表
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:07:05
	 */
//	@Override
//	public List<OperatorDiscountPo> selectByAgencyId(Integer rootAgencyId) {
//		
//		return sqlSessionTemplate.selectList("disccount_addList", rootAgencyId);
//	}
	/**
	 * @description:查询登录用户是否有该费率名称(添加费率时)
	 * @param rateName
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:09:57
	 */
	@Override
	public int checkRateName(String rateName, Integer rootAgencyId) {
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("rateName", rateName);
		paramsMap.put("rootAgencyId", rootAgencyId);
		return sqlSessionTemplate.selectOne("checkRateName", paramsMap);
	}
	/**
	 * @description:通过登录用户id查询费率列表总数
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:43:48
	 */
	@Override
	public int countByAgencyId(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectOne("countByAgencyId", paramsMap);
	}
	/**
	 * @description:通过条件查询费率列表
	 * @param operatorDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 下午1:01:28
	 */
	@Override
	public List<OperatorDiscountPo> selectDiscountByPo(
			OperatorDiscountPo operatorDiscountPo) {
		
		return sqlSessionTemplate.selectList("selectDiscountByPo", operatorDiscountPo);
	}
	/**
	 * @description:通过部分查询整体
	 * @param operatorDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月24日 下午4:14:49
	 */
	@Override
	public OperatorDiscountPo selectOneDiscountByPo(
			OperatorDiscountPo operatorDiscountPo) {
		
		return sqlSessionTemplate.selectOne("selectOneDiscountByPo", operatorDiscountPo);
	}

}
