package org.weizu.api.outter.facade;

import org.weizu.api.outter.pojo.BalanceDTO;

/**
 * @description:代理商查询账户余额接口
 * @projectName:weizu-web-api
 * @className:BalanceFacade.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午2:34:46
 * @version 1.0
 */
public interface BalanceFacade {
	/**
	 * @description: 获取余额接口
	 * @param userName 
	 * @param sign
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午3:40:20
	 */
	BalanceDTO myBalance(String userName, String sign);
}
