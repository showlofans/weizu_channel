package com.weizu.flowsys.web.trade.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.core.util.Formatter;
import com.weizu.flowsys.web.http.entity.PurchaseLog;
import com.weizu.flowsys.web.trade.dao.PurchaseLogDao;

@Repository(value="purchaseLogDao")
public class PurchaseLogDaoImpl extends DaoImpl<PurchaseLog, Long> implements
		PurchaseLogDao {
		

}
