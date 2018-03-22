package com.weizu.flowsys.api.hsingleton.orderState;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weizu.flowsys.core.util.hibernate.util.StringHelper;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.web.trade.ao.AccountPurchaseAO;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.DateUtil;


@Controller
@RequestMapping(value=TelCallBackURL.MODOE_NAME)
public class TelCallBackController {

	@Resource
	private AccountPurchaseAO accountPurchaseAO;
//	@Resource
//	private PurchaseAO purchaseAO;
	
	@Resource
	private PurchaseDao purchaseDAO;
	
	/**
	 * @description: 连城连回调  /flowsys/telcallBack/unicomAync
	 * @param userId
	 * @param bizId
	 * @param ejId
	 * @param downstreamSerialno
	 * @param status
	 * @param sign
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月19日 上午11:49:42
	 */
	@ResponseBody
	@RequestMapping(value=TelCallBackURL.UNICOMAYNC,method=RequestMethod.GET)
	public String UnicomAyncCallBack(String userId,String bizId, String ejId, 
			String downstreamSerialno,String status, String sign){
		System.out.println("bizId:"+bizId+"ejId:"+ejId+"\tdownstreamSerialno:"+downstreamSerialno+"\tstatus:"+status);
		String successTag = "success";
		if(StringHelper.isEmpty(downstreamSerialno)){
			successTag = "未找到该订单";
			return successTag;
		}
		long orderId = Long.parseLong(downstreamSerialno);
        
        PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);//数据库没有没有上游订单号
		if(purchasePo == null){
			successTag = "未找到该订单";
			return successTag;
		}
		Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
		String res = "";
		if(!hasCall){//上一次没有回调成功
			int myStatus = -1;
			String statusDetail = "";
			if(status.equals("2")){//成功
				myStatus = OrderStateEnum.CHARGED.getValue();
				statusDetail = OrderStateEnum.CHARGED.getDesc();
			}else if(status.equals("3")){
				myStatus = OrderStateEnum.UNCHARGE.getValue();
				statusDetail = OrderStateEnum.UNCHARGE.getDesc();
			}
			 Long chargeTime = System.currentTimeMillis();
            res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, ejId, chargeTime, myStatus,OrderResultEnum.SUCCESS.getCode() , statusDetail));
            if(!"success".equals(res)){
            	successTag = res;
            }
		}
		System.out.println("successTag:"+successTag);
		return successTag;
	}
}
