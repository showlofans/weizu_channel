package com.weizu.flowsys.api.singleton;

import java.io.UnsupportedEncodingException;

import org.weizu.api.util.HttpRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.base.charge.ChargeDTO;
import com.weizu.flowsys.api.base.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

public class Lljypt implements BaseInterface {

	private static Lljypt instance = new Lljypt();  
	private static String epEngId;
	private static BaseP baseParams;
	private static StringBuffer sbParams = new StringBuffer();			//输入参数
	private Lljypt() {
	}
	
	 public static Lljypt getInstance(String epEngId,BaseP baseParams) {  
		 Lljypt.epEngId = epEngId;
//	    	baseParams = baseParams;
		 Lljypt.baseParams=baseParams;
	    	return instance;  
	    }
	
	@Override
	public ChargeDTO charge() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		 String jsonStr = HttpRequest.sendGet(epPo.getEpPurchaseIp(), toParams());
		 ChargeDTO chargeDTO = null;
		 try {  
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("rspCode");
	            String tipMsg = obj.getString("rspMsg");
	            String orderIdApi = obj.getString("tastId");
	            String epEngId = epPo.getEpEngId();
	            int billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
	            if("0".equals(epEngId.substring(epEngId.length()-1))){//英文标识最后一个字符是0表示对私
	            	billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
	            }
	            //用我这边默认的对私账户充值
	            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCode(), billType));
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
//		System.out.println(resultStr);
		return null;
	}
	
	

	@Override
	public OrderDTO getOrderState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initSpecialP(Object... objs) {
		

	}

	@Override
	public String toBalanceParams() {
		String otherParams = baseParams.getEpo().getEpOtherParams();
		sbParams.append(otherParams.trim());
		Long ts = System.currentTimeMillis();
		sbParams.append("ts=").append(ts);
		String apiKey = baseParams.getEpo().getEpApikey();
		String balanceSign = getBalanceSign(otherParams,ts,apiKey);
		System.out.println(balanceSign);
		sbParams.append("&sign=").append(balanceSign);
		return sbParams.toString();
	}
	
	/**
	 * @description: 获得余额签名
	 * @param otherParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 下午12:22:59
	 */
	private String getBalanceSign(String otherParams,Long ts,String apikey){
		StringBuffer sbKeyValue = new StringBuffer();
		sbKeyValue.append(otherParams);
		sbKeyValue.append("ts=").append(ts);
		sbKeyValue.append(apikey);
		String sign = getSignBySignStr(sbKeyValue.toString());
		return sign;
	}
	
	@Override
	public String toParams() {
		String otherParams = baseParams.getEpo().getEpOtherParams(); 
		Boolean hasOther = StringHelper.isNotEmpty(otherParams);
		Long timeStamp = System.currentTimeMillis();		//对外统一的时间戳
		if(hasOther){
			String sign = getSign(otherParams,timeStamp);
			sbParams.append("&sign=").append(sign);
		}
		sbParams.append(otherParams);
		sbParams.append("accountVal=").append(baseParams.getChargeTel());
		sbParams.append("&product=").append(baseParams.getProductCode());
		sbParams.append("&outTradeNo=").append(baseParams.getOrderId());
		sbParams.append("&ts=").append(timeStamp);
		
		return sbParams.toString();
	}
	
	
	
	/**
	 * @description:
	 * @param otherParams (格式：clientId=10000&merchant=10304&version=v100&  )
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 上午11:41:17
	 */
	private String getSign(String otherParams,Long ts){
		//添加sign
		StringBuffer sbKeyValue = new StringBuffer();
		sbKeyValue.append("accountVal").append(baseParams.getChargeTel());
		//先取 clientId
		String clientId = StringUtil2.getParamsByCharSeq(otherParams, "clientId");
		clientId = clientId.replace("=", "");
		sbKeyValue.append(clientId);
		//再取merchant
		String merchant = StringUtil2.getParamsByCharSeq(otherParams, "merchant");
		merchant = merchant.replace("=", "");
		sbKeyValue.append(merchant);
		sbKeyValue.append("outTradeNo").append(baseParams.getOrderId());
		sbKeyValue.append("product").append(baseParams.getProductCode());
		sbKeyValue.append("ts").append(ts);
		//再取version
		String version = StringUtil2.getParamsByCharSeq(otherParams, "version");
		version = version.replace("=", "");
		sbKeyValue.append(version);
		
		//生成sign加上其他的参数
//		if(hasOther){//把1=2&3=4换成1234
//			//先加上其他的参数
//			System.out.println(otherParams);
//			sbParams.append("&").append(otherParams);
//			otherParams = otherParams.replace("&", "");
//			otherParams = otherParams.replace("=", "");
//			sbKeyValue.append(otherParams);
////					System.out.println(sbKeyValue.toString());
//		}
		
		String sign = getSignBySignStr(sbKeyValue.toString());
		
//		if(StringHelper.isNotEmpty(otherParams)){//把1=2&3=4换成1234
//			//先加上其他的参数
//			System.out.println(otherParams);
//			sbParams.append("&").append(otherParams);
//			otherParams = otherParams.replace("&", "");
//			otherParams = otherParams.replace("=", "");
//			sbKeyValue.append(otherParams);
////			System.out.println(sbKeyValue.toString());
//		}
		
		return sign;
		
	}
	
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

	@Override
	public void initSpecialP(String addParams) {
//		Lljypt.baseParams.setAddParams(addParams);
	}

	

}
