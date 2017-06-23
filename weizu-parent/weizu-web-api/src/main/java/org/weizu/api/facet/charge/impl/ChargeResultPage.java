package org.weizu.api.facet.charge.impl;

import org.weizu.api.base.PageResult;
import org.weizu.api.base.ResultPageBase;
import org.weizu.api.facet.charge.ChargePageOrder;

/**
 * @description:充值结果page实体
 * @projectName:testHttpInterface
 * @className:ChargeResultPage.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午10:11:55
 * @version 1.0
 */
public class ChargeResultPage extends ResultPageBase implements PageResult {

	private ChargePageOrder chargePageOrder;
	
	public ChargeResultPage(int tipCode, String tipMsg,ChargePageOrder cpo) {
		super(tipCode, tipMsg);
		this.chargePageOrder = cpo;
	}

	public ChargePageOrder getChargePageOrder() {
		return chargePageOrder;
	}

	public void setChargePageOrder(ChargePageOrder chargePageOrder) {
		this.chargePageOrder = chargePageOrder;
	}
	
}
