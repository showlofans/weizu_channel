package com.weizu.flowsys.web.agency.ao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.agency.pojo.BankAccountPo;

public interface BankAccountAO {
	
	/**
	 * @description: 获得我的银行卡列表
	 * @param contextId
	 * @param resultMap
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月11日 上午10:49:51
	 */
	void getMyBankList(Integer contextId, Map<String,Object> resultMap);
	
	/**
	 * @description: 根据子代理商账户id查询绑定的银行卡
	 * @param accountId
	 * @param resultMap
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月11日 上午10:50:28
	 */
	void getAttachBankList(Integer accountId,Integer agencyId, Map<String,Object> resultMap);
	
	/**
	 * @description: 获得被加卡列表
	 * @param contextId
	 * @param billType
	 * @param resultMap
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月10日 下午4:31:09
	 */
	void getPlusBankList(Integer contextId,Integer accountId, Map<String,Object> resultMap);
	
	/**
	 * @description: 添加银行卡信息
	 * @param bankPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午3:57:41
	 */
	String addBank(BankAccountPo bankPo);
	
	/**
	 * @description: 根据id获得页面账户实体
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月10日 下午6:13:42
	 */
	BankAccountPo getBankPoById(Long id);
	
	/**
	 * @description: 给代理商添加银行卡绑定
	 * @param bankPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月11日 上午10:58:45
	 */
	String attachBank(BankAccountPo bankPo);
	
	/**
	 * @description: 修改子母银行卡默认状态
	 * @param id
	 * @param polarity
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月16日 上午11:13:17
	 */
	String changeBankPolarity(Long id, Integer polarity);
	
	/**
	 * @description: 初始化绑定银行卡页面
	 * @param accountId
	 * @param agencyId
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月11日 上午11:41:02
	 */
//	void attachBankPage(Integer accountId,String agencyId);
	
}
