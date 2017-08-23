package com.weizu.flowsys.web.trade.ao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//import org.weizu.api.facet.orderState.PageOrder;




import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.api.base.ChargeDTO;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.http.ParamsEntityWeiZu;
import com.weizu.flowsys.web.http.weizu.OrderStateResult;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.pojo.TotalResult;

public interface PurchaseAO {
	
	/**
	 * @description:页面上充值
	 * @param purchasePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月12日 下午5:34:23
	 */
	String purchase(PgChargeVO pcVO, Integer ap_agency_id);
	
	/**
	 * @description:封装查询参数
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:51:41
	 */
	Map<String,Object> getMapByPojo(PurchaseVO purchaseVO,Boolean isCharged);
	
	/**
	 * @description:查询订单列表
	 * @param purchaseVO
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月13日 下午12:52:58
	 */
	Pagination<PurchaseVO> getPurchase(Map<String, Object> resultMap,PurchaseVO purchaseVO,PageParam pageParam);
	
	/**
	 * @description:通过微族api充值
	 * @param paramsEntity
	 * @return json数据
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:20:12
	 */
	OrderStateResult purchaseByWeizuAPI(ParamsEntityWeiZu paramsEntity);
	
	/**
	 * @description: 更新查看订单状态
	 * @param pageOrder
	 * @param purchaseVO
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午12:57:43
	 */
//	int checkOrderState(PageOrder pageOrder, PurchaseVO purchaseVO);
	
	/**
	 * @description: 通过订单Id查询订单
	 * @param orderId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月26日 下午1:04:25
	 */
	PurchasePo getOnePurchase(long orderId);
	
	ChargeDTO chargeByFacet(ExchangePlatformPo epPo,ProductCodePo dataPo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	
	/**
	 * @description: 获得成功列表统计信息
	 * @param purchaseVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月22日 下午2:18:36
	 */
	TotalResult getTotalResultFromSuccess(PurchaseVO purchaseVO);
	
}
