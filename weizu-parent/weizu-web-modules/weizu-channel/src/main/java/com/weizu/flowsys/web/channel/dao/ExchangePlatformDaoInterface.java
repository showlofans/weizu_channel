package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description:对接平台管理接口
 * @projectName:crud
 * @className:ExchangePlatformDaoInterface.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 上午10:45:38
 * @version 1.0
 */
public interface ExchangePlatformDaoInterface extends Dao<ExchangePlatformPo, Integer> {
	/**
	 * @description:通过平台名查找平台对象
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	ExchangePlatformPo getEpByEpName(@Param("epName")String epName);
	
	/**
	 * @description: 根据费率id获得平台信息
	 * @param rateId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月16日 下午5:08:00
	 */
//	ExchangePlatformPo getEpByCDId(Long rateId);
	
	/**
	 * @description:根据通道折扣id获得平台信息
	 * @param channelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月18日 上午9:07:50
	 */
	ExchangePlatformPo getEpByCDiscountId(Long CDiscountId);
	
	/**
	 * @description: 通过话费通道id获得平台信息
	 * @param telchannelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月11日 下午4:38:34
	 */
	ExchangePlatformPo getEpByTelchannelId(Long telchannelId);
	/**
	 * @description:获得所有平台名称
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	List<ExchangePlatformPo> getSimpleEp();
	/**
	 * @description:获得所有平台
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	List<ExchangePlatformPo> getEp(Map<String,Object> paramsMap);
	/**
	 * @description:获得所有平台总记录数
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	int countEp(Map<String,Object> paramsMap);
	
	/**
	 * @description: 根据订单号找到订单流向的平台信息
	 * @param orderId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月16日 上午9:44:29
	 */
	ExchangePlatformPo getEpInPurchase(Long orderId);
	
}
