package com.weizu.flowsys.web.channel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelStateEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelchannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.ao.TelChannelAO;
import com.weizu.flowsys.web.channel.ao.TelProductAO;
import com.weizu.flowsys.web.channel.dao.IProcincesDAO;
import com.weizu.flowsys.web.channel.pojo.Provinces;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelChannelPo;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.flowsys.web.channel.url.TelChannelURL;

@Controller
@RequestMapping(value=TelChannelURL.MODOE_NAME)
public class TelChannelController {

	@Resource
	private IProcincesDAO procincesDAO;
	@Resource
	private TelChannelAO telChannelAO;
	
	/**
	 * @description: 话费通道添加页面
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月10日 下午4:49:59
	 */
	@RequestMapping(value=TelChannelURL.TELCHANNEL_ADD_PAGE)
	public ModelAndView telChannelAddPage(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("billTypes", BillTypeEnum.toList());					//商务类型
		resultMap.put("channelUseStateEnums", ChannelUseStateEnum.toList());
		resultMap.put("chargeTelEnums", TelchannelTypeEnum.toList());			//话费基本类型枚举
		resultMap.put("telchargeSpeedEnums", TelchargeSpeedEnum.toList());
		resultMap.put("operatorNameEnums", OperatorNameEnum.toList());
		resultMap.put("serviceTypeEnums", HuaServiceTypeEnum.toList());
		
		List<Provinces> provinces = procincesDAO.getProvinces();
		resultMap.put("provinces", provinces);
//		resultMap.put("provincesJson", JSON.toJSONString(provinces));
		return new ModelAndView("/tel_channel/telchannel_add_page", "resultMap", resultMap);
		
	}
	
	@RequestMapping(value=TelChannelURL.TELCHANNEL_ADD)
	@ResponseBody
	public String addTelChannel(TelChannelPo telChannelPo){
		String res = telChannelAO.addTelChannel(telChannelPo);
		return res;
	}
	
	/**
	 * @description: 获得话费通道分页列表
	 * @param telParams
	 * @param pageNoLong
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月14日 下午5:43:04
	 */
	@RequestMapping(value=TelChannelURL.TELCHANNEL_LIST)
	public ModelAndView getTelChannel(TelChannelParams telParams,@RequestParam(value = "pageNoLong", required = false)Long pageNoLong){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("operatorNameEnums", OperatorNameEnum.toList());
		resultMap.put("serviceTypeEnums", HuaServiceTypeEnum.toList());
		resultMap.put("telchargeSpeedEnums", TelchargeSpeedEnum.toList());
		resultMap.put("billTypeEnums", BillTypeEnum.toList());
		resultMap.put("channelStateEnums", ChannelStateEnum.toList());
		resultMap.put("channelUseStateEnums", ChannelUseStateEnum.toList());
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
		Pagination<TelChannelParams> pagination = telChannelAO.getTelChannel(telParams, pageParam);
		resultMap.put("pagination", pagination);
		
		List<Provinces> provinces = procincesDAO.getProvinces();
		resultMap.put("provinces", provinces);
		resultMap.put("params", telParams);
		return new ModelAndView("/tel_channel/tel_channel_list", "resultMap", resultMap);
	}
	
	
	
}
