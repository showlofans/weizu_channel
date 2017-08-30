package com.weizu.flowsys.api.singleton;

import java.io.UnsupportedEncodingException;

import org.weizu.api.util.HttpRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.base.charge.ChargeDTO;
import com.weizu.flowsys.api.base.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.MD5;

/**
 * @description: 微族接口实现
 * @projectName:weizu-channel
 * @className:Weizu.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 下午5:49:05
 * @version 1.0
 */
public class Weizu implements BaseInterface {

	private static Weizu instance = new Weizu();  
	private static String epEngId;
	private static BaseP baseParams;
	private static StringBuffer sbParams = new StringBuffer();;			//输入参数
	
    private Weizu (){}  
    public static Weizu getInstance(String epEngId,BaseP baseParams) {  
    	Weizu.epEngId = epEngId;
//    	baseParams = baseParams;
    	Weizu.baseParams=baseParams;
    	return instance;  
    }
    
//    public static ChargeDTO charge(){
//    	String chargeTel = Weizu.baseParams.getChargeTel();
//    	System.out.println(chargeTel);
//    	return null;
//    }
	
	@Override
	public ChargeDTO charge() {
//		"http://139.224.70.161:32001/api/v1/sendOrder", "weizu", "CS111111", "722c16de0a83e5bd2f988e3c7bc9fee8", "15858343638", "500"
		System.out.println(epEngId);
//		 baseParams.getEpo().getEpPurchaseIp();
		 
//		initSpecialP("1","1.0","GET");
		 String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpPurchaseIp(), toParams());
		 ChargeDTO chargeDTO = null;
		 try {  
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("errcode");
	            String tipMsg = obj.getString("errmsg");
	            
	            JSONObject orderObj = obj.getJSONObject("order");
	            String orderIdApi = orderObj.getString("transaction_id");
	            String number = orderObj.getString("number");
	            String pgSize = orderObj.getString("flowsize");
	            //用我这边默认的对私账户充值
	            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, number, pgSize, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
			    // 最后输出到控制台  
	            System.out.println(tipCode+"<--->"+tipMsg);  
	  
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		 
//		System.out.println(baseParams.getOrderId());
//		System.out.println(baseParams.getAddParams());
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
		String sign = null;
		try {
			sign = MD5.getMd5("username="+epPo.getEpUserName()+"&apikey="+epPo.getEpApikey(),null,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		sbParams.append("username=").append(epPo.getEpUserName());
		sbParams.append("&number=").append(baseParams.getChargeTel());
		sbParams.append("&flowsize=").append(baseParams.getProductCode());
		sbParams.append("&user_order_id=").append(baseParams.getOrderId());
		sbParams.append("&sign=").append(sign);
		
		return sbParams.toString();
		
		
//		return "username=" + epPo.getEpUserName() + "&number=" + baseParams.getChargeTel()
//				+ "&flowsize=" + baseParams.getProductCode() + "&user_order_id=" + baseParams.getOrderId()
//				+ "&sign=" + sign;
	}

	@Override
	public BalanceDTO getBalance() {
		
		return null;
	}

	@Override
	public OrderDTO getOrderState() {
		
		return null;
	}
	@Override
	public void initSpecialP(Object... objs) {
		//顺序和加入位置，都是可以随时调的
		String [] paramsNames = new String [] {"serviceCode","interVersion","callBackWay"};
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < objs.length; i++) {
			sBuffer.append(paramsNames[i]);
			sBuffer.append("=");
			sBuffer.append(objs[i].toString());
			sBuffer.append("&");
		}
//		Weizu.baseParams.setAddParams(sBuffer.toString());
		
	}
	@Override
	public void initSpecialP(String addParams) {
//		Weizu.baseParams.setAddParams(addParams);
	}
	@Override
	public String toBalanceParams() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
