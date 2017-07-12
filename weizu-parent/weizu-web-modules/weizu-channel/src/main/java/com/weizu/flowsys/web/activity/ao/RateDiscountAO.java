package com.weizu.flowsys.web.activity.ao;

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
}
