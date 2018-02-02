package com.weizu.flowsys.web.trade.ao;

import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;

public interface WXPayAO {
	
	/**
	 * @description: 生成等待订单
	 * @param pgChargeVO
	 * @param openid
	 * @return orderId
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月1日 上午11:21:40
	 */
	Long purchase(PgChargeVO pgChargeVO,String openid); 
	
	/**
	 * @description: 小程序退款接口
	 * @param purchasePo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月2日 下午4:34:15
	 */
	String refund(PurchasePo purchasePo);
	
}
