package com.weizu.flowsys.web.activity.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

public class RateDiscountDaoImpl extends DaoImpl<RateDiscountPo, Long> implements
		RateDiscountDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description: 批量添加费率折扣
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午5:43:20
	 */
	@Override
	public int rate_addList(List<RateDiscountPo> list) {
		return sqlSessionTemplate.insert("rate_addList", list);
	}

	

}