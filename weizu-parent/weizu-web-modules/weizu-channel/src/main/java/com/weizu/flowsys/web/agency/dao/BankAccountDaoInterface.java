package com.weizu.flowsys.web.agency.dao;

import java.util.List;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;

/**
 * @description: 引用账户信息Dao层接口
 * @projectName:weizu-channel
 * @className:BankAccountDaoInterface.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月8日 上午11:29:01
 * @version 1.0
 */
public interface BankAccountDaoInterface extends Dao<BankAccountPo, Long> {
	/**
	 * @description: 获得银行卡列表
	 * @param contextId 登陆用户id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 上午11:38:03
	 */
	List<BankAccountPo> getBankList(Integer contextId);
}