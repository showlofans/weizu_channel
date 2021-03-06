package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgSizeEnum;
import com.weizu.flowsys.operatorPg.enums.PgTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.dao.AgencyActiveRateDTODao;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.DiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountShowDTO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.OperatorPgDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.pojo.RatePgPo;
import com.weizu.web.foundation.String.StringHelper;

@Service(value="rateDiscountAO")
public class RateDiscountAOImpl implements RateDiscountAO {

	@Resource
	private RateDiscountDao rateDiscountDao;
	
	@Resource
	private AgencyActiveRateDTODao agencyActiveRateDTODao;
	
	@Resource
	private PurchaseAO purchaseAO;
	
	@Resource
	private OperatorPgDaoInterface operatorPgDao;
	
	/**
	 * @description: 获得费率列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午5:21:52
	 */
//	@Override
//	public Pagination<RateDiscountPo> getRateList(RateDiscountPo ratePo,PageParam pageParam) {
//		
//		return null;
//	}
	@Override
	public Pagination<RateDiscountPo> getMyRateList(RateDiscountPo ratePo,PageParam pageParam) {
		Map<String, Object> paramsMap = getMapByRate(ratePo);
		long toatalRecord = rateDiscountDao.countMyRate(paramsMap);
		int pageSize = 10;
		Long pageNoLong = 1l;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNoLong = pageParam.getPageNoLong();
			paramsMap.put("start", (pageNoLong-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<RateDiscountPo> records = rateDiscountDao.getMyRate(paramsMap);
		if(ratePo.getAccountId() != null){//去查询子代理商账号下的费率
			for (RateDiscountPo ratePo1 : records) {
				//初始化子费率
				Map<String,Object> pMap = new HashMap<String, Object>();
//			pMap.put("bindState", BindStateEnum.BIND.getValue());
//			pMap.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
				pMap.put("activeId", ratePo1.getId());
				pMap.put("accountId", ratePo.getAccountId());
				pMap.put("bindState", BindStateEnum.BIND.getValue());
				RateDiscountPo childRatePo = rateDiscountDao.getMyChildRate(pMap);
				ratePo1.setChildRatePo(childRatePo);
//			for (RateDiscountPo rateDiscountPo : list) {
//				rateDiscountPo.setBillTypeDesc(BillTypeEnum.getEnum(rateDiscountPo.getBillType()).getDesc());
//			}
//			ratePo1.setDiscountList(list);
			}
		}else{
			for (RateDiscountPo ratePo1 : records) {
				Map<String,Object> params = new HashMap<String, Object>();
				params.put("channelId", ratePo1.getChannelId());
				//初始化包体规格列表参数
				List<PgDataPo> pgList = operatorPgDao.getPgByChanel(params);
				ratePo1.setPgList(pgList);
			}
		}
		return new Pagination<RateDiscountPo>(records, toatalRecord, pageNoLong, pageSize);
	}

	/**
	 * @description: 获得费率总数
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午5:22:01
	 */
	@Override
	public int countRateList(RateDiscountPo ratePo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @description: 通过折扣初始化地区折扣列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午9:48:48
	 */
	@Override
	public List<RateDiscountPo> getOperatorList(RateDiscountPo ratePo) {
//		Map<String, Object> paramsMap = getMapByEntity(ratePo);
		List<RateDiscountPo> rateList = rateDiscountDao.getRateDiscountList(ratePo);
		
		return rateList;
	}

	@Override
	public Map<String, Object> getMapByEntity(RateDiscountPo ratePo) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(ratePo != null){
//			if(StringHelper.isNotEmpty(ratePo.getChannelName()))
//			{
//				paramsMap.put("channelName", ratePo.getChannelName());
//			}
			if(ratePo.getOperatorType() != null)
			{
				paramsMap.put("operatorType", ratePo.getOperatorType());
			}
			if(ratePo.getServiceType() != null){
				paramsMap.put("serviceType", ratePo.getServiceType());
			}
			if(ratePo.getBillType() != null){
				paramsMap.put("billType", ratePo.getBillType());
			}
//			if(StringHelper.isNotEmpty(ratePo.getScopeCityName()))
//			{
//				String scopeCityCode = "";
//				for(Map<String, Object> cityMap : ScopeCityEnum.toList())
//				{
//					String cityName = cityMap.get("desc").toString();
//					if(cityName.contains(ratePo.getScopeCityName().trim()))//江西属于江西省
//					{
//						scopeCityCode = cityMap.get("value").toString();
//					}
//					paramsMap.put("scopeCityCode", scopeCityCode);
//				}
//			}
			if(StringHelper.isNotEmpty(ratePo.getScopeCityCode()))
			{
				paramsMap.put("scopeCityCode", ratePo.getScopeCityCode());
			}
			if(ratePo.getAgencyId() != null)
			{
				paramsMap.put("agencyId", ratePo.getAgencyId());
			}
			if(ratePo.getChannelId() != null){
				paramsMap.put("channelId", ratePo.getChannelId());
			}
		}
		return paramsMap;
	}

	/**
	 * @description: 通过折扣初始化地区折扣列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 下午1:00:30
	 */
	@Override
	public Map<String,Object> getOperatorListRate(RateDiscountPo ratePo) {
//		List<ScopeDiscount> list0 = new LinkedList<ScopeDiscount>();		//移动的折扣
//		List<ScopeDiscount> list1 = new LinkedList<ScopeDiscount>();		//联通的折扣
//		List<ScopeDiscount> list2 = new LinkedList<ScopeDiscount>();		//电信的折扣
//		Map<String, Object> paramsMap = getMapByEntity(ratePo);
		List<RateDiscountPo> records = rateDiscountDao.getRateDiscountList(ratePo);
		
//		List<String> scopeList = rateDisocuntDao.getDistinctScope(ratePo);
//		Map<String,Map<String,Object>> scopeMap = new HashMap<String, Map<String,Object>>();
		//初始化地区map（）
//		for (String scopeCityCode : scopeList) {
//			Map<String,Object> addMap = new HashMap<String, Object>();
//			scopeMap.put(scopeCityCode, addMap);
//		}
		
		
		//给折扣列表按地区分类
		Map<String,Object> resultMap = new HashMap<String, Object>();
//		List<ScopeDiscount> addlist = new LinkedList<ScopeDiscount>();
		
		String scopeCityCodeSim = "100";
		
		//填充地区map
//		Map<String,Object> addMap = null;
		List<Double> discountList = null;
		for (RateDiscountPo rateDiscountPo : records) {
			//在排好序的情况下
			if(!scopeCityCodeSim.equals(rateDiscountPo.getScopeCityCode())){//地区不相等（第一个一定）
				discountList = new LinkedList<Double>();
				discountList.add(rateDiscountPo.getActiveDiscount());
				resultMap.put(rateDiscountPo.getScopeCityCode(), discountList);//新增一个list
				scopeCityCodeSim = rateDiscountPo.getScopeCityCode();//生成新的key
			}else{//地区相等
				discountList.add(rateDiscountPo.getActiveDiscount());//在原来的list上新增一个折扣
				resultMap.put(scopeCityCodeSim, discountList);//覆盖原来的key
			}
			
//			scopeMap.get(scopeCityCode).put(scopeCityCode, rateDiscountPo);
//			if(StringHelper.isNotEmpty(scopeCityCode)){
//				ScopeDiscount scopeDis = new ScopeDiscount(ScopeCityEnum.getEnum(scopeCityCode).getDesc(), rateDiscountPo.getActiveDiscount()+"", scopeCityCode);
//				for (Map<String,Object> scopeDiscount : ScopeCityEnum.toList()) {
//					
//				}
//				resultMap.put(scopeCityCode, value)
////				if(rateDiscountPo.getOperatorType() == OperatorTypeEnum.MOBILE.getValue()){
////					list0.add(scopeDis);
////				}else if(rateDiscountPo.getOperatorType() == OperatorTypeEnum.LINK.getValue()){
////					list1.add(scopeDis);
////				}else{
////					list2.add(scopeDis);
////				}
//			}
		}
//		List<OperatorDiscount> odList = new ArrayList<OperatorDiscount>();
//		if(list0.size() != 0){
//			resultMap.put("mobile", new OperatorDiscount(OperatorTypeEnum.MOBILE.getValue(), list0));
////			odList.add(new OperatorDiscount(OperatorTypeEnum.MOBILE.getValue()+"", list0));
//		}
//		if(list1.size() != 0){
//			resultMap.put("link", new OperatorDiscount(OperatorTypeEnum.LINK.getValue(), list1));
////			odList.add(new OperatorDiscount(OperatorTypeEnum.LINK.getValue()+"", list1));
//		}
//		if(list2.size() != 0){
//			resultMap.put("telecome", new OperatorDiscount(OperatorTypeEnum.TELECOME.getValue(), list2));
////			odList.add(new OperatorDiscount(OperatorTypeEnum.TELECOME.getValue()+"", list2));
//		}
//		return odList;
		return resultMap;
	}

	/**
	 * @description:  添加费率折扣
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午11:24:36
	 */
	@Override
	public String addRateDiscount(RateDiscountPo ratePo) {
		Map<String,Object> params = getMapByRate(ratePo);
		//看同样的折扣是否存在
		long tag = rateDiscountDao.countDiscountList(params);
		if(tag > 0){
			return "exist";
		}else{
			int addRes = rateDiscountDao.add(ratePo);
			if(addRes > 0)
			{
				return "success";
			}else{
				return "error";
			}
		}
	}
	/**
	 * @description: 在折扣上添加费率折扣
	 * @param ratePo
	 * @param agencyName
	 * @param bindAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午3:19:56
	 */
	@Transactional
	@Override
	public String addRateDiscount(RateDiscountPo ratePo, String childAgencyName,
			Integer bindAgencyId) {
		long rateDiscountId = rateDiscountDao.nextId();
		int addRes = rateDiscountDao.add(ratePo);
		AccountActiveRateDTO aardto = new AccountActiveRateDTO(ratePo.getAccountId(), childAgencyName, rateDiscountId,ratePo.getChannelDiscountId(), System.currentTimeMillis(), BindStateEnum.BIND.getValue(), bindAgencyId);
		int addaardtoRes = agencyActiveRateDTODao.add(aardto);
		if(addRes + addaardtoRes > 1){
			return "success";
		}
		return "error";
	}
	/**
	 * @description: 更新下级费率折扣
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午3:32:34
	 */
	@Transactional
	@Override
	public String updateRateDiscount(RateDiscountPo ratePo) {
		int res = rateDiscountDao.updateLocal(ratePo, new WherePrams("id", "=", ratePo.getId()));
		if(res > 0){
			return "success";
		}
		return "error";
	}
	/**
	 * @description: 封装查询是否存在费率，单表查询参数
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午11:35:49
	 */
	private Map<String,Object> getMapByRate(RateDiscountPo ratePo){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		if(ratePo.getChannelDiscountId() != null)
		{
			resultMap.put("channelDiscountId", ratePo.getChannelDiscountId());
		}
		if(ratePo.getActiveDiscount() != null)
		{
			resultMap.put("activeDiscount", ratePo.getActiveDiscount());
		}
		if(ratePo.getActiveId() != null)
		{
			resultMap.put("activeId", ratePo.getActiveId());
		}
		if(ratePo.getBillType() != null)
		{
			resultMap.put("billTypeRate", ratePo.getBillType());
		}
		if(ratePo.getAgencyId() != null)
		{
			resultMap.put("agencyId", ratePo.getAgencyId());
		}
		if(ratePo.getId() != null)
		{
			resultMap.put("id", ratePo.getId());
		}
		if(StringHelper.isNotEmpty(ratePo.getScopeCityCode())){
			resultMap.put("scopeCityCode", ratePo.getScopeCityCode());
		}
		if(ratePo.getOperatorType() != null){
			resultMap.put("operatorType", ratePo.getOperatorType());
		}
		if(ratePo.getServiceType() != null){
			resultMap.put("serviceType", ratePo.getServiceType());
		}
		
		resultMap.put("bindState", BindStateEnum.BIND.getValue());
		resultMap.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
		return resultMap;
	}

	/**
	 * @description: 修改费率折扣
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午1:59:11
	 */
	@Override
	public String editBindRate(RateDiscountPo ratePo) {
		Map<String,Object> params = getMapByRate(ratePo);
		//看同样的折扣是否存在
		long tag = rateDiscountDao.countDiscountList(params);
		if(tag > 0){
			return "exist";
		}else{
			int updRes = rateDiscountDao.update(ratePo);
			if(updRes > 0){
				return "success";
			}else{
				return "error";
			}
		}
		
	}

	/**
	 * @description: 获得首页折扣信息
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月19日 下午12:08:07
	 */
//	@Override
//	public Map<String,Object> getShowRate(Integer agencyId) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		Map<String,Object> dtoMap = new HashMap<String, Object>();
//		params.put("agencyId", agencyId);
//		
//		BillTypeEnum[] bTypeEnums = BillTypeEnum.values();	
//		ServiceTypeEnum [] sTypeEnums = ServiceTypeEnum.values();
//		for (ServiceTypeEnum serviceTypeEnum : sTypeEnums) {
//			for (BillTypeEnum billTypeEnum : bTypeEnums) {
//				params.put("billType", billTypeEnum.getValue());
//				params.put("serviceType", serviceTypeEnum.getValue());
//				params.put("bindState", BindStateEnum.BIND.getValue());
//				params.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
//				List<RateDiscountPo> rateListBill = rateDiscountDao.getShowRate(params);
//				initRateList(rateListBill, dtoMap, billTypeEnum.getValue(), serviceTypeEnum.getValue());
//			}
//		}
//		
////		params.put("billType", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////		List<RateDiscountPo> rateList = rateDiscountDao.getShowRate(params);
////		initRateList(rateList, dtoMap, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		
////		if(rateListBill != null && rateListBill.size()>0){//有对公的费率
//////			DiscountPo dpo = null;
////			StringBuffer discount0 = new StringBuffer("{");
////			StringBuffer discount1 = new StringBuffer("{");
////			StringBuffer discount2 = new StringBuffer("{");
////			for (RateDiscountPo rateDiscountPo2 : rateListBill) {
////				String code = rateDiscountPo2.getScopeCityCode();
////				String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
////				int operatorType = rateDiscountPo2.getOperatorType();
////				if(operatorType == OperatorTypeEnum.MOBILE.getValue())
////				{
////					discount0.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\",");
////				}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
////				{
////					discount2.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\",");
////				}else//联通
////				{
////					discount1.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\",");
////				}
////			}
////			String dis0Str = discount0.append("}").toString();
////			String dis1Str = discount1.append("}").toString();
////			String dis2Str = discount2.append("}").toString();
////			DiscountPo dpo = new DiscountPo(dis0Str, dis1Str, dis2Str);
////			dtoMap.put("billDTO", new RateDiscountShowDTO(dpo, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
////		}
//		
//		return dtoMap;
//	}
	@Resource
	private ChannelChannelDao channelChannelDao;
	@Override
	public List<RateDiscountShowDTO> getIndexShowRate(Integer agencyId, Boolean isRoot) {
		Map<String, Object> params = new HashMap<String, Object>();
//		Map<String,Object> dtoMap = new HashMap<String, Object>();
		List<RateDiscountShowDTO> dtoList = new LinkedList<RateDiscountShowDTO>();
		params.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
		if(isRoot){
			params.put("channelState", ChannelStateEnum.OPEN.getValue());
		}else{
			params.put("agencyId", agencyId);
			params.put("bindState", BindStateEnum.BIND.getValue());
		}
		BillTypeEnum[] bTypeEnums = BillTypeEnum.values();	
		ServiceTypeEnum [] sTypeEnums = ServiceTypeEnum.values();
		for (ServiceTypeEnum serviceTypeEnum : sTypeEnums) {
			for (BillTypeEnum billTypeEnum : bTypeEnums) {
				params.put("billType", billTypeEnum.getValue());
				params.put("serviceType", serviceTypeEnum.getValue());
				if(isRoot){
					List<ChannelChannelPo> channelList = channelChannelDao.listChannel(params);
					initChannelList(channelList, dtoList, billTypeEnum.getValue(), serviceTypeEnum.getValue());
				}else{
					//分类查询，然后合并
					List<RateDiscountPo> rateListBill = rateDiscountDao.getShowRate(params);
					initRateList(rateListBill, dtoList, billTypeEnum.getValue(), serviceTypeEnum.getValue());
				}
				
			}
		}
		return dtoList;
	}
	
	/**
	 * @description: 把带票业务区分开来
	 * @param rateList
	 * @param dtoMap
	 * @param billType
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午4:41:56
	 */
	private void initChannelList(List<ChannelChannelPo> cnelList,List<RateDiscountShowDTO> showList,int billType,int serviceType) {
//		List<RateDiscountShowDTO> dtoList = new LinkedList<RateDiscountShowDTO>();
//		String key = "";
		if(cnelList != null && cnelList.size()>0){//有对公的费率
//			DiscountPo dpo = null;
			int i = 0;
			int j = 0;
			int k = 0;
			
			for (ChannelChannelPo channelPo : cnelList) {
				List<ChannelDiscountPo>  cdlist = channelPo.getDiscountList();
				for (ChannelDiscountPo channelDiscountPo : cdlist) {
					int operatorType = channelDiscountPo.getOperatorType();
					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
					{
						i++;
					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
					{
						k++;
					}else//联通
					{
						j++;
					}
				}
			}
			StringBuffer discount0 = null;
			StringBuffer discount1 = null;
			StringBuffer discount2 = null;
//			StringBuffer discountTag0 = null;
//			StringBuffer discountTag1 = null;
//			StringBuffer discountTag2 = null;
			if(i > 0){
				discount0 = new StringBuffer("{");
//				discountTag0 = new StringBuffer("{");
			}
			if(j > 0){
				discount1 = new StringBuffer("{");
//				discountTag1 = new StringBuffer("{");
			}
			if(k > 0){
				discount2 = new StringBuffer("{");
//				discountTag2 = new StringBuffer("{");
			}
			
			int m = 0;
			
			int listSize = cnelList.size();
			for (ChannelChannelPo channelPo : cnelList) {
				List<ChannelDiscountPo>  cdlist = channelPo.getDiscountList();
				boolean hasSpecialTag = StringHelper.isEmpty(channelPo.getSpecialTag());
				for (ChannelDiscountPo channelDiscountPo : cdlist) {
					String code = channelDiscountPo.getScopeCityCode();
					String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
					int operatorType = channelDiscountPo.getOperatorType();
					if(hasSpecialTag){
						
						if(operatorType == OperatorTypeEnum.MOBILE.getValue())
						{
//						channelPo.
							discount0.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							if(m != listSize-1){
								discount0.append(",");
							}
						}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
						{
							discount2.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							if(m != listSize-1){
								discount2.append(",");
							}
						}else//联通
						{
							discount1.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							if(m != listSize-1){
								discount1.append(",");
							}
						}
					}else{
						StringBuffer discountTag = new StringBuffer("{");
						DiscountPo dpo = null;
						if(operatorType == OperatorTypeEnum.MOBILE.getValue())
						{
//							discountTag0.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							discountTag.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							discountTag.append("}");
							dpo = new DiscountPo(discountTag.toString(), null, null);
//							if(m != listSize-1){
//								discountTag1.append(",");
//							}
						}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
						{
//							discountTag2.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							discountTag.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							discountTag.append("}");
							dpo = new DiscountPo(null, null, discountTag.toString());
//							if(m != listSize-1){
//								discountTag2.append(",");
//							}
						}else//联通
						{
//							discountTag1.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							discountTag.append("\""+ScopeCityName+"\":\""+channelDiscountPo.getChannelDiscount()+"\"");
							discountTag.append("}");
							dpo = new DiscountPo(null, discountTag.toString(), null );
//							if(m != listSize-1){
//								discountTag1.append(",");
//							}
						}
						if(m != listSize-1){
							discountTag.append(",");
						}
						String specialTag = channelPo.getSpecialTag();
						RateDiscountShowDTO showDTO = new RateDiscountShowDTO(dpo, billType,serviceType);
						showDTO.setSpecialTag(specialTag);
						showList.add(showDTO);
					}
					
				}
				m++;
			}
			String dis0Str = "";
			String dis1Str = "";
			String dis2Str = "";
			if(i > 0){
				if( discount0.length() == 1){
					dis0Str = null;
				}else{
					dis0Str = discount0.append("}").toString();
				}
			}
			if(j > 0){
				if( discount1.length() == 1){
					dis1Str = null;
				}else{
					dis1Str = discount1.append("}").toString();
				}
			}
			if(k > 0){
				if( discount2.length() == 1){
					dis2Str = null;
				}else{
					dis2Str = discount2.append("}").toString();
				}
			}
			DiscountPo dpo = new DiscountPo(dis0Str, dis1Str, dis2Str);
			RateDiscountShowDTO showDTO = new RateDiscountShowDTO(dpo, billType,serviceType);
			showList.add(showDTO);
		}
	}
	/**
	 * @description: 把带票业务区分开来
	 * @param rateList
	 * @param dtoMap
	 * @param billType
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午4:41:56
	 */
	private void initRateList(List<RateDiscountPo> rateList,List<RateDiscountShowDTO> showList,int billType,int serviceType) {
//		List<RateDiscountShowDTO> dtoList = new LinkedList<RateDiscountShowDTO>();
//		String key = "";
		if(rateList != null && rateList.size()>0){//有对公的费率
//			DiscountPo dpo = null;
			int i = 0;
			int j = 0;
			int k = 0;
			for (RateDiscountPo rateDiscountPo2 : rateList) {
				int operatorType = rateDiscountPo2.getOperatorType();
				if(operatorType == OperatorTypeEnum.MOBILE.getValue())
				{
					i++;
				}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
				{
					k++;
				}else//联通
				{
					j++;
				}
			}
			StringBuffer discount0 = null;
			StringBuffer discount1 = null;
			StringBuffer discount2 = null;
			if(i > 0){
				discount0 = new StringBuffer("{");
			}
			if(j > 0){
				discount1 = new StringBuffer("{");
			}
			if(k > 0){
				discount2 = new StringBuffer("{");
			}
			
			int m = 0;
			for (RateDiscountPo rateDiscountPo2 : rateList) {
				
				String code = rateDiscountPo2.getScopeCityCode();
				String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
				int operatorType = rateDiscountPo2.getOperatorType();
				if(StringHelper.isEmpty(rateDiscountPo2.getSpecialTag())){
					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
					{
						discount0.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\"");
						if(m != rateList.size()-1){
							discount0.append(",");
						}
					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
					{
						discount2.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\"");
						if(m != rateList.size()-1){
							discount2.append(",");
						}
					}else//联通
					{
						discount1.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\"");
						if(m != rateList.size()-1){
							discount1.append(",");
						}
					}
				}else{
					StringBuffer discountTag = new StringBuffer("{");
					DiscountPo dpo = null;
					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
					{
						discountTag.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\"");
						discountTag.append("}");
						dpo = new DiscountPo(discountTag.toString(), null, null);
					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
					{
						discountTag.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\"");
						discountTag.append("}");
						dpo = new DiscountPo(null, null, discountTag.toString());
					}else//联通
					{
						discountTag.append("\""+ScopeCityName+"\":\""+rateDiscountPo2.getActiveDiscount()+"\"");
						discountTag.append("}");
						dpo = new DiscountPo(null, discountTag.toString(), null );
					}
					if(m != rateList.size()-1){
						discountTag.append(",");
					}
					String specialTag = rateDiscountPo2.getSpecialTag();
					RateDiscountShowDTO showDTO = new RateDiscountShowDTO(dpo, billType,serviceType);
					showDTO.setSpecialTag(specialTag);
					showList.add(showDTO);
				}
				m++;
			}
			String dis0Str = "";
			String dis1Str = "";
			String dis2Str = "";
			if(i > 0){
				if( discount0.length() == 1){
					dis0Str = null;
				}else{
					dis0Str = discount0.append("}").toString();
				}
			}
			if(j > 0){
				if( discount1.length() == 1){
					dis1Str = null;
				}else{
					dis1Str = discount1.append("}").toString();
				}
			}
			if(k > 0){
				if( discount2.length() == 1){
					dis2Str = null;
				}else{
					dis2Str = discount2.append("}").toString();
				}
			}
			DiscountPo dpo = new DiscountPo(dis0Str, dis1Str, dis2Str);
			RateDiscountShowDTO showDTO = new RateDiscountShowDTO(dpo, billType,serviceType);
			showList.add(showDTO);
		}
	}
//			Map<String,Object> bMap = new HashMap<String, Object>();
//			if(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue() == billType){
//				bMap.put("noDTO", new RateDiscountShowDTO(dpo, 1,serviceType));
//			}else{
//				bMap.put("billDTO", new RateDiscountShowDTO(dpo, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
//			}
//			if(ServiceTypeEnum.NATION_WIDE.getValue() == serviceType){
//				key = "nationWide";
//			}else if(ServiceTypeEnum.PROVINCE_ROAMING.getValue() == serviceType){
//				key = "provinceRoaming";
//			}else{
//				key = "province";
//			}
//			dtoMap.put(key, bMap);
		
//		if(rateList != null && rateList.size()>0){
////			DiscountPo dpo = null;
//			StringBuffer discount0 = new StringBuffer("{");
//			StringBuffer discount1 = new StringBuffer("{");
//			StringBuffer discount2 = new StringBuffer("{");
//			StringBuffer discount10 = new StringBuffer("{");//不带票
//			StringBuffer discount11 = new StringBuffer("{");
//			StringBuffer discount12 = new StringBuffer("{");
//			int tagBill = 0;		//有带票的折扣
//			int tag = 0;			//不带票的折扣标志
//			for (RateDiscountPo rateDiscountPo : rateList) {
//				String code = rateDiscountPo.getScopeCityCode();
//				String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
//				int operatorType = rateDiscountPo.getOperatorType();
//				int billTypeRate = rateDiscountPo.getBillType();
//				if(billTypeRate == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()){
//					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
//					{
//						discount10.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
//					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
//					{
//						discount12.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
//					}else//联通
//					{
//						discount11.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
//					}
//					tag = 1;
//				}else{
//					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
//					{
//						discount0.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
//					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
//					{
//						discount2.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
//					}else//联通
//					{
//						discount1.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
//					}
//					tagBill = 1;
//				}
//			}
//			String dis0Str = discount0.append("}").toString();
//			String dis1Str = discount1.append("}").toString();
//			String dis2Str = discount2.append("}").toString();
//			String dis10Str = discount10.append("}").toString();
//			String dis11Str = discount11.append("}").toString();
//			String dis12Str = discount12.append("}").toString();
//			DiscountPo dpo = new DiscountPo(dis0Str, dis1Str, dis2Str);
//			DiscountPo dpo1 = new DiscountPo(dis10Str, dis11Str, dis12Str);
//			if(tagBill == 1){
//				dtoMap.put("billDTO", new RateDiscountShowDTO(dpo, 0));
//			}
//			if(tag == 1){
//				dtoMap.put("noDTO", new RateDiscountShowDTO(dpo1, 1));
//			}
//			
//		}
	
	/**
	 * @description: 看传入的地区参数是否符合折扣信息
	 * @param loginAgencyId
	 * @param scopeCityName
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月1日 下午5:54:59
	 */
	@Override
	public boolean checkScopeIsAccept(Integer accountId,
			String scopeCityName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		String scopeCityCode = ScopeCityEnum.getValueByDesc(scopeCityName);
		params.put("scopeCityCode", scopeCityCode);
		params.put("bindState", BindStateEnum.BIND.getValue());
		params.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
		params.put("channelType", ChannelTypeEnum.ORDINARY.getValue());
		params.put("pgType", PgTypeEnum.PGDATA.getValue());
		params.put("pgValidity", PgValidityEnum.MONTH_DAY_DATA.getValue());
		RateDiscountPo ratePo = rateDiscountDao.getRateForCharge(params);
		if(ratePo != null){
			return true;
		}
		
//		List<RateDiscountPo> rateList = rateDiscountDao.getShowRate(params);//参考地区
//		ScopeCityEnum[] enumAry = ScopeCityEnum.values();
//		//验证是否存在该地区的折扣
//		if(rateList == null || rateList.size()==0){
//			return false;
//		}
//		for (RateDiscountPo rateDiscountPo : rateList) {
//			for (ScopeCityEnum scopeCityEnum : enumAry) {
//				if(scopeCityEnum.getValue().equals(rateDiscountPo.getScopeCityCode()) && scopeCityEnum.getDesc().contains(scopeCityName) ){//得到参考地区
//					return true;
//				}
//			}
//		}
		return false;
	}
	/**
	 * @description: 获得充值价格
	 * @param dataPo
	 * @param carrier
	 * @param loginAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 上午11:54:40
	 */
//	@Override
//	public RateDiscountPo getRateForCharge(int serviceType,
//			String carrier, int accountId, Boolean judgeChannelState) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		//用不带票的账户去获得价格
//		params.put("accountId", accountId);
//		params.put("bindState", BindStateEnum.BIND.getValue());
//		params.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
//		params.put("serviceType", serviceType);
//		int sLength = carrier.length();
//		String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
//		if(ServiceTypeEnum.NATION_WIDE.getValue() != serviceType){
//			String scopeCityName = carrier.substring(0,sLength-2);
//			int opType = OperatorTypeEnum.getValueByDesc(oType);//运营商类型
//			params.put("operatorType", opType);
//			String scopeCityCode = ScopeCityEnum.getValueByDesc(scopeCityName);
//			params.put("scopeCityCode", scopeCityCode);
//		}else{
//			params.put("scopeCityCode", ScopeCityEnum.QG.getValue());//使用全国的地区
//		}
//		if(judgeChannelState){//需要判断通道状态:比如再次提交获得的费率，比如测试通道的时候
//			params.put("channelState", ChannelStateEnum.OPEN.getValue());
//		}
//		return rateDiscountDao.getRateForCharge(params);
//	}
	
	@Override
	public RateDiscountPo getRateForCharge(ChargeChannelParamsPo ccpp,
			int accountId, Boolean judgeChannelState) {
		Map<String, Object> params = getMapByParams(ccpp, accountId, judgeChannelState);
		return rateDiscountDao.getRateForCharge(params);
	}
	
	@Override
	public List<RatePgPo> getRatePgForCharge(ChargeChannelParamsPo ccpp,
			int accountId, Boolean judgeChannelState) {
		Map<String, Object> params = getMapByParams(ccpp, accountId, judgeChannelState);
		List<RatePgPo> ratePgList = rateDiscountDao.getRatePgForCharge(params);
		for (RatePgPo ratePgPo : ratePgList) {
			ratePgPo.setPgDiscountPrice(NumberTool.round(NumberTool.mul(ratePgPo.getPgPrice(), ratePgPo.getActiveDiscount()), 2));
			if(PgSizeEnum.getEnum(ratePgPo.getPgSize()) != null){
				ratePgPo.setPgSizeStr(PgSizeEnum.getEnum(ratePgPo.getPgSize()).getDesc()); 
			}else{
				ratePgPo.setPgSizeStr(ratePgPo.getPgSize() + "M");
			}
		}
		return ratePgList;
	}
	
	private Map<String,Object> getMapByParams(ChargeChannelParamsPo ccpp,
			int accountId, Boolean judgeChannelState){
		String carrier = ccpp.getCarrier();
		Map<String, Object> params = PurchaseUtil.getOperatorMapByCarrier(carrier);
		if(params != null){
			params.put("accountId", accountId);
			params.put("bindState", BindStateEnum.BIND.getValue());
			params.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
			Integer serviceType = ccpp.getServiceType();
			params.put("serviceType", serviceType);
			if(ServiceTypeEnum.NATION_WIDE.getValue() == serviceType){
				params.put("scopeCityCode", ScopeCityEnum.QG.getValue());//使用全国的地区
			}
			
//			int sLength = carrier.length();
//			String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
//			if(ServiceTypeEnum.NATION_WIDE.getValue() != serviceType){
//				String scopeCityName = carrier.substring(0,sLength-2);
//				String scopeCityCode = ScopeCityEnum.getValueByDesc(scopeCityName);
//				params.put("scopeCityCode", scopeCityCode);
//			}else{
//				params.put("scopeCityCode", ScopeCityEnum.QG.getValue());//使用全国的地区
//			}
//			int opType = OperatorTypeEnum.getValueByDesc(oType);//运营商类型
//			params.put("operatorType", opType);
			
			
			if(judgeChannelState){//需要判断通道状态:比如再次提交获得的费率，比如测试通道的时候
				params.put("channelState", ChannelStateEnum.OPEN.getValue());
			}
			if (ccpp.getChannelType() == null) {
				params.put("channelType", ChannelTypeEnum.ORDINARY.getValue());
			} else {
				params.put("channelType", ccpp.getChannelType());
			}
			if (ccpp.getPgType() == null) {
				params.put("pgType", PgTypeEnum.PGDATA.getValue());
			} else {
				params.put("pgType", ccpp.getPgType());
			}
			if (StringHelper.isEmpty(ccpp.getPgValidity())) {
				params.put("pgValidity", PgValidityEnum.MONTH_DAY_DATA.getValue());
			} else {
				params.put("pgValidity", ccpp.getPgValidity());
			}
			
			if(ccpp.getPgSize() != null){
				params.put("pgSize", ccpp.getPgSize());
			}
		}else{
			System.out.println("获取地区编码和运营商失败");
		}
		return params;
	}
	
	@Override
	public RateDiscountPo getRateByAcountIdAndCDId(Long channelDiscountId,
			Integer accountId) {
		List<RateDiscountPo> rateList = rateDiscountDao.getRateByAcountIdAndCDId(channelDiscountId, accountId);
		if(rateList != null && rateList.size()==1){
			return rateList.get(0);
		}
		return null;
	}

	@Override
	public List<PgDataPo> getPgListForPurchase(
			ChargeChannelParamsPo ccpp, int agencyId, Boolean judgeChannelState) {
		Map<String, Object> params = new HashMap<String, Object>();
		//用不带票的账户去获得价格
		params.put("agencyId", agencyId);
		params.put("bindState", BindStateEnum.BIND.getValue());
		params.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
		Integer serviceType = ccpp.getServiceType();
		String carrier = ccpp.getCarrier();
		params.put("serviceType", serviceType);
		int sLength = carrier.length();
		String oType = carrier.substring(sLength-2,sLength); //获得operatorType:运营商类型参数，移动
		if(ServiceTypeEnum.NATION_WIDE.getValue() != serviceType){
			String scopeCityName = carrier.substring(0,sLength-2);
			String scopeCityCode = ScopeCityEnum.getValueByDesc(scopeCityName);
			params.put("scopeCityCode", scopeCityCode);
		}else{
			params.put("scopeCityCode", ScopeCityEnum.QG.getValue());//使用全国的地区
		}
		int opType = OperatorTypeEnum.getValueByDesc(oType);//运营商类型
		params.put("operatorType", opType);
		if(judgeChannelState){//需要判断通道状态:比如再次提交获得的费率，比如测试通道的时候
			params.put("channelState", ChannelStateEnum.OPEN.getValue());
		}
		if (ccpp.getChannelType() == null) {
			params.put("channelType", ChannelTypeEnum.ORDINARY.getValue());
		} else {
			params.put("channelType", ccpp.getChannelType());
		}
		if (ccpp.getPgType() == null) {
			params.put("pgType", PgTypeEnum.PGDATA.getValue());
		} else {
			params.put("pgType", ccpp.getPgType());
		}
		if (StringHelper.isEmpty(ccpp.getPgValidity())) {
			params.put("pgValidity", PgValidityEnum.MONTH_DAY_DATA.getValue());
		} else {
			params.put("pgValidity", ccpp.getPgValidity());
		}
		
		List<RateDiscountPo> rateList = rateDiscountDao.getRateListForCharge(params);
		List<PgDataPo> resultList = new LinkedList<PgDataPo>();
		for (RateDiscountPo rateDiscountPo : rateList) {
			List<PgDataPo> pgList = purchaseAO.getPgByChanel(rateDiscountPo.getChannelId());
			resultList.addAll(pgList);
		}
//		List<OperatorPgDataPo> chargeList = initByPgList(resultList);
//		for (OperatorPgDataPo operatorPgDataPo : chargeList) {//初始化第一个折扣，折扣id和包体价格
//			operatorPgDataPo.setRteId(ratePo.getId());
//			operatorPgDataPo.setRteDis(activeDiscount);
//			operatorPgDataPo.setChannelId(channelId);
//			operatorPgDataPo.setPgDiscountPrice(NumberTool.mul(activeDiscount, operatorPgDataPo.getPgPrice()));
//		}
		
		return resultList;
	}

	@Override
	public RateDiscountPo getPriceByPg(Integer pgId, Integer agencyId, Long channelId,Integer billType) {
		RateDiscountPo ratePo = rateDiscountDao.getPriceByPg(agencyId, pgId,channelId, billType);
		
		return ratePo;
	}

	
}
