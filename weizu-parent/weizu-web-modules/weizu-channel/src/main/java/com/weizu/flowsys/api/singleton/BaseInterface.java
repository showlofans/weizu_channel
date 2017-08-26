package com.weizu.flowsys.api.singleton;

/**
 * @description: 对接上游要实现的接口
 * @projectName:weizu-channel
 * @className:BaseInterface.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 下午5:51:19
 * @version 1.0
 */
public interface BaseInterface {
	/**
	 * @description: 充值接口
	 * @param baseP
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月25日 下午5:44:48
	 */
	ChargeDTO charge();
	
	/**
	 * @description: 查询余额接口
	 * @param baseP
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月25日 下午5:50:43
	 */
	BalanceDTO getBalance();
	
	/**
	 * @description: 主动查询订单状态接口
	 * @param baseP
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月25日 下午5:50:53
	 */
	OrderDTO getOrderState();
	
	/**
	 * @description: 初始化特殊的参数
	 * @param objs
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月26日 上午9:50:57
	 */
	void initSpecialP(Object...objs);
}
