package com.weizu.flowsys.web.channel.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscount;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
import com.weizu.flowsys.web.activity.pojo.ScopeDiscount;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
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

	@Override
	public int countDiscount(Map<String, Object> paramsMap) {
		
		return sqlSessionTemplate.selectOne("countDiscount", paramsMap);
	}

	/**
	 * @description: 查看折扣列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月10日 下午12:06:26
	 */
	@Override
	public List<ChannelDiscountPo> getDiscountList(Map<String, Object> paramsMap) {
		
		return sqlSessionTemplate.selectList("getDiscountList", paramsMap);
	}
	
	/**
	 * @description:查询简易通道信息
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午3:54:28
	 */
	@Override
	public List<ChannelDiscountPo> listSimpleChannel(Map<String,Object> paramsMap) {
		
		return sqlSessionTemplate.selectList("listSimpleChannel",paramsMap);
	}

}
