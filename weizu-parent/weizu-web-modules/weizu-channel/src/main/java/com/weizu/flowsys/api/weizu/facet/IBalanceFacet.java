package com.weizu.flowsys.api.weizu.facet;

import com.weizu.flowsys.api.singleton.BalanceDTO;


/**
 * @description: 下游查询余额接口
 * @projectName:weizu-channel
 * @className:IBalanceFacet.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月31日 下午4:28:41
 * @version 1.0
 */
public interface IBalanceFacet {
	/**
	 * @description: 获得余额
	 * @param userName
	 * @param sign
	 * @param accountType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月31日 下午4:28:51
	 */
	BalanceDTO myBalance(String userName, String sign,Integer billType);
}
