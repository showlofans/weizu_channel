package com.weizu.flowsys.web.channel.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscount;
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
	
	/**
	 * @description: 获得折扣列表
	 * @param cdp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 下午5:57:36
	 */
	List<ChannelDiscountPo> getDiscountList(ChannelDiscountPo cdp);
	
	/**
	 * @description: 通过折扣列表初始化地区折扣列表
	 * @param paramsList
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 下午6:01:12
	 */
	List<OperatorDiscount> getOperatorList(List<ChannelDiscountPo> paramsList);
	
	/**
	 * @description: 通过折扣列表初始化地区折扣列表
	 * @param cdp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 下午6:24:29
	 */
	Map<String,Object> getOperatorList(ChannelDiscountPo cdp);
	
	Map<String,Object> getMapByEntity(ChannelDiscountPo cdp);
}
