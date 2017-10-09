package com.weizu.flowsys.web.agency.ao;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.web.agency.pojo.BankAccountPo;

public interface BankAccountAO {
	/**
	 * @description: 获得银行卡列表
	 * @param contextId 登陆用户id
	 * @param contextId 登陆用户id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 上午11:38:03
	 */
	void getBankList(Integer contextId, Map<String,Object> resultMap);
	
	/**
	 * @description: 添加银行卡信息
	 * @param bankPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月9日 下午3:57:41
	 */
	String addBank(BankAccountPo bankPo);
	
}
