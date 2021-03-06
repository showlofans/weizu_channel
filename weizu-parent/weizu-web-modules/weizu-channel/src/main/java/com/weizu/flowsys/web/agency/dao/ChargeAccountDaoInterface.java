package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.agency.pojo.AccountBalanceSumPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;

public interface ChargeAccountDaoInterface extends Dao<ChargeAccountPo, Integer>  {
	/**
	 * @description:通过代理商id获得账户信息（包涵Id的简易账户信息）
	 * @param agencyId
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月6日 上午11:40:01
	 */
	ChargeAccountPo selectByAgencyId(int agencyId, int billType);
	
	/**
	 * @description: 根据当前账户获得相关父级账户信息
	 * @param accountId
	 * @param billType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月26日 上午11:56:14
	 */
	ChargeAccountPo getRootAccountById(int accountId, int billType); 

	/**
	 * @description: 查询父级代理商的相关账户
	 * @param agencyId
	 * @param billType
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月3日 下午2:47:49
	 */
//	ChargeAccountPo selectRootAccountByAgencyId(int agencyId, int billType);
	
	/**
	 * @description:通过agencyId更新账户信息
	 * @param map
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月22日 下午4:25:12
	 */
	int updateById(Map<String, Object> map);
	
	/**
	 * @description: 通过转账记录id找到关联的转账账户
	 * @param transferId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 下午5:58:10
	 */
	ChargeAccountPo getAccountByTransferId(Long transferId, String type);
	
	/**
	 * @description: 更新账户余额
	 * @param accountBalance
	 * @param accountId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月5日 下午3:55:06
	 */
	int updateAccountBalance(Double accountBalance, Integer accountId);
	
	/**
	 * @description:  统计真实平台余额
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月7日 下午3:11:39
	 */
	List<AccountBalanceSumPo> getBalanceSum(Map<String, Object> params);
	
	
}
