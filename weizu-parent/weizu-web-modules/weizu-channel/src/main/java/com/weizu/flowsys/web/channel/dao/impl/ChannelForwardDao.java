package com.weizu.flowsys.web.channel.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.pojo.ScopeDiscount;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.ChannelForwardDaoInterface;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

@Repository(value="channelForwardDao")
public class ChannelForwardDao extends DaoImpl<ChannelForwardPo, Integer> implements
		ChannelForwardDaoInterface {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	
	/**
	 * @description: 添加通道
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月4日 下午4:58:59
	 */
	@Override
	public int channel_addList(ChannelForwardPo channelPo) {
		List<ChannelDiscountPo> disList = new LinkedList<ChannelDiscountPo>();
		int channelRes = add(channelPo);
		Integer channelId = Integer.parseInt(nextId()+"")-1;
		for(ScopeDiscount sd: channelPo.getDiscountList())
		{
			long nextId = channelDiscountDao.nextId();
			double channelDiscount = StringUtil2.getDiscount(sd.getChannelDiscount());
			ChannelDiscountPo cdp = new ChannelDiscountPo(channelId, sd.getScopeCityName(), channelDiscount, channelPo.getChannelName());
			cdp.setId(nextId);
			disList.add(cdp);
		}
		int discountRes = channelDiscountDao.discount_addList(disList);
		return channelRes;
	}
	/**
	 * @description:批量添加通道
	 * @param list
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 上午9:23:12
	 */
	@Override
	public int channel_addList(List<ChannelForwardPo> list) {
		long startId = nextId();
		
		for (int i = 0; i < list.size(); i++) {
			ChannelForwardPo channel = list.get(i);
			channel.setId(Integer.valueOf(startId + i + ""));
			//初始化通道状态和使用状态
			channel.setChannelUseState(0);
			channel.setChannelState(0);//
			//批量添加通道折扣
			//重新根据通道和折扣批量添加通道折扣
		}
		return sqlSessionTemplate.insert("channel_addList", list);
		
	}
	/**
	 * @description:查询通道列表
	 * @param pageParam
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:18:03
	 */
	@Override
	public List<ChannelForwardPo> listChannel(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectList("list_channel", paramsMap);
	}
	/**
	 * @description:根据查询参数查询总记录数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:45:46
	 */
	@Override
	public int count_channel(Map<String, Object> paramsMap) {
		
		return sqlSessionTemplate.selectOne("count_channel",paramsMap);
	}
	/**
	 * @description:获得最优通道
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 上午11:00:52
	 */
	@Override
	public BestChannelPO getBestChannel(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getBestChannel",paramsMap);
	}
	/**
	 * @description: 通过通道ID找到所属平台
	 * @param channelId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:25:01
	 */
	@Override
	public ExchangePlatformPo getEpByChannelId(Integer channelId) {
		
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
	public int updateChannelUseState(int channelId, int channelUseState) {
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
	public int updateChannelState(int channelId, int channelState) {
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
}
