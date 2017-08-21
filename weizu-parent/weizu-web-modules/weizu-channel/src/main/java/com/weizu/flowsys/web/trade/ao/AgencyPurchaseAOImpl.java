package com.weizu.flowsys.web.trade.ao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;

@Service(value="agencyPurchaseAO")
public class AgencyPurchaseAOImpl implements AgencyPurchaseAO {

	@Resource
	private AgencyPurchaseDao agencyPurchaseDao;
	@Resource
	private PurchaseDao purchaseDAO;
	
	@Override
	public String updatePurchaseState(Long orderId, Integer orderResult,
			String orderResultDetail) {
		//更新订单表
		int pur = purchaseDAO.updatePurchaseState(new PurchaseStateParams(orderId, System.currentTimeMillis(), orderResult, orderResultDetail, null));
		//更新连接表
		int ap = agencyPurchaseDao.batchUpdateState(orderId, orderResult, orderResultDetail);
		if(pur + ap > 1){
			return "success";
		}else{
			return "error";
		}
	}

}
