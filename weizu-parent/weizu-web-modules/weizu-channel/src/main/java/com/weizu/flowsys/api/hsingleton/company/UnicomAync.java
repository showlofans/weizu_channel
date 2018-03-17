package com.weizu.flowsys.api.hsingleton.company;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.dom4j.Document;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.api.hsingleton.TelBaseInterface;
import com.weizu.flowsys.api.hsingleton.TelBaseP;
import com.weizu.flowsys.api.hsingleton.TelOrderStateDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.trade.WXPayUtil;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.http.HttpRequest;

//@Service(value="unicomAync")
/**
 * @description: 连城连话费充值接口
 * @projectName:weizu-channel
 * @className:UnicomAync.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年3月17日 下午2:40:30
 * @version 1.0
 */
public class UnicomAync implements TelBaseInterface{

	private static UnicomAync instance = new UnicomAync();  
	
	private static TelBaseP telBaseP;  
	
	private UnicomAync() {
	}
	
	 public static UnicomAync getInstance(TelBaseP telBaseP) {  
		UnicomAync.telBaseP=telBaseP;
    	return instance;  
    }
	 public static UnicomAync getInstance() {  
		 return instance;  
	 }
	
	@Override
	public ChargeDTO chargeTel(TelBaseP baseP) {
		String telParams = toTelParams();
		String xmlStr = HttpRequest.sendGet(baseP.getEpo().getEpPurchaseIp(), telParams);
		Map<String, Object> resultMap = WXPayUtil.readStringXmlOut(xmlStr);
		String codeStr = resultMap.get("code").toString();
		String desc = resultMap.get("desc").toString();
		ChargeDTO chargeDTO = null;
		if(codeStr.equals("00")){
			String bizOrderId = resultMap.get("bizOrderId").toString();
			chargeDTO = new ChargeDTO(OrderResultEnum.SUCCESS.getCode(), desc, new ChargeOrder(bizOrderId, baseP.getChargeTel(), baseP.getTelProductPo().getTelCode(), 0));
		}else{
			chargeDTO = new ChargeDTO(OrderResultEnum.ERROR.getCode(), desc, new ChargeOrder(baseP.getOrderId().toString(), baseP.getChargeTel(), baseP.getTelProductPo().getTelCode(), 0));
		}
		chargeDTO.setJsonStr(JSON.toJSONString(resultMap));
		return chargeDTO;
	}

	@Override
	public TelOrderStateDTO getTelOrderState(TelBaseP baseP) {
		String params = toTelOrderParams();
		String xmlStr = HttpRequest.sendGet(baseP.getEpo().getEpOrderStateIp(), params);
		
		return readOrderXmlStr(xmlStr);
	}

	private TelOrderStateDTO readOrderXmlStr(String xmlStr){
		 Document doc = null;
		 
//		try {
//			// 将字符串转为XML
//			doc = DocumentHelper.parseText(xmlStr);
//			// 获取根节点
//			Element rootElt = doc.getRootElement();
//			Iterator iter = rootElt.elementIterator("head");
//			iter.
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return null;
	}
	
	@Override
	public String toTelParams() {
		ExchangePlatformPo epPo = telBaseP.getEpo();
		String epOtherP = epPo.getEpOtherParams();
		StringBuffer signBuff = new StringBuffer();
		String dtCreate = DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss");
		signBuff.append(dtCreate);
		String itemId = telBaseP.getTelProductPo().getTelCode();
		signBuff.append(itemId);
		String serialno = telBaseP.getOrderId().toString();
		signBuff.append(serialno);
		String uid = telBaseP.getChargeTel();
		signBuff.append(uid);
		String userId = epOtherP.substring(epOtherP.indexOf("=")+1,epOtherP.indexOf("&"));
		signBuff.append(userId);
		signBuff.append(epPo.getEpApikey());
		String sign = null;
		System.out.println("签名串："+signBuff.toString());
		try {
			sign = MD5.getMd5(signBuff.toString(),MD5.LOWERCASE,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		StringBuffer paramsBuff = new StringBuffer();
		paramsBuff.append(epOtherP);//userId
		paramsBuff.append("itemId="+itemId);//itemId
		paramsBuff.append("&uid="+uid);//uid
		paramsBuff.append("&serialno="+serialno);//serialno
		paramsBuff.append("&dtCreate="+dtCreate);//dtCreate
		paramsBuff.append("&sign="+sign);//sign
		
		return paramsBuff.toString();
	}
	
	private String getChargeSign(TelBaseP telBaseP){
//		telBaseP
		return null;
	}

	@Override
	public String toTelOrderParams() {
		ExchangePlatformPo epPo = telBaseP.getEpo();
		String epOtherP = epPo.getEpOtherParams();
		String userId = epOtherP.substring(epOtherP.indexOf("=")+1,epOtherP.indexOf("&"));
		String serialno = telBaseP.getOrderId().toString();//流水号
		
		String signStr = serialno + userId + epPo.getEpApikey();
		String sign = null;
		try {
			sign = MD5.getMd5(signStr,MD5.LOWERCASE,null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		StringBuffer paramsBuff = new StringBuffer();
		paramsBuff.append("serialno="+serialno);
		paramsBuff.append("&sign="+sign);
		paramsBuff.append("&userId="+userId);
		return paramsBuff.toString();
	}

	public static TelBaseP getTelBaseP() {
		return telBaseP;
	}

	public static void setTelBaseP(TelBaseP telBaseP) {
		UnicomAync.telBaseP = telBaseP;
	}
}
