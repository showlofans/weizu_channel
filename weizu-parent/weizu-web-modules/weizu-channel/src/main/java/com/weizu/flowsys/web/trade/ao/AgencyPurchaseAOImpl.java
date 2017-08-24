package com.weizu.flowsys.web.trade.ao;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
import com.weizu.flowsys.web.agency.dao.impl.ChargeRecordDao;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;

@Service(value="agencyPurchaseAO")
public class AgencyPurchaseAOImpl implements AgencyPurchaseAO {

	@Resource
	private AgencyPurchaseDao agencyPurchaseDao;
	@Resource
	private PurchaseDao purchaseDAO;
	@Resource
	private ChargeAccountDao chargeAccountDao;
	@Resource
	private ChargeRecordDao chargeRecordDao;
	
	@Override
	public String updatePurchaseState(Long orderId, Integer orderResult,
			String orderResultDetail) {
		int ap = 0;
		int pur = 0;
		if(orderResult == OrderStateEnum.UNCHARGE.getValue()){//手动失败，要返款
			List<AgencyPurchasePo> list = agencyPurchaseDao.list(new WherePrams("purchase_id", "=", orderId));
			int billType = -1;
			Integer agencyId = null;
			ChargeAccountPo accountPo = null;
			Double orderAmount = 0d;
			Double agencyBeforeBalance = 0.0d;
//		Double agencyAfterBalance = 0.0d;
			int batchAddCrt = 0;
			if(list != null && list.size() > 0){
				List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
				for (AgencyPurchasePo agencyPurchasePo : list) {
					agencyId = agencyPurchasePo.getAgencyId();
					billType = agencyPurchasePo.getBillType();
					orderAmount = agencyPurchasePo.getOrderAmount();
					accountPo = chargeAccountDao.get(new WherePrams("agency_id", "=", agencyId).and("bill_type", "=", billType));
					agencyBeforeBalance = accountPo.getAccountBalance();
					accountPo.addBalance(orderAmount, 1);
					recordPoList.add(new ChargeRecordPo(System.currentTimeMillis(), orderAmount,
							agencyBeforeBalance, accountPo.getAccountBalance(), 
							billType,AccountTypeEnum.Replenishment.getValue(), accountPo.getId(), agencyId, 1 , orderId));
					chargeAccountDao.updateLocal(accountPo, new WherePrams("id","=",accountPo.getId()));
				}
				batchAddCrt = chargeRecordDao.crt_addList(recordPoList);		//批量添加扣款记录信息
			}
			if(batchAddCrt > 0){
				//更新连接表
				ap = agencyPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
				//更新订单表
				pur = purchaseDAO.updatePurchaseState(new PurchaseStateParams(orderId, System.currentTimeMillis(), orderResult, orderResultDetail, null));
			}
		}else{
			//更新连接表
			ap = agencyPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
			//更新订单表
			pur = purchaseDAO.updatePurchaseState(new PurchaseStateParams(orderId, System.currentTimeMillis(), orderResult, orderResultDetail, null));
		}
		if(pur + ap > 1){
			return "success";
		}
		return "error";
	}

}
