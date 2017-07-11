package com.weizu.flowsys.web.channel.ao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscount;
import com.weizu.flowsys.web.activity.pojo.ScopeDiscount;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;

@Service(value="channelDiscountAO")
public class ChannelDiscountAOImpl implements ChannelDiscountAO {

	@Resource
	private ChannelDiscountDao channelDiscountDao;
	
	/**
	 * @description: 获得分页折扣列表
	 * @param cdp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月10日 上午11:58:37
	 */
	@Override
	public Pagination<ChannelDiscountPo> getDiscountList(ChannelDiscountPo cdp,PageParam pageParam) {
		Map<String, Object> paramsMap = getMapByEntity(cdp);
		
		int toatalRecord = channelDiscountDao.countDiscount(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		
		List<ChannelDiscountPo> records = channelDiscountDao.getDiscountList(paramsMap);
		
		return new Pagination<ChannelDiscountPo>(records, toatalRecord, pageNo, pageSize);
	}

	@Override
	public Map<String, Object> getMapByEntity(ChannelDiscountPo cdp) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(cdp.getChannelId() != null){
			paramsMap.put("channelId", cdp.getChannelId());
		}
		if(cdp.getDiscountType() != null){
			paramsMap.put("discountType", cdp.getDiscountType());
		}
		if(cdp.getChannelState() != null){
			paramsMap.put("channelState", cdp.getChannelState());
		}
		if(StringHelper.isNotEmpty(cdp.getChannelName())){
			//todo
			paramsMap.put("discountType", cdp.getDiscountType());
		}
		return paramsMap;
	}

	/**
	 * @description: 获得折扣列表
	 * @param cdp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 下午5:58:59
	 */
	@Override
	public List<ChannelDiscountPo> getDiscountList(ChannelDiscountPo cdp) {
		Map<String, Object> paramsMap = getMapByEntity(cdp);
		List<ChannelDiscountPo> records = channelDiscountDao.getDiscountList(paramsMap);
		return records;
	}
	
	/**
	 * @description: 通过折扣列表初始化地区折扣列表
	 * @param paramsList
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 下午6:01:52
	 */
	@Override
	public List<OperatorDiscount> getOperatorList(
			List<ChannelDiscountPo> paramsList) {
		
		List<ScopeDiscount> list0 = new LinkedList<ScopeDiscount>();		//移动的折扣
		List<ScopeDiscount> list1 = new LinkedList<ScopeDiscount>();		//联通的折扣
		List<ScopeDiscount> list2 = new LinkedList<ScopeDiscount>();		//电信的折扣
		
		for (ChannelDiscountPo channelDiscountPo : paramsList) {
			String scopeCityCode = channelDiscountPo.getScopeCityCode();
			if(StringHelper.isNotEmpty(scopeCityCode)){
				ScopeDiscount scopeDis = new ScopeDiscount(ScopeCityEnum.getEnum(scopeCityCode).getDesc(), channelDiscountPo.getChannelDiscount()+"", scopeCityCode);
				if(channelDiscountPo.getOperatorType() == OperatorTypeEnum.MOBILE.getValue()){
					list0.add(scopeDis);
				}else if(channelDiscountPo.getOperatorType() == OperatorTypeEnum.LINK.getValue()){
					list1.add(scopeDis);
				}else{
					list2.add(scopeDis);
				}
			}
		}
		List<OperatorDiscount> odList = new ArrayList<OperatorDiscount>();
		if(list0.size() != 0){
			odList.add(new OperatorDiscount(OperatorTypeEnum.MOBILE.getValue()+"", list0));
		}
		if(list1.size() != 0){
			odList.add(new OperatorDiscount(OperatorTypeEnum.LINK.getValue()+"", list1));
		}
		if(list2.size() != 0){
			odList.add(new OperatorDiscount(OperatorTypeEnum.TELECOME.getValue()+"", list2));
		}
		return odList;
	}

	/**
	 * @description: 通过折扣列表初始化地区折扣列表
	 * @param cdp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 下午6:25:29
	 */
	@Override
	public List<OperatorDiscount> getOperatorList(ChannelDiscountPo cdp) {
		List<ScopeDiscount> list0 = new LinkedList<ScopeDiscount>();		//移动的折扣
		List<ScopeDiscount> list1 = new LinkedList<ScopeDiscount>();		//联通的折扣
		List<ScopeDiscount> list2 = new LinkedList<ScopeDiscount>();		//电信的折扣
		Map<String, Object> paramsMap = getMapByEntity(cdp);
		List<ChannelDiscountPo> records = channelDiscountDao.getDiscountList(paramsMap);
		for (ChannelDiscountPo channelDiscountPo : records) {
			String scopeCityCode = channelDiscountPo.getScopeCityCode();
			if(StringHelper.isNotEmpty(scopeCityCode)){
				ScopeDiscount scopeDis = new ScopeDiscount(ScopeCityEnum.getEnum(scopeCityCode).getDesc(), channelDiscountPo.getChannelDiscount()+"", scopeCityCode);
				if(channelDiscountPo.getOperatorType() == OperatorTypeEnum.MOBILE.getValue()){
					list0.add(scopeDis);
				}else if(channelDiscountPo.getOperatorType() == OperatorTypeEnum.LINK.getValue()){
					list1.add(scopeDis);
				}else{
					list2.add(scopeDis);
				}
			}
		}
		List<OperatorDiscount> odList = new ArrayList<OperatorDiscount>();
		if(list0.size() != 0){
			odList.add(new OperatorDiscount(OperatorTypeEnum.MOBILE.getValue()+"", list0));
		}
		if(list1.size() != 0){
			odList.add(new OperatorDiscount(OperatorTypeEnum.LINK.getValue()+"", list1));
		}
		if(list2.size() != 0){
			odList.add(new OperatorDiscount(OperatorTypeEnum.TELECOME.getValue()+"", list2));
		}
		return odList;
	}

}
