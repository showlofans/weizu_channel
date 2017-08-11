package com.weizu.flowsys.web.channel.util;

import java.util.List;

import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 通道工具类
 * @projectName:weizu-channel
 * @className:ChannelUtil.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月4日 下午2:54:41
 * @version 1.0
 */
public class ChannelUtil {
	
	/**
	 * @description: 通过通道列表（业务id）初始化业务类型
	 * @param records
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月4日 下午2:55:39
	 */
	public static void initServiceTypeByList(List<ChannelForwardPo> records)
	{
		for (ChannelForwardPo channelForwardPo : records) {
			String serviceId = channelForwardPo.getServiceId();
			if(StringHelper.isNotEmpty(channelForwardPo.getServiceId())){
				channelForwardPo.setServiceType(Integer.parseInt(serviceId.substring(3)));
			}
		}
	}
}
