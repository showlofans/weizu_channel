package com.weizu.flowsys.web.trade.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.trade.dao.AccountPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;

@Service(value="accountPurchaseAO")
public class AccountPurchaseAOImpl implements AccountPurchaseAO {

	@Resource
	private AccountPurchaseDao accountPurchaseDao;
	@Resource
	private PurchaseDao purchaseDAO;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeRecordDao chargeRecordDao;
	
	@Override
	public String updatePurchaseState(Long orderId, Integer orderResult,
			String orderResultDetail, Long realBackTime) {
		int ap = 0;
		int pur = 0;
		if(realBackTime == null){
			realBackTime = System.currentTimeMillis();
		}
		if(orderResult == OrderStateEnum.UNCHARGE.getValue()){//手动失败，要返款
			PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
			if(purchasePo != null && purchasePo.getOrderResult() != null && OrderStateEnum.UNCHARGE.getValue() !=  purchasePo.getOrderResult()){
				List<AccountPurchasePo> list = accountPurchaseDao.list(new WherePrams("purchase_id", "=", orderId));
//				Double agencyAfterBalance = 0.0d;
					int batchAddCrt = 0;
					if(list != null && list.size() > 0){
						List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
						for (AccountPurchasePo agencyPurchasePo : list) {
//							Integer agencyId = agencyPurchasePo.getAgencyId();
//							int billType = agencyPurchasePo.getBillType();
//							ChargeAccountPo accountPo = chargeAccountDao.get(new WherePrams("agency_id", "=", agencyId).and("bill_type", "=", billType));
							Integer accountId = agencyPurchasePo.getAccountId();
							if(accountId != null){
								ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
								Double orderAmount = agencyPurchasePo.getOrderAmount();
								Double agencyBeforeBalance = accountPo.getAccountBalance();
								accountPo.addBalance(orderAmount, 1);
								recordPoList.add(new ChargeRecordPo(realBackTime, orderAmount,
										agencyBeforeBalance, accountPo.getAccountBalance(), 
										AccountTypeEnum.Replenishment.getValue(), accountId,  1 , orderId));
								chargeAccountDao.updateLocal(accountPo, new WherePrams("id","=",accountId));
							}
						}
						batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加扣款记录信息
						//更新连接表
						ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
						//更新订单表
						pur = purchaseDAO.updatePurchaseState(new PurchaseStateParams(orderId, System.currentTimeMillis(), orderResult, orderResultDetail, null));
					}
			}else{
				System.out.println("订单不存在");
				return "error";
			}
			
		}else{
			//更新连接表
			ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
			//更新订单表
			pur = purchaseDAO.updatePurchaseState(new PurchaseStateParams(orderId, System.currentTimeMillis(), orderResult, orderResultDetail, null));
		}
		if(pur + ap > 1){
			return "success";
		}
		return "error";
	}

}
