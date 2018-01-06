package com.weizu.flowsys.web.agency.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weizu.flowsys.operatorPg.enums.ConfirmStateEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateTransferEnum;
import com.weizu.flowsys.util.MessageTool;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;
import com.weizu.flowsys.web.agency.pojo.TransferMsgVo;
import com.weizu.flowsys.web.agency.url.AgencyURL;

@Controller
public class IndexController {
	@Resource
	private MessageTool messageTool;
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
		HttpSession session = request.getSession();
		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVo == null){
			return "/agency/login_page";
		}
		///**设置消息*/
		messageTool.setMsg(agencyVo.getId(), session);
		return "index";
	}
}
