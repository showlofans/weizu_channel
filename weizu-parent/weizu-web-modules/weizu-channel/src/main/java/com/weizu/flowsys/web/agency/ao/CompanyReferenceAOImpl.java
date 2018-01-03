package com.weizu.flowsys.web.agency.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.dao.CompanyReferenceDao;
import com.weizu.flowsys.web.agency.pojo.CompanyReferencePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 客户基本信息AO层
 * @projectName:weizu-channel
 * @className:CompanyReferenceAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月3日 下午2:57:48
 * @version 1.0
 */
@Service(value="companyReferenceAO")
public class CompanyReferenceAOImpl implements CompanyReferenceAO {

	@Resource
	private CompanyReferenceDao companyReferenceDao;
	
	@Override
	public Pagination<CompanyReferencePo> list(
			CompanyReferencePo companyReferencePo, PageParam pageParam) {
		Map<String,Object> params = getMapByPo(companyReferencePo);
		
		int totalRecord = companyReferenceDao.countCRM(params);
		int pageSize = 0;
		int pageNo = 0;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			params.put("start", (pageNo-1)*pageSize);
			params.put("end", pageSize);
		}
		List<CompanyReferencePo> crmList = companyReferenceDao.listCRM(params);
		for (CompanyReferencePo companyReferencePo2 : crmList) {
			String lastAccessStr = DateUtil.format(companyReferencePo2.getLastAccess());
			companyReferencePo2.setLastAccessStr(lastAccessStr);
		}
		
		return new Pagination<CompanyReferencePo>(crmList, totalRecord, pageNo, pageSize);
	}
	
	private Map<String,Object> getMapByPo(CompanyReferencePo companyReferencePo){
		Map<String,Object> params = new HashMap<String,Object>();
		if(StringHelper.isNotEmpty(companyReferencePo.getCrmName())){
			params.put("crmName", companyReferencePo.getCrmName());
		}
		if(StringHelper.isNotEmpty(companyReferencePo.getCrmGroupMark())){
			params.put("crmGroupMark", companyReferencePo.getCrmGroupMark());
		}
		if(companyReferencePo.getCrmPlatformTag() != null){
			params.put("crmPlatformTag", companyReferencePo.getCrmPlatformTag());
		}
		
		return params;
	}

}
