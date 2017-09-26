package com.weizu.flowsys.web.activity.dao.impl;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.activity.dao.AgencyActiveRateDTODao;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;

@Repository(value="agencyActiveRateDTODao")
public class AgencyActiveRateDTODaoImpl extends DaoImpl<AccountActiveRateDTO, Long> implements
		AgencyActiveRateDTODao {

}
