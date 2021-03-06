package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.weizu.api.forward.weizu.OrderState;
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
import com.weizu.flowsys.operatorPg.enums.CallBackEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
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
//	@Resource
//	private IProductCodeDAO productCodeDAO;
	
	
    private Weizu (){}  
    public static Weizu getInstance(String epEngId,BaseP baseParams) {  
    	Weizu.setEpEngId(epEngId);
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
    	String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpBalanceIp(), toBalanceParams());
    	BalanceDTO balanceDTO = null;
    	try {  
            JSONObject obj = JSON.parseObject(jsonStr);
            int rspCode = obj.getIntValue("errcode");
            String rspMsg = obj.getString("errmsg");
            double balance = 0.00d;
            String balanceStr = obj.getString("balance");
            if(rspCode == 0){
            	if(StringHelper.isNotEmpty(balanceStr)){
            		balance = Double.parseDouble(balanceStr);
            	}
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.SUCCESS.getCode(), rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
//            	String epEngId = baseParams.getEpo().getEpEngId();
//            	String epEngIdTag = epEngId.substring(epEngId.length()-1);
//            	if("0".equals(epEngIdTag)){
//            		balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
//            	}else{
//            		balanceDTO = new BalanceDTO(balance, rspCode, rspMsg,BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
//            	}
            }else{
            	balanceDTO = new BalanceDTO(balance, OrderResultEnum.ERROR.getCode(), rspMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
            }
            
    	 } catch (JSONException e) {  
             e.printStackTrace();  
         } 
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		String paramsStr =  toOrderParams();
		String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpOrderStateIp(),paramsStr);
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
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
            		myStatus = OrderStateEnum.CHARGING.getValue();
            		break;
            	case 1://等待充值
            		myStatus = OrderStateEnum.CHARGING.getValue();
            		break;
            	case 2://正在充值
            		myStatus = OrderStateEnum.CHARGING.getValue();
            		break;
            	case 4://充值成功
            		myStatus = OrderStateEnum.CHARGED.getValue();
            		break;
            	case 8://充值失败
            		myStatus = OrderStateEnum.UNCHARGE.getValue();
            		break;
            	default:
            		break;
            	}
            	if(StringHelper.isEmpty(msg)){
            		switch (status) {
                	case 0://未充值
                		msg = "未冲";
                		break;
                	case 1://等待充值
                		msg = "等待充值";
                		break;
                	case 2://正在充值
                		msg = OrderStateEnum.CHARGING.getDesc();
                		break;
                	case 4://充值成功
                		msg = OrderStateEnum.CHARGED.getDesc();
                		break;
                	case 8://充值失败
                		msg =  "充值失败";
                		break;
                	default:
                		break;
                	}
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
//		ExchangePlatformPo epPo = baseParams.getEpo();
		
		 String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpPurchaseIp(), toParams());
		 ChargeDTO chargeDTO = null;
//		 if("exception".equals(jsonStr)){
//			 chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), "请求失败", null);
//		 }
		 
		 try {  
			 	if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("errcode");
	            
	            String tipMsg = obj.getString("errmsg");
	            
	            JSONObject orderObj = obj.getJSONObject("order");
	            String orderIdApi = orderObj.getString("transaction_id");
	            String number = orderObj.getString("number");
	            String pgSize = orderObj.getString("flowsize");
	            if(StringHelper.isNotEmpty(orderIdApi)){
	            	//用我这边默认的对私账户充值
	            	if(tipCode == 0){
	            		chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), tipMsg, new ChargeOrder(orderIdApi, number, pgSize, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            		chargeDTO.setJsonStr(jsonStr);//设置返回的json串日志信息
	            	}else if(tipCode == 50000 || tipCode == 50005 || tipCode == 50006 || tipCode == 50008 || tipCode == 50012 || tipCode == 50004 || tipCode == 55006){
	            		chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), tipMsg, new ChargeOrder(orderIdApi, number, pgSize, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            		chargeDTO.setJsonStr(jsonStr);//设置返回的json串日志信息
	            	}else{//返回失败,考虑退款
	            		// 最后输出到控制台  
	            		System.out.println(tipCode+"<--->"+tipMsg);  
	            	}
	            }else{
	            	System.out.println(tipCode+"<--->"+tipMsg); 
	            }
	  
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
		 ProductCodePo pc = baseParams.getProductCodePo();
		sbParams.append("username=").append(epPo.getEpUserName());
		sbParams.append("&number=").append(baseParams.getChargeTel());
		sbParams.append("&flowsize=").append(pc.getProductCode());
		sbParams.append("&user_order_id=").append(baseParams.getOrderId());
		sbParams.append("&scope=").append(getScope(pc.getServiceType()));
		
		if(CallBackEnum.POSITIVE.getValue().equals(epPo.getEpCallBack()) && StringHelper.isNotEmpty(epPo.getEpCallBackIp())){
			sbParams.append("&reporturl=").append(epPo.getEpCallBackIp());
		}
		sbParams.append("&sign=").append(sign);
		
		return sbParams.toString();
		
		
//		return "username=" + epPo.getEpUserName() + "&number=" + baseParams.getChargeTel()
//				+ "&flowsize=" + baseParams.getProductCode() + "&user_order_id=" + baseParams.getOrderId()
//				+ "&sign=" + sign;
	}
	/**
	 * @description:设置业务范围
	 * @param serviceType
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月19日 上午9:44:04
	 */
	private int getScope(Integer serviceType){
//		ProductCodePo productPo = productCodeDAO.selectByPrimaryKey(baseParams.getProductCodeId());
		int scope = 0;	//默认全国漫游
//		int serviceType = productPo.getServiceType();
		switch (serviceType) {
		case 1://非全国漫游
			scope = 1;
			break;
		default:
			break;
		}
		return scope;
	}

	
//	@Override
//	public void initSpecialP(Object... objs) {
//		//顺序和加入位置，都是可以随时调的
//		String [] paramsNames = new String [] {"serviceCode","interVersion","callBackWay"};
//		StringBuffer sBuffer = new StringBuffer();
//		for (int i = 0; i < objs.length; i++) {
//			sBuffer.append(paramsNames[i]);
//			sBuffer.append("=");
//			sBuffer.append(objs[i].toString());
//			sBuffer.append("&");
//		}
////		Weizu.baseParams.setAddParams(sBuffer.toString());
//	}
//	@Override
//	public void initSpecialP(String addParams) {
////		Weizu.baseParams.setAddParams(addParams);
//	}
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
	public static String getEpEngId() {
		return epEngId;
	}
	public static void setEpEngId(String epEngId) {
		Weizu.epEngId = epEngId;
	}
}
