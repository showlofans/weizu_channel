package com.weizu.flowsys.web.channel.ao;

import java.util.List;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description:上级对接平台业务层接口
 * @projectName:crud
 * @className:ExchangePlatformAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 下午12:40:30
 * @version 1.0
 */
public interface ExchangePlatformAO {
	/**
	 * @description:通过平台名查找平台对象
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:45:57
	 */
	ExchangePlatformPo getEpByEpName(String epName);
	
	/**
	 * @description:通过id得到平台信息
	 * @param id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:07:43
	 */
	ExchangePlatformPo getEpById(Integer id);
	
	/**
	 * @description: 根据费率id获得平台信息
	 * @param rateId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月16日 下午4:54:06
	 */
//	ExchangePlatformPo getEpByRateId(Long rateId);
	
	/**
	 * @description: 通过通道id获得平台信息
	 * @param channelId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月18日 上午9:04:58
	 */
//	ExchangePlatformPo getEpByChannelId(Long channelId);
	
	/**
	 * @description:获得所有平台名称
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
	List<ExchangePlatformPo> getSimpleEp();
	/**
	 * @description:获得所有平台(agencyEp)
	 * @param name
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月11日 下午12:50:57
	 */
//	Pagination<ExchangePlatformPo> getEp(int agencyId,ExchangePlatformPo ep,PageParam pageParam);
	
	/**
	 * @description: 获得所有平台
	 * @param ep
	 * @param pageParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月11日 上午11:58:28
	 */
	Pagination<ExchangePlatformPo> getEp(ExchangePlatformPo ep,PageParam pageParam);
	/**
	 * @description:平台添加（单系统）
	 * @param exchangePlatformPo
	 * @param agencyId
	 * @param agencyName
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月8日 下午6:20:40
	 */
//	String addEp(ExchangePlatformPo exchangePlatformPo,int agencyId,String agencyName);
	
	/**
	 * @description: 平台添加
	 * @param exchangePlatformPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月17日 下午4:59:04
	 */
	String addEp(ExchangePlatformPo exchangePlatformPo);
	
	/**
	 * @description: 更新平台信息
	 * @param epPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月26日 上午10:24:44
	 */
	String updateEp(ExchangePlatformPo epPo);
	
	/**
	 * @description:清除平台信息
	 * @param epId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月26日 上午10:54:57
	 */
	String delEp(String epId);
	
	/**
	 * @description: 看英文标识是否存在
	 * @param epEngId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月17日 上午11:38:20
	 */
	boolean checkEpName(String epName);
	
	/**
	 * @description: 更新平台余额
	 * @return 
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月4日 上午10:11:14
	 */
	String updateEpBalance();
	
}
