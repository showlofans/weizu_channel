package com.weizu.flowsys.web.activity.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

import crud.aotest.RateAOTest;

public interface AgencyActiveChannelAO {
	
	/**
	 * @description:查询代理商参与的活动通道
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:15:57
	 */
	Pagination<AgencyActiveChannelPo> listActive(PageParam pageParam,AgencyActiveChannelPo activePo);
	
	/**
	 * @description: 查询分页费率列表
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午11:00:30
	 */
	Pagination<AgencyActiveChannelPo> listActiveRate(PageParam pageParam,AgencyActiveChannelPo activePo);
	
	/**
	 * @description:  查询分页费率列表
	 * @param pageParam
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午11:22:20
	 */
	Pagination<AgencyActiveChannelPo> listActiveRate(PageParam pageParam,RateDiscountPo ratePo);
	
	
	/**
	 * @description: 查询代理商参与的活动通道(不分页)
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 下午7:10:11
	 */
	List<AgencyActiveChannelPo> listActiveDiscount(PageParam pageParam,AgencyActiveChannelPo activePo);

	/**
	 * @description: 通过实体封装参数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:16:28
	 */
	Map<String,Object> getMapByEntity(AgencyActiveChannelPo activePo);
	
	/**
	 * @description: 通过实体封装参数
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午11:22:47
	 */
	Map<String,Object> getMapByEntity(RateDiscountPo ratePo);
	
	/**
	 * @description:代理商绑定通道
	 * @param aacp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 上午9:34:30
	 */
	int bindChannel(AgencyActiveChannelPo aacp,RateDiscountPo rateDiscountPo);
	
	/**
	 * @description: 更新绑定状态
	 * @param activeId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 上午11:58:34
	 */
	int updateBindState(String activeId,String bindState);
	
	/**
	 * @description: 更新绑定的折扣
	 * @param activeId
	 * @param activeDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午4:16:06
	 */
	int updateRateDiscount(String activeId,String activeDiscount);
	
}
