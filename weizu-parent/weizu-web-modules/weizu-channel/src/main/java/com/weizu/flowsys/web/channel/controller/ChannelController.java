package com.weizu.flowsys.web.channel.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.ServiceScopeAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.ChannelForwardAO;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
import com.weizu.flowsys.web.channel.pojo.ChannelForwardPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.url.ChannelURL;

/**
 * @description:上级通道控制层
 * @projectName:crud
 * @className:ChannelController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 下午3:47:43
 * @version 1.0
 */
@Controller
@RequestMapping(value = ChannelURL.MODOE_NAME)
public class ChannelController {
	
	@Resource
	private ExchangePlatformDao exchangePlatformDao;
	
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	
	@Resource
	private ServiceScopeAO serviceScopeAO;
	
	@Resource
	private ChannelForwardAO channelForwardAO;
	
	@Resource
	private OperatorPgAO operatorPgAO;
	
	@Resource
	private ChargeAccountAo chargeAccountAO;
	
	/**
	 * @description:通道添加页面
	 * @param request
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午4:15:02
	 */
	@RequestMapping(value= ChannelURL.CHANNEL_ADD_PAGE)
	public ModelAndView addChannelPage(HttpServletRequest request){
//		List operatorTypes = serviceScopeAO.listOperatorType();
//		List scopeCityNames = serviceScopeAO.listScopeCityName();
//		List serviceTypes = serviceScopeAO.listServiceType();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("operatorTypes", OperatorTypeEnum.toList());
		resultMap.put("scopeCityNames", ScopeCityEnum.toList());
		resultMap.put("serviceTypes", ServiceTypeEnum.toList());
		
		//查看代理商有没有对公的账户
		//默认对私通道
		//ChargeAccountPo chargeAccount =  (ChargeAccountPo)request.getSession().getAttribute("chargeAccount");
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		if(agencyVO != null){
//			ChargeAccountPo chargeAccount = chargeAccountAO.getAccountByAgencyId(agencyVO.getId(), BillTypeEnum.CORPORATE_BUSINESS.getValue());
//			if(chargeAccount != null)
//			{
//				resultMap.put("billType", BillTypeEnum.CORPORATE_BUSINESS.getValue());
//			}
//		}
//		
//		
		resultMap.put("billTypes", BillTypeEnum.toList());
		//默认用移动的包体
		resultMap.put("pgSizeStr", operatorPgAO.pgSizeStr(0,0));
		
		return new ModelAndView("/channel/channel_add_page", "resultMap", resultMap);
	}
	
	/**
	 * @description:通道添加业务
	 * @param request
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午4:14:47
	 */
	@RequestMapping(value= ChannelURL.CHANNEL_ADD)
	public ModelAndView addChannel(HttpServletRequest request, ChannelForwardPo channelForwardPo){
//		System.out.println(channelForwardPo);
//		
		//添加代理商账户Id
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		channelForwardPo.setAgencyId(agencyVO.getId());
		
		List<ChannelForwardPo> list = channelForwardAO.initAddListByPo(channelForwardPo);	//初始化list
		int result = channelForwardAO.channel_addList(list);
		//System.out.println(result);
		
//		System.out.println(channelForwardPo.getScopeCityName());
		
		if(result > 0){
//			ChannelForwardPo channelForwardPoParam = new ChannelForwardPo();
//			channelForwardPoParam.setAgencyId(agencyVO.getId());
			return list_channel(null, request, null);
		}else{
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("pgSizeStr", channelForwardPo.getPgSize());
			resultMap.put("channelName", channelForwardPo.getChannelName());
			return new ModelAndView("/channel/channel_add_page","resultMap",resultMap);
		}
	}
	
	/**
	 * @description:通道列表
	 * @param request
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午3:47:52
	 */
	@RequestMapping(value= ChannelURL.CHANNEL_LIST)
	public ModelAndView list_channel(@RequestParam(value = "pageNo", required = false) String pageNo,
			HttpServletRequest request, ChannelForwardPo channelForwardPo){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		if(channelForwardPo == null){
			channelForwardPo = new ChannelForwardPo();
		}
		channelForwardPo.setAgencyId(agencyVO.getId());
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{
			pageParam = new PageParam(1, 10);
		}
		Pagination<ChannelForwardPo> pagination = channelForwardAO.listChannel(pageParam, channelForwardPo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pagination", pagination);
		resultMap.put("searchParam", channelForwardPo);
		resultMap.put("channelStateEnums", ChannelStateEnum.toList());
		resultMap.put("channelUseStateEnums", ChannelUseStateEnum.toList());
		resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		
		
		return new ModelAndView("/channel/channel_list", "resultMap", resultMap); 
	}
	
	/**
	 * @description:根据运营商类型改变通道规格
	 * @param operatorType
	 * @param response
	 * @throws IOException
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午12:45:16
	 */
	@RequestMapping(value= ChannelURL.CHANGE_CHANNEL_PGSIZE)
	@ResponseBody
	public void changePgSizeList(String operatorType,String serviceType,HttpServletResponse response) throws IOException{
		response.getWriter().print(operatorPgAO.pgSizeStr(Integer.parseInt(operatorType),Integer.parseInt(serviceType)));
	}
	
	/**
	 * @description:平台搜索
	 * @param response
	 * @param requet
	 * @param epName
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月5日 下午12:12:45
	 */
	@RequestMapping(value = ChannelURL.SEARCH_PLATFORM)
	public void getPlatformByName(HttpServletResponse response, HttpServletRequest requet,String epName){
		
		try {
			requet.setCharacterEncoding("utf-8");
//			epName = new String(epName.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		System.out.println(epName);
		ExchangePlatformPo exchangePlatformPo = exchangePlatformAO.getEpByEpName(epName);
//		 JSONObject json = new JSONObject();
		
//		 json.put("exchangePlatformPo", exchangePlatformPo);
		
			try {
				if(exchangePlatformPo != null){ 
		            response.getWriter().print( JSONObject.toJSON(exchangePlatformPo).toString());
		            response.getWriter().close();
		        } else{
					response.getWriter().print( JSONObject.toJSON("错误字符串").toString());
		            response.getWriter().close();
					System.out.println("错误字符串");
				}
			}
			catch (IOException e) {
	            System.out.println(e);
	        }
	}
	
	/**
	 * @description: 通道使用状态更新
	 * @param id
	 * @param channelUseState
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 下午12:02:12
	 */
	@RequestMapping(value=ChannelURL.CHANNEL_USE_STATE_UPDATE)
	public void updateUseState(String id, String channelUseState, HttpServletResponse response){
		int updateRes = channelForwardAO.updateChannelUseState(id, channelUseState);
		response.setContentType("text/html;charset=utf-8");
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
	 * @description: 通道状态更新
	 * @param id
	 * @param channelUseState
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月27日 下午12:02:17
	 */
	@RequestMapping(value=ChannelURL.CHANNEL_STATE_UPDATE)
	public void updateState(String id, String channelState, HttpServletResponse response){
		int updateRes = channelForwardAO.updateChannelState(id, channelState);
		response.setContentType("text/html;charset=utf-8");
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
	 * @description: 活动通道列表
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 上午11:36:49
	 */
	@RequestMapping(value=ChannelURL.ACTIVITY_CHANNEL_LIST)
	public ModelAndView activityChannelList(){
		return new ModelAndView("/channel/activity_channel_list");
	}
	/**
	 * @description: 下架删除通道
	 * @param channelId
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月1日 下午3:29:53
	 */
	@RequestMapping(value=ChannelURL.CHANNEL_DELETE)
	@ResponseBody
	public void deleteChannel(String channelId,HttpServletResponse response){
		try {
			int delResult = channelForwardAO.deleteChannel(channelId);
			if(delResult > 0){
				response.getWriter().print("success");
			}else{
				response.getWriter().print("error");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return new ModelAndView("/channel/activity_channel_list");
	}
	
}
