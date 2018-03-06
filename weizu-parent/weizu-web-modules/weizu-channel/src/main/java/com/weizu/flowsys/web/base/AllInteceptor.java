package com.weizu.flowsys.web.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.weizu.flowsys.operatorPg.enums.EventTypeEnum;
import com.weizu.flowsys.operatorPg.enums.LoginStateEnum;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.log.AccountEventPo;
import com.weizu.flowsys.web.log.ao.AccountEventAO;
import com.weizu.flowsys.web.log.dao.IAccountEventDao;
import com.weizu.web.foundation.DateUtil;

public class AllInteceptor implements HandlerInterceptor  {

	@Resource
	private IAccountEventDao accountEventDao;
	@Resource
	private AccountEventAO accountEventAO;
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		Object obj = request.getSession().getAttribute("loginContext");
//	    if (agencyVO == null) {
//	      //System.out.println("尚未登录，调到登录页面");
//	      response.sendRedirect("/agency/login_page");
//	      return false;
//	    }else{
		if(obj != null){
			AgencyBackwardVO agencyVO = (AgencyBackwardVO)obj;
	    	AccountEventPo accountEventPo = accountEventAO.getLastByAgency(agencyVO.getId(), EventTypeEnum.AGENCY_LOGIN.getValue());
	    	if(accountEventPo != null){
	    		Integer eventKey = Integer.parseInt(accountEventPo.getEventKey() == null? "0":accountEventPo.getEventKey());
	    		if(accountEventPo!= null&& LoginStateEnum.ED.getValue().equals(eventKey)) {
//	        	agencyVO.setUserPass("");
//	        	request.getSession().setAttribute("loginContext", agencyVO);
	    			request.getSession().removeAttribute("loginContext");
	    			//response.getWriter().print("请先登陆");
//	    			HttpSession session = request.getSession();
//	    			session.setAttribute("errorMsg", "您已在其他地方已退出登陆");
//	    			session.setAttribute("loginIpAddress", accountEventPo.getEventLocation());
//	    			session.setAttribute("loginTime", accountEventPo.getEventTime()==null?System.currentTimeMillis():DateUtil.formatAll(accountEventPo.getEventTime()));
	    			//response.sendRedirect("/WEB-INF/jsp/error");
	    			return true;
	    		}
	    	}else{
	    		return true;
	    	}
	    }
		    return true;//登陆请求
		
//		int port = arg0.getLocalPort();
//		if(port == 8082){
//			arg0.getSession().setAttribute("portNum", 382);
//		}else{
//			arg0.getSession().setAttribute("portNum", 381);
//		}
	}


}
