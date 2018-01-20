package com.weizu.flowsys.web.trade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.AgencyForwardEnum;
import com.weizu.flowsys.operatorPg.enums.IsExceptionEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.trade.ao.ChargeLogAO;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;
import com.weizu.flowsys.web.trade.url.ChargeLogURL;

@RequestMapping(value=ChargeLogURL.MODEL_NAME)
@Controller
public class ChargeLogController {

	@Resource
	private ChargeLogAO chargeLogAO;
	
	/**
	 * @description: 冲单日志分页列表
	 * @param request
	 * @param chargeLog
	 * @param pageNoLong
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月13日 下午2:48:43
	 */
	@SuppressWarnings("restriction")
	@RequestMapping(value = ChargeLogURL.CHARGE_LOG_LIST)
	public ModelAndView chargeLogList(HttpServletRequest request, ChargeLog chargeLog,
			@RequestParam(value="isException",required=false)Integer isException, @RequestParam(value="pageNoLong",required=false)Long pageNoLong){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		if(agencyVO == null || agencyVO.getRootAgencyId() != 0){
			return new ModelAndView("error", "errorMsg", "不符合查看条件");
		}
		PageParam pageParam = null;
		if(pageNoLong != null){
			pageParam = new PageParam(pageNoLong, 10) ;
		}else{//初始化开始时间和结束时间
			pageParam = new PageParam(1l, 10);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Pagination<ChargeLog> pagination = chargeLogAO.list(chargeLog, pageParam,isException);
		resultMap.put("pagination", pagination);
		resultMap.put("agencyForwardEnums", AgencyForwardEnum.toList());
		resultMap.put("isExceptionEnums", IsExceptionEnum.toList());
		resultMap.put("searchParams", chargeLog);
		resultMap.put("isException", isException);
		
		resultMap.put("chargeStatusEnums", ChargeStatusEnum.toList());
		resultMap.put("orderResultEnums", OrderResultEnum.toList());
		return new ModelAndView("/trade/charge_log_list", "resultMap", resultMap);
	}
	
	/**
	 * @description: 按条件清除日志
	 * @param request
	 * @param chargeLog
	 * @param isException
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月13日 下午4:25:16
	 */
	@ResponseBody
	@RequestMapping(value=ChargeLogURL.DEL_CHARGE_LOG)
	public String delChargeLog(HttpServletRequest request, ChargeLog chargeLog,
			@RequestParam(value="isException",required=false)Integer isException){
		String res = chargeLogAO.delChargeLog(chargeLog, isException);
		return res;
	}
}
