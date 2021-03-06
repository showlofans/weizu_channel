package com.weizu.flowsys.web.activity.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountShowDTO;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
import com.weizu.flowsys.web.channel.pojo.PgDataPo;
import com.weizu.flowsys.web.trade.pojo.RatePgPo;

public interface RateDiscountAO {
	/**
	 * @description: 获得费率列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午5:20:46
	 */
//	Pagination<RateDiscountPo> getRateList(RateDiscountPo ratePo,PageParam pageParam);
	
	/**
	 * @description:获得我的费率列表
	 * @param ratePo
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月28日 下午5:53:00
	 */
	Pagination<RateDiscountPo> getMyRateList(RateDiscountPo ratePo,PageParam pageParam);
	
	/**
	 * @description: 通过通道折扣id和账户id找到绑定的简单费率实体
	 * @param channelDiscountId
	 * @param accountId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月23日 下午5:14:04
	 */
	public RateDiscountPo getRateByAcountIdAndCDId(Long channelDiscountId, Integer accountId);
	
	/**
	 * @description: 获得费率总数
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月12日 下午5:21:12
	 */
	int countRateList(RateDiscountPo ratePo);
	
	/**
	 * @description: 通过折扣初始化地区折扣列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午9:48:20
	 */
	List<RateDiscountPo> getOperatorList(RateDiscountPo ratePo);
	
	/**
	 * @description: 通过折扣初始化地区折扣列表
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 下午12:58:33
	 */
	Map<String,Object> getOperatorListRate(RateDiscountPo ratePo);
	
	Map<String,Object> getMapByEntity(RateDiscountPo ratePo);
	
	/**
	 * @description: 添加费率折扣
	 * @param ratePo
	 * @return success,error
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午11:24:03
	 */
	String addRateDiscount(RateDiscountPo ratePo);
	
	/**
	 * @description: 添加费率折扣
	 * @param ratePo
	 * @param agencyName
	 * @param bindAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午3:19:33
	 */
	String addRateDiscount(RateDiscountPo ratePo,String childAgencyName,Integer bindAgencyId);
	
	/**
	 * @description: 修改费率折扣
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 下午1:58:08
	 */
	String editBindRate(RateDiscountPo ratePo);
	
	/**
	 * @description:更新下级费率折扣
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月29日 下午3:32:12
	 */
	String updateRateDiscount(RateDiscountPo ratePo);
	
	/**
	 * @description: 获得首页折扣信息
	 * @param params
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月19日 下午12:05:15
	 */
//	Map<String,Object> getShowRate (Integer agencyId);
	
	/**
	 * @description: 获得首页折扣信息
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月11日 下午3:46:10
	 */
	List<RateDiscountShowDTO> getIndexShowRate (Integer agencyId, Boolean isRoot);
	
	/**
	 * @description: 看传入的地区参数是否符合折扣信息
	 * @param loginAgencyId
	 * @param scopeCityName
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月1日 下午5:54:00
	 */
	boolean checkScopeIsAccept(Integer loginAgencyId, String scopeCityName);
	
	/**
	 * @description: 获得充值价格
	 * @param dataPo
	 * @param carrier
	 * @param loginAgencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 上午11:54:07
	 */
//	RateDiscountPo getRateForCharge(int serviceType,String carrier, int accountId,Boolean judgeChannelState);
	
	/**
	 * @description: 获得真正的充值费率
	 * @param ccpp
	 * @param accountId
	 * @param judgeChannelState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月26日 下午4:42:16
	 */
	RateDiscountPo getRateForCharge(ChargeChannelParamsPo ccpp, int accountId,Boolean judgeChannelState);
	
	/**
	 * @description:获得费率包体列表
	 * @param ccpp
	 * @param accountId
	 * @param judgeChannelState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月18日 下午4:02:14
	 */
	List<RatePgPo> getRatePgForCharge(ChargeChannelParamsPo ccpp, int accountId,Boolean judgeChannelState);
	
	/**
	 * @description: 获得充值的包体
	 * @param ccpp
	 * @param accountId
	 * @param judgeChannelState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月31日 下午4:27:38
	 */
	List<PgDataPo> getPgListForPurchase(ChargeChannelParamsPo ccpp, int agencyId,Boolean judgeChannelState);
	
	/**
	 * @description: 通过包体id获得代理商绑定的价格
	 * @param id
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月1日 上午9:41:10
	 */
	RateDiscountPo getPriceByPg(Integer id, Integer agencyId, Long channelId,Integer billType);
	
	/**
	 * @description:
	 * @param aacp
	 * @param rateDiscountPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午12:10:59
	 */
//	int getScopeExceptionForRate(AgencyActiveRatePo aacp,RateDiscountPo rateDiscountPo);
	
}
