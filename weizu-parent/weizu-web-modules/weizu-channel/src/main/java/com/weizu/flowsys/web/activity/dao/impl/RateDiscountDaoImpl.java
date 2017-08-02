package com.weizu.flowsys.web.activity.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

/**
 * @description: 费率折扣Dao层实现
 * @projectName:weizu-channel
 * @className:RateDiscountDaoImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月7日 上午9:36:25
 * @version 1.0
 */
@Repository(value="rateDiscountDao")
public class RateDiscountDaoImpl extends DaoImpl<RateDiscountPo, Long> implements
		RateDiscountDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @description: 批量添加费率折扣
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午5:43:20
	 */
	@Override
	public int rate_addList(List<RateDiscountPo> list) {
		return sqlSessionTemplate.insert("rate_addList", list);
	}

	/**
	 * @description: 更新绑定的折扣
	 * @param activeId
	 * @param activeDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午4:19:19
	 */
	@Override
	public int updateRateDiscount(long activeId, double activeDiscount) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("id", activeId);
		paramsMap.put("activeDiscount", activeDiscount);
		return sqlSessionTemplate.update("updateRateDiscount", paramsMap);
	}

	/**
	 * @description: 获得所有的折扣
	 * @param rateDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午4:02:37
	 */
	@Override
	public List<RateDiscountPo> getRateDiscountList(
			RateDiscountPo rateDiscountPo) {
		return sqlSessionTemplate.selectList("getRateDiscountList",rateDiscountPo);
	}

	/**
	 * @description:  获得费率折扣列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午10:34:01
	 */
	@Override
	public List<RateDiscountPo> getDiscountList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @description: 费率列表长度
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午10:34:11
	 */
	@Override
	public Long countDiscountList(Map<String, Object> params) {
		
		return sqlSessionTemplate.selectOne("countDiscountList", params);
	}

	/**
	 * @description:  获得所有费率的地区
	 * @param rateDiscountPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 下午1:30:48
	 */
//	@Override
//	public List<String> getDistinctScope(RateDiscountPo rateDiscountPo) {
//		
//		return sqlSessionTemplate.selectList("getDistinctScope",rateDiscountPo);
//	}

	/**
	 * @description:  通过通道折扣id
	 * @param channelDiscountId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月14日 下午6:24:54
	 */
	@Override
	public List<RateDiscountPo> getListByCDiscountId(Long channelDiscountId,Integer billTypeRate) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("channelDiscountId", channelDiscountId);
		paramsMap.put("billTypeRate", billTypeRate);
		
		return sqlSessionTemplate.selectList("getListByCDiscountId",paramsMap);
	}

	/**
	 * @description: 获得首页折扣信息
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月19日 下午12:05:52
	 */
	@Override
	public List<RateDiscountPo> getShowRate(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("getShowRate", params);
	}
	
	/**
	 * @description:  获得充值的折扣 
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 上午11:34:40
	 */
	@Override
	public RateDiscountPo getRateForCharge(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("getRateForCharge", params);
	}

	/**
	 * @description: 费率配置列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月28日 下午5:46:00
	 */
	@Override
	public List<RateDiscountPo> getMyRate(Map<String, Object> params) {
		
		return sqlSessionTemplate.selectList("getMyRate", params);
	}

	/**
	 * @description: 费率配置列表长度
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月28日 下午5:48:47
	 */
	@Override
	public int countMyRate(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("countMyRate", params);
	}

	/**
	 * @description: 获得子费率列表
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午6:23:44
	 */
	@Override
	public List<RateDiscountPo> getMyChildRate(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("getMyChildRate", params);
	}

}
