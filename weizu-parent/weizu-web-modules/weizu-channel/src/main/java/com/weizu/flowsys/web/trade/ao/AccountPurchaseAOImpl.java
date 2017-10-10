package com.weizu.flowsys.web.trade.ao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Override
	public String updatePurchaseState(Long orderId, Integer orderResult,
			String orderResultDetail, Long realBackTime) {
		int ap = 0;
		int pur = 0;
		if(realBackTime == null){
			realBackTime = System.currentTimeMillis();
		}
		
		//失败直接返款判定
		boolean unchargeNotSave = orderResult == OrderStateEnum.UNCHARGE.getValue();
		
		if(unchargeNotSave){//手动失败，要返款
			PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
			if(purchasePo != null && purchasePo.getOrderResult() != null && OrderStateEnum.UNCHARGE.getValue() !=  purchasePo.getOrderResult()){//清除已经返款的记录
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
						batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加补款记录信息
						//更新连接表
						ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
						//更新订单表(只更新超管的订单详情)
						pur = purchaseDAO.updatePurchaseState(new PurchaseStateParams(orderId, System.currentTimeMillis(), orderResult, orderResultDetail, null));
					}
			}else{
				System.out.println("订单不存在");
				return "error";
			}
			
		}else{
			if(!orderResult.equals(OrderStateEnum.CHARGED.getValue())){
				//更新连接表//不是成功和失败，就是进行
				ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, OrderStateEnum.CHARGING.getDesc());
			}else{
				ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, OrderStateEnum.CHARGED.getDesc());
			}
			//更新订单表
			pur = purchaseDAO.updatePurchaseState(new PurchaseStateParams(orderId, System.currentTimeMillis(), orderResult, orderResultDetail, null));
		}
		if(pur + ap > 1){
			return "success";
		}
		return "error";
	}

	@Transactional
	@Override
	public String updatePurchaseStateByMe(Long orderId, Integer orderResult,
			String orderResultDetail, Long realBackTime) {
		int ap = 0;
		int pur = 0;
		if(realBackTime == null){
			realBackTime = System.currentTimeMillis();
		}
		if(orderResult == OrderStateEnum.UNCHARGE.getValue()){//手动失败，要返款
			PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
			if(purchasePo != null && purchasePo.getOrderResult() != null && OrderStateEnum.UNCHARGE.getValue() !=  purchasePo.getOrderResult()){//清除已经返款的记录
				List<AccountPurchasePo> list = accountPurchaseDao.list(new WherePrams("purchase_id", "=", orderId));
//				Double agencyAfterBalance = 0.0d;
					int batchAddCrt = 0;
					if(list != null && list.size() > 0){
						List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
						List<AccountPurchasePo> apList = new LinkedList<AccountPurchasePo>();
						long recordId = chargeRecordDao.nextId();
						for (AccountPurchasePo accountPurchasePo : list) {
//							Integer agencyId = agencyPurchasePo.getAgencyId();
//							int billType = agencyPurchasePo.getBillType();
//							ChargeAccountPo accountPo = chargeAccountDao.get(new WherePrams("agency_id", "=", agencyId).and("bill_type", "=", billType));
							Integer accountId = accountPurchasePo.getAccountId();
							
							if(accountId != null){
								ChargeAccountPo accountPo = chargeAccountDao.get(accountId);
								Double orderAmount = accountPurchasePo.getOrderAmount();
								Double agencyBeforeBalance = accountPo.getAccountBalance();
								accountPo.addBalance(orderAmount, 1);
								recordPoList.add(new ChargeRecordPo(realBackTime, orderAmount,
										agencyBeforeBalance, accountPo.getAccountBalance(), 
										AccountTypeEnum.Replenishment.getValue(), accountId,  1 , orderId));
								chargeAccountDao.updateLocal(accountPo, new WherePrams("id","=",accountId));
								//更新连接表
//								ap = accountPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
//								Long appId = accountPurchaseDao.nextId();
								//同样的订单消费再添加一笔消费记录
								AccountPurchasePo appPo = accountPurchasePo.clone();
								appPo.setRecordId(recordId);
								appPo.setOrderState(orderResult);
								appPo.setOrderStateDetail(orderResultDetail);
								apList.add(appPo);
								recordId++;
							}
						}
						batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加补款记录信息
						ap = accountPurchaseDao.ap_addList(apList);
						//更新订单表(只更新超管的订单详情)
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
