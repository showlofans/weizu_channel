package com.weizu.flowsys.web.agency.ao;

import java.util.List;
import java.util.Map;

import com.aiyi.base.pojo.PageParam;
import com.aiyi.base.pojo.PurchasePo;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;
import com.weizu.flowsys.web.agency.pojo.GroupAgencyRecordPo;

public interface ChargeRecordAO {
	/**
	 * @description:修改代理商账户信息
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午4:06:02
	 */
	int updateAccount(Integer accountId, Double rechargeAmount,Integer loginContextId);
	
	/**
	 * @description:修改登陆用户账户余额
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月10日 上午11:47:52
	 */
//	int updateContextAccount(ChargeRecordPo chargeRecordPo);
	
	Map<String,Object> getMapByEntity(ChargeRecordPo chargeRecordPo);
	
	
	/**
	 * @description:加载分页充值记录列表
	 * @param params
	 * @param pageParam
	 * @param contextAgencyId 当前登陆id
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 下午4:07:35
	 */
	Pagination<ChargeRecordPo> listChargeRecord(Map<String, Object> resultMap,Integer contextAgencyId,ChargeRecordPo chargeRecordPo, PageParam pageParam);
	
	/**
	 * @description: 封装查询参数
	 * @param chargeRecordPo
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 下午5:17:57
	 */
	Map<String,Object> getMapByConsume(ConsumeRecordPo consumeRecordPo,Integer contextAgencyId);
	
	/**
	 * @description: 代理商订单消费统计
	 * @param contextAgencyId
	 * @param consumeRecordPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月5日 下午2:24:41
	 */
	List<GroupAgencyRecordPo> groupAgencyRecord(Integer contextAgencyId,ConsumeRecordPo consumeRecordPo);
	
	/**
	 * @description: 加载分页消费记录列表
	 * @param contextAgencyId
	 * @param consumeRecordPo
	 * @param pageParam
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月3日 下午5:17:19
	 */
	Pagination<ConsumeRecordPo> listConsumeRecord(Map<String, Object> resultMap,Integer contextAgencyId,ConsumeRecordPo consumeRecordPo, PageParam pageParam);
	
	/**
	 * @description:购买流量
	 * @param purchasePo
	 * @return 充值状态
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午6:00:42
	 */
	int purchasePg(PurchasePo purchasePo);
	
	/**
	 * @description:异步通过手机号获得充值的其他信息
	 * @param operatorType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月26日 下午6:04:29
	 */
	Map<String,Object> ajaxGetPurchasePg(String telephone);
	
}
