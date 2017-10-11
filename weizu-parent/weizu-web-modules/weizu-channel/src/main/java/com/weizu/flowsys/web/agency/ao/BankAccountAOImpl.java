package com.weizu.flowsys.web.agency.ao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
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
//	@Resource
//	private AgencyAO agencyAO;
	
	@Override
	public void getMyBankList(Integer contextId,  Map<String,Object> resultMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agencyId", contextId);
		map.put("polarity", CallBackEnum.POSITIVE.getValue());
		List<BankAccountPo> dataList = bankAccountDao.getMyBankList(map);
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

	@Transactional
	@Override
	public String addBank(BankAccountPo bankPo) {
		bankPo.setPolarity(CallBackEnum.POSITIVE.getValue());//设为加款卡
		int res = bankAccountDao.add(bankPo);
		if(res > 0){
			return "success";
		}
		return "error";
	}

	@Override
	public void getPlusBankList(Integer contextId, Integer accountId,
			Map<String, Object> resultMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agencyId", contextId);
		map.put("accountId", accountId);
		map.put("polarity", CallBackEnum.POSITIVE.getValue());
		List<BankAccountPo> dataList = bankAccountDao.getAttachBankList(map);
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

	@Override
	public void getAttachBankList(Integer accountId,Integer agencyId,
			Map<String, Object> resultMap) {
		
		ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
		if(accountPo != null){
			resultMap.put("agencyName", accountPo.getAgencyName());
			resultMap.put("billType", accountPo.getBillType());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("agencyId", agencyId);
			map.put("inUseState", CallBackEnum.POSITIVE.getValue());
			map.put("billType", accountPo.getBillType());
			//父级代理商所有银行卡
			List<BankAccountPo> parentAccountList = bankAccountDao.getMyBankList(map);	//获得没有绑定的银行卡
			
			//与该账户绑定的父级代理商银行卡
			map.put("accountId", accountId);
			map.put("polarity", CallBackEnum.POSITIVE.getValue());
			map.put("useState", CallBackEnum.POSITIVE.getValue());
			List<BankAccountPo> dataList = bankAccountDao.getAttachBankList(map);		//获得绑定的银行卡
			
			List<BankAccountPo> sameAttachList = new LinkedList<BankAccountPo>();
			
			for (BankAccountPo parentAccount : parentAccountList) {
				for (BankAccountPo dataBank : dataList) {
					Boolean isRepeat = dataBank.getRemittanceBankAccount().equals(parentAccount.getRemittanceBankAccount());
					if(isRepeat){
						sameAttachList.add(parentAccount);
					}
				}
			}
			parentAccountList.removeAll(sameAttachList);
			
//			map.put("useState", CallBackEnum.POSITIVE.getValue());
			
//			
//			List<BankAccountPo> attachList = new LinkedList<BankAccountPo>();
//			 for (Iterator<BankAccountPo> it = dataList.iterator(); it.hasNext();) {
//				 BankAccountPo bankAccountPo = it.next();
//		         if (bankAccountPo.getAccountId().equals(accountId)) {
//		        	 attachList.add(bankAccountPo);
//			     }
//			}
//			 dataList.removeAll(attachList);//删除自己的部分
//			for (BankAccountPo bankAccountPo : attachList) {
//				for (BankAccountPo dataBank : dataList) {
//					Boolean isRepeat = !CallBackEnum.POSITIVE.getValue().equals(dataBank.getUseState()) && dataBank.getRemittanceBankAccount().equals(bankAccountPo.getRemittanceBankAccount());
//					if(isRepeat){
//						sameAttachList.add(dataBank);
//					}
//				}
//			}
//			dataList.removeAll(sameAttachList);
//			for (BankAccountPo bankAccountPo : dataList) {
//				if(bankAccountPo.getAccountId().equals(accountId)){
//					BankAccountPo clonePo = bankAccountPo.clone();
//					attachList.add(clonePo);
//					dataList.remove(bankAccountPo);
//				}
//			}
			resultMap.put("unattachList", parentAccountList);
			resultMap.put("attachList", dataList);
//			AgencyBackwardPo agencyPo = agencyAO.getAgencyByAccountId(accountId);
			resultMap.put("billTypeEnums", BillTypeEnum.toList());
		}
		
		
		
	}

	@Transactional
	@Override
	public String attachBank(BankAccountPo bankPo) {
		BankAccountPo existPo = bankAccountDao.get(new WherePrams("agency_id", "=", bankPo.getAgencyId()).and("account_id", "=", bankPo.getAccountId()).and("remittance_bank_account", "=", bankPo.getRemittanceBankAccount()));
		if(existPo != null){
			return "exist";
		}
		int res = bankAccountDao.add(bankPo);
		if(res > 0){
			return "success";
		}
		return "error";
	}

//	@Override
//	public void attachBankPage(Integer accountId, String agencyId) {
//		
//		
//	}

}
