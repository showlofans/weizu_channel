package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.dao.AacJoinRdDao;
import com.weizu.flowsys.web.activity.dao.AgencyActiveChannelDao;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRatePo;
import com.weizu.flowsys.web.activity.pojo.DiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
@Service(value="agencyActiveChannelAO")
public class AgencyActiveChannelAOImpl implements AgencyActiveChannelAO {

	@Resource
	private AgencyActiveChannelDao agencyActiveChannelDao;
	
	@Resource
	private RateDiscountDao rateDiscountDao;
	
	@Resource
	private AacJoinRdDao aacJoinRdDao;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
	/**
	 * @description: 查询代理商参与的活动通道(不分页)
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 下午7:11:39
	 */
	@Override
	public List<AgencyActiveRatePo> listActiveDiscount(PageParam pageParam,
			AgencyActiveRatePo activePo) {
		Map<String, Object> paramsMap = getMapByEntity(activePo);
		List<AgencyActiveRatePo> records = agencyActiveChannelDao.listActiveDiscount(paramsMap);
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
	public Pagination<AgencyActiveRatePo> listActive(PageParam pageParam,
			AgencyActiveRatePo activePo) {
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
		List<AgencyActiveRatePo> records = agencyActiveChannelDao.listActive(paramsMap);
		initRateDiscountStr(records);
		return new Pagination<AgencyActiveRatePo>(records, toatalRecord, pageNo, pageSize);
	}
	
	/**
	 * @description: 查询分页费率列表
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午11:01:18
	 */
	@Override
	public Pagination<AgencyActiveRatePo> listActiveRate(
			PageParam pageParam, AgencyActiveRatePo activePo) {
		Map<String, Object> paramsMap = getMapByEntity(activePo);
		long toatalRecord = agencyActiveChannelDao.countActiveRate(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<AgencyActiveRatePo> records = agencyActiveChannelDao.listActiveRate(paramsMap);
		for (AgencyActiveRatePo activePo1 : records) {
			//初始化时间
			if(activePo1.getActiveTime() != null){
				String activeTimeStr = DateUtil.formatAll(activePo1.getActiveTime());
				activePo1.setActiveTimeStr(activeTimeStr);
			}
		}
		return new Pagination<AgencyActiveRatePo>(records, toatalRecord, pageNo, pageSize);
	}
	/**
	 * @description: 查询分页费率列表
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午11:01:18
	 */
	@Override
	public Pagination<AgencyActiveRatePo> listActiveRate(
			PageParam pageParam, RateDiscountPo ratePo) {
		Map<String, Object> paramsMap = getMapByEntity(ratePo);
		long toatalRecord = agencyActiveChannelDao.countActiveRate(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<AgencyActiveRatePo> records = agencyActiveChannelDao.listActiveRate(paramsMap);
		for (AgencyActiveRatePo activePo : records) {
			//初始化时间
			if(activePo.getActiveTime() != null){
				String activeTimeStr = DateUtil.formatAll(activePo.getActiveTime());
				activePo.setActiveTimeStr(activeTimeStr);
			}
		}
		return new Pagination<AgencyActiveRatePo>(records, toatalRecord, pageNo, pageSize);
	}
	
	
	/**
	 * @description: 初始化代理商绑定通道列表页面运营商的折扣
	 * @param records
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月6日 上午10:16:36
	 */
	private void initRateDiscountStr(List<AgencyActiveRatePo> records) {
		for (AgencyActiveRatePo activePo : records) {
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
	public Map<String, Object> getMapByEntity(AgencyActiveRatePo activePo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(activePo.getRateDiscountId() != null)
		{
			paramsMap.put("rateDiscountId", activePo.getRateDiscountId());
		}
		if(activePo.getAgencyName() != null)
		{
			paramsMap.put("agencyName", activePo.getAgencyName());
		}
		
		if(activePo.getAgencyId() != null)
		{
			paramsMap.put("agencyId", activePo.getAgencyId());
		}
		if(activePo.getBindAgencyId() != null)
		{
			paramsMap.put("bindAgencyId", activePo.getBindAgencyId());
		}
		if(activePo.getScopeCityCode() != null)
		{
			paramsMap.put("scopeCityCode", activePo.getScopeCityCode());
		}
		if(activePo.getOperatorType() != null)
		{
			paramsMap.put("operatorType", activePo.getOperatorType());
		}
		if(activePo.getServiceType() != null){
			paramsMap.put("serviceType", activePo.getServiceType());
		}
		return paramsMap;
	}
	/**
	 * @description: 通过实体封装参数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:17:36
	 */
	@Override
	public Map<String, Object> getMapByEntity(RateDiscountPo ratePo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(ratePo.getId() != null){
			paramsMap.put("rateId", ratePo.getId());
		}
		if(ratePo.getOperatorType() != null)
		{
			paramsMap.put("operatorType", ratePo.getOperatorType());
		}
		if(ratePo.getServiceType() != null){
			paramsMap.put("serviceType", ratePo.getServiceType());
		}
		if(StringHelper.isNotEmpty(ratePo.getScopeCityCode()))
		{
			paramsMap.put("scopeCityCode", ratePo.getScopeCityCode());
		}
		if(ratePo.getAgencyId() != null)
		{
			paramsMap.put("agencyId", ratePo.getAgencyId());
		}
//		if(ratePo.getChannelId() != null){
//			paramsMap.put("channelId", ratePo.getChannelId());
//		}
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
	public int bindChannel(AgencyActiveRatePo aacp,RateDiscountPo rateDiscountPo) {
		//只有一个地区,添加费率
		int operatorType = aacp.getOperatorType();
		int serviceType = aacp.getServiceType();
		rateDiscountPo.setOperatorType(operatorType);
		rateDiscountPo.setServiceType(serviceType);
//		rateDiscountPo.setActiveId(nextActiveId);
		rateDiscountPo.setActiveDiscount(StringUtil2.getDiscount(rateDiscountPo.getActiveDiscount()));
		Long nextDiscountId = rateDiscountDao.nextId();
		rateDiscountDao.add(rateDiscountPo);
		
		
//		Long nextActiveId = agencyActiveChannelDao.nextId();
		aacp.setActiveTime(System.currentTimeMillis());
		aacp.setBindState(BindStateEnum.BIND.getValue());
		aacp.setRateDiscountId(nextDiscountId);
		int bindRes = agencyActiveChannelDao.add(aacp);
		
		
		
//		bindRes = aacJoinRdDao.add(new AacJoinRdPo(nextDiscountId, nextActiveId));
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
	 * @description: 更新绑定状态
	 * @param activeId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午12:01:14
	 */
	@Transactional
	@Override
	public int updateBindState(String activeId, String bindState) {
		long id = Long.parseLong(activeId);
		int bindStateInt = Integer.parseInt(bindState);
		return agencyActiveChannelDao.updateBindState(id, bindStateInt);
	}
	/**
	 * @description: 批量更新绑定状态（根据折扣id，批量解除绑定）
	 * @param rateDiscountId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午10:15:00
	 */
	@Transactional
	@Override
	public int batchUpdateBindState(AgencyActiveRateDTO aardto) {
//		long rateId = Long.parseLong(rateDiscountId);
//		int bState = Integer.parseInt(bindState);
		if(aardto.getBindState() == BindStateEnum.BIND.getValue()){//绑定
			String agencyIdst = aardto.getAgencyIds();
			if(StringHelper.isNotEmpty(agencyIdst)){
				String [] agencyIdsi = agencyIdst.split(",");
				int[] agencyIds = new int[agencyIdsi.length];
				for (int i = 0; i < agencyIds.length; i++) {
					agencyIds[i] = Integer.parseInt(agencyIdsi[i]);
				}
				return agencyActiveChannelDao.batchUpdateBindState(aardto.getRateDiscountId(), aardto.getBindState(), agencyIds);
			}else{
				return 0;
			}
		}else{//解绑
			return agencyActiveChannelDao.batchUpdateBindState(aardto.getRateDiscountId(), aardto.getBindState());
		}
	}

	/**
	 * @description: 更新绑定的折扣
	 * @param activeId
	 * @param activeDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午4:17:00
	 */
	@Override
	public int updateRateDiscount(String activeId, String activeDiscount) {
		long id = Long.parseLong(activeId);
		double activeDiscountD = StringUtil2.getDiscount(activeDiscount);
		return rateDiscountDao.updateRateDiscount(id, activeDiscountD);
	}

	/**
	 * @description: 添加绑定
	 * @param aacp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月15日 上午11:53:37
	 */
	@Override
	public int add(AgencyActiveRatePo aacp) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @description: 通道批量绑定代理商 
	 * @param aardto
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 下午3:38:17
	 */
	@Override
	public int batchBindAgency(AgencyActiveRateDTO aardto) {
		String agencyIdst = aardto.getAgencyIds();
		if(StringHelper.isNotEmpty(agencyIdst)){
			String [] agencyIdsi = agencyIdst.split(",");
			int[] agencyIds = new int[agencyIdsi.length];
			String[]agencyNames = new String[agencyIdsi.length];
			for (int i = 0; i < agencyIdsi.length; i++) {
				agencyIds[i] = Integer.parseInt(agencyIdsi[i]);
				agencyNames[i] = agencyVODao.get(agencyIds[i]).getUserName();
			}
			
			List<AgencyActiveRateDTO> list = new LinkedList<AgencyActiveRateDTO>();
			Long rateDiscountId = aardto.getRateDiscountId();
			for (int i = 0; i < agencyNames.length; i++) {
				AgencyActiveRateDTO aardtoq = new AgencyActiveRateDTO(agencyIds[i], agencyNames[i], rateDiscountId, System.currentTimeMillis(), 0, aardto.getBindAgencyId());
				list.add(aardtoq);
			}
			return agencyActiveChannelDao.batch_bindList(list);
//			AgencyBackwardPo agencyPo = new AgencyBackwardPo();
//			agencyPo.setAgencyIds(agencyIds);
//			List<AgencyBackwardPo> list = agencyVODao.getBatchAgency(agencyPo);
		}
		return 0;
	}

	@Override
	@Transactional
	public String delAar(Long aarId) {
		int res = agencyActiveChannelDao.del(aarId);
		if(res > 0){
			return "success";
		}
		return "error";
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
