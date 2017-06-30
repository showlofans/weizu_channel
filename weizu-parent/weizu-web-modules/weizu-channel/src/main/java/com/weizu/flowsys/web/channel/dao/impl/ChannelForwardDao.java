package com.weizu.flowsys.web.channel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.channel.dao.ChannelForwardDaoInterface;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

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
			//初始化通道状态和使用状态
			list.get(i).setChannelUseState(0);
			list.get(i).setChannelState(0);//
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
	/**
	 * @description: 通过通道ID找到所属平台
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:25:01
	 */
	@Override
	public ExchangePlatformPo getEpByChannelId(Integer channelId) {
		
		return sqlSessionTemplate.selectOne("getEpByChannelId",channelId);
	}
	/**
	 * @description:更新通道使用状态
	 * @param channelId
	 * @param channelUseState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:52:39
	 */
	@Override
	public int updateChannelUseState(int channelId, int channelUseState) {
		Map<String, Object> parameter = new HashMap<String, Object>(); 
		parameter.put("id", channelId);
		parameter.put("channelUseState", channelUseState);
		return sqlSessionTemplate.update("updateChannelUseState", parameter);
	}
	/**
	 * @description: 更新通道状态
	 * @param channelId
	 * @param channelState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:52:26
	 */
	@Override
	public int updateChannelState(int channelId, int channelState) {
		Map<String, Object> parameter = new HashMap<String, Object>(); 
		parameter.put("id", channelId);
		parameter.put("channelState", channelState);
		return sqlSessionTemplate.update("updateChannelState", parameter);
	}

}
