package com.weizu.flowsys.web.log.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.LoginStateEnum;
import com.weizu.flowsys.web.log.AccountEventPo;
import com.weizu.flowsys.web.log.dao.IAccountEventDao;

@Service(value="accountEventAO")
public class AccountEventAOImpl implements AccountEventAO {

	@Resource
	private IAccountEventDao accountEventDao;
	@Override
	public AccountEventPo getLastByAgency(Integer agencyId,Integer eventType) {
		//得到上一次的登陆日志
		WherePrams where = new WherePrams("agency_id", "=", agencyId).and("event_type", "=", eventType);
		where.orderBy("event_time",WherePrams.DESC);
		where.limit(0, 1);
		AccountEventPo eventPo = accountEventDao.get(where);
		return eventPo;
	}
	@Transactional
	@Override
	public int updateLastByAgency(Integer agencyId, Integer eventType,
			String eventKey) {
		WherePrams where = new WherePrams("agency_id", "=", agencyId).and("event_type", "=", eventType);
		where.orderBy("event_time",WherePrams.DESC);
		where.limit(1);
		AccountEventPo eventPo = new AccountEventPo();
		eventPo.setEventKey(eventKey);
		int res = accountEventDao.updateLocal(eventPo, where);
		return res;
	}

}
