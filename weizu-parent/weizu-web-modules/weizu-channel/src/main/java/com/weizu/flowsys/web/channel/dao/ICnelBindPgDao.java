package com.weizu.flowsys.web.channel.dao;

import java.util.List;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.core.dao.impl.DaoImpl;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.CnelBindPgPo;

/**
 * @description: 包体通道绑定
 * @projectName:weizu-channel
 * @className:ICnelBindPgDao.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年9月16日 上午10:50:29
 * @version 1.0
 */
public interface ICnelBindPgDao extends Dao<CnelBindPgPo, Long> {
	
	/**
	 * @description:批量绑定
	 * @param list
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月16日 上午10:50:37
	 */
	public int batchAddBind(List<CnelBindPgPo> list);
}
