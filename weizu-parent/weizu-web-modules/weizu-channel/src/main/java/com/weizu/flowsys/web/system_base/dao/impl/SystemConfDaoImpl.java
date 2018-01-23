package com.weizu.flowsys.web.system_base.dao.impl;

import org.springframework.stereotype.Repository;

import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.system_base.dao.SystemConfDaoInterface;
import com.weizu.flowsys.web.system_base.pojo.SystemConfPo;

/**
 * @description: 系统配置
 * @projectName:weizu-channel
 * @className:SystemConfDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月23日 下午3:15:15
 * @version 1.0
 */
@Repository(value="systemConfDao")
public class SystemConfDaoImpl extends DaoImpl<SystemConfPo, Integer> implements SystemConfDaoInterface {


}
