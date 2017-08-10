package com.weizu.flowsys.web.activity.dao;

import java.util.List;

import org.weizu.web.foundation.core.dao.Dao;

import com.weizu.flowsys.web.activity.pojo.AacJoinRdPo;

public interface AacJoinRdDao extends Dao<AacJoinRdPo, Long> {
	
	/**
	 * @description: 批量添加
	 * @param addList
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 下午2:01:08
	 */
	int aac_addList(List<AacJoinRdPo> addList);
}
