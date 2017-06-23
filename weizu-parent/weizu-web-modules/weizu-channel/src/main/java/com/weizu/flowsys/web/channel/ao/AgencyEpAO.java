package com.weizu.flowsys.web.channel.ao;

import java.util.List;

import com.weizu.flowsys.web.channel.pojo.AgencyEpPo;

/**
 * @description:代理商平台连接管理AO
 * @projectName:crud
 * @className:AgencyEpAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 下午1:22:51
 * @version 1.0
 */
public interface AgencyEpAO {
	/**
	 * @description:通过代理商ID获得所有平台列表
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午1:14:32
	 */
	List<AgencyEpPo> getAgencyEpByAgencyId(int agencyId);
}
