package com.weizu.flowsys.web.channel.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;

@Repository(value="channelDiscountDao")
public class ChannelDiscountDaoImpl extends DaoImpl<ChannelDiscountPo, Integer> implements
		ChannelDiscountDao {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description: 批量添加通道折扣
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月4日 下午4:43:35
	 */
	@Override
	public int discount_addList(List<ChannelDiscountPo> list) {
		
		return sqlSessionTemplate.insert("discount_addList", list);
	}


}
