package com.weizu.flowsys.web.agency.ao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
/**
 * @description: 银行卡管理AO
 * @projectName:weizu-channel
 * @className:BankAccountAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月9日 上午11:42:28
 * @version 1.0
 */
@Service(value="bankAccountAO")
public class BankAccountAOImpl implements BankAccountAO {

	@Resource
	private BankAccountDaoInterface bankAccountDao;
	
	@Override
	public void getBankList(Integer contextId, Map<String,Object> resultMap) {
		List<BankAccountPo> dataList = bankAccountDao.getBankList(contextId);
		//将列表分开展示
		List<BankAccountPo> bankList0 = new LinkedList<BankAccountPo>();
		List<BankAccountPo> bankList = new LinkedList<BankAccountPo>();
		for (BankAccountPo bankAccountPo : dataList) {
			if(BillTypeEnum.CORPORATE_BUSINESS.getValue().equals(bankAccountPo.getBillType())){
				bankList.add(bankAccountPo);
			}else if(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue().equals(bankAccountPo.getBillType())){
				bankList0.add(bankAccountPo);
			}
		}
		//设置账户余额
//		if(bankList.size() > 0){
//			resultMap.put("accountBalance", bankList.get(0).getAccountBalance());
//		}
//		if(bankList0.size() > 0){
//			resultMap.put("accountBalance0", bankList0.get(0).getAccountBalance());
//		}
		resultMap.put("bankList0", bankList0);
		resultMap.put("bankList", bankList);
	}

	@Override
	public String addBank(BankAccountPo bankPo) {
		int res = bankAccountDao.add(bankPo);
		if(res > 0){
			return "success";
		}
		return "error";
	}

}
