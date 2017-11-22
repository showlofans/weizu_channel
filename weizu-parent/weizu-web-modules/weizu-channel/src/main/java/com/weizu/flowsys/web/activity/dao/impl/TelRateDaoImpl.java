package com.weizu.flowsys.web.activity.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;

/**
 * @description: 话费折扣Dao
 * @projectName:weizu-channel
 * @className:TelRateDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午3:26:34
 * @version 1.0
 */
@Repository(value="telRateDao")
public class TelRateDaoImpl extends DaoImpl<TelRatePo, Long> implements ITelRateDao {

	@Override
	public List<TelRatePo> listByTelRatePo(TelRatePo telRatePo) {
		WherePrams where = new WherePrams("1", "=", "1");
		if(telRatePo.getTelchannelId() != null){
			where.and("telchannel_id", "=", telRatePo.getTelchannelId());
		}
		if(telRatePo.getBillType() != null){
			where.and("bill_type", "=", telRatePo.getBillType());
		}
		if(telRatePo.getRateFor() != null){
			where.and("rate_for", "=", telRatePo.getRateFor());
		}
		return list(where);
	}


}
