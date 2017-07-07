package com.weizu.flowsys.web.activity.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

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
	 * @description:代理商绑定通道
	 * @param aacp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 上午9:34:30
	 */
	int bindChannel(AgencyActiveChannelPo aacp,RateDiscountPo rateDiscountPo);
	
}
