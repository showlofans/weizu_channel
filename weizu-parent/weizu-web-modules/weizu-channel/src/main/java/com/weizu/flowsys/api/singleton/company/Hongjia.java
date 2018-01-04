package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.util.NumberUtils;
import org.weizu.api.util.HttpRequest;

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
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 微族接口实现
 * @projectName:weizu-channel
 * @className:Weizu.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 下午5:49:05
 * @version 1.0
 */
public class Hongjia implements BaseInterface {

	private static Hongjia instance = new Hongjia();  
	private static String epEngId;
	private static BaseP baseParams;
//	private static String sign;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
	
	
    private Hongjia (){}  
    public static Hongjia getInstance(String epEngId,BaseP baseParams) {  
    	Hongjia.setEpEngId(epEngId);
//    	baseParams = baseParams;
    	Hongjia.baseParams=baseParams;
//    	ExchangePlatformPo epPo = baseParams.getEpo();
    	//得到所有的参数数组
//    	String [] firstArray = StringUtil2.getArrayByCharSeq(epPo.getEpOtherParams());
//    	String [] otherArray = new String[]{"request_time"};
//    	String[] arr = new String[firstArray.length+otherArray.length];
//    	System.arraycopy(firstArray, 0, arr, 0, firstArray.length);
//    	System.arraycopy(otherArray, 0, arr, firstArray.length, otherArray.length);
//    	Arrays.sort(arr);//排序
//    	for (String key : arr) {
//			
//		}
//    	
//    	Map<String,Object> map = new TreeMap<String, Object>();
//    	map.put("", value)
    	
//    	for (String key : map.keySet()) {
//			String value = map.get(key).toString();
//		}
    	
    	
//    	try {
//    		Zxpay.sign = MD5.getMd5("username="+epPo.getEpUserName()+"&apikey="+epPo.getEpApikey(),MD5.LOWERCASE,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
    	return instance;  
    }
    
//    public static ChargeDTO charge(){
//    	String chargeTel = Weizu.baseParams.getChargeTel();
//    	System.out.println(chargeTel);
//    	return null;
//    }
    @Override
	public BalanceDTO getBalance() {
    	String params = toBalanceParams();
    	String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpBalanceIp(), params);
//    	System.out.println("完整访问地址："+baseParams.getEpo().getEpBalanceIp() +"?"+ params);
//    	System.out.println(jsonStr);
    	BalanceDTO balanceDTO = null;
    	try {  
            JSONObject obj = JSON.parseObject(jsonStr);
            int rspCode = obj.getIntValue("status");
            String rspMsg = obj.getString("message");
            System.out.println(rspCode+"<--->"+rspMsg);
            double balance = 0d;
            if(rspCode == 1){
            	JSONObject dataObj = obj.getJSONObject("data");
            	if(dataObj != null){
            		String balanceStr = dataObj.getString("balance").toString();
            		String credit = dataObj.getString("credit");//信用
            		balance = Double.parseDouble(balanceStr);
            		rspCode = OrderResultEnum.SUCCESS.getCode();
            		rspMsg += "，信用："+credit; 
            	}else{
            		rspCode = OrderResultEnum.ERROR.getCode();
            	}
            }else{
            	rspCode = OrderResultEnum.ERROR.getCode();
            }
            balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//            StringBuffer sbBalanceMsg = new StringBuffer();
//    		sbBalanceMsg.append("balance=");
//    		sbBalanceMsg.append(balance);
//    		sbBalanceMsg.append(",");
//    		sbBalanceMsg.append("credit=");
//    		sbBalanceMsg.append(credit);
//            JSONArray array = obj.getJSONArray("data");
//	        if(array != null && array.size() > 0){
//	        	for (Object object : array) {
//	        		JSONObject jsonObj = (JSONObject)object;
//	        		String balance = jsonObj.getString("balance");
//	        		String credit = jsonObj.getString("credit");
//	        		System.out.println(sbBalanceMsg.toString());
////	        	System.out.println("type=" + name);
//	        	}
//	        }
//            String epEngId = baseParams.getEpo().getEpEngId();
//            String epEngIdTag = epEngId.substring(epEngId.length()-1);
//            if("0".equals(epEngIdTag)){
//            	balanceDTO = new BalanceDTO(Double.parseDouble(balance), rspCode, rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
//            }else{
//            	balanceDTO = new BalanceDTO(balance, rspCode, sbBalanceMsg.toString(),BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
//            }
    	 } catch (JSONException e) {  
             e.printStackTrace();  
         } 
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		String[] paramsArr =  toOrderParamsArr();
		String requestIp = baseParams.getEpo().getEpOrderStateIp()+"?"+paramsArr[0];
//		System.out.println("访问地址：" + requestIp);
//		System.out.println("参数：" + paramsArr[1]);
		String jsonStr = HttpRequest.sendPost(requestIp,paramsArr[1]);
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
			System.out.println("返回值:"+jsonStr);
            JSONObject obj = JSON.parseObject(jsonStr);
            int rspCode = obj.getIntValue("status");
            String rspMsg = obj.getString("message");
//            System.out.println(rspCode);
            int myStatus = OrderStateEnum.CHARGING.getValue();
            
            if(rspCode == 1){//查询到订单状态
            	JSONObject orderObj = obj.getJSONObject("data");
            	if(orderObj != null){
            		String orderIdApi = orderObj.getString("orderid");
            		String user_order_id = orderObj.getString("transno");
            		
            		String number = orderObj.getString("phone");
            		String message = orderObj.getString("message");//订单描述
            		int status = orderObj.getIntValue("status");
            		
            		System.out.println("查询状态其他结果参数：message="+message+",number="+number);
            		switch (status) {
            		case 2://充值中
            			myStatus = OrderStateEnum.CHARGING.getValue();
            			break;
            		case 1://充值成功
            			myStatus = OrderStateEnum.CHARGED.getValue();
            			break;
            		default://充值失败
            			myStatus = OrderStateEnum.UNCHARGE.getValue();
            			break;
            		}
            		if(StringHelper.isEmpty(message)){
            			switch (status) {
            			case 2://正在充值
            				message = OrderStateEnum.CHARGING.getDesc();
            				break;
            			case 1://充值成功
            				message = OrderStateEnum.CHARGED.getDesc();
            				break;
            			default:
            				message = OrderStateEnum.UNCHARGE.getDesc();
            				break;
            			}
            		}
            		OrderIn orderId = new OrderIn(orderIdApi, user_order_id, number, null, null, System.currentTimeMillis(), myStatus, message);
//            	orderId.setCreated_at_time(created_at_time);
            		//用我这边默认的对私账户充值
            		orderDTO = new OrderDTO(orderId, rspCode, rspMsg);
            	}
            }else{//查询失败
            	System.out.print("查询参数有误：");
            	System.out.println(rspCode+"<--->"+rspMsg);
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
	public ChargeDTO charge() {
		String[] paramsArr = toParamsArr();
		String requestIp = baseParams.getEpo().getEpPurchaseIp()+"?"+paramsArr[0];
//		System.out.println("访问地址：" + requestIp);
//		System.out.println("参数：" + paramsArr[1]);
		 String jsonStr = HttpRequest.sendPost(requestIp, paramsArr[1]);
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
			 		return null;
			 	}
			 	System.out.println("返回的json结果串："+ jsonStr);
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("status");
	            String tipMsg = obj.getString("message");
	            System.out.println("message=" + tipMsg);
	            if(tipCode == 2 || tipCode == 1){//充值中(tipCode == 1){//充值成功（秒）
//	            	JSONArray array = obj.getJSONArray("data");
//	    	        if(array != null && array.size() > 0){
//	    	        	for (Object object : array) {
//	    	        		if(object != null){
//	    	        			JSONObject jsonObj = (JSONObject)object;
//	    	        			String orderIdApi = jsonObj.getString("orderid");//红茄订单号
//	    	        			String orderId = jsonObj.getString("transno");//自己传过去的订单好
//	    	        			System.out.println("自己的订单好："+orderId);
//	    	        			chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
//	    	        		}
//	    	        	}
//	    	        }
	            	JSONObject orderObj = obj.getJSONObject("data");
	            	if(orderObj != null){
	            		String orderIdApi = orderObj.getString("orderid");
	            		String orderId = orderObj.getString("transno");
	            		System.out.println("自己的订单好："+orderId.toString());
	            		chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            	}else{
	            		System.out.println("返回为空");
	            	}
	            }
	            else{//返回失败,考虑退款
	            	// 最后输出到控制台  
	            	System.out.println(tipCode+"<--->"+tipMsg);  
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), tipMsg, new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            }
//	            	String codeMsg = "";
//	            	//用我这边默认的对私账户充值
//		            switch (tipCode) {
//					case 600:
//						codeMsg = "商户禁用,接口已关闭";
//						break;
//					case 602:
//						codeMsg = "订单提交失败，未充值";
//						break;
//					case 603:
//						codeMsg = "请求数据格式错误";
//						break;
//					case 606:
//						codeMsg = "数据签名错误";
//						break;
//					case 622:
//						codeMsg = "商户不存在";
//						break;
//					case 623:
//						codeMsg = "通道维护";
//						break;
//					case 624:
//						codeMsg = "产品未配置";
//						break;
//					case 615:
//						codeMsg = "号码归属地未配置";
//						break;
//					case 625:
//						codeMsg = "重复流水号";
//						orderState = OrderStateEnum.CHARGING.getValue();//不做失败处理
//						break;
//					case 637:
//						codeMsg = "流量充值未配置";
//						break;
//					case 751:
//						codeMsg = "IP地址限制";
//						break;
//					default:
//						break;
//					}
//		            System.out.println("返回码描述信息codeMsg:"+codeMsg);
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		return chargeDTO;
	}
	
	
	/**
	 * @description: 充值参数 【0】urlAddParams【1】json参数列表
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月27日 上午11:34:19
	 */
	private String[] toParamsArr() {
		 ProductCodePo pc = baseParams.getProductCodePo();
		
		ExchangePlatformPo epPo = baseParams.getEpo();
		
//		Map<String,Object> map = new HashMap<String, Object>();
		String account = epPo.getEpUserName();
		String apiKey = epPo.getEpApikey();
		String sign = "";
		int seconds = (int) (System.currentTimeMillis()/1000);//时间戳：秒
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append(apiKey);
		String method = "rw.open.dataflow.order";
		signBuffer.append("method" + method);
		signBuffer.append("timestamp"+seconds);
		signBuffer.append("userid"+account);
		
		Map<String,Object> signMap = new HashMap<String, Object>();
		signMap.put("goodstype", getScope(pc.getServiceType()).toString());
		signMap.put("num", pc.getPgSize().toString());
		signMap.put("phone", baseParams.getChargeTel());
		signMap.put("userorderid", baseParams.getOrderId().toString());
		if(StringHelper.isNotEmpty(epPo.getEpCallBackIp())){//必须要传回调地址:CallBackEnum.POSITIVE.getValue().equals(epPo.getEpCallBack())
			signMap.put("callbackurl", epPo.getEpCallBackIp());//回调
		}else{
			signMap.put("callbackurl", "");
		}
		String jsonStr = JSON.toJSONString(signMap);
		
		signBuffer.append(jsonStr);
		signBuffer.append(apiKey);
//		System.out.println("参与签名参数："+signBuffer.toString());
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramsBuffer = new StringBuffer();
		paramsBuffer.append("userid=");
		paramsBuffer.append(account);
		paramsBuffer.append("&method=");
		paramsBuffer.append(method);
		paramsBuffer.append("&timestamp=");
		paramsBuffer.append(seconds);
		paramsBuffer.append("&sign=");
		paramsBuffer.append(sign);
//		System.out.println("sign签名"+sign);
		String [] arr = new String []{paramsBuffer.toString(),jsonStr};
		return arr;
	}
	
	public String toParams(){
		return null;
	}
	
	
	/**
	 * @description:设置业务范围
	 * @param serviceType
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月19日 上午9:44:04
	 */
	private Integer getScope(Integer serviceType){
		int scope = 3;	//默认省内流量
		if(ServiceTypeEnum.PROVINCE_ROAMING.getValue() == serviceType)
		{
			scope = 2;//分省漫游
		}
		else if(ServiceTypeEnum.NATION_WIDE.getValue() == serviceType)
		{
			scope = 1;//全国
		}
		return scope;
	}
	
	/**
	 * @description: 设置运营商
	 * @param operatorType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月21日 下午5:10:32
	 */
	private String getOperator(int operatorType){
//		boolean isMobile = OperatorTypeEnum.MOBILE.getValue().equals(operatorType);
		String operator = "01";//默认移动
		boolean isLink = OperatorTypeEnum.LINK.getValue().equals(operatorType);
		boolean isTel= OperatorTypeEnum.TELECOME.getValue().equals(operatorType);
		if(isLink){//联通
			operator = "03";
		}else if(isTel){//电信
			operator = "02";
		}
		return operator;
	}

	@Override
	public String toBalanceParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		Map<String,Object> map = new HashMap<String, Object>();
		String account = epPo.getEpUserName();
		String apiKey = epPo.getEpApikey();
		String sign = "";
		int seconds = (int) (System.currentTimeMillis()/1000);//时间戳：秒
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append(apiKey);
		String method = "rw.open.dataflow.accountquery";
		signBuffer.append("method" + method);
		signBuffer.append("timestamp"+seconds);
		signBuffer.append("userid"+account);
		signBuffer.append(apiKey);
//		System.out.println("参与签名参数："+signBuffer.toString());
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramsBuffer = new StringBuffer();
		paramsBuffer.append("method=");
		paramsBuffer.append(method);
		paramsBuffer.append("&userid=");
		paramsBuffer.append(account);
		paramsBuffer.append("&timestamp=");
		paramsBuffer.append(seconds);
		paramsBuffer.append("&sign=");
		paramsBuffer.append(sign);
//		System.out.println("sign签名"+sign);
		
//		map.put("sign", sign);
//		map.put("timestamp", seconds);
//		map.put("userid", account);
//		map.put("method", method);
		
		return paramsBuffer.toString();
//		return JSON.toJSONString(map);
	}
	@Override
	public String toOrderParams() {
//		ExchangePlatformPo epPo = baseParams.getEpo();
////ProductCodePo pc = baseParams.getProductCodePo();
////		Map<String,Object> map = new HashMap<String, Object>();
//		String account = epPo.getEpUserName();
//		String apiKey = epPo.getEpApikey();
//		String sign = "";
//		int seconds = (int) (System.currentTimeMillis()/1000);//时间戳：秒
//		StringBuffer signBuffer = new StringBuffer();
//		signBuffer.append(apiKey);
//		String method = "rw.open.dataflow.orderquery";
//		signBuffer.append("method" + method);
//		signBuffer.append("timestamp"+seconds);
//		signBuffer.append("userid"+account);
//		
//		Map<String,Object> signMap = new HashMap<String, Object>();
//		signMap.put("orderid", baseParams.getOrderIdApi());
//		signMap.put("transno", baseParams.getOrderId().toString());
//		String jsonStr = JSON.toJSONString(signMap);
//		
//		signBuffer.append(jsonStr);
//		signBuffer.append(apiKey);
//		System.out.println("参与签名参数："+signBuffer.toString());
//		try {
//			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		StringBuffer paramsBuffer = new StringBuffer();
//		paramsBuffer.append("userid=");
//		paramsBuffer.append(account);
//		paramsBuffer.append("&method=");
//		paramsBuffer.append(method);
//		paramsBuffer.append("&timestamp=");
//		paramsBuffer.append(seconds);
//		paramsBuffer.append("&sign=");
//		paramsBuffer.append(sign);
//		System.out.println("sign签名"+sign);
//		
//		return JSON.toJSONString(map);
		return null;
	}
	public String[] toOrderParamsArr() {
		ExchangePlatformPo epPo = baseParams.getEpo();
//ProductCodePo pc = baseParams.getProductCodePo();
//		Map<String,Object> map = new HashMap<String, Object>();
		String account = epPo.getEpUserName();
		String apiKey = epPo.getEpApikey();
		String sign = "";
		int seconds = (int) (System.currentTimeMillis()/1000);//时间戳：秒
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append(apiKey);
		String method = "rw.open.dataflow.orderquery";
		signBuffer.append("method" + method);
		signBuffer.append("timestamp"+seconds);
		signBuffer.append("userid"+account);
		
		Map<String,Object> signMap = new HashMap<String, Object>();
		signMap.put("orderid", baseParams.getOrderIdApi());
		signMap.put("transno", baseParams.getOrderId().toString());
		String jsonStr = JSON.toJSONString(signMap);
		
		signBuffer.append(jsonStr);
		signBuffer.append(apiKey);
//		System.out.println("参与签名参数："+signBuffer.toString());
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramsBuffer = new StringBuffer();
		paramsBuffer.append("userid=");
		paramsBuffer.append(account);
		paramsBuffer.append("&method=");
		paramsBuffer.append(method);
		paramsBuffer.append("&timestamp=");
		paramsBuffer.append(seconds);
		paramsBuffer.append("&sign=");
		paramsBuffer.append(sign);
//		System.out.println("sign签名"+sign);
		
//		return JSON.toJSONString(map);
		String [] arr = new String []{paramsBuffer.toString(),jsonStr};
		return arr;
	}
	
	private void initSign(Map<String,Object> map,String secret_key) {
		StringBuffer mdStr = new StringBuffer();
		for (String key : map.keySet()) {
			mdStr.append(key);
			mdStr.append(map.get(key) == null?"":map.get(key).toString());
		}
		mdStr.append(secret_key);
		//System.out.println("签名参数："+ mdStr.toString());
		String sign = null;
		try {
			sign = MD5.getMd5(mdStr.toString(),MD5.LOWERCASE,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		map.put("sign", sign);
	}
	public static String getEpEngId() {
		return epEngId;
	}
	public static void setEpEngId(String epEngId) {
		Hongjia.epEngId = epEngId;
	}
}
