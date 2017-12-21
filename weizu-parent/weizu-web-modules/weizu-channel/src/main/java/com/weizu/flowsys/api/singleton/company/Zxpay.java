package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.StringUtil2;
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
public class Zxpay implements BaseInterface {

	private static Zxpay instance = new Zxpay();  
	private static String epEngId;
	private static BaseP baseParams;
//	private static String sign;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
	
	
    private Zxpay (){}  
    public static Zxpay getInstance(String epEngId,BaseP baseParams) {  
    	Zxpay.setEpEngId(epEngId);
//    	baseParams = baseParams;
    	Zxpay.baseParams=baseParams;
    	ExchangePlatformPo epPo = baseParams.getEpo();
    	//得到所有的参数数组
//    	String [] firstArray = StringUtil2.getArrayByCharSeq(epPo.getEpOtherParams());
//    	String [] otherArray = new String[]{"request_time"};
//    	String[] arr = new String[firstArray.length+otherArray.length];
//    	System.arraycopy(firstArray, 0, arr, 0, firstArray.length);
//    	System.arraycopy(otherArray, 0, arr, firstArray.length, otherArray.length);
//    	Arrays.sort(arr);//排序
//    	for (String key : arr) {
//			
//		}
//    	
//    	Map<String,Object> map = new TreeMap<String, Object>();
//    	map.put("", value)
    	
//    	for (String key : map.keySet()) {
//			String value = map.get(key).toString();
//		}
    	
    	
//    	try {
//    		Zxpay.sign = MD5.getMd5("username="+epPo.getEpUserName()+"&apikey="+epPo.getEpApikey(),MD5.LOWERCASE,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
    	return instance;  
    }
    
//    public static ChargeDTO charge(){
//    	String chargeTel = Weizu.baseParams.getChargeTel();
//    	System.out.println(chargeTel);
//    	return null;
//    }
    @Override
	public BalanceDTO getBalance() {
    	String params = toBalanceParams();
    	String jsonStr = HttpRequest.sendPost(baseParams.getEpo().getEpBalanceIp(), params);
    	System.out.println(jsonStr);
    	BalanceDTO balanceDTO = null;
    	try {  
            JSONObject obj = JSON.parseObject(jsonStr);
            int rspCode = obj.getIntValue("code");
            String rspMsg = obj.getString("message");
            
            JSONObject dataObj = obj.getJSONObject("data");
            String balance = dataObj.getString("balance").toString();
            String flow_balance = dataObj.getString("flow_balance");
            System.out.println(rspCode+"<--->"+rspMsg);
            StringBuffer sbBalanceMsg = new StringBuffer();
            sbBalanceMsg.append("balance=");
            sbBalanceMsg.append(balance);
            sbBalanceMsg.append(",");
            sbBalanceMsg.append("flow_balance=");
            sbBalanceMsg.append(flow_balance);
            
//            String epEngId = baseParams.getEpo().getEpEngId();
//            String epEngIdTag = epEngId.substring(epEngId.length()-1);
//            if("0".equals(epEngIdTag)){
            	balanceDTO = new BalanceDTO(Double.parseDouble(flow_balance), rspCode, sbBalanceMsg.toString(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
//            }else{
//            	balanceDTO = new BalanceDTO(balance, rspCode, sbBalanceMsg.toString(),BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
//            }
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
		String params = toParams();
		System.out.println("参数：" + params);
		 String jsonStr = HttpRequest.sendPost(baseParams.getEpo().getEpPurchaseIp(), params);
		 ChargeDTO chargeDTO = null;
		 
		 try {  
			 	if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
			 		return null;
			 	}
			 	System.out.println(jsonStr);
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("code");
	            
	            String tipMsg = obj.getString("message");
	            
	            JSONObject orderObj = obj.getJSONObject("data");
	            String orderIdApi = orderObj.getString("up_order_no");//
	            //用我这边默认的对私账户充值
	            if(tipCode == 2){
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            }else if(tipCode == 50000 || tipCode == 50005 || tipCode == 50006 || tipCode == 50008 || tipCode == 50012 || tipCode == 50004 || tipCode == 55006){
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            }else{//返回失败,考虑退款
	            	// 最后输出到控制台  
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
		 ProductCodePo pc = baseParams.getProductCodePo();
		
		ExchangePlatformPo epPo = baseParams.getEpo();
		Map<String,Object> map = StringUtil2.getTreeMapByStr(epPo.getEpOtherParams());
		map.put("request_time", DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss"));
		map.put("client_order_no", baseParams.getOrderId());
		map.put("product_type", getScope(pc.getServiceType()));//产品类型,业务类型
		map.put("phone_no", baseParams.getChargeTel());//
		map.put("cp", getOperator(pc.getOperatorType()));//
		map.put("city_code", "");//
		map.put("recharge_amount", pc.getPgSize());//包体大小(以M为单位)
		map.put("recharge_desc", "测试");//支付方式：0: 预存金中扣
		if(CallBackEnum.POSITIVE.getValue().equals(epPo.getEpCallBack()) && StringHelper.isNotEmpty(epPo.getEpCallBackIp())){
			map.put("notify_url", epPo.getEpCallBackIp());//支付方式：0: 预存金中扣
		}else{
			map.put("notify_url", "");//支付方式：0: 预存金中扣
		}
		initSign(map, epPo.getEpApikey());
		
		return JSON.toJSONString(map);
		
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
		boolean nation = ServiceTypeEnum.NATION_WIDE.getValue() == serviceType || ServiceTypeEnum.PROVINCE_ROAMING.getValue() == serviceType;
//		boolean province = ServiceTypeEnum.PROVINCE.getValue() == serviceType;
		int scope = 5;	//默认省内流量
		if(nation){//国内流量
			scope = 4;
		}
//		ProductCodePo productPo = productCodeDAO.selectByPrimaryKey(baseParams.getProductCodeId());
//		int scope = 0;	//默认全国漫游
////		int serviceType = productPo.getServiceType();
//		switch (serviceType) {
//		case 1://非全国漫游
//			scope = 1;
//			break;
//		default:
//			break;
//		}
		return scope;
	}
	
	/**
	 * @description: 设置运营商
	 * @param operatorType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月21日 下午5:10:32
	 */
	private String getOperator(int operatorType){
//		boolean isMobile = OperatorTypeEnum.MOBILE.getValue().equals(operatorType);
		String operator = "01";//默认移动
		boolean isLink = OperatorTypeEnum.LINK.getValue().equals(operatorType);
		boolean isTel= OperatorTypeEnum.TELECOME.getValue().equals(operatorType);
		if(isLink){//联通
			operator = "03";
		}else if(isTel){//电信
			operator = "02";
		}
		return operator;
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
		Map<String,Object> map = StringUtil2.getTreeMapByStr(epPo.getEpOtherParams());
		map.put("request_time", DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss"));
		initSign(map, epPo.getEpApikey());
		
		return JSON.toJSONString(map);
	}
	@Override
	public String toOrderParams() {
		StringBuffer sbParams = new StringBuffer();
		ExchangePlatformPo epPo = baseParams.getEpo();
		Map<String,Object> map = StringUtil2.getTreeMapByStr(epPo.getEpOtherParams());
//		sbParams.append("&sign=").append(getSign(map, epPo.getEpApikey()));
		
		
		
		sbParams.append("username=").append(epPo.getEpUserName());
		sbParams.append("&order_id=").append(baseParams.getOrderIdApi());		//通过api订单号去查，就是String类型
		return sbParams.toString();
	}
	
	private void initSign(Map<String,Object> map,String secret_key) {
		StringBuffer mdStr = new StringBuffer();
		for (String key : map.keySet()) {
			mdStr.append(key);
			mdStr.append(map.get(key) == null?"":map.get(key).toString());
		}
		mdStr.append(secret_key);
		System.out.println("签名参数："+ mdStr.toString());
		String sign = null;
		try {
			sign = MD5.getMd5(mdStr.toString(),MD5.LOWERCASE,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		return sign;
		map.put("sign", sign);
	}
	public static String getEpEngId() {
		return epEngId;
	}
	public static void setEpEngId(String epEngId) {
		Zxpay.epEngId = epEngId;
	}
}
