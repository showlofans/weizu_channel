package com.weizu.flowsys.web.channel.ao;

import java.util.Map;

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
	
	/**
	 * @description: 获得分页的我的话费通道
	 * @param pageParams
	 * @param telChannelParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月24日 下午2:31:53
	 */
	public Pagination<TelChannelParams> getAgencyTelChannel(PageParam pageParams, TelChannelParams telChannelParams, Integer rootAgencyId, Integer contextAgencyId);
	

	/**
	 * @description: 获得子代理商的话费折扣配置列表
	 * @param pageParams
	 * @param telChannelParams
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月19日 下午4:19:43
	 */
	public void getChildAgencyTelChannel(PageParam pageParams, TelChannelParams telChannelParams, Integer agencyId, Integer childAccountId, Map<String,Object> resultMap);
	
//	public Pagination<TelChannelParams> getTelChannel(TelChannelParams telParams, PageParam pageParams);
	
	/**
	 * @description: 通过id和ServiceType获得通道的(含地区)详细信息
	 * @param telChannelId
	 * @param serviceType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月18日 下午2:36:03
	 */
	public TelChannelParams selectByIdType(Long telChannelId, Integer serviceType);
	
	/**
	 * @description: 编辑话费通道
	 * @param telChannelPo
	 * @param ifUpdateRate
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月18日 下午4:32:49
	 */
	public String editTelChannel(TelChannelPo telChannelPo, Integer ifUpdateRate);
	
	/**
	 * @description: 通过id删除话费通道
	 * @param telChannelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月5日 下午3:36:47
	 */
	public String delTelChannelById(Long telChannelId);
	
	/**
	 * @description: 获得我的话费折扣配置列表
	 * @param pageParams
	 * @param childAccountId
	 * @param contextAgencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月19日 下午4:08:52
	 */
//	public Pagination<TelRatePo> getMyTelRateList(PageParam pageParams, Integer childAccountId, Integer contextAgencyId);
}
