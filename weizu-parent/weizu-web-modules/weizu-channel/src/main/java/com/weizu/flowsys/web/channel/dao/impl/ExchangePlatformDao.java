package com.weizu.flowsys.web.channel.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

@Repository(value="exchangePlatformDao")
public class ExchangePlatformDao extends DaoImpl<ExchangePlatformPo, Integer> implements ExchangePlatformDaoInterface {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * @description:通过平台名查找平台对象
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:51:24
	 */
	@Override
	public ExchangePlatformPo getEpByEpName(@Param("epName")String epName) {
		
		return sqlSessionTemplate.selectOne("getEpByEpName", epName);
	}
	/**
	 * @description:获得所有平台名称
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午12:57:52
	 */
	@Override
	public List<ExchangePlatformPo> getSimpleEp() {
		
		return sqlSessionTemplate.selectList("getSimpleEp");
	}
	/**
	 * @description: 获得所有平台
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午4:12:25
	 */
	@Override
	public List<ExchangePlatformPo> getEp(Map<String, Object> paramsMap) {
		
		return sqlSessionTemplate.selectList("getEp",paramsMap);
	}
	/**
	 * @description:获得所有平台总记录数
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午4:21:34
	 */
	@Override
	public int countEp(Map<String, Object> paramsMap) {
		return sqlSessionTemplate.selectOne("countEp",paramsMap);
	}
//	@Override
//	public ExchangePlatformPo getEpByRateId(Long rateId) {
//		return sqlSessionTemplate.selectOne("getEpByRateId", rateId);
//	}
	@Override
	public ExchangePlatformPo getEpByCDiscountId(Long CDiscountId) {
		return sqlSessionTemplate.selectOne("getEpByCDiscountId", CDiscountId);
	}
	@Override
	public ExchangePlatformPo getEpByTelchannelId(Long telchannelId) {
		return sqlSessionTemplate.selectOne("getEpByTelchannelId", telchannelId);
	}

}
