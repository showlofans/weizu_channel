package com.weizu.flowsys.api.singleton.orderState;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.trade.ao.AccountPurchaseAO;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.http.HttpRequest;

/**
 * @description: 推送订单结果工具类
 * @projectName:weizu-channel
 * @className:SendCallBackUtil.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年9月7日 下午2:40:36
 * @version 1.0
 */
@Service(value="sendCallBack")
public class SendCallBackUtil {
	
	@Resource
	private AccountPurchaseAO accountPurchaseAO;
//	@Resource
//	private PurchaseAO purchaseAO;
	
	@Resource
	private PurchaseDao purchaseDAO;
	
//	@Resource
//	private AgencyBackwardDao agencyBackwardDao;
	@Resource
	private AgencyAO agencyAO;
	private final static int CALL_BACK_TIME = 6;			//回调次数
	
	/**
	 * @description: 向下游推送结果方法
	 * @param rjdto
	 * @param status
	 * @param statusDetail
	 * @param url
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月4日 下午1:08:42
	 */
	public String sendCallBack(ResponseJsonDTO rjdto,String reportUrl){
//		String requestUrl = agencyPo.getCallBackIp();
		String repRes = "";
		if(StringHelper.isNotEmpty(reportUrl)){
			String resMsg = "";
			int i = 0;
//			do{
//				try {
					i++;
					String backJson = JSONObject.toJSONString(rjdto);
					System.out.println("推送的json:"+ backJson);
					resMsg = HttpRequest.sendPost(reportUrl, backJson);
					if(i== CALL_BACK_TIME){
						return "error";
					}
//					if( i < 4 && !"ok".equals(resMsg) ){
//						Thread.sleep(30 * 1000 * i);//30 60 90
//					}else{
//						Thread.sleep(30 * 1000 * 10);//300s
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}while(!"ok".equals(resMsg));
			if("ok".equals(resMsg)){
				repRes = "success";
			}else{
				repRes = "error";
			}
			System.out.println(rjdto.getOrderId()+"推送响应："+resMsg);
		}else{
			System.out.println("回调地址不存在");
			repRes = "error";
		}
		System.out.println(rjdto.getOrderId()+"推送结果："+repRes );
		return repRes;
	}
	
	/**
	 * @description: 对上游接收回调结果
	 * @param purchasePo1 待更新的订单实体
	 * @param purchasePo 订单表中该订单的其他基本信息
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月24日 上午10:22:41
	 */
	@Transactional
	public String getCallBackResult(PurchasePo params,String successTag){
         //找到这个订单绑定的代理商，然后按照代理商的回调地址，推送json结果
         PurchasePo purchasePo = purchaseDAO.get(new WherePrams("order_id", "=", params.getOrderId()));	//根据订单号判断订单是否已经回调
 		if(purchasePo == null){
 			System.out.println("回调订单号不存在或者不匹配");
 			successTag = "本次回调失败：回调订单号不存在";//
 		}else{
 			Integer hasCallBack = purchasePo.getHasCallBack();
 			if(! OrderResultEnum.SUCCESS.getCode().equals(hasCallBack)){//已经回调过了
 				String orderIdFrom = purchasePo.getOrderIdFrom();
 				ResponseJsonDTO rjdto = new ResponseJsonDTO(params.getOrderId(), orderIdFrom, System.currentTimeMillis());
 				rjdto.setStatus(params.getOrderResult());
 				rjdto.setStatusDetail(params.getOrderResultDetail());
 				
 				params.setHasCallBack(OrderResultEnum.SUCCESS.getCode());
 				String callBack = accountPurchaseAO.updatePurchaseState(params);//orderId, backTime, myStatus, statusDetail, reqNo
 				if("success".equals(callBack)){//没有回调，本次回调成功
 					AgencyBackwardPo agencyPo = agencyAO.getAgencyByAccountId(purchasePo.getAccountId());
 					if(StringHelper.isNotEmpty(orderIdFrom) && agencyPo != null){
 						//把rjdto按照代理商返回
 						if(!"success".equals(sendCallBack(rjdto, agencyPo.getCallBackIp()))){//回调成功，更新数据库回调状态
 							//					logger.config("向下返回调失败");
 							System.out.println("向下返回调失败");
 						}
 					}
 				}else{//设为回调失败
 					successTag = "本次回调失败:更新数据库失败";
 				}
 			}
 			
 		}
// 		System.out.println(res);
 		return successTag;
	}
}
