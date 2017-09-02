package com.weizu.flowsys.web.http.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeParams;
import com.weizu.flowsys.api.weizu.facet.IBalanceFacet;
import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
import com.weizu.flowsys.api.weizu.facet.IOrderFacet;
import com.weizu.flowsys.api.weizu.order.QueryOrderParams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.http.entity.Charge;
import com.weizu.flowsys.web.http.entity.Order;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description:对外开放的查询接口
 * @projectName:weizu-channel
 * @className:OuterAPIController.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午2:51:01
 * @version 1.0
 */
@Controller
@RequestMapping(value= OuterApiURL.MODOE_NAME)
public class OuterAPIController {
	
	@Resource
	private IBalanceFacet balanceFacade;
	@Resource
	private IChargeFacet chargeImpl;
	@Resource
	private IOrderFacet orderFacade;
	
	
	
	/**
	 * @description:
	 * @description: 查询账户余额接口
	 * @param username 账号
	 * @param sign 密钥
	 * @param billType 票务类型,不传为对公
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午5:59:57
	 */
	@RequestMapping(value=OuterApiURL.MY_BALANCE)
	@ResponseBody
	public String myBalance(String username,String sign,@RequestParam(value="billType",required=false) Integer billType){
			if(billType == null){
				billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
			}
			BalanceDTO balanceDTO = balanceFacade.myBalance(username, sign,billType);
			String jsonResult = JSON.toJSON(balanceDTO).toString();
//			response.setCharacterEncoding("UTF-8");
//			response.getWriter().print(jsonResult);
//			System.out.println(jsonResult);
			return jsonResult;
	}
	/**
	 * @description: 流量充值接口
	 * @param username
	 * @param sign
	 * @param response
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午4:48:53
	 */
	@RequestMapping(value=OuterApiURL.CHARGE)
	@ResponseBody
	public String chargePg(String userName, String number,Integer flowsize,
			@RequestParam(value="scope",required=false)Integer scope, String sign,
			@RequestParam(value="billType",required=false) Integer billType,
			@RequestParam(value="userOrderId",required=false) String userOrderId){
		if(billType == null){//默认对私
			billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
		}
		if(scope == null){//默认全国类型
			scope = ServiceTypeEnum.NATION_WIDE.getValue();
		}
		Charge charge = null;
		try {
			charge = chargeImpl.charge(new ChargeParams(userName, number, flowsize, scope, sign, billType, userOrderId));
			String jsonResult = JSON.toJSON(charge).toString();
//		System.out.println(jsonResult);
			return jsonResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @description: 查询订单详情接口
	 * @param userName
	 * @param sign
	 * @param orderId
	 * @param number
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 上午10:55:24
	 */
	@RequestMapping(value=OuterApiURL.MY_ORDER_STATE)
	public String myOrderState(String userName, String sign, Long orderId, 
			@RequestParam(value="number", required=false)String number){
		
		QueryOrderParams orderParams = null;
		if(StringHelper.isNotEmpty(number))
		{
			orderParams = new QueryOrderParams(userName, sign, orderId, number);//方便验证是否和数据库中订单充值的号码相同
		}else{
			orderParams = new QueryOrderParams(userName, sign, orderId);//方便验证是否和数据库中订单充值的号码相同
		}
		Order order = orderFacade.getOrder(orderParams);
		String jsonResult = JSON.toJSON(order).toString();
		System.out.println(jsonResult);
		return jsonResult;
	}
	
	
}
