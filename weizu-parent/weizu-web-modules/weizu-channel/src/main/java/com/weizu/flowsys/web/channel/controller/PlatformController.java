package com.weizu.flowsys.web.channel.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.url.PlatformURL;

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
	public void addPlatform(ExchangePlatformPo exchangePlatformPo,HttpServletResponse resonse,HttpServletRequest request)
	{
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO != null){
			String result = exchangePlatformAO.addEp(exchangePlatformPo,agencyVO.getId(),agencyVO.getUserName());
			try {
					resonse.getWriter().print(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
}
