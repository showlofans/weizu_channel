package com.weizu.flowsys.web.agency.ao;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.ConfirmStateTransferEnum;
import com.weizu.flowsys.operatorPg.enums.InOrOutEnum;
import com.weizu.flowsys.util.GetSlip;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
import com.weizu.flowsys.web.agency.dao.ChargeRecordDaoInterface;
import com.weizu.flowsys.web.agency.dao.ITransferRecDao;
import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.TransferRecordPo;
import com.weizu.flowsys.web.agency.pojo.TransferRecordVO;
import com.weizu.web.foundation.DateUtil;

@Service(value="transferRecAO")
public class TransferRecAOImpl implements TransferRecAO {

	@Resource
	private ITransferRecDao transferRecDao;
	@Resource
	private BankAccountDaoInterface bankAccountDao;
	@Resource
	private BankAccountAO bankAccountAO;
	@Resource
	private ChargeAccountDaoInterface chargeAccountDao;
//	@Resource
//	private ChargeRecordDaoInterface chargeRecordDao;
	@Resource
	private ChargeRecordAO chargeRecordAO;
	
	
	@Transactional
	@Override
	public String transferBank(TransferRecordPo transferPo) {
		transferPo.setCommitTime(System.currentTimeMillis());
		transferPo.setConfirmState(ConfirmStateTransferEnum.ON_CONFIRM.getValue());
		//转化真实时间格式
		Date realDate = DateUtil.strToDate(transferPo.getRealTimeStr(), null);
		if(realDate != null){
			transferPo.setRealTime(realDate.getTime());
		}
		//扣除来源账户的款
		int updateRes = 0;
		Long fromBankId = transferPo.getFromBankId();
		if(fromBankId != null){
			BankAccountPo fromBankPo = bankAccountDao.get(fromBankId);
			fromBankPo.minusReferenceBalance(transferPo.getCommitAmount(), -1);
			updateRes = bankAccountDao.updateLocal(fromBankPo, new WherePrams("id", "=", fromBankId));
		}
		
		//找到找到子代理商账户绑定卡的母卡to_agency_id找到母卡，设置to_bank_id
		BankAccountPo childAccountBankPo = bankAccountDao.get(transferPo.getToBankId());	//子代理商显示充值的卡
		Integer toAgencyId =  childAccountBankPo.getAgencyId();
		String remmitanceBankAccount = childAccountBankPo.getRemittanceBankAccount();
		int inUseState = CallBackEnum.POSITIVE.getValue(); 
		BankAccountPo bankPo = bankAccountDao.getMyOneBankAccount(toAgencyId, remmitanceBankAccount, inUseState);
		if(bankPo == null){
			System.out.println("没有找到该充值银行卡的母卡");
			return "error";
		}
		transferPo.setToBankId(bankPo.getId());
		transferPo.setTransferAmount(0.00d);
		//添加记录
		int addRes = transferRecDao.add(transferPo);
		
		if(addRes + updateRes > 1){
			return "success";
		}
		return "error";
	}


	@Override
	public void getTransferRec(Long bankId, Integer direction, Integer confirmState,PageParam pageParam, Map<String,Object> resultMap) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fromBankId", bankId);//默认查询转出记录
		map.put("confirmState", confirmState);//默认查询转出记录
		
		if(direction != null && InOrOutEnum.IN.getValue().equals(direction)){//查询转入记录
			map.put("fromBankId", null);
			map.put("toBankId", bankId);
		}else{
			direction = InOrOutEnum.OUT.getValue();
		}
		resultMap.put("direction", direction);
		Long totalRecord = transferRecDao.countInOutRecord(map);
		
		int pageSize = pageParam.getPageSize();
		Long pageNoLong = pageParam.getPageNoLong();
		map.put("start", (pageNoLong-1) * pageSize);
		map.put("end", pageSize);
		List<TransferRecordVO> records = transferRecDao.getInOutRecord(map);
		for (TransferRecordVO transferRecordVO : records) {
			if(transferRecordVO.getConfirmTime() != null){
				transferRecordVO.setConfirmTimeStr(DateUtil.formatAll(transferRecordVO.getConfirmTime()));
			}
			if(transferRecordVO.getCommitTime() != null){
				transferRecordVO.setCommitTimeStr(DateUtil.formatAll(transferRecordVO.getCommitTime()));
			}
			if(transferRecordVO.getRealTime() != null){
				transferRecordVO.setRealTimeStr(DateUtil.formatAll(transferRecordVO.getRealTime()));
			}
		}
		
		Pagination<TransferRecordVO> pagination = new Pagination<TransferRecordVO>(records, totalRecord, pageNoLong, pageSize);
		resultMap.put("pagination", pagination);
	}


	@Transactional
	@Override
	public String confirmTransfer(Long id, Integer confirmState) {
		TransferRecordPo transferPo = transferRecDao.get(id);
		int up1 = 0 ;
		if(ConfirmStateTransferEnum.CONFIRM_PASS.getValue().equals(confirmState)){
			Double transferAmount = transferPo.getCommitAmount();	//入账金额
			//增加自己的银行卡款，同时增加代理商系统账户的余额
			 BankAccountPo bankPo = bankAccountDao.get(transferPo.getToBankId());
			 Double referAccountBanlance = bankPo.minusReferenceBalance(transferAmount, 1);
			 bankPo.setReferenceBalance(referAccountBanlance);
			 up1 = bankAccountDao.updateLocal(bankPo,new WherePrams("id", "=", bankPo.getId()));
			 
			 ChargeAccountPo accountPo = chargeAccountDao.getAccountByTransferId(id);
			 
			 ChargeRecordPo paramsPo = new ChargeRecordPo(transferAmount, accountPo.getBillType(), AccountTypeEnum.INCREASE.getValue(), accountPo.getId());
			 Integer loginContextId = bankPo.getAgencyId();
			 int upAccount = chargeRecordAO.updateAccount(paramsPo, loginContextId);
			 up1 += upAccount -1 ;
			 
			 //将转账金额设置为0
			 transferPo.setTransferAmount(transferAmount);
			 
//			 Double beforeBalance = accountPo.getAccountBalance();
//			 //更新系统账户余额
//			 Double accountBalance = accountPo.addBalance(transferAmount, 1);
//			 
//			 int up2 = chargeAccountDao.updateLocal(accountPo, new WherePrams("id", "=", accountPo.getId()));
//			 int resultMsg = chargeRecordDao.add(new ChargeRecordPo(System
//						.currentTimeMillis(), transferAmount,
//						beforeBalance, accountPo.getAccountBalance(), 
//						AccountTypeEnum.INCREASE.getValue(), accountPo.getId(),1,null));
			 
			 
//			 int up2 = chargeAccountDao.update(accountPo);
//			 up1 += up2 -1;
//			 up1 += resultMsg -1;
			 
		}else if(ConfirmStateTransferEnum.FAIL_CONFIRM.getValue().equals(confirmState)){
			//增加子代理商银行卡款
			BankAccountPo fromBankPo = bankAccountDao.get(transferPo.getFromBankId());
			Double referAccountBanlance = fromBankPo.minusReferenceBalance(transferPo.getCommitAmount(), 1);
			fromBankPo.setReferenceBalance(referAccountBanlance);
			up1 = bankAccountDao.updateLocal(fromBankPo, new WherePrams("id", "=", fromBankPo.getId()));
			//将转账金额设置为0
			transferPo.setTransferAmount(0.00d);
//			up1 = bankAccountDao.update(fromBankPo);
		}
		//账户更新完成后更新转账记录
		if(up1 > 0){
			transferPo.setConfirmState(confirmState);
			transferPo.setConfirmTime(System.currentTimeMillis());
			//增加审核凭条
			transferPo.setTransferSlip(GetSlip.getSlip());
			int upRes = transferRecDao.updateLocal(transferPo, new WherePrams("id", "=", id));
			if(upRes > 0){
				return "success";
			}
		}
		return "error";
	}


//	@Override
//	public List<Map<String, Object>> getMapList(Integer to_agency_id) {
//		List<Map<String, Object>> mapList = new LinkedList<Map<String,Object>>();  
//		//先找到所有的银行卡列表
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("agencyId", to_agency_id);
//		map.put("polarity", CallBackEnum.POSITIVE.getValue());
//		List<BankAccountPo> myBankList = bankAccountDao.getMyBankList(map);//无带票区分列表
//		
////		bankAccountAO.getMyBankList(contextId, resultMap);
//		
//		//找到所有未审核的银行卡消息
//		Map<String, Object> paramsTransfer = new HashMap<String, Object>();
//		paramsTransfer.put("confirmState", ConfirmStateTransferEnum.ON_CONFIRM.getValue());
//		paramsTransfer.put("toAgencyId", to_agency_id);
//		List<TransferRecordVO> transferList = transferRecDao.getInOutRecord(paramsTransfer);
////				.list(new WherePrams("to_agency_id", "=", to_agency_id).and("confirm_state", "=", ConfirmStateTransferEnum.ON_CONFIRM.getValue()));
//		for (BankAccountPo bankAccountPo : myBankList) {
//			Map<String, Object> paramsMap = new HashMap<String, Object>();
//			int countNum = 0;	//未审核转账记录数
//			for (TransferRecordVO transferRecordVo : transferList) {
//				
////				if(transferRecordPo.getToBankId().equals(bankAccountPo.))
//			}
//			paramsMap.put("bankRtAccount", bankAccountPo.getRemittanceBankAccount());
//		}
//		return mapList;
//	}

}
