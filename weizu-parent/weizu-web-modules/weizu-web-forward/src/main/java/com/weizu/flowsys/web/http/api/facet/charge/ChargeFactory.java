package com.weizu.flowsys.web.http.api.facet.charge;

public class ChargeFactory {
	
	public static ChargeBase getChargeBase(String epName){
		ChargeBase cb = null;
		if("wzkj".equals(epName)){
			cb = new com.weizu.flowsys.web.http.api.forward.weizu.Charge();
		}
		return cb;
	}
}
