package org.weizu.api.forward.weizu;

import org.weizu.api.base.APIParams;
import org.weizu.api.base.APIResult;
import org.weizu.api.base.PageParams;
import org.weizu.api.base.PageResult;
import org.weizu.api.facet.charge.ChargeBase;
import org.weizu.api.facet.charge.ChargePageOrder;
import org.weizu.api.facet.charge.impl.ChargeParamsPage;
import org.weizu.api.facet.charge.impl.ChargeResultPage;
import org.weizu.api.util.HttpRequest;

import com.alibaba.fastjson.JSON;

/**
 * @description:微族充值
 * @projectName:testHttpInterface
 * @className:Charge.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月20日 上午10:36:58
 * @version 1.0
 */
public class Charge implements ChargeBase{

	/**
	 * @description: 初始化参数
	 * @param pp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月20日 上午10:36:19
	 */
	@Override
	public APIParams initParams(PageParams pp) {
		ChargeParamsPage bpp =  (ChargeParamsPage)pp;
		ChargeParamsAPI cpapi = new ChargeParamsAPI(bpp.requestUrl, bpp.epName, bpp.epUserName, bpp.apikey, bpp.getNumber(), bpp.getFlowsize());
		return cpapi;
	}

	/**
	 * @description: 获得结果
	 * @param apir
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月20日 上午10:36:29
	 */
	@Override
	public PageResult resetResult(APIResult apir) {
		ChargeResultAPI crapi = (ChargeResultAPI)apir;
		ChargeAPIOrder capio =  crapi.getOrder();
		ChargePageOrder cpo = null;
		if(capio != null){
			cpo = new ChargePageOrder(capio.getTransaction_id(), capio.getNumber(), capio.getFlowsize());
		}
		ChargeResultPage crp = new ChargeResultPage(crapi.getTipCode(), crapi.getTipMsg(), cpo);
		return crp;
	}

	/**
	 * @description: 充值
	 * @param cpp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月20日 上午10:36:39
	 */
	@Override
	public ChargeResultPage charge(ChargeParamsPage cpp) {
		ChargeParamsAPI cpapi =(ChargeParamsAPI) initParams(cpp);
		String jsonStr = HttpRequest.sendGet(cpp.requestUrl, cpapi.toParams());
		ChargeResultAPI crapi = JSON.parseObject(jsonStr, ChargeResultAPI.class);
		ChargeResultPage crp = (ChargeResultPage)resetResult(crapi);
		return crp;
	}

}
