package com.weizu.flowsys.api.singleton.orderState;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
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
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.OrderIn;
import com.weizu.flowsys.api.singleton.ProductDTO;
import com.weizu.flowsys.api.singleton.ProductIn;
import com.weizu.flowsys.core.beans.WherePrams;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.util.JsonKeyEncodeUtil;
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
 * @description: 回调控制层111
 * @projectName:weizu-channel
 * @className:CallBack111Controller.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月11日 上午9:33:46
 * @version 1.0
 */
@Controller
@RequestMapping(value=CallBackURL.MODOE_NAME)
public class CallBack111Controller {
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
	
	/**
	 * @description: 流量汇后台推送
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月27日 下午4:15:48
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.LIULIANGHUI,method=RequestMethod.POST,produces="application/json;charset=UTF-8")//charset=UTF-8
	public String liuLiangHuiCallBack(@RequestBody String key){
//		System.out.println(key);
		String successTag = "success";
		String statusDetail = "";
		int myStatus = -1;
		try {  
            JSONObject obj = JSON.parseObject(key);
            Integer code = obj.getInteger("code");
            String code_desc = obj.getString("code_desc");
            String goods_id = obj.getString("goods_id");
            String mch_id = obj.getString("mch_id");
            String out_trade_no = obj.getString("out_trade_no");//本地订单号
            String phone = obj.getString("phone");
            String time = obj.getString("time");
            String transaction_id = obj.getString("transaction_id");
            String sign = obj.getString("sign");
//            System.out.println("其它参数：time-"+time+"mch_id-"+mch_id+"goods_id-"+goods_id+"phone-"+phone);
            //初始化参数
            long orderId = Long.parseLong(out_trade_no.trim());
            
            PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);//数据库没有没有上游订单号
			if(purchasePo == null){
				successTag = "未找到该订单";
				return successTag;
			}
			Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
			String res = "";
			if(!hasCall){//上一次没有回调成功
	            //Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
	            switch (code) {
				case 0:
					myStatus = OrderStateEnum.CHARGED.getValue();
					statusDetail = OrderStateEnum.CHARGED.getDesc();
					break;
	
				default:
					myStatus = OrderStateEnum.UNCHARGE.getValue();
					statusDetail = code_desc;
					break;
				}
	            Long chargeTime = DateUtil.strToDate(time, "").getTime();
	            res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, transaction_id, chargeTime, myStatus,OrderResultEnum.SUCCESS.getCode() , statusDetail));
	            if(!"success".equals(res)){
	            	successTag = res;
	            }
			}
			System.out.println("code:"+code+"<--------->code_desc:"+code_desc);
            //根据订单号去更新数据库，并返回回调结果
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
//		System.out.println(successTag);
		return successTag;
	}
	/**
	 * @description: 江苏卡池-网池充值平台回调接口
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月29日 下午4:22:46
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.KPOOL,method=RequestMethod.POST,produces="application/json;charset=UTF-8")//charset=UTF-8
	public String kpoolCallBack(@RequestBody String key){
//		System.out.println(key);
		String successTag = "1";
		String statusDetail = "";
		int myStatus = -1;
		try {  
			JSONObject obj = JSON.parseObject(key);
			String orderid = obj.getString("orderid");
			String userid = obj.getString("userid");
			String bizid = obj.getString("bizid");
			String mobile = obj.getString("mobile");//本地订单号
			String resultCode = obj.getString("resultCode");
			String resultMsg = obj.getString("resultMsg");
			String sign = obj.getString("key");
//            System.out.println("其它参数：time-"+time+"mch_id-"+mch_id+"goods_id-"+goods_id+"phone-"+phone);
			//初始化参数
			long orderId = Long.parseLong(bizid.trim());
			
			PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);//数据库没有没有上游订单号
			if(purchasePo == null){
				successTag = "未找到该订单";
				return successTag;
			}
			Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
			String res = "";
			if(!hasCall){//上一次没有回调成功
				//Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
				if("T00003".equals(resultCode)){
					myStatus = OrderStateEnum.CHARGED.getValue();
					statusDetail = OrderStateEnum.CHARGED.getDesc();
				}else if("T00004".equals(resultCode)){
					myStatus = OrderStateEnum.UNCHARGE.getValue();
					statusDetail = resultMsg;
				}
				Long chargeTime = System.currentTimeMillis();
				res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderid, chargeTime, myStatus,OrderResultEnum.SUCCESS.getCode() , statusDetail));
				if(!"success".equals(res)){
					successTag = res;
				}
			}
			System.out.println("code:"+resultCode+"<--------->code_desc:"+resultMsg);
			//根据订单号去更新数据库，并返回回调结果
			
		} catch (JSONException e) {  
			e.printStackTrace();  
		}  
//		System.out.println(successTag);
		return successTag;
	}
	
	/**
	 * @description: 杭州弯流流量系统回调接口
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月27日 下午2:04:01
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.CTRA,method=RequestMethod.POST,produces="application/json;charset=UTF-8")//charset=UTF-8
	public String ctraCallBack(@RequestBody String key){
//		System.out.println(key+"..key");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		boolean code = false;
		String successTag = "success";
		String statusDetail = "";
		int myStatus = -1;
		try {  
			key = JsonKeyEncodeUtil.getRealJsonStr(key);
//			System.out.println("key1:"+key);
			key = key.substring(0, key.length()-1);
			System.out.println("key2:"+key);
			JSONObject orderObj = JSON.parseObject(key);
			String time = orderObj.get("updated").toString();
			String orderIdStr = orderObj.get("req_sn").toString();
			String orderIdApi = orderObj.get("order_sn").toString();
			String prod_code = orderObj.get("prod_code").toString();
			String order_stat = orderObj.get("order_stat").toString();
			String mob_no = orderObj.get("mob_no").toString();
			String err_code = orderObj.get("err_code").toString();
			String err_msg = orderObj.get("err_msg").toString();
			String sign = orderObj.getString("sign");
//            System.out.println("其它参数：time-"+time+"mch_id-"+mch_id+"goods_id-"+goods_id+"phone-"+phone);
			System.out.println(orderIdStr+"..");
			//初始化参数
			long orderId = Long.parseLong(orderIdStr.trim());
			
			PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);//数据库没有没有上游订单号
			if(purchasePo == null){
				resultMap.put("data", "未找到该订单");
				resultMap.put("code", code);
				String returnStr = JSON.toJSONString(resultMap);
				return returnStr;
			}
			Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
			String res = "";
			if(!hasCall){//上一次没有回调成功
				//Long orderBackTime = DateUtil.strToDate(report_time, null).getTime();
				if("99".equals(order_stat)){
					myStatus = OrderStateEnum.CHARGED.getValue();
					statusDetail = OrderStateEnum.CHARGED.getDesc();
				}else{
					myStatus = OrderStateEnum.UNCHARGE.getValue();
					statusDetail = OrderStateEnum.UNCHARGE.getDesc();
				}
				Long chargeTime = DateUtil.strToDate(time, "").getTime();
				res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, chargeTime, myStatus,OrderResultEnum.SUCCESS.getCode() , statusDetail));
				if(!"success".equals(res)){
					successTag = res;
				}
			}
			if("success".equals(successTag)){
				code = true;
			}else{
				resultMap.put("data", successTag);
			}
//			System.out.println("code:"+code+"<--------->successTag:"+successTag);
			//根据订单号去更新数据库，并返回回调结果
			
		} catch (JSONException e) {  
			return "内部错误：json解析异常";  
		}  
		resultMap.put("code", code);
		String returnStr = JSON.toJSONString(resultMap);
		System.out.println("返回值："+returnStr);
		return returnStr;
	}
	/**
	 * @description: 智胜新-生东网络-格科恒信息平台回调接口
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月28日 下午5:46:10
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.FLUX,method=RequestMethod.POST,produces="application/json;charset=UTF-8")//charset=UTF-8
	public String fluxCallBack(@RequestBody String key){
		String successTag = "ok";
		
		String statusDetail = "";
		int myStatus = -1;
		try {  
			System.out.println("返回值:"+key);
			JSONObject obj = JSON.parseObject(key);
//			JSONObject headerObj = obj.getJSONObject("header");
			JSONObject payloadObj = obj.getJSONObject("payload");
			
			JSONObject dataObj = payloadObj.getJSONObject("data");
			String orderIdStr = dataObj.getString("orderid");
			String orderIdApi = dataObj.getString("orderno");
			String desc = dataObj.getString("desc");
			String time = dataObj.getString("transtime");
			int result = dataObj.getIntValue("result");
			//初始化参数
			long orderId = Long.parseLong(orderIdStr.trim());
			
			PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);//数据库没有没有上游订单号
			if(purchasePo == null){
				return "未找到该订单";
			}
			Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
			String res = "";
			if(!hasCall){//上一次没有回调成功
				if(result == 0){
					myStatus = OrderStateEnum.CHARGED.getValue();
					statusDetail = OrderStateEnum.CHARGED.getDesc();
				}else{
					myStatus = OrderStateEnum.UNCHARGE.getValue();
					statusDetail = desc;
				}
				Long chargeTime = DateUtil.strToDate(time, "").getTime();
				res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, chargeTime, myStatus,OrderResultEnum.SUCCESS.getCode() , statusDetail));
				if(!"success".equals(res)){
					successTag = res;
				}
			}
        } catch (JSONException e) {  
            return "内部错误";
        } 
		return successTag;
	}
	/**
	 * @description: 顺园平台平台回调接口
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月30日 下午2:05:17
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.SHUNYUAN,method=RequestMethod.POST,produces="application/json;charset=UTF-8")//charset=UTF-8
	public String shunYuanCallBack(@RequestBody String key){
		String errorTag = "error";
		String statusDetail = "";
		int myStatus = -1;
		try {  
			System.out.println("返回值:"+key);
			JSONArray jsonArray = JSON.parseArray("OrderList");
			if(jsonArray != null){
				for (Object object : jsonArray) {
					JSONObject subObj = (JSONObject)object;
					String orderIdApi= subObj.getString("Id");
					String orderIdStr = subObj.getString("OrderCode");
					String desc = subObj.getString("Message");
					int status = subObj.getIntValue("Status");
					//初始化参数
					long orderId = Long.parseLong(orderIdStr.trim());
					
					PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderId);//数据库没有没有上游订单号
					if(purchasePo == null){
						return "未找到该订单";
					}
					Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
					String res = "";
					if(!hasCall){//上一次没有回调成功
						if(status == 0){
							myStatus = OrderStateEnum.CHARGED.getValue();
							statusDetail = OrderStateEnum.CHARGED.getDesc();
						}else {
							myStatus = OrderStateEnum.UNCHARGE.getValue();
							statusDetail = desc;
						}
						Long chargeTime = System.currentTimeMillis();
						res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderId, orderIdApi, chargeTime, myStatus,OrderResultEnum.SUCCESS.getCode() , statusDetail));
						if("success".equals(res)){
							errorTag = res;
						}
					}else{//已经有过回调，设置为成功
						errorTag = "1";
					}
					
				}
			}
		} catch (JSONException e) {  
			errorTag = "内部错误";
		} 
		return errorTag;
	}
	/**
	 * @description: 兴芃回调
	 * @param taskId
	 * @param orderId
	 * @param mobile
	 * @param status
	 * @param msg
	 * @param reportTime
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年3月30日 下午3:52:06
	 */
	@ResponseBody
	@RequestMapping(value=CallBackURL.XINGPENG,method=RequestMethod.POST)//charset=UTF-8
	public String xingPengCallBack(String taskId, String orderId,String mobile,
			String status,String msg,String reportTime){
			String successTag = "ok";
			boolean isNull = StringHelper.isEmpty(orderId) || StringHelper.isEmpty(status);
			if(!isNull){
				//初始化参数
				long orderIdl = Long.parseLong(orderId.trim());
				
				PurchasePo purchasePo = purchaseDAO.getOnePurchase(orderIdl);//数据库没有没有上游订单号
				if(purchasePo == null){
					return "未找到该订单";
				}
				Boolean hasCall = OrderResultEnum.SUCCESS.getCode().equals(purchasePo.getHasCallBack());
				String res = "";
				if(!hasCall){//上一次没有回调成功
					int result = Integer.parseInt(status);
					int myStatus = -1;
					String statusDetail = "";
					if(result == 0){
						myStatus = OrderStateEnum.CHARGED.getValue();
						statusDetail = OrderStateEnum.CHARGED.getDesc();
					}else {
						myStatus = OrderStateEnum.UNCHARGE.getValue();
						statusDetail = msg;
					}
//					Long chargeTime = System.currentTimeMillis();
					Long chargeTime = DateUtil.strToDate(reportTime, "yyyy-MM-dd HH：mm：ss").getTime();
					res = accountPurchaseAO.updatePurchaseState(new PurchasePo(orderIdl, taskId, chargeTime, myStatus,OrderResultEnum.SUCCESS.getCode() , statusDetail));
					if(!"success".equals(res)){
						successTag = res;
					}
				}
			}
		return successTag;
	}
	
	
	
}
