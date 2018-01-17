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
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

public class Lljypt implements BaseInterface {

	private static Lljypt instance = new Lljypt();  
	private static String epEngId;
	private static BaseP baseParams;
	private static String [] specialKeys = new String[]{"clientId","merchant","version"};
	private Lljypt() {
	}
	
	 public static Lljypt getInstance(String epEngId,BaseP baseParams) {  
		 Lljypt.setEpEngId(epEngId);
		 Lljypt.baseParams=baseParams;
    	return instance;  
    }
	
	@Override
	public ChargeDTO charge() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		 String jsonStr = HttpRequest.sendPost(epPo.getEpPurchaseIp(), toParams());
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("rspCode");
	            String tipMsg = obj.getString("rspMsg");
	            String orderIdApi = obj.getString("tastId");
	            String epEngId = epPo.getEpEngId();
	            int billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
	            if("0".equals(epEngId.substring(epEngId.length()-1))){//英文标识最后一个字符是0表示对私
	            	billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
	            }
	            if(tipCode == 0){//提交成功
	            	//用我这边默认的对私账户充值
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getProductCode(), billType));
	            }else{
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getProductCode(), billType));
	            }
	            chargeDTO.setJsonStr(jsonStr);//设置返回的json串日志信息
			    // 最后输出到控制台  
	            System.out.println(tipCode+"<--->"+tipMsg);  
	  
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		return chargeDTO;
	}

	@Override
	public BalanceDTO getBalance() {
		String resultStr = HttpRequest.sendPost(baseParams.getEpo().getEpBalanceIp(), toBalanceParams());
		BalanceDTO balanceDTO = null;
		try {  
            JSONObject obj = JSON.parseObject(resultStr);
            int rspCode = obj.getIntValue("rspCode");
            String rspMsg = obj.getString("rspMsg");
            String balanceStr = obj.getString("balance");
            double balance = 0.00d;
//            System.out.println(obj);
            if(rspCode == 0){
            	if(StringHelper.isNotEmpty(balanceStr)){
            		balance = Double.parseDouble(balanceStr);
            	}
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.SUCCESS.getCode(), rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
            }else{
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.ERROR.getCode(), rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
            }
//            String epEngId = baseParams.getEpo().getEpEngId();
//            String epEngIdTag = epEngId.substring(epEngId.length()-1);
//            if("0".equals(epEngIdTag)){
//            	balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
//            }else{
//            	balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
//            }
		    // 最后输出到控制台  
            System.out.println(rspCode+"<--->"+rspMsg);  
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
//		System.out.println(resultStr);
		return balanceDTO;
	}
	
	

	@Override
	public OrderDTO getOrderState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toBalanceParams() {
		String otherParams = baseParams.getEpo().getEpOtherParams();
		Long timeStamp = System.currentTimeMillis();		//对外统一的时间戳
		Boolean hasOther = StringHelper.isNotEmpty(otherParams);
		JSONObject param = new JSONObject();
		if(hasOther){//对于行云流水来讲保证其他参数不为空
			//除了sign之外的其他参数
			String [] tipSign = new String[]{"clientId","merchant","version","ts"};
			for (String key : tipSign) {
				String valueSample = StringUtil2.getParamsByCharSeq(otherParams, key);
				if(valueSample != null){
					String value = valueSample.substring(valueSample.indexOf("=") +1);
					param.put(key, value);
				}
			}
			String sign = getBalanceSign(otherParams,timeStamp, tipSign);
			
			//加上时间戳和sign这两个最特别的参数加上
			param.put("ts", timeStamp);
			param.put("sign", sign);
			
		}
		return param.toString();
	}
	

	@Override
	public String toParams() {
		String otherParams = baseParams.getEpo().getEpOtherParams(); 
//		param.put("clientId",10000);
//        param.put("merchant",10210);
		JSONObject param = new JSONObject();
		Long timeStamp = System.currentTimeMillis();		//对外统一的时间戳
		Boolean hasOther = StringHelper.isNotEmpty(otherParams);
		if(hasOther){//对于行云流水来讲保证其他参数不为空
			//添加其他参数
//			String [] specialKeys = new String[]{"clientId","merchant","version"};
			String sign = getSign(otherParams,timeStamp);
			for (String key : specialKeys) {
				String valueSample = StringUtil2.getParamsByCharSeq(otherParams, key);
				String value = valueSample.substring(valueSample.indexOf("=") +1);
				param.put(key, value);
			}
			param.put("accountVal", baseParams.getChargeTel());
			param.put("product", baseParams.getProductCodePo().getProductCode());
			param.put("outTradeNo", baseParams.getOrderId());
			param.put("ts", timeStamp);
			param.put("sign", sign);
		}
		return param.toString();
	}
	
	@Override
	public String toOrderParams() {
		JSONObject param = new JSONObject();
		String otherParams = baseParams.getEpo().getEpOtherParams();
		Long timeStamp = System.currentTimeMillis();		//对外统一的时间戳
		String sign = getSign(otherParams,timeStamp);
		for (String key : specialKeys) {
			String valueSample = StringUtil2.getParamsByCharSeq(otherParams, key);
			String value = valueSample.substring(valueSample.indexOf("=") +1);
			param.put(key, value);
		}
		param.put("outTradeNo", baseParams.getOrderId());
		param.put("ts", timeStamp);
		param.put("sign", sign);
		return param.toString();
	}
	
	
	
	/**
	 * @description: 获得充值签名
	 * @param otherParams (格式：clientId=10000&merchant=10304&version=v100&  )
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 上午11:41:17
	 */
	private String getSign(String otherParams,Long ts){
		/**除了sign之外的其他参数*/
		String [] tipSign = new String[]{"clientId","merchant","version","accountVal","product","outTradeNo","ts"};
		Arrays.sort(tipSign);//按升序排列
		StringBuffer sbKeyValue = new StringBuffer();
		for (String key : tipSign) {
			String valueSample = StringUtil2.getParamsByCharSeq(otherParams, key);
			if(valueSample == null){//不再特殊参数里，就单独添加到签名当中
//				System.out.println(key);//key一定只有当前时间
				if("ts".equals(key)){
					sbKeyValue.append(key).append(ts);
				}else if("accountVal".equals(key)){
					sbKeyValue.append(key).append(baseParams.getChargeTel());
				}else if("product".equals(key)){
					sbKeyValue.append(key).append(baseParams.getProductCodePo().getProductCode());
				}else if("outTradeNo".equals(key)){
					sbKeyValue.append(key).append(baseParams.getOrderId());
				}
			}else{
				valueSample =  valueSample.substring(valueSample.indexOf("=") +1);
				sbKeyValue.append(key).append(valueSample);
			}
		}
		//最后加上一个apikey
		sbKeyValue.append(baseParams.getEpo().getEpApikey().trim());
		//System.out.println("params:"+sbKeyValue.toString());
		String sign = getSignBySignStr(sbKeyValue.toString());
		return sign;
	}
	/**
	 * @description: 获得余额签名
	 * @param otherParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @param specialKeys 
	 * @createTime:2017年8月30日 下午12:22:59
	 */
	private String getBalanceSign(String otherParams,Long ts, String[] specialKeys){
		Arrays.sort(specialKeys);//按升序排列
		StringBuffer sbKeyValue = new StringBuffer();
		for (String key : specialKeys) {
			String valueSample = StringUtil2.getParamsByCharSeq(otherParams, key);
			if(valueSample != null){
				valueSample =  valueSample.substring(valueSample.indexOf("=") +1);
				sbKeyValue.append(key).append(valueSample);
			}else{//不再特殊参数里，就单独添加到签名当中,只有一个当前时间
//				System.out.println(key);//key一定只有当前时间
				if("ts".equals(key)){
					sbKeyValue.append(key).append(ts);
				}
			}
		}
		//最后加上一个apikey
		sbKeyValue.append(baseParams.getEpo().getEpApikey().trim());
		//System.out.println("balanceParams:"+sbKeyValue.toString());
		String sign = getSignBySignStr(sbKeyValue.toString());
		return sign;
	}
	
		
//		//添加sign
//		StringBuffer sbKeyValue = new StringBuffer();
//		sbKeyValue.append("accountVal").append(baseParams.getChargeTel());
//		//先取 clientId
//		String clientId = StringUtil2.getParamsByCharSeq(otherParams, "clientId");
//		clientId = clientId.replace("=", "");
//		sbKeyValue.append(clientId);
//		//再取merchant
//		String merchant = StringUtil2.getParamsByCharSeq(otherParams, "merchant");
//		merchant = merchant.replace("=", "");
//		sbKeyValue.append(merchant);
//		sbKeyValue.append("outTradeNo").append(baseParams.getOrderId());
//		sbKeyValue.append("product").append(baseParams.getProductCode());
//		sbKeyValue.append("ts").append(ts);
//		//再取version
//		String version = StringUtil2.getParamsByCharSeq(otherParams, "version");
//		version = version.replace("=", "");
//		sbKeyValue.append(version);
//		sbKeyValue.append(baseParams.getEpo().getEpApikey().trim());
//		
//		//生成sign加上其他的参数
////		if(hasOther){//把1=2&3=4换成1234
////			//先加上其他的参数
////			System.out.println(otherParams);
////			sbParams.append("&").append(otherParams);
////			otherParams = otherParams.replace("&", "");
////			otherParams = otherParams.replace("=", "");
////			sbKeyValue.append(otherParams);
//////					System.out.println(sbKeyValue.toString());
////		}
//		
//		String sign = getSignBySignStr(sbKeyValue.toString());
//		
////		if(StringHelper.isNotEmpty(otherParams)){//把1=2&3=4换成1234
////			//先加上其他的参数
////			System.out.println(otherParams);
////			sbParams.append("&").append(otherParams);
////			otherParams = otherParams.replace("&", "");
////			otherParams = otherParams.replace("=", "");
////			sbKeyValue.append(otherParams);
//////			System.out.println(sbKeyValue.toString());
////		}
		
	
	/**
	 * @description: 把字符串按指定md5格式编码
	 * @param signStr
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 下午1:48:57
	 */
	private String getSignBySignStr(String signStr){
		String sign = null;
		try {
			sign = MD5.getMd5(signStr,MD5.LOWERCASE,MD5.ENCODE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sign;
	}

//	@Override
//	public void initSpecialP(String addParams) {
////		Lljypt.baseParams.setAddParams(addParams);
//	}

	public static String getEpEngId() {
		return epEngId;
	}

	public static void setEpEngId(String epEngId) {
		Lljypt.epEngId = epEngId;
	}

	

}
