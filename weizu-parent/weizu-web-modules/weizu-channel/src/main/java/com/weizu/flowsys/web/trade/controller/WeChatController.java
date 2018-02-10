package com.weizu.flowsys.web.trade.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.EpEncodeTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgSizeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.WxPaySendPost;
import com.weizu.flowsys.util.apiEncode.Encrypt;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.OneCodePo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.flowsys.web.trade.PurchaseUtil;
import com.weizu.flowsys.web.trade.WXPayUtil;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.ao.WXPayAO;
import com.weizu.flowsys.web.trade.constant.WXPayConfig;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.PurchasePo;
import com.weizu.flowsys.web.trade.pojo.RatePgPo;
import com.weizu.flowsys.web.trade.url.WeChatURL;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.String.StringHelper;
import com.weizu.web.foundation.hash.Hash;
import com.weizu.web.foundation.http.HttpRequest;

/**
 * @description: 微信小程序数据接口
 * @projectName:weizu-channel
 * @className:WeChatController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月15日 下午2:42:32
 * @version 1.0
 */
@Controller
@RequestMapping(value=WeChatURL.MODEL_NAME)
public class WeChatController {
	
//	@Resource
//	private OperatorPgAO operatorPgAO;
	@Resource
	private RateDiscountAO rateDiscountAO;
	
	@Resource
	private ChargeAccountAo chargeAccountAo;
	@Resource
	private WXPayAO wXPayAO;
	
	@Resource
	private PurchaseDao purchaseDAO;
	@Resource
	private PurchaseAO purchaseAO;
	@Resource
	private ExchangePlatformDaoInterface exchangePlatformDao;
	
	@Resource
	private ProductCodeAO productCodeAO;
	
	public static final int PICKEROTHERSIZE = 9;
	
//	@ResponseBody
	@RequestMapping(value=WeChatURL.INIT_FIRST_PAGE)
	public void initFirstPage(HttpServletResponse response){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("serviceTypeEnums", ServiceTypeEnum.toList());
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(JSON.toJSONString(resultMap));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * @description: 根据业务类型和归属地获得包体
	 * @param response
	 * @param ccpp
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月18日 下午12:02:18
	 */
	@RequestMapping(value=WeChatURL.GETPG_FOR_PURCHASE)
	public void getPgForPurchase(HttpServletResponse response, ChargeChannelParamsPo ccpp){
		//参数：serviceType和carrier
		String carrier = ccpp.getCarrier();
		if(StringHelper.isNotEmpty(carrier)){
				ChargeAccountPo accountPo = chargeAccountAo.getAccountByAgencyId(231, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
				List<RatePgPo> ratePgList = rateDiscountAO.getRatePgForCharge(ccpp, accountPo.getId(), false);
				Map<String,Object> resultMap = new HashMap<String,Object>();
				int ratePgSize = ratePgList.size();
			try {
				if(ratePgList != null){
					if(ratePgSize > PICKEROTHERSIZE){
						List<RatePgPo> rateShowList = ratePgList.subList(0, PICKEROTHERSIZE-1);//0-8
						List<RatePgPo> pickerList = ratePgList.subList(PICKEROTHERSIZE-1,ratePgSize);//8-
						resultMap.put("pickerList", pickerList);
						resultMap.put("rateShowList", rateShowList);
					}else{
						resultMap.put("pickerList", null);
						resultMap.put("rateShowList", ratePgList);
					}
					response.getWriter().print(JSON.toJSONString(resultMap));
				}
//				response.getWriter().print(JSON.toJSONString(resultMap));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @description: (统一下单接口)生成订单，根据参数调用微信接口获得预支付id
	 * @param pgChargeVO
	 * @param openid
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月1日 上午10:23:38
	 */
	@Transactional
	@RequestMapping(value=WeChatURL.GETPREPAYID)
	public void getPrepayId(HttpServletResponse response,PgChargeVO pgChargeVO,String openid){
		String jsonStr = "error";
		System.out.println(pgChargeVO.toString());
		if(pgChargeVO.getAccountId() != null){
//			ChargeAccountPo accountPo = chargeAccountAo.getAccountById(pgChargeVO.getAccountId());
			//充值
			pgChargeVO.setChargeFor(PgServiceTypeEnum.PGCHARGE.getValue());
			Long orderId = wXPayAO.purchase(pgChargeVO, openid);
			Map<String,Object> resultMap = new HashMap<String,Object>();
			if(orderId != null){
				try {
					Map<String,Object> reqMap = new TreeMap<String,Object>();
					reqMap.put("appid", WXPayConfig.APPID);
				     reqMap.put("mch_id", WXPayConfig.MCH_ID);
				     reqMap.put("nonce_str", WXPayUtil.getNonce_str());
				     reqMap.put("body", new String("微族充值中心-流量充值".getBytes("UTF-8")));
				     reqMap.put("out_trade_no", orderId);
				     
				     reqMap.put("total_fee", (int)NumberTool.mul(pgChargeVO.getOrderAmount(), 100)); //订单总金额，单位为分
//				     reqMap.put("spbill_create_ip", "192.168.0.1"); //用户端ip
				     reqMap.put("notify_url", WXPayConfig.NOTIFY_URL); //通知地址
				     reqMap.put("trade_type", WXPayConfig.TRADETYPE);
				     reqMap.put("openid", openid);
//				     reqMap.put("attach", pgChargeVO.getRateId());
//				     String sign = WXPayUtil.getSign(reqMap);
//				     reqMap.put("sign", sign);
				     String reqStr = WXPayUtil.map2Xml(reqMap);
//				     System.out.println("微信请求参数："+ reqStr);
//				      String resultXml = HttpRequest.sendPost(WXPayConfig.PAY_URL, reqStr);
				     String resultXml = WxPaySendPost.sendPost(WXPayConfig.PAY_URL, reqStr);	
				     
				      
//				      System.out.println("微信请求返回:" + resultXml);
				      String returnCode = WXPayUtil.getReturnCode(resultXml);
				      if("SUCCESS".equals(returnCode)){
				          String prepayId = WXPayUtil.getPrepayId(resultXml);
				          if(prepayId == null){
				        	  jsonStr = "微信请求支付失败";
				          }else{
				        	  resultMap.put("appId", System.getenv("appid"));
				        	  resultMap.put("nonceStr", WXPayUtil.getNonceStr(resultXml));//解析随机字符串
				        	  resultMap.put("packages", "prepay_id=" + prepayId);
				        	  resultMap.put("signType", "MD5");
				        	  resultMap.put("timeStamp", String.valueOf((System.currentTimeMillis() / 1000)));//时间戳
				        	  String paySign = WXPayUtil.getSign(resultMap);
				        	  resultMap.put("paySign", paySign);
				        	  resultMap.put("msg", "success");
				        	  resultMap.put("orderId", orderId);
				        	  jsonStr = JSON.toJSONString(resultMap);
				          }
				      }else{
				    	  resultMap.put("msg", "微信请求支付失败");
				    	  jsonStr = JSON.toJSONString(resultMap);
				      }
				} catch (UnsupportedEncodingException e) {
					resultMap.put("msg", "编码错误");
					jsonStr = JSON.toJSONString(resultMap);
					e.printStackTrace();
				}
			}else{
				resultMap.put("msg", "生成订单号失败");
				jsonStr = JSON.toJSONString(resultMap);
			}
		}
		try {
//			System.out.println("返回的参数："+jsonStr);
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description: 获得用户openId
	 * @param request
	 * @param response
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月9日 下午2:21:28
	 */
	@RequestMapping(value=WeChatURL.GETOPENID)
	public void getOpenId(String jsCode, HttpServletResponse response){
		StringBuffer paramSb = new StringBuffer();
		paramSb.append("js_code="+jsCode);
		paramSb.append("&appid="+WXPayConfig.APPID);
		paramSb.append("&grant_type="+WXPayConfig.GRANT_TYPE);
		paramSb.append("&secret="+WXPayConfig.APP_SECRET);
//		System.out.println("paramSb:"+paramSb);
		String jsonStr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", paramSb.toString());
//		System.out.println("返回json："+jsonStr);
		JSONObject obj = JSON.parseObject(jsonStr);
		Map<String,Object> returnMap = new HashMap<String, Object>();
		if(obj != null){
			String openid = obj.get("openid") == null?"": obj.get("openid").toString();
			String session_key = obj.get("session_key") == null?"":obj.get("session_key").toString();
			String unionid = obj.get("unionid") == null?"":obj.get("unionid").toString();
			returnMap.put("openid", openid);
//    	returnMap.put("session_key", session_key);
			returnMap.put("unionid", unionid);
			returnMap.put("msg", "success");
		}else{
			returnMap.put("msg", "error");
		}
		try {
//			System.out.println("输出的字符串:"+JSON.toJSONString(returnMap));
			response.getWriter().print(JSON.toJSONString(returnMap));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description: 微信支付结果推送(向上提单)
	 * @param request
	 * @author:微族通道代码设计人 宁强
	 * @throws IOException 
	 * @createTime:2018年2月1日 下午4:16:39
	 */
	@RequestMapping(value=WeChatURL.WXNOTIFY)
	public void wxNotify(HttpServletRequest request, HttpServletResponse response){
		//输入流读取推送过来的xml文件
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
			String line = null;
			while((line = br.readLine())!=null){
			    sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//        Map<String,Object> resultMap = WXPayUtil.xmlToMap(sb.toString());
        Map<String,Object> resultMap = WXPayUtil.readStringXmlOut(sb.toString());
        
        int successTag = 0;
        if(resultMap != null){
        	String returnCode = resultMap.get("return_code").toString();
        	if(returnCode.equals("SUCCESS")){
        		String resultCode = resultMap.get("result_code").toString();
        		if(resultCode.equals("SUCCESS")){
        			SortedMap<String, String> packageParams = new TreeMap<String, String>();
        			packageParams.put("appid", resultMap.get("appid").toString());
//                  String attachStr = resultMap.get("attach").toString();
//                  packageParams.put("attach", resultMap.get("attach").toString());
//                  packageParams.put("bank_type", resultMap.get("bank_type").toString());
        			packageParams.put("cash_fee", resultMap.get("cash_fee").toString());//分
//                  packageParams.put("fee_type", resultMap.get("fee_type").toString());
//                  packageParams.put("is_subscribe", resultMap.get("is_subscribe").toString());
//                  packageParams.put("mch_id", resultMap.get("mch_id").toString());
//                  packageParams.put("nonce_str", resultMap.get("nonce_str").toString());
//                  packageParams.put("openid", resultMap.get("openid").toString());
        			String orderIdStr = resultMap.get("out_trade_no").toString();
        			packageParams.put("out_trade_no", orderIdStr);
        			packageParams.put("result_code", resultMap.get("result_code").toString());
        			packageParams.put("return_code", resultMap.get("return_code").toString());
//                  packageParams.put("time_end", resultMap.get("time_end").toString());
        			packageParams.put("total_fee", resultMap.get("total_fee").toString());//分
//                  packageParams.put("trade_type", resultMap.get("trade_type").toString());
        			String transaction_id = resultMap.get("transaction_id").toString();
        			packageParams.put("transaction_id", transaction_id);
//                  String sign = WXPayUtil.getSign(resultMap);
        			String originSign = resultMap.get("sign").toString();
//                  if(sign.equals(originSign)){
        			//支付成功后，把状态改为进行，调用相应的通道平台向上提单
        			//(产品编码的获取,直接从订单表中取？)
//        			  Long rateId = Long.parseLong(attachStr);
        			Long orderId = Long.parseLong(orderIdStr);
        			PurchasePo purchasePo = purchaseDAO.get(orderId);
        			if(purchasePo != null){
        				Integer epId = purchasePo.getEpId();
        				if(epId != null){
        					ExchangePlatformPo epPo = exchangePlatformDao.get(epId);
        					ProductCodePo dataPo = null;
        					if(EpEncodeTypeEnum.WITH_CODE.getValue().equals(epPo.getEpEncodeType())){
        						Map<String,Object> map = PurchaseUtil.getScopeCityByCarrier(purchasePo.getChargeTelDetail());
        						String scopeCityCode = map.get("scopeCityCode").toString();
        						dataPo = productCodeAO.getOneProductCode(new OneCodePo(scopeCityCode, epPo.getId(), Integer.parseInt(purchasePo.getPgId())));
        					}else{
        						dataPo = productCodeAO.getOneProductCodeByPg(Integer.parseInt(purchasePo.getPgId()));
        					}
        					
//        					ChargeDTO chargeDTO = purchaseAO.chargeByBI(epPo, purchasePo, dataPo);
//        					Integer orderResult = null;
//        					String orderResultDetail = "";
//        					if(chargeDTO != null){
//        						if(chargeDTO.getTipCode().equals(OrderResultEnum.SUCCESS.getCode()) ){
//        							orderResult = OrderStateEnum.CHARGING.getValue();
//        							orderResultDetail = OrderStateEnum.CHARGING.getDesc();
//        							ChargeOrder co = chargeDTO.getChargeOrder();
//        							if(co != null){
////        								purchasePo.setOrderIdFrom(transaction_id);//将openid换成支付返回的支付id
//        								purchasePo.setOrderIdApi(co.getOrderIdApi());
//        								successTag++;
//        							}
//        						}else{
//        							orderResult = OrderStateEnum.DAICHONG.getValue();
//        							orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+chargeDTO.getTipMsg();
//        						}
//        					}else{
//        						orderResult = OrderStateEnum.DAICHONG.getValue();
//        						orderResultDetail = OrderStateEnum.UNCHARGE.getDesc()+"上游提交直接返失败";
//        					}
//        					purchasePo.setOrderResult(orderResult);
//        					purchasePo.setOrderResultDetail(orderResultDetail);
//        					successTag += purchaseDAO.updatePurchaseState(purchasePo);
        					successTag++;
        				}
        			}
        			System.out.println("签名:"+originSign);
//                	  System.out.println("签名正确");
//                  }
        		}else{
        			System.out.println("支付失败");
        		}
        	}else{
        		System.out.println("接收支付结果失败");
        	}
        }
        Map<String,Object> returnMap = new HashMap<String, Object>();
        if(successTag > 1){
        	returnMap.put("return_code", "SUCCESS");
        	returnMap.put("return_msg", "OK");
        }else{
        	returnMap.put("return_code", "FAIL");
        }
        try {
			String returnXMLStr = WXPayUtil.map2XmlNoSign(returnMap);
			System.out.println("返回的参数"+returnXMLStr);
			response.getWriter().print(returnXMLStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description: 微信返款结果推送
	 * @param request
	 * @param response
	 * @author:微族通道代码设计人 宁强
	 * @throws UnsupportedEncodingException 
	 * @createTime:2018年2月3日 上午11:15:34
	 */
	@Transactional
	@RequestMapping(value=WeChatURL.WX_REFUND_NOTIFY)
	public void wxRefundNotify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		//输入流读取推送过来的xml文件
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
			String line = null;
			while((line = br.readLine())!=null){
			    sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		        Map<String,Object> resultMap = WXPayUtil.xmlToMap(sb.toString());
        Map<String,Object> resultMap = WXPayUtil.readStringXmlOut(sb.toString());
        String returnCode = resultMap.get("return_code").toString();
        if(returnCode.equals("SUCCESS")){
        	Map<String,Object> returnMap = new HashMap<String, Object>();
        	String appid = resultMap.get("appid").toString();
        	String mch_id = resultMap.get("mch_id").toString();
        	String nonce_str = resultMap.get("nonce_str").toString();
        	String reqInfo = resultMap.get("req_info").toString();
        	
        	String baseDecode = Hash.BASE_UTIL.decode(reqInfo);
    		System.out.println("BASE_UTIL解密结果："+ baseDecode);
        	byte[] keys = MD5.getMd5("2IBtBXdrqC3kCBs4gaceL7nl2nnFadQv", MD5.LOWERCASE, "UTF-8").getBytes();
        	String reqInfoXml = Encrypt.Aes256Decode(baseDecode.getBytes(), keys);
        	System.out.println("aes解密后结果："+ reqInfoXml);
        	Map<String,Object> reqInfoMap = WXPayUtil.readStringXmlOut(reqInfoXml);
        	int upRes = 0;
        	if(reqInfoMap != null){
        		String refund_status = reqInfoMap.get("refund_status").toString();
        		String out_trade_no = reqInfoMap.get("out_trade_no").toString();
        		String orderResultDetail = "微信支付-";
        		if("SUCCESS".equals(refund_status)){
        			orderResultDetail += "退款成功";
        		}else if("CHANGE".equals(refund_status)){
        			orderResultDetail += "退款异常";
        		}
        		else if("REFUNDCLOSE".equals(refund_status)){
        			orderResultDetail += "退款关闭";
        		}
        		PurchasePo purchasePo1 = purchaseDAO.getOnePurchase(Long.parseLong(out_trade_no));
        		if(purchasePo1 != null){
        			purchasePo1.setOrderBackTime(System.currentTimeMillis());
        			purchasePo1.setOrderResultDetail(orderResultDetail);
        			upRes = purchaseDAO.updatePurchaseState(purchasePo1);
        		}
        	}
        	if(upRes > 0){
        		returnMap.put("return_code", "SUCCESS");
        		returnMap.put("return_msg", "OK");
        	}else{
        		returnMap.put("return_code", "FAIL");
        	}
        	try {
    			String returnXMLStr = WXPayUtil.map2XmlNoSign(returnMap);
    			System.out.println("返回给微信返款的的参数"+returnXMLStr);
    			response.getWriter().print(returnXMLStr);
    		} catch (UnsupportedEncodingException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
	}
	
}
