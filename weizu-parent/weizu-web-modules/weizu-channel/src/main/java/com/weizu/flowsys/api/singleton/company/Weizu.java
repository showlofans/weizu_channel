package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.weizu.api.util.HttpRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.OrderIn;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 微族接口实现
 * @projectName:weizu-channel
 * @className:Weizu.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月25日 下午5:49:05
 * @version 1.0
 */
public class Weizu implements BaseInterface {

	private static Weizu instance = new Weizu();  
	private static String epEngId;
	private static BaseP baseParams;
	private static String sign;
	
	
    private Weizu (){}  
    public static Weizu getInstance(String epEngId,BaseP baseParams) {  
    	Weizu.epEngId = epEngId;
//    	baseParams = baseParams;
    	Weizu.baseParams=baseParams;
    	ExchangePlatformPo epPo = baseParams.getEpo();
    	try {
    		Weizu.sign = MD5.getMd5("username="+epPo.getEpUserName()+"&apikey="+epPo.getEpApikey(),null,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return instance;  
    }
    
//    public static ChargeDTO charge(){
//    	String chargeTel = Weizu.baseParams.getChargeTel();
//    	System.out.println(chargeTel);
//    	return null;
//    }
    @Override
	public BalanceDTO getBalance() {
    	String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpBalanceIp(), toOrderParams());
    	BalanceDTO balanceDTO = null;
    	try {  
            JSONObject obj = JSON.parseObject(jsonStr);
            int rspCode = obj.getIntValue("errcode");
            String rspMsg = obj.getString("errmsg");
            double balance = 0.00d;
            String balanceStr = obj.getString("balance");
            if(StringHelper.isNotEmpty(balanceStr)){
            	balance = Double.parseDouble(balanceStr);
            }
            String epEngId = baseParams.getEpo().getEpEngId();
            String epEngIdTag = epEngId.substring(epEngId.length()-1);
            if("0".equals(epEngIdTag)){
            	balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
            }else{
            	balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
            }
    	 } catch (JSONException e) {  
             e.printStackTrace();  
         } 
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getPgdataCheckIp(), toOrderParams());
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(jsonStr)){
		 		return null;
		 	}
            JSONObject obj = JSON.parseObject(jsonStr);
            int rspCode = obj.getIntValue("errcode");
            String rspMsg = obj.getString("errmsg");
//            System.out.println(rspCode);
            if(rspCode == 55006){//订单不存在
            	
            }else{
            	JSONObject orderObj = obj.getJSONObject("order");
            	String orderIdApi = orderObj.getString("transaction_id");
            	String user_order_id = orderObj.getString("user_order_id");
            	String number = orderObj.getString("number");
            	String flowsize = orderObj.getString("flowsize");
            	String charge_fee = orderObj.getString("charge_fee");
            	int status = orderObj.getIntValue("status");
            	String msg = orderObj.getString("msg");
            	String created_at = orderObj.getString("created_at");
            	Long created_at_time = 0l;
            	Date date = DateUtil.strToDate(created_at, null);
            	if(DateUtil.strToDate(created_at, null) != null){
            		created_at_time = date.getTime();
            	}
            	int myStatus = OrderStateEnum.UNCHARGE.getValue();
            	switch (status) {
            	case 0://未充值
            		myStatus = OrderStateEnum.WEICHONG.getValue();
            		break;
            	case 1://等待充值
            		myStatus = OrderStateEnum.DAICHONG.getValue();
            		break;
            	case 2://正在充值
            		myStatus = OrderStateEnum.CHARGING.getValue();
            		break;
            	case 4://充值成功
            		myStatus = OrderStateEnum.CHARGED.getValue();
            		break;
            	case 8://充值失败
//				myStatus = OrderStateEnum.UNCHARGE.getValue();
            		break;
            	default:
            		break;
            	}
            	OrderIn orderId = new OrderIn(orderIdApi, user_order_id, number, flowsize, charge_fee, created_at, myStatus, msg);
            	orderId.setCreated_at_time(created_at_time);
            	//用我这边默认的对私账户充值
            	orderDTO = new OrderDTO(orderId, rspCode, rspMsg);
//            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, number, pgSize, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
            	// 最后输出到控制台  
//            System.out.println(tipCode+"<--->"+tipMsg);  
            	
            }
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}
	@Override
	public ChargeDTO charge() {
//		"http://139.224.70.161:32001/api/v1/sendOrder", "weizu", "CS111111", "722c16de0a83e5bd2f988e3c7bc9fee8", "15858343638", "500"
//		System.out.println(epEngId);
//		 baseParams.getEpo().getEpPurchaseIp();
		 
//		initSpecialP("1","1.0","GET");
		 String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpPurchaseIp(), toParams());
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(jsonStr)){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("errcode");
	            String tipMsg = obj.getString("errmsg");
	            
	            JSONObject orderObj = obj.getJSONObject("order");
	            String orderIdApi = orderObj.getString("transaction_id");
	            String number = orderObj.getString("number");
	            String pgSize = orderObj.getString("flowsize");
	            //用我这边默认的对私账户充值
	            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, number, pgSize, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
			    // 最后输出到控制台  
	            System.out.println(tipCode+"<--->"+tipMsg);  
	  
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		 
//		System.out.println(baseParams.getOrderId());
//		System.out.println(baseParams.getAddParams());
		return chargeDTO;
	}
	
	/**
	 * @description: 封装充值参数方法
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月28日 上午11:39:28
	 */
	public String toParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		 StringBuffer sbParams = new StringBuffer();
		sbParams.append("username=").append(epPo.getEpUserName());
		sbParams.append("&number=").append(baseParams.getChargeTel());
		sbParams.append("&flowsize=").append(baseParams.getProductCode());
		sbParams.append("&user_order_id=").append(baseParams.getOrderId());
		sbParams.append("&sign=").append(sign);
		
		return sbParams.toString();
		
		
//		return "username=" + epPo.getEpUserName() + "&number=" + baseParams.getChargeTel()
//				+ "&flowsize=" + baseParams.getProductCode() + "&user_order_id=" + baseParams.getOrderId()
//				+ "&sign=" + sign;
	}

	
	@Override
	public void initSpecialP(Object... objs) {
		//顺序和加入位置，都是可以随时调的
		String [] paramsNames = new String [] {"serviceCode","interVersion","callBackWay"};
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < objs.length; i++) {
			sBuffer.append(paramsNames[i]);
			sBuffer.append("=");
			sBuffer.append(objs[i].toString());
			sBuffer.append("&");
		}
//		Weizu.baseParams.setAddParams(sBuffer.toString());
	}
	@Override
	public void initSpecialP(String addParams) {
//		Weizu.baseParams.setAddParams(addParams);
	}
	@Override
	public String toBalanceParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
//		String sign = null;
//		try {
//			sign = MD5.getMd5("username="+epPo.getEpUserName()+"&apikey="+epPo.getEpApikey(),null,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		StringBuffer sbParams = new StringBuffer();
		sbParams.append("username=").append(epPo.getEpUserName());
		sbParams.append("&sign=").append(sign);
		return sbParams.toString();
	}
	@Override
	public String toOrderParams() {
		StringBuffer sbParams = new StringBuffer();
		ExchangePlatformPo epPo = baseParams.getEpo();
		sbParams.append("username=").append(epPo.getEpUserName());
		sbParams.append("&order_id=").append(baseParams.getOrderIdApi());		//通过api订单号去查，就是String类型
		sbParams.append("&sign=").append(sign);
		return sbParams.toString();
	}
	
	public static String getSign() {
		return sign;
	}
}
