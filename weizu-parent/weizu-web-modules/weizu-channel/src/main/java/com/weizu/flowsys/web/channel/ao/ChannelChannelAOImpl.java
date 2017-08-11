package com.weizu.flowsys.web.channel.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.DiscountPo;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.String.StringHelper;

@Service(value="channelChannelAO")
public class ChannelChannelAOImpl implements ChannelChannelAO {

	@Resource
	private ChannelChannelDao channelChannelDao;
	
	@Override
	public ExchangePlatformPo getEpByChannelId(Long channelId) {
		
		return channelChannelDao.getEpByChannelId(channelId);
	}

	@Override
	@Transactional
	public int updateChannelUseState(String channelId, String channelUseState) {
		Long id = Long.parseLong(channelId);
		int useState = Integer.parseInt(channelUseState);
		
		if(ChannelUseStateEnum.CLOSE.getValue() == useState)
		{
			useState = ChannelUseStateEnum.OPEN.getValue();
		}else{
			useState = ChannelUseStateEnum.CLOSE.getValue();
		}
		
		return channelChannelDao.updateChannelUseState(id, useState);
	}

	@Transactional
	@Override
	public int updateChannelState(String channelId, String channelState) {
		Long id = Long.parseLong(channelId);
		int cState = Integer.parseInt(channelState);
		
		if(ChannelStateEnum.CLOSE.getValue() == cState)
		{
			cState = ChannelStateEnum.OPEN.getValue();
		}else{
			cState = ChannelStateEnum.CLOSE.getValue();
		}
		
		return channelChannelDao.updateChannelState(id, cState);
	}

	@Override
	public int deleteChannel(String channelId) {
		Long id = Long.parseLong(channelId);
		return channelChannelDao.del(id);
	}

	/**
	 * @description: 添加通道
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午9:52:30
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE)
	@Override
	public int channel_addList(ChannelChannelPo channelPo) {
		//初始化通道状态和使用状态
		channelPo.setChannelUseState(0);
		channelPo.setChannelState(0);
		String serviceType = ServiceTypeEnum.getEnum(channelPo.getServiceType()).getDesc();
		channelPo.setChannelName(serviceType +"-"+channelPo.getChannelName());
		return channelChannelDao.channel_addList(channelPo);
	}

	@Override
	public Pagination<ChannelChannelPo> listChannel(PageParam pageParam,
			ChannelChannelPo channelChannelPo) {
		
		Map<String, Object> paramsMap = getMapByEntity(channelChannelPo);
		
		int toatalRecord = channelChannelDao.count_channel(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<ChannelChannelPo> records = channelChannelDao.listChannel(paramsMap);
		
		initChannelDiscountStr(records);
		//初始化scopeCityName,引用类型直接
//		for (ChannelChannelPo channelChannelPo2 : records) {
//			String scopeCityName = "";
//			for(ChannelDiscountPo channelDiscount: channelChannelPo2.getDiscountList())
//			if(StringHelper.isNotEmpty(channelDiscount.getScopeCityCode()))
//			{
//				for(Map<String, Object> cityMap : ScopeCityEnum.toList())
//				{
//					String cityName = cityMap.get("desc").toString();
//					if(cityName.contains(channelChannelPo2.getScopeCityName().trim()))//江西属于江西省
//					{
//						scopeCityName = cityMap.get("value").toString();
//						break;
//					}
//				}
//			}
//			channelChannelPo2.setScopeCityName(scopeCityName);
//		}
//		
		return new Pagination<ChannelChannelPo>(records, toatalRecord, pageNo, pageSize);
	}

	/**
	 * @description: 初始化通道列表页面运营商的折扣
	 * @param records
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午12:49:30
	 */
	private void initChannelDiscountStr(List<ChannelChannelPo> records) {
		for (ChannelChannelPo channelChannelPo : records) {
			List<ChannelDiscountPo>  list = channelChannelPo.getDiscountList();
			StringBuffer discount0 = new StringBuffer("{");
			StringBuffer discount1 = new StringBuffer("{");
			StringBuffer discount2 = new StringBuffer("{");
			if(list != null && list.size()>0){
				channelChannelPo.setServiceType(list.get(0).getServiceType());//初始化业务类型
				channelChannelPo.setOperatorType(list.get(0).getOperatorType());//初始化业务类型
				for (ChannelDiscountPo channelDiscountPo : list) {
					String code = channelDiscountPo.getScopeCityCode();
					String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
					int operatorType = channelDiscountPo.getOperatorType();
					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
					{
						discount0.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\",");
					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
					{
						discount2.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\",");
					}else//联通
					{
						discount1.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\",");
					}
				}
				
				String dis0Str = discount0.append("}").toString();
	//			String dis0 = dis0Str.substring(0,dis0Str.lastIndexOf(","));
	//			channelChannelPo.setDiscount0(dis0);
				String dis1Str = discount1.append("}").toString();
	//			String dis1 = dis1Str.substring(0,dis1Str.lastIndexOf(","));
	//			channelChannelPo.setDiscount0(dis0);
				String dis2Str = discount2.append("}").toString();
	//			String dis2 = dis2Str.substring(0,dis2Str.lastIndexOf(","));
				channelChannelPo.setDiscountPo(new DiscountPo(dis0Str, dis1Str, dis2Str));
				channelChannelPo.setBillType(list.get(0).getBillType());
			}
		}
	}

	/**
	 * @description: 通过实体封装参数
	 * @param operatorScopeVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午10:17:07
	 */
	@Override
	public Map<String, Object> getMapByEntity(ChannelChannelPo channelPo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		
		if(channelPo != null){
			if(StringHelper.isNotEmpty(channelPo.getChannelName()))
			{
				paramsMap.put("channelName", channelPo.getChannelName());
			}
			if(channelPo.getChannelState() != null)
			{
				paramsMap.put("channelState", channelPo.getChannelState());
			}
			if(channelPo.getServiceType() != null){
				paramsMap.put("serviceType", channelPo.getServiceType());
			}
			if(StringHelper.isNotEmpty(channelPo.getScopeCityName()))
			{
				String scopeCityCode = "";
				for(Map<String, Object> cityMap : ScopeCityEnum.toList())
				{
					String cityName = cityMap.get("desc").toString();
					if(cityName.contains(channelPo.getScopeCityName().trim()))//江西属于江西省
					{
						scopeCityCode = cityMap.get("value").toString();
					}
					paramsMap.put("scopeCityCode", scopeCityCode);
				}
			}
//			if(StringHelper.isNotEmpty(channelPo.getScopeCityCode()))
//			{
//				paramsMap.put("scopeCityName", channelPo.getScopeCityCode());
//			}
			if(channelPo.getBelongAgencyId() != null)
			{
				paramsMap.put("belongAgencyId", channelPo.getBelongAgencyId());
			}
			if(channelPo.getId() != null){
				paramsMap.put("channelId", channelPo.getId());
			}
			
		}
		
		return paramsMap;
	}

	/**
	 * @description: 获得简易通道列表( agencyId,  billType)(id,name)
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午3:47:32
	 */
//	@Override
//	public List<ChannelChannelPo> listChannel(Integer agencyId,Integer billType) {
//		Map<String,Object> paramsMap = new HashMap<String, Object>(3);
//		String[] scopeCityCodes = ScopeCityEnum.getValues();
//		//billtype在controller已经确认不为空
//		
//		paramsMap.put("belongAgencyId", agencyId);
//		paramsMap.put("billType", billType);
//		paramsMap.put("scopeCityCodes", scopeCityCodes);
//		
//		return channelChannelDao.listSimpleChannel(paramsMap);
//	}
	/**
	 * @description: 获得开通的简易通道列表( agencyId,  billType)(id,name)
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月6日 下午5:45:35
	 */
//	@Override
//	public List<ChannelChannelPo> listOpenChannel(ChannelChannelPo channelPo) {
//		Map<String,Object> paramsMap = new HashMap<String, Object>(5);
//		paramsMap.put("belongAgencyId", channelPo.getBelongAgencyId());
////		paramsMap.put("billType", channelPo.getBillType());
//		paramsMap.put("channelState", ChannelStateEnum.OPEN.getValue());//查找开通的通道
//		paramsMap.put("operatorType", channelPo.getOperatorType());
//		paramsMap.put("serviceType", channelPo.getServiceType());
//		paramsMap.put("scopeCityCode", channelPo.getScopeCityCode());
//		return channelChannelDao.listSimpleChannel(paramsMap);
//	}

}
