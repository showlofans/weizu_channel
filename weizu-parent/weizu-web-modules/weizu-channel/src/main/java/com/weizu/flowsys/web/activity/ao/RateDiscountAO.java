package com.weizu.flowsys.web.activity.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

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
}
