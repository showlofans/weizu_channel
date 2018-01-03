package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.agency.pojo.CompanyReferencePo;

public interface CompanyReferenceDao extends Dao<CompanyReferencePo, Integer> {
	
	/**
	 * @description: 根据条件查询客户基本信息列表
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月3日 下午3:16:37
	 */
	public List<CompanyReferencePo> listCRM(Map<String,Object> params);
	
	/**
	 * @description: 根据条件查询客户基本信息总数
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月3日 下午3:17:02
	 */
	public int countCRM(Map<String,Object> params);
}
