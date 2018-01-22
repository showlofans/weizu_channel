package com.weizu.flowsys.web.trade.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.pojo.RatePgPo;
import com.weizu.flowsys.web.trade.url.WeChatURL;
import com.weizu.web.foundation.String.StringHelper;

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
	
//	@Resource
//	private OperatorPgAO operatorPgAO;
	@Resource
	private RateDiscountAO rateDiscountAO;
	
	@Resource
	private ChargeAccountAo chargeAccountAo;
	
//	@ResponseBody
	@RequestMapping(value=WeChatURL.INIT_FIRST_PAGE)
	public void initFirstPage(HttpServletResponse response){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(JSON.toJSONString(resultMap));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * @description: 根据业务类型和归属地获得包体
	 * @param response
	 * @param ccpp
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月18日 下午12:02:18
	 */
	@RequestMapping(value=WeChatURL.GETPG_FOR_PURCHASE)
	public void getPgForPurchase(HttpServletResponse response, ChargeChannelParamsPo ccpp){
		//参数：serviceType和carrier
		String carrier = ccpp.getCarrier();
		if(StringHelper.isNotEmpty(carrier)){
			try {
				ChargeAccountPo accountPo = chargeAccountAo.getAccountByAgencyId(231, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
				List<RatePgPo> ratePgList = rateDiscountAO.getRatePgForCharge(ccpp, accountPo.getId(), false);
				response.getWriter().print(JSON.toJSONString(ratePgList));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
