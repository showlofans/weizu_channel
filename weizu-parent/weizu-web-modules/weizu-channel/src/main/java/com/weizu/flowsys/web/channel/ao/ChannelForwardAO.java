package com.weizu.flowsys.web.channel.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.OperatorScopeVO;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description:对上通道接口
 * @projectName:crud
 * @className:ChannelForwardAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 上午9:30:03
 * @version 1.0
 */
public interface ChannelForwardAO {
	/**
	 * @description:批量添加通道
	 * @param list
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 上午9:31:15
	 */
	int channel_addList(List<ChannelForwardPo> list);
	
	/**
	 * @description: 添加通道
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月4日 下午5:04:26
	 */
//	int channel_addList(ChannelForwardPo channelPo);
	
	/**
	 * @description:通道如果是多个，将实体变为多个通道
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 上午10:18:48
	 */
	List<ChannelForwardPo> initAddListByPo(ChannelForwardPo channelForwardPo);
	
	/**
	 * @description:查询通道列表
	 * @param pageParam
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:14:04
	 */
	Pagination<ChannelForwardPo> listChannel(PageParam pageParam,ChannelForwardPo channelForwardPo);
	
	/**
	 * @description:通过实体封装参数
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:57:27
	 */
	Map<String,Object> getMapByEntity(ChannelForwardPo channelForwardPo);
	
	/**
	 * @description:通过实体封装参数(最优通道)
	 * @param operatorScopeVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 上午11:15:09
	 */
	Map<String,Object> getMapByEntity(OperatorScopeVO operatorScopeVO);
	
	/**
	 * @description:获得最优通道
	 * @param operatorScopeVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 上午11:14:30
	 */
	BestChannelPO getBestChannel(OperatorScopeVO operatorScopeVO);
	
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
	
//	Pagination<ChannelForwardPo> getActiveChannel()
}
