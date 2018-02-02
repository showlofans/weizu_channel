package com.weizu.flowsys.web.trade.ao;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;


//import org.weizu.api.facet.orderState.PageOrder;
import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.http.ParamsEntityWeiZu;
import com.weizu.flowsys.web.http.weizu.OrderStateResult;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
import com.weizu.flowsys.web.trade.pojo.TelChargeVO;
import com.weizu.flowsys.web.trade.pojo.TotalResult;

public interface PurchaseAO {
	
	/**
	 * @description:页面上充值流量
	 * @param purchasePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月12日 下午5:34:23
	 */
	String purchase(PgChargeVO pcVO, ChargeAccountPo accoutPo);
	
	/**
	 * @description: 页面上充值话费
	 * @param tcVO
	 * @param accoutPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月2日 下午2:15:34
	 */
	String purchase(TelChargeVO tcVO, ChargeAccountPo accoutPo);
	
	/**
	 * @description: 通过接口向上提单
	 * @param epPo
	 * @param purchasePo
	 * @param pc
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月2日 下午2:14:28
	 */
	public ChargeDTO chargeByBI(ExchangePlatformPo epPo,PurchasePo purchasePo,ProductCodePo pc);
	
	
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
	 * @description: 根据页面订单实体获得总记录数
	 * @param purchaseVO
	 * @param isCharged
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月3日 上午9:47:38
	 */
//	Long getTotalRecordByParams(PurchaseVO purchaseVO, Boolean isCharged);
	/**
	 * @description: 获得不分页列表
	 * @param purchaseVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月22日 上午9:53:53
	 */
	Map<String,Object> getPurchaseMap(PurchaseVO purchaseVO);
	
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
	List<PgDataPo> getPgByChanel(ChargeChannelParamsPo ccpp);
	
	/**
	 * @description: 充值页面异步获得充值包体（超级管理员）
	 * @param channelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月31日 上午11:51:27
	 */
	List<PgDataPo> getPgByChanel(Long channelId);
	
	
	
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
	String ajaxCommitOrder(Long orderId,Integer accountId,String chargeTelDetail);
	
	/**
	 * @description: 批量提交订单
	 * @param purchaseVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月4日 上午9:56:37
	 */
	String batchCommitOrder(PurchaseVO purchaseVO);
	
	/**
	 * @description: 批量更新订单状态
	 * @param purchaseVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月4日 上午9:56:37
	 */
	String batchChangeOrderState(PurchaseVO purchaseVO);
	
	
	/**
	 * @description: 批量推送订单
	 * @param purchaseVO 查询推送的订单
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月7日 下午4:44:31
	 */
	String batchPushOrder(PurchaseVO purchaseVO);
	
	/**
	 * @description: 导出充值成功列表
	 * @param purchaseVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月7日 下午2:27:29
	 */
	HSSFWorkbook exportChargedList(PurchaseVO purchaseVO, Integer agencyTag);
	
}
