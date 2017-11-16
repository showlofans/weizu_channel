package com.weizu.flowsys.web.activity.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.activity.ao.TelrateBindAccountAO;
import com.weizu.flowsys.web.activity.pojo.TelrateBindAccountVO;
import com.weizu.flowsys.web.activity.url.TelRateURL;

@RequestMapping(value=TelRateURL.MODOE_NAME)
@Controller
public class TelRateController {
	
	@Resource
	private TelrateBindAccountAO telrateBindAccountAO;
	
	
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
		resultMap.put("otypeEnums", OperatorTypeEnum.toList());
		resultMap.put("stypeEnums", ServiceTypeEnum.toList());
		resultMap.put("bindStateEnums", BindStateEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("scopeCityEnums", ScopeCityEnum.toList());
		
		return new ModelAndView("/activity/telrate_bind_list","resultMap",resultMap);
	}

}
