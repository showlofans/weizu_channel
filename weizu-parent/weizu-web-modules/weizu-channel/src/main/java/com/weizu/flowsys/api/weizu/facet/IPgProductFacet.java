package com.weizu.flowsys.api.weizu.facet;

import com.weizu.flowsys.api.weizu.charge.PgProductParams;
import com.weizu.flowsys.web.http.entity.PgProduct;

public interface IPgProductFacet {
	
	/**
	 * @description: 获得产品列表接口
	 * @param pgParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月9日 下午1:55:53
	 */
	PgProduct getPgProductList(PgProductParams pgParams);
}
