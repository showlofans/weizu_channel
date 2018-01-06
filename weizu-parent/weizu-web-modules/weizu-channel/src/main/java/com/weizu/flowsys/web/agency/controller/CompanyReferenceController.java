package com.weizu.flowsys.web.agency.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.AgencyForwardEnum;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BusinessOneEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.CrmPlatformTagEnum;
import com.weizu.flowsys.operatorPg.enums.LimitPriceEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.ao.CompanyReferenceAO;
import com.weizu.flowsys.web.agency.dao.CompanyReferenceDao;
import com.weizu.flowsys.web.agency.pojo.CompanyReferencePo;
import com.weizu.flowsys.web.agency.url.CRMURL;

/**
 * @description: 客户基本信息模块
 * @projectName:weizu-channel
 * @className:CompanyReferenceController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月3日 下午2:23:20
 * @version 1.0
 */
@Controller
@RequestMapping(value=CRMURL.MODOE_NAME)
public class CompanyReferenceController {
	@Resource
	private CompanyReferenceDao companyReferenceDao;
	@Resource
	private CompanyReferenceAO companyReferenceAO;
	
	/**
	 * @description: 客户基本信息添加页面
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月3日 下午2:34:10
	 */
	@RequestMapping(value=CRMURL.CRM_ADD_PAGE)
	public ModelAndView crmAddPage(HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("agencyTagEnums", AgencyTagEnum.toList());//
//		resultMap.put("crmPlatformTagEnums", CrmPlatformTagEnum.toList());//是否已对接
		return new ModelAndView("/agency/crm_add_page", "resultMap", resultMap);
	}
	
	/**
	 * @description: 添加客户基本信息
	 * @param request
	 * @param companyReferencePo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:15:49
	 */
	@ResponseBody
	@Transactional
	@RequestMapping(value=CRMURL.CRM_ADD)
	public String crmAdd(HttpServletRequest request,CompanyReferencePo companyReferencePo){
		companyReferencePo.setLastAccess(System.currentTimeMillis());
		if(companyReferencePo.getCrmPlatformTag() == null){
			companyReferencePo.setCrmPlatformTag(CrmPlatformTagEnum.PLATFORM_USER.getValue());
		}
		int res = companyReferenceDao.add(companyReferencePo);
		String result = "error";
		if(res > 0){
			result = "success";
		}
		return result;
	}
	/**
	 * @description:客户基本信息编辑页面
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 上午10:18:30
	 */
	@RequestMapping(value=CRMURL.CRM_EDIT_PAGE)
	public ModelAndView crmEditPage(HttpServletRequest request,Integer id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		CompanyReferencePo companyReferencePo = companyReferenceDao.get(id);
		resultMap.put("companyReferencePo", companyReferencePo);
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("limitPriceEnums", LimitPriceEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("businessOneEnums", BusinessOneEnum.toList());
		return new ModelAndView("/agency/crm_add_page", "resultMap", resultMap);
	}
	/**
	 * @description: 客户信息编辑页面 
	 * @param request
	 * @param id
	 * @param agencyForward
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月6日 下午3:38:37
	 */
	@RequestMapping(value=CRMURL.CRM_INFO_EDIT_PAGE)
	public ModelAndView crmInfoEditPage(HttpServletRequest request,Integer id,Integer agencyForward){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		CompanyReferencePo companyReferencePo = companyReferenceDao.get(id);
		resultMap.put("companyReferencePo", companyReferencePo);//id 描述
		
		resultMap.put("agencyForward", agencyForward);
//		resultMap.put("AgencyForwardEnum", AgencyForwardEnum.toList());
		return new ModelAndView("/agency/crm_info_edit_page", "resultMap", resultMap);
	}
	
	/**
	 * @description: 客户基本信息更新
	 * @param request
	 * @param companyReferencePo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月3日 下午2:32:37
	 */
	@ResponseBody
	@RequestMapping(value=CRMURL.CRM_EDIT)
	public String crmEdit(HttpServletRequest request,CompanyReferencePo companyReferencePo){//,@RequestParam(value="agencyForward",required=false)Integer agencyForward
		companyReferencePo.setLastAccess(System.currentTimeMillis());
		int res = companyReferenceDao.updateLocal(companyReferencePo);
		String result = "error";
			result = "success";
			if(res > 0){
		}
		return result;
	}
	
	/**
	 * @description: 删除客户基本信息
	 * @param request
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月3日 下午2:32:49
	 */
	@ResponseBody
	@RequestMapping(value=CRMURL.DEL_CRM)
	public String delCRM(HttpServletRequest request,Integer id){
		int res = companyReferenceDao.del(id);
		String result = "error";
		if(res > 0){
			result = "success";
		}
		return result;
	}
	/**
	 * @description: 更新客户基本信息维护状态
	 * @param request
	 * @param id
	 * @param crmState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月2日 下午4:46:38
	 */
//	@Transactional
//	@ResponseBody
//	@RequestMapping(value=CRMURL.UPDATE_CRM_STATE)
//	public String updateShowRate(HttpServletRequest request,Long id, Integer crmState){
//		int res = companyReferenceDao.updateLocal(new ChannelForShowPo(id, crmState,System.currentTimeMillis()));
//		String result = "error";
//		if(res > 0){
//			result = "success";
//		}
//		return result;
//	}
	
	/**
	 * @description: 客户基本信息列表
	 * @param companyReferencePo
	 * @param showModel
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月3日 下午2:33:06
	 */
	@RequestMapping(value=CRMURL.CRM_LIST)
	public ModelAndView listCRM(CompanyReferencePo companyReferencePo,@RequestParam(value="pageNo",required=false)Integer pageNo){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		PageParam pageParam = null;
		if(pageNo == null){
			pageParam = new PageParam(1, 10);
		}else{
			pageParam = new PageParam(pageNo, 10);
		}
		Pagination<CompanyReferencePo> pagination = companyReferenceAO.list(companyReferencePo, pageParam);
		resultMap.put("pagination", pagination);
		resultMap.put("params", companyReferencePo);
		resultMap.put("crmPlatformTagEnums", CrmPlatformTagEnum.toList());//是否已对接
		return new ModelAndView("/agency/crm_list", "resultMap", resultMap);
	}
}
