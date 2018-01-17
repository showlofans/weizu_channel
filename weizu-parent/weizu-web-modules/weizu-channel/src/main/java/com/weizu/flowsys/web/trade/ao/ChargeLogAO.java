package com.weizu.flowsys.web.trade.ao;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.CompanyReferencePo;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;

public interface ChargeLogAO {
	
	/**
	 * @description: 查询分页日志
	 * @param chargeLog
	 * @param pageParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月13日 下午2:02:49
	 */
	Pagination<ChargeLog> list(ChargeLog chargeLog, PageParam pageParam, Integer isException);
	
	/**
	 * @description: 根据条件删除冲单日志
	 * @param chargeLog
	 * @param isException
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月13日 下午4:19:17
	 */
	String delChargeLog(ChargeLog chargeLog, Integer isException);
}
