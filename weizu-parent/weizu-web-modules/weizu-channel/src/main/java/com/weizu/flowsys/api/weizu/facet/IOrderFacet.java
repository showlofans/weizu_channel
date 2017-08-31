package com.weizu.flowsys.api.weizu.facet;

import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.weizu.order.QueryOrderParams;

/**
 * @description: 下级主动查询订单状态接口
 * @projectName:weizu-channel
 * @className:IOrderFacet.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月31日 下午5:06:21
 * @version 1.0
 */
public interface IOrderFacet {
	/**
	 * @description: 查询订单状态
	 * @param orderParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月31日 下午5:12:00
	 */
	OrderDTO getOrderDTO(QueryOrderParams orderParam);
}
