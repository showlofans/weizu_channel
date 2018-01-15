package com.weizu.flowsys.web.trade.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.trade.url.WeChatURL;

/**
 * @description: 微信小程序数据接口
 * @projectName:weizu-channel
 * @className:WeChatController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月15日 下午2:42:32
 * @version 1.0
 */
@Controller
@RequestMapping(value=WeChatURL.MODEL_NAME)
public class WeChatController {
	
	@ResponseBody
	@RequestMapping(value=WeChatURL.INIT_FIRST_PAGE)
	public String initFirstPage(){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		
		return JSON.toJSONString(resultMap);
	}
}
