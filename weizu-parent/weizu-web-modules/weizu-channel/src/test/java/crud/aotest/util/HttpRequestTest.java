//package crud.aotest.util;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Map;
//import java.util.TreeMap;
//
//
//
//import com.weizu.flowsys.core.util.NumberTool;
//import com.weizu.flowsys.util.WxPaySendPost;
//import com.weizu.flowsys.web.trade.WXPayUtil;
//import com.weizu.flowsys.web.trade.constant.WXPayConfig;
//import com.weizu.web.foundation.http.HttpRequest;
//
//
//
//public class HttpRequestTest {
//	public static void main(String[] args) throws UnsupportedEncodingException {
////		Map<String,Object> reqMap = new TreeMap<String,Object>();
////		reqMap.put("appid", WXPayConfig.APPID);
////	     reqMap.put("mch_id", WXPayConfig.MCH_ID);
////	     reqMap.put("nonce_str", WXPayUtil.getNonce_str());
////	     reqMap.put("body", new String("微族充值中心-流量充值".getBytes("UTF-8")));
////	     reqMap.put("out_trade_no", 787026305714491392l);
////	     
////	     reqMap.put("total_fee", (int)NumberTool.mul(2.04, 100)); //订单总金额，单位为分
//////	     reqMap.put("spbill_create_ip", "192.168.0.1"); //用户端ip
////	     reqMap.put("notify_url", WXPayConfig.NOTIFY_URL); //通知地址
////	     reqMap.put("trade_type", WXPayConfig.TRADETYPE);
////	     reqMap.put("openid", "oiuEW0c7ROWDfIZDTUcEmDFkQ9mc");
//////	     reqMap.put("attach", pgChargeVO.getRateId());
//////	     String sign = WXPayUtil.getSign(reqMap);
//////	     reqMap.put("sign", sign);
////	     String reqStr = WXPayUtil.map2Xml(reqMap);
////	     System.out.println("请求参数："+reqStr);
//////		String resultStr = WxPaySendPost.sendPost(WXPayConfig.PAY_URL, "<xml><appid>wxcf0590c3295581d8</appid><body>微族充值中心-流量充值</body><mch_id>1401974602</mch_id><nonce_str>APF0CHGIC16M117</nonce_str><notify_url>https://www.91weizu.cn/flowsys/wechat/wxNotify.do</notify_url><openid>oiuEW0c7ROWDfIZDTUcEmDFkQ9mc</openid><out_trade_no>787026305714491392</out_trade_no><total_fee>204</total_fee><trade_type>JSAPI</trade_type><sign>82A564CC6202221F0908FD6F02F99978</sign></xml>");
////		String resultStr = WxPaySendPost.sendPost(WXPayConfig.PAY_URL, reqStr);
////		System.out.println(resultStr);
//		测试推送
//		String params = "errcode=0&transaction_id=20180207152732819330&user_order_id=787104526988480512&number=13948437262&status=4";
//		String jsonStr = HttpRequest.sendPost("https://www.91weizu.cn/flowsys/callBack/weizu.do", params);
//		System.out.println(jsonStr);
//	}
//}
