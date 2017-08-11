package com.weizu.flowsys.web.activity.dao.impl;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.web.activity.dao.AgencyActiveRateDTODao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRateDTO;
import com.weizu.web.foundation.core.dao.impl.DaoImpl;

@Repository(value="agencyActiveRateDTODao")
public class AgencyActiveRateDTODaoImpl extends DaoImpl<AgencyActiveRateDTO, Long> implements
		AgencyActiveRateDTODao {

}
