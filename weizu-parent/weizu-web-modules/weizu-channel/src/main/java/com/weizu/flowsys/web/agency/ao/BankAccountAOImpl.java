package com.weizu.flowsys.web.agency.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
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
	@Resource
	private ChargeAccountDao chargeAccountDao;
	
	@Override
	public void getMyBankList(Integer contextId,  Map<String,Object> resultMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agencyId", contextId);
		map.put("polarity", CallBackEnum.POSITIVE.getValue());
		List<BankAccountPo> dataList = bankAccountDao.getBankList(map);
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

	@Override
	public void getPlusBankList(Integer contextId, Integer billType,
			Map<String, Object> resultMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agencyId", contextId);
		map.put("billType", billType);
		map.put("polarity", CallBackEnum.NEGATIVE.getValue());
		List<BankAccountPo> dataList = bankAccountDao.getBankList(map);
		resultMap.put("plusBankList", dataList);
	}

	@Override
	public BankAccountPo getBankPoById(Long id) {
		BankAccountPo bankPo = bankAccountDao.get(id);
		if(bankPo != null){
			ChargeAccountPo accountPo = chargeAccountDao.get(bankPo.getAccountId());
			if(accountPo != null){
				bankPo.setAccountBalance(accountPo.getAccountBalance());
				bankPo.setBillType(accountPo.getBillType());
			}
			return bankPo;
		}
		return null;
	}

}
