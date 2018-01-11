package com.weizu.flowsys.web.trade.dao.impl;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.http.entity.ChargeLog;
import com.weizu.flowsys.web.trade.dao.ChargeLogDao;

/**
 * @description: 提单日志数据库操作
 * @projectName:weizu-channel
 * @className:ChargeLogDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月11日 下午3:21:28
 * @version 1.0
 */
@Repository(value="chargeLogDao")
public class ChargeLogDaoImpl extends DaoImpl<ChargeLog, Long> implements
		ChargeLogDao {

}
