package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.OrderIn;
import com.weizu.flowsys.api.singleton.ProductDTO;
import com.weizu.flowsys.api.singleton.ProductIn;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.HttpRequestPost;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
import com.weizu.flowsys.web.channel.dao.impl.ProductCodeDAOImpl;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

public class XingPeng implements BaseInterface {

	private static XingPeng instance = new XingPeng();  
	private static String epEngId;
	private static BaseP baseParams;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
//	private static String [] specialKeys = new String[]{"clientId","merchant","version"};
	private XingPeng() {
	}
	
	 public static XingPeng getInstance(String epEngId,BaseP baseParams) {  
		 XingPeng.setEpEngId(epEngId);
		 XingPeng.baseParams=baseParams;
    	return instance;  
    }
	
	
	@Override
	public ChargeDTO charge() {
		String result = toParams();
		System.out.println("返回结果:"+ result);
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(result) ){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(result);
	            boolean success = obj.getBooleanValue("success");
	    	    String resultMsg = obj.getString("msg");
	            
	            if(success){//充值成功
	            	String taskId = obj.getString("taskId");
//	            	String orderId = obj.getString("orderId");
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), resultMsg, new ChargeOrder(taskId, baseParams.getChargeTel(), baseParams.getProductCodePo().getProductCode(), 0));
	            }else{
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), resultMsg, null);
	            	System.out.println("返回值："+ result);
	            	System.out.println(success+"<--->"+resultMsg);  
	            }
			    // 最后输出到控制台  
	            chargeDTO.setJsonStr(result);//设置返回的json串日志信息
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		return chargeDTO;
	}

	@Override
	public BalanceDTO getBalance() {
		String params = toBalanceParams();
//		String resultStr = HttpRequest.sendPost(baseParams.getEpo().getEpBalanceIp(), params);
		System.out.println("返回值："+ params);
		BalanceDTO balanceDTO = null;
		try {  
            JSONObject obj = JSON.parseObject(params);
            boolean success = obj.getBooleanValue("success");
    	    String resultMsg = obj.getString("msg");
            double balance = 0.0d;
            if(success){//充值成功//查询成功
            	balance = obj.getDoubleValue("balance");
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.SUCCESS.getCode(), resultMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
            }else{
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.ERROR.getCode(), resultMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
            }
//            String epEngId = baseParams.getEpo().getEpEngId();
//            String epEngIdTag = epEngId.substring(epEngId.length()-1);
//            if("0".equals(epEngIdTag)){
//            	balanceDTO = new BalanceDTO(balance, tipCode, tipMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
//            }else{
//            	balanceDTO = new BalanceDTO(balance, tipCode, tipMsg,BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
//            }
		    // 最后输出到控制台  
            System.out.println(success+"<--->"+resultMsg + ":" + balance);  
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		String params =  toOrderParams();
//		System.out.println("返回值："+params);
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(params)){
		 		return null;
		 	}
            JSONObject obj = JSON.parseObject(params);
            boolean resultCode = obj.getBooleanValue("success");
    	    String resultMsg = obj.getString("msg");
    	    String statusMsg = "";
    	    if(resultCode){//查询成功
    	    	int orderResult = -1;
    	    	
    	    	JSONObject dataObj = obj.getJSONObject("report");
    	    	int status = dataObj.getIntValue("status");
    	    	String reportDesc = dataObj.getString("reportDesc");
    	    	
    	    	if(status == 4){//充值成功
    	    		orderResult = OrderStateEnum.CHARGED.getValue();
    	    		statusMsg = OrderStateEnum.CHARGED.getDesc();
    	    		OrderIn orderIn = new OrderIn(orderResult, statusMsg);
//            	orderIn.setCreated_at_time(created_at_time);
    	    		//用我这边默认的对私账户充值
    	    		orderDTO = new OrderDTO(orderIn, OrderResultEnum.SUCCESS.getCode(), resultMsg);
    	    	}
    	    	else if (status == 5){//充值失败
    	    		orderResult = OrderStateEnum.UNCHARGE.getValue();
    	    		OrderIn orderIn = new OrderIn(orderResult, reportDesc);
//            	orderIn.setCreated_at_time(created_at_time);
    	    		//用我这边默认的对私账户充值
    	    		orderDTO = new OrderDTO(orderIn, OrderResultEnum.SUCCESS.getCode(), resultMsg);
    	    	}
    	    }else{
    	    	orderDTO = new OrderDTO(null, OrderResultEnum.ERROR.getCode(), resultMsg);
    	    	System.out.println("查询失败:"+ resultCode +"<---------->"+resultMsg);
    	    }
    	    
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}
	@Override
	public String toParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		ProductCodePo pcPo = baseParams.getProductCodePo();
		String account = epPo.getEpUserName();
		String mobile = baseParams.getChargeTel();
		int amount = pcPo.getPgSize();
		int range = 0;//默认漫游
		if(pcPo.getServiceType().equals(ServiceTypeEnum.PROVINCE.getValue())){
			range = 1;//本地
		}
		
		StringBuffer signBuff =new StringBuffer();
		signBuff.append("account=").append(account);
		signBuff.append("&mobile=").append(mobile);
		signBuff.append("&amount=").append(amount);
		signBuff.append("&range=").append(range);
		signBuff.append("&key=").append(epPo.getEpApikey());
//		System.out.println("签名串："+signBuff.toString());
		String sign = "";
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		System.out.println("签名："+ sign);
		
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("account", account); 
		paramsMap.put("mobile", mobile); 
		paramsMap.put("amount", amount); //包体大小
		paramsMap.put("range", range); 
		paramsMap.put("orderId", baseParams.getOrderId().toString()); 
		paramsMap.put("sign", sign); 
		paramsMap.put("callbackUrl", epPo.getEpCallBackIp()); 
		String resultStr = HttpRequestPost.doPost(epPo.getEpPurchaseIp(), paramsMap);
		return resultStr;
	}
	
	
	@Override
	public String toBalanceParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		String account = epPo.getEpUserName();
		
		StringBuffer signBuff =new StringBuffer();
		signBuff.append("account=").append(account);
		signBuff.append("&key=").append(epPo.getEpApikey());
//		System.out.println("签名串："+signBuff.toString());
		String sign = "";
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		System.out.println("签名："+ sign);
		paramsMap.put("sign", sign); 
		paramsMap.put("account", account); 
		String resultStr = HttpRequestPost.doPost(epPo.getEpBalanceIp(), paramsMap);
		return resultStr;
	}

	@Override
	public String toOrderParams() {
		/**获得订单的订单状态*/
		ExchangePlatformPo epPo = baseParams.getEpo();
		
		Map<String,Object> paramsMap = new HashMap<String, Object>();
		String apiKey = epPo.getEpApikey();
		String account = epPo.getEpUserName();
		StringBuffer signBuff =new StringBuffer();
		signBuff.append("account=").append(account);
		signBuff.append("&orderId=").append(baseParams.getOrderId());
		signBuff.append("&key=").append(apiKey);
//		System.out.println("签名串："+signBuff.toString());
		String sign = "";
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paramsMap.put("account", account); 
		paramsMap.put("orderId", baseParams.getOrderId()); 
		paramsMap.put("sign", sign); 
//		System.out.println("签名："+ sign);
		String resultStr = HttpRequestPost.doPost(epPo.getEpOrderStateIp(), paramsMap);
		return resultStr;
	}

	public static String getEpEngId() {
		return epEngId;
	}

	public static void setEpEngId(String epEngId) {
		XingPeng.epEngId = epEngId;
	}
	
}
