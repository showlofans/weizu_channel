package com.weizu.flowsys.web.trade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.flowsys.web.trade.url.ChargeTelURL;

@Controller
@RequestMapping(value=ChargeTelURL.MODEL_NAME)
public class ChargeTelController {
	
	/**
	 * @description: 跳转到话费充值页面
	 * @param msg
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月30日 下午5:24:58
	 */
	@RequestMapping(value=ChargeTelURL.TEL_CHARGE_PAGE)
	public ModelAndView telChargePage(@RequestParam(value="msg",required=false)String msg,HttpServletRequest request){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(agencyVO != null){
			resultMap.put("telchargeSpeedEnums", TelchargeSpeedEnum.toList());
			resultMap.put("huaServiceTypeEnum", HuaServiceTypeEnum.toList());
			return new ModelAndView("/trade/tel_charge_page","resultMap",resultMap);
		}else{
			return new ModelAndView("error", "errorMsg", "当前登录用户不合法");
		}
	}
	
	/**
	 * @description: 异步获得话费充值编码和折扣

	 * @param telProductPo
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月1日 下午2:48:10
	 */
	@ResponseBody
	@RequestMapping(value=ChargeTelURL.AJAX_CHARGE_TELPC)
	public String ajaxTelpc(TelProductPo telProductPo,HttpServletRequest request){
		String jsonStr = "";
		return jsonStr;
	}

}
