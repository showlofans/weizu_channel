package com.weizu.flowsys.web.channel.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.channel.dao.ICitiesDAO;
import com.weizu.flowsys.web.channel.pojo.Cities;

@Repository(value="citiesDao")
public class CitiesDAOImpl extends DaoImpl<Cities, Integer> implements ICitiesDAO {

	

}
