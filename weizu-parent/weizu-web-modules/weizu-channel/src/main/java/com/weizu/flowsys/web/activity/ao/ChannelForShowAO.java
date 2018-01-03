package com.weizu.flowsys.web.activity.ao;

import java.util.List;

import com.weizu.flowsys.web.activity.pojo.ChannelForShowPo;

public interface ChannelForShowAO {
	
	/**
	 * @description: 展示通道列表
	 * @param channelForShowPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:26:48
	 */
	List<ChannelForShowPo> listShowRate(ChannelForShowPo channelForShowPo);
}
