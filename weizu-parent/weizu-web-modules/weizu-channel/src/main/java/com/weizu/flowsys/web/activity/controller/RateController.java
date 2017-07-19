package com.weizu.flowsys.web.activity.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.WherePrams;
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
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRatePo;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscount;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;
import com.weizu.flowsys.web.activity.pojo.RateBackwardVo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateJoinChannelPo;
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
	private ChannelChannelDao channelChannelDao;
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private AgencyActiveChannelAO agencyActiveChannelAO;
//	@Resource
//	private ChannelDiscountDao channelDiscountDao;
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
	public void getSimpleChannel(HttpServletRequest request, HttpServletResponse response,ChannelDiscountPo discountPo)//设置运营商类型和地区筛选
	{
//		ChargeAccountPo chargeAccount1 = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount1");
//		ChargeAccountPo chargeAccount = (ChargeAccountPo) request.getSession().getAttribute("chargeAccount");
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		String agencyName = request.getSession().getAttribute("childAgencyName").toString();
		if(agencyVO == null){//未登录用户
			System.out.println("no login");
//			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		discountPo.setBelongAgencyId(agencyVO.getId());//当前登录用户的通道的
		
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
//		AgencyActiveChannelPo activePo = new 
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
	@RequestMapping(value=RateURL.BIND_AGENCY_LIST)
	public ModelAndView bindAgencyList(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request,AgencyActiveRatePo activePo){
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
	public void rateJoinChannel(AgencyActiveRatePo aacp,RateDiscountPo rateDiscountPo,HttpServletResponse response, HttpServletRequest request)
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
	 * @description: 批量更新绑定状态（根据折扣id，批量解除绑定）
	 * @param bindState
	 * @param rateDiscountId
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午10:18:20
	 */
	@RequestMapping(value=RateURL.BATCH_UPDATE_BIND_STATE)
	@ResponseBody
	public void batchUpdateBindState(AgencyActiveRateDTO aardto, HttpServletResponse response)
	{
		try {
			agencyActiveChannelAO.batchUpdateBindState(aardto);
			response.getWriter().print("success");
		} catch (Exception e) {
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
	public ModelAndView getBindRate(AgencyActiveRatePo aarp,String channelId, @RequestParam(value = "pageNo", required = false) String pageNo,HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{
			pageParam = new PageParam(1, 10);
		}
		
//		Long channelId = ratePo.getChannelId();
		//channelDiscountDao.get(new WherePrams(file, where, value))
		
		
////		cdp.setDiscountType(ChannelDiscountTypeEnum.RATE.getValue());
		//得到地区和折扣列表
//		List<RateDiscountPo> rateList = rateDiscountDao.getRateDiscountList(ratePo);
		
		ChannelDiscountPo cdp = new ChannelDiscountPo();
		cdp.setChannelId(Long.parseLong(channelId));
		resultMap.put("channelId", channelId);
		List<ChannelDiscountPo> channelList = channelDiscountAO.getDiscountList(cdp);
		
		if(	channelList!= null && channelList.size() > 0){
			resultMap.put("channelBillType", channelList.get(0).getBillType());
			String scopeCityCodeSim = "100";
			List<String> scopeList = new LinkedList<String>();
			//初始化地区列表
			for (ChannelDiscountPo channelPo : channelList) {
				//在排好序的情况下
				String scopeCityCode =channelPo.getScopeCityCode();
				if(!scopeCityCodeSim.equals(scopeCityCode)){//地区不相等（第一个一定）
//					rateDisPo = new RateDiscountPo();
//					rateDisPo.setScopeCityCode(channelPo.getScopeCityCode());
//					rateDisPo.setScopeCityName(ScopeCityEnum.getEnum(channelPo.getScopeCityCode()).getDesc());
					scopeList.add(scopeCityCode);
					scopeCityCodeSim = scopeCityCode;//生成新的key
				}
//				rateDiscountPo.setScopeCityName(ScopeCityEnum.getEnum(rateDiscountPo.getScopeCityCode()).getDesc());
			}
			resultMap.put("scopeList", scopeList);//取地区和地区编码
			
			resultMap.put("channelName", channelList.get(0).getChannelName());//设置通道名称
			
			if(StringHelper.isEmpty(aarp.getScopeCityCode())){//如果为空，就取第一个
				String scopeCityCode = channelList.get(0).getScopeCityCode();//默认选第一个城市
				aarp.setScopeCityCode(scopeCityCode);
				cdp.setScopeCityCode(scopeCityCode);//设置第一个城市
			}else{
				//再去找一遍折扣,通道折扣
				cdp.setScopeCityCode(aarp.getScopeCityCode());
			}
			cdp.setOperatorType(aarp.getOperatorType());//不为空
			cdp.setServiceType(aarp.getServiceType());//不为空
			List<ChannelDiscountPo> channelList1 = channelDiscountAO.getDiscountList(cdp);
			if(channelList1 != null && channelList1.size()==1){//一般一个地区只有一个通道折扣
				ChannelDiscountPo cdp1 = channelList1.get(0);
				Double singleDiscount = cdp1.getChannelDiscount();
				resultMap.put("channelDiscount", singleDiscount);//设置第一个地区的通道折扣
				Long channelDiscountId = cdp1.getId();
				resultMap.put("channelDiscountId", channelDiscountId);//设置第一个地区的通道折扣
				int billType = -1;
				if(aarp.getBillTypeRate() != null){//有查询参数，就用查询参数
					billType = aarp.getBillTypeRate();
				}else{//没有查询参数，就用第一个通道折扣类型，作为费率折扣类型
					billType = cdp1.getBillType();
				}
				List<RateDiscountPo> discountList = rateDiscountDao.getListByCDiscountId(channelDiscountId,billType);//折扣列表
				
				resultMap.put("discountList", discountList);//取折扣和折扣id
				//根据第一个折扣id去找连接
//				RateDiscountPo ratePP = new RateDiscountPo();
				AgencyActiveRatePo aarp1 = new AgencyActiveRatePo();			//搜索参数
				if(discountList != null && discountList.size() > 0){
					if(aarp.getRateDiscountId()==null){
						Long rateId = discountList.get(0).getId();//第一个折扣id
						aarp1.setRateDiscountId(rateId);
					}else
					{
						aarp1.setRateDiscountId(aarp.getRateDiscountId());
					}
					aarp1.setAgencyName(aarp.getAgencyName());
					Pagination<AgencyActiveRatePo> pagination = agencyActiveChannelAO.listActiveRate(pageParam, aarp1);
					resultMap.put("pagination", pagination);
				}else{//显示没有记录
					List<AgencyActiveRatePo> nullList = new ArrayList<AgencyActiveRatePo>();
					Pagination<AgencyActiveRatePo> pagination = new Pagination<AgencyActiveRatePo>(nullList, 0, 1, 10);
					resultMap.put("pagination", pagination);
				}
			}else{//显示没有记录
				List<AgencyActiveRatePo> nullList = new ArrayList<AgencyActiveRatePo>();
				Pagination<AgencyActiveRatePo> pagination = new Pagination<AgencyActiveRatePo>(nullList, 0, 1, 10);
				resultMap.put("pagination", pagination);
			}
			
//			List<Double> disList = new LinkedList<Double>(); 
//			for (RateDiscountPo rateDiscountPo : discountList) {
//				disList.add(rateDiscountPo.getActiveDiscount());
//			}
			
			
		}
//		for (RateDiscountPo rateDiscountPo : rateList) {
//			rateDiscountPo.setScopeCityName(ScopeCityEnum.getEnum(rateDiscountPo.getScopeCityCode()).getDesc());
//		}
//		
//		//初始化开头字段
//		
////		List<ChannelDiscountPo> discountList = channelDiscountAO.getDiscountList(cdp);
//		
//		
//		ChannelDiscountPo cdp = new ChannelDiscountPo();
////		cdp.setDiscountType(ChannelDiscountTypeEnum.CHANNEL.getValue());
//		cdp.setChannelId(ratePo.getChannelId());
//		
//		
//		
////		Pagination<ChannelDiscountPo> pagination = channelDiscountAO.getDiscountList(cdp, pageParam);//
////		AgencyActiveChannelPo activePo = new AgencyActiveChannelPo();
////		activePo.setOperatorType(ratePo.getOperatorType());
//		Pagination<AgencyActiveChannelPo> pagination = agencyActiveChannelAO.listActiveRate(pageParam, ratePo);
//		
////		Map<String,Object> prefixMap = channelDiscountAO.getOperatorList(cdp);//获得对上通道相关信息
////		prefixList = channelDiscountAO
//		
//		resultMap.put("pagination", pagination);
////		request.getSession().setAttribute("prefixMap", prefixMap);//通道折扣选项
////		resultMap.put("prefixMap", ratePo);	//通道折扣选项
//		resultMap.put("rateList", rateList);	//费率折扣选项
//		if(rateList.size() > 0){//默认设置为第一个rateId
//			resultMap.put("rateId", rateList.get(0).getId());
//		}
		
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());
		resultMap.put("bindStateEnums", BindStateEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("searchParams", aarp);
		
		
//		channelDis
//		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
//		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
//		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
//		resultMap.put("channelListStr", channelListStr);
//		resultMap.put("channelList", channelList);
		return new ModelAndView("/activity/bind_rate_list","resultMap",resultMap);
	}
	/**
	 * @description: js/json通过参数获得折扣列表
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
	
	/**
	 * @description: 绑定折扣添加页面
	 * @param ratePo
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月14日 下午2:48:58
	 */
	@RequestMapping(value= RateURL.BIND_RATE_ADD_PAGE)
	public ModelAndView addBindRatePage(@RequestParam(value="channelDiscountId",required=false)String channelDiscountId,@RequestParam(value="billType",required=false)String billType, 
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
	 * @description: 绑定折扣添加
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
	 * @description: 编辑折扣
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
	@RequestMapping(value= RateURL.BIND_AGENCY_PAGE)
	public ModelAndView bindAgencyPage(String channelDiscountId,String activeDiscount, String rateDiscountId){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		long cId = Long.parseLong(channelDiscountId.trim());
		ChannelDiscountPo cDPo = channelDiscountDao.get(new WherePrams("id", "=", cId));
		resultMap.put("cDPo",cDPo);//显示参数
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());//显示参数
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());//显示参数
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());//显示参数
		resultMap.put("activeDiscount", activeDiscount);//折扣：显示参数
		resultMap.put("rateDiscountId", rateDiscountId);//折扣id：hidden
		return new ModelAndView("/activity/bind_agency_page", "resultMap", resultMap);
	}
	/**
	 * @description: 更新绑定状态提示页面
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
	 * @description: 通道批量绑定代理商页面 /flowsys/rate/batch_bind_agency_page
	 * @param pageNo
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午3:46:08
	 */
	@RequestMapping(value= RateURL.BATCH_BIND_AGENCY_PAGE)
	@ResponseBody
	public ModelAndView batchBindAgencyPage(@RequestParam(value = "pageNo", required = false) String pageNo,AgencyActiveRateDTO aardto, HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String, Object> resultMap = new HashMap<String, Object>();
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
		
		Pagination<AgencyBackwardVO> pagination = agencyAO.getUnbindAgency(rootAgencyId,aardto, pageParam);
		resultMap.put("searchParams", aardto);
		resultMap.put("pagination", pagination);
		resultMap.put("bindStateEnums", BindStateEnum.toBindList());
		
		return new ModelAndView("/activity/batch_bind_agency_page", "resultMap", resultMap);
//		agencyActiveChannelAO.
//		int addRes = rateDiscountDao.add(ratePo);
//		try {
//			if(addRes > 0)
//			{
//				response.getWriter().print("success");
//			}
//			else
//			{
//				response.getWriter().print("error");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("ratePo",ratePo);
	}
	/**
	 * @description: 通道批量绑定代理商 
	 * @param aardto
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 下午3:37:56
	 */
	@ResponseBody
	@RequestMapping(value=RateURL.BATCH_BIND_AGENCY)
	public void batchBindAgency(AgencyActiveRateDTO aardto,HttpServletResponse response,HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		aardto.setBindAgencyId(agencyVO.getId());
		int res = agencyActiveChannelAO.batchBindAgency(aardto);
		try {
			if(res>0){
				response.getWriter().print("success"); 
			}else{
				response.getWriter().print("error"); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @description: 欢迎界面 /flowsys/rate/welcome.do
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月19日 下午2:24:34
	 */
	@RequestMapping(value=RateURL.WELCOME)
	public ModelAndView welcome(HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String,Object> map = rateDiscountAO.getShowRate(agencyVO.getId());
		resultMap.put("map", map);
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		return new ModelAndView("/welcome", "resultMap", resultMap);
	}
	
}
