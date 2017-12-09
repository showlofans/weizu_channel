package com.weizu.flowsys.web.agency.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.url.AgencyURL;

@Controller
public class IndexController {
	/**
	 * @description: 首页控制
	 * <br>跳转到首页还有一种方法，就是session中已登录直接从首页跳转到首页
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月9日 上午9:36:22
	 */
	@RequestMapping(value=AgencyURL.INDEX)
	public String goIndex(HttpServletRequest request) {
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo == null){
			return "/agency/login_page";
		}
		return "index";
	}
}
