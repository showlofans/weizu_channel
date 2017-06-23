package com.weizu.flowsys.web.http.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.weizu.api.outter.facade.OrderFacade;
import org.weizu.api.outter.pojo.order.OrderDTO;
import org.weizu.api.outter.pojo.order.OrderParams;

/**
 * @description: 查询订单详情接口实现类
 * @projectName:weizu-channel
 * @className:OrderFacadeImpl.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午6:04:27
 * @version 1.0
 */
@Service("orderFacade")
public class OrderFacadeImpl implements OrderFacade {

	/**
	 * @description:查询订单详情
	 * @param orderParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午6:04:40
	 */
	@Override
	public OrderDTO checkOrder(OrderParams orderParams) {
		return null;
	}

}
