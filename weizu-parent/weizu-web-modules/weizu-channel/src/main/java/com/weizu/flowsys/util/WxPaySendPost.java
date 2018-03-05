package com.weizu.flowsys.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

//@Service
public class WxPaySendPost {
	/**
     * 方法名: getRemotePortData
     * 描述: 发送远程请求 获得代码示例
     * 参数：  @param urls 访问路径
     * 参数：  @param param 访问参数-字符串拼接格式, 例：port_d=10002&port_g=10007&country_a=
     * 创建人: Xia ZhengWei
     * 创建时间: 2017年3月6日 下午3:20:32
     * 版本号: v1.0   
     * 返回类型: String
    */
    public static String sendPost(String urls, String param){
//        try {
//            URL url = new URL(urls);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            // 设置连接超时时间
//            conn.setConnectTimeout(30000);
//            // 设置读取超时时间
//            conn.setReadTimeout(30000);
//            conn.setRequestMethod("POST");
//            if(StringHelper.isNotEmpty(param)) {
//                conn.setRequestProperty("Origin", "https://www.91weizu.cn");// 主要参数
////                conn.setRequestProperty("Referer", "https://sirius.searates.com/cn/port?A=ChIJP1j2OhRahjURNsllbOuKc3Y&D=567&G=16959&shipment=1&container=20st&weight=1&product=0&request=&weightcargo=1&");
//                conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");// 主要参数
//            }
//            // 需要输出
//            conn.setDoInput(true);
//            // 需要输入
//            conn.setDoOutput(true);
//            // 设置是否使用缓存
//            conn.setUseCaches(false);
//            // 设置请求属性
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            conn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
//            conn.setRequestProperty("Charset", "UTF-8");
//            
//            if(StringHelper.isNotEmpty(param)) {
//                // 建立输入流，向指向的URL传入参数
//                DataOutputStream dos=new DataOutputStream(conn.getOutputStream());
//                dos.writeBytes(param);
//                dos.flush();
//                dos.close();
//            }
//            // 输出返回结果
//            InputStream input = conn.getInputStream();
//            int resLen =0;
//            byte[] res = new byte[1024];
//            StringBuilder sb=new StringBuilder();
//            while((resLen=input.read(res))!=-1){
//                sb.append(new String(res, 0, resLen));
//            }
//            return sb.toString();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            System.out.println("港距查询抓取数据----抓取外网港距数据发生异常：" + e.getMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("港距查询抓取数据----抓取外网港距数据发生异常：" + e.getMessage());
//        }
//        System.out.println("港距查询抓取数据----抓取外网港距数据失败, 返回空字符串");
//        return "";
    	  StringBuffer buffer=null;  
    	    try{  
    	    //创建SSLContext  
    	    SSLContext sslContext=SSLContext.getInstance("SSL");  
    	    TrustManager[] tm={new MyX509TrustManager()};  
    	    //初始化  
    	    sslContext.init(null, tm, new java.security.SecureRandom());;  
    	    //获取SSLSocketFactory对象  
    	    SSLSocketFactory ssf=sslContext.getSocketFactory();  
    	    URL url=new URL(urls);  
    	    HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();  
    	    conn.setDoOutput(true);  
    	    conn.setDoInput(true);  
    	    conn.setUseCaches(false);  
    	    conn.setRequestMethod("POST");  
    	    //设置当前实例使用的SSLSoctetFactory  
    	    conn.setSSLSocketFactory(ssf);  
    	    conn.connect();  
    	    //往服务器端写内容  
    	    if(null!=param){  
    	        OutputStream os=conn.getOutputStream();  
    	        os.write(param.getBytes("utf-8"));  
    	        os.close();  
    	    }  
    	      
    	    //读取服务器端返回的内容  
    	    InputStream is=conn.getInputStream();  
    	    InputStreamReader isr=new InputStreamReader(is,"utf-8");  
    	    BufferedReader br=new BufferedReader(isr);  
    	    buffer=new StringBuffer();  
    	    String line=null;  
    	    while((line=br.readLine())!=null){  
    	        buffer.append(line);  
    	    }  
    	    }catch(Exception e){  
    	        e.printStackTrace();  
    	    }  
    	    return buffer.toString();  
    }
    
    /**
     * @description: 发送https：Get请求
     * @param urls
     * @param param
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年3月3日 下午2:55:56
     */
    public static String sendGet(String urls, String param){
    	String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = urls + "?" + param;
          //创建SSLContext  
    	    SSLContext sslContext=SSLContext.getInstance("SSL");  
    	    TrustManager[] tm={new MyX509TrustManager()};  
    	    //初始化  
    	    sslContext.init(null, tm, new java.security.SecureRandom());;  
    	    //获取SSLSocketFactory对象  
    	    SSLSocketFactory ssf=sslContext.getSocketFactory();
    	    
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            HttpsURLConnection connection = (HttpsURLConnection) realUrl.openConnection();
            connection.setSSLSocketFactory(ssf);  
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
