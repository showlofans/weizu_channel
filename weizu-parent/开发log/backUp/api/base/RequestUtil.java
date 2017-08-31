package com.weizu.flowsys.api.base;

public class RequestUtil {
//	public static String doPost(String url, Map<String, String> params, String charset) {  
//        StringBuffer response = new StringBuffer();  
//        HttpClient client = new HttpClient();  
//        PostMethod method = new PostMethod(url);  
//        // 设置Http Post数据  
//        method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=" + charset);  
//        if(params != null){  
//            Set<String> keySet = params.keySet();  
//            NameValuePair[] param = new NameValuePair[keySet.size()];  
//            int i = 0;  
//            for(String key : keySet){  
//                param[i] = new NameValuePair(key, params.get(key));  
//                i++;  
//            }  
//            method.setRequestBody(param);  
//        }  
//        InputStream responseBodyStream = null;  
//        InputStreamReader streamReader = null;  
//        BufferedReader reader = null;  
//        try {  
//            client.executeMethod(method);  
//            if (method.getStatusCode() == HttpStatus.SC_OK) {  
//                responseBodyStream = method.getResponseBodyAsStream();  
//                streamReader = new InputStreamReader(responseBodyStream, charset);  
//                reader = new BufferedReader(streamReader);  
//                String line;  
//                while ((line = reader.readLine()) != null) {  
//                    response.append(line);  
//                }  
//            }  
//        } catch (IOException e) {  
//            logger.error("执行HTTP Post请求" + url + "时，发生异常！", e);  
//        } finally {  
//            try {  
//                responseBodyStream.close();  
//                streamReader.close();  
//                reader.close();  
//            } catch (IOException e) {  
//                logger.error("执行HTTP Post请求" + url + "时，发生异常，关闭流异常！", e);  
//                e.printStackTrace();  
//            }  
//            method.releaseConnection();  
//        }  
//        return response.toString();  
//    } 
}
