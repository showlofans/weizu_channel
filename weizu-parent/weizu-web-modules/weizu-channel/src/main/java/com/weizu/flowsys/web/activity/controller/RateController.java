package com.weizu.flowsys.web.activity.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.RateStateEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.AgencyActiveChannelAO;
import com.weizu.flowsys.web.activity.ao.OperatorDiscountAO;
import com.weizu.flowsys.web.activity.ao.RateBackwardAO;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardVo;
import com.weizu.flowsys.web.activity.pojo.RateJoinChannelPo;
import com.weizu.flowsys.web.activity.url.RateURL;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.ChannelChannelAO;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;

/**
 * @description:费率管理
 * @projectName:crud
 * @className:RateController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月5日 上午10:52:59
 * @version 1.0
 */
@Controller
@RequestMapping(value = RateURL.MODOE_NAME)
public class RateController {
	
	@Resource
	private OperatorDiscountAO operatorDiscountAO;
	@Resource
	private RateBackwardAO rateBackwardAO;
	@Resource
	private ChannelChannelAO channelChannelAO;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private AgencyActiveChannelAO agencyActiveChannelAO;
	
	/**
	 * @description:跳转到费率添加页面
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @throws UnsupportedEncodingException 
	 * @createTime:2017年5月17日 下午12:19:11
	 */
	@RequestMapping(value= RateURL.RATE_ADD_PAGE)
	public ModelAndView rateAddPage(HttpServletRequest request,@RequestParam(value="agencyId", required = false)String agencyId,@RequestParam(value="rateId", required = false)String rateId) throws UnsupportedEncodingException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		ChargeAccountPo chargeAccount = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
		if(chargeAccount != null){
			if(chargeAccount.getBillType() != null &&  chargeAccount.getBillType() == 1)
			{
				resultMap.put("billTypes", BillTypeEnum.toList());
			}else{
				resultMap.put("billType", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
			}
		}
		
		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
		resultMap.put("scopeCityNames", ScopeCityEnum.toList());
		if (rateId != null) {
//			AgencyBackwardPo agencyPo = agencyAO.getAgencyById();
//			RateBackwardPo ratePo = rateBackwardAO.getByPoId(Long.parseLong(rateId));
//			resultMap.put("ratePo", ratePo);
			OperatorDiscountPo opo = new OperatorDiscountPo();
			opo.setRateId(Long.parseLong(rateId));
			List<OperatorDiscountPo> list = operatorDiscountAO.listDiscountByPo(opo);
//			for (OperatorDiscountPo operatorDiscountPo : list) {//设置编码
//				for (Map<String,Object> map : OperatorTypeEnum.toList()) {
//					if(operatorDiscountPo.getOperatorType()==Integer.parseInt(map.get("value").toString())){
//						String operatorName = map.get("desc").toString();
//						operatorDiscountPo.setOperatorScope(operatorName + operatorDiscountPo.getScopeName());
//					}
//				}
//			}
			resultMap.put("discountList", list);
			resultMap.put("agencyId", agencyId);
			
//			OperatorScopeVO osv = new OperatorScopeVO();
//			osv.set
//			ServiceScopePo ssp = new ServiceScopePo(id, scopeCityCode, serviceType, operatorType, operatorName, scopeCityName)
			
		}
		
//		String rateName = agencyPo.getRateName();
//		String userName = agencyPo.getUserName();
//		rateName = new String(rateName.getBytes("iso-8859-1"), "utf-8");
//		userName = new String(userName.getBytes("iso-8859-1"), "utf-8");
//		agencyPo.setRateName(rateName);
//		agencyPo.setUserName(userName);
		//resultMap.put("serviceTypes", ServiceTypeEnum.toList());
		
		return new ModelAndView("/rate/rate_add_page", "resultMap", resultMap);
	}
	/**
	 * @description:跳转到费率编辑页面
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @throws UnsupportedEncodingException 
	 * @createTime:2017年5月17日 下午12:19:11
	 */
	@RequestMapping(value= RateURL.RATE_EDIT_PAGE)
	public ModelAndView rateEditPage(HttpServletRequest request,@RequestParam(value="rateId", required = false)String rateId) throws UnsupportedEncodingException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
		resultMap.put("scopeCityNames", ScopeCityEnum.toList());
		if (rateId != null) {
			OperatorDiscountPo opo = new OperatorDiscountPo();
			opo.setRateId(Long.parseLong(rateId));
			List<OperatorDiscountPo> list = operatorDiscountAO.listDiscountByPo(opo);
			
			for (OperatorDiscountPo operatorDiscountPo : list) {//设置编码
				operatorDiscountPo.setScopeCityNames( ScopeCityEnum.toList());
//				for (Map<String,Object> map : OperatorTypeEnum.toList()) {
//					if(operatorDiscountPo.getOperatorType()==Integer.parseInt(map.get("value").toString())){
//						String operatorName = map.get("desc").toString();
//						operatorDiscountPo.setOperatorScope(operatorName + operatorDiscountPo.getScopeName());
//					}
//				}
			}
			resultMap.put("discountList", list);
			resultMap.put("rateId", rateId);
		}
		
		return new ModelAndView("/rate/rate_edit_page", "resultMap", resultMap);
	}
	
	/**
	 * @description:添加费率
	 * @param id 代理商id
	 * @param request
	 * @param rateBackwardPo
	 * @param response
	 * @return
	 * @throws IOException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月27日 上午9:47:51
	 */
	@RequestMapping(value= RateURL.RATE_ADD)
	@ResponseBody
	public ModelAndView rateAdd(HttpServletRequest request, RateBackwardVo rateBackwardVo,HttpServletResponse response) throws IOException{
		AgencyBackwardVO vo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(vo == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		int result =  operatorDiscountAO.disccount_addList(rateBackwardVo, vo.getId());
		
		if(result > 0){
//			response.getWriter().print("success");
			return selectByPo(request, null, null);
		}
		return null;
	}
	/**
	 * @description:异步验证费率名称是否存在
	 * @param request
	 * @param rateName
	 * @param response
	 * @throws IOException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月5日 上午10:50:53
	 */
	@RequestMapping(value = RateURL.CHECK_RATE_NAME)
	@ResponseBody
	public void checkRateName(HttpServletRequest request, String rateName,HttpServletResponse response) throws IOException{
		AgencyBackwardVO vo  = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		rateName = new String(rateName.getBytes("iso-8859-1"), "utf-8");
		
		int result =  operatorDiscountAO.checkRateName(rateName, vo.getId());
		
//		if(result > 0){
			response.getWriter().print(result);
//		}else{
//			response.getWriter().print("error");
//		}
	}
	
	/**
	 * @description:通过登录用户id查询费率列表 
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:34:48
	 */
	@RequestMapping(value= RateURL.RATE_LIST)
	public ModelAndView selectByPo(HttpServletRequest request,@RequestParam(value="pageNo",required=false)String pageNo,RateBackwardPo rateBackwardPo)
	{
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){//未登录用户
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}else{
			if(rateBackwardPo == null){
				rateBackwardPo = new RateBackwardPo();
			}
			rateBackwardPo.setRootAgencyId(agencyVO.getId());
			PageParam pageParam = null;
			if(StringHelper.isNotEmpty(pageNo)){
				pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
			}else{
				pageParam = new PageParam(1, 10);
			}
			Pagination<RateBackwardPo> pagination = rateBackwardAO.selectByPo(rateBackwardPo, pageParam);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("params",rateBackwardPo);
			resultMap.put("rateStateEnums", RateStateEnum.toList());
			resultMap.put("billTypeEnums", BillTypeEnum.toList());
			
			resultMap.put("pagination", pagination);
			
			return new ModelAndView("/rate/rate_list","resultMap",resultMap);
		}
	}
	
	/**
	 * @description:获得最优通道信息
	 * @param request
	 * @param operatorScopeVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 上午10:22:11
	 */
//	@RequestMapping(value= RateURL.GET_BEST_CHANNEL)
//	public void getBestChannel(HttpServletRequest request, HttpServletResponse response, OperatorScopeVO operatorScopeVO)
//	{
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		operatorScopeVO.setAid(agencyVO.getId());
//		try {
//			String scopeCityName = operatorScopeVO.getScopeCityName();
//			if(StringHelper.isNotEmpty(scopeCityName)){
//				scopeCityName = new String(scopeCityName.getBytes("iso-8859-1"),"utf-8");
//				operatorScopeVO.setScopeCityName(scopeCityName);
//			}
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		BestChannelPO bestChannelPo = channelForwardAO.getBestChannel(operatorScopeVO);
////		Map<String, Object> resultMap = new HashMap<String, Object>();
////		resultMap.put("bestChannelPo", bestChannelPo);
//		try {
//			if(bestChannelPo != null){
//			response.getWriter().print(JSONObject.toJSON(bestChannelPo).toString());
//			response.getWriter().print(JSONObject.parse("['error']").toString());
//			}
//			else{
//				response.getWriter().print(JSONObject.parse("['error']").toString());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	@RequestMapping(value= RateURL.GET_BEST_CHANNEL)
	public void getBestChannel(HttpServletRequest request, HttpServletResponse response, ChannelChannelPo channelPo)//设置运营商类型和地区筛选
	{
//		ChargeAccountPo chargeAccount1 = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount1");
//		ChargeAccountPo chargeAccount = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount");
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		String agencyName = request.getSession().getAttribute("childAgencyName").toString();
		String childAgencyIdStr = request.getSession().getAttribute("childAgencyId").toString();
		if(agencyVO == null){//未登录用户
			System.out.println("no login");
//			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		channelPo.setBelongAgencyId(agencyVO.getId());//设置代理商
		//设置是否带票
		if(StringHelper.isNotEmpty(childAgencyIdStr))
		{
			int childAgencyId = Integer.parseInt(childAgencyIdStr);
			ChargeAccountPo chargeAccountPo1 = chargeAccountAO
					.getAccountByAgencyId(childAgencyId,BillTypeEnum.CORPORATE_BUSINESS.getValue());
			ChargeAccountPo chargeAccountPo = chargeAccountAO
					.getAccountByAgencyId(childAgencyId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
			if(chargeAccountPo1 != null && chargeAccountPo == null)
			{
				channelPo.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
			}else
			{//
				channelPo.setBillType(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
			}
		}
		
//		request.getSession().setAttribute("childAgencyName", childAgencyName);
		
		List<ChannelChannelPo> channelList = new ArrayList<ChannelChannelPo>();
		
		//简易通道列表
		channelList = channelChannelAO.listChannel(channelPo);
		request.getSession().setAttribute("channelList", channelList);
//		resultMap.put("channelList", channelList);
//		resultMap.put("childAgencyId", childAgencyId);
//		resultMap.put("agencyName", agencyName);
		
	}
	/**
	 * @description: 通道配置费率列表
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 上午11:43:53
	 */
	@RequestMapping(value=RateURL.BIND_CHANNEL_LIST)
	public ModelAndView bindChannelList(HttpServletRequest request,String childAgencyId, String childAgencyName)
	{
//		agencyActiveChannelAO.listActive(pageParam, activePo)
		request.getSession().setAttribute("childAgencyId", childAgencyId);
		request.getSession().setAttribute("childAgencyName", childAgencyName);
		return new ModelAndView("/activity/bind_channel_list");
	}
	/**
	 * @description: 绑定代理商
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午12:26:09
	 */
	@RequestMapping(value=RateURL.BIND_CHANNEL_PAGE)
	public ModelAndView rateJoinChannelPage(@RequestParam(value="pageTitle",required=false)String pageTitle,ChannelChannelPo channelPo,HttpServletRequest request)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageTitle", pageTitle);
		resultMap.put("scopeCityNames", ScopeCityEnum.toList());
		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
		return new ModelAndView("/activity/bind_channel","resultMap",resultMap);
	}
	/**
	 * @description: 代理商绑定通道
	 * @param rjcp
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午12:36:01
	 */
	@RequestMapping(value=RateURL.BIND_CHANNEL)
	@ResponseBody
	public void rateJoinChannel(RateJoinChannelPo rjcp,HttpServletResponse response, HttpServletRequest request)
	{
		String agencyId = request.getSession().getAttribute("childAgencyId").toString();
		String agencyName = request.getSession().getAttribute("childAgencyName").toString();
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return new ModelAndView("/rate/rate_join_channel_page","pageTitle","pageTitle");
	}
	
}
