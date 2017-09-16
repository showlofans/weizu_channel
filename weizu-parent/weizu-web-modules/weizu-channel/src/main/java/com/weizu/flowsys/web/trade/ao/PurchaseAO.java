package com.weizu.flowsys.web.trade.ao;

import java.util.List;
import java.util.Map;


//import org.weizu.api.facet.orderState.PageOrder;
import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelPo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
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
	
//	ChargeDTO chargeByFacet(ExchangePlatformPo epPo,ProductCodePo dataPo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	
	/**
	 * @description: 获得成功列表统计信息
	 * @param purchaseVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月22日 下午2:18:36
	 */
	TotalResult getTotalResultFromSuccess(PurchaseVO purchaseVO);
	
	
	/**
	 * @description: 充值页面异步获得充值通道
	 * @param ccpp
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月28日 下午3:57:57
	 */
	List<ChargeChannelPo> ajaxChargeChannel(ChargeChannelParamsPo ccpp);
	
	/**
	 * @description: 充值页面异步获得充值包体（超级管理员）
	 * @param ccpp
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月29日 上午9:15:57
	 */
	List<OperatorPgDataPo> ajaxChargePg(ChargeChannelParamsPo ccpp);
	
	/**
	 * @description:充值页面异步获得充值包体（超级管理员）
	 * @param ccpp
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月16日 下午2:32:22
	 */
	List<OperatorPgDataPo> getPgByChanel(ChargeChannelParamsPo ccpp);
	
	
	
	/**
	 * @description:
	 * @param ccpp
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月15日 下午6:08:24
	 */
//	List<OperatorPgDataPo> testChannel(ChargeChannelParamsPo ccpp);
	
	/**
	 * @description: 通过费率充值 
	 * @param rateId
	 * @param agencyId
	 * @param fromAgencyName
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月4日 上午9:51:28
	 */
//	void purchaseByRate(Long rateId,Integer agencyId,String fromAgencyName);
	
	/**
	 * @description: 充值等待异步提交订单
	 * @param orderId
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月4日 上午10:18:03
	 */
	String ajaxCommitOrder(Long orderId,Integer agencyId,String chargeTelDetail,Integer billTypeRate);
	
}
