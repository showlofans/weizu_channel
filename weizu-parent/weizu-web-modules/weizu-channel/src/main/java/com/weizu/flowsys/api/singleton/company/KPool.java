package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
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

public class KPool implements BaseInterface {

	private static KPool instance = new KPool();  
	private static String epEngId;
	private static BaseP baseParams;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
//	private static String [] specialKeys = new String[]{"clientId","merchant","version"};
	private KPool() {
	}
	
	 public static KPool getInstance(String epEngId,BaseP baseParams) {  
		 KPool.setEpEngId(epEngId);
		 KPool.baseParams=baseParams;
    	return instance;  
    }
	
	
	@Override
	public ChargeDTO charge() {
		String result = toParams();
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(result) || "exception".equals(result)){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(result);
	            String resultCode = obj.getString("resultCode");
	    	    String resultMsg = obj.getString("resultMsg");
	            
	            if("T00001".equals(resultCode)){//查询成功
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), resultMsg, new ChargeOrder(resultMsg, baseParams.getChargeTel(), baseParams.getProductCodePo().getProductCode(), 0));
	            }else{
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), resultMsg, null);
	            	System.out.println("返回值："+ result);
	            	System.out.println(resultCode+"<--->"+resultMsg);  
	            }
	          //用我这边默认的对私账户充值
//	            String epEngId = epPo.getEpEngId();
//	            int billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
//	            if("0".equals(epEngId.substring(epEngId.length()-1))){//英文标识最后一个字符是0表示对私
//	            	billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
//	            }
	            //用我这边默认的对私账户充值
//	            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCode(), billType));
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
//		System.out.println("返回值："+ params);
		BalanceDTO balanceDTO = null;
		try {  
            JSONObject obj = JSON.parseObject(params);
    	    String resultCode = obj.getString("resultCode");
    	    String resultMsg = obj.getString("resultMsg");
            double balance = 0.0d;
            if("T00002".equals(resultCode)){//查询成功
            	if(StringHelper.isNotEmpty(resultMsg)){
            		balance = Double.parseDouble(resultMsg);
            	}
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.SUCCESS.getCode(), "成功",BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
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
            System.out.println(resultCode+"<--->"+resultMsg + ":" + balance);  
  
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
			if(StringHelper.isEmpty(params) || "exception".equals(params)){
		 		return null;
		 	}
            JSONObject obj = JSON.parseObject(params);
            String resultCode = obj.getString("resultCode");
    	    String resultMsg = obj.getString("resultMsg");
    	    if("T00002".equals(resultCode)){//查询成功
    	    	int orderResult = -1;
    	    	String statusMsg = "";
    	    	if("2".equals(resultMsg)){//充值成功
    	    		orderResult = OrderStateEnum.CHARGED.getValue();
    	    		statusMsg = OrderStateEnum.CHARGED.getDesc();
    	    	}
    	    	else if ("3".equals(resultMsg)){//充值失败
    	    		orderResult = OrderStateEnum.UNCHARGE.getValue();
    	    		statusMsg = OrderStateEnum.UNCHARGE.getDesc();
    	    	}
    	    	OrderIn orderIn = new OrderIn(orderResult, statusMsg);
//            	orderIn.setCreated_at_time(created_at_time);
            	//用我这边默认的对私账户充值
            	orderDTO = new OrderDTO(orderIn, OrderResultEnum.SUCCESS.getCode(), resultMsg);
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
		String mobile = baseParams.getChargeTel();
		String productid = pcPo.getProductCode();
		String notifyurl = epPo.getEpCallBackIp();
		
		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		String refer = StringUtil2.getParamsByCharSeq(epPo.getEpOtherParams(), "userid");
		String userid = refer.substring(refer.indexOf("=")+1);
		
		String apiKey = epPo.getEpApikey();
		StringBuffer signBuff =new StringBuffer();
		signBuff.append(userid).append(mobile).append(productid).append(apiKey);
//		System.out.println("签名串："+signStr);
		String sign = "";
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paramsMap.put("userid", userid); 
		paramsMap.put("mobile", mobile); 
		paramsMap.put("bizid", baseParams.getOrderId()); 
		paramsMap.put("productid", productid); 
		paramsMap.put("notifyurl", notifyurl); 
		paramsMap.put("key", sign); 
//		System.out.println("签名："+ sign);
		String resultStr = HttpRequestPost.doPost(epPo.getEpPurchaseIp(), paramsMap);
		return resultStr;
	}
	
	
	@Override
	public String toBalanceParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		String refer = StringUtil2.getParamsByCharSeq(epPo.getEpOtherParams(), "userid");
		String userid = refer.substring(refer.indexOf("=")+1);
		String apiKey = epPo.getEpApikey();
		String signStr = userid + apiKey;
//		System.out.println("签名串："+signStr);
		String sign = "";
		try {
			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paramsMap.put("key", sign); 
		paramsMap.put("userid", userid); 
//		System.out.println("签名："+ sign);
		String resultStr = HttpRequestPost.doPost(epPo.getEpBalanceIp(), paramsMap);
		return resultStr;
	}

	@Override
	public String toOrderParams() {
		/**获得订单的订单状态*/
		ExchangePlatformPo epPo = baseParams.getEpo();
		
		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		String refer = StringUtil2.getParamsByCharSeq(epPo.getEpOtherParams(), "userid");
		String userid = refer.substring(refer.indexOf("=")+1);
		
		String apiKey = epPo.getEpApikey();
		StringBuffer signBuff =new StringBuffer(userid);
		String orderid = baseParams.getOrderIdApi();//上游订单
		if(StringHelper.isNotEmpty(orderid)){
			signBuff.append(orderid);
			paramsMap.put("orderid", orderid);
		}
		Long orderId = baseParams.getOrderId();//自己订单 
		if(orderId != null){
			String bizid = orderId.toString();
			signBuff.append(bizid);
			paramsMap.put("bizid", bizid);
		}
		signBuff.append(apiKey);
//		System.out.println("签名串："+signStr);
		String sign = "";
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paramsMap.put("userid", userid); 
		paramsMap.put("key", sign); 
//		System.out.println("签名："+ sign);
		String resultStr = HttpRequestPost.doPost(epPo.getEpPurchaseIp(), paramsMap);
		return resultStr;
	}

	public static String getEpEngId() {
		return epEngId;
	}

	public static void setEpEngId(String epEngId) {
		KPool.epEngId = epEngId;
	}
	
}
