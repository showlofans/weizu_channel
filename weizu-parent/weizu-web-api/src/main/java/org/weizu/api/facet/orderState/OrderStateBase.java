package org.weizu.api.facet.orderState;

import org.weizu.api.base.ParamsResult;
import org.weizu.api.facet.orderState.impl.OrderStateParamsPage;
import org.weizu.api.facet.orderState.impl.OrderStateResultPage;

/**
 * @description:订单状态页面接口
 * @projectName:testHttpInterface
 * @className:OrderStateBase.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午5:54:35
 * @version 1.0
 */
public interface OrderStateBase extends ParamsResult{
	
	/**
	 * @description: 获得订单状态
	 * @param ospp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午6:04:02
	 */
	OrderStateResultPage getOrderState(OrderStateParamsPage ospp);
}
