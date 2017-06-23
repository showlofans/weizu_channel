package com.weizu.flowsys.web.http.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weizu.api.outter.facade.BalanceFacade;
import org.weizu.api.outter.facade.ChargeFacade;
import org.weizu.api.outter.facade.OrderFacade;
import org.weizu.api.outter.pojo.BalanceDTO;
import org.weizu.api.outter.pojo.charge.ChargeDTO;
import org.weizu.api.outter.pojo.charge.ChargeParams;

import com.alibaba.fastjson.JSON;

/**
 * @description:对外开放的查询接口
 * @projectName:weizu-channel
 * @className:OuterAPIController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午2:51:01
 * @version 1.0
 */
@Controller
@RequestMapping(value="/weizuAPI")
public class OuterAPIController {
	
	@Resource
	private BalanceFacade balanceFacade;
	@Resource
	private ChargeFacade chargeFacade;
	@Resource
	private OrderFacade orderFacade;
	
	
	/**
	 * @description: 查询账户余额接口
	 * @param username 账号
	 * @param sign 密钥
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午2:53:26
	 */
	@RequestMapping(value="/myBalance.do")
	@ResponseBody
	public void myBalance(String username,String sign,HttpServletResponse response){
		try {
			BalanceDTO balanceDTO = balanceFacade.myBalance(username, sign);
			String jsonResult = JSON.toJSON(balanceDTO).toString();
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonResult);
			System.out.println(jsonResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @description: 流量充值接口
	 * @param username
	 * @param sign
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午4:48:53
	 */
	@RequestMapping(value="/chargePg.do")
	@ResponseBody
	public void chargePg(String userName, String number, String pgSize,
			String scope, String sign,HttpServletResponse response){
		ChargeDTO chargeDTO = null;
		try {
				
			chargeDTO = chargeFacade.charge(new ChargeParams(scope, userName, number, pgSize, sign));
			String jsonResult = JSON.toJSON(chargeDTO).toString();
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonResult);
			System.out.println(jsonResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
