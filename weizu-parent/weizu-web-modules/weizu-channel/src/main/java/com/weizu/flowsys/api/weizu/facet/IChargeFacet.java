package com.weizu.flowsys.api.weizu.facet;

import com.weizu.flowsys.api.weizu.charge.ChargeParams;
import com.weizu.flowsys.api.weizu.charge.ChargeTelParams;
import com.weizu.flowsys.web.http.entity.Charge;
import com.weizu.flowsys.web.http.entity.ChargeTel;


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
	Charge charge(ChargeParams chargeParams) throws Exception;
	
	/**
	 * @description: 话费充值
	 * @param chargeTelParams
	 * @return
	 * @throws Exception
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月20日 下午2:56:54
	 */
	ChargeTel charge(ChargeTelParams chargeTelParams) throws Exception;
}
