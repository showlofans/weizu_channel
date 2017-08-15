package org.weizu.api.facet.balance.impl;

import org.weizu.api.base.PageParams;
import org.weizu.api.base.ParamsPageBase;

/**
 * @description:余额page参数
 * @projectName:testHttpInterface
 * @className:BanlanceParamsPage.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午3:20:41
 * @version 1.0
 */
public class BalanceParamsPage extends ParamsPageBase implements PageParams {

	public BalanceParamsPage(String requestUrl, String epName,
			String epUserName, String apikey) {
		
		super(requestUrl, epName, epUserName, apikey);
	}

}
