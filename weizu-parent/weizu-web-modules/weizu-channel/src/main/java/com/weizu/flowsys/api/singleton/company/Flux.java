package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.OrderIn;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

public class Flux implements BaseInterface {
	private static Flux instance = new Flux();  
	private static String epEngId;
	private static BaseP baseParams;
//	private static String sign;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
	
	
    private Flux (){}  
    public static Flux getInstance(String epEngId,BaseP baseParams) {  
    	Flux.setEpEngId(epEngId);
    	Flux.baseParams=baseParams;
    	return instance;  
    }
	
	@Override
	public ChargeDTO charge() {
		String params = toParams();
		ExchangePlatformPo epPo = baseParams.getEpo();
		System.out.println("请求参数："+params);
		String otherParams = epPo.getEpOtherParams();
		String url = epPo.getEpPurchaseIp();
		url += "?" + otherParams.substring(0, otherParams.length()-1);
		String returnJson = HttpRequest.sendPost(url, params);
		if(returnJson == null){
			return null;
		}
		try {
			JSONObject obj = JSON.parseObject(returnJson);
			JSONObject headerObj = obj.getJSONObject("header");
			
			int errcode = headerObj.getIntValue("errcode");
			String rspMsg = headerObj.get("errmsg").toString();
			if(errcode == 0){
				JSONObject payloadObj = obj.getJSONObject("payload");
				JSONObject dataObj = payloadObj.getJSONObject("data");
				//System.out.println("自己的订单好："+orderId.toString());
				String orderIdApi = dataObj.get("orderid").toString();
				ChargeDTO chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), rspMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
				chargeDTO.setJsonStr(returnJson);
				return chargeDTO;
			}else{
				System.out.println(returnJson);
				ChargeDTO chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), rspMsg, new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
				chargeDTO.setJsonStr(returnJson);
				return chargeDTO;
			}
		} catch (Exception e) {
			ChargeDTO chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), "生东网络平台:Json解析异常", new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
			chargeDTO.setJsonStr(returnJson);
			System.out.println(returnJson);
			return chargeDTO;
		}
	}

	@Override
	public BalanceDTO getBalance() {
		String balanceParams = toBalanceParams();
//		System.out.println("余额参数："+balanceParams);
		ExchangePlatformPo epPo = baseParams.getEpo();
		String otherParams = epPo.getEpOtherParams();
		String url = epPo.getEpBalanceIp();
		url += "?" + otherParams.substring(0, otherParams.length()-1);
		String returnJson = HttpRequest.sendPost(url, balanceParams);
		System.out.println("返回值:"+returnJson);
//		JSONObject obj = JSON.parseObject(returnJson);
//		 double balance = 0d;
//		boolean code = obj.getBooleanValue("code");
//		int rspCode = OrderResultEnum.ERROR.getCode();
//		String rspMsg = "";
//		if(code){
//			JSONObject subObj = obj.getJSONObject("data");
//			if(subObj != null){
//				String balanceStr = subObj.get("balance").toString();
//				String time = subObj.get("time").toString();
//				balance = Double.parseDouble(balanceStr);
//				rspCode = OrderResultEnum.SUCCESS.getCode();
//			}
//		}else{
//			System.out.println(returnJson);
//			rspMsg = obj.get("errmsg").toString();
//		}
//		BalanceDTO balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		return balanceDTO;
		return null;
	}

	@Override
	public OrderDTO getOrderState() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String params = toOrderParams();
		System.out.println("参数：" + params);
		String jsonStr = HttpRequest.sendGet(epPo.getEpOrderStateIp(),params);
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
			System.out.println("返回值:"+jsonStr);
			JSONObject obj = JSON.parseObject(jsonStr);
			JSONObject headerObj = obj.getJSONObject("header");
			
			int errcode = headerObj.getIntValue("errcode");
			String rspMsg = headerObj.get("errmsg").toString();
			int myStatus = -1; 
			if(errcode == 0){
				JSONObject payloadObj = obj.getJSONObject("payload");
				JSONObject dataObj = payloadObj.getJSONObject("data");
				//System.out.println("自己的订单好："+orderId.toString());
				int result = dataObj.getIntValue("result");
				String msg = "";
				if(result == 1){//失败
					msg = dataObj.getString("desc");
					 myStatus = OrderStateEnum.UNCHARGE.getValue();
				}else if(result == 0){//成功
					myStatus = OrderStateEnum.CHARGED.getValue();
					msg = OrderStateEnum.CHARGED.getDesc();
				}else{//2-尚未充值
					msg = OrderStateEnum.CHARGING.getDesc();
					myStatus = OrderStateEnum.CHARGING.getValue();
				}
				OrderIn orderId = new OrderIn(myStatus, msg);
            	//用我这边默认的对私账户充值
            	orderDTO = new OrderDTO(orderId, errcode, rspMsg);
				return orderDTO;
			}
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}

	@Override
	public String toParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String userName = epPo.getEpUserName();
		Map<String,Object> headerMap = new HashMap<String, Object>();
		Long nowTime = System.currentTimeMillis();
		String timestamp = DateUtil.formatPramm(nowTime, "yyyyMMddHHmmss");
		headerMap.put("timestamp", timestamp);
		headerMap.put("identity", nowTime.toString());
		headerMap.put("type", "json");
		
		ProductCodePo pcPo = baseParams.getProductCodePo();
		String pgValidity = pcPo.getPgValidity();
		boolean oneDay = PgValidityEnum.ONE_DAY_DATA.getValue().equals(pgValidity) ;
		int scope = 0;
		int expiration = 1;//月包
		if(oneDay){
			scope = 3;//日包
		}else{
			int serviceType = pcPo.getServiceType();
			if(serviceType == ServiceTypeEnum.NATION_WIDE.getValue() || serviceType == ServiceTypeEnum.PROVINCE_ROAMING.getValue()){
				scope = 1;
			}else{
				scope = 2;
			}
			if(PgValidityEnum.HALF_YEAR_DATA.getValue().equals(pgValidity)){
				expiration = 6;//半年包
			}else if (PgValidityEnum.ONE_SEASON_DATA.getValue().equals(pgValidity)){
				expiration = 3;//季包
			}else if(PgValidityEnum.ONE_YEAR_DATA.getValue().equals(pgValidity)){
				expiration = 12;//季包
			}
		}
		Integer activeflag = 0;//0-当月，1-下月
		String orderno = baseParams.getOrderId().toString();
//		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		StringBuffer signBuff = new StringBuffer();
		signBuff.append(timestamp).append(userName).append(epPo.getEpApikey()).append(scope);
		signBuff.append(orderno).append(baseParams.getChargeTel()).append(activeflag);
		signBuff.append(expiration).append(pcPo.getPgSize());
//		System.out.println("签名串："+ signStr);
		String sign = "";
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		headerMap.put("sign", sign);
		Map<String,Object> payloadMap = new HashMap<String, Object>();
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user", userName);
		dataMap.put("scope", scope);
		dataMap.put("orderno", orderno);
		dataMap.put("mobile", baseParams.getChargeTel());
		dataMap.put("activeflag", activeflag);
		dataMap.put("expiration", expiration);
		dataMap.put("fluxnum", pcPo.getPgSize());
		payloadMap.put("data", dataMap);
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("header", headerMap);
		paramsMap.put("payload", payloadMap);
		return JSON.toJSONString(paramsMap);
	}

	@Override
	public String toBalanceParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String userName = epPo.getEpUserName();
		Map<String,Object> headerMap = new HashMap<String, Object>();
		Long nowTime = System.currentTimeMillis();
		String timestamp = DateUtil.formatPramm(nowTime, "yyyyMMddHHmmss");
		headerMap.put("timestamp", timestamp);
		headerMap.put("identity", nowTime.toString());
		headerMap.put("type", "json");
		
//		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		String signStr = timestamp + userName + epPo.getEpApikey();
//		System.out.println("签名串："+ signStr);
		String sign = "";
		try {
			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		headerMap.put("sign", sign);
		Map<String,Object> payloadMap = new HashMap<String, Object>();
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user", userName);
		payloadMap.put("data", dataMap);
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("header", headerMap);
		paramsMap.put("payload", payloadMap);
		return JSON.toJSONString(paramsMap);
		
	}

	@Override
	public String toOrderParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
//		String epOtherParams = epPo.getEpOtherParams();
		StringBuffer paramsB = new StringBuffer(epPo.getEpOtherParams());
		paramsB.append("orderid=");
		paramsB.append(baseParams.getOrderIdApi());
		return paramsB.toString();
	}
	public static String getEpEngId() {
		return epEngId;
	}
	public static void setEpEngId(String epEngId) {
		Flux.epEngId = epEngId;
	}
	
	

}
