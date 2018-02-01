package com.weizu.flowsys.web.trade.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
import com.weizu.flowsys.web.trade.WXPayUtil;
import com.weizu.flowsys.web.trade.ao.WXPayAO;
import com.weizu.flowsys.web.trade.constant.WXPayConfig;
import com.weizu.flowsys.web.trade.pojo.PgChargeVO;
import com.weizu.flowsys.web.trade.pojo.RatePgPo;
import com.weizu.flowsys.web.trade.url.WeChatURL;
import com.weizu.web.foundation.String.StringHelper;
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
			try {
				ChargeAccountPo accountPo = chargeAccountAo.getAccountByAgencyId(231, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
				List<RatePgPo> ratePgList = rateDiscountAO.getRatePgForCharge(ccpp, accountPo.getId(), false);
				response.getWriter().print(JSON.toJSONString(ratePgList));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @description: 生成订单，根据参数调用微信接口获得预支付id
	 * @param pgChargeVO
	 * @param openid
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年2月1日 上午10:23:38
	 */
	@RequestMapping(value=WeChatURL.GETPREPAYID)
	public void getPrepayId(HttpServletResponse response,PgChargeVO pgChargeVO,String openid){
		String jsonStr = "error";
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
				     
				     reqMap.put("total_fee", NumberTool.mul(pgChargeVO.getOrderAmount(), 100)); //订单总金额，单位为分
//				     reqMap.put("spbill_create_ip", "192.168.0.1"); //用户端ip
				     reqMap.put("notify_url", WXPayConfig.NOTIFY_URL); //通知地址
				     reqMap.put("trade_type", WXPayConfig.TRADETYPE);
				     reqMap.put("openid", openid);
//				     String sign = WXPayUtil.getSign(reqMap);
//				     reqMap.put("sign", sign);
				     String reqStr = WXPayUtil.map2Xml(reqMap);
				     System.out.println("微信请求参数："+ reqStr);
				      String resultXml = HttpRequest.sendPost(WXPayConfig.PAY_URL, reqStr);
				      System.out.println("微信请求返回:" + resultXml);
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
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @description: 微信支付结果推送
	 * @param request
	 * @author:微族通道代码设计人 宁强
	 * @throws IOException 
	 * @createTime:2018年2月1日 下午4:16:39
	 */
	@RequestMapping(value=WeChatURL.WXNOTIFY)
	public void wxNotify(HttpServletRequest request) throws IOException{
		//输入流读取推送过来的xml文件
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
		String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        Map<String,Object> resultMap = WXPayUtil.xmlToMap(sb.toString());
        String returnCode = resultMap.get("return_code").toString();
        if(returnCode.equals("SUCCESS")){
            String resultCode = resultMap.get("result_code").toString();
            if(resultCode.equals("SUCCESS")){
            	  SortedMap<String, String> packageParams = new TreeMap<String, String>();
                  packageParams.put("appid", resultMap.get("appid").toString());
                  packageParams.put("attach", resultMap.get("attach").toString());
                  packageParams.put("bank_type", resultMap.get("bank_type").toString());
                  packageParams.put("cash_fee", resultMap.get("cash_fee").toString());
                  packageParams.put("fee_type", resultMap.get("fee_type").toString());
                  packageParams.put("is_subscribe", resultMap.get("is_subscribe").toString());
                  packageParams.put("mch_id", resultMap.get("mch_id").toString());
                  packageParams.put("nonce_str", resultMap.get("nonce_str").toString());
                  packageParams.put("openid", resultMap.get("openid").toString());
                  packageParams.put("out_trade_no", resultMap.get("out_trade_no").toString());
                  packageParams.put("result_code", resultMap.get("result_code").toString());
                  packageParams.put("return_code", resultMap.get("return_code").toString());
                  packageParams.put("time_end", resultMap.get("time_end").toString());
                  packageParams.put("total_fee", resultMap.get("total_fee").toString());
                  packageParams.put("trade_type", resultMap.get("trade_type").toString());
                  packageParams.put("transaction_id", resultMap.get("transaction_id").toString());
                  String sign = WXPayUtil.getSign(resultMap);
                  String originSign = resultMap.get("sign").toString();
                  if(sign.equals(originSign)){
                	  //支付成功后，把状态改为进行，调用相应的通道平台向上提单
                	  //(产品编码的获取,直接从订单表中取？)
                	  
                	  System.out.println("签名正确");
                  }
            }
        }
        
	}
}
