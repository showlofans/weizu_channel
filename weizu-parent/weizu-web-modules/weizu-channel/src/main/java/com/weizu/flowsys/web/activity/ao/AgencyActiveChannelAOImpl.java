package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizu.web.foundation.DateUtil;
import org.weizu.web.foundation.StringUtil;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.dao.AgencyActiveChannelDao;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;
import com.weizu.flowsys.web.activity.pojo.DiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
@Service(value="agencyActiveChannelAO")
public class AgencyActiveChannelAOImpl implements AgencyActiveChannelAO {

	@Resource
	private AgencyActiveChannelDao agencyActiveChannelDao;
	
	@Resource
	private RateDiscountDao rateDiscountDao;
	
	/**
	 * @description: 查询代理商参与的活动通道(不分页)
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 下午7:11:39
	 */
	@Override
	public List<AgencyActiveChannelPo> listActiveDiscount(PageParam pageParam,
			AgencyActiveChannelPo activePo) {
		Map<String, Object> paramsMap = getMapByEntity(activePo);
		List<AgencyActiveChannelPo> records = agencyActiveChannelDao.listActiveDiscount(paramsMap);
		initRateDiscountStr(records);
		return records;
	}
	
	/**
	 * @description: 查询代理商参与的活动通道
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:17:27
	 */
	@Override
	public Pagination<AgencyActiveChannelPo> listActive(PageParam pageParam,
			AgencyActiveChannelPo activePo) {
		Map<String, Object> paramsMap = getMapByEntity(activePo);
		
		int toatalRecord = agencyActiveChannelDao.countActive(activePo);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<AgencyActiveChannelPo> records = agencyActiveChannelDao.listActive(paramsMap);
		initRateDiscountStr(records);
		return new Pagination<AgencyActiveChannelPo>(records, toatalRecord, pageNo, pageSize);
	}
	
	
	/**
	 * @description: 初始化代理商绑定通道列表页面运营商的折扣
	 * @param records
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月6日 上午10:16:36
	 */
	private void initRateDiscountStr(List<AgencyActiveChannelPo> records) {
		for (AgencyActiveChannelPo activePo : records) {
			List<RateDiscountPo>  list = activePo.getRateList();
			StringBuffer discount0 = new StringBuffer("{");
			StringBuffer discount1 = new StringBuffer("{");
			StringBuffer discount2 = new StringBuffer("{");
			for (RateDiscountPo ratePo : list) {
				String code = ratePo.getScopeCityCode();
				if(StringHelper.isNotEmpty(code)){
					String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
					int operatorType = ratePo.getOperatorType();
					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
					{
						discount0.append("\""+ScopeCityName+"\":\""+ratePo.getActiveDiscount()+"\",");
					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
					{
						discount2.append("\""+ScopeCityName+"\":\""+ratePo.getActiveDiscount()+"\",");
					}else//联通
					{
						discount1.append("\""+ScopeCityName+"\":\""+ratePo.getActiveDiscount()+"\",");
					}
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
			activePo.setDiscountPo(new DiscountPo(dis0Str, dis1Str, dis2Str));
			
			//初始化时间
			if(activePo.getActiveTime() != null){
				String activeTimeStr = DateUtil.formatAll(activePo.getActiveTime());
				activePo.setActiveTimeStr(activeTimeStr);
			}
		}
	}

	/**
	 * @description: 通过实体封装参数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:17:36
	 */
	@Override
	public Map<String, Object> getMapByEntity(AgencyActiveChannelPo activePo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(activePo.getChannelId() == null)
		{
			paramsMap.put("channelId", activePo.getChannelId());
		}
		if(activePo.getAgencyId() == null)
		{
			paramsMap.put("agencyId", activePo.getAgencyId());
		}
		return paramsMap;
	}


	/**
	 * @description: 代理商绑定通道
	 * @param aacp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 上午9:34:53
	 */
	@Transactional
	@Override
	public int bindChannel(AgencyActiveChannelPo aacp,RateDiscountPo rateDiscountPo) {
		
		Long nextActiveId = agencyActiveChannelDao.nextId();
		aacp.setActiveTime(System.currentTimeMillis());
		int bindRes = agencyActiveChannelDao.add(aacp);
		
		//只有一个地区
		int operatorType = aacp.getOperatorType();
		int serviceType = aacp.getServiceType();
		rateDiscountPo.setOperatorType(operatorType);
		rateDiscountPo.setServiceType(serviceType);
		rateDiscountPo.setActiveId(nextActiveId);
		rateDiscountPo.setActiveDiscount(StringUtil2.getDiscount(rateDiscountPo.getActiveDiscount()));
		rateDiscountDao.add(rateDiscountPo);
		
//		List<RateDiscountPo> rateList = aacp.getRateList();
//		initRateList(rateList,aacp,nextActiveId);
//		rateDiscountDao.rate_addList(rateList);
		
//		List<RateDiscountPo> rateList0 = aacp.getRateList0();
//		List<RateDiscountPo> rateList1 = aacp.getRateList1();
//		List<RateDiscountPo> rateList2 = aacp.getRateList2();
//			
//		if(rateList0 != null){
//		initRateList(rateList0,aacp,nextActiveId);
//			rateDiscountDao.rate_addList(rateList0);
//		}
//		if(rateList1 != null){
//			initRateList(rateList1,aacp,nextActiveId);
//			rateDiscountDao.rate_addList(rateList1);
//		}
//		if(rateList2 != null){
//			initRateList(rateList2,aacp,nextActiveId);
//			rateDiscountDao.rate_addList(rateList2);
//		}
		
		return bindRes;
	}


	


	/**
	 * @description: 初始化费率折扣列表
	 * @param rateList
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 上午10:40:23
	 */
//	private void initRateList(List<RateDiscountPo> rateList,AgencyActiveChannelPo aacp,Long nextActiveId) {
//		int operatorType = aacp.getOperatorType();
//		int serviceType = aacp.getServiceType();
//		for (RateDiscountPo rateDiscountPo : rateList) {
//			rateDiscountPo.setActiveId(nextActiveId);
//			rateDiscountPo.setServiceType(serviceType);
//			rateDiscountPo.setOperatorType(operatorType);
//		}
//		
//	}

}
