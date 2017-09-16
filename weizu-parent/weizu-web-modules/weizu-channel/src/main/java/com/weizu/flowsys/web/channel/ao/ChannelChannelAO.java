package com.weizu.flowsys.web.channel.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
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
	int updateChannelState(String channelId, String channelState);
	
	/**
	 * @description: 删除通道
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午3:26:36
	 */
	int deleteChannel(String channelId);
	
	
	/**
	 * @description:  添加通道
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午9:50:55
	 */
	String channel_addList(ChannelChannelPo channelPo);
	
	/**
	 * @description: 查询通道列表
	 * @param pageParam
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午10:15:12
	 */
	Pagination<ChannelChannelPo> listChannel(PageParam pageParam,ChannelChannelPo channelForwardPo);
	
	/**
	 * @description: 获得简易通道列表( agencyId,  billType)(id,name)
	 * @param agencyId
	 * @param billType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午3:45:32
	 */
//	List<ChannelChannelPo> listChannel(Integer agencyId,Integer billType);
	
//	/**
//	 * @description: 获得开通的简易通道列表( agencyId,  billType)(id,name)
//	 * @param channelChannelPo
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年7月6日 下午5:40:36
//	 */
//	List<ChannelChannelPo> listOpenChannel(ChannelChannelPo channelChannelPo);
	
	
	/**
	 * @description: 通过实体封装参数
	 * @param operatorScopeVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午10:16:33
	 */
	Map<String,Object> getMapByEntity(ChannelChannelPo channelPo);
	
	
}
