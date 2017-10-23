//package crud.aotest.apiTest;
//
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import net.sf.json.JSONObject;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.http.Header;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.util.EntityUtils;
//
//
//
//
///* *
// *类名：LeFengApi
// *功能：乐风流量平台单号订购接口1.0示例
// *版本：1.0
// *日期：2016-06-29
// *说明：
// *以下代码只是为了方便客户测试而提供的样例代码，客户可以根据自己的需要，按照技术文档编写,并非一定要使用该代码。
// *该代码只是提供一个参考。
// */
//public class LeFengApi {
//	public static void main(String[] args) {
//		//客户修改1：===>订购接口私钥：乐疯平台为用户分配的接口调用私钥
//		String key = "接口密钥";
//		//客户修改2：===>流量规格:1024,10240
//		String orderMeal = "1024";
//		//客户修改3：===>用户名：乐疯平台为用户开的用户
//		String userName = "lefeng";
//		//客户修改4：===>手机号
//		String mobile = "18560686986";
//		//客户修改5：===>订单编号64位以内
//		String msgId = "ORDER12345778900";
//		//客户修改6：===>0：全国  1省内非漫游 2漫游
//		String range = "0";
//		//时间戳：5分钟内订单有效
//		String timeStamp = Long.toString(new Date().getTime()/1000);
//		
//		//签名
//		String sign=DigestUtils.sha1Hex("userName"+userName+"mobile"+mobile+"orderMeal"+orderMeal
//				+"timeStamp"+timeStamp+"key"+key).toLowerCase();
//		//订购接口地址:乐疯流量订购接口
//		String url = "http://103.254.76.66:8082/apiFlow/order/singleNumber";
//		chargeFlowPost(url,timeStamp, userName, mobile, sign, range, msgId, orderMeal);
//	}
//	public static void chargeFlowPost(String url,String timeStamp,String userName,String mobile,String sign,String range,String msgId,String orderMeal){
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put("timeStamp", timeStamp);
//			map.put("userName", userName);
//			map.put("mobile", mobile);
//			map.put("sign", sign);
//			map.put("range", range);
//			map.put("msgId", msgId);
//			map.put("orderMeal", orderMeal);
//			map.put("orderTime", 1);
//			String requestStr = map2json(map);
//			System.out.print("发送的请求参数为"+requestStr);
//			System.out.print("请求的url为"+url);
//			Map<String,String> headers = new HashMap<String,String>();
//			headers.put("Content-Type", "application/json");
//			String response;
//			try {
//				response = post(url, requestStr, headers , "UTF-8");//post方法自己封装或者模拟下边的post方法
//				System.out.print("请求报文为"+response);
//				Map<String,Object> responseMap = toHashMap(response);
//				if(responseMap != null && "0000".equals(responseMap.get("code").toString())){//提交成功
//						System.out.println("------------------------订单提交成功code---------------------------------------------------------------------"+responseMap.get("code").toString());
//						System.out.println("------------------------订单提交成功msg---------------------------------------------------------------------"+responseMap.get("msg").toString());
//				}else{//提交失败
//					System.out.println("-------------------------订单提交失败code--------------------------------------------------------------------"+responseMap.get("code").toString());
//					System.out.println("-------------------------订单提交失败msg--------------------------------------------------------------------"+responseMap.get("msg").toString());
//				}
//			}catch (Exception e) {
//				System.out.println("----------------------------------------请注意，当做异常订单处理，不要当做提交失败处理-------订单提交异常-----------------------------------");
//				e.printStackTrace();
//			}
//		}
//	/**
//	 * 发送post请求【查询参数使用字符串】，并返回字符串
//	 * 
//	 * @param url 请求地址
//	 * @param parameter 请求参数字符串
//	 * @param headers 请求头部数组
//	 * @param charSet 请参数编码格式
//	 * @return
//	 */
//	public static String post(String url, String requestContext,Map<String, String> headers, String charSet) {
//		// 创建默认的httpClient实例.    
//        CloseableHttpClient httpClient = HttpClients.createDefault();  
//		StringEntity stringEntity = new StringEntity(requestContext, charSet);
//		stringEntity.setContentEncoding(charSet);
//		String httpStr = null;
//		CloseableHttpResponse response = null;
//		HttpPost httpPost = new HttpPost(url);
//		httpPost.setEntity(stringEntity);
//		Header[] heads = new BasicHeader[headers.size()];
//		int i = 0;
//		for (String str : headers.keySet()) {
//			heads[i] = new BasicHeader(str, headers.get(str));
//			i++;
//		}
//		httpPost.setHeaders(heads);
//		try {
//			try {
//				response = httpClient.execute(httpPost);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			HttpEntity entity = response.getEntity();
//			try {
//				httpStr = EntityUtils.toString(entity, charSet);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}finally {
//			if (response != null) {
//				try {
//					//释放资源
//					EntityUtils.consume(response.getEntity());
//				} catch (IOException e) {
//					e.printStackTrace();
//				}finally {
//					//关闭CloseableHttpResponse
//					try {
//						response.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			httpPost.releaseConnection();
//			//关闭HttpClient
//			try {
//				httpClient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return httpStr;
//	}
//	// 将Map转换成JSON
//		public static String map2json(Object object) {
//			JSONObject jsonObject = JSONObject.fromObject(object);
//			return jsonObject.toString();
//		}
//		/***
//		 * 将对象转换为HashMap
//		 * 
//		 * @param object
//		 * @return
//		 */
//		public static HashMap toHashMap(Object object) {
//			HashMap<String, Object> data = new HashMap<String, Object>();
//			JSONObject jsonObject = JSONObject.fromObject(object);
//			Iterator it = jsonObject.keys();
//			while (it.hasNext()) {
//				String key = String.valueOf(it.next());
//				Object value = jsonObject.get(key);
//				data.put(key, value);
//			}
//
//			return data;
//		}
//}
//
