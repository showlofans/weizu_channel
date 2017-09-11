package com.weizu.flowsys.web.activity.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.AgencyActiveChannelAO;
import com.weizu.flowsys.web.activity.ao.OperatorDiscountAO;
import com.weizu.flowsys.web.activity.ao.RateBackwardAO;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRatePo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountShowDTO;
import com.weizu.flowsys.web.activity.url.RateURL;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.ChannelChannelAO;
import com.weizu.flowsys.web.channel.ao.ChannelDiscountAO;
import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.web.foundation.String.StringHelper;

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
	private ChannelChannelDao channelChannelDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private AgencyActiveChannelAO agencyActiveChannelAO;
	@Resource
	private ChannelDiscountAO channelDiscountAO;
	
	@Resource
	private ChannelDiscountDao channelDiscountDao;
	
	@Resource
	private RateDiscountDao rateDiscountDao;
	@Resource
	private RateDiscountAO rateDiscountAO;
	
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
	@Resource
	private AgencyAO agencyAO;
	
	/**
	 * @description:跳转到费率添加页面
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @throws UnsupportedEncodingException 
	 * @createTime:2017年5月17日 下午12:19:11
	 */
//	@RequestMapping(value= RateURL.RATE_ADD_PAGE)
//	public ModelAndView rateAddPage(HttpServletRequest request,@RequestParam(value="agencyId", required = false)String agencyId,@RequestParam(value="rateId", required = false)String rateId) throws UnsupportedEncodingException{
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		
//		
//		ChargeAccountPo chargeAccount = (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//		if(chargeAccount != null){
//			if(chargeAccount.getBillType() != null &&  chargeAccount.getBillType() == 1)
//			{
//				resultMap.put("billTypes", BillTypeEnum.toList());
//			}else{
//				resultMap.put("billType", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//			}
//		}
//		
//		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
//		resultMap.put("scopeCityNames", ScopeCityEnum.toList());
//		if (rateId != null) {
////			AgencyBackwardPo agencyPo = agencyAO.getAgencyById();
////			RateBackwardPo ratePo = rateBackwardAO.getByPoId(Long.parseLong(rateId));
////			resultMap.put("ratePo", ratePo);
//			OperatorDiscountPo opo = new OperatorDiscountPo();
//			opo.setRateId(Long.parseLong(rateId));
//			List<OperatorDiscountPo> list = operatorDiscountAO.listDiscountByPo(opo);
////			for (OperatorDiscountPo operatorDiscountPo : list) {//设置编码
////				for (Map<String,Object> map : OperatorTypeEnum.toList()) {
////					if(operatorDiscountPo.getOperatorType()==Integer.parseInt(map.get("value").toString())){
////						String operatorName = map.get("desc").toString();
////						operatorDiscountPo.setOperatorScope(operatorName + operatorDiscountPo.getScopeName());
////					}
////				}
////			}
//			resultMap.put("discountList", list);
//			resultMap.put("agencyId", agencyId);
//			
////			OperatorScopeVO osv = new OperatorScopeVO();
////			osv.set
////			ServiceScopePo ssp = new ServiceScopePo(id, scopeCityCode, serviceType, operatorType, operatorName, scopeCityName)
//			
//		}
//		
////		String rateName = agencyPo.getRateName();
////		String userName = agencyPo.getUserName();
////		rateName = new String(rateName.getBytes("iso-8859-1"), "utf-8");
////		userName = new String(userName.getBytes("iso-8859-1"), "utf-8");
////		agencyPo.setRateName(rateName);
////		agencyPo.setUserName(userName);
//		//resultMap.put("serviceTypes", ServiceTypeEnum.toList());
//		
//		return new ModelAndView("/rate/rate_add_page", "resultMap", resultMap);
//	}
//	/**
//	 * @description:跳转到费率编辑页面
//	 * @param request
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @throws UnsupportedEncodingException 
//	 * @createTime:2017年5月17日 下午12:19:11
//	 */
//	@RequestMapping(value= RateURL.RATE_EDIT_PAGE)
//	public ModelAndView rateEditPage(HttpServletRequest request,@RequestParam(value="rateId", required = false)String rateId) throws UnsupportedEncodingException{
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
//		resultMap.put("scopeCityNames", ScopeCityEnum.toList());
//		if (rateId != null) {
//			OperatorDiscountPo opo = new OperatorDiscountPo();
//			opo.setRateId(Long.parseLong(rateId));
//			List<OperatorDiscountPo> list = operatorDiscountAO.listDiscountByPo(opo);
//			
//			for (OperatorDiscountPo operatorDiscountPo : list) {//设置编码
//				operatorDiscountPo.setScopeCityNames( ScopeCityEnum.toList());
////				for (Map<String,Object> map : OperatorTypeEnum.toList()) {
////					if(operatorDiscountPo.getOperatorType()==Integer.parseInt(map.get("value").toString())){
////						String operatorName = map.get("desc").toString();
////						operatorDiscountPo.setOperatorScope(operatorName + operatorDiscountPo.getScopeName());
////					}
////				}
//			}
//			resultMap.put("discountList", list);
//			resultMap.put("rateId", rateId);
//		}
//		
//		return new ModelAndView("/rate/rate_edit_page", "resultMap", resultMap);
//	}
//	
//	/**
//	 * @description:添加费率
//	 * @param id 代理商id
//	 * @param request
//	 * @param rateBackwardPo
//	 * @param response
//	 * @return
//	 * @throws IOException
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年5月27日 上午9:47:51
//	 */
//	@RequestMapping(value= RateURL.RATE_ADD)
//	@ResponseBody
//	public ModelAndView rateAdd(HttpServletRequest request, RateBackwardVo rateBackwardVo,HttpServletResponse response) throws IOException{
//		AgencyBackwardVO vo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		if(vo == null){
//			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
//		}
//		int result =  operatorDiscountAO.disccount_addList(rateBackwardVo, vo.getId());
//		
//		if(result > 0){
////			response.getWriter().print("success");
//			return selectByPo(request, null, null);
//		}
//		return null;
//	}
//	/**
//	 * @description:异步验证费率名称是否存在
//	 * @param request
//	 * @param rateName
//	 * @param response
//	 * @throws IOException
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月5日 上午10:50:53
//	 */
//	@RequestMapping(value = RateURL.CHECK_RATE_NAME)
//	@ResponseBody
//	public void checkRateName(HttpServletRequest request, String rateName,HttpServletResponse response) throws IOException{
//		AgencyBackwardVO vo  = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		rateName = new String(rateName.getBytes("iso-8859-1"), "utf-8");
//		
//		int result =  operatorDiscountAO.checkRateName(rateName, vo.getId());
//		
////		if(result > 0){
//			response.getWriter().print(result);
////		}else{
////			response.getWriter().print("error");
////		}
//	}
	
	/**
	 * @description:通过登录用户id查询费率列表 
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午3:34:48
	 */
//	@RequestMapping(value= RateURL.RATE_LIST)
//	public ModelAndView doRateList(HttpServletRequest request,@RequestParam(value="pageNo",required=false)String pageNo,RateBackwardPo rateBackwardPo)
//	{
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		if(agencyVO == null){//未登录用户
//			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
//		}else{
//			if(rateBackwardPo == null){
//				rateBackwardPo = new RateBackwardPo();
//			}
//			rateBackwardPo.setRootAgencyId(agencyVO.getId());
//			PageParam pageParam = null;
//			if(StringHelper.isNotEmpty(pageNo)){
//				pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
//			}else{
//				pageParam = new PageParam(1, 10);
//			}
//			Pagination<RateBackwardPo> pagination = rateBackwardAO.selectByPo(rateBackwardPo, pageParam);
//			Map<String, Object> resultMap = new HashMap<String, Object>();
//			resultMap.put("params",rateBackwardPo);
//			resultMap.put("rateStateEnums", BindStateEnum.toList());
//			resultMap.put("billTypeEnums", BillTypeEnum.toList());
//			
//			resultMap.put("pagination", pagination);
//			
//			return new ModelAndView("/rate/rate_list","resultMap",resultMap);
//		}
//	}
	
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
	public void getSimpleChannel(HttpServletRequest request, HttpServletResponse response,ChannelDiscountPo discountPo)//设置运营商类型和地区筛选
	{
//		ChargeAccountPo chargeAccount1 = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount1");
//		ChargeAccountPo chargeAccount = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount");
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		String agencyName = request.getSession().getAttribute("childAgencyName").toString();
//		if(agencyVO == null){//未登录用户
//			System.out.println("no login");
////			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
//		}
		Object childAgencyId = request.getSession().getAttribute("childAgencyId");
		if(childAgencyId != null){
			discountPo.setBelongAgencyId(Integer.parseInt(childAgencyId.toString()));//当前登录用户的通道的
		}
		
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
		 List<ChannelDiscountPo> channelList = channelDiscountAO.listOpenChannel(discountPo);
		
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
	@SuppressWarnings("restriction")
	@RequestMapping(value=RateURL.BIND_CHANNEL_LIST)
	public ModelAndView bindChannelList(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request,AgencyActiveRatePo activePo)
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
		Pagination<AgencyActiveRatePo> pagination = agencyActiveChannelAO.listActive(pageParam, activePo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pagination", pagination);
		resultMap.put("bindStateEnums", BindStateEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		
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
//	@SuppressWarnings("restriction")
//	@RequestMapping(value=RateURL.BIND_AGENCY_LIST)
//	public ModelAndView bindAgencyList(@RequestParam(value = "pageNo", required = false) String pageNo,
//			HttpServletRequest request,AgencyActiveRatePo activePo){
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		return new ModelAndView("/activity/bind_agency_list","resultMap",resultMap);
//	}
	
	/**
	 * @description: 费率配置列表
	 * @param pageNo
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月28日 下午5:38:02
	 */
	@SuppressWarnings("restriction")
	@RequestMapping(value=RateURL.MY_RATE_LIST)
	public ModelAndView myRateList(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request,RateDiscountPo ratePo,String agencyName){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
//		activePo.setBindAgencyId(agencyVO.getId());//设置当前登录用户的
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{
			pageParam = new PageParam(1, 10);
		}
		int childAgencyId = ratePo.getAgencyId();
		request.getSession().setAttribute("childAgencyId", ratePo.getAgencyId());
		ratePo.setAgencyId(agencyVO.getId());
		Pagination<RateDiscountPo> pagination = rateDiscountAO.getMyRateList(ratePo,childAgencyId, pageParam);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("pagination", pagination);
		resultMap.put("searchParam", ratePo);
		request.getSession().setAttribute("childAgencyName", agencyName);
		
		return new ModelAndView("/activity/my_rate_list","resultMap",resultMap);
	}
	/**
	 * @description: 更新下级代理商折扣
	 * @param request
	 * @param ratePo
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午3:37:51
	 */
	@ResponseBody
	@RequestMapping(value=RateURL.ADD_MY_RATE)
	public void addMyRate(HttpServletRequest request,RateDiscountPo ratePo,HttpServletResponse response){
		String resAddDis = "error";
		if(ratePo.getId() != null){//更新
			resAddDis = rateDiscountAO.updateRateDiscount(ratePo);
		}else{
			AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
			if(agencyVO != null){
				String agencyName = request.getSession().getAttribute("childAgencyName").toString();
				String agencyIdStr = request.getSession().getAttribute("childAgencyId").toString();
				int bindAgencyId = agencyVO.getId();
				ratePo.setAgencyId(Integer.parseInt(agencyIdStr));
				resAddDis = rateDiscountAO.addRateDiscount(ratePo, agencyName, bindAgencyId);
			}
		}
		try {
			response.getWriter().print(resAddDis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description: 给代理商配置通道（费率）
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午12:26:09
	 */
	@SuppressWarnings("restriction")
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
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
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
	public String rateJoinChannel(AgencyActiveRatePo aacp,RateDiscountPo rateDiscountPo,HttpServletResponse response, HttpServletRequest request)
	{
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		
		String agencyId = request.getSession().getAttribute("childAgencyId").toString();
		String agencyName = request.getSession().getAttribute("childAgencyName").toString();
		
		aacp.setBindAgencyId(agencyVO.getId());
		aacp.setAgencyId(Integer.parseInt(agencyId));
		aacp.setAgencyName(agencyName);
		if(ServiceTypeEnum.NATION_WIDE.getValue() == rateDiscountPo.getServiceType() && !ScopeCityEnum.QG.getValue().equals(rateDiscountPo.getScopeCityCode())){
			//全国业务，必须匹配全国的折扣
			return "disMatch";
		}
		int bindRes = agencyActiveChannelAO.bindChannel(aacp,rateDiscountPo);
		if(bindRes == -1){
			return "hasScope";
		}else if(bindRes > 0){
			return "success";
		}else{
			return "error";
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
	 * @description: 批量更新绑定状态（根据折扣id，批量解除绑定）
	 * @param bindState
	 * @param rateDiscountId
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午10:18:20
	 */
	@RequestMapping(value=RateURL.BATCH_UPDATE_BIND_STATE)
	@ResponseBody
	public String batchUpdateBindState(AgencyActiveRateDTO aardto, HttpServletResponse response)
	{
		int res = agencyActiveChannelAO.batchUpdateBindState(aardto);
		if(res > 0){
			return "success";
		}else{
			return "error";
			
		}
//		try {
//			response.getWriter().print("success");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
	 * @description:来源：channel_list.jsp channel_edit函数<br>查询统一配置的费率列表
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月10日 上午11:53:39
	 */
	@RequestMapping(value=RateURL.BIND_RATE_LIST)
	public ModelAndView getBindRateList(AgencyActiveRatePo aarp,Long channelId, @RequestParam(value = "pageNo", required = false) String pageNo,HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{
			pageParam = new PageParam(1, 10);
		}
		//初始化resultMap集合
		agencyActiveChannelAO.getBindRateList(resultMap, pageParam, aarp, channelId);
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());
		resultMap.put("bindStateEnums", BindStateEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("searchParams", aarp);
		
		return new ModelAndView("/activity/bind_rate_list","resultMap",resultMap);
	}
	/**
	 * @description: 发送ajax请求的位置：bind_rate_list.jsp setDiscount函数
	 * <br>js/json通过参数获得折扣列表
	 * @see
	 * @param request
	 * @param oType
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 上午10:49:23
	 */
	@SuppressWarnings("restriction")
	@RequestMapping(value = RateURL.GET_DISCOUNT)
	@ResponseBody
	public void getDiscount(HttpServletRequest request,RateDiscountPo ratePo,HttpServletResponse response){
//		Map<String,Object> resMap = (Map<String, Object>) request.getSession().getAttribute("prefixMap");
		List<RateDiscountPo> list = rateDiscountDao.getRateDiscountList(ratePo);
		String jsonStr = JSON.toJSONString(list);
//		return jsonStr;
		try {
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description: 绑定折扣添加页面
	 * <br>来源： bind_rate_list 添加或者编辑折扣按钮
	 * @param ratePo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月14日 下午2:48:58
	 */
	@RequestMapping(value= RateURL.BIND_RATE_ADD_PAGE)
	public ModelAndView addBindRatePage(String channelDiscountId,String billType,
			String fromTag, @RequestParam(value="rateDiscountId",required=false)String rateDiscountId){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(fromTag.equals("edit") && rateDiscountId != null){
			resultMap.put("rateDiscountId", rateDiscountId);
			Double rateDiscount = rateDiscountDao.get(Long.parseLong(rateDiscountId)).getActiveDiscount();
			resultMap.put("rateDiscount", rateDiscount);//费率折扣
		}
		
		resultMap.put("fromTag", fromTag);
		resultMap.put("billType", billType);
		
		long cId = Long.parseLong(channelDiscountId.trim());
		ChannelDiscountPo cDPo = channelDiscountDao.get(new WherePrams("id", "=", cId));
		resultMap.put("cDPo",cDPo);
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		return new ModelAndView("/activity/bind_rate_add_page", "resultMap", resultMap);
	}
	/**
	 * @description: 来源： bind_rate_add_page.jsp<br>绑定折扣添加
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月14日 下午2:53:05
	 */
	@RequestMapping(value= RateURL.BIND_RATE_ADD)
	@ResponseBody
	public void addBindRate(RateDiscountPo ratePo,HttpServletResponse response){
		
		String addRes = rateDiscountAO.addRateDiscount(ratePo);
		try {
			response.getWriter().print(addRes);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("ratePo",ratePo);
		
	}
	
	/**
	 * @description: 来源： bind_rate_add_page.jsp<br>编辑折扣
	 * @param ratePo
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午9:53:08
	 */
	@RequestMapping(value= RateURL.BIND_RATE_EDIT)
	@ResponseBody
	public void editBindRate(RateDiscountPo ratePo,HttpServletResponse response){
		//也需添加是否存在的判断
		String res = rateDiscountAO.editBindRate(ratePo);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("ratePo",ratePo);
		
	}
	
	/**
	 * @description: 通道绑定代理商页面 
	 * @param channelDiscountId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月15日 上午11:44:58
	 */
//	@RequestMapping(value= RateURL.BIND_AGENCY_PAGE)
//	public ModelAndView bindAgencyPage(String channelDiscountId,String activeDiscount, String rateDiscountId){
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		long cId = Long.parseLong(channelDiscountId.trim());
//		ChannelDiscountPo cDPo = channelDiscountDao.get(new WherePrams("id", "=", cId));
//		resultMap.put("cDPo",cDPo);//显示参数
//		resultMap.put("otypeEnums", OperatorTypeEnum.toList());//显示参数
//		resultMap.put("stypeEnums", ServiceTypeEnum.toList());//显示参数
//		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());//显示参数
//		resultMap.put("activeDiscount", activeDiscount);//折扣：显示参数
//		resultMap.put("rateDiscountId", rateDiscountId);//折扣id：hidden
//		return new ModelAndView("/activity/bind_agency_page", "resultMap", resultMap);
//	}
	/**
	 * @description: 来源：bind_rate_list.jsp  changeBState函数 <br>更新绑定状态提示页面
	 * @param channelDiscountId
	 * @param activeDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月15日 下午3:04:47
	 */
	@RequestMapping(value= RateURL.UPDATE_BIND_STATE_CONFIRM)
	public ModelAndView updateBindStateConfirm(String channelDiscountId,String activeDiscount, String agencyName,String bindState){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int bindStateInt = Integer.parseInt(bindState);
		long cId = Long.parseLong(channelDiscountId.trim());
		ChannelDiscountPo cDPo = channelDiscountDao.get(new WherePrams("id", "=", cId));
		resultMap.put("cDPo",cDPo);//显示参数
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());//显示参数
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());//显示参数
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());//显示参数
		resultMap.put("activeDiscount", activeDiscount);//折扣：显示参数
		resultMap.put("agencyName", agencyName);//绑定代理商名字
		resultMap.put("bindState", bindStateInt);//绑定状态
		resultMap.put("bindStateEnums", BindStateEnum.toList());//绑定代理商名字
		return new ModelAndView("/activity/update_bind_state_confirm", "resultMap", resultMap);
	}
	/**
	 * @description: 来源：bind_rate_list.jsp  batch_bind函数 <br>通道批量绑定代理商页面 /flowsys/rate/batch_bind_agency_page
	 * @param pageNo
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:46:08
	 */
	@RequestMapping(value= RateURL.BATCH_BIND_AGENCY_PAGE)
	@ResponseBody
	public ModelAndView batchBindAgencyPage(@RequestParam(value = "pageNo", required = false) String pageNo,AgencyActiveRateDTO aardto,RateDiscountPo ratePo, HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(agencyVO == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		int rootAgencyId = agencyVO.getId();
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{
			pageParam = new PageParam(1, 10);
		}
		//初始化绑定状态
		if(aardto.getBindState() == null){
			aardto.setBindState(BindStateEnum.UNBIND.getValue());
		}
		//初始化代理商类型
		if(aardto.getAgencyTag() == null){
			aardto.setAgencyTag(AgencyTagEnum.PLATFORM_USER.getValue());
		}
		
		Pagination<AgencyBackwardVO> pagination = agencyAO.getUnbindAgency(rootAgencyId,aardto, pageParam);
		resultMap.put("ratePo", ratePo);
		resultMap.put("aardto", aardto);
		resultMap.put("pagination", pagination);
		resultMap.put("bindStateEnums", BindStateEnum.toBindList());
		resultMap.put("agencyTagEnums", AgencyTagEnum.toList());
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		
		return new ModelAndView("/activity/batch_bind_agency_page", "resultMap", resultMap);
	}
	/**
	 * @description: 来源：batch_bind_agency_page.jsp changeBState函数<br>通道批量绑定（解绑）代理商 
	 * @param aardto
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 下午3:37:56
	 */
	@SuppressWarnings("restriction")
	@ResponseBody
	@RequestMapping(value=RateURL.BATCH_BIND_AGENCY)
	public String batchBindAgency(AgencyActiveRateDTO aardto,HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return "error";
		}
		aardto.setBindAgencyId(agencyVO.getId());
		int res = agencyActiveChannelAO.batchBindAgency(aardto);
		String msg = "";
		if(res>0){
			msg = "success"; 
		}else{
			msg = "error"; 
		}
//		try {
//			if(res>0){
//				response.getWriter().print("success"); 
//			}else{
//				response.getWriter().print("error"); 
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return msg;
	}
	
	/**
	 * @description: 来源：index.jsp <br>欢迎界面 /flowsys/rate/welcome.do
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月19日 下午2:24:34
	 */
	@RequestMapping(value=RateURL.WELCOME)
	public ModelAndView welcome(HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		List<RateDiscountShowDTO> rateList = rateDiscountAO.getIndexShowRate(agencyVO.getId());
//		resultMap.put("map", map);
		resultMap.put("rateList", rateList);
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		return new ModelAndView("/welcome", "resultMap", resultMap);
	}
	/**
	 * @description: 来源：bind_channel_list.jsp bind_del函数<br> 删除代理商和通道的绑定
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 下午3:46:36
	 */
	@ResponseBody
	@RequestMapping(value=RateURL.DEL_AGENCY_ACTIVE_RATE)
	public String delAar(Long id){
		String res = agencyActiveChannelAO.delAar(id);
		return res;
	}
	/**
	 * @description: 来源：rate_list.jsp delRateDiscount函数<br>删除折扣
	 * @param rateDiscountId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午5:15:34
	 */
	@ResponseBody
	@RequestMapping(value=RateURL.DEL_RATE)
	public String delRateDiscount(Long rateDiscountId){
		int res = rateDiscountDao.del(rateDiscountId);
		if(res > 0){
			return "success";
		}
		return "error";
	}
	
}
