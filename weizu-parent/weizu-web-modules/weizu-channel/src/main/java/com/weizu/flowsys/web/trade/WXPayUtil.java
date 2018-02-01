package com.weizu.flowsys.web.trade;

import org.dom4j.io.SAXReader;
import org.w3c.dom.NodeList;

import com.weizu.flowsys.web.trade.constant.WXPayConfig;
import com.weizu.web.foundation.MD5;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * @description: 微信支付工具类
 * @projectName:weizu-channel
 * @className:WXPayUtil.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月31日 上午11:33:04
 * @version 1.0
 */
public class WXPayUtil {
 //生成随机字符串
  public static String getNonce_str() {
    String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 15; i++) {
      int number = random.nextInt(base.length());
      sb.append(base.charAt(number));
    }
    return sb.toString();
  }
 
  //map转xml 加上签名信息
  public static String map2Xml(Map<String, Object> map) throws UnsupportedEncodingException {
    StringBuffer sb = new StringBuffer();
    StringBuilder sb2 = new StringBuilder();
    sb2.append("<xml>");
    for (String key : map.keySet()) {
      sb.append(key);
      sb.append('=');
      sb.append(map.get(key));
      sb.append('&');
      // sb2是用来做请求的xml参数
      sb2.append("<" + key + ">");
//      sb2.append("<![CDATA[" + map.get(key) + "]]>");
      sb2.append(map.get(key));
      sb2.append("</" + key + ">");
    }
    sb.append(System.getenv("signKey"));
    String sign = MD5.getMd5(sb.toString(), MD5.UPPERCASE, "utf-8");
//    String sign = MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
    sb2.append("<sign>");
    sb2.append(sign);
    sb2.append("</sign>");
    sb2.append("</xml>");
    return sb2.toString();
  }
 
  //解析微信返回return_code SUCCESS或FILE
  //根据微信返回resultXml再次生成签名
  public static String getSign(Map<String, Object> map) {
    StringBuffer sb = new StringBuffer();
    for (String key : map.keySet()) {
      sb.append(key);
      sb.append('=');
      sb.append(map.get(key));
      sb.append('&');
    }
    sb.append(WXPayConfig.KEY);
    System.out.println("第二次签名内容:" + sb);
//    System.out.println("第二次签名SING:" + MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase());
    String sign="";
	try {
		sign = MD5.getMd5(sb.toString(), MD5.UPPERCASE, "utf-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("第二次签名SING:" + sign);
//    return MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
    return sign;
  }
 
  //解析微信返回return_code SUCCESS或FILE
  public static String getReturnCode(String resultXml) {
    String nonceStr;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = dbf.newDocumentBuilder();
      InputStream inputStream = new ByteArrayInputStream(resultXml.getBytes());
      org.w3c.dom.Document doc = builder.parse(inputStream); //
      // 下面开始读取
      org.w3c.dom.Element root = doc.getDocumentElement(); // 获取根元素
      NodeList nl = root.getElementsByTagName("return_code");
      org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
      org.w3c.dom.Node nd = el.getFirstChild();
      nonceStr = nd.getNodeValue();
      return nonceStr;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
 
  //解析微信返回return_msg
  public static String getReturn_msg(String resultXml) {
    String nonceStr;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = dbf.newDocumentBuilder();
      InputStream inputStream = new ByteArrayInputStream(resultXml.getBytes());
      org.w3c.dom.Document doc = builder.parse(inputStream); //
      // 下面开始读取
      org.w3c.dom.Element root = doc.getDocumentElement(); // 获取根元素
      NodeList nl = root.getElementsByTagName("return_msg");
      org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
      org.w3c.dom.Node nd = el.getFirstChild();
      nonceStr = nd.getNodeValue();
      return nonceStr;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
 
  //解析微信返回appid
  public static String getAppId(String resultXml) {
    String nonceStr;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = dbf.newDocumentBuilder();
      InputStream inputStream = new ByteArrayInputStream(resultXml.getBytes());
      org.w3c.dom.Document doc = builder.parse(inputStream); //
      // 下面开始读取
      org.w3c.dom.Element root = doc.getDocumentElement(); // 获取根元素
      NodeList nl = root.getElementsByTagName("appid");
      org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
      org.w3c.dom.Node nd = el.getFirstChild();
      nonceStr = nd.getNodeValue();
      return nonceStr;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
 
  //解析微信返回mch_id
  public static String getMchId(String resultXml) {
    String nonceStr;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = dbf.newDocumentBuilder();
      InputStream inputStream = new ByteArrayInputStream(resultXml.getBytes());
      org.w3c.dom.Document doc = builder.parse(inputStream); //
      // 下面开始读取
      org.w3c.dom.Element root = doc.getDocumentElement(); // 获取根元素
      NodeList nl = root.getElementsByTagName("mch_id");
      org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
      org.w3c.dom.Node nd = el.getFirstChild();
      nonceStr = nd.getNodeValue();
      return nonceStr;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
 
  //解析微信返回nonce_str
  public static String getNonceStr(String resultXml) {
    String nonceStr;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = dbf.newDocumentBuilder();
      InputStream inputStream = new ByteArrayInputStream(resultXml.getBytes());
      org.w3c.dom.Document doc = builder.parse(inputStream); //
      // 下面开始读取
      org.w3c.dom.Element root = doc.getDocumentElement(); // 获取根元素
      NodeList nl = root.getElementsByTagName("nonce_str");
      org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
      org.w3c.dom.Node nd = el.getFirstChild();
      nonceStr = nd.getNodeValue();
      return nonceStr;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
//解析微信返回prepay_id
  public static String getPrepayId(String resultXml) {
    String nonceStr;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = dbf.newDocumentBuilder();
      InputStream inputStream = new ByteArrayInputStream(resultXml.getBytes());
      org.w3c.dom.Document doc = builder.parse(inputStream); //
      // 下面开始读取
      org.w3c.dom.Element root = doc.getDocumentElement(); // 获取根元素
      NodeList nl = root.getElementsByTagName("prepay_id");
      org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
      org.w3c.dom.Node nd = el.getFirstChild();
      nonceStr = nd.getNodeValue();
      return nonceStr;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
  /**
 * @description: 解析回调的xml文件(https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_7)
 * @param resultXml
 * @return
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年2月1日 下午5:10:09
 */
public static Map<String,Object> xmlToMap(String resultXml){
	  String nonceStr;
	  Map<String, Object> map = new HashMap<String, Object>();
	  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	  DocumentBuilder builder;
	    try {
	      builder = dbf.newDocumentBuilder();
	      InputStream inputStream = new ByteArrayInputStream(resultXml.getBytes());
	      org.w3c.dom.Document doc = builder.parse(inputStream); //
	      // 下面开始读取
	      org.w3c.dom.Element root = doc.getDocumentElement(); // 获取根元素
	      
	      
	      NodeList nl = root.getElementsByTagName("return_code");
	      org.w3c.dom.Element el = (org.w3c.dom.Element) nl.item(0);
	      org.w3c.dom.Node nd = el.getFirstChild();
	      nonceStr = nd.getNodeValue();
	      
	      map.put("prepay_id", nonceStr);
	      
	      
	      return map;
	    } catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
//	  return map;
  }
}
