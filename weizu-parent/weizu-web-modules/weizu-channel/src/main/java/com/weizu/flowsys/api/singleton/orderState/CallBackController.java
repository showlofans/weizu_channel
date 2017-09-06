package com.weizu.flowsys.api.singleton.orderState;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.trade.ao.AgencyPurchaseAO;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.http.HttpRequest;

/**
 * @description: 回调控制层
 * @projectName:weizu-channel
 * @className:CallBackController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月26日 上午10:32:16
 * @version 1.0
 */
@Controller(value=CallBackURL.MODOE_NAME)
public class CallBackController {
	@Resource
	private AgencyPurchaseAO agencyPurchaseAO;
//	@Resource
//	private PurchaseAO purchaseAO;
	
	@Resource
	private PurchaseDao purchaseDAO;
	
	@Resource
	private AgencyBackwardDao agencyBackwardDao;
	
	private final static int CALL_BACK_TIME = 6;			//回调次数
	
	private Logger logger = Logger.getLogger("CallBackController");
	
//	public void weizuCallBack(){
//		
//	}
	
	/**
	 * @description:丽荣科技回调: http://www.weizutec.top:28445/flowsys/callBack/li_rong.do
	 * @param taskId
	 * @param orderId
	 * @param mobile
	 * @param actualPrice
	 * @param status
	 * @param error
	 * @param reportTime
	 * @return ok
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月26日 上午10:34:58
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.LIRONG)
	public String liRongCallBack(int taskId,String orderId,String mobile,Double actualPrice,int status, String error,int reportTime){
		
		
		return "ok";
	}
	/**
	 * @description: 行云流水回调：http://www.weizutec.top:28445/flowsys/callBack/lljypt.do
	 * @param failReason
	 * @param outTradeNo
	 * @param sign
	 * @param status
	 * @param ts
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 下午4:29:17
	 */
	@RequestMapping(value=CallBackURL.LLJYPT,method=RequestMethod.POST)
	public String lljyptCallBack(String jsonStr){
		try {  
            JSONObject obj = JSON.parseObject(jsonStr);
            int status = obj.getIntValue("status");
            long ts = obj.getLongValue("ts");
            String sign = obj.getString("sign");
            String failReason = obj.getString("failReason");
            String outTradeNo = obj.getString("outTradeNo");//本地订单号
            long orderId = Long.parseLong(outTradeNo.trim());
            
            System.out.println(obj);
            PurchasePo purchasePo = purchaseDAO.get(new WherePrams("order_id_api", "=", outTradeNo.trim()).and("order_id", "=", orderId));
            //找到这个订单绑定的代理商，然后按照代理商的回调地址，推送json结果
            if (purchasePo  == null) {
            	logger.config("回调订单号不存在");
            	System.out.println("回调订单号不存在");
				return "回调订单号不存在";//
			}else{
				String orderIdFrom = purchasePo.getOrderIdFrom();
				ResponseJsonDTO rjdto = new ResponseJsonDTO(orderId, orderIdFrom, System.currentTimeMillis());
				String statusDetail = "";
				int myStatus = -1;
				if(4 == status){//成功回调
					myStatus = OrderStateEnum.CHARGED.getValue();
					statusDetail = OrderStateEnum.CHARGED.getDesc();
					
					rjdto.setStatus(myStatus);
					rjdto.setStatusDetail(statusDetail);
				}else if(5 == status){//失败回调
					myStatus = OrderStateEnum.UNCHARGE.getValue();
					statusDetail = failReason;
					
					rjdto.setStatus(myStatus);
					rjdto.setStatusDetail(statusDetail);
				}
				//把rjdto按照代理商返回
				if("success".equals(sendCallBack(rjdto, purchasePo.getAgencyId()))){//回调成功，更新数据库回调状态
					agencyPurchaseAO.updatePurchaseState(purchasePo.getOrderId(), myStatus, statusDetail, ts);
				}else{
					logger.config("回调失败");
					return "回调失败";
				}
			}
            
		    // 最后输出到控制台  
//            System.out.println(tipCode+"<--->"+tipMsg);  
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
		//String failReason,String outTradeNo,String sign,int status,Long ts
		return "ok";
	}
	/**
	 * @description: 向下游返回结果方法
	 * @param rjdto
	 * @param status
	 * @param statusDetail
	 * @param url
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月4日 下午1:08:42
	 */
	private String sendCallBack(ResponseJsonDTO rjdto,Integer agencyId){
		AgencyBackwardPo agencyPo = agencyBackwardDao.get(agencyId);
		String requestUrl = agencyPo.getCallBackIp();
		String resMsg = "";
		int i = 0;
		do{
			i++;
			String backJson = JSONObject.toJSONString(rjdto);
			resMsg = HttpRequest.sendPost(requestUrl, backJson);
			if(i== CALL_BACK_TIME){
				return "error";
			}
		}while(!"ok".equals(resMsg));
		
		return "success";
	}
}
