package com.weizu.flowsys.web.activity.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountShowDTO;

public interface RateDiscountAO {
	/**
	 * @description: 获得费率列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午5:20:46
	 */
	Pagination<RateDiscountPo> getRateList(RateDiscountPo ratePo,PageParam pageParam);
	
	/**
	 * @description:获得我的费率列表
	 * @param ratePo
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月28日 下午5:53:00
	 */
	Pagination<RateDiscountPo> getMyRateList(RateDiscountPo ratePo,Integer childAgencyId,PageParam pageParam);
	
	
	
	/**
	 * @description: 获得费率总数
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午5:21:12
	 */
	int countRateList(RateDiscountPo ratePo);
	
	/**
	 * @description: 通过折扣初始化地区折扣列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午9:48:20
	 */
	List<RateDiscountPo> getOperatorList(RateDiscountPo ratePo);
	
	/**
	 * @description: 通过折扣初始化地区折扣列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 下午12:58:33
	 */
	Map<String,Object> getOperatorListRate(RateDiscountPo ratePo);
	
	Map<String,Object> getMapByEntity(RateDiscountPo ratePo);
	
	/**
	 * @description: 添加费率折扣
	 * @param ratePo
	 * @return success,error
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午11:24:03
	 */
	String addRateDiscount(RateDiscountPo ratePo);
	
	/**
	 * @description: 添加费率折扣
	 * @param ratePo
	 * @param agencyName
	 * @param bindAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午3:19:33
	 */
	String addRateDiscount(RateDiscountPo ratePo,String agencyName,Integer bindAgencyId);
	
	/**
	 * @description: 修改费率折扣
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午1:58:08
	 */
	String editBindRate(RateDiscountPo ratePo);
	
	/**
	 * @description:更新下级费率折扣
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午3:32:12
	 */
	String updateRateDiscount(RateDiscountPo ratePo);
	
	/**
	 * @description: 获得首页折扣信息
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月19日 下午12:05:15
	 */
	Map<String,Object> getShowRate (Integer agencyId);
}
