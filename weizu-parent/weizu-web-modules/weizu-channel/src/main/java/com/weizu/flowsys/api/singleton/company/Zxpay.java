package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.util.NumberUtils;
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
import com.weizu.flowsys.core.util.NumberTool;
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
//    	ExchangePlatformPo epPo = baseParams.getEpo();
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
		//System.out.println("查询参数："+paramsStr);
		String jsonStr = HttpRequest.sendPost(baseParams.getEpo().getEpOrderStateIp(),paramsStr);
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
			System.out.println("返回值:"+jsonStr);
            JSONObject obj = JSON.parseObject(jsonStr);
            int rspCode = obj.getIntValue("code");
            String rspMsg = obj.getString("message");
//            System.out.println(rspCode);
            int myStatus = OrderStateEnum.CHARGING.getValue();
            if(rspCode == 626){//未查询到订单状态
            	String order_time = baseParams.getOtherParams();
            	String msg = "正在充值";
            	if(StringHelper.isEmpty(order_time)){//传值不正确
            		msg = "提交参数有误，或者正在充值";
            	}else{//传值正确
            		Long orderTime = DateUtil.strToDate(order_time, "yyyyMMddHHmmss").getTime();
            		int minutes = (int) ((System.currentTimeMillis() - orderTime) / (1000*60));
            		if(minutes > 10){//
            			myStatus = OrderStateEnum.UNCHARGE.getValue();
            			msg = rspMsg;
            		}else{
            			msg = "提交参数有误，或者正在充值（充值未超时）";
//            			System.out.println("提交参数有误，或者正在充值（充值未超时）");
            		}
            	}
            	System.out.println("626未查到结果："+msg);
            	OrderIn orderId = new OrderIn(baseParams.getOrderIdApi(), baseParams.getOrderId().toString(), null, null, null, System.currentTimeMillis(), myStatus, msg);
            	//用我这边默认的对私账户充值
            	orderDTO = new OrderDTO(orderId, rspCode, rspMsg);
            }else if(rspCode == 2){
            	JSONObject orderObj = obj.getJSONObject("data");
            	String orderIdApi = orderObj.getString("up_order_no");
            	String user_order_id = orderObj.getString("client_order_no");
            	
            	String number = orderObj.getString("phone_no");
            	String charge_fee = orderObj.getString("deduction_amount");//以分为单位
            	double chargeValue = NumberTool.div(Double.parseDouble(charge_fee), 100); //扣款金额以元为单位 
            	int status = orderObj.getIntValue("recharge_status");
            	String elecardID = orderObj.getString("elecardID");//运营商流水号
            	
            	String product_type = orderObj.getString("product_type");//产品类型
            	String msg = orderObj.getString("desc");
            	System.out.println("其他结果参数：desc="+msg+",product_type="+product_type+"扣款金额（元）："+chargeValue+"运营商流水号："+elecardID);
            	switch (status) {
            	case 1://充值中
            		myStatus = OrderStateEnum.CHARGING.getValue();
            		break;
            	case 2://充值成功
            		myStatus = OrderStateEnum.CHARGED.getValue();
            		break;
            	case 6://充值失败
            		myStatus = OrderStateEnum.UNCHARGE.getValue();
            		break;
            	default:
            		break;
            	}
            	if(StringHelper.isEmpty(msg)){
            		switch (status) {
                	case 1://正在充值
                		msg = OrderStateEnum.CHARGING.getDesc();
                		break;
                	case 2://充值成功
                		msg = OrderStateEnum.CHARGED.getDesc();
                		break;
                	case 6://充值失败
                		msg = OrderStateEnum.UNCHARGE.getDesc();
                		break;
                	default:
                		break;
                	}
            	}
            	OrderIn orderId = new OrderIn(orderIdApi, user_order_id, number, null, charge_fee, System.currentTimeMillis(), myStatus, msg);
//            	orderId.setCreated_at_time(created_at_time);
            	//用我这边默认的对私账户充值
            	orderDTO = new OrderDTO(orderId, rspCode, rspMsg);
            }else{//不做失败处理：不做处理
            	System.out.print("查询参数有误：");
            	System.out.println(rspCode+"<--->"+rspMsg);
//            	String errorMsg = "";
//            	switch (rspCode) {
//				case 603:
//					errorMsg = "请求数据不正确或查询异常";
//					break;
//				case 606:
//					errorMsg = "数据签名错误";
//					break;
//				case 751:
//					errorMsg = "IP地址限制";
//					break;
//
//				default:
//					errorMsg = "其他返回码" + rspCode;
//					break;
//				}
//            	System.out.println("查询状态错误信息：" +errorMsg);
            }
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}
	@Override
	public ChargeDTO charge() {
		String params = toParams();
//		System.out.println("参数：" + params);
		 String jsonStr = HttpRequest.sendPost(baseParams.getEpo().getEpPurchaseIp(), params);
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
			 		return null;
			 	}
			 	System.out.println("返回的json结果串："+ jsonStr);
	            JSONObject obj = JSON.parseObject(jsonStr);
	            int tipCode = obj.getIntValue("code");
	            String tipMsg = obj.getString("message");
	            if(tipCode == 2){
	            	JSONObject orderObj = obj.getJSONObject("data");
	            	String orderIdApi = orderObj.getString("up_order_no");//
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
	            } else{//返回失败,考虑退款
	            	// 最后输出到控制台  
	            	if(tipCode == 625){//充值失败,不需直接返失败
	            		System.out.println("返回码描述信息codeMsg:重复流水号");
//	            		System.out.println("充值未直接返回失败："+ tipMsg);
		            }else{//直接返回失败
		            	System.out.println(tipCode+"<--->"+tipMsg);  
		            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), tipMsg, new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCodePo().getPgSize().toString(), BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()));
		            }
//	            	String codeMsg = "";
//	            	//用我这边默认的对私账户充值
//		            switch (tipCode) {
//					case 600:
//						codeMsg = "商户禁用,接口已关闭";
//						break;
//					case 602:
//						codeMsg = "订单提交失败，未充值";
//						break;
//					case 603:
//						codeMsg = "请求数据格式错误";
//						break;
//					case 606:
//						codeMsg = "数据签名错误";
//						break;
//					case 622:
//						codeMsg = "商户不存在";
//						break;
//					case 623:
//						codeMsg = "通道维护";
//						break;
//					case 624:
//						codeMsg = "产品未配置";
//						break;
//					case 615:
//						codeMsg = "号码归属地未配置";
//						break;
//					case 625:
//						codeMsg = "重复流水号";
//						orderState = OrderStateEnum.CHARGING.getValue();//不做失败处理
//						break;
//					case 637:
//						codeMsg = "流量充值未配置";
//						break;
//					case 751:
//						codeMsg = "IP地址限制";
//						break;
//					default:
//						break;
//					}
//		            System.out.println("返回码描述信息codeMsg:"+codeMsg);
	            }
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
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
		map.put("client_order_no", baseParams.getOrderId().toString());
		map.put("product_type", getScope(pc.getServiceType()));//产品类型,业务类型
		map.put("phone_no", baseParams.getChargeTel());//
		map.put("cp", getOperator(pc.getOperatorType()));//获得运营商类型
		map.put("city_code", "");//
		map.put("recharge_amount", pc.getPgSize());//包体大小(以M为单位)
		map.put("recharge_desc", "测试");//充值描述
		map.put("recharge_type", 0);//支付方式：0: 预存金中扣
		if(StringHelper.isNotEmpty(epPo.getEpCallBackIp())){//必须要传回调地址:CallBackEnum.POSITIVE.getValue().equals(epPo.getEpCallBack())
			map.put("notify_url", epPo.getEpCallBackIp());//回调
		}else{
			map.put("notify_url", "");//支付方式：0: 预存金中扣
		}
		initSign(map, epPo.getEpApikey());
		
		return JSON.toJSONString(map);
	}
	/**
	 * @description:设置业务范围
	 * @param serviceType
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月19日 上午9:44:04
	 */
	private int getScope(Integer serviceType){
		int scope = 5;	//默认省内流量
		boolean nation = ServiceTypeEnum.NATION_WIDE.getValue() == serviceType || ServiceTypeEnum.PROVINCE_ROAMING.getValue() == serviceType;
		if(nation){//国内流量（含省网中的省漫游资源）
			scope = 4;
		}
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
		ExchangePlatformPo epPo = baseParams.getEpo();
		Map<String,Object> map = StringUtil2.getTreeMapByStr(epPo.getEpOtherParams());
		map.put("request_time", DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss"));//查询时间
		map.put("client_order_no", baseParams.getOrderId().toString());
		//订单生成时间
		//按照传过来的订单提交时间格式，去解析真正的时间
		Long time = DateUtil.strToDate(baseParams.getOtherParams(), "yyyy-MM-dd").getTime();
		map.put("order_time", DateUtil.formatPramm(time, "yyyyMMddHHmmss"));
		initSign(map, epPo.getEpApikey());
		return JSON.toJSONString(map);
	}
	
	private void initSign(Map<String,Object> map,String secret_key) {
		StringBuffer mdStr = new StringBuffer();
		for (String key : map.keySet()) {
			mdStr.append(key);
			mdStr.append(map.get(key) == null?"":map.get(key).toString());
		}
		mdStr.append(secret_key);
		//System.out.println("签名参数："+ mdStr.toString());
		String sign = null;
		try {
			sign = MD5.getMd5(mdStr.toString(),MD5.LOWERCASE,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		map.put("sign", sign);
	}
	public static String getEpEngId() {
		return epEngId;
	}
	public static void setEpEngId(String epEngId) {
		Zxpay.epEngId = epEngId;
	}
}
