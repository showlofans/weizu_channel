package com.weizu.flowsys.web.channel.dao.impl;

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
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

@Repository(value = "channelChannelDao")
public class ChannelChannelDaoImpl extends DaoImpl<ChannelChannelPo, Long> implements
		ChannelChannelDao {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description: 通过通道ID找到所属平台
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:25:01
	 */
	@Override
	public ExchangePlatformPo getEpByChannelId(Long channelId) {
		
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
	public int updateChannelUseState(Long channelId, int channelUseState) {
		Map<String, Object> parameter = new HashMap<String, Object>(); 
		parameter.put("id", channelId);
		parameter.put("channelUseState", channelUseState);
		int channelState = get(channelId).getChannelState();
		if(channelState == ChannelStateEnum.OPEN.getValue())
		{//设置活动时间
			parameter.put("lastAccess", System.currentTimeMillis());
		}
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
	public int updateChannelState(Long channelId, int channelState) {
		Map<String, Object> parameter = new HashMap<String, Object>(); 
		parameter.put("id", channelId);
		parameter.put("channelState", channelState);
		int channelUseState = get(channelId).getChannelUseState();
		if(channelUseState == ChannelUseStateEnum.OPEN.getValue())
		{//设置活动时间
			parameter.put("lastAccess", System.currentTimeMillis());
		}
		return sqlSessionTemplate.update("updateChannelState", parameter);
	}
	/**
	 * @description: 查询通道列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月4日 下午6:01:06
	 */
	@Override
	public List<ChannelChannelPo> listChannel(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("list_channel", paramsMap);
	}

	

}
