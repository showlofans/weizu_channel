package com.weizu.flowsys.api.singleton.company;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.weizu.api.util.HttpRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.OrderIn;
import com.weizu.flowsys.api.singleton.ProductDTO;
import com.weizu.flowsys.api.singleton.ProductIn;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
import com.weizu.flowsys.web.channel.dao.impl.ProductCodeDAOImpl;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;

public class Maiyuan implements BaseInterface {

	private static Maiyuan instance = new Maiyuan();  
	private static String epEngId;
	private static BaseP baseParams;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
//	private static String [] specialKeys = new String[]{"clientId","merchant","version"};
	private Maiyuan() {
	}
	
	 public static Maiyuan getInstance(String epEngId,BaseP baseParams) {  
		 Maiyuan.setEpEngId(epEngId);
		 Maiyuan.baseParams=baseParams;
    	return instance;  
    }
	
	
	@Override
	public ChargeDTO charge() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String params = toParams();
		System.out.println(epPo.getEpPurchaseIp()+"?"+params);
		 String jsonStr = HttpRequest.sendGet(epPo.getEpPurchaseIp(), params);
		 ChargeDTO chargeDTO = null;
		 System.out.println(jsonStr);
		 try {  
			 	if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(jsonStr);
	            String taskId = obj.getString("TaskID");
	            String code = obj.getString("Code");
	            String message = obj.getString("Message");
//	            String orderId = obj.getString("out_trade_no");
	          //用我这边默认的对私账户充值
	            if(!taskId.equals(0) && code.equals(0)){
	            	chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), message, new ChargeOrder(taskId, baseParams.getChargeTel(), baseParams.getProductCodePo().getProductCode(), 0));
	            }else{
	            	chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), message, null);
	            }
//	            String epEngId = epPo.getEpEngId();
//	            int billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
//	            if("0".equals(epEngId.substring(epEngId.length()-1))){//英文标识最后一个字符是0表示对私
//	            	billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
//	            }
	            //用我这边默认的对私账户充值
//	            chargeDTO = new ChargeDTO(tipCode, tipMsg, new ChargeOrder(orderIdApi, baseParams.getChargeTel(), baseParams.getProductCode(), billType));
			    // 最后输出到控制台  
	            System.out.println(code+"<--->"+message);  
	  
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		return chargeDTO;
	}

	@Override
	public BalanceDTO getBalance() {
		String resultStr = HttpRequest.sendGet(baseParams.getEpo().getEpBalanceIp(), toBalanceParams());
		BalanceDTO balanceDTO = null;
		try {  
            JSONObject obj = JSON.parseObject(resultStr);
            int tipCode = obj.getIntValue("Code");
    	    String tipMsg = obj.getString("Message");
    	    String balanceStr = obj.getString("Balance");
            double balance = 0.00d;
            if(StringHelper.isNotEmpty(balanceStr)){
            	balance = Double.parseDouble(balanceStr);
            }
            String epEngId = baseParams.getEpo().getEpEngId();
            String epEngIdTag = epEngId.substring(epEngId.length()-1);
            if("0".equals(epEngIdTag)){
            	balanceDTO = new BalanceDTO(balance, tipCode, tipMsg,BillTypeEnum.BUSINESS_INDIVIDUAL.getValue()); 
            }else{
            	balanceDTO = new BalanceDTO(balance, tipCode, tipMsg,BillTypeEnum.CORPORATE_BUSINESS.getValue()); 
            }
		    // 最后输出到控制台  
            System.out.println(tipMsg+"<--->"+tipMsg + ":" + balance);  
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
		
		ProductDTO productDTO = getProduct();
		
		if(productDTO != null){
			  // 最后输出到控制台  
	        System.out.println(productDTO.getRspCode()+"<--->"+productDTO.getRspMsg());
	        
	        List<ProductIn> getList = productDTO.getProductInList();
	        if(getList != null){
	        	for (ProductIn productIn : getList) {
//	        		System.out.println(productIn.getOperator() + "\tname=" + productIn.getName() + "\tprice=" + productIn.getPrice() + "\t" + productIn.getPg());
					System.out.println(productIn.toString());
				}
	        }
		}else{
			System.out.println("没有该类型产品");
		}
		return balanceDTO;
	}

	@Override
	public OrderDTO getOrderState() {
		String paramsStr =  toOrderParams();
		String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpOrderStateIp(),paramsStr);
		OrderDTO orderDTO = null;
		String statusMsg = "";
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
            JSONObject obj = JSON.parseObject(jsonStr);
            System.out.println(jsonStr);
            int tipCode = obj.getIntValue("Code");
    	    String tipMsg = obj.getString("Message");
        	JSONArray Reports = obj.getJSONArray("Reports");
        	if(Reports != null && Reports.size() > 0){
        		for (Object object : Reports) {
        			JSONObject Report = (JSONObject) object;
        			if(Report != null){
        				String taskId = Report.getString("TaskID");
        				String mobile = Report.getString("Mobile");
        				int charge_status = Report.getIntValue("Status");
        				String ReportCode = Report.getString("ReportCode");
        				String ReportTime = Report.getString("ReportTime");
        				System.out.println(ReportCode + "\t上一次回调时间："+ ReportTime);//SUCCESS：	上一次回调时间：2017-12-10 13:56:08
        				String OutTradeNo = Report.getString("OutTradeNo");
//            	Long created_at_time = 0l;
        				int myStatus = OrderStateEnum.UNCHARGE.getValue();
        				switch (charge_status) {
        				case 4://充值成功
        					myStatus = OrderStateEnum.CHARGED.getValue();
        					break;
		//        		case 5://充值失败
		//        			myStatus = OrderStateEnum.UNCHARGE.getValue();
		//        			break;
		        				case 2://正在充值
		        				case 7://待处理
		        					myStatus = OrderStateEnum.CHARGING.getValue();
		        					break;
		//        		case 3://提交失败
		//        			break;
        				default:
        					break;
        				}
//            			if(StringHelper.isEmpty(msg)){
        				switch (charge_status) {
        				case 3://提交失败
        					statusMsg = "提交失败";
        					break;
        				case 7://待处理
        					statusMsg = "上游正在处理";
        					break;
        				case 4://充值成功
        					statusMsg = OrderStateEnum.CHARGED.getDesc();
        					break;
        				case 5://充值失败
        					statusMsg =  "充值失败";
        					break;
        				case 8://正在充值
        					statusMsg = OrderStateEnum.CHARGING.getDesc();
        					break;
        				default:
        					break;
        				}
//            	}
        				OrderIn orderIn = new OrderIn(taskId, OutTradeNo, mobile, null, null, System.currentTimeMillis(), myStatus, statusMsg);
        				//用我这边默认的对私账户充值
        				orderDTO = new OrderDTO(orderIn, tipCode, tipMsg);
        			}
        		}
        		
        	}
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}
	@Override
	public String toParams() {
		
		ExchangePlatformPo platformPo = baseParams.getEpo();
		ProductCodePo pc = baseParams.getProductCodePo();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(platformPo.getEpUserName());
		signBuffer.append("&mobile=");
		signBuffer.append(baseParams.getChargeTel());
		signBuffer.append("&package=");
		signBuffer.append(pc.getProductCode());
		signBuffer.append("&key=");
		signBuffer.append(platformPo.getEpApikey());
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
			System.out.println("充值sign编码参数："+ signBuffer.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramBuffer = new StringBuffer();
		paramBuffer.append(platformPo.getEpOtherParams());
		paramBuffer.append("mobile=");
		paramBuffer.append(baseParams.getChargeTel());
		paramBuffer.append("&action=charge");
		
		paramBuffer.append("&account=");
		paramBuffer.append(platformPo.getEpUserName());
		paramBuffer.append("&");
		paramBuffer.append("&out_trade_no=");
		paramBuffer.append(baseParams.getOrderId());
		paramBuffer.append("&package=");
		paramBuffer.append(pc.getProductCode());
//		Long productId = pc.getId();
//		ProductCodePo productPo = productCodeDAO.selectByPrimaryKey(pc.getId());
		paramBuffer.append("&range=");
		paramBuffer.append(getRange(pc.getServiceType()));
		paramBuffer.append("&packageType=");
		paramBuffer.append(getPackageType(pc));
		paramBuffer.append("&sign=");
		paramBuffer.append(sign);
		
		System.out.println(paramBuffer.toString());
		return paramBuffer.toString();
	}
	
	private int getPackageType(ProductCodePo productPo){
		int packageType = 1;
		Integer circulateWay = productPo.getCirculateWay();
		String pgValidity = productPo.getPgValidity();
		if(ChannelTypeEnum.RED_PACKET.getValue().equals(circulateWay)){
			packageType = 2;
		}
		else if(ChannelTypeEnum.MOBILE.getValue().equals(circulateWay)){
			packageType = 3;
		}
		else if(PgValidityEnum.ONE_DAY_DATA.getValue().equals(pgValidity)){
			packageType = 5;
		}
		else if(PgValidityEnum.THREE_DAY_DATA.getValue().equals(pgValidity)){
			packageType = 6;
		}
		else if(PgValidityEnum.SEVEN_DAY_DATA.getValue().equals(pgValidity)){
			packageType = 7;
		}
		else if(PgValidityEnum.ONE_SEASON_DATA.getValue().equals(pgValidity)){
			packageType = 8;
		}
		else if(PgValidityEnum.HALF_YEAR_DATA.getValue().equals(pgValidity)){
			packageType = 9;
		}
		else if(PgValidityEnum.ONE_YEAR_DATA.getValue().equals(pgValidity)){
			packageType = 10;
		}
		return packageType;//月包
	}
	
	/**
	 * @description: 获得流量范围
	 * @param serviceType
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月15日 下午3:10:36
	 */
	private int getRange(Integer serviceType){
		int range = 0;
		if(ServiceTypeEnum.NATION_WIDE.getValue() == serviceType){
			range = 0;
		}
		else if(ServiceTypeEnum.PROVINCE_ROAMING.getValue() == serviceType){
			range = 2;
		}
		else if(ServiceTypeEnum.PROVINCE.getValue() == serviceType){
			range = 3;
		}else{
			range = 1;		//全国非漫游
		}
		return range;
	}
	
	public String toProductParams(){
		ExchangePlatformPo platformPo = baseParams.getEpo();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(platformPo.getEpUserName());
		signBuffer.append("&type=");
		signBuffer.append(0);
		signBuffer.append("&key=");
		signBuffer.append(platformPo.getEpApikey());
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
			System.out.println("充值sign编码参数："+ signBuffer.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramBuffer = new StringBuffer();
		paramBuffer.append("account=");
		paramBuffer.append(platformPo.getEpUserName());
		paramBuffer.append("&");
		paramBuffer.append(platformPo.getEpOtherParams());//v=1.1
		paramBuffer.append("action=getPackage");
		paramBuffer.append("&range=");
		paramBuffer.append(getRange(ServiceTypeEnum.NATION_WIDE.getValue()));//省漫游
		paramBuffer.append("&type=");
		paramBuffer.append(0);//不指定运营
		paramBuffer.append("&sign=");
		paramBuffer.append(sign);
		
		return paramBuffer.toString();
	}
	
	public ProductDTO getProduct(){
		String paramsStr =  toProductParams();
		//产品编码地址和订购地址一样
		String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpPurchaseIp(),paramsStr);
		ProductDTO productDTO = null;
		List<ProductIn> pcList = new LinkedList<ProductIn>();
		try {  
			if(StringHelper.isEmpty(jsonStr) || "exception".equals(jsonStr)){
		 		return null;
		 	}
			System.out.println(jsonStr);
            JSONObject obj = JSON.parseObject(jsonStr);
           
            int rspCode = obj.getIntValue("Code");
            String rspMsg = obj.getString("Message");
	        JSONArray array = obj.getJSONArray("Packages");
	        if(array != null && array.size() > 0){
	        	for (Object object : array) {
	        		JSONObject jsonObj = (JSONObject)object;
	        		int operator = jsonObj.getIntValue("Type");
	        		String pg = jsonObj.getString("Package");
	        		String name = jsonObj.getString("Name");
	        		Double price = jsonObj.getDoubleValue("Price");
	        		pcList.add(new ProductIn(operator, pg, name, price));
//	        	System.out.println("type=" + name);
	        	}
	        	productDTO = new ProductDTO(rspCode, rspMsg, pcList);
	        }else{
	        	productDTO = new ProductDTO(rspCode, rspMsg, null);
	        }
            
		} catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return productDTO;
	}
//	private String getChargeSign(String epOtherParams){
//		ExchangePlatformPo platformPo = baseParams.getEpo();
//		String account = platformPo.getEpUserName();
////		String otherParams = platformPo.getEpOtherParams(); //按照升序排好的
//		StringBuffer signBuffer = new StringBuffer();
//		signBuffer.append("account=");
//		signBuffer.append(account);
//		signBuffer.append("&");
//		signBuffer.append(epOtherParams);
//		signBuffer.append("mobile=");
//		signBuffer.append(baseParams.getChargeTel());
//		signBuffer.append("&package=");
//		signBuffer.append(baseParams.getProductCode());
//		String sign = "";
//		try {
//			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return sign;
//	}

	@Override
	public String toBalanceParams() {
		ExchangePlatformPo platformPo = baseParams.getEpo();
		String account = platformPo.getEpUserName();
		String apiKey = platformPo.getEpApikey();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(account);
		signBuffer.append("&key=");
		signBuffer.append(apiKey);
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramsBuffer = new StringBuffer();
		
		paramsBuffer.append(platformPo.getEpOtherParams());
		paramsBuffer.append("action=getBalance");
		paramsBuffer.append("&account=");
		paramsBuffer.append(account);
		paramsBuffer.append("&sign=");
		paramsBuffer.append(sign);
		
		return paramsBuffer.toString();
	}

	@Override
	public String toOrderParams() {
		ExchangePlatformPo platformPo = baseParams.getEpo();
		String account = platformPo.getEpUserName();
		String key = platformPo.getEpApikey();
		String sign = "";
		StringBuffer signBuffer = new StringBuffer();
		signBuffer.append("account=");
		signBuffer.append(account);
		signBuffer.append("&key=");
		signBuffer.append(key);
		try {
			sign = MD5.getMd5(signBuffer.toString(), MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer paramsBuffer = new StringBuffer();
		paramsBuffer.append("Account=");
		paramsBuffer.append(account);
		paramsBuffer.append("&");
		paramsBuffer.append(platformPo.getEpOtherParams());//app_key
		paramsBuffer.append("Action=queryReport");//mobile
		if(StringHelper.isNotEmpty(baseParams.getOrderIdApi())){
			paramsBuffer.append("&TaskId=");//trade_no
			paramsBuffer.append(baseParams.getOrderIdApi());//trade_no
		}
		if(baseParams.getOrderId() != null){
			paramsBuffer.append("&OutTradeNo=");//out_trade_no
			paramsBuffer.append(baseParams.getOrderId());//out_trade_no
		}
		paramsBuffer.append("&SendTime=");//SendTime
		paramsBuffer.append(baseParams.getOtherParams());//SendTime
		paramsBuffer.append("&Sign=");//sign
		paramsBuffer.append(sign);//sign
		
		
		return paramsBuffer.toString();
	}

	public static String getEpEngId() {
		return epEngId;
	}

	public static void setEpEngId(String epEngId) {
		Maiyuan.epEngId = epEngId;
	}
	
}
