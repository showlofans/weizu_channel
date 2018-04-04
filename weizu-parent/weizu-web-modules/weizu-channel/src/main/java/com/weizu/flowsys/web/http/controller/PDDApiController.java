package com.weizu.flowsys.web.http.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.weizu.charge.ChargeTelParams;
import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.AgencyForwardEnum;
import com.weizu.flowsys.operatorPg.enums.TelServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
import com.weizu.flowsys.util.AddressUtils;
import com.weizu.flowsys.web.channel.dao.impl.OperatorPgDao;
import com.weizu.flowsys.web.http.url.PDDApiURL;
import com.weizu.flowsys.web.trade.ao.PDDChargeAO;
import com.weizu.flowsys.web.trade.dao.ChargeLogDao;
import com.weizu.flowsys.web.trade.pojo.ChargeLog;
import com.weizu.flowsys.web.trade.pojo.pdd.PDDChargePo;
import com.weizu.flowsys.web.trade.pojo.pdd.PDDChargeTelPo;
import com.weizu.flowsys.web.trade.pojo.pdd.PddEnums;
import com.weizu.flowsys.web.trade.pojo.pdd.PddPgParams;
import com.weizu.web.foundation.MD5;

/**
 * @description: 拼多多对外接口
 * @projectName:weizu-channel
 * @className:PDDApiController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年4月2日 上午11:15:35
 * @version 1.0
 */
@RequestMapping(value=PDDApiURL.MODOE_NAME)
@Controller
public class PDDApiController {

	@Resource
	private AddressUtils addressUtils;
	@Resource
	private OperatorPgDao operatorPgDao;
	@Resource
	private IChargeFacet chargeImpl;
	@Resource
	private ChargeLogDao chargeLogDao;
	@Resource
	private PDDChargeAO pddChargeAO;
	
	/**
	 * @description: 流量订购
	 * @param key
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月2日 上午11:23:09
	 */
	@ResponseBody
	@RequestMapping(value=PDDApiURL.ORDER_DATA_FLOW,produces = "text/json;charset=UTF-8")
	public String orderDataFlow(@RequestBody String key, HttpServletRequest request){
		System.out.println("接口参数："+key);
		int resultCode = 21;	//未知错误
		PDDChargePo ppdChargePo = null;
		Map<String,Object> chargeMap = new HashMap<String, Object>();
		try {  
            JSONObject obj = JSON.parseObject(key);
            String mctNo = obj.getString("mctNo");//商家编号
            String sign = obj.getString("sign");//拼多多订单号
            String signType = obj.getString("signType");//拼多多订单号
            
            String outOrderNo = obj.getString("outOrderNo");//拼多多订单号
            String proNo = obj.getString("proNo");//流量Id
            Integer amount = obj.getInteger("amount");
//            int amount = 1;
            String mobile = obj.getString("mobile");
            String notifyUrl = obj.getString("notifyUrl");
            Integer resType = obj.getInteger("resType");
            Integer dataFloat = obj.getInteger("dataFloat");
            Integer expireDay = obj.getInteger("expireDay");
            
            String getSign = getSign(mctNo, signType, outOrderNo, proNo, amount, mobile, notifyUrl, resType, dataFloat, expireDay);
            System.out.println("getSign:"+getSign);
            System.out.println("sign:"+sign);
            
            
            if(getSign.equals(sign)){//参数正确，apikey正确
            	if(amount == null){
            		amount = 1;
            	}
            	PddPgParams pddPgParams = new PddPgParams(outOrderNo, proNo, amount, mobile, notifyUrl, resType, dataFloat, expireDay, mctNo, getSign, signType);
            	
            	try {
	       			 String ip = addressUtils.getIp(request);
	       			pddPgParams.setRequestIp(ip);
	       		} catch (Exception e1) {
	       			pddPgParams.setRequestIp("未知ip");
	       			e1.printStackTrace();
	       		}
	       		try {
	       			//System.out.println("传单参数：" + chargeParams.toString());
//	       			charge = chargeImpl.charge(chargeParams);
	       			ppdChargePo = pddChargeAO.chargePg(pddPgParams);
	       		}
	       		catch(TooManyResultsException tmre){
	       			ChargeLog chargeLog = new ChargeLog(JSON.toJSONString(pddPgParams), "查询出多个结果", null, pddPgParams.getMobile(), ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), System.currentTimeMillis(),AgencyForwardEnum.BACKWARD.getValue(),pddPgParams.getRequestIp()+ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc());
	       			chargeLogDao.add(chargeLog);
	       			ppdChargePo = new PDDChargePo(ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc(), null);
	       		}
	       		catch (Exception e) {
	       			ChargeLog chargeLog = new ChargeLog(JSON.toJSONString(pddPgParams), "无返回，有异常", null, pddPgParams.getMobile(), ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), System.currentTimeMillis(),AgencyForwardEnum.BACKWARD.getValue(),pddPgParams.getRequestIp()+ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc());
	       			chargeLogDao.add(chargeLog);
	       			ppdChargePo = new PDDChargePo(ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc(), null);
	       			e.printStackTrace();
	       		}
	       		
            }else{//签名验证失败
            	ppdChargePo = new PDDChargePo(PddEnums.sign_error.getValue(), PddEnums.sign_error.getDesc(), null);
            }
//			System.out.println("code:"+code+"<--------->code_desc:"+code_desc);
            //根据订单号去更新数据库，并返回回调结果
  
        } catch (JSONException e) {  
        	ppdChargePo = new PDDChargePo(PddEnums.exception.getValue(), PddEnums.exception.getDesc(), null);
//        	resultCode = -1;
            e.printStackTrace();  
        }
		String jsonResult = JSON.toJSON(ppdChargePo).toString();
		return jsonResult;
	}
	/**
	 * @description: 快充话费
	 * @param key
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月4日 上午9:58:11
	 */
	@ResponseBody
	@RequestMapping(value=PDDApiURL.order_tel_fee_by_phone,produces = "text/json;charset=UTF-8")
	public String orderTelFeeByPhone(@RequestBody String key, HttpServletRequest request){
		System.out.println("接口参数："+key);
		int resultCode = 21;	//未知错误
		PDDChargeTelPo ppdChargeTelPo = null;
		try {  
			JSONObject obj = JSON.parseObject(key);
			String mctNo = obj.getString("mctNo");//商家编号
			String sign = obj.getString("sign");//拼多多订单号
			String signType = obj.getString("signType");//拼多多订单号
			
			String outOrderNo = obj.getString("outOrderNo");//拼多多订单号
			Integer amount = obj.getInteger("amount");
//            int amount = 1;
			String mobile = obj.getString("mobile");
			String notifyUrl = obj.getString("notifyUrl");
			Integer parPrice = obj.getInteger("parPrice");
			
			String getSign = getSign(mctNo, signType, outOrderNo, parPrice, amount, mobile, notifyUrl);
			System.out.println("getSign:"+getSign);
			System.out.println("sign:"+sign);
			
			Double price = NumberTool.mul(parPrice, 1.0d);
			if(getSign.equals(sign)){//参数正确，apikey正确
				if(amount == null){
					amount = 1;
				}
				ChargeTelParams chargeTelParams = new ChargeTelParams(mobile, sign, TelServiceTypeEnum.PROVINCE.getValue(), TelchargeSpeedEnum.FAST.getValue(), notifyUrl, outOrderNo, price);
				
				try {
					String ip = addressUtils.getIp(request);
					chargeTelParams.setRequestIp(ip);
				} catch (Exception e1) {
					chargeTelParams.setRequestIp("未知ip");
					e1.printStackTrace();
				}
				try {
					//System.out.println("传单参数：" + chargeParams.toString());
					ppdChargeTelPo = pddChargeAO.chargeTel(chargeTelParams);
				}
				catch(TooManyResultsException tmre){
					ChargeLog chargeLog = new ChargeLog(JSON.toJSONString(chargeTelParams), "查询出多个结果", null, mobile, ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), System.currentTimeMillis(),AgencyForwardEnum.BACKWARD.getValue(),chargeTelParams.getRequestIp()+ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc());
					chargeLogDao.add(chargeLog);
					ppdChargeTelPo = new PDDChargeTelPo(PddEnums.exception.getValue(), PddEnums.exception.getDesc(), null);
				}
				catch (Exception e) {
					ChargeLog chargeLog = new ChargeLog(JSON.toJSONString(chargeTelParams), "无返回，有异常", null, mobile, ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), System.currentTimeMillis(),AgencyForwardEnum.BACKWARD.getValue(),chargeTelParams.getRequestIp()+ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc());
					chargeLogDao.add(chargeLog);
					ppdChargeTelPo = new PDDChargeTelPo(PddEnums.exception.getValue(),PddEnums.exception.getDesc(), null);
					e.printStackTrace();
				}
				
			}else{//签名验证失败
				ppdChargeTelPo = new PDDChargeTelPo(PddEnums.sign_error.getValue(), PddEnums.sign_error.getDesc(), null);
			}
//			System.out.println("code:"+code+"<--------->code_desc:"+code_desc);
			//根据订单号去更新数据库，并返回回调结果
			
		} catch (JSONException e) {  
			ppdChargeTelPo = new PDDChargeTelPo(PddEnums.exception.getValue(), PddEnums.exception.getDesc(), null);
//        	resultCode = -1;
			e.printStackTrace();  
		}
		String jsonResult = JSON.toJSON(ppdChargeTelPo).toString();
		return jsonResult;
	}
	/**
	 * @description: 慢充话费充值接口
	 * @param key
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月4日 下午3:38:45
	 */
	@ResponseBody
	@RequestMapping(value=PDDApiURL.ORDER_TEL_FEE,produces = "text/json;charset=UTF-8")
	public String orderTelFee(@RequestBody String key, HttpServletRequest request){
		System.out.println("接口参数："+key);
		int resultCode = 21;	//未知错误
		PDDChargeTelPo ppdChargeTelPo = null;
		try {  
			JSONObject obj = JSON.parseObject(key);
			String mctNo = obj.getString("mctNo");//商家编号
			String sign = obj.getString("sign");//拼多多订单号
			String signType = obj.getString("signType");//拼多多订单号
			
			String outOrderNo = obj.getString("outOrderNo");//拼多多订单号
			Integer amount = obj.getInteger("amount");
//            int amount = 1;
			String mobile = obj.getString("mobile");
			String notifyUrl = obj.getString("notifyUrl");
			Integer parPrice = obj.getInteger("parPrice");
			
			String getSign = getSign(mctNo, signType, outOrderNo, parPrice, amount, mobile, notifyUrl);
			System.out.println("getSign:"+getSign);
			System.out.println("sign:"+sign);
			
			Double price = NumberTool.mul(parPrice, 1.0d);
			if(getSign.equals(sign)){//参数正确，apikey正确
				if(amount == null){
					amount = 1;
				}
				ChargeTelParams chargeTelParams = new ChargeTelParams(mobile, sign, TelServiceTypeEnum.PROVINCE.getValue(), TelchargeSpeedEnum.FAST.getValue(), notifyUrl, outOrderNo, price);
				
				try {
					String ip = addressUtils.getIp(request);
					chargeTelParams.setRequestIp(ip);
				} catch (Exception e1) {
					chargeTelParams.setRequestIp("未知ip");
					e1.printStackTrace();
				}
				try {
					//System.out.println("传单参数：" + chargeParams.toString());
					ppdChargeTelPo = pddChargeAO.chargeTel(chargeTelParams);
				}
				catch(TooManyResultsException tmre){
					ChargeLog chargeLog = new ChargeLog(JSON.toJSONString(chargeTelParams), "查询出多个结果", null, mobile, ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), System.currentTimeMillis(),AgencyForwardEnum.BACKWARD.getValue(),chargeTelParams.getRequestIp()+ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc());
					chargeLogDao.add(chargeLog);
					ppdChargeTelPo = new PDDChargeTelPo(PddEnums.exception.getValue(), PddEnums.exception.getDesc(), null);
				}
				catch (Exception e) {
					ChargeLog chargeLog = new ChargeLog(JSON.toJSONString(chargeTelParams), "无返回，有异常", null, mobile, ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), System.currentTimeMillis(),AgencyForwardEnum.BACKWARD.getValue(),chargeTelParams.getRequestIp()+ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc());
					chargeLogDao.add(chargeLog);
					ppdChargeTelPo = new PDDChargeTelPo(PddEnums.exception.getValue(),PddEnums.exception.getDesc(), null);
					e.printStackTrace();
				}
				
			}else{//签名验证失败
				ppdChargeTelPo = new PDDChargeTelPo(PddEnums.sign_error.getValue(), PddEnums.sign_error.getDesc(), null);
			}
//			System.out.println("code:"+code+"<--------->code_desc:"+code_desc);
			//根据订单号去更新数据库，并返回回调结果
			
		} catch (JSONException e) {  
			ppdChargeTelPo = new PDDChargeTelPo(PddEnums.exception.getValue(), PddEnums.exception.getDesc(), null);
//        	resultCode = -1;
			e.printStackTrace();  
		}
		String jsonResult = JSON.toJSON(ppdChargeTelPo).toString();
		return jsonResult;
	}
	
	/**
	 * @description: 获得流量签名
	 * @param mctNo
	 * @param signType
	 * @param outOrderNo
	 * @param proNo
	 * @param amount
	 * @param mobile
	 * @param notifyUrl
	 * @param resType
	 * @param dataFloat
	 * @param expireDay
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月4日 上午9:54:33
	 */
	private String getSign(String mctNo, String signType, String outOrderNo, String proNo, Integer amount, String mobile, String notifyUrl, 
			Integer resType, Integer dataFloat, Integer expireDay)
	{
		 Map<String, Object> treeMap = new TreeMap<String, Object>();
		 treeMap.put("mctNo", mctNo);
         treeMap.put("outOrderNo", outOrderNo);
         treeMap.put("proNo", proNo);
         if(amount != null){
        	 treeMap.put("amount", amount);
         }
         treeMap.put("mobile", mobile);
         treeMap.put("notifyUrl", notifyUrl);
         if(resType != null){
        	 treeMap.put("resType", resType);
         }
         if(dataFloat != null){
        	 treeMap.put("dataFloat", dataFloat);
         }
         if(expireDay != null){
        	 treeMap.put("expireDay", expireDay);
         }
         
         String params = treeMap.toString();
         params = params.substring(1,params.length()-1);
         String [] paramsA = params.split(",");
         StringBuffer tempStr =  new StringBuffer();
         for (String pa : paramsA) {
        	 tempStr.append(pa.trim()).append("&");
		}
//        String temp = tempStr.toString().substring(0, tempStr.length()-1);
         tempStr.append("signType=").append(signType);
         tempStr.append("&key=").append(PDDApiURL.API_KEY);
         String signStr = tempStr.toString();
         System.out.println("signStr:"+signStr);
         String sign = "";
         try {
 			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
 		} catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
 		}
		return sign;
	}
	/**
	 * @description: 快充话费签名
	 * @param mctNo
	 * @param signType
	 * @param outOrderNo
	 * @param parPrice
	 * @param amount
	 * @param mobile
	 * @param notifyUrl
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年4月4日 上午10:13:11
	 */
	private String getSign(String mctNo, String signType, String outOrderNo, Integer parPrice, Integer amount, String mobile, String notifyUrl)
	{
		Map<String, Object> treeMap = new TreeMap<String, Object>();
		treeMap.put("mctNo", mctNo);
		treeMap.put("outOrderNo", outOrderNo);
		if(parPrice != null){
			treeMap.put("parPrice", parPrice);
		}
		if(amount != null){
			treeMap.put("amount", amount);
		}
		treeMap.put("mobile", mobile);
		treeMap.put("notifyUrl", notifyUrl);
		
		String params = treeMap.toString();
		params = params.substring(1,params.length()-1);
		String [] paramsA = params.split(",");
		StringBuffer tempStr =  new StringBuffer();
		for (String pa : paramsA) {
			tempStr.append(pa.trim()).append("&");
		}
//        String temp = tempStr.toString().substring(0, tempStr.length()-1);
		tempStr.append("signType=").append(signType);
		tempStr.append("&key=").append(PDDApiURL.API_KEY);
		String signStr = tempStr.toString();
		System.out.println("signStr:"+signStr);
		String sign = "";
		try {
			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sign;
	}
	
}
