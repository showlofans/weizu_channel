package com.weizu.flowsys.web.http.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeParams;
import com.weizu.flowsys.api.weizu.charge.PgProductParams;
import com.weizu.flowsys.api.weizu.facet.IBalanceFacet;
import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
import com.weizu.flowsys.api.weizu.facet.IOrderFacet;
import com.weizu.flowsys.api.weizu.facet.IPgProductFacet;
import com.weizu.flowsys.api.weizu.order.QueryOrderParams;
import com.weizu.flowsys.operatorPg.enums.AgencyForwardEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.AddressUtils;
import com.weizu.flowsys.web.http.entity.Charge;
import com.weizu.flowsys.web.http.entity.Order;
import com.weizu.flowsys.web.http.entity.PgProduct;
import com.weizu.flowsys.web.http.entity.PurchaseLog;
import com.weizu.flowsys.web.trade.dao.ChargeLogDao;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;
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
	@Resource
	private IPgProductFacet pgProductFacdeImpl;
	@Resource
	private ChargeLogDao chargeLogDao;
	
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
	@RequestMapping(value=OuterApiURL.MY_BALANCE,produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String myBalance(String userName,String sign,@RequestParam(value="billType",required=false) Integer billType){
			if(billType == null){
				billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
			}
			BalanceDTO balanceDTO = balanceFacade.myBalance(userName, sign,billType);
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
	@RequestMapping(value=OuterApiURL.CHARGE,produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String chargePg(String userName, String number,Integer pgSize, String sign,
			@RequestParam(value="scope",required=false)Integer scope,
			@RequestParam(value="billType",required=false) Integer billType,
			@RequestParam(value="channelType",required=false) Integer channelType,
			@RequestParam(value="pgType",required=false) Integer pgType,
			@RequestParam(value="pgValidity",required=false) String pgValidity,
			@RequestParam(value="reportUrl",required=false) String reportUrl,
			@RequestParam(value="userOrderId",required=false) String userOrderId,HttpServletRequest request){
		if(billType == null){//默认对公
			billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
		}
		if(scope == null){//默认省漫游类型
			scope = ServiceTypeEnum.PROVINCE_ROAMING.getValue();
		}
		Long currentTime = System.currentTimeMillis();
		ChargeParams chargeParams = new ChargeParams(userName, number, pgSize, scope, sign, billType,currentTime);
		if(pgType == null)
		{
			pgType = PgTypeEnum.PGDATA.getValue();
		}
		if(StringHelper.isEmpty(pgValidity ))
		{
			pgValidity = PgValidityEnum.MONTH_DAY_DATA.getValue();
		}
		if(channelType == null){
			channelType = ChannelTypeEnum.ORDINARY.getValue();
		}
		chargeParams.setPgType(pgType);
		chargeParams.setPgValidity(pgValidity);
		chargeParams.setChannelType(channelType);
		if(StringHelper.isNotEmpty(userOrderId)){
			chargeParams.setOrderIdFrom(userOrderId);
		}
		if(StringHelper.isNotEmpty(reportUrl)){
			chargeParams.setReportUrl(reportUrl);
		}
		try {
			 String ip = addressUtils.getIp(request);
			chargeParams.setRequestIp(ip);
		} catch (Exception e1) {
			chargeParams.setRequestIp("未知ip");
			e1.printStackTrace();
		}
		Charge charge = null;
		try {
			//System.out.println("传单参数：" + chargeParams.toString());
			charge = chargeImpl.charge(chargeParams);
		} catch (Exception e) {
			ChargeLog chargeLog = new ChargeLog(chargeParams.toString(), "无返回，有异常", null, chargeParams.getNumber(), ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), chargeParams.getOrderArriveTime(),AgencyForwardEnum.BACKWARD.getValue(),chargeParams.getRequestIp()+ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc());
			chargeLogDao.add(chargeLog);
			charge = new Charge(ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc(), null);
			e.printStackTrace();
		}
//		Purchase
		//根据charge获得返回的订单号，结果，结果描述，
		//根据穿入的参数，设定其他参数的传单日志（根据日志，能判定订单情况，从而手动生成订单和扣款记录）
		
		String jsonResult = JSON.toJSON(charge).toString();
//		System.out.println(jsonResult);
		return jsonResult;
	}
	@Resource
	private AddressUtils addressUtils;
	
	/**
	 * @description: 查询订单详情接口
	 * @param userName
	 * @param sign
	 * @param orderId
	 * @param number
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 上午10:55:24
	 */
	@ResponseBody
	@RequestMapping(value=OuterApiURL.MY_ORDER_STATE,produces = "text/json;charset=UTF-8")
	public String myOrderState(String userName, String sign, Long orderId, 
			@RequestParam(value="number", required=false)String number,HttpServletRequest request){
		try {
			String remoteIp = addressUtils.getIp(request);
			System.out.println("请求地址："+request.getRequestURL()+"访问ip:"+remoteIp);
		} catch (Exception e) {
			System.out.println("请求地址："+request.getRequestURL()+"访问ip:"+"未识别地址");
			e.printStackTrace();
		}
//		Map<String,Object> addressMap  = addressUtils.getAddresses(request, "utf-8");
//		String address = addressMap.get("address").toString();
//		String eventIp = addressMap.get("ip").toString();
		QueryOrderParams orderParams = null;
		if(StringHelper.isNotEmpty(number))
		{
			orderParams = new QueryOrderParams(userName, sign, orderId, number);//方便验证是否和数据库中订单充值的号码相同
		}else{
			orderParams = new QueryOrderParams(userName, sign, orderId);//方便验证是否和数据库中订单充值的号码相同
		}
		Order order = orderFacade.getOrder(orderParams);
		String jsonResult = JSON.toJSON(order).toString();
//		System.out.println(jsonResult);
		return jsonResult;
	}
	
	/**
	 * @description: 获得流量产品列表
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月9日 下午2:15:56
	 */
	@ResponseBody
	@RequestMapping(value=OuterApiURL.MY_PGPRODUCT_LIST,method=RequestMethod.GET)
	public String myProductList(String userName,String sign,@RequestParam(value="operaterType", required=false)Integer operaterType){
		PgProductParams pgParams = new PgProductParams(sign, userName);
		pgParams.setOperaterType(operaterType);
		PgProduct pgProduct = pgProductFacdeImpl.getPgProductList(pgParams);
		String jsonResult = JSON.toJSON(pgProduct).toString();
		System.out.println(jsonResult);
		return jsonResult;
	}
//	public String
	
	
}
