package org.weizu.api.facet.balance;

import org.weizu.api.base.ParamsResult;
import org.weizu.api.facet.balance.impl.BalanceParamsPage;
import org.weizu.api.facet.balance.impl.BalanceResultPage;


/**
 * @description:余额页面接口
 * @projectName:testHttpInterface
 * @className:BalanceBase.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午5:53:37
 * @version 1.0
 */
public interface BalanceBase extends ParamsResult {
	/**
	 * @description:得到页面余额
	 * @param bpp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午3:27:29
	 */
	public BalanceResultPage getBalance(BalanceParamsPage bpp);
}
