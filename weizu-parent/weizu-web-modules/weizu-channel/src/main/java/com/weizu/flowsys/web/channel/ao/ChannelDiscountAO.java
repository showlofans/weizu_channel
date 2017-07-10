package com.weizu.flowsys.web.channel.ao;

import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;


/**
 * @description: 通道折扣
 * @projectName:weizu-channel
 * @className:ChannelDiscountAO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月10日 上午11:56:42
 * @version 1.0
 */
public interface ChannelDiscountAO {
	
	/**
	 * @description: 获得分页折扣列表
	 * @param cdp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月10日 上午11:57:45
	 */
	Pagination<ChannelDiscountPo> getDiscountList(ChannelDiscountPo cdp,PageParam pageParam);
	
	Map<String,Object> getMapByEntity(ChannelDiscountPo cdp);
}
