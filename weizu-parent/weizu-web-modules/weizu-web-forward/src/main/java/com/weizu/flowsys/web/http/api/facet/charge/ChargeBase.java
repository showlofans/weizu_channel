package com.weizu.flowsys.web.http.api.facet.charge;

import com.weizu.flowsys.web.http.api.base.ParamsResult;
import com.weizu.flowsys.web.http.api.facet.charge.impl.ChargeParamsPage;
import com.weizu.flowsys.web.http.api.facet.charge.impl.ChargeResultPage;


/**
 * @description: 充值接口
 * @projectName:testHttpInterface
 * @className:ChargeBase.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午10:09:12
 * @version 1.0
 */
public interface ChargeBase extends ParamsResult {
	/**
	 * @description:充值
	 * @param cpp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月20日 上午10:33:18
	 */
	ChargeResultPage charge(ChargeParamsPage cpp);
}
