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

	

}
