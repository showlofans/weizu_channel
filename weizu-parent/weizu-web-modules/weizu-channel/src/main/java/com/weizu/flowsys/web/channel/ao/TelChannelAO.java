package com.weizu.flowsys.web.channel.ao;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelChannelPo;

public interface TelChannelAO {
	/**
	 * @description: 添加话费通道
	 * @param telChannelPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月14日 下午3:35:42
	 */
	public String addTelChannel(TelChannelPo telChannelPo);
	
	/**
	 * @description: 获得话费通道分页列表
	 * @param telParams
	 * @param pageParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月14日 下午5:29:45
	 */
	public Pagination<TelChannelParams> getTelChannel(TelChannelParams telParams, PageParam pageParams);
}
