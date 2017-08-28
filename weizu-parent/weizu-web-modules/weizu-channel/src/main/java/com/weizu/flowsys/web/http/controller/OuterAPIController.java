//package com.weizu.flowsys.web.http.controller;
//
//import java.io.IOException;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.weizu.api.outter.facade.BalanceFacade;
//import org.weizu.api.outter.facade.ChargeFacade;
//import org.weizu.api.outter.facade.OrderFacade;
//import org.weizu.api.outter.pojo.BalanceDTO;
//import org.weizu.api.outter.pojo.charge.ChargeDTO;
//import org.weizu.api.outter.pojo.charge.ChargeParams;
//import org.weizu.api.outter.pojo.order.OrderDTO;
//import org.weizu.api.outter.pojo.order.OrderParams;
//
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
//import com.weizu.flowsys.web.http.OuterApiURL;
//import com.weizu.web.foundation.String.StringHelper;
//
///**
// * @description:对外开放的查询接口
// * @projectName:weizu-channel
// * @className:OuterAPIController.java
// * @author:POP产品研发部 宁强
// * @createTime:2017年6月23日 下午2:51:01
// * @version 1.0
// */
//@Controller
//@RequestMapping(value= OuterApiURL.MODOE_NAME)
//public class OuterAPIController {
//	
//	@Resource
//	private BalanceFacade balanceFacade;
//	@Resource
//	private ChargeFacade chargeFacade;
//	@Resource
//	private OrderFacade orderFacade;
//	
//	
//	/**
//	 * @description: 查询账户余额接口
//	 * @param username 账号
//	 * @param sign 密钥
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月23日 下午2:53:26
//	 */
//	@RequestMapping(value=OuterApiURL.MY_BALANCE)
//	@ResponseBody
//	public String myBalance(String username,String sign){
////		try {
//			BalanceDTO balanceDTO = balanceFacade.myBalance(username, sign);
//			String jsonResult = JSON.toJSON(balanceDTO).toString();
////			response.setCharacterEncoding("UTF-8");
////			response.getWriter().print(jsonResult);
//			System.out.println(jsonResult);
//			return jsonResult;
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//	}
//	/**
//	 * @description: 流量充值接口
//	 * @param username
//	 * @param sign
//	 * @param response
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月23日 下午4:48:53
//	 */
//	@RequestMapping(value=OuterApiURL.CHARGE)
//	@ResponseBody
//	public String chargePg(String userName, String number, String pgSize,
//			String scope, String sign,@RequestParam(value="billType",required=false) Integer billType){
//		ChargeDTO chargeDTO = null;
//		if(billType == null){//默认对私
//			int bType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
////			chargeDTO = chargeFacade.charge(new ChargeParams( userName, number, pgSize,scope, sign, bType));
//		}else{
////			chargeDTO = chargeFacade.charge(new ChargeParams(userName, number, pgSize, scope, sign, billType));
//		}
//		String jsonResult = JSON.toJSON(chargeDTO).toString();
//		System.out.println(jsonResult);
//		return jsonResult;
//	}
//	
//	/**
//	 * @description: 查询订单详情接口
//	 * @param userName
//	 * @param sign
//	 * @param orderId
//	 * @param number
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月26日 上午10:55:24
//	 */
//	@RequestMapping(value=OuterApiURL.MY_ORDER_STATE)
//	public String myOrderState(String userName, String sign, String orderId, 
//			@RequestParam(value="number", required=false)String number,HttpServletResponse response){
//		OrderDTO orderDTO = null;
//		
//		OrderParams op =  new OrderParams(userName, sign, orderId);
//		if(StringHelper.isNotEmpty(number))
//		{
//			op.setNumber(number);//方便验证是否和数据库中订单充值的号码相同
//		}
//		orderDTO = orderFacade.checkOrder(op);
//			String jsonResult = JSON.toJSON(orderDTO).toString();
//			System.out.println(jsonResult);
//		return jsonResult;
//	}
//	
//	
//}
