package com.weizu.flowsys.web.channel.dao;

import java.util.List;

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
public interface ChannelDiscountDao extends Dao<ChannelDiscountPo, Integer> {
	/**
	 * @description: 批量添加通道折扣
	 * @param list
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月4日 下午4:23:18
	 */
	public int discount_addList(List<ChannelDiscountPo> list);
}
