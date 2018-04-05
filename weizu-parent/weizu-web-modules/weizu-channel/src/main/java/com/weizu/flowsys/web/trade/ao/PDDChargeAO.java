package com.weizu.flowsys.web.trade.ao;

import com.weizu.flowsys.api.weizu.charge.ChargeTelParams;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.pdd.PDDChargePo;
import com.weizu.flowsys.web.trade.pojo.pdd.PDDChargeTelPo;
import com.weizu.flowsys.web.trade.pojo.pdd.PddPgParams;
import com.weizu.flowsys.web.trade.pojo.pdd.PddTelParams;

public interface PDDChargeAO {
	/**
	 * @description: 拼多多流量充值
	 * @param pddPgParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月3日 下午2:07:52
	 */
	PDDChargePo chargePg(PddPgParams pddPgParams);
	
	/**
	 * @description: 拼多多快充话费充值
	 * @param chargeTelParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月4日 上午10:42:57
	 */
	PDDChargeTelPo chargeTel(ChargeTelParams chargeTelParams);

	/**
	 * @description: 拼多多快充慢充充值
	 * @param chargeTelParams
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月4日 下午3:11:49
	 */
	PDDChargeTelPo chargeTel(PddTelParams pddTelParams);
	
	/**
	 * @description: 发货接口
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月4日 下午4:17:37
	 */
	String sendCallBack(PurchasePo purchasePo, String reportUrl);
}
