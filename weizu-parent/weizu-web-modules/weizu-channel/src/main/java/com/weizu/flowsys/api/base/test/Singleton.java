package com.weizu.flowsys.api.base.test;

import com.weizu.flowsys.api.base.BaseParams;

public class Singleton {
	private static Singleton instance = new Singleton();  
	private static String tag;
	private static BaseParams baseParams;
	
    private Singleton (){}  
    public static Singleton getInstance(String msg,BaseParams baseParams) {  
    	tag = msg;
//    	baseParams = baseParams;
    	Singleton.baseParams=baseParams;
    	return instance;  
    }
    
//    public static ChargeDTO charge(){
//    	String chargeTel = Singleton.baseParams.getChargeTel();
//    	System.out.println(chargeTel);
//    	return null;
//    }
	public static String getTag() {
		return tag;
	}
	public static BaseParams getBaseParams() {
		return baseParams;
	}
	
//	public static void setTag(String tag) {
//		Singleton.tag = tag;
//	}
    
    
}
