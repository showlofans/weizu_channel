package com.weizu.flowsys.web.system_base.ao;

import java.util.List;

import com.weizu.flowsys.web.system_base.pojo.SystemConfPo;

public interface SystemConfAO {
	
	/**
	 * @description: 根据参数获得列表
	 * @param systemConfPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月23日 下午3:26:18
	 */
	List<SystemConfPo> getConf(SystemConfPo systemConfPo);
	
	/**
	 * @description: 通过key值找到value值（主要业务层使用方法）
	 * @param confKey
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月23日 下午4:07:23
	 */
	SystemConfPo getByKey(String confKey);
}
