package org.weizu.api.forward.weizu;

import org.weizu.api.base.APIParams;
import org.weizu.api.base.APIResult;
import org.weizu.api.base.PageParams;
import org.weizu.api.base.PageResult;
import org.weizu.api.facet.balance.BalanceBase;
import org.weizu.api.facet.balance.impl.BalanceParamsPage;
import org.weizu.api.facet.balance.impl.BalanceResultPage;
import org.weizu.api.util.HttpRequest;

import com.alibaba.fastjson.JSON;

/**
 * @description: 微族余额获取实现
 * @projectName:testHttpInterface
 * @className:Balance.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午3:28:59
 * @version 1.0
 */
public class Balance implements BalanceBase{

	/**
	 * @description:获得余额
	 * @param bpp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午4:16:09
	 */
	@Override
	public BalanceResultPage getBalance(BalanceParamsPage bpp) {
		BalanceParamsAPI bpapi = (BalanceParamsAPI)initParams(bpp);
		String apiJson = HttpRequest.sendGet(bpp.requestUrl, bpapi.toParams());
		BalanceResultAPI brapi = JSON.parseObject(apiJson, BalanceResultAPI.class);
		BalanceResultPage brp =(BalanceResultPage) resetResult(brapi);
		return brp;
	}
	
	/**
	 * @description:  初始化参数
	 * @param pp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午4:38:18
	 */
	@Override
	public APIParams initParams(PageParams pp) {
		BalanceParamsPage bpp =  (BalanceParamsPage)pp;
		BalanceParamsAPI bpapi = new BalanceParamsAPI(bpp.epUserName, bpp.apikey, bpp.requestUrl, bpp.epName);
		return bpapi;
	}

	/**
	 * @description: 获得结果
	 * @param apir
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午4:38:10
	 */
	@Override
	public PageResult resetResult(APIResult apir) {
		BalanceResultAPI brapi = (BalanceResultAPI)apir;
		BalanceResultPage brp = new BalanceResultPage(brapi.getTipCode(), brapi.getTipMsg(), brapi.getBalance());
		return brp;
	}

	/**
	 * @description: 获得结果
	 * @param brapi
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午3:37:57
	 */
//	private BalanceResultPage resetResult(BalanceResultAPI brapi) {
//		BalanceResultPage brp = new BalanceResultPage(brapi.getTipCode(), brapi.getTipMsg(), brapi.getBalance());
//		return brp;
//	}

	/**
	 * @description: 初始化参数
	 * @param bpp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月19日 下午3:38:12
	 */
//	private APIParams initParams(BalanceParamsPage bpp) {
//		BalanceParamsAPI bpapi = new BalanceParamsAPI(bpp.epUserName, bpp.apikey, bpp.balanceUrl, bpp.epName);
//		return bpapi;
//	}

	
}
