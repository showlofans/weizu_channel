package com.weizu.flowsys.web.channel.ao;

import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description: 通道业务层接口
 * @projectName:weizu-channel
 * @className:ChannelChannelAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月4日 下午6:03:40
 * @version 1.0
 */
public interface ChannelChannelAO {
	/**
	 * @description:通过通道ID找到所属平台
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:24:13
	 */
	ExchangePlatformPo getEpByChannelId(Long channelId);
	
	/**
	 * @description: 更新通道使用状态
	 * @param channelId
	 * @param channelUseState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:50:57
	 */
	int updateChannelUseState(String channelId, String channelUseState);
	
	/**
	 * @description: 更新通道状态
	 * @param channelId
	 * @param channelUseState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:50:57
	 */
	int updateChannelState(String channelId, String channelUseState);
	
	/**
	 * @description: 删除通道
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午3:26:36
	 */
	int deleteChannel(String channelId);
}
