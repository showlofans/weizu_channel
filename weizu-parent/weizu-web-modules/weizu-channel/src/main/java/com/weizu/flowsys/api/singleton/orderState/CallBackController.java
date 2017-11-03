package com.weizu.flowsys.api.singleton.orderState;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.dao.impl.AgencyBackwardDao;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.trade.ao.AccountPurchaseAO;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.PurchaseStateParams;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 回调控制层
 * @projectName:weizu-channel
 * @className:CallBackController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月26日 上午10:32:16
 * @version 1.0
 */
@Controller
@RequestMapping(value=CallBackURL.MODOE_NAME)
public class CallBackController {
	@Resource
	private AccountPurchaseAO accountPurchaseAO;
//	@Resource
//	private PurchaseAO purchaseAO;
	
	@Resource
	private PurchaseDao purchaseDAO;
	
	@Resource
	private SendCallBackUtil sendCallBack;
	
//	@Resource
//	private AgencyBackwardDao agencyBackwardDao;
	@Resource
	private AgencyAO agencyAO;
	
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
	public String lljyptCallBack(@RequestBody String jsonStr){
		try {  
            JSONObject obj = JSON.parseObject(jsonStr);
            int status = obj.getIntValue("status");
            long ts = obj.getLongValue("ts");
            String sign = obj.getString("sign");
            System.out.println(sign);
            String failReason = obj.getString("failReason");
            String outTradeNo = obj.getString("outTradeNo");//本地订单号
            long orderId = Long.parseLong(outTradeNo.trim());
            
            System.out.println(obj);
            PurchasePo purchasePo = purchaseDAO.get(new WherePrams("order_id_api", "=", outTradeNo.trim()).and("order_id", "=", orderId));
            //找到这个订单绑定的代理商，然后按照代理商的回调地址，推送json结果
            if (purchasePo  == null) {
            	logger.config("回调订单号不存在或者不匹配");
            	System.out.println("回调订单号不存在或者不匹配");
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
				String res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, null, ts, myStatus, null, statusDetail));//purchasePo.getOrderId(), myStatus, statusDetail, ts
				System.out.println("向下返回调结果："+res);
//				AgencyBackwardPo agencyPo = agencyAO.getAgencyByAccountId(purchasePo.getAccountId());
				//把rjdto按照代理商返回
//				if(!"success".equals(sendCallBack.sendCallBack(rjdto, agencyPo.getCallBackIp()))){//回调成功，更新数据库回调状态
//					logger.config("向下返回调失败");
//					System.out.println("向下返回调失败");
////					return "回调失败";
//				}
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
	 * @description: 河南硕朗回调
	 * @param errorcode
	 * @param transaction_id
	 * @param user_order_id
	 * @param number
	 * @param status
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月16日 下午1:07:19
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.Weizu)
	public String WeizuCallBack(@RequestBody String key){
		System.out.println("接收到的jsonStr："+key);
		String res = "ok";
		try {  
            JSONObject obj = JSON.parseObject(key);
            Integer errcode = obj.getInteger("errcode");
            String transaction_id = obj.getString("transaction_id");
            String user_order_id = obj.getString("user_order_id");//本地订单号
            String number = obj.getString("number");
            Integer status = obj.getInteger("status");
            
            if(errcode.equals(0)){
    			Long orderId = Long.parseLong(user_order_id);
    			String orderIdApi = transaction_id;
    			switch (status) {
    			case 4://成功:设置orderResult和orderState为成功
    				res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, System.currentTimeMillis(), OrderStateEnum.CHARGED.getValue(), null, OrderStateEnum.CHARGED.getDesc()));
    				break;
    			case 8://失败:设置orderResult为充值等待(设置回调缓冲时间限制)
    				res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, System.currentTimeMillis(), OrderStateEnum.DAICHONG.getValue(), null, OrderStateEnum.DAICHONG.getDesc()));
    				break;
    				
    			default:
    				break;
    			}
    		}
            if(!"success".equals(res)){
            	System.out.println("状态回调失败");
    			System.out.println(errcode+":" +transaction_id+":"  +user_order_id+":"  +number+":"  + status);
    			res = "状态回调失败";
    		}
            //根据订单号去更新数据库，并返回回调结果
  
        } catch (JSONException e) { 
        	e.printStackTrace();  
        	res = "解析json异常";
        }  
		return res;
	}
	/**
	 * @description: 乐疯回调接口
	 * @param errcode
	 * @param transaction_id
	 * @param user_order_id
	 * @param number
	 * @param status
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月20日 下午4:58:27
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.Lefeng)
	public String LefengCallBack(@RequestBody String key){
		System.out.println(key);
//		String res = null;
		String successTag = "0000";
		String statusDetail = "";
		int myStatus = -1;
		try {  
            JSONObject obj = JSON.parseObject(key);
            String mobile = obj.getString("mobile");
            String userId = obj.getString("userId");
            String msgId = obj.getString("msgId");//本地订单号
            String reqNo = obj.getString("reqNo");
            Integer err = obj.getInteger("err");
            String fail_describe = obj.getString("fail_describe");
            String report_time = obj.getString("report_time");
            String salePrice = obj.getString("salePrice");
            String finishTime = obj.getString("finishTime");
            String sign = obj.getString("sign");
            
            //初始化参数
            long orderId = Long.parseLong(msgId.trim());
            Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
            switch (err) {
			case 0:
				myStatus = OrderStateEnum.CHARGED.getValue();
				statusDetail = OrderStateEnum.CHARGED.getDesc();
				break;

			default:
				myStatus = OrderStateEnum.UNCHARGE.getValue();
				statusDetail = fail_describe;
				break;
			}
            
            successTag = sendCallBack.getCallBackResult(new PurchasePo(orderId, reqNo, orderBackTime, myStatus, null, statusDetail), successTag);	//不使用订单参数修改回调结果
            //根据订单号去更新数据库，并返回回调结果
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
//		System.out.println(successTag);
		return successTag;
	}
	
	
}
