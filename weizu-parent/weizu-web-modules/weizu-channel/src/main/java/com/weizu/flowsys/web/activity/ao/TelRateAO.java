package com.weizu.flowsys.web.activity.ao;

import java.util.List;

import com.weizu.flowsys.web.activity.pojo.TelRatePo;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;
import com.weizu.flowsys.web.trade.pojo.GetTelRatePo;

public interface TelRateAO {
	
	/**
	 * @description: 获得充值折扣和费率
	 * @param telRatePo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月1日 下午5:47:01
	 */
	List<GetTelRatePo> getRateForCharge(TelProductPo telProductPo);
	
}
