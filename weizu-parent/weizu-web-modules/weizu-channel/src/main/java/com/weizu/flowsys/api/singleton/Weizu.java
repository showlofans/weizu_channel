package com.weizu.flowsys.api.singleton;

import java.util.ArrayList;
import java.util.List;

import com.weizu.flowsys.api.base.test.Singleton;

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
	private static String msg;
	private static BaseP baseParams;
	
    private Weizu (){}  
    public static Weizu getInstance(String msg,BaseP baseParams) {  
    	Weizu.msg = msg;
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
		
		System.out.println(msg);
		System.out.println(baseParams.getOrderId());
		System.out.println(baseParams.getAddParams());
		return null;
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
		Weizu.baseParams.setAddParams(sBuffer.toString());
		
	}
	
}
