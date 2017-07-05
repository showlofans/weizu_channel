package com.weizu.flowsys.web.activity.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;

public interface AgencyActiveChannelDao extends Dao<AgencyActiveChannelPo, Long> {
	

	/**
	 * @description: 查询代理商参与的活动通道
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:08:23
	 */
	List<AgencyActiveChannelPo> listActive(Map<String, Object> paramsMap);
	
	/**
	 * @description: 根据参数获得总记录数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:11:41
	 */
	int countActive(AgencyActiveChannelPo activePo);
}
