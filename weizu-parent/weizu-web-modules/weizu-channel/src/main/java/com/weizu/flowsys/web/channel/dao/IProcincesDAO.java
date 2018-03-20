package com.weizu.flowsys.web.channel.dao;

import java.util.List;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.Provinces;

public interface IProcincesDAO extends Dao<Provinces, Integer> {
	
	/**
	 * @description: 获得所有城市列表
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月9日 下午5:41:05
	 */
	List<Provinces> getProvinces();
	
}	
