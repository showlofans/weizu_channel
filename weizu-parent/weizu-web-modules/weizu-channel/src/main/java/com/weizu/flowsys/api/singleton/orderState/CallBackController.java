package com.weizu.flowsys.api.singleton.orderState;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.ProductDTO;
import com.weizu.flowsys.api.singleton.ProductIn;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
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
import com.weizu.web.foundation.http.HttpRequest;

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
	public String WeizuCallBack(Integer errcode, String transaction_id,String user_order_id, String number,Integer status){
//			@RequestParam(value = "flowsize", required = false)String flowsize,@RequestParam(value = "charge_fee", required = false)String charge_fee,
//			@RequestParam(value = "realcash", required = false)String realcash,@RequestParam(value = "msg", required = false)String msg
		String successTag = "ok";
		String res = "";
		if(errcode.equals(0)){
			Long orderId = Long.parseLong(user_order_id);				//用户订单号
			PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
			Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
			if(!hasCall){//上一次没有回调成功
				String orderIdApi = transaction_id;
				switch (status) {
				case 4://成功:设置orderResult和orderState为成功
					res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, System.currentTimeMillis(), OrderStateEnum.CHARGED.getValue(), null, OrderStateEnum.CHARGED.getDesc()));
					break;
				case 8://失败:设置orderResult为充值等待(设置回调缓冲时间限制)
					res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, System.currentTimeMillis(), OrderStateEnum.UNCHARGE.getValue(), null, OrderStateEnum.UNCHARGE.getDesc()));
					break;
				default:
					break;
				}
				if(!"success".equals(res)){//success返ok
					System.out.println("状态回调失败");
					System.out.println(errcode+":" +transaction_id+":"  +user_order_id+":"  +number+":"  + status);
					successTag = "状态回调失败";
				}
			}else{
				System.out.println("已经有过回调");
			}
		}else{
			System.out.println("errCode:" +errcode);
		}
		System.out.println("successTag:"+successTag);
		return successTag;
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
	@RequestMapping(value=CallBackURL.LEFENG)
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
            
            PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
			Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
			String res = "";
			if(!hasCall){//上一次没有回调成功
	            //Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
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
	            res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, reqNo, System.currentTimeMillis(), myStatus,null , statusDetail));
	            if(!"success".equals(res)){
	            	successTag = res;
	            }
			}
            //根据订单号去更新数据库，并返回回调结果
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
//		System.out.println(successTag);
		return successTag;
	}
	/**
	 * @description: 河南趣闻回调
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月13日 上午9:52:26
	 */
//	@ResponseBody
//	@RequestMapping(value=CallBackURL.Wantull)
//	public String WantullCallBack(@RequestBody String key){
//		System.out.println(key);
////		String res = null;
//		String successTag = "ok";
//		String statusDetail = "";
//		int myStatus = -1;
//		try {  
//			JSONObject obj = JSON.parseObject(key);
//			Integer code = obj.getInteger("code");
//			String msg = obj.getString("msg");
//			if(code.equals(1)){
//				String mobile = obj.getString("mobile");
//				String orderIdApi = obj.getString("trade_no");
//				String msgId = obj.getString("out_trade_no");//本地订单号
//				String sign = obj.getString("sign");
//				String packageId = obj.getString("package");
//				Integer charge_status = obj.getInteger("charge_status");
//				System.out.println("其他参数：sign="+sign + " msg=" + msg+ "mobile="+mobile + " package=" + packageId );
//				//初始化参数
//				long orderId = Long.parseLong(msgId.trim());
//				PurchasePo purchasePo = purchaseDAO.get(orderId);
//				Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
//				String res = "";
//				if(!hasCall){//上一次没有回调成功
//					//Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
//					switch (charge_status) {
//					case 4:
//						myStatus = OrderStateEnum.CHARGED.getValue();
//						statusDetail = OrderStateEnum.CHARGED.getDesc();
//						break;
//					case 5:
//						myStatus = OrderStateEnum.UNCHARGE.getValue();
//						statusDetail = OrderStateEnum.UNCHARGE.getDesc();
//						break;
//						
//					default:
//						break;
//					}
//					res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, System.currentTimeMillis(), myStatus,null , statusDetail));
//					if(!"success".equals(res)){
//						successTag = res;
//					}
//				}
//				//根据订单号去更新数据库，并返回回调结果
//			}else{
//				successTag = "error";
//			}
//		} catch (JSONException e) {  
//			e.printStackTrace();  
//		}  
////		System.out.println(successTag);
//		return successTag;
//	}
	/**
	 * @description: 河南趣闻回调
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月12日 下午2:29:47
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.WANTULL)
	public String WantullCallBack(HttpServletRequest request){
		
		String successTag = "ok";
		String statusDetail = "";
		int myStatus = -1;
		try {  
			String msg = request.getParameter("msg")==null?"":request.getParameter("msg").toString();
			if(request.getParameter("code") == null){
				successTag = "errorCode";
			}else{
				String codeStr = request.getParameter("code").toString();
				Integer code = Integer.parseInt(codeStr);
				
				if(code.equals(1)){
					String packageId = request.getParameter("package")==null?"":request.getParameter("package").toString();
					String mobile = request.getParameter("mobile")==null?"":request.getParameter("mobile").toString();
					String orderIdApi = request.getParameter("trade_no").toString();
					String charge_statusStr = request.getParameter("charge_status").toString();
					String sign = request.getParameter("sign")==null?"":request.getParameter("sign").toString();
					Integer charge_status = Integer.parseInt(charge_statusStr);
					
					System.out.println("其他参数：sign="+sign + " msg=" + msg+ "mobile="+mobile + " package=" + packageId );
					
					String msgId = request.getParameter("out_trade_no").toString();
					//初始化参数
					long orderId = Long.parseLong(msgId.trim());
					PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
					Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
					String res = "";
					if(!hasCall){//上一次没有回调成功
						//Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
						switch (charge_status) {
						case 4:
							myStatus = OrderStateEnum.CHARGED.getValue();
							statusDetail = OrderStateEnum.CHARGED.getDesc();
							break;
						case 5:
							myStatus = OrderStateEnum.UNCHARGE.getValue();
							statusDetail = OrderStateEnum.UNCHARGE.getDesc();
							break;
							
						default:
							break;
						}
						res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, System.currentTimeMillis(), myStatus,null , statusDetail));
						if(!"success".equals(res)){
							successTag = res;
						}
					}
				}else{
					successTag = "errorCode："+code;
				}
			}
			//根据订单号去更新数据库，并返回回调结果
			
		} catch (JSONException e) {  
			e.printStackTrace();  
		}  
		System.out.println("successTag:"+successTag);
		return successTag;
	}
	/**
	 * @description: 迈远系统GET回调（未使用）
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月14日 下午4:06:23
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.MAIYUAN,method=RequestMethod.GET)
	public String MaiyuanCallBack(String TaskId, String mobile, Integer Status, String ReportTIme,
			String ReportCode, String OutTradeNo,String sign){
		String successTag = "ok";
		String statusDetail = "";
		int myStatus = -1;
		try {  
				System.out.println("其他参数：sign="+sign + " ReportCode=" + ReportCode + " OutTradeNo=" + OutTradeNo+ "mobile="+mobile + " ReportTIme=" + ReportTIme );
				//初始化参数
				long orderId = Long.parseLong(OutTradeNo.trim());
				PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
				Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
				String res = "";
				if(!hasCall){//上一次没有回调成功
					//Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
					switch (Status) {
					case 4:
						myStatus = OrderStateEnum.CHARGED.getValue();
						statusDetail = OrderStateEnum.CHARGED.getDesc();
						break;
					case 5:
						myStatus = OrderStateEnum.UNCHARGE.getValue();
						statusDetail = OrderStateEnum.UNCHARGE.getDesc();
						break;
						
					default:
						break;
					}
					res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, TaskId, System.currentTimeMillis(), myStatus,null , statusDetail));
					if(!"success".equals(res)){
						successTag = res;
					}
				}
			//根据订单号去更新数据库，并返回回调结果
			
		} catch (JSONException e) {  
			e.printStackTrace();  
		}  
		System.out.println("successTag:"+successTag);
		return successTag;
	}
	/**
	 * @description: 迈远系统Post回调(使用)
	 * @param jsonStr
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月14日 下午4:38:13
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.MAIYUAN,method=RequestMethod.POST)
	public String MaiyuanCallBack(@RequestBody String jsonStr){
		String successTag = "ok";
		String statusDetail = "";
		int myStatus = -1;
		try {  
			JSONArray jsonArr = JSON.parseArray(jsonStr);
			boolean isError = false;
			if(jsonArr != null && jsonArr.size() > 0){
				for (Object object : jsonArr) {
	        		JSONObject jsonObj = (JSONObject)object;
	        		int Status = jsonObj.getIntValue("Status");
	        		String taskId = jsonObj.getString("TaskID");
	        		String mobile = jsonObj.getString("Mobile");
	        		String ReportTIme = jsonObj.getString("ReportTIme");
	        		String OutTradeNo = jsonObj.getString("OutTradeNo");
	        		String ReportCode = jsonObj.getString("ReportCode");
	        		String sign = jsonObj.getString("sign");
//	        	System.out.println("type=" + name);
	        		System.out.println("其他参数：sign="+sign + " ReportCode=" + ReportCode+ "mobile="+mobile + " ReportTIme=" + ReportTIme + " OutTradeNo=" + OutTradeNo );
	        		if(StringHelper.isEmpty(OutTradeNo)){
	        			successTag = "没有返回用户订单号";
	        			break;
	        		}else{
	        			//初始化参数
	        			long orderId = Long.parseLong(OutTradeNo.trim());
	        			PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
	        			Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
	        			String res = "";
	        			if(!hasCall){//上一次没有回调成功
	        				//Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
	        				switch (Status) {
	        				case 4:
	        					myStatus = OrderStateEnum.CHARGED.getValue();
	        					statusDetail = OrderStateEnum.CHARGED.getDesc();
	        					break;
	        				case 5:
	        					myStatus = OrderStateEnum.UNCHARGE.getValue();
	        					statusDetail = OrderStateEnum.UNCHARGE.getDesc();
	        					break;
	        					
	        				default:
	        					break;
	        				}
	        				res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, taskId, System.currentTimeMillis(), myStatus,null , statusDetail));
	        				if(!"success".equals(res)){
	        					isError = true;
//	        				successTag = res;
	        				}
	        			}
	        		}
	        	}
	        }else{
	        	successTag = "没有返回数据";
	        }
			if(isError){
				successTag = "更新数据库失败";
			}
			//根据订单号去更新数据库，并返回回调结果
			
		} catch (JSONException e) {  
			e.printStackTrace();  
		}  
		System.out.println("successTag:"+successTag);
		return successTag;
	}
	/**
	 * @description: 智信系统回调
	 * @param jsonStr
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月22日 上午10:44:54
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.ZXPAY,method=RequestMethod.GET)
	public String ZxpayCallBack(@RequestBody String jsonStr){
		String successTag = "SUCCESS";
		String statusDetail = "";
		int myStatus = -1;
		try {  
			System.out.println("回调返回json串:"+jsonStr);
			JSONObject obj = JSON.parseObject(jsonStr);
			String orderIdApi = obj.getString("up_order_no");
        	String user_order_id = obj.getString("client_order_no");
        	
//        	String number = obj.getString("phone_no");
        	int status = obj.getIntValue("recharge_status");
        	String elecardID = obj.getString("elecardID");//运营商流水号
        	String charge_fee = obj.getString("deduction_amount");
        	
        	String product_type = obj.getString("product_type");//产品类型
        	String sign = obj.getString("sign");//签名
        	String msg = obj.getString("desc");
        	System.out.println("其他结果参数：desc="+msg+"product_type="+product_type+"运营商流水号："+elecardID);
        	System.out.println("其他结果参数：sign："+sign+"抵扣金额（分）："+charge_fee);
        	if(StringHelper.isEmpty(user_order_id)){
				successTag = "没有返回用户订单号";
			}else{
				//初始化参数
				long orderId = Long.parseLong(user_order_id.trim());
				PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);
				Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
				String res = "";
				if(!hasCall){//上一次没有回调成功
					//Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
					switch (status) {
					case 1://充值中
	            		myStatus = OrderStateEnum.CHARGING.getValue();
	            		statusDetail = OrderStateEnum.CHARGING.getDesc();
	            		break;
	            	case 2://充值成功
	            		myStatus = OrderStateEnum.CHARGED.getValue();
	            		statusDetail = OrderStateEnum.CHARGED.getDesc();
	            		break;
	            	case 6://充值失败
	            		myStatus = OrderStateEnum.UNCHARGE.getValue();
	            		statusDetail = OrderStateEnum.UNCHARGE.getDesc();
	            		break;
					default:
						break;
					}
					res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, System.currentTimeMillis(), myStatus,null , statusDetail));
					if(!"success".equals(res)){
						successTag = res;
					}
				}
			}
			//根据订单号去更新数据库，并返回回调结果
			
		} catch (JSONException e) {  
			successTag = "json结果解析异常";
			e.printStackTrace();  
		}  
		System.out.println("successTag:"+successTag);
		return successTag;
	}
	
	
	
	
}
