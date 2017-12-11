package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.weizu.api.util.HttpRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

public class Wantull implements BaseInterface {

	private static Wantull instance = new Wantull();  
	private static String epEngId;
	private static BaseP baseParams;
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
		ExchangePlatformPo epPo = baseParams.getEpo();
		 String jsonStr = HttpRequest.sendPost(epPo.getEpPurchaseIp(), toParams());
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(jsonStr)){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("code");
	            String tipMsg = obj.getString("msg");
	            String orderIdApi = obj.getString("trade_no");
	            String orderId = obj.getString("out_trade_no");
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
            if(StringHelper.isNotEmpty(balanceStr)){
            	balance = Double.parseDouble(balanceStr);
            }
            String epEngId = baseParams.getEpo().getEpEngId();
            String epEngIdTag = epEngId.substring(epEngId.length()-1);
            if("0".equals(epEngIdTag)){
            	balanceDTO = new BalanceDTO(balance, tipCode, tipMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
            }else{
            	balanceDTO = new BalanceDTO(balance, tipCode, tipMsg,BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
            }
		    // 最后输出到控制台  
            System.out.println(tipMsg+"<--->"+tipMsg + ":" + balance);  
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		
		
		return null;
	}

	@Override
	public String toParams() {
		ExchangePlatformPo platformPo = baseParams.getEpo();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(platformPo.getEpUserName());
		signBuffer.append("&");
		signBuffer.append(platformPo.getEpOtherParams());
		signBuffer.append("mobile=");
		signBuffer.append(baseParams.getChargeTel());
		signBuffer.append("&package=");
		signBuffer.append(baseParams.getProductCode());
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		signBuffer.append("&out_trade_no=");
		signBuffer.append(baseParams.getOrderId());
//		signBuffer.append("&range=");
//		signBuffer.append(getRange());
//		signBuffer.append("&notify_url=");
//		signBuffer.append(platformPo.getEpCallBackIp());
		signBuffer.append("&sign=");
		signBuffer.append(sign);
		
//		baseParams.get
//		signBuffer.append("")
		
//		String [] tipSign = new String []{"account","app_key","mobile","package"};//参与签名的字段
//		
		
//		String [] specialKeys = new String[]{"app_key"};
//		for (String key : specialKeys) {
//			String valueSample = StringUtil2.getParamsByCharSeq(platformPo.getEpOtherParams(), key);
//			System.out.println(valueSample);
//		}
		
		return signBuffer.toString();
	}
	
	/**
	 * @description: 获得流量类型
	 * @param serviceType
	 * @param pgValidate
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月11日 下午2:26:24
	 */
//	private int getRange(int serviceType,String pgValidate){
	private int getRange(){
//		//漫游
//		boolean roaming = ServiceTypeEnum.PROVINCE_ROAMING.getValue() == serviceType;
//		//省内
//		boolean province = ServiceTypeEnum.PROVINCE.getValue() == serviceType;
//		//月包漫游
//		boolean monthRoaming = roaming && PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidate);
//		//月包省内
//		boolean monthProvince = province && PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidate);
//		//月包漫游
//		boolean monthRoaming = roaming && PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidate);
//		//月包漫游
//		boolean monthRoaming = roaming && PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidate);
//		//月包漫游
//		boolean monthRoaming = roaming && PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidate);
//		//月包漫游
//		boolean monthRoaming = roaming && PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidate);
//		//月包漫游
//		boolean monthRoaming = roaming && PgValidityEnum.MONTH_DAY_DATA.getValue().equals(pgValidate);
//		
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	public static String getEpEngId() {
		return epEngId;
	}

	public static void setEpEngId(String epEngId) {
		Wantull.epEngId = epEngId;
	}
	
}
