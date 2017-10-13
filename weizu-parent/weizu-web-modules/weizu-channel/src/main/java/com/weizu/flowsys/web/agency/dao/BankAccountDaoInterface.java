package com.weizu.flowsys.web.agency.dao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.dao.Dao;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
import com.weizu.flowsys.web.agency.pojo.TransferMsgVo;

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
	 * @description: 获得充值银行卡列表
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 上午11:38:03
	 */
	List<BankAccountPo> getMyBankList(Map<String, Object> paramsMap);//Integer contextId, Integer polarity
	
	/**
	 * @description: 获得充值银行卡列表
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 上午11:38:03
	 */
	List<BankAccountPo> getAttachBankList(Map<String, Object> paramsMap);
	
	/**
	 * @description: 根据卡号获得我的那张母卡
	 * @param toAgencyId
	 * @param remmitanceBankAccount
	 * @param inUseState
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 下午4:33:43
	 */
	BankAccountPo getMyOneBankAccount(Integer toAgencyId,String remmitanceBankAccount, Integer inUseState);
	
	/**
	 * @description: 获得转账消息展示列表
	 * @param params
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月13日 下午1:09:52
	 */
	List<TransferMsgVo> getTransferMsg(Integer toAgencyId,Integer confirmState);
	
	/**
	 * @description: 通过卡号和代理商id删除子母银行卡
	 * @param remmitanceBankAccount
	 * @param agencyId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月13日 上午11:04:35
	 */
//	int delBank(String remmitanceBankAccount, Integer agencyId);
	
}
