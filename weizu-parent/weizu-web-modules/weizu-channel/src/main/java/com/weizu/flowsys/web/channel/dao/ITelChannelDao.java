package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelChannelPo;

public interface ITelChannelDao extends Dao<TelChannelPo, Long> {
	/**
	 * @description: 批量添加话费通道
	 * @param telChannelPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月14日 下午3:35:42
	 */
	public int batchAddTelChannel(List<TelChannelPo> telChannelList);
	
	/**
	 * @description: 查询话费通道列表
	 * @param telParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月14日 下午5:16:41
	 */
	public List<TelChannelParams> getTelChannel(Map<String,Object> params);
	/**
	 * @description: 通过id和ServiceType获得通道的(含地区)详细信息
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月16日 下午4:57:32
	 */
	public TelChannelParams selectByIdType(Map<String,Object> params);
	
	/**
	 * @description: 统计话费通道总记录
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月14日 下午5:17:50
	 */
	public Long countTelChanenl(Map<String,Object> params);
	
}
