package com.weizu.flowsys.web.activity.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRateDTO;
import com.weizu.flowsys.web.activity.pojo.AccountActiveRatePo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

public interface AccountActiveRateAO {
	
	/**
	 * @description: 跳转到折扣代理商列表页面
	 * @param resultMap
	 * @param pageParam
	 * @param activePo
	 * @param channelId
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月7日 下午12:33:52
	 */
	void getBindRateList(Map<String,Object> resultMap,PageParam pageParam,AccountActiveRatePo activePo,Long channelId);
	
	/**
	 * @description:查询代理商参与的活动通道
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:15:57
	 */
	Pagination<AccountActiveRatePo> listActive(PageParam pageParam,AccountActiveRatePo activePo);
	
	
	
	/**
	 * @description: 查询分页费率列表
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午11:00:30
	 */
	Pagination<AccountActiveRatePo> listActiveRate(PageParam pageParam,AccountActiveRatePo activePo);
	
	/**
	 * @description:  查询分页费率列表
	 * @param pageParam
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午11:22:20
	 */
//	Pagination<AgencyActiveRatePo> listActiveRate(PageParam pageParam,RateDiscountPo ratePo);
	
	
	/**
	 * @description: 查询代理商参与的活动通道(不分页)
	 * @param pageParam
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 下午7:10:11
	 */
	List<AccountActiveRatePo> listActiveDiscount(PageParam pageParam,AccountActiveRatePo activePo);

	/**
	 * @description: 通过实体封装参数
	 * @param activePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 下午6:16:28
	 */
	Map<String,Object> getMapByEntity(AccountActiveRatePo activePo);
	
	/**
	 * @description: 通过实体封装参数
	 * @param ratePo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月13日 上午11:22:47
	 */
	Map<String,Object> getMapByEntity(RateDiscountPo ratePo);
	
	/**
	 * @description:代理商绑定通道
	 * @param aacp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月7日 上午9:34:30
	 */
	int bindChannel(AccountActiveRatePo aacp,RateDiscountPo rateDiscountPo);
	
	/**
	 * @description: 更新绑定状态
	 * @param activeId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 上午11:58:34
	 */
	int updateBindState(String activeId,String bindState);
	
	/**
	 * @description: 批量更新绑定状态（根据折扣id，批量解除绑定）
	 * @param rateDiscountId
	 * @param bindState
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月17日 上午10:08:57
	 */
	int batchUpdateBindState(AccountActiveRateDTO aardto);
	
	/**
	 * @description: 更新绑定的折扣
	 * @param activeId
	 * @param activeDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月8日 下午4:16:06
	 */
	int updateRateDiscount(String activeId,String activeDiscount);
	
	/**
	 * @description: 添加绑定
	 * @param aacp
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月15日 上午11:52:53
	 */
	int add(AccountActiveRatePo aacp);
	
	/**
	 * @description: 通道批量绑定代理商 
	 * @param aardto
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 下午3:37:46
	 */
	int batchBindAgency(AccountActiveRateDTO aardto);

	/**
	 * @description: 通道价格批量绑定所有代理商
	 * @param billTypeRate
	 * @param rootAgencyId
	 * @param aardto
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月20日 下午3:29:03
	 */
	int batchBindAllAgency(int billTypeRate, int rootAgencyId, AccountActiveRateDTO aardto, int updateBindState);
	
	
	
	/**
	 * @description:删除代理商和通道的绑定
	 * @param aarId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 下午3:43:48
	 */
	String delAar(Long aarId);
	
}
