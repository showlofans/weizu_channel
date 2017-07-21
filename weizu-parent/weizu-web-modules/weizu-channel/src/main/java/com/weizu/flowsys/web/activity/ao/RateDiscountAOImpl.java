package com.weizu.flowsys.web.activity.ao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.DiscountPo;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscount;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountShowDTO;
import com.weizu.flowsys.web.activity.pojo.ScopeDiscount;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.http.weizu.GetBalanceParams;

@Service(value="rateDiscountAO")
public class RateDiscountAOImpl implements RateDiscountAO {

	@Resource
	private RateDiscountDao rateDiscountDao;
	/**
	 * @description: 获得费率列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午5:21:52
	 */
	@Override
	public Pagination<RateDiscountPo> getRateList(RateDiscountPo ratePo,PageParam pageParam) {
		
		return null;
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
		if(ratePo.getBillType() != null)
		{
			resultMap.put("billTypeRate", ratePo.getBillType());
		}
		
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
	@Override
	public Map<String,Object> getShowRate(Integer agencyId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agencyId", agencyId);
		List<RateDiscountPo> rateList = rateDiscountDao.getShowRate(params);
		return initRateList(rateList);
	}

	private Map<String,Object> initRateList(List<RateDiscountPo> rateList) {
//		List<RateDiscountShowDTO> dtoList = new ArrayList<RateDiscountShowDTO>();
		Map<String,Object> dtoMap = new HashMap<String, Object>();
		if(rateList != null && rateList.size()>0){
//			DiscountPo dpo = null;
			StringBuffer discount0 = new StringBuffer("{");
			StringBuffer discount1 = new StringBuffer("{");
			StringBuffer discount2 = new StringBuffer("{");
			StringBuffer discount10 = new StringBuffer("{");//不带票
			StringBuffer discount11 = new StringBuffer("{");
			StringBuffer discount12 = new StringBuffer("{");
			int tagBill = 0;		//有带票的折扣
			int tag = 0;			//不带票的折扣标志
			for (RateDiscountPo rateDiscountPo : rateList) {
				String code = rateDiscountPo.getScopeCityCode();
				String ScopeCityName = ScopeCityEnum.getEnum(code).getDesc();	//城市名
				int operatorType = rateDiscountPo.getOperatorType();
				int billTypeRate = rateDiscountPo.getBillType();
				if(billTypeRate == BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()){
					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
					{
						discount10.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
					{
						discount12.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
					}else//联通
					{
						discount11.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
					}
					tag = 1;
				}else{
					if(operatorType == OperatorTypeEnum.MOBILE.getValue())
					{
						discount0.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
					}else if(operatorType == OperatorTypeEnum.TELECOME.getValue())
					{
						discount2.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
					}else//联通
					{
						discount1.append("\""+ScopeCityName+"\":\""+rateDiscountPo.getActiveDiscount()+"\",");
					}
					tagBill = 1;
				}
			}
			String dis0Str = discount0.append("}").toString();
			String dis1Str = discount1.append("}").toString();
			String dis2Str = discount2.append("}").toString();
			String dis10Str = discount10.append("}").toString();
			String dis11Str = discount11.append("}").toString();
			String dis12Str = discount12.append("}").toString();
			DiscountPo dpo = new DiscountPo(dis0Str, dis1Str, dis2Str);
			DiscountPo dpo1 = new DiscountPo(dis10Str, dis11Str, dis12Str);
			if(tagBill == 1){
				dtoMap.put("billDTO", new RateDiscountShowDTO(dpo, 0));
			}
			if(tag == 1){
				dtoMap.put("noDTO", new RateDiscountShowDTO(dpo1, 1));
			}
			
		}
		return dtoMap;
	}
	
	

}