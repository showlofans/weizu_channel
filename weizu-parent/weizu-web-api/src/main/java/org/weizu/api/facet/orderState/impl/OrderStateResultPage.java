package org.weizu.api.facet.orderState.impl;

import org.weizu.api.base.PageResult;
import org.weizu.api.base.ResultPageBase;
import org.weizu.api.facet.orderState.PageOrder;


/**
 * @description: 获得订单状态的page结果基类
 * @projectName:testHttpInterface
 * @className:OrderStateParamsPage.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午5:59:26
 * @version 1.0
 */
public class OrderStateResultPage extends ResultPageBase implements PageResult {
	private PageOrder pageOrder;
	
	public OrderStateResultPage(int tipCode, String tipMsg,PageOrder pageOrder) {
		super(tipCode, tipMsg);
		this.pageOrder = pageOrder;
	}

	public PageOrder getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(PageOrder pageOrder) {
		this.pageOrder = pageOrder;
	}
	
}
