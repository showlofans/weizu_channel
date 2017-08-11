package com.weizu.apiTest;


import org.weizu.web.foundation.MD5;

import com.weizu.flowsys.web.http.api.facet.balance.BalanceBase;
import com.weizu.flowsys.web.http.api.facet.balance.BalanceFactory;
import com.weizu.flowsys.web.http.api.facet.balance.impl.BalanceParamsPage;
import com.weizu.flowsys.web.http.api.facet.balance.impl.BalanceResultPage;

public class TestBalance {
	
//	public static void main(String[] args) {
////		用户名： CS111111
//		//apikey: 722c16de0a83e5bd2f988e3c7bc9fee8
//		String username="XZZR0918";//	CS111111
//		//
//		String apikey = "d9bca9744768c0a762d77c6358fc80de";//722c16de0a83e5bd2f988e3c7bc9fee8
//		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
//		String epBalanceIP = "http://139.224.70.161:32001/api/v1/getBalance";
//		String epName = "weizu";
//		
//		BalanceBase bb = BalanceFactory.getBalance(epName);
//		BalanceResultPage brp = bb.getBalance(new BalanceParamsPage(epBalanceIP, epName, username, apikey));
//		System.out.println(brp.getBalance());//1089
//		System.out.println(brp.tipCode + ":"+brp.tipMsg);//0
//		
//		
//		//解析返回的json数据
//		//获得账户余额
//		//获得订单详情
//		
//		//利用单例模式，对某一个系统生成唯一的sign（根据url分配apikey）
//		//利用反射自动生成toString的方法
//		//Json可以统一解析的Json对象
////		System.out.println(sign);
////		GetBalanceParams gbp = new GetBalanceParams(username, sign);
////		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/getBalance", gbp.toString());
////		System.out.println(resMsg);
//	}
}
