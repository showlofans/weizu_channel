package com.weizu.flowsys.web.channel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.url.PlatformURL;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description:平台管理
 * @projectName:crud
 * @className:PlatformController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月5日 下午12:09:08
 * @version 1.0
 */
@Controller
@RequestMapping(value = PlatformURL.MODOE_NAME)
public class PlatformController {
	
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	
	/**
	 * @description: 平台添加
	 * @param exchangePlatformPo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午3:16:48
	 */
	@RequestMapping(value = PlatformURL.PLATFORM_ADD)
	@ResponseBody
	public String addPlatform(ExchangePlatformPo exchangePlatformPo,HttpServletResponse resonse,HttpServletRequest request)
	{
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			String result = exchangePlatformAO.addEp(exchangePlatformPo);
//			String result = exchangePlatformAO.addEp(exchangePlatformPo,agencyVO.getId(),agencyVO.getUserName());
//			try {
//					resonse.getWriter().print(result);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			return result;
		}
		return "error";
	}
	
	/**
	 * @description: 平台编辑页面
	 * @param epId
	 * @param resonse
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月26日 上午10:38:37
	 */
	@RequestMapping(value=PlatformURL.PLATFORM_EDIT_PAGE)
	public ModelAndView editPlatformPage(String epId,HttpServletResponse resonse,HttpServletRequest request){
		if(StringHelper.isNotEmpty(epId)){
			int id = Integer.parseInt(epId);
			ExchangePlatformPo epPo = exchangePlatformAO.getEpById(id);
			return new ModelAndView("/channel/platform_edit_page","exchangePlatformPo",epPo);
		}
		return new ModelAndView("/channel/platform_edit_page");
	}
	
	/**
	 * @description: 修改平台信息
	 * @param exchangePlatformPo
	 * @param resonse
	 * @param request
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月26日 上午10:23:50
	 */
	@ResponseBody
	@RequestMapping(value=PlatformURL.PLATFORM_EDIT)
	public void editPlatform(ExchangePlatformPo exchangePlatformPo,HttpServletResponse resonse,HttpServletRequest request){
		String res = exchangePlatformAO.updateEp(exchangePlatformPo);
		try {
			resonse.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@ResponseBody
	@RequestMapping(value=PlatformURL.PLATFORM_DEL)
	public void delEp(String epId,HttpServletResponse resonse){
		String res = exchangePlatformAO.delEp(epId);
		try {
			resonse.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @description: 平台列表
	 * @param exchangePlatformPo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午3:16:48
	 */
	@RequestMapping(value = PlatformURL.PLATFORM_LIST)
	public ModelAndView PlatformSearch(@RequestParam(value = "pageNo", required = false)String pageNo,ExchangePlatformPo exchangePlatformPo,HttpServletRequest request)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			PageParam pageParam = null;
			if(StringHelper.isNotEmpty(pageNo)){
				pageParam = new PageParam(Integer.parseInt(pageNo), 10);
			}else{
				pageParam = new PageParam(1, 10);
			}
			Pagination<ExchangePlatformPo> pagination = exchangePlatformAO.getEp(agencyVO.getId(), exchangePlatformPo, pageParam);
//			resultMap.put("pgInEnums", PgInServiceEnum.toList());
//			resultMap.put("pgTypeEnums", OperatorTypeEnum.toList());
//			resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
			resultMap.put("searchParam", exchangePlatformPo);
			resultMap.put("callBackEnums", CallBackEnum.toList());
			resultMap.put("pagination", pagination);
		}
		return new ModelAndView("/channel/platform_list", "resultMap", resultMap);
		
	}
	/**
	 * @description:添加平台页面
	 * @param exchangePlatformPo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午3:52:42
	 */
	@RequestMapping(value = PlatformURL.PLATFORM_ADD_PAGE)
	public ModelAndView addPlatformPage(@RequestParam(value = "pageTitle", required = false)String pageTitle)
	{
//		try {
//		Map<String,Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("", CallBackEnum.toList().)
		if(StringHelper.isNotEmpty(pageTitle)){
//				pageTitle = new String(pageTitle.getBytes("iso-8859-1"), "utf-8");
				return new ModelAndView("/channel/platform_add_page","pageTitle",pageTitle);
			}else{
				return new ModelAndView("/channel/platform_add_page");
			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * @description: CHECK_EP_ENGID
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月17日 下午3:08:41
	 */
	@RequestMapping(value = PlatformURL.CHECK_EP_ENGID)
	@ResponseBody
	public String checkEpEngId(String epEngId){
		boolean isExist = exchangePlatformAO.checkEpEngId(epEngId);
		if(isExist){
			return "exist";
		}
		return "not";
	}
}
