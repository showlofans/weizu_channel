package com.weizu.flowsys.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpRequestPost {
	/** 
     * 发送 POST 请求（HTTP），K-V形式 
     * @param apiUrl API接口URL 
     * @param params 参数map 
     * @return 
     */  
    public static String doPost(String apiUrl, Map<String, Object> params) {  
        String httpStr = null;  
    	try {
    		System.out.println("请求参数："+params);
			RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).build();  
			CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();  
			List<NameValuePair> pairs = null;
			if (params != null && !params.isEmpty()) {
				pairs = new ArrayList<NameValuePair>(params.size());
				for (String key : params.keySet()) {
					pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
				}
			}
			HttpPost httpPost = new HttpPost(apiUrl);
			if (pairs != null && pairs.size() > 0) {
				httpPost.setEntity(new UrlEncodedFormEntity(pairs, "utf-8"));
			}
			CloseableHttpResponse response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				httpStr = EntityUtils.toString(entity, "utf-8");
				EntityUtils.consume(entity);
				response.close();
//				System.out.println(httpStr);
			} else {
				
			}
		} catch (Exception e){
			e.printStackTrace(); 
		}

    	
//    	CloseableHttpClient httpClient = HttpClients.createDefault();  
//        HttpPost httpPost = new HttpPost(apiUrl);  
//        CloseableHttpResponse response = null;  
//  
//        try {  
////            httpPost.setConfig(requestConfig);  
//            List<NameValuePair> pairList = new ArrayList<>(params.size());  
//            for (Map.Entry<String, Object> entry : params.entrySet()) {  
//                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry  
//                        .getValue().toString());  
//                pairList.add(pair);  
//            }  
//            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));  
//            response = httpClient.execute(httpPost);  
////            System.out.println(response.toString());  
//            HttpEntity entity = response.getEntity();  
//            httpStr = EntityUtils.toString(entity, "UTF-8");  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        } finally {  
//            if (response != null) {  
//                try {  
//                    EntityUtils.consume(response.getEntity());  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
        return httpStr;  
    }  
}
