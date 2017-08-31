package com.weizu.flowsys.api.weizu.facet;

import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeParams;


/**
 * @description: 对下充值接口
 * @projectName:weizu-channel
 * @className:IChargeFacet.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月17日 上午10:42:17
 * @version 1.0
 */
public interface IChargeFacet {
	/**
	 * @description: 充值
	 * @return 返回页面统一充值状态
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月17日 上午10:43:12
	 */
	ChargeDTO charge(ChargeParams chargeParams);
}
