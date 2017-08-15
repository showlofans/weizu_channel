package org.weizu.api.facet.balance;

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
		if("weizu".equals(epName)){
			bb = new org.weizu.api.forward.weizu.Balance();
		}
		
		return bb;
	}
	
}
