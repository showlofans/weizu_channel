package com.weizu.flowsys.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.weizu.web.foundation.String.StringHelper;

/**
 * 根据IP地址获取详细的地域信息
 * 
 * @project:personGocheck
 * @class:AddressUtils.java
 * @author:heguanhua E-mail:37809893@qq.com
 * @date：Nov 14, 2012 6:38:25 PM
 */
/**
 * @description: 根据IP地址获取详细的地域信息
 * @projectName:weizu-channel
 * @className:AddressUtils.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月7日 上午9:07:30
 * @version 1.0
 */
@Service(value="addressUtils")
public class AddressUtils {
	/**
	 *
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encoding
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getAddresses(String content, String encodingString)
			throws UnsupportedEncodingException {
		// 这里调用pconline的接口
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		// 从http://whois.pconline.com.cn取得IP所在的省市区信息
		String returnStr = this.getResult(urlStr, content, encodingString);
		if (returnStr != null) {
			// 处理返回的省市区信息
			System.out.println(returnStr);
			String[] temp = returnStr.split(",");
			if (temp.length < 3) {
				return "0";// 无效IP，局域网测试
			}
			String region = (temp[5].split(":"))[1].replaceAll("\"", "");
			region = decodeUnicode(region);// 省份

			String country = "";
			String area = "";
			// String region = "";
			String city = "";
			String county = "";
			String isp = "";
			for (int i = 0; i < temp.length; i++) {
				switch (i) {
				case 1:
					country = (temp[i].split(":"))[2].replaceAll("\"", "");
					country = decodeUnicode(country);// 国家
					break;
				case 3:
					area = (temp[i].split(":"))[1].replaceAll("\"", "");
					area = decodeUnicode(area);// 地区
					break;
				case 5:
					region = (temp[i].split(":"))[1].replaceAll("\"", "");
					region = decodeUnicode(region);// 省份
					break;
				case 7:
					city = (temp[i].split(":"))[1].replaceAll("\"", "");
					city = decodeUnicode(city);// 市区
					break;
				case 9:
					county = (temp[i].split(":"))[1].replaceAll("\"", "");
					county = decodeUnicode(county);// 地区
					break;
				case 11:
					isp = (temp[i].split(":"))[1].replaceAll("\"", "");
					isp = decodeUnicode(isp); // ISP公司
					break;
				}
			}

//			System.out.println(country + "=" + area + "=" + region + "=" + city
//					+ "=" + county + "=" + isp);
			return city;
		}
		return null;
	}

	/**
	 * @param urlStr
	 *            请求的地址
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encoding
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return
	 */
	private String getResult(String urlStr, String content, String encoding) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// 新建连接实例
			connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
			connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
			connection.setDoOutput(true);// 是否打开输出流 true|false
			connection.setDoInput(true);// 是否打开输入流true|false
			connection.setRequestMethod("POST");// 提交方法POST|GET
			connection.setUseCaches(false);// 是否缓存true|false
			connection.connect();// 打开连接端口
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());// 打开输出流往对端服务器写数据
			out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
			out.flush();// 刷新
			out.close();// 关闭输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
			// ,以BufferedReader流来读取
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();// 关闭连接
			}
		}
		return null;
	}

	/**
	 * unicode 转换成 中文
	 *
	 * @author fanhui 2007-3-15
	 * @param theString
	 * @return
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	// 测试
//	public static void main(String[] args) {
//		AddressUtils addressUtils = new AddressUtils();
//		// 测试ip 219.136.134.157 中国=华南=广东省=广州市=越秀区=电信
//		String ip = "106.4.247.116";// 120.55.162.224
//		String address = "";
//		try {
//			address = addressUtils.getAddresses("ip=" + ip, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(address);
//		// 输出结果为：广东省,广州市,越秀区
//	}
	
	/**
	 * @description: 根据客户端请求获得相应编码的城市信息
	 * @param request
	 * @param encodingString
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月7日 上午9:19:54
	 */
	public Map<String,Object> getAddresses(HttpServletRequest request,String encodingString){
		Map<String,Object> locMap = new HashMap<String, Object>();
		if(StringHelper.isEmpty(encodingString)){
			encodingString = "utf-8";
		}
		String address = "";
		try {
			String ip = getIp(request);
//			String ip = request.getAttribute("X-real-ip").toString();
			locMap.put("ip", ip);
			
			address = getAddresses("ip=" + ip, encodingString);
			if(StringHelper.isNotEmpty(address)){
				locMap.put("address", address);
			}else{
				locMap.put("address", "未找到该地区");
			}
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return locMap;
	}
	/**
	 * @description:   根据客户端请求获得客户端ip
	 * @param request
	 * @return
	 * @throws Exception
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月7日 上午9:24:59
	 */
	public String getIp(HttpServletRequest request) throws Exception {
	    String ip = request.getHeader("X-Forwarded-For");
	    if (ip != null) {
	        if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
	            int index = ip.indexOf(",");
	            if (index != -1) {
	                return ip.substring(0, index);
	            } else {
	                return ip;
	            }
	        }
	    }
	    ip = request.getHeader("X-Real-IP");
	    if (ip != null) {
	        if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	    }
	    ip = request.getHeader("Proxy-Client-IP");
	    if (ip != null) {
	        if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	    }
	    ip = request.getHeader("WL-Proxy-Client-IP");
	    if (ip != null) {
	        if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	    }
	    ip =  request.getRemoteAddr();
	    return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
}
