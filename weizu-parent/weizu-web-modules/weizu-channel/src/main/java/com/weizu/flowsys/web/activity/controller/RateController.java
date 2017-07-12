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
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelDiscountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.AgencyActiveChannelAO;
import com.weizu.flowsys.web.activity.ao.OperatorDiscountAO;
import com.weizu.flowsys.web.activity.ao.RateBackwardAO;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscount;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardVo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateJoinChannelPo;
import com.weizu.flowsys.web.activity.url.RateURL;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.ChannelChannelAO;
import com.weizu.flowsys.web.channel.ao.ChannelDiscountAO;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.impl.ChannelDiscountDaoImpl;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;

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
//	@Resource
//	private ChannelDiscountDao channelDiscountDao;
	@Resource
	private ChannelDiscountAO channelDiscountAO;
	@Resource
	private RateDiscountDao rateDiscountDao;
	@Resource
	private RateDiscountAO rateDiscountAO;
	
	
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
			resultMap.put("rateStateEnums", BindStateEnum.toList());
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
	/**
	 * @description: 获得可配置的简易通道信息
	 * @param request
	 * @param response
	 * @param channelChannelPo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 上午10:45:49
	 */
	@RequestMapping(value= RateURL.GET_SIMPLE_CHANNEL)
	public void getSimpleChannel(HttpServletRequest request, HttpServletResponse response,ChannelChannelPo channelChannelPo)//设置运营商类型和地区筛选
	{
//		ChargeAccountPo chargeAccount1 = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount1");
//		ChargeAccountPo chargeAccount = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount");
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		String agencyName = request.getSession().getAttribute("childAgencyName").toString();
		if(agencyVO == null){//未登录用户
			System.out.println("no login");
//			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		channelChannelPo.setBelongAgencyId(agencyVO.getId());//当前登录用户的通道的
		
		//设置票务筛选
//		String childAgencyIdStr = request.getSession().getAttribute("childAgencyId").toString();
//		if(StringHelper.isNotEmpty(childAgencyIdStr))
//		{
//			int childAgencyId = Integer.parseInt(childAgencyIdStr);
//			ChargeAccountPo chargeAccountPo1 = chargeAccountAO
//					.getAccountByAgencyId(childAgencyId,BillTypeEnum.CORPORATE_BUSINESS.getValue());
//			ChargeAccountPo chargeAccountPo = chargeAccountAO
//					.getAccountByAgencyId(childAgencyId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//			if(chargeAccountPo1 != null && chargeAccountPo == null)
//			{
//				//简易通道列表(不含运营商和地区筛选)
//				channelChannelPo.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
////				channelPo.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
//			}
//		}
		 List<ChannelChannelPo> channelList = channelChannelAO.listOpenChannel(channelChannelPo);
		
		//简易通道列表
		try {
			response.setContentType("text/xml;charset=utf-8");
			response.getWriter().print(JSON.toJSONString(channelList));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			response.getWriter().print("success");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		resultMap.put("channelList", channelList);
//		resultMap.put("childAgencyId", childAgencyId);
//		resultMap.put("agencyName", agencyName);
		
	}
	/**
	 * @description: 通道配置费率列表(代理商绑定通道)
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 上午11:43:53
	 */
	@RequestMapping(value=RateURL.BIND_CHANNEL_LIST)
	public ModelAndView bindChannelList(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request,AgencyActiveChannelPo activePo)
	{
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		activePo.setBindAgencyId(agencyVO.getId());//设置当前登录用户的
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{
			pageParam = new PageParam(1, 10);
		}
//		AgencyActiveChannelPo activePo = new 
		Pagination<AgencyActiveChannelPo> pagination = agencyActiveChannelAO.listActive(pageParam, activePo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pagination", pagination);
		resultMap.put("bindStateEnums", BindStateEnum.toList());
		
		if(activePo.getAgencyId() != null)
		{
			ChargeAccountPo chargeAccountPo1 = chargeAccountAO
					.getAccountByAgencyId(activePo.getAgencyId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
			if(chargeAccountPo1 != null)
			{
				request.getSession().setAttribute("isOpen", 1);
			}
		}
		request.getSession().setAttribute("childAgencyId", activePo.getAgencyId());
		request.getSession().setAttribute("childAgencyName", activePo.getAgencyName());
		return new ModelAndView("/activity/bind_channel_list","resultMap",resultMap);
	}
	
	/**
	 * @description: 绑定代理商列表（一键配置代理商折扣功能）
	 * @param pageNo
	 * @param request
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午5:23:10
	 */
	@RequestMapping(value=RateURL.BIND_AGENCY_LIST)
	public ModelAndView bindAgencyList(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request,AgencyActiveChannelPo activePo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		return new ModelAndView("/activity/bind_agency_list","resultMap",resultMap);
	}
	
	/**
	 * @description: 绑定代理商
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午12:26:09
	 */
	@RequestMapping(value=RateURL.BIND_CHANNEL_PAGE)
	public ModelAndView rateJoinChannelPage(@RequestParam(value="pageTitle",required=false)String pageTitle,HttpServletRequest request)//,ChannelChannelPo channelPo
	{
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
////		String agencyName = request.getSession().getAttribute("childAgencyName").toString();
//		String childAgencyIdStr = request.getSession().getAttribute("childAgencyId").toString();
//		if(agencyVO == null){//未登录用户
//			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
//		}
		
		//设置是否带票
//		List<ChannelChannelPo> channelList = new ArrayList<ChannelChannelPo>();
//		if(StringHelper.isNotEmpty(childAgencyIdStr))
//		{
//			int childAgencyId = Integer.parseInt(childAgencyIdStr);
//			ChargeAccountPo chargeAccountPo1 = chargeAccountAO
//					.getAccountByAgencyId(childAgencyId,BillTypeEnum.CORPORATE_BUSINESS.getValue());
//			ChargeAccountPo chargeAccountPo = chargeAccountAO
//					.getAccountByAgencyId(childAgencyId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//			if(chargeAccountPo1 != null && chargeAccountPo == null)
//			{
//				//简易通道列表(不含运营商和地区筛选)
//				channelList = channelChannelAO.listChannel(agencyVO.getId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
////				channelPo.setBillType(BillTypeEnum.CORPORATE_BUSINESS.getValue());
//			}else
//			{//
//				channelList = channelChannelAO.listChannel(agencyVO.getId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//			}
//		}
		
//		Jso
//		String channelListStr = JSON.toJSONString(channelList);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageTitle", pageTitle);
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
//		resultMap.put("channelListStr", channelListStr);
//		resultMap.put("channelList", channelList);
		return new ModelAndView("/activity/bind_channel","resultMap",resultMap);
	}
	/**
	 * @description: 代理商绑定通道
	 * @param aacp
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午12:36:01
	 */
	@RequestMapping(value=RateURL.BIND_CHANNEL)
	@ResponseBody
	public void rateJoinChannel(AgencyActiveChannelPo aacp,RateDiscountPo rateDiscountPo,HttpServletResponse response, HttpServletRequest request)
	{
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		String agencyId = request.getSession().getAttribute("childAgencyId").toString();
		String agencyName = request.getSession().getAttribute("childAgencyName").toString();
		
		aacp.setBindAgencyId(agencyVO.getId());
		aacp.setAgencyId(Integer.parseInt(agencyId));
		aacp.setAgencyName(agencyName);
		int bindRes = agencyActiveChannelAO.bindChannel(aacp,rateDiscountPo);
		
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return new ModelAndView("/rate/rate_join_channel_page","pageTitle","pageTitle");
	}
	
	/**
	 * @description: 更新绑定状态
	 * @param bindState
	 * @param activeId
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午12:10:18
	 */
	@RequestMapping(value=RateURL.UPDATE_BIND_STATE)
	@ResponseBody
	public void updateBindState(String bindState, String activeId, HttpServletResponse response)
	{
		int updateRes = agencyActiveChannelAO.updateBindState(activeId, bindState);
		try {
			if(updateRes > 0)
			{
				response.getWriter().print("success");
			}else{
				response.getWriter().print("error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @description: 更新绑定的折扣
	 * @param bindState
	 * @param activeId
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午4:15:06
	 */
	@RequestMapping(value=RateURL.UPDATE_RATE_DISCOUNT)
	@ResponseBody
	public void updateRateDiscount(String discount, String activeId, HttpServletResponse response)
	{
		int updateRes = agencyActiveChannelAO.updateRateDiscount(activeId, discount);
		try {
			if(updateRes > 0)
			{
				response.getWriter().print("success");
			}else{
				response.getWriter().print("error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description:查询统一配置的费率列表
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月10日 上午11:53:39
	 */
	@RequestMapping(value=RateURL.BIND_RATE_LIST)
	public ModelAndView getRateByChannelId(RateDiscountPo ratePo, @RequestParam(value = "pageNo", required = false) String pageNo,HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{
			pageParam = new PageParam(1, 10);
		}
//		cdp.setDiscountType(ChannelDiscountTypeEnum.RATE.getValue());
		List<RateDiscountPo> rateList = rateDiscountDao.getRateDiscountList(ratePo);
		
		
		//初始化开头字段
		
//		List<ChannelDiscountPo> discountList = channelDiscountAO.getDiscountList(cdp);
		
		ChannelDiscountPo cdp = new ChannelDiscountPo();
		cdp.setDiscountType(ChannelDiscountTypeEnum.CHANNEL.getValue());
		cdp.setChannelId(ratePo.getChannelId());
		
		Pagination<ChannelDiscountPo> pagination = channelDiscountAO.getDiscountList(cdp, pageParam);//
		
		Map<String,Object> prefixMap = channelDiscountAO.getOperatorList(cdp);//获得对上通道相关信息
//		prefixList = channelDiscountAO
		
		resultMap.put("pagination", pagination);
//		request.getSession().setAttribute("prefixMap", prefixMap);//通道折扣选项
		resultMap.put("prefixMap", prefixMap);	//通道折扣选项
		resultMap.put("rateList", rateList);	//通道折扣选项
		
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());
		resultMap.put("searchParams", ratePo);
		
		
//		channelDis
//		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
//		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
//		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
//		resultMap.put("channelListStr", channelListStr);
//		resultMap.put("channelList", channelList);
		return new ModelAndView("/activity/bind_rate_list","resultMap",resultMap);
	}
	/**
	 * @description: js/json通过运营商类型获得城市列表
	 * @param request
	 * @param oType
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 上午10:49:23
	 */
	@RequestMapping(value = RateURL.GET_DISCOUNT)
	@ResponseBody
	public void getDiscount(HttpServletRequest request,RateDiscountPo ratePo,HttpServletResponse response){
//		Map<String,Object> resMap = (Map<String, Object>) request.getSession().getAttribute("prefixMap");
		List<RateDiscountPo> list = rateDiscountDao.getRateDiscountList(ratePo);
		String jsonStr = JSON.toJSONString(list);
		try {
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
