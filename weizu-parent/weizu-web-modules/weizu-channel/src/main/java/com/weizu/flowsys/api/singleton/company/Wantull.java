package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;

import org.weizu.api.util.HttpRequest;

import com.alibaba.fastjson.JSON;
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
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

//@Service(value="wantull")
public class Wantull implements BaseInterface {

	private static Wantull instance = new Wantull();  
	private static String epEngId;
	private static BaseP baseParams;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
	
//	private static String [] specialKeys = new String[]{"clientId","merchant","version"};
	private Wantull() {
	}
	
	 public static Wantull getInstance(String epEngId,BaseP baseParams) {  
		 Wantull.setEpEngId(epEngId);
		 Wantull.baseParams=baseParams;
    	return instance;  
    }
	
	
	@Override
	public ChargeDTO charge() {
		String params = toParams();
		ExchangePlatformPo epPo = baseParams.getEpo();
		//System.out.println(epPo.getEpPurchaseIp()+"?"+params);
		 String jsonStr = HttpRequest.sendGet(epPo.getEpPurchaseIp(), params);
		 
		 ChargeDTO chargeDTO = null;
		 System.out.println(jsonStr);
		 try {  
			 	if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("code");
	            String tipMsg = obj.getString("msg");
	            String orderIdApi = obj.getString("trade_no");
//	            String orderId = obj.getString("out_trade_no");
//	            if()
	            
	          //用我这边默认的对私账户充值
	            if(tipCode == 1){
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), tipMsg, new ChargeOrder(orderIdApi, null, null, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            }else{
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), tipMsg, new ChargeOrder(orderIdApi, null, null, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            }
	            chargeDTO.setJsonStr(jsonStr);//设置返回的json串日志信息
//	            String epEngId = epPo.getEpEngId();
//	            int billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
//	            if("0".equals(epEngId.substring(epEngId.length()-1))){//英文标识最后一个字符是0表示对私
//	            	billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
//	            }
	            //用我这边默认的对私账户充值
//	            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCode(), billType));
			    // 最后输出到控制台  
	            System.out.println(tipCode+"<--->"+tipMsg);  
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
            int tipCode = obj.getIntValue("code");
    	    String tipMsg = obj.getString("msg");
    	    String balanceStr = obj.getString("balance");
            double balance = 0.00d;
            if(tipCode == 1){//查询成功
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
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		String paramsStr =  toOrderParams();
		String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpOrderStateIp(),paramsStr);
		OrderDTO orderDTO = null;
		String statusMsg = "";
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
            JSONObject obj = JSON.parseObject(jsonStr);
            int rspCode = obj.getIntValue("code");
            String rspMsg = obj.getString("msg");
            if(rspCode != 1){//查询失败
            	//用我这边默认的对私账户充值
            	orderDTO = new OrderDTO(null, OrderResultEnum.ERROR.getCode(), "查询失败");
            }else{
            	String out_trade_no = obj.getString("out_trade_no");
            	String trade_no = obj.getString("trade_no");
            	int charge_status = obj.getIntValue("charge_status");
            	String mobile = obj.getString("mobile");
            	String packageId = obj.getString("package");
//            	Long created_at_time = 0l;
            	int myStatus = OrderStateEnum.UNCHARGE.getValue();
            	switch (charge_status) {
            	case 4://充值成功
            		myStatus = OrderStateEnum.CHARGED.getValue();
            		break;
            	case 5://充值失败
            		myStatus = OrderStateEnum.UNCHARGE.getValue();
            		break;
            	case 8://正在充值
            		myStatus = OrderStateEnum.CHARGING.getValue();
            		break;
            	default:
            		break;
            	}
//            	if(StringHelper.isEmpty(msg)){
            		switch (charge_status) {
                	case 4://充值成功
                		statusMsg = OrderStateEnum.CHARGED.getDesc();
                		break;
                	case 5://充值失败
                		statusMsg =  "充值失败";
                		break;
                	case 8://正在充值
                		statusMsg = OrderStateEnum.CHARGING.getDesc();
                		break;
                	default:
                		break;
                	}
//            	}
            	OrderIn orderIn = new OrderIn(trade_no, out_trade_no, mobile, packageId, null, System.currentTimeMillis(), myStatus, statusMsg);
//            	orderIn.setCreated_at_time(created_at_time);
            	//用我这边默认的对私账户充值
            	orderDTO = new OrderDTO(orderIn, rspCode, rspMsg);
//            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, number, pgSize, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
            	// 最后输出到控制台  
//            System.out.println(tipCode+"<--->"+tipMsg);  
            	
            }
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}

	@Override
	public String toParams() {
		ExchangePlatformPo platformPo = baseParams.getEpo();
		String sign = "";
		ProductCodePo pc = baseParams.getProductCodePo();
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(platformPo.getEpUserName());
		signBuffer.append("&");
		signBuffer.append(platformPo.getEpOtherParams());
		signBuffer.append("mobile=");
		signBuffer.append(baseParams.getChargeTel());
		signBuffer.append("&package=");
		signBuffer.append(pc.getProductCode());
		signBuffer.append("&app_secret=");
		signBuffer.append(platformPo.getEpApikey());
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
			System.out.println("充值sign编码参数："+ signBuffer.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		StringBuffer paramBuffer = new StringBuffer();
		paramBuffer.append("account=");
		paramBuffer.append(platformPo.getEpUserName());
		paramBuffer.append("&");
		paramBuffer.append(platformPo.getEpOtherParams());
		paramBuffer.append("mobile=");
		paramBuffer.append(baseParams.getChargeTel());
		paramBuffer.append("&out_trade_no=");
		paramBuffer.append(baseParams.getOrderId());
		paramBuffer.append("&package=");
		paramBuffer.append(pc.getProductCode());
		paramBuffer.append("&range=");
		paramBuffer.append(getRange(pc));
		paramBuffer.append("&sign=");
		paramBuffer.append(sign);
		if(CallBackEnum.POSITIVE.getValue().equals(platformPo.getEpCallBack())){
			paramBuffer.append("&notify_url=");
			paramBuffer.append(platformPo.getEpCallBackIp());
		}
		System.out.println(paramBuffer.toString());
		
		return paramBuffer.toString();
	}
	
	/**
	 * @description: 获得流量类型
	 * @param serviceType
	 * @param pgValidate
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月11日 下午2:26:24
	 */
	private int getRange(ProductCodePo pc){
		int range = 0;
		int serviceType = pc.getServiceType();
		String pgValidity = pc.getPgValidity();
		int cirulateWay = pc.getCirculateWay();
		//漫游
		Boolean isRoaming = ServiceTypeEnum.NATION_WIDE.getValue()==serviceType || ServiceTypeEnum.PROVINCE_ROAMING.getValue() == serviceType;
		//省内
		boolean isProvince = ServiceTypeEnum.PROVINCE.getValue()==serviceType;
		if(isProvince){//省内
			if(PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidity)){
				range = 0;
			}
			else if(ChannelTypeEnum.RED_PACKET.getValue().equals(cirulateWay)){
				range = 2;
			}
			else if(PgValidityEnum.ONE_DAY_DATA.getValue().equals(pgValidity)){
				range = 6;
			}
			else if(PgValidityEnum.THREE_DAY_DATA.getValue().equals(pgValidity)){
				range = 8;
			}
			else if(PgValidityEnum.SEVEN_DAY_DATA.getValue().equals(pgValidity)){
				range = 10;
			}else{
				range = 99;
			}
		}else if(isRoaming){//漫游包
			if(ChannelTypeEnum.MOBILE.getValue().equals(cirulateWay)){
				range = 3;
			}
			else if(PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidity)){
			}
			else if(PgValidityEnum.TWO_MONTH_DATA.getValue().equals(pgValidity)){
				range = 4;
			}
			else if(PgValidityEnum.ONE_DAY_DATA.getValue().equals(pgValidity)){
				range = 5;
			}
			else if(PgValidityEnum.THREE_DAY_DATA.getValue().equals(pgValidity)){
				range = 7;
			}
			else if(PgValidityEnum.SEVEN_DAY_DATA.getValue().equals(pgValidity)){
				range = 9;
			}
			else if(PgValidityEnum.ONE_SEASON_DATA.getValue().equals(pgValidity)){
				range = 11;
			}
			else if(PgValidityEnum.HALF_YEAR_DATA.getValue().equals(pgValidity)){
				range = 12;
			}
			else if(PgValidityEnum.ONE_YEAR_DATA.getValue().equals(pgValidity)){
				range = 13;
			}
		}
		return range;
	}
	
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
		String app_secret = platformPo.getEpApikey();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(account);
		signBuffer.append("&app_secret=");
		signBuffer.append(app_secret);
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramsBuffer = new StringBuffer();
		paramsBuffer.append("account=");
		paramsBuffer.append(account);
		paramsBuffer.append("&sign=");
		paramsBuffer.append(sign);
		
		return paramsBuffer.toString();
	}

	@Override
	public String toOrderParams() {
		ExchangePlatformPo platformPo = baseParams.getEpo();
		String account = platformPo.getEpUserName();
		String app_secret = platformPo.getEpApikey();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(account);
		signBuffer.append("&app_secret=");
		signBuffer.append(app_secret);
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramsBuffer = new StringBuffer();
		paramsBuffer.append("account=");
		paramsBuffer.append(account);
		paramsBuffer.append("&");
		paramsBuffer.append(platformPo.getEpOtherParams());//app_key
		paramsBuffer.append("mobile=");//mobile
		paramsBuffer.append(baseParams.getChargeTel());//mobile
		paramsBuffer.append("&trade_no=");//trade_no
		paramsBuffer.append(baseParams.getOrderIdApi());//trade_no
		paramsBuffer.append("&out_trade_no=");//out_trade_no
		paramsBuffer.append(baseParams.getOrderId());//out_trade_no
		paramsBuffer.append("&sign=");//sign
		paramsBuffer.append(sign);//sign
		
		
		return paramsBuffer.toString();
	}

	public static String getEpEngId() {
		return epEngId;
	}

	public static void setEpEngId(String epEngId) {
		Wantull.epEngId = epEngId;
	}
	
}
