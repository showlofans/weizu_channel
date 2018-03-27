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
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

public class Ctra implements BaseInterface {
	private static Ctra instance = new Ctra();  
	private static String epEngId;
	private static BaseP baseParams;
//	private static String sign;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
	
	
    private Ctra (){}  
    public static Ctra getInstance(String epEngId,BaseP baseParams) {  
    	Ctra.setEpEngId(epEngId);
    	Ctra.baseParams=baseParams;
    	return instance;  
    }
	
	@Override
	public ChargeDTO charge() {
		String params = toParams();
		ExchangePlatformPo epPo = baseParams.getEpo();
		System.out.println("请求参数："+params);
		String returnJson = HttpRequest.sendPost(epPo.getEpPurchaseIp(), params);
		if(returnJson == null){
			return null;
		}
		try {
			JSONObject obj = JSON.parseObject(returnJson);
			boolean code = obj.getBooleanValue("code");
			int rspCode = OrderResultEnum.ERROR.getCode();
			String rspMsg = "";
			if(code){
				JSONArray subArray = obj.getJSONArray("data");
				for (Object object : subArray) {
					JSONObject subObj = (JSONObject)object;
					String created = subObj.get("created").toString();
					String orderIdStr = subObj.get("req_sn").toString();
					String orderIdApi = subObj.get("order_sn").toString();
					String prod_code = subObj.get("prod_code").toString();
					String order_stat = subObj.get("order_stat").toString();
					String mob_no = subObj.get("mob_no").toString();
					String err_code = subObj.get("err_code").toString();
					String err_msg = subObj.get("err_msg").toString();
					if("0".equals(order_stat) && "0000".equals(err_code)){
			    		//System.out.println("自己的订单好："+orderId.toString());
						ChargeDTO chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), err_msg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
						chargeDTO.setJsonStr(returnJson);
			    		return chargeDTO;
					}else{
						System.out.println(returnJson);
						JSONObject subObj2 = obj.getJSONObject("data");
						rspMsg = subObj2.get("err_msg").toString();
						ChargeDTO chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), "杭州弯流:"+rspMsg, new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
						chargeDTO.setJsonStr(returnJson);
						System.out.println(returnJson);
						System.out.println(err_msg);
			    		return chargeDTO;
					}
				}
			}else{
				System.out.println(returnJson);
				JSONObject subObj2 = obj.getJSONObject("data");
				rspMsg = subObj2.get("err_msg").toString();
				
				ChargeDTO chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), "杭州弯流:"+rspMsg, new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
				chargeDTO.setJsonStr(returnJson);
				return chargeDTO;
			}
		} catch (Exception e) {
			ChargeDTO chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), "杭州弯流:Json解析异常", new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
			chargeDTO.setJsonStr(returnJson);
			System.out.println(returnJson);
			return chargeDTO;
		}
		return null;
	}

	@Override
	public BalanceDTO getBalance() {
		String balanceParams = toBalanceParams();
		System.out.println("余额参数："+balanceParams);
		ExchangePlatformPo epPo = baseParams.getEpo();
		String returnJson = HttpRequest.sendPost(epPo.getEpBalanceIp(), balanceParams);
		JSONObject obj = JSON.parseObject(returnJson);
		 double balance = 0d;
		boolean code = obj.getBooleanValue("code");
		int rspCode = OrderResultEnum.ERROR.getCode();
		String rspMsg = "";
		if(code){
			JSONObject subObj = obj.getJSONObject("data");
			if(subObj != null){
				String balanceStr = subObj.get("balance").toString();
				String time = subObj.get("time").toString();
				balance = Double.parseDouble(balanceStr);
				rspCode = OrderResultEnum.SUCCESS.getCode();
			}
		}else{
			System.out.println(returnJson);
			rspMsg = obj.get("errmsg").toString();
		}
		BalanceDTO balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String params = toOrderParams();
		System.out.println("参数：" + params);
		String jsonStr = HttpRequest.sendPost(epPo.getEpOrderStateIp(),params);
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
			System.out.println("返回值:"+jsonStr);
            JSONObject obj = JSON.parseObject(jsonStr);
            boolean code = obj.getBooleanValue("code");
            String rspMsg = obj.getString("message");
//            System.out.println(rspCode);
            int myStatus = OrderStateEnum.CHARGING.getValue();
            
            if(code){//查询到订单状态
            	JSONArray subArray = obj.getJSONArray("data");
            	if(subArray != null){
	    			for (Object object : subArray) {
	    				JSONObject orderObj = (JSONObject)object;
	    				String time = orderObj.get("time").toString();
	    				String orderIdStr = orderObj.get("req_sn").toString();
	    				String orderIdApi = orderObj.get("order_sn").toString();
	    				String prod_code = orderObj.get("prod_code").toString();
	    				String order_stat = orderObj.get("order_stat").toString();
	    				String mob_no = orderObj.get("mob_no").toString();
	    				String err_code = orderObj.get("err_code").toString();
	    				String err_msg = orderObj.get("err_msg").toString();
//	    				System.out.println("查询状态其他结果参数：message="+message+",number="+number);
	    				if("0".equals(order_stat) || "9".equals(order_stat)){
	    					myStatus = OrderStateEnum.CHARGING.getValue();
	    				}else if("99".equals(order_stat)){
	    					myStatus = OrderStateEnum.CHARGED.getValue();
	    				}else{
	    					myStatus = OrderStateEnum.UNCHARGE.getValue();
	    				}
	    				if(StringHelper.isEmpty(err_msg)){
	    					switch (myStatus) {
	    					case 2://正在充值
	    						err_msg = OrderStateEnum.CHARGING.getDesc();
	    						break;
	    					case 1://充值成功
	    						err_msg = OrderStateEnum.CHARGED.getDesc();
	    						break;
	    					default:
	    						err_msg = OrderStateEnum.UNCHARGE.getDesc();
	    						break;
	    					}
	    				}
	    				OrderIn orderId = new OrderIn(orderIdApi, orderIdStr, mob_no, null, null, System.currentTimeMillis(), myStatus, err_msg);
	    				orderDTO = new OrderDTO(orderId, myStatus, rspMsg);
	    			}
//            	orderId.setCreated_at_time(created_at_time);
            		//用我这边默认的对私账户充值
            	}
            }else{//查询失败
            	System.out.print("查询返回："+jsonStr);
            	String errmsg = obj.getString("errmsg");
            	System.out.println(errmsg+"<--->"+errmsg);
//            	String errorMsg = "";
//            	switch (rspCode) {
//				case 603:
//					errorMsg = "请求数据不正确或查询异常";
//					break;
//				case 606:
//					errorMsg = "数据签名错误";
//					break;
//				case 751:
//					errorMsg = "IP地址限制";
//					break;
//
//				default:
//					errorMsg = "其他返回码" + rspCode;
//					break;
//				}
//            	System.out.println("查询状态错误信息：" +errorMsg);
            }
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}

	@Override
	public String toParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		//custcode 
		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		Long nowTime = System.currentTimeMillis() / 1000;
		String signStr = epPo.getEpApikey() + nowTime;
		paramsMap.put("timestamp", nowTime);
		String sign = "";
		try {
			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paramsMap.put("sign", sign);
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		map.put("req_sn", baseParams.getOrderId().toString());
		map.put("mob_no", baseParams.getChargeTel());
		map.put("prod_code", baseParams.getProductCodePo().getProductCode()); 
		mapList.add(map);
//		String mapStr = JSON.toJSONString(map);
//		String[] tx_info = new String [] {mapStr};
		paramsMap.put("tx_info", mapList);
		return JSON.toJSONString(paramsMap);
	}

	@Override
	public String toBalanceParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		//custcode 
		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		Long nowTime = System.currentTimeMillis() / 1000;
		paramsMap.put("timestamp", nowTime);
		String signStr = epPo.getEpApikey() + nowTime;
//		System.out.println("签名串："+ signStr);
		String sign = "";
		try {
			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paramsMap.put("sign", sign);
		return JSON.toJSONString(paramsMap);
		
	}

	@Override
	public String toOrderParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		//custcode 
		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		Long nowTime = System.currentTimeMillis() / 1000;
		String signStr = epPo.getEpApikey() + nowTime;
		paramsMap.put("timestamp", nowTime);
		String sign = "";
		try {
			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paramsMap.put("sign", sign);
		String [] req_sn = new String[]{baseParams.getOrderId().toString()};
		paramsMap.put("req_sn", req_sn);
		return JSON.toJSONString(paramsMap);
	}
	public static String getEpEngId() {
		return epEngId;
	}
	public static void setEpEngId(String epEngId) {
		Ctra.epEngId = epEngId;
	}
	
	

}
