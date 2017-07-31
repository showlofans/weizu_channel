package com.weizu.flowsys.web.activity.dao;

import java.util.List;
import java.util.Map;

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
	
	
	
	/**
	 * @description: 通过通道折扣查询简易折扣列表
	 * @param channelDiscountId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月14日 下午5:54:50
	 */
	List<RateDiscountPo> getListByCDiscountId(Long channelDiscountId, Integer billTypeRate);
	
	/**
	 * @description: 获得费率折扣列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午10:32:43
	 */
	List<RateDiscountPo> getDiscountList(Map<String, Object> params);
	
	/**
	 * @description: 费率列表长度
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午10:33:33
	 */
	Long countDiscountList(Map<String, Object> params);
	
	/**
	 * @description: 获得首页折扣信息
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月19日 下午12:05:15
	 */
	List<RateDiscountPo> getShowRate (Map<String, Object> params);
	
	/**
	 * @description: 费率配置列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月28日 下午5:45:31
	 */
	List<RateDiscountPo> getMyRate (Map<String, Object> params);
	
	/**
	 * @description: 费率配置列表长度
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月28日 下午5:48:13
	 */
	int countMyRate(Map<String, Object> params);
	
	/**
	 * @description: 获得子费率列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午6:23:23
	 */
	List<RateDiscountPo>getMyChildRate(Map<String, Object> params);
	
	/**
	 * @description: 获得所有费率的地区
	 * @param rateDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 下午1:30:03
	 */
//	List<String> getDistinctScope(RateDiscountPo rateDiscountPo);
	
}
