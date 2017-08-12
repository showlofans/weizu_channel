package com.weizu.flowsys.web.channel.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.ChannelDiscountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

@Repository(value = "channelChannelDao")
public class ChannelChannelDaoImpl extends DaoImpl<ChannelChannelPo, Long> implements
		ChannelChannelDao {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	
	/**
	 * @description: 通过通道ID找到所属平台
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:25:01
	 */
	@Override
	public ExchangePlatformPo getEpByChannelId(Long channelId) {
		
		return sqlSessionTemplate.selectOne("getEpByChannelId",channelId);
	}
	/**
	 * @description:更新通道使用状态
	 * @param channelId
	 * @param channelUseState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:52:39
	 */
	@Override
	public int updateChannelUseState(Long channelId, int channelUseState) {
		Map<String, Object> parameter = new HashMap<String, Object>(); 
		parameter.put("id", channelId);
		parameter.put("channelUseState", channelUseState);
		int channelState = get(channelId).getChannelState();
		if(channelState == ChannelStateEnum.OPEN.getValue())
		{//设置活动时间
			parameter.put("lastAccess", System.currentTimeMillis());
		}
		return sqlSessionTemplate.update("updateChannelUseState", parameter);
	}
	/**
	 * @description: 更新通道状态
	 * @param channelId
	 * @param channelState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 上午11:52:26
	 */
	@Override
	public int updateChannelState(Long channelId, int channelState) {
		Map<String, Object> parameter = new HashMap<String, Object>(); 
		parameter.put("id", channelId);
		parameter.put("channelState", channelState);
		int channelUseState = get(channelId).getChannelUseState();
		if(channelUseState == ChannelUseStateEnum.OPEN.getValue())
		{//设置活动时间
			parameter.put("lastAccess", System.currentTimeMillis());
		}
		return sqlSessionTemplate.update("updateChannelState", parameter);
	}
	/**
	 * @description: 查询通道列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月4日 下午6:01:06
	 */
	@Override
	public List<ChannelChannelPo> listChannel(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("list_channel_channel", paramsMap);
	}
	/**
	 * @description: 添加通道
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午9:55:28
	 */
	@Override
	public int channel_addList(ChannelChannelPo channelPo) {
		List<ChannelDiscountPo> disList = new LinkedList<ChannelDiscountPo>();
		int channelRes = add(channelPo);
		Long channelId = nextId()-1;
		int operatorType = channelPo.getOperatorType();
		int serviceType = channelPo.getServiceType();
		int billType = channelPo.getBillType();
		
		//设置通道名称
		String serviceTypeStr = ServiceTypeEnum.getEnum(serviceType).getDesc();
		channelPo.setChannelName(serviceTypeStr +"-"+channelPo.getChannelName());
		String channelName = channelPo.getChannelName();
		
		for(ChannelDiscountPo cdp: channelPo.getDiscountList())
		{
//			long nextId = channelDiscountDao.nextId();
			double channelDiscount = StringUtil2.getDiscount(cdp.getChannelDiscount());
			ChannelDiscountPo cdp1 = new ChannelDiscountPo(channelId, cdp.getScopeCityCode(), channelDiscount, channelName, operatorType, serviceType,ChannelDiscountTypeEnum.CHANNEL.getValue());
//			cdp1.setId(nextId);
			cdp1.setBillType(billType);
			disList.add(cdp1);
		}
		int discountRes = channelDiscountDao.discount_addList(disList);
		return channelRes;
	}
	/**
	 * @description: 查询通道个数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午10:50:17
	 */
	@Override
	public int count_channel(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectOne("count_channel_channel",paramsMap);
	}

}
