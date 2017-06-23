package com.weizu.flowsys.web.channel.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.channel.dao.ChannelForwardDaoInterface;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;

@Repository(value="channelForwardDao")
public class ChannelForwardDao extends DaoImpl<ChannelForwardPo, Integer> implements
		ChannelForwardDaoInterface {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * @description:批量添加通道
	 * @param list
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 上午9:23:12
	 */
	@Override
	public int channel_addList(List<ChannelForwardPo> list) {
		long startId = nextId();
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setId(Integer.valueOf(startId + i + ""));
		}
		return sqlSessionTemplate.insert("channel_addList", list);
		
	}
	/**
	 * @description:查询通道列表
	 * @param pageParam
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:18:03
	 */
	@Override
	public List<ChannelForwardPo> listChannel(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("list_channel", paramsMap);
	}
	/**
	 * @description:根据查询参数查询总记录数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:45:46
	 */
	@Override
	public int count_channel(Map<String, Object> paramsMap) {
		
		return sqlSessionTemplate.selectOne("count_channel",paramsMap);
	}
	/**
	 * @description:获得最优通道
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 上午11:00:52
	 */
	@Override
	public BestChannelPO getBestChannel(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getBestChannel",paramsMap);
	}

}
