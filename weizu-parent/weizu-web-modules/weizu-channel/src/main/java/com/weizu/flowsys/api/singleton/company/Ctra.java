package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.http.HttpRequest;

public class Ctra implements BaseInterface {
	private static Ctra instance = new Ctra();  
	private static String epEngId;
	private static BaseP baseParams;
//	private static String sign;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
	
	
    private Ctra (){}  
    public static Ctra getInstance(String epEngId,BaseP baseParams) {  
    	Ctra.setEpEngId(epEngId);
    	Ctra.baseParams=baseParams;
    	return instance;  
    }
	
	@Override
	public ChargeDTO charge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BalanceDTO getBalance() {
		String balanceParams = toBalanceParams();
		System.out.println("余额参数："+balanceParams);
		ExchangePlatformPo epPo = baseParams.getEpo();
		String returnJson = HttpRequest.sendPost(epPo.getEpBalanceIp(), balanceParams);
		JSONObject obj = JSON.parseObject(returnJson);
		 double balance = 0d;
		boolean code = obj.getBooleanValue("code");
		int rspCode = OrderResultEnum.ERROR.getCode();
		String rspMsg = "";
		if(code){
			JSONObject subObj = obj.getJSONObject("data");
			if(subObj != null){
				String balanceStr = subObj.get("balance").toString();
				String time = subObj.get("time").toString();
				balance = Double.parseDouble(balanceStr);
				rspCode = OrderResultEnum.SUCCESS.getCode();
			}
		}else{
			System.out.println(returnJson);
			rspMsg = obj.get("errmsg").toString();
		}
		BalanceDTO balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toParams() {
		return null;
	}

	@Override
	public String toBalanceParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
//		Map<String,Object> paramsMap = new HashMap<String,Object>();
		//custcode 
		Map<String,Object> paramsMap = StringUtil2.getHashMapByStr(epPo.getEpOtherParams());
		Long nowTime = System.currentTimeMillis() / 1000;
		paramsMap.put("timestamp", nowTime);
		String signStr = epPo.getEpApikey() + nowTime;
		System.out.println("签名串："+ signStr);
		String sign = "";
		try {
			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paramsMap.put("sign", sign);
		return JSON.toJSONString(paramsMap);
		
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
		Ctra.epEngId = epEngId;
	}
	
	

}
