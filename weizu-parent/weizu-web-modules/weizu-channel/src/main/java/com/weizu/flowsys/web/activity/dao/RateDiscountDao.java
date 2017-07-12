package com.weizu.flowsys.web.activity.dao;

import java.util.List;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

public interface RateDiscountDao extends Dao<RateDiscountPo, Long> {
	
	/**
	 * @description:批量添加费率折扣
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午5:41:27
	 */
	public int rate_addList(List<RateDiscountPo> list);
	
	/**
	 * @description: 更新绑定的折扣
	 * @param activeId
	 * @param activeDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午4:18:59
	 */
	int updateRateDiscount(long activeId,double activeDiscount);
	
	/**
	 * @description: 获得所有的折扣
	 * @param rateDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午4:01:50
	 */
	List<RateDiscountPo> getRateDiscountList(RateDiscountPo rateDiscountPo);
}
