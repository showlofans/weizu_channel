package com.weizu.flowsys.web.trade.constant;

public class WXPayConfig {
	//小程序appid  
    public static final String APPID = "wxcf0590c3295581d8";  
    //微信支付的商户id  
    public static final String MCH_ID = "1401974602";  
    //微信支付的商户密钥  
    public static final String KEY = "qqqqqqqqqqqqqq360111199605236014";  
    //获得openid的密钥
//    public static final String app_secret = "9cb60b1746e195f0e0f6f39e82257dbc";  
    //支付成功后的服务器回调url  
    public static final String NOTIFY_URL = "https://www.91weizu.cn/flowsys/wechat/wxNotify.do";  
    //签名方式，固定值  
    public static final String SIGNTYPE = "MD5";  
    //交易类型，小程序支付的固定值为JSAPI  
    public static final String TRADETYPE = "JSAPI";  
    //微信统一下单接口地址  
    public static final String PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";  
}
