package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.EpEncodeTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

/**
 * @description: 微族接口实现
 * @projectName:weizu-channel
 * @className:Weizu.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 下午5:49:05
 * @version 1.0
 */
public class ShunYuan implements BaseInterface {

	private static ShunYuan instance = new ShunYuan();  
	private static String epEngId;
	private static BaseP baseParams;
	private static String sign;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
	
	
    private ShunYuan (){}  
    public static ShunYuan getInstance(String epEngId,BaseP baseParams) {  
    	ShunYuan.setEpEngId(epEngId);
//    	baseParams = baseParams;
    	ShunYuan.baseParams=baseParams;
    	return instance;  
    }
    
//    public static ChargeDTO charge(){
//    	String chargeTel = Weizu.baseParams.getChargeTel();
//    	System.out.println(chargeTel);
//    	return null;
//    }
    @Override
	public BalanceDTO getBalance() {
    	String balanceParams = toBalanceParams();
//    	System.out.println("参数："+balanceParams);
//    	System.out.println("余额返回值："+jsonStr);
    	ExchangePlatformPo platPo = baseParams.getEpo();
    	String jsonStr = HttpRequest.sendGet(platPo.getEpBalanceIp(), balanceParams);
//    	System.out.println("余额返回值："+jsonStr);
    	BalanceDTO balanceDTO = null;
    	try {  
    		
            JSONObject obj = JSON.parseObject(jsonStr);
            boolean isError = obj.getBooleanValue("IsError");
            String rspMsg = obj.getString("Message");
            double balance = 0.00d;
            JSONObject dataObj = obj.getJSONObject("Data");
            if(!isError && dataObj != null){//查询正确
//            	String user = dataObj.getString("User");
            	balance = dataObj.getDoubleValue("BanancePrice");
//            	double credit = dataObj.getDoubleValue("CreditPrice");
//            	String balanceStr = dataObj.getString("BanancePrice");
//            	if(StringHelper.isNotEmpty(balanceStr)){
//            		balance = Double.parseDouble(balanceStr);
//            	}
//            	int sMSCount = dataObj.getIntValue("SMSCount");
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.SUCCESS.getCode(), rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
            }else if(isError){//查询有错
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.ERROR.getCode(), rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
            }
            
            
//            String productParams = toProductParams();
//        	String productStr = HttpRequest.sendGet(platPo.getProductListIp(),productParams);
//        	System.out.println("产品列表返回值："+productStr);
//            JSONObject obj2 = JSON.parseObject(productStr);
//            boolean isError2 = obj2.getBooleanValue("IsError");
//            String rspMsg2 = obj2.getString("Message");
//            JSONArray dataArray = obj2.getJSONArray("Data");
//            if(dataArray != null && !isError2){
//            	 for (Object object : dataArray) {
//            		 JSONObject dataObj2 = (JSONObject)object;
//            		 int flow = dataObj2.getIntValue("Flow");
//            		 int flowId = dataObj2.getIntValue("FlowId");
//            		 String flowName = dataObj2.getString("FlowName");
//            		System.out.println("流量id\t流量大小\t流量名称");
//            		 System.out.println(flowId + "\t"+flow+"\t"+flowName);
//     			}
//            }else{
//            	System.out.println("获取产品失败:"+ rspMsg2);
//            }
            
           
            
            
    	 } catch (JSONException e) {  
             e.printStackTrace();  
         } 
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		String paramsStr =  toOrderParams();
//		System.out.println("参数："+paramsStr);
		String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpOrderStateIp(),paramsStr);
//    	System.out.println("返回值："+jsonStr);
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
            JSONObject obj = JSON.parseObject(jsonStr);
            boolean isError = obj.getBooleanValue("IsError");
            String rspMsg = obj.getString("Message");
            JSONObject dataObj = obj.getJSONObject("Data");
//            System.out.println(rspCode);
            if(dataObj != null && !isError){//订单查询失败
//            	String orderIdApi = dataObj.getString("Id");
//            	String user_order_id = dataObj.getString("OrderCode");
            	
            	String msg = dataObj.getString("Message");
            	int status = dataObj.getIntValue("Status");
            	int myStatus = OrderStateEnum.UNCHARGE.getValue();
            	if(status == 10){
            		myStatus = OrderStateEnum.CHARGED.getValue();
					msg = OrderStateEnum.CHARGED.getDesc();
					OrderIn orderId = new OrderIn(myStatus, msg);
	            	//用我这边默认的对私账户充值
	            	orderDTO = new OrderDTO(orderId, status, msg);
            	}else if(status == 5){
            		myStatus = OrderStateEnum.UNCHARGE.getValue();
            		OrderIn orderId = new OrderIn(myStatus, msg);
                	//用我这边默认的对私账户充值
                	orderDTO = new OrderDTO(orderId, status, msg);
            	}
            }
            else{
            	orderDTO = new OrderDTO(null, OrderResultEnum.ERROR.getCode(), rspMsg);
    	    	System.out.println("查询失败:"+ rspMsg);
            }
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}
	@Override
	public ChargeDTO charge() {
		String params = toParams();
//		System.out.println("参数："+params);
		String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpPurchaseIp(), params);
//		System.out.println("传单结果:"+params);
		ChargeDTO chargeDTO = null;
		 try {  
			 JSONObject obj = JSON.parseObject(jsonStr);
	            boolean isError = obj.getBooleanValue("IsError");
	            String rspMsg = obj.getString("Message");
	            String orderIdApi = obj.getString("OrderId");
	            if(!isError && StringHelper.isNotEmpty(orderIdApi)){
	            	//用我这边默认的对私账户充值
	            	ChargeOrder co = new ChargeOrder();
	            	co.setOrderIdApi(orderIdApi);
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), rspMsg, co);
            		chargeDTO.setJsonStr(jsonStr);//设置返回的json串日志信息
	            }else{
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), rspMsg, null);
            		chargeDTO.setJsonStr(jsonStr);//设置返回的json串日志信息
	            }
	  
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		return chargeDTO;
	}
	
	
	/**
	 * @description: 封装充值参数方法
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月28日 上午11:39:28
	 */
	public String toParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String user = epPo.getEpUserName();
		StringBuffer signBuff = new StringBuffer();
		signBuff.append(user).append(",");
		signBuff.append(epPo.getEpApikey()).append(",");
		String time = DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss");
		signBuff.append(time);
		String sign = null;
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ProductCodePo pcPo = baseParams.getProductCodePo();
		StringBuffer sbParams = new StringBuffer();
		sbParams.append("user=").append(user);
		sbParams.append("&time=").append(time);
		sbParams.append("&mobile=").append(baseParams.getChargeTel());
//		if(EpEncodeTypeEnum.WITHOUT_CODE.getValue().equals(epPo.getEpEncodeType())){
//		}else{
//		}
		sbParams.append("&flowSize=").append(pcPo.getPgSize());//无编码
		sbParams.append("&orderCode=").append(baseParams.getOrderId());
		//本地，不传参数默认漫游
		if(ServiceTypeEnum.PROVINCE.getValue() == pcPo.getServiceType().intValue()){
			sbParams.append("&local=").append(1);
		}
		//	匹配模式 默认为自动匹配（非1值） 1为匹配到分省 如果为1的情况下 找不到当前号码分省折扣设置将直接返回错误信息
		sbParams.append("&mode=").append(1);//分省
		sbParams.append("&callback=").append(epPo.getEpCallBackIp());//回调地址
		sbParams.append("&sign=").append(sign);
		return sbParams.toString();
	}
	public String toProductParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String user = epPo.getEpUserName();
		StringBuffer signBuff = new StringBuffer();
		
		signBuff.append(user).append(",");
		signBuff.append(epPo.getEpApikey()).append(",");
		String time = DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss");
		signBuff.append(time);
		String sign = null;
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer sbParams = new StringBuffer();
		sbParams.append("user=").append(user);
		sbParams.append("&sign=").append(sign);
		sbParams.append("&time=").append(time);
//		sbParams.append("&isALL=").append(true);
		return sbParams.toString();
	}
	@Override
	public String toBalanceParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String user = epPo.getEpUserName();
		StringBuffer signBuff = new StringBuffer();
		
		signBuff.append(user).append(",");
		signBuff.append(epPo.getEpApikey()).append(",");
		String time = DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss");
		signBuff.append(time);
		String sign = null;
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer sbParams = new StringBuffer();
		sbParams.append("user=").append(user);
		sbParams.append("&sign=").append(sign);
		sbParams.append("&time=").append(time);
		return sbParams.toString();
	}
	@Override
	public String toOrderParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String user = epPo.getEpUserName();
		StringBuffer signBuff = new StringBuffer();
		
		signBuff.append(user).append(",");
		signBuff.append(epPo.getEpApikey()).append(",");
		String time = DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss");
		signBuff.append(time);
		String sign = null;
		try {
			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer sbParams = new StringBuffer();
		sbParams.append("user=").append(user);
		sbParams.append("&sign=").append(sign);
		sbParams.append("&time=").append(time);
//		sbParams.append("&orderCode=").append(baseParams.getOrderId());
		sbParams.append("&orderCode=").append(baseParams.getOrderId());
		return sbParams.toString();
	}
	
	public static String getSign() {
		return sign;
	}
	public static String getEpEngId() {
		return epEngId;
	}
	public static void setEpEngId(String epEngId) {
		ShunYuan.epEngId = epEngId;
	}
}
