package com.weizu.flowsys.web.activity.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;

public interface IRateBackwardDao {
	/**
	 * @description:查询费率列表
	 * @param rateBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月20日 下午2:48:13
	 */
	List<RateBackwardPo> selectByPagePo(Map<String,Object> paramsMap);
	
	
	/**
	 * @description: 查询代理商全部费率 
	 * @param rootAgencyId
	 * @param billType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月30日 上午11:58:24
	 */
	List<RateBackwardPo> selectByRootId(Integer rootAgencyId,Integer billType);
	
	/**
	 * @description:根据条件查询总记录数
	 * @param rateBackwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月20日 下午3:08:39
	 */
	int countByPo(Map<String,Object> paramsMap);
	
}
