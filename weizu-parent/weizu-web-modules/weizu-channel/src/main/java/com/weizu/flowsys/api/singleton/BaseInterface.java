package com.weizu.flowsys.api.singleton;

import com.weizu.flowsys.api.weizu.charge.ChargeDTO;

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
	
	/**
	 * @description: 根据表中信息添加到参数当中
	 * @param addParams
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 上午9:25:22
	 */
	void initSpecialP(String addParams);
	
	/**
	 * @description: 封装参数
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 上午9:15:55
	 */
	String toParams();
	
	/**
	 * @description:封装余额参数
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 下午12:18:24
	 */
	String toBalanceParams();
	
	/**
	 * @description: 封装订单状态查询参数
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月31日 下午3:06:02
	 */
	String toOrderParams();
}
