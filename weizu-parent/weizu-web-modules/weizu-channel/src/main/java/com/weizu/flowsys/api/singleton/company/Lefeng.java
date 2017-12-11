package com.weizu.flowsys.api.singleton.company;

import java.util.Date;

import javax.annotation.Resource;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.springframework.stereotype.Service;
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
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.SHA1;
import com.weizu.web.foundation.String.StringHelper;

@Service
public class Lefeng implements BaseInterface {

	@Resource
	private PurchaseDao purchaseDAO;
	
	private static Lefeng instance = new Lefeng();  
	private static String epEngId;
	private static BaseP baseParams;
	private Lefeng() {
	}
	
	 public static Lefeng getInstance(String epEngId,BaseP baseParams) {  
		 Lefeng.setEpEngId(epEngId);
		 Lefeng.baseParams=baseParams;
    	return instance;  
    }
	 public static String getEpEngId() {
		return epEngId;
	}

	public static void setEpEngId(String epEngId) {
		Lefeng.epEngId = epEngId;
	}
	
	private int getScope(Integer serviceType) {
		int scope = 0;	//全国
		switch (serviceType) {
		case 0:		//全国
			scope = 0;
			break;
		case 1:		//省内
			scope = 1;
			break;
		case 2:		//省漫游 
			scope = 2;
			break;

		default:
			break;
		}
		return scope;
	}
	
	private String getSign(ExchangePlatformPo epPo,Long currentTime){
		
		StringBuffer sbStr = new StringBuffer();
		sbStr.append("userName").append(epPo.getEpUserName());
		sbStr.append("mobile").append(baseParams.getChargeTel());
		sbStr.append("orderMeal").append(baseParams.getProductCode());
		sbStr.append("timeStamp").append(currentTime);
		sbStr.append("key").append(epPo.getEpApikey());
		String sign = SHA1.getSha1(sbStr.toString(), MD5.LOWERCASE);
		return sign;
	}
	
	private String getOrderSign(ExchangePlatformPo epPo){
		
		StringBuffer sbStr = new StringBuffer();
		sbStr.append("userName").append(epPo.getEpUserName());
		sbStr.append("msgId").append(baseParams.getOrderId());
		sbStr.append("key").append(epPo.getEpApikey());
		String sign = SHA1.getSha1(sbStr.toString(), MD5.LOWERCASE);
		return sign;
	}
	
	
	@Override
	public ChargeDTO charge() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		String params = toParams();
		System.out.println(epPo.getEpPurchaseIp() + params);
		 String jsonStr = HttpRequest.sendPost(epPo.getEpPurchaseIp(), params);
		 ChargeDTO chargeDTO = null;
		 try {  
			 	if(StringHelper.isEmpty(jsonStr)){
			 		return null;
			 	}
	            JSONObject obj = JSON.parseObject(jsonStr);
	            
//	            int tipCode = obj.getIntValue("code");
	            String tipCode = obj.getString("code");
	            String tipMsg = obj.getString("msg");
	            String reqNo = obj.getString("reqNo");
	            String epEngId = epPo.getEpEngId();
	            int billType = BillTypeEnum.CORPORATE_BUSINESS.getValue();
	            if("0".equals(epEngId.substring(epEngId.length()-1))){//英文标识最后一个字符是0表示对私
	            	billType = BillTypeEnum.BUSINESS_INDIVIDUAL.getValue();
	            }
	            int rspCode = 0;
	            if("0000".equals(tipCode)){
	            	rspCode = OrderResultEnum.SUCCESS.getCode();
	            	//用我这边默认的对私账户充值
	            	chargeDTO = new ChargeDTO(rspCode, tipMsg, new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCode(), billType));
	            }else{
	            	rspCode = OrderResultEnum.ERROR.getCode();
	            	chargeDTO = new ChargeDTO(rspCode, tipMsg, new ChargeOrder(null, baseParams.getChargeTel(), baseParams.getProductCode(), billType));
	            	// 最后输出到控制台  
	            	System.out.println(tipCode+"<--->"+tipMsg);  
	            }
	        } catch (JSONException e) {  
	            e.printStackTrace();  
	        }  
		return chargeDTO;
	}

	@Override
	public BalanceDTO getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO getOrderState() {
		String paramsStr =  toOrderParams();
		String jsonStr = HttpRequest.sendGet(baseParams.getEpo().getEpOrderStateIp(),paramsStr);
		OrderDTO orderDTO = null;
		try {  
			if(StringHelper.isEmpty(jsonStr)){
		 		return null;
		 	}
            JSONObject obj = JSON.parseObject(jsonStr);
            String rspCode = obj.getString("code");
            String rspMsg = obj.getString("msg");
//            System.out.println(rspCode);
            if("0000".equals(rspCode)){//订单不存在
            	String msgId = obj.getString("msgId");
            	String reqNo = obj.getString("reqNo");
            	int status = obj.getIntValue("status");
            	String fail_describe = obj.getString("fail_describe");
            	String salePrice = obj.getString("salePrice");
            	String finishTime = obj.getString("finishTime");
            	
            	int myStatus = OrderStateEnum.UNCHARGE.getValue();
            	switch (status) {
            	case 0://充值成功
            		myStatus = OrderStateEnum.CHARGED.getValue();
            		break;
            	case 1://订购中
            		myStatus = OrderStateEnum.CHARGING.getValue();
            		break;
            	case 45://充值不成功
            		myStatus = OrderStateEnum.UNCHARGE.getValue();
            		break;
            	default:
            		break;
            	}
            	Long orderId = Long.parseLong(msgId);
            	Long created_at = Long.parseLong(finishTime);
            	PurchasePo purPo = purchaseDAO.get(orderId);
            	OrderIn orderIn = new OrderIn(reqNo, msgId, null, null, salePrice, created_at, myStatus, fail_describe);
            	
            	orderDTO = new OrderDTO(orderIn, OrderResultEnum.SUCCESS.getCode(), rspMsg);
            }else{
            	System.out.println("查询失败");
            	orderDTO = new OrderDTO(null, OrderResultEnum.ERROR.getCode(), rspMsg);
            }
  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } 
		return orderDTO;
	}

	@Override
	public String toParams() {
		ExchangePlatformPo epPo = baseParams.getEpo();
		JSONObject param = new JSONObject();
		Long timeStamp = System.currentTimeMillis()/1000;		//对外统一的时间戳
//		Long.toString(i)
		
		param.put("userName", epPo.getEpUserName());
		param.put("mobile", baseParams.getChargeTel());
		param.put("orderMeal", baseParams.getProductCode());	//订购产品id
		param.put("orderTime", "1");						//固定值1
		param.put("msgId", Long.toString(baseParams.getOrderId()));	//我的订单号
		param.put("range", Integer.toString(getScope(baseParams.getServiceType())) );
		param.put("sign", getSign(epPo, timeStamp));
		param.put("timeStamp",Long.toString(timeStamp) );
//		boolean callB = epPo.getEpCallBack().equals(CallBackEnum.POSITIVE.getValue()) && StringHelper.isNotEmpty(epPo.getEpCallBackIp());
//		if(callB){
//			param.put("notifyUrl", epPo.getEpCallBackIp());
//		}
		System.out.println(param.toString());
		return param.toString();
	}

	

	@Override
	public String toBalanceParams() {
		String userName = baseParams.getEpo().getEpUserName();
		return userName;
	}

	@Override
	public String toOrderParams() {
		JSONObject param = new JSONObject();
		ExchangePlatformPo epPo = baseParams.getEpo();
		param.put("userName", baseParams.getEpo().getEpUserName());
		param.put("msgId", baseParams.getOrderId());
		param.put("sign", getOrderSign(epPo));
		return param.toString();
	}
}
