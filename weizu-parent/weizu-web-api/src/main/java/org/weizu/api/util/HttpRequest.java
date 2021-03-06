package org.weizu.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequest {
	private final static int connection_time_out = 30000;			//30秒无响应
	private final static int read_time_out = 50000;					//50秒无响应
	
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        URLConnection connection = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setConnectTimeout(connection_time_out);
            connection.setReadTimeout(read_time_out);
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	result = "exception";
            System.out.println("请求超时，或者其他问题" + e);
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

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是json 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
//        PrintWriter out = null;
    	 OutputStream out = null;
        BufferedReader in = null;
        HttpURLConnection httpConn = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            httpConn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            httpConn.setRequestProperty("accept", "*/*");
            httpConn.setRequestProperty("connection", "Keep-Alive");
            httpConn.setRequestMethod("POST"); 
            httpConn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
//            httpConn.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded");
            httpConn.setConnectTimeout(connection_time_out);
            httpConn.setReadTimeout(read_time_out);
//            httpConn.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.connect();
            // 获取URLhttpConnection对象对应的输出流
//            out = new PrintWriter(httpConn.getOutputStream());
           out = httpConn.getOutputStream();
            out.write(param.getBytes());
            // 发送请求参数
//            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(httpConn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	result = "exception";
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
                httpConn.disconnect();
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    } 
//    public static String sendDefaultPost(String url, String param) {
////        PrintWriter out = null;
//    	 String uriAPI = "http://XXXXXX";//Post方式没有参数在这里  
//         String result = "";  
//         HttpPost httpRequst = new HttpPost(uriAPI);//创建HttpPost对象  
//           
//         List <NameValuePair> params = new ArrayList<NameValuePair>();  
//         params.add(new BasicNameValuePair("str", "I am Post String"));  
//    	try {  
//            httpRequst.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));  
//            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);  
//            if(httpResponse.getStatusLine().getStatusCode() == 200)  
//            {  
//                HttpEntity httpEntity = httpResponse.getEntity();  
//                result = EntityUtils.toString(httpEntity);//取出应答字符串  
//            }  
//        } catch (UnsupportedEncodingException e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//            result = e.getMessage().toString();  
//        }  
//        catch (ClientProtocolException e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//            result = e.getMessage().toString();  
//        }  
//        catch (IOException e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//            result = e.getMessage().toString();  
//        }  
//    	return result;
//    } 

    
}
