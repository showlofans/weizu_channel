package com.weizu.flowsys.web.log.ao;

import com.weizu.flowsys.web.log.AccountEventPo;

public interface AccountEventAO {
	
	/**
	 * @description: 获得代理商最后一次登陆时的日志
	 * @param agencyId
	 * @param state
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月9日 下午2:06:14
	 */
	public AccountEventPo getLastByAgency(Integer agencyId,Integer eventType);
	
	/**
	 * @description: 更新最后一次事件状态
	 * @param agencyId
	 * @param eventType
	 * @param state
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月9日 下午2:26:29
	 */
	public int updateLastByAgency(Integer agencyId,Integer eventType,String eventKey);
}
