package com.weizu.flowsys.web.http.api.facet.balance;

public class BalanceFactory {
	
	
	/**
	 * @description:根据名字获得该余额实体
	 * @param epName
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午5:12:24
	 */
	public static BalanceBase getBalance(String epName){
		BalanceBase bb = null;
		if("wzkj".equals(epName)){
			bb = new com.weizu.flowsys.web.http.api.forward.weizu.Balance();
		}
		
		return bb;
	}
	
}
