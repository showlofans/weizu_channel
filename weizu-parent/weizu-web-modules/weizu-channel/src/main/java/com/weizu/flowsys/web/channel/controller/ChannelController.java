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
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.ServiceScopeAO;
import com.weizu.flowsys.web.activity.url.RateURL;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.channel.ao.ChannelChannelAO;
import com.weizu.flowsys.web.channel.ao.ChannelDiscountAO;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.url.ChannelURL;
import com.weizu.web.foundation.String.StringHelper;

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
	private ExchangePlatformDaoInterface exchangePlatformDao;
	
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	
	@Resource
	private ServiceScopeAO serviceScopeAO;
	
//	@Resource
//	private ChannelForwardAO channelForwardAO;
	@Resource
	private ChannelChannelAO channelChannelAO;
	
	@Resource
	private OperatorPgAO operatorPgAO;
	
	@Resource
	private ChargeAccountAo chargeAccountAO;
	@Resource
	private ChannelDiscountDao channelDiscountDao;
//	@Resource
//	private ChannelDiscountAO channelDiscountAO;
	
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
		resultMap.put("pgTypeEnums", PgTypeEnum.toList());
		resultMap.put("pgValidityEnums", PgValidityEnum.toList());
		resultMap.put("channelTypeEnums", ChannelTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("serviceTypes", ServiceTypeEnum.toList());
		resultMap.put("epFor", PgServiceTypeEnum.PGCHARGE.getValue());
		
		
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
		resultMap.put("pgSizeStr", operatorPgAO.pgSizeStr(new OneCodePo(null, ServiceTypeEnum.NATION_WIDE.getValue(), OperatorTypeEnum.MOBILE.getValue(), ScopeCityEnum.QG.getValue(), PgTypeEnum.PGDATA.getValue(), PgValidityEnum.MONTH_DAY_DATA.getValue(),ChannelTypeEnum.ORDINARY.getValue())));
		
		return new ModelAndView("/channel/channel_add_page", "resultMap", resultMap);
	}
	
	/**
	 * @description: 通道添加业务
	 * @param request
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午10:06:10
	 */
	@RequestMapping(value= ChannelURL.CHANNEL_ADD)
	@ResponseBody
	public String addChannel(HttpServletRequest request, ChannelChannelPo channelChannelPo){
//		System.out.println(channelForwardPo);
//		
		//添加代理商账户Id
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return "error";
		}else{
			channelChannelPo.setBelongAgencyId(agencyVO.getId());
			
//		List<ChannelForwardPo> list = channelForwardAO.initAddListByPo(channelForwardPo);	//初始化list
			String result = channelChannelAO.channel_addList(channelChannelPo);
			//System.out.println(result);
			
//		System.out.println(channelForwardPo.getScopeCityName());
			return result;
//			if(result > 0){
//			ChannelForwardPo channelForwardPoParam = new ChannelForwardPo();
//			channelForwardPoParam.setAgencyId(agencyVO.getId());
//			return list_channel(null, request, null);
//				return "success";
//			}else{
//			Map<String, Object> resultMap = new HashMap<String, Object>();
//			resultMap.put("pgSizeStr", channelChannelPo.getPgSize());
//			resultMap.put("channelName", channelChannelPo.getChannelName());
//				return "error";
//			return new ModelAndView("/channel/channel_add_page","resultMap",resultMap);
//			}
		}
	}
	
	/**
	 * @description:通道添加业务
	 * @param request
	 * @param channelForwardPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月10日 下午4:14:47
	 */
//	@RequestMapping(value= ChannelURL.CHANNEL_ADD)
//	public ModelAndView addChannel(HttpServletRequest request, ChannelForwardPo channelForwardPo){
////		System.out.println(channelForwardPo);
////		
//		//添加代理商账户Id
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		channelForwardPo.setAgencyId(agencyVO.getId());
//		
////		List<ChannelForwardPo> list = channelForwardAO.initAddListByPo(channelForwardPo);	//初始化list
//		int result = channelForwardAO.channel_addList(channelForwardPo);
//		//System.out.println(result);
//		
////		System.out.println(channelForwardPo.getScopeCityName());
//		
//		if(result > 0){
////			ChannelForwardPo channelForwardPoParam = new ChannelForwardPo();
////			channelForwardPoParam.setAgencyId(agencyVO.getId());
//			return list_channel(null, request, null);
//		}else{
//			Map<String, Object> resultMap = new HashMap<String, Object>();
//			resultMap.put("pgSizeStr", channelForwardPo.getPgSize());
//			resultMap.put("channelName", channelForwardPo.getChannelName());
//			return new ModelAndView("/channel/channel_add_page","resultMap",resultMap);
//		}
//	}
	
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
			HttpServletRequest request, ChannelChannelPo channelChannelPo){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		if(channelChannelPo == null){
			channelChannelPo = new ChannelChannelPo();
		}
		channelChannelPo.setBelongAgencyId(agencyVO.getId());
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{
			pageParam = new PageParam(1, 10);
		}
		Pagination<ChannelChannelPo> pagination = channelChannelAO.listChannel(pageParam, channelChannelPo);
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pagination", pagination);
		resultMap.put("searchParam", channelChannelPo);
		resultMap.put("channelStateEnums", ChannelStateEnum.toList());		//通道状态
		resultMap.put("channelUseStateEnums", ChannelUseStateEnum.toList());//
		resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());		//	
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());		//
		resultMap.put("pgTypeEnums", PgTypeEnum.toList());					//
		resultMap.put("pgValidityEnums", PgValidityEnum.toList());			//
		resultMap.put("channelTypeEnums", ChannelTypeEnum.toList());		//
		resultMap.put("billTypeEnums", BillTypeEnum.toList());				//
		
		
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
	public void changePgSizeList(OneCodePo oneCodePo,HttpServletResponse response) throws IOException{
		response.getWriter().print(operatorPgAO.pgSizeStr(oneCodePo));
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
		int updateRes = channelChannelAO.updateChannelUseState(id, channelUseState);
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
		int updateRes = channelChannelAO.updateChannelState(id, channelState);
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
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("operatorTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("serviceTypeEnums",  ServiceTypeEnum.toList());//包体类型
		return new ModelAndView("/activity/activity_channel_list","resultMap",resultMap);
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
			int delResult = channelChannelAO.deleteChannel(channelId);
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
	
	/**
	 * @description: 编辑修改通道信息
	 * @param channelPo
	 * @param ifUpdateRate
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月19日 上午9:51:38
	 */
	@ResponseBody
	@RequestMapping(value= ChannelURL.EDIT_CHANNEL_DISCOUNT)
	public String editChannelD(ChannelChannelPo channelPo,Integer ifUpdateRate){
		channelPo.setLastAccess(System.currentTimeMillis());
		String res = channelChannelAO.editChannel(channelPo, ifUpdateRate);
		return res;
	} 
	
	@RequestMapping(value= ChannelURL.CHANNEL_EDIT_PAGE)
	public ModelAndView addBindRatePage(Long channelId){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<ChannelDiscountPo> cdList = channelDiscountDao.list(new WherePrams("channel_id", "=", channelId));
		resultMap.put("cdList",cdList);
		if(cdList != null && cdList.size() > 0){
			ChannelDiscountPo cdPo = cdList.get(0);
			resultMap.put("billType",cdPo.getBillType());
			resultMap.put("operatorType",cdPo.getOperatorType());
			resultMap.put("serviceType",cdPo.getServiceType());
			resultMap.put("channelName",cdPo.getChannelName());
		}
		resultMap.put("channelId",channelId);
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		return new ModelAndView("/channel/channel_edit_page", "resultMap", resultMap);
	}
	
}
