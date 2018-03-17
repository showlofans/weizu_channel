package com.weizu.flowsys.api.hsingleton;

import com.weizu.flowsys.api.weizu.charge.ChargeDTO;

/**
 * @description:话费向上统一接口
 * @projectName:weizu-channel
 * @className:TelBaseInterface.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年3月17日 下午2:31:16
 * @version 1.0
 */
public interface TelBaseInterface {
	/**
	 * @description: 话费向上提单统一接口
	 * @param baseP
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月17日 下午2:30:40
	 */
	ChargeDTO chargeTel(TelBaseP baseP);
	
	/**
	 * @description: 话费向上查询订单状态统一接口
	 * @param baseP
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月17日 下午2:31:00
	 */
	TelOrderStateDTO getTelOrderState(TelBaseP baseP);
	
	/**
	 * @description: 封装话费充值参数
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月17日 下午2:32:23
	 */
	String toTelParams();
	
	
	/**
	 * @description: 封装话费订单查询参数
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月17日 下午2:33:35
	 */
	String toTelOrderParams();
}
