package com.weizu.flowsys.web.trade.ao;

import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.http.ParamsEntityWeiZu;
import com.weizu.flowsys.web.http.weizu.OrderStateResult;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

public interface PurchaseAO {
	
	/**
	 * @description:页面上充值
	 * @param purchasePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月12日 下午5:34:23
	 */
	Integer purchase(PurchasePo purchasePo,ChargeAccountPo accountPo);
	
	/**
	 * @description:封装查询参数
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:51:41
	 */
	Map<String,Object> getMapByPojo(PurchaseVO purchaseVO);
	
	/**
	 * @description:查询订单列表
	 * @param purchaseVO
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:52:58
	 */
	Pagination<PurchaseVO> getPurchase(PurchaseVO purchaseVO,PageParam pageParam);
	
	/**
	 * @description:通过微族api充值
	 * @param paramsEntity
	 * @return json数据
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:20:12
	 */
	OrderStateResult purchaseByWeizuAPI(ParamsEntityWeiZu paramsEntity);
	
	
	
}
