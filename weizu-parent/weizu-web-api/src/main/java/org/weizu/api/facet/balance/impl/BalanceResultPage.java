package org.weizu.api.facet.balance.impl;

import org.weizu.api.base.PageResult;
import org.weizu.api.base.ResultPageBase;

/**
 * @description:余额page结果
 * @projectName:testHttpInterface
 * @className:BalanceResultPage.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午3:22:43
 * @version 1.0
 */
public class BalanceResultPage extends ResultPageBase implements PageResult {

	private String balance;		//余额
	
	public BalanceResultPage(int tipCode, String tipMsg) {
		super(tipCode, tipMsg);
	}

	public BalanceResultPage(int tipCode, String tipMsg, String balance) {
		super(tipCode, tipMsg);//先要初始化父类元素
		this.balance = balance;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
}
