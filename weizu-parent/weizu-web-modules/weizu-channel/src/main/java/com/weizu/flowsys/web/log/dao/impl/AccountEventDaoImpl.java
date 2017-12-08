package com.weizu.flowsys.web.log.dao.impl;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.log.AccountEventPo;
import com.weizu.flowsys.web.log.dao.IAccountEventDao;

@Repository(value="accountEventDao")
public class AccountEventDaoImpl extends DaoImpl<AccountEventPo, Long> implements
		IAccountEventDao {


}
