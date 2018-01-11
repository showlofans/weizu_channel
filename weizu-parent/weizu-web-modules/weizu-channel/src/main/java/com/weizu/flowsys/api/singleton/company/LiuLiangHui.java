package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
import com.weizu.flowsys.web.channel.dao.impl.ProductCodeDAOImpl;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

public class LiuLiangHui implements BaseInterface {

	private static LiuLiangHui instance = new LiuLiangHui();  
	private static String epEngId;
	private static BaseP baseParams;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
//	private static String [] specialKeys = new String[]{"clientId","merchant","version"};
	private LiuLiangHui() {
	}
	
	 public static LiuLiangHui getInstance(String epEngId,BaseP baseParams) {  
		 LiuLiangHui.setEpEngId(epEngId);
		 LiuLiangHui.baseParams=baseParams;
    	return instance;  
    }
	
	
	@Override
	public ChargeDTO charge() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String params = toParams();
		System.out.println(epPo.getEpPurchaseIp()+"?"+params);
		 String jsonStr = HttpRequest.sendPost(epPo.getEpPurchaseIp(), params);
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
			 		return null;
			 	}
			 	System.out.println(jsonStr);
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int code = obj.getIntValue("code");
	            String message = obj.getString("code_desc");
//	            String orderId = obj.getString("out_trade_no");
	          //用我这边默认的对私账户充值
	            if(code == 0){
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), message, new ChargeOrder(baseParams.getOrderId().toString(), baseParams.getChargeTel(), baseParams.getProductCodePo().getProductCode(), 0));
	            }
	            else if(code == -1){
	            	System.out.println("充值余额不zu");
	            }
	            else{
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), message, null);
	            }
//	            String epEngId = epPo.getEpEngId();
//	            int billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
//	            if("0".equals(epEngId.substring(epEngId.length()-1))){//英文标识最后一个字符是0表示对私
//	            	billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
//	            }
	            //用我这边默认的对私账户充值
//	            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCode(), billType));
			    // 最后输出到控制台  
	            System.out.println(code+"<--->"+message);  
	  
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		return chargeDTO;
	}

	@Override
	public BalanceDTO getBalance() {
		String resultStr = HttpRequest.sendGet(baseParams.getEpo().getEpBalanceIp(), toBalanceParams());
		BalanceDTO balanceDTO = null;
		try {  
            JSONObject obj = JSON.parseObject(resultStr);
            int tipCode = obj.getIntValue("Code");
    	    String tipMsg = obj.getString("Message");
    	    String balanceStr = obj.getString("Balance");
            double balance = 0.00d;
            
            if(tipCode == 0){//查询成功
            	if(StringHelper.isNotEmpty(balanceStr)){
            		balance = Double.parseDouble(balanceStr);
            	}
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.SUCCESS.getCode(), tipMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
            }else{
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.ERROR.getCode(), tipMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
            }
//            String epEngId = baseParams.getEpo().getEpEngId();
//            String epEngIdTag = epEngId.substring(epEngId.length()-1);
//            if("0".equals(epEngIdTag)){
//            	balanceDTO = new BalanceDTO(balance, tipCode, tipMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
//            }else{
//            	balanceDTO = new BalanceDTO(balance, tipCode, tipMsg,BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
//            }
		    // 最后输出到控制台  
            System.out.println(tipMsg+"<--->"+tipMsg + ":" + balance);  
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
		//获得产品列表
//		ProductDTO productDTO = getProduct();
//		
//		if(productDTO != null){
//			  // 最后输出到控制台  
//	        System.out.println(productDTO.getRspCode()+"<--->"+productDTO.getRspMsg());
//	        
//	        List<ProductIn> getList = productDTO.getProductInList();
//	        if(getList != null){
//	        	for (ProductIn productIn : getList) {
////	        		System.out.println(productIn.getOperator() + "\tname=" + productIn.getName() + "\tprice=" + productIn.getPrice() + "\t" + productIn.getPg());
//					System.out.println(productIn.toString());
//				}
//	        }
//		}else{
//			System.out.println("没有该类型产品");
//		}
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		String paramsStr =  toOrderParams();
		String jsonStr = HttpRequest.sendPost(baseParams.getEpo().getEpOrderStateIp(),paramsStr);
		System.out.println(baseParams.getEpo().getEpOrderStateIp() +'?' + paramsStr);
		OrderDTO orderDTO = null;
		String statusMsg = "";
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
            JSONObject obj = JSON.parseObject(jsonStr);
            System.out.println(jsonStr);
            int tipCode = obj.getIntValue("code");
    	    String tipMsg = obj.getString("code_desc");
    	    if(tipCode == 0){//查询到订单状态
            	JSONObject orderObj = obj.getJSONObject("data");
            	if(orderObj != null){
            		String orderIdApi = orderObj.getString("transaction_id");
            		String user_order_id = orderObj.getString("out_trade_no");
            		
            		String number = orderObj.getString("phone");
            		String money = orderObj.getString("money");//订单描述
            		int status = orderObj.getIntValue("code");
            		String code_desc = obj.getString("code_desc");
            		System.out.println("充值状态码："+ status);
            		System.out.println("查询状态其他结果参数：money="+money+",number="+number);
//            		if(code == 0){
//            			OrderIn orderId = new OrderIn(orderIdApi, user_order_id, number, null, null, System.currentTimeMillis(), myStatus, message);
//            		}
            		int myStatus = -1;
            		switch (status) {
            		case 1://充值中
            			myStatus = OrderStateEnum.CHARGING.getValue();
            			break;
            		case 0://充值成功
            			myStatus = OrderStateEnum.CHARGED.getValue();
            			break;
            		default://充值失败
            			myStatus = OrderStateEnum.UNCHARGE.getValue();
            			break;
            		}
//            		if(StringHelper.isEmpty(message)){
//            			switch (status) {
//            			case 2://正在充值
//            				message = OrderStateEnum.CHARGING.getDesc();
//            				break;
//            			case 1://充值成功
//            				message = OrderStateEnum.CHARGED.getDesc();
//            				break;
//            			default:
//            				message = OrderStateEnum.UNCHARGE.getDesc();
//            				break;
//            			}
//            		}
            		OrderIn orderId = new OrderIn(orderIdApi, user_order_id, number, null, null, System.currentTimeMillis(), myStatus, code_desc);
//            	orderId.setCreated_at_time(created_at_time);
            		//用我这边默认的对私账户充值
            		orderDTO = new OrderDTO(orderId, tipCode, tipMsg);
            	}
            }else{//查询失败
            	System.out.print("查询参数有误：");
//            	System.out.println(rspCode+"<--->"+rspMsg);
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
		
		ExchangePlatformPo platformPo = baseParams.getEpo();
		//{"goods_id","mch_id","mch_time","notify_url","out_trade_no","phone",}
		
		ProductCodePo pc = baseParams.getProductCodePo();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("goods_id=");
		signBuffer.append(pc.getProductCode());
		signBuffer.append("&");
		signBuffer.append(platformPo.getEpOtherParams());//商户号
//		signBuffer.append("&mch_id=");
//		signBuffer.append(platformPo.getEpUserName());
		signBuffer.append("mch_time=");
		String timeStr = DateUtil.formatAll(System.currentTimeMillis());
		signBuffer.append(timeStr);
		if(CallBackEnum.POSITIVE.getValue().equals(platformPo.getEpCallBack()) && StringHelper.isNotEmpty(platformPo.getEpCallBackIp())){
			signBuffer.append("&notify_url=").append(platformPo.getEpCallBackIp());
		}
		signBuffer.append("&out_trade_no=");
		signBuffer.append(baseParams.getOrderId());
		signBuffer.append("&phone=");
		signBuffer.append(baseParams.getChargeTel());
		signBuffer.append(platformPo.getEpApikey());
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
			System.out.println("充值sign编码参数："+ signBuffer.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//{"goods_id","mch_id","mch_time","notify_url","out_trade_no","phone",}
		Map<String,Object> signMap = new HashMap<String, Object>();
		signMap.put("goods_id", pc.getProductCode());
		String refer = StringUtil2.getParamsByCharSeq(platformPo.getEpOtherParams(), "mch_id");
		signMap.put("mch_id", refer.substring(refer.indexOf("=")+1)); 
		signMap.put("mch_time", timeStr);
		if(CallBackEnum.POSITIVE.getValue().equals(platformPo.getEpCallBack()) && StringHelper.isNotEmpty(platformPo.getEpCallBackIp())){
			signMap.put("notify_url", platformPo.getEpCallBackIp());
		}
		signMap.put("out_trade_no", baseParams.getOrderId());
		signMap.put("phone", baseParams.getChargeTel());
		signMap.put("sign", sign);
		String jsonStr = JSON.toJSONString(signMap);
		System.out.println(jsonStr);
		return jsonStr;
	}
	
//	private int getPackageType(ProductCodePo productPo){
//		int packageType = 1;
//		Integer circulateWay = productPo.getCirculateWay();
//		String pgValidity = productPo.getPgValidity();
//		if(ChannelTypeEnum.RED_PACKET.getValue().equals(circulateWay)){
//			packageType = 2;
//		}
//		else if(ChannelTypeEnum.MOBILE.getValue().equals(circulateWay)){
//			packageType = 3;
//		}
//		else if(PgValidityEnum.ONE_DAY_DATA.getValue().equals(pgValidity)){
//			packageType = 5;
//		}
//		else if(PgValidityEnum.THREE_DAY_DATA.getValue().equals(pgValidity)){
//			packageType = 6;
//		}
//		else if(PgValidityEnum.SEVEN_DAY_DATA.getValue().equals(pgValidity)){
//			packageType = 7;
//		}
//		else if(PgValidityEnum.ONE_SEASON_DATA.getValue().equals(pgValidity)){
//			packageType = 8;
//		}
//		else if(PgValidityEnum.HALF_YEAR_DATA.getValue().equals(pgValidity)){
//			packageType = 9;
//		}
//		else if(PgValidityEnum.ONE_YEAR_DATA.getValue().equals(pgValidity)){
//			packageType = 10;
//		}
//		return packageType;//月包
//	}
	
	/**
	 * @description: 获得流量范围
	 * @param serviceType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月15日 下午3:10:36
	 */
//	private int getRange(Integer serviceType){
//		int range = 0;
//		if(ServiceTypeEnum.NATION_WIDE.getValue() == serviceType){
//			range = 0;
//		}
//		else if(ServiceTypeEnum.PROVINCE_ROAMING.getValue() == serviceType){
//			range = 2;
//		}
//		else if(ServiceTypeEnum.PROVINCE.getValue() == serviceType){
//			range = 3;
//		}else{
//			range = 1;		//全国非漫游
//		}
//		return range;
//	}
	
//	private String getChargeSign(String epOtherParams){
//		ExchangePlatformPo platformPo = baseParams.getEpo();
//		String account = platformPo.getEpUserName();
////		String otherParams = platformPo.getEpOtherParams(); //按照升序排好的
//		StringBuffer signBuffer = new StringBuffer();
//		signBuffer.append("account=");
//		signBuffer.append(account);
//		signBuffer.append("&");
//		signBuffer.append(epOtherParams);
//		signBuffer.append("mobile=");
//		signBuffer.append(baseParams.getChargeTel());
//		signBuffer.append("&package=");
//		signBuffer.append(baseParams.getProductCode());
//		String sign = "";
//		try {
//			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return sign;
//	}

	@Override
	public String toBalanceParams() {
		ExchangePlatformPo platformPo = baseParams.getEpo();
		String account = platformPo.getEpUserName();
		String apiKey = platformPo.getEpApikey();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(account);
		signBuffer.append("&key=");
		signBuffer.append(apiKey);
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramsBuffer = new StringBuffer();
		
		paramsBuffer.append(platformPo.getEpOtherParams());
		paramsBuffer.append("action=getBalance");
		paramsBuffer.append("&account=");
		paramsBuffer.append(account);
		paramsBuffer.append("&sign=");
		paramsBuffer.append(sign);
		
		return paramsBuffer.toString();
	}

	@Override
	public String toOrderParams() {
		/**获得订单的订单状态*/
		ExchangePlatformPo platformPo = baseParams.getEpo();
		String account = platformPo.getEpUserName();
		String key = platformPo.getEpApikey();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("mch_id=");
		signBuffer.append(platformPo.getEpUserName());
		signBuffer.append("&out_trade_no=");
		signBuffer.append(baseParams.getOrderId());
		signBuffer.append("&time=");
		String time = DateUtil.formatAll(System.currentTimeMillis());
		signBuffer.append(DateUtil.formatAll(System.currentTimeMillis()));
		signBuffer.append(key);
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map<String,Object> signMap = new HashMap<String, Object>();
		signMap.put("mch_id", platformPo.getEpUserName());
		signMap.put("time", time);
		signMap.put("out_trade_no", baseParams.getOrderId().toString());
		signMap.put("sign", sign);
		String jsonStr = JSON.toJSONString(signMap);
		System.out.println(jsonStr);
		return jsonStr;
	}

	public static String getEpEngId() {
		return epEngId;
	}

	public static void setEpEngId(String epEngId) {
		LiuLiangHui.epEngId = epEngId;
	}
	
}
