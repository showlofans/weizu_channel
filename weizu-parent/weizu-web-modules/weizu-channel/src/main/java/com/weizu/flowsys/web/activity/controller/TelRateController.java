package com.weizu.flowsys.web.activity.controller;

import java.util.HashMap;
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
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelChannelTagEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.TelrateBindAccountAO;
import com.weizu.flowsys.web.activity.dao.ITelRateDao;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountPo;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;
import com.weizu.flowsys.web.activity.url.RateURL;
import com.weizu.flowsys.web.activity.url.TelRateURL;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.channel.ao.TelChannelAO;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.web.foundation.String.StringHelper;

@RequestMapping(value=TelRateURL.MODOE_NAME)
@Controller
public class TelRateController {
	
	@Resource
	private TelrateBindAccountAO telrateBindAccountAO;
	@Resource
	private TelChannelAO telChannelAO;
	@Resource
	private ITelRateDao telRateDao;
	
	@Resource
	private AgencyAO agencyAO;
//	@Resource
//	private ITelChannelDao telChannelDao;
	
	
	/**
	 * @description: 
	 * @param aarp
	 * @param channelId
	 * @param specialTag
	 * @param pageNoLong
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月16日 下午5:14:34
	 */
	@RequestMapping(value=TelRateURL.BIND_TELRATE_LIST)
	public ModelAndView getBindTelRateList(TelrateBindAccountVO tbaVO, @RequestParam(value = "pageNoLong", required = false) Long pageNoLong,HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		PageParam pageParam = null;
		if(pageNoLong != null){
			pageParam = new PageParam(pageNoLong, 10) ;
		}else{
			pageParam = new PageParam(1l, 10);
		}
		//初始化resultMap集合
		telrateBindAccountAO.getBindList(resultMap, pageParam, tbaVO);
		
		//页面通道信息
		TelChannelParams telChannelParams = telChannelAO.selectByIdType(tbaVO.getTelchannelId(), tbaVO.getServiceType());
//		resultMap.put("telChannelParams", telChannelParams);
		request.getSession().setAttribute("telChannelParams", telChannelParams);//通道信息展示参数
		
		resultMap.put("operatorNameEnums", OperatorNameEnum.toList());
		resultMap.put("huaServiceTypeEnums", HuaServiceTypeEnum.toList());
		resultMap.put("bindStateEnums", BindStateEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		
		return new ModelAndView("/activity/telRate_bind_list","resultMap",resultMap);
	}
	/**
	 * @description: 话费折扣（数据用户）添加页面<br>
	 * 来源：telRate_bind_list
	 * @param telchannelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月18日 下午2:31:23
	 */
	@RequestMapping(value=TelRateURL.TELRATE_ADD_PAGE)
	public ModelAndView telRateAddPage(Long id, Integer serviceType,@RequestParam(value="telRateId",required=false)Long telRateId){//, String fromTag
		Map<String, Object> resultMap = new HashMap<String, Object>();
		TelChannelParams telChannelParams = telChannelAO.selectByIdType(id, serviceType);
		resultMap.put("telChannelParams", telChannelParams);//通道信息展示参数
		resultMap.put("rateFor", AgencyTagEnum.DATA_USER.getValue());//费率折扣信息
		if(telRateId != null){
			TelRatePo telRatePo = telRateDao.get(telRateId);
			resultMap.put("telRatePo", telRatePo);//费率折扣信息
		}
		resultMap.put("operatorNameEnums", OperatorNameEnum.toList());
		resultMap.put("huaServiceTypeEnums", HuaServiceTypeEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("agencyTagEnums", AgencyTagEnum.toList());
		
//		resultMap.put("fromTag", fromTag);//
		return new ModelAndView("/activity/telRate_add_page","resultMap",resultMap);
	}
	/**
	 * @description:  话费折扣添加页面(平台用户)
	 * @param id
	 * @param serviceType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月22日 下午4:47:00
	 */
	@RequestMapping(value=TelRateURL.TELRATE_ADD_PAGE_PLAT)
	public ModelAndView telRateAddPagePlat(Long id, Integer serviceType){//, String fromTag
		Map<String, Object> resultMap = new HashMap<String, Object>();
		TelChannelParams telChannelParams = telChannelAO.selectByIdType(id, serviceType);
		
//		if(billType == null){
//			billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
//		}
		//一条通道只能配置一个平台折扣
		TelRatePo telRatePo = telRateDao.get(new WherePrams("telchannel_id", "=", id).and("rate_for", "=", AgencyTagEnum.PLATFORM_USER.getValue()).and("bill_type", "=", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
		resultMap.put("telRatePo", telRatePo);//费率折扣信息
		resultMap.put("rateFor", AgencyTagEnum.PLATFORM_USER.getValue());//费率折扣信息
		
		resultMap.put("telChannelParams", telChannelParams);//通道信息展示参数
		resultMap.put("operatorNameEnums", OperatorNameEnum.toList());
		resultMap.put("huaServiceTypeEnums", HuaServiceTypeEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("telChannelTagEnums", TelChannelTagEnum.toList());
		
//		resultMap.put("fromTag", fromTag);//
		return new ModelAndView("/activity/telRate_add_page","resultMap",resultMap);
	}
	
	/**
	 * @description: 异步获得平台用户折扣
	 * @param id
	 * @param serviceType
	 * @param billType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月22日 下午5:46:18
	 */
	@ResponseBody
	@RequestMapping(value=TelRateURL.AJAX_TELRATE_PLAT)
	public String ajaxTelRatePlat(Long telChannelId, Integer billType){
		TelRatePo telRatePo = telRateDao.get(new WherePrams("telchannel_id", "=", telChannelId).and("rate_for", "=", AgencyTagEnum.PLATFORM_USER.getValue()).and("bill_type", "=", billType));
		String telRateJsonStr = JSON.toJSONString(telRatePo);
		return telRateJsonStr;
	}
	
	
	/**
	 * @description: 话费折扣添加和编辑
	 * @param telRatePo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月18日 下午3:43:44
	 */
	@ResponseBody
	@RequestMapping(value=TelRateURL.TELRATE_ADD)
	public String telRateAdd(TelRatePo telRatePo){
		String resStr = "error";
		int res = 0;
		if(telRatePo.getId() != null){//编辑话费折扣
			res = telRateDao.updateLocal(telRatePo);
		}else{//添加折扣
			telRatePo.setRateType(PgServiceTypeEnum.TELCHARGE.getValue());
			res = telRateDao.add(telRatePo);
		}
		if(res > 0){
			resStr = "success";
		}
		
		return resStr;
	}
	
	/**
	 * @description: 删除折扣
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月18日 下午4:11:08
	 */
	@ResponseBody
	@RequestMapping(value=TelRateURL.DEL_TELRATE)
	public String telRateDel(Long id){
		int res = telRateDao.del(id);
		String resStr = "error";
		if(res > 0){
			resStr = "success";
		}
		return resStr;
	}
	
	/**
	 * @description: 话费折扣批量绑定代理商
	 * <br>来源：/activity/telRate_bind_list
	 * @param pageNo
	 * @param aardto
	 * @param ratePo
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午4:37:30
	 */
	@RequestMapping(value= TelRateURL.BATCH_BINDTEL_AGENCY_PAGE)
	@ResponseBody
	public ModelAndView batchBindtelAgencyPage(@RequestParam(value = "pageNo", required = false) String pageNo,TelrateBindAccountVO telrateBindAccountVO, HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(agencyVO == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		int rootAgencyId = agencyVO.getId();
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10) ;
		}else{//第一次进入页面
//			request.getSession().setAttribute("telRatePo", telRatePo);
			pageParam = new PageParam(1, 10);
		}
		//初始化绑定状态
		if(telrateBindAccountVO.getBindState() == null){
			telrateBindAccountVO.setBindState(BindStateEnum.NO.getValue());
		}
//		if(telrateBindAccountVO.getRateFor() == null){
//			telrateBindAccountVO.setRateFor(AgencyTagEnum.DATA_USER.getValue());
//		}
		//初始化代理商类型
//		if(aardto.getAgencyTag() == null){
//			aardto.setAgencyTag(AgencyTagEnum.PLATFORM_USER.getValue());
//		}
		
		Pagination<AgencyBackwardVO> pagination = agencyAO.getUnbindTelAgency(rootAgencyId, telrateBindAccountVO, pageParam);
//		resultMap.put("ratePo", ratePo);
//		if(request.getSession().getAttribute("ratePo") != null){
//			request.getSession().setAttribute("ratePo", ratePo);
//		}
		resultMap.put("telrateBindAccountVO", telrateBindAccountVO);
		resultMap.put("pagination", pagination);
		resultMap.put("bindStateEnums", BindStateEnum.toBindList());
		resultMap.put("agencyTagEnums", AgencyTagEnum.toList());
		resultMap.put("platformUser", AgencyTagEnum.PLATFORM_USER.getValue());
		resultMap.put("onameEnums", OperatorNameEnum.toList());
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
//		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		
		return new ModelAndView("/activity/batch_bindtel_agency_page", "resultMap", resultMap);
	}
	
	/**
	 * @description: :来源：batch_bindtel_agency_page.jsp changeBAllState函数
	 * <br>话费折扣全量绑定全部代理商 
	 * @param telVO
	 * @param updateBindState
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月23日 下午6:22:41
	 */
	@ResponseBody
	@RequestMapping(value=TelRateURL.BATCH_BIND_ALLAGENCY)
	public String batchBindAllAgency(TelrateBindAccountVO telrateBindAccountVO,Integer updateBindState, HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return "error";
		}
		telrateBindAccountVO.setBindAgencyId(agencyVO.getId());
		int res = telrateBindAccountAO.batchBindAllTelAgency(agencyVO.getId(), telrateBindAccountVO, updateBindState);
//		int res = accountActiveRateAO.batchBindAllAgency( agencyVO.getId(), telrateBindAccountVO, updateBindState);
		String msg = "";
		if(res>0){
			msg = "success"; 
		}else{
			msg = "error"; 
		}
		return msg;
	}
	
	/**
	 * @description: 话费折扣批量绑定代理商
	 * @param telrateBindAccountVO
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月24日 上午10:42:10
	 */
	@ResponseBody
	@RequestMapping(value=TelRateURL.BATCH_BIND_AGENCY)
	public String batchBindAgency(TelrateBindAccountVO telrateBindAccountVO,HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return "error";
		}
		telrateBindAccountVO.setBindAgencyId(agencyVO.getId());
		int res = telrateBindAccountAO.batchBindAgency(telrateBindAccountVO);
//		int res = accountActiveRateAO.batchBindAgency(aardto);
		String msg = "";
		if(res>0){
			msg = "success"; 
		}else{
			msg = "error"; 
		}
		return msg;
	}
	
	/**
	 * @description: 批量更新绑定状态（根据折扣id，批量解除绑定）
	 * @param telrateBindAccountVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月24日 上午10:52:53
	 */
	@RequestMapping(value=TelRateURL.BATCH_UPDATE_BINDTEL_STATE)
	@ResponseBody
	public String batchUpdateBindState(TelrateBindAccountVO telrateBindAccountVO)
	{
		int res = telrateBindAccountAO.batchUpdateBindState(telrateBindAccountVO);
		String result = "";
		if(res >= 0){
			result = "success";
		}else{
			result = "error";
		}
		return result;
	}
	
	/**
	 * @description: 更新话费折扣与账户的绑定状态(接口用户)
	 * @param telrateBindAccountPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月24日 下午3:17:51
	 */
	@ResponseBody
	@RequestMapping(value=TelRateURL.UPDATE_BINDTEL_STATE)
	public String updateBindTelState(TelrateBindAccountPo telrateBindAccountPo){
		String result = "error";
		 int res = telrateBindAccountAO.updateBindState(telrateBindAccountPo);
		 if(res > 0){
			 result = "success";
		 }
		return result;
	}
	
	

}
