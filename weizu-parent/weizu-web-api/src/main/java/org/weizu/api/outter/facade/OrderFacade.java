package org.weizu.api.outter.facade;

import org.weizu.api.outter.pojo.order.OrderDTO;
import org.weizu.api.outter.pojo.order.OrderParams;

/**
 * @description: 查询订单详情接口
 * @projectName:weizu-web-api
 * @className:OrderFacade.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:50:41
 * @version 1.0
 */
public interface OrderFacade {
	/**
	 * @description: 查询订单详情
	 * @param orderParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午6:03:04
	 */
	OrderDTO checkOrder(OrderParams orderParams);
}
