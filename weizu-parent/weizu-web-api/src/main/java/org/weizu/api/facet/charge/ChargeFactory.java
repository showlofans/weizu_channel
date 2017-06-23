package org.weizu.api.facet.charge;

public class ChargeFactory {
	
	public static ChargeBase getChargeBase(String epName){
		ChargeBase cb = null;
		if("wzkj".equals(epName)){
			cb = new org.weizu.api.forward.weizu.Charge();
		}
		return cb;
	}
}
