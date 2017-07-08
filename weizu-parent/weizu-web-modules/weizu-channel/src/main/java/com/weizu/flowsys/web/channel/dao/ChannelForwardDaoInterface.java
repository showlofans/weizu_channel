package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description:上家通道折扣dao层接口
 * @projectName:crud
 * @className:ChannelForwardDaoInterface.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 上午10:58:23
 * @version 1.0
 */
public interface ChannelForwardDaoInterface extends Dao<ChannelForwardPo, Integer> {
	
	/**
	 * @description:批量添加通道
	 * @param list
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 上午9:21:12
	 */
	int channel_addList(List<ChannelForwardPo> list);
	/**
	 * @description:添加通道
	 * @param list
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 上午9:21:12
	 */
//	int channel_addList(ChannelForwardPo channelPo);
	
	/**
	 * @description:查询通道列表
	 * @param pageParam
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:17:18
	 */
	List<ChannelForwardPo> listChannel(Map<String, Object> paramsMap);
	
	/**
	 * @description:根据查询参数查询总记录数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:44:38
	 */
	int count_channel(Map<String, Object> paramsMap);
	
	/**
	 * @description:获得最优通道
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 上午11:00:20
	 */
	BestChannelPO getBestChannel(Map<String, Object> paramsMap);
	
	/**
	 * @description:通过通道ID找到所属平台
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:24:13
	 */
	ExchangePlatformPo getEpByChannelId(Integer channelId);
	
	/**
	 * @description: 更新通道使用状态
	 * @param channelId
	 * @param channelUseState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:50:57
	 */
	int updateChannelUseState(int channelId, int channelUseState);
	/**
	 * @description: 更新通道状态
	 * @param channelId
	 * @param channelUseState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:50:57
	 */
	int updateChannelState(int channelId, int channelState);

}
