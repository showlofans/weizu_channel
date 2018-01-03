package com.weizu.flowsys.web.agency.ao;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.CompanyReferencePo;

public interface CompanyReferenceAO {
	/**
	 * @description: 查询分页列表
	 * @param companyReferencePo
	 * @param pageParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月3日 下午2:56:42
	 */
	Pagination<CompanyReferencePo> list(CompanyReferencePo companyReferencePo, PageParam pageParam);
}
