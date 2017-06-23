package com.weizu.flowsys.web.activity.ao;

import java.util.List;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;

public interface RateBackwardAO {
	
	/**
	 * @description:添加费率
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午5:21:44
	 */
	int addRateBackward(RateBackwardPo ratePo);
	
	/**
	 * @description:查询费率列表 
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:31:20
	 */
	Pagination<RateBackwardPo> selectByPo(RateBackwardPo rateBackwardPo,PageParam pageParam);
	
	/**
	 * @description:查询全部费率列表
	 * @param rootAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 上午10:53:28
	 */
	List<RateBackwardPo> selectByRootId(Integer rootAgencyId);
	
	/**
	 * @description:通过id获得费率列表
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 下午1:05:50
	 */
	RateBackwardPo getByPoId(Long id);

}
