package com.weizu.flowsys.web.activity.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.activity.dao.IOperatorDiscountDao;
import com.weizu.flowsys.web.activity.dao.impl.RateBackwardDaoImpl;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscount;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardVo;
import com.weizu.flowsys.web.activity.pojo.ScopeDiscount;
import com.weizu.flowsys.web.agency.dao.impl.AgencyVODao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description:费率操作业务层接口实现
 * @projectName:crud
 * @className:OperatorDiscountAOImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月18日 下午4:42:28
 * @version 1.0
 */
@Service(value="operatorDiscountAO")
public class OperatorDiscountAOImpl implements OperatorDiscountAO {

	@Resource
	private IOperatorDiscountDao operatorDiscountDao;
	@Resource
	private RateBackwardDaoImpl rateBackwardDao;
	@Resource
	private AgencyVODao agencyVODao;
	/**
	 * @description:根据页面费率实体批量添加费率
	 * @param rateBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 下午4:42:41
	 */
//	@Transactional
//	@Override
//	public int disccount_addList(RateBackwardVo rateBackwardVo,Integer rootAgencyId) {
//		List<OperatorDiscountPo> list = new LinkedList<OperatorDiscountPo>();
//		String rateName = rateBackwardVo.getRateName();
//		List<OperatorDiscount> discounts = rateBackwardVo.getOperatorDiscount();//
//		
//		String[] ratePrice = new String[3];
//		for (int i = 0 ; i < discounts.size(); i++) {
//			int operatorType = Integer.parseInt(discounts.get(i).getOperatorType()) ;
//			
//			List<ScopeDiscount> scopeList = discounts.get(i).getList();
//			
//			for (ScopeDiscount scopeDiscount : scopeList) {
//				String scopeName = scopeDiscount.getScopeCityName();
//				double discount = StringUtil2.getDiscount(scopeDiscount.getChannelDiscount());
//				OperatorDiscountPo addPo = new OperatorDiscountPo(operatorType, scopeName, discount, rateName, rootAgencyId);
//				list.add(addPo);
//			}
//			Map<String,Object> map = new HashMap<String,Object>();
//			for (ScopeDiscount scopeDiscount : scopeList) {
//				map.put(scopeDiscount.getScopeCityName(), StringUtil2.getDiscount(scopeDiscount.getChannelDiscount()));
//			}
//			ratePrice[operatorType] = JSONArray.toJSONString(map).toString();
//		}
//		RateBackwardPo rateBackwardPo = new RateBackwardPo(rateName, rootAgencyId, ratePrice[0], ratePrice[1], ratePrice[2], 0,rateBackwardVo.getBillType());
//		Long rateId = rateBackwardDao.nextId();
//		int res = rateBackwardDao.add(rateBackwardPo);
//		for (OperatorDiscountPo odp : list) {
//			odp.setRateId(rateId);//设置费率Id
//		}
//		
//		if(rateBackwardVo.getAgencyId() != null){//判断是否是自动绑定到代理商
//			Long id = rateBackwardDao.nextId()-1;//费率列表id
//			AgencyBackwardPo agencyPo = new AgencyBackwardPo();
////			agencyPo.setRateId(id);
//			agencyPo.setId(rateBackwardVo.getAgencyId());
//			agencyVODao.updateByAgencyPO(agencyPo);
//		}
//		
//		if(res > 0 ){
//			return operatorDiscountDao.disccount_addList(list);
//		}
//		
//		return 0;
//	}
	/**
	 * @description:查询登录用户是否有该费率名称(添加费率时)
	 * @param operatorDiscountPo
	 * @return 为0时费率名称合法
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:15:14
	 */
	@Override
	public int checkRateName(String rateName, Integer rootAgencyId) {
		int result = 0;
		if(StringHelper.isNotEmpty(rateName) && rootAgencyId != null)
		{
			result = operatorDiscountDao.checkRateName(rateName, rootAgencyId);
		}
		else
		{
			result = -1;
		}
		return result;
	}
	/**
	 * @description:通过条件查询费率列表（每条详细费率表）
	 * @param operatorDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 下午3:42:34
	 */
//	@Override
//	public List<OperatorDiscountPo> listDiscountByPo(
//			OperatorDiscountPo operatorDiscountPo) {
//		
//		return operatorDiscountDao.selectDiscountByPo(operatorDiscountPo);
//	}
}
