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
import com.weizu.web.foundation.DateUtil;
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
	@Resource
	private ChargeAccountAo chargeAccountAO;
//	@Resource
//	private AgencyAO agencyAO;
	
	@Override
	public void getMyBankList(Integer contextId, Integer baHide, Map<String,Object> resultMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agencyId", contextId);
		
		if(baHide != null){
			map.put("baHide", baHide);
		}else{
			baHide = CallBackEnum.NEGATIVE.getValue();
			map.put("baHide", CallBackEnum.NEGATIVE.getValue());
		}
//		map.put("polarity", CallBackEnum.POSITIVE.getValue());
		List<BankAccountPo> dataList = bankAccountDao.getMyBankList(map);
		//将列表分开展示
		List<BankAccountPo> bankList0 = new LinkedList<BankAccountPo>();
		List<BankAccountPo> bankList = new LinkedList<BankAccountPo>();
		for (BankAccountPo bankAccountPo : dataList) {
			bankAccountPo.setLastAccessStr(DateUtil.formatAll(bankAccountPo.getLastAccess()));
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
		ChargeAccountPo chargeAccount1 = chargeAccountAO
				.getAccountByAgencyId(contextId,BillTypeEnum.CORPORATE_BUSINESS.getValue());
		resultMap.put("chargeAccount1", chargeAccount1);
		resultMap.put("baHide", baHide);
		ChargeAccountPo chargeAccount = chargeAccountAO
				.getAccountByAgencyId(contextId,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
		resultMap.put("chargeAccount", chargeAccount);
		resultMap.put("bankList0", bankList0);
		resultMap.put("bankList", bankList);
	}

	@Transactional
	@Override
	public String addBank(BankAccountPo bankPo) {
		//母卡是否存在
		BankAccountPo rootBankPo = bankAccountDao.getMyOneBankAccount(bankPo.getAgencyId(), bankPo.getRemittanceBankAccount(), CallBackEnum.POSITIVE.getValue());
		if(rootBankPo != null){
			return "exist";
		}
		//是否设置polarity为negative
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("agencyId", bankPo.getAgencyId());
		params.put("billType", bankPo.getBillType());
		params.put("inUseState", CallBackEnum.POSITIVE.getValue());
		params.put("originalPolarity", CallBackEnum.NEGATIVE.getValue());
		List<BankAccountPo> dataList = bankAccountDao.getOriginalBankA(params);
		if(bankPo.getPolarity() == null){
			if(!(dataList != null && dataList.size() > 0)){//有默认绑定的银行卡，就不设置为默认
				bankPo.setPolarity(CallBackEnum.NEGATIVE.getValue());//默认卡
			}else{
				bankPo.setPolarity(CallBackEnum.POSITIVE.getValue());//设为普通卡
			}
		}
		bankPo.setLastAccess(System.currentTimeMillis());
		bankPo.setBaHide(CallBackEnum.NEGATIVE.getValue());
		int res = bankAccountDao.add(bankPo);
		if(res > 0){
			return "success";
		}
		return "error";
	}

	@Override
	public void getPlusBankList(Integer rootAgencyId, Integer accountId,
			Map<String, Object> resultMap) {
		ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
		if(accountPo != null){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("agencyId", rootAgencyId);
			map.put("accountId", accountId);
			map.put("polarity", CallBackEnum.POSITIVE.getValue());
			map.put("useState", CallBackEnum.POSITIVE.getValue());
			List<BankAccountPo> dataList = bankAccountDao.getAttachBankList(map);
			if(!(dataList != null && dataList.size() > 0)){//没有手动绑定的银行卡，就用默认的银行卡
				Map<String,Object> params = new HashMap<String, Object>();
				params.put("agencyId", rootAgencyId);
				params.put("billType", accountPo.getBillType());
				params.put("inUseState", CallBackEnum.POSITIVE.getValue());
				params.put("originalPolarity", CallBackEnum.NEGATIVE.getValue());
				dataList = bankAccountDao.getOriginalBankA(params);
			}
			
			
			resultMap.put("plusBankList", dataList);
		}
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
			int billType = accountPo.getBillType();
			resultMap.put("billType", billType);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("agencyId", agencyId);
			map.put("inUseState", CallBackEnum.POSITIVE.getValue());
			map.put("billType", billType);
			//父级代理商所有银行卡
			List<BankAccountPo> parentAccountList = bankAccountDao.getMyBankList(map);	//获得没有绑定的银行卡
			
			//与该账户绑定的父级代理商银行卡
			map.put("accountId", accountId);
			map.put("polarity", CallBackEnum.POSITIVE.getValue());
			map.put("useState", CallBackEnum.POSITIVE.getValue());
			List<BankAccountPo> dataList = bankAccountDao.getAttachBankList(map);		//获得绑定的银行卡
			if(!(dataList != null && dataList.size() > 0)){//没有绑定的就加载默认的银行卡
				Map<String,Object> params = new HashMap<String, Object>();
				params.put("agencyId", agencyId);
				params.put("billType", billType);
				params.put("inUseState", CallBackEnum.POSITIVE.getValue());
				params.put("originalPolarity", CallBackEnum.NEGATIVE.getValue());
				dataList = bankAccountDao.getOriginalBankA(params);
//				dataList.addAll(dataList2);
			}
//			else{
//				boolean hasDefaultBank = false;
//				for (BankAccountPo bankAccountPo : dataList) {
//					if(CallBackEnum.NEGATIVE.getValue().equals(bankAccountPo.getPolarity())){
//						hasDefaultBank = true;
//						break;
//					}
//				}
//				if(hasDefaultBank){//有默认绑定的，
//					Map<String,Object> params = new HashMap<String, Object>();
//					params.put("agencyId", agencyId);
//					params.put("billType", billType);
//					params.put("inUseState", CallBackEnum.POSITIVE.getValue());
//					params.put("originalPolarity", CallBackEnum.NEGATIVE.getValue());
//					List<BankAccountPo> dataList2 = bankAccountDao.getOriginalBankA(params);
//					dataList.addAll(dataList2);
//				}
//			}
			
			List<BankAccountPo> sameAttachList = new LinkedList<BankAccountPo>();
			
			for (BankAccountPo parentAccount : parentAccountList) {
//				boolean hasDefaultBank = false;
				for (BankAccountPo dataBank : dataList) {
					Boolean isRepeat = dataBank.getRemittanceBankAccount().equals(parentAccount.getRemittanceBankAccount());
					if(isRepeat){
						sameAttachList.add(parentAccount);
					}
//					if(CallBackEnum.NEGATIVE.getValue().equals(dataBank.getPolarity()) ){
//						sameAttachList.add(dataBank);
////						hasDefaultBank = true;
//					}
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

	@Override
	public String changeBankPolarity(Long id, Integer polarity) {
		String result = "error";
//		BankAccountPo bankPo = bankAccountDao.get(id);
		Map<String,Object> params = new HashMap<String, Object>();
//		params.put("agencyId", bankPo.getAgencyId());
//		params.put("remmitanceBankAccount", bankPo.getRemittanceBankAccount());
		params.put("originalPolarity", polarity);
		params.put("bankId", id);
		
		int res = bankAccountDao.changePolarity(params);
		if(res > 0){
			result = "success";
		}
		return result;
	}

//	@Override
//	public void attachBankPage(Integer accountId, String agencyId) {
//		
//		
//	}

}
