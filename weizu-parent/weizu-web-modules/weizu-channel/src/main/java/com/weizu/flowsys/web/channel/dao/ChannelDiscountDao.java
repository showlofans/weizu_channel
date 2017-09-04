package com.weizu.flowsys.web.channel.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;

/**
 * @description:活动通道dao层接口
 * @projectName:weizu-channel
 * @className:ActiveChannelDao.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月4日 下午3:48:26
 * @version 1.0
 */
public interface ChannelDiscountDao extends Dao<ChannelDiscountPo, Long> {
	/**
	 * @description: 批量添加通道折扣
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月4日 下午4:23:18
	 */
	int discount_addList(List<ChannelDiscountPo> list);
	
	int countDiscount(Map<String,Object> paramsMap);
	
	/**
	 * @description: 查看折扣列表
	 * @param paramsMap
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月10日 下午12:05:56
	 */
	List<ChannelDiscountPo> getDiscountList(Map<String,Object> paramsMap);
	
	/**
	 * @description: 查询简易通道信息
	 * @param channelPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午3:53:23
	 */
	List<ChannelDiscountPo> listSimpleChannel(Map<String,Object> paramsMap);
	
	/**
	 * @description: 通过代理商和订单号得到走的通道折扣实体 
	 * @param purchaseId
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月4日 下午3:17:33
	 */
	ChannelDiscountPo getCDbyAP(Long purchaseId, Integer agencyId);
	
}
