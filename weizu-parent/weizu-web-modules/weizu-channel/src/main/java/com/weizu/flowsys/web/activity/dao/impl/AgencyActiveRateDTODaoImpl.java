package com.weizu.flowsys.web.activity.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.activity.dao.AgencyActiveRateDTODao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRateDTO;

@Repository(value="agencyActiveRateDTODao")
public class AgencyActiveRateDTODaoImpl extends DaoImpl<AgencyActiveRateDTO, Long> implements
		AgencyActiveRateDTODao {

}
