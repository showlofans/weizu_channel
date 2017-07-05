package com.weizu.flowsys.web.activity.ao;

import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;

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
	 * @description: 通过实体封装参数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:16:28
	 */
	Map<String,Object> getMapByEntity(AgencyActiveChannelPo activePo);
	
}
