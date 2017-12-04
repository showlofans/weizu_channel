package com.weizu.flowsys.web.agency.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
import com.weizu.flowsys.operatorPg.enums.TelChannelTagEnum;
import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;
import com.weizu.flowsys.web.agency.url.AgencyChannelURL;
import com.weizu.flowsys.web.channel.ao.TelChannelAO;
import com.weizu.flowsys.web.channel.dao.IProcincesDAO;
import com.weizu.flowsys.web.channel.pojo.Provinces;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;


/**
 * @description: 代理商通道管理(我的通道模块)
 * @projectName:weizu-channel
 * @className:AgencyChannelController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月24日 下午2:21:46
 * @version 1.0
 */
@RequestMapping(value=AgencyChannelURL.MODEL_NAME)
@Controller
public class AgencyChannelController {

	@Resource
	private IProcincesDAO procincesDAO;
	@Resource
	private TelChannelAO telChannelAO;
	
	/**
	 * @description: 获得我的话费通道
	 * @param telParams
	 * @param pageNoLong
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月24日 下午5:43:47
	 */
	@RequestMapping(value=AgencyChannelURL.TEL_CHANNEL_LIST)
	public ModelAndView getMyTelChannel(HttpServletRequest request, TelChannelParams telParams,@RequestParam(value = "pageNoLong", required = false)Long pageNoLong){
		AgencyBackwardVO agencyVO = (AgencyBackwardVO) request.getSession().getAttribute("loginContext");
		if(agencyVO == null){
			return new ModelAndView("error", "errorMsg", "系统维护之后，用户未登陆！！");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("operatorNameEnums", OperatorNameEnum.toList());
		resultMap.put("serviceTypeEnums", HuaServiceTypeEnum.toList());
		resultMap.put("telchargeSpeedEnums", TelchargeSpeedEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());					//商务类型
		resultMap.put("telChannelTagEnums", TelChannelTagEnum.toList());
//		resultMap.put("chargeTelEnums", TelchannelTypeEnum.toList());			//话费基本类型枚举
		PageParam pageParam = null;
		if(pageNoLong != null){
			pageParam  = new PageParam(pageNoLong, 10);
		}else{
			pageParam = new PageParam(1l, 10);
		}
		if(telParams.getServiceType() == null){//默认加载市内的
			telParams.setServiceType(HuaServiceTypeEnum.CITY.getValue());
		}
		if(telParams.getRateFor() == null){
			telParams.setRateFor(agencyVO.getAgencyTag());
		}
		Pagination<TelChannelParams> pagination = telChannelAO.getAgencyTelChannel(pageParam, telParams);
		resultMap.put("pagination", pagination);
		
		
		List<Provinces> provinces = procincesDAO.getProvinces();
		resultMap.put("provinces", provinces);
		resultMap.put("params", telParams);
		return new ModelAndView("/tel_channel/mytel_channel_list", "resultMap", resultMap);
	}
}
