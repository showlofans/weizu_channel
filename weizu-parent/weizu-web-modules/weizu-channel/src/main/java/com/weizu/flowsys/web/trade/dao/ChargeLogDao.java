package com.weizu.flowsys.web.trade.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;

public interface ChargeLogDao extends Dao<ChargeLog, Long> {
	
	Long countChargeLog(Map<String,Object> params);
	
	List<ChargeLog> listChargeLog(Map<String,Object> params);
}
