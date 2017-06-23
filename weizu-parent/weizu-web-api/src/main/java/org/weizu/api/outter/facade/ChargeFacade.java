package org.weizu.api.outter.facade;

import org.weizu.api.outter.pojo.charge.ChargeParams;
import org.weizu.api.outter.pojo.charge.ChargeDTO;

/**
 * @description:充值对外接口
 * @projectName:weizu-web-api
 * @className:ChargeFacade.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午4:22:07
 * @version 1.0
 */
public interface ChargeFacade {
	
	/**
	 * @description: 充值接口
	 * @param chargeParams
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月23日 下午4:34:02
	 */
	ChargeDTO charge(ChargeParams chargeParams);
}
