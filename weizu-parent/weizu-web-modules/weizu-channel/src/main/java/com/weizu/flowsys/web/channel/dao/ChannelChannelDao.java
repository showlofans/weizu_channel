package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.SpecialCnelType;
import com.weizu.flowsys.web.channel.pojo.SpecialOpdType;

/**
 * @description: 通道接口
 * @projectName:weizu-channel
 * @className:ChannelChannelDao.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月4日 下午5:48:38
 * @version 1.0
 */
public interface ChannelChannelDao extends Dao<ChannelChannelPo, Long> {
	
	
	/**
	 * @description: 添加通道
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午9:55:06
	 */
	int channel_addList(ChannelChannelPo channelPo);
	
	/**
	 * @description:查询通道列表
	 * @param pageParam
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:17:18
	 */
	List<ChannelChannelPo> listChannel(Map<String, Object> paramsMap);
	
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
	int updateChannelUseState(Long channelId, int channelUseState);
	/**
	 * @description: 更新通道状态
	 * @param channelId
	 * @param channelUseState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:50:57
	 */
	int updateChannelState(Long channelId, int channelState);
	
	/**
	 * @description: 查询通道个数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午10:21:40
	 */
	int count_channel(Map<String, Object> paramsMap);
	
	/**
	 * @description: 通道充值页面返回实体
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月28日 下午3:45:36
	 */
	List<ChargeChannelPo> list_charge_channel(Map<String,Object> params);
	
	/**
	 * @description: 获得特殊通道的特殊类型
	 * @param channelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月27日 上午10:24:59
	 */
	List<SpecialCnelType> getSpecialCnelType (Integer cnelType);
	/**
	 * @description: 获得特殊包体的特殊类型
	 * @param specialOpdType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月27日 上午10:24:59
	 */
	List<SpecialOpdType> getSpecialOpdType (SpecialOpdType specialOpdType);
	
	/**
	 * @description: 通过通道id获得通道相关的信息
	 * @param channelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月10日 下午5:11:04
	 */
	ChannelChannelPo getChannelById(Long channelId);

}
