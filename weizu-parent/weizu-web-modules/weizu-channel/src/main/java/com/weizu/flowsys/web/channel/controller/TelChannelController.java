package com.weizu.flowsys.web.channel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChargeTelEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
import com.weizu.flowsys.web.channel.dao.IProcincesDAO;
import com.weizu.flowsys.web.channel.pojo.Provinces;
import com.weizu.flowsys.web.channel.url.TelChannelURL;

@Controller
@RequestMapping(value=TelChannelURL.MODOE_NAME)
public class TelChannelController {

	@Resource
	private IProcincesDAO procincesDAO;
	
	/**
	 * @description: 话费通道添加页面
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月10日 下午4:49:59
	 */
	@RequestMapping(value=TelChannelURL.TELCHANNEL_ADD_PAGE)
	public ModelAndView telChannelAddPage(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		
		resultMap.put("chargeTelEnums", ChargeTelEnum.toList());			//话费基本类型枚举
		resultMap.put("billTypes", BillTypeEnum.toList());					//商务类型
		resultMap.put("operatoerTypeEnums", OperatorTypeEnum.toList());
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		resultMap.put("channelUseStateEnums", ChannelUseStateEnum.toList());
		resultMap.put("telchargeSpeedEnums", TelchargeSpeedEnum.toList());
		
		List<Provinces> provinces = procincesDAO.getProvinces();
		resultMap.put("provinces", provinces);
//		resultMap.put("provincesJson", JSON.toJSONString(provinces));
		return new ModelAndView("/tel_channel/telchannel_add_page", "resultMap", resultMap);
		
	}
}
