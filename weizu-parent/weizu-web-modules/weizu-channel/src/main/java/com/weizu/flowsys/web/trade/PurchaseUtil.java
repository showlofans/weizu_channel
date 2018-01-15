package com.weizu.flowsys.web.trade;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.String.StringHelper;

public class PurchaseUtil {
	
	/**
	 * @description: 通过归属地得到地区信息
	 * @param carrier
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月17日 上午11:44:29
	 */
	public static Map<String, Object> getScopeCityByCarrier(String carrier){
		if(carrier != null){
		for ( Map<String,Object> map : ScopeCityEnum.toList()) {
				if (map.get("desc").toString().contains(carrier.substring(0,carrier.length()-2))) {
					Map<String, Object> resultMap = new HashMap<String, Object>(); 
					resultMap.put("scopeCityCode", map.get("value").toString());
					resultMap.put("scopeCityName", map.get("desc").toString());
					return resultMap;
				}
			}
		}
		return null;
	}
	/**
	 * @description: 通过手机号查运营商归属地（NOW api）
	 * @param telphone
	 * @return
	 * @author:POP产品研发部 宁强
	 * @throws IOException 
	 * @createTime:2017年6月24日 下午3:09:48
	 */
//	public static Map<String, Object> getOperatorsByTel(String telphone){
//		String res = null;
//		try {
//			URL u=new URL("http://api.k780.com/?app=phone.get&phone="+telphone+"&appkey=26408&sign=39c448bd783fea5ecbe7a1047b3c5113&format=json");
//			InputStream in=u.openStream();
//			ByteArrayOutputStream out=new ByteArrayOutputStream();
//			try {
//			    byte buf[]=new byte[1024];
//			    int read = 0;
//			    while ((read = in.read(buf)) > 0) {
//			        out.write(buf, 0, read);
//			    }
//			}  finally {
//			    if (in != null) {
//			        in.close();
//			    }
//			}
//			byte b[]=out.toByteArray( );
//			res = new String(b,"utf-8");
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if(StringHelper.isEmpty(res)){
//			return null;
//		}
//		JSONObject jsonObj = JSON.parseObject(res);
//        
//       String result = jsonObj.get("result").toString();
//       String status = JSON.parseObject(result).get("status").toString();
//       
//       if("NOT_ATT".equals(status)){//没有归属地
//    	   System.out.println(JSON.parseObject(result).get("msg").toString()); //暂无相关归属地信息
//    	   return null;
//       }else
//       {
//    	   Map<String, Object> resMap = new HashMap<String, Object>();
//    	   String att = JSON.parseObject(result).get("att").toString();
//           String operators = JSON.parseObject(result).get("operators").toString();
//           String[] atts = att.split(",");//
//    	   String otype = operators.substring(2); //去掉中国得到移动两字
//    	   String chargeDetail = atts[1] + otype;//省份和运营商（地区）
//           //获得运营商编码
//    	   for (Map<String, Object> typeMap : OperatorTypeEnum.toList()) {
//    		   if(otype.equals(typeMap.get("desc").toString()))
//    		   {
//    			   String otypeInt = typeMap.get("value").toString();
//    			   resMap.put("operatorType", otypeInt);//编码
//    			   resMap.put("scopeName", atts[1]);//省份
//    		   }
//    	   }
//           resMap.put("chargeTelDetail", chargeDetail);//归属地
//           resMap.put("chargeTelCity", atts[atts.length-1]);//城市
//           return resMap;
//       }
//       
//	}
	/**
	 * @description:聚合数据 -获得号码归属地
	 * <br>https://www.juhe.cn/docs/api/id/11
	 * @param telphone
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月8日 下午4:01:58
	 */
	public static Map<String, Object> getOperatorsByTel(String telphone){
		String res = null;
		try {
			//聚合appkey 59b0973a9e6d8642b987ac04c1eb2c07
			URL u=new URL("http://apis.juhe.cn/mobile/get?phone="+telphone+"&key=59b0973a9e6d8642b987ac04c1eb2c07");
			InputStream in=u.openStream();
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			try {
				byte buf[]=new byte[1024];
				int read = 0;
				while ((read = in.read(buf)) > 0) {
					out.write(buf, 0, read);
				}
			}  finally {
				if (in != null) {
					in.close();
				}
			}
			byte b[]=out.toByteArray( );
			res = new String(b,"utf-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(StringHelper.isEmpty(res)){
			return null;
		}
		JSONObject jsonObj = JSON.parseObject(res);
		if(jsonObj.getIntValue("error_code")==0){
			Map<String, Object> resMap = new HashMap<String, Object>();
			String result = jsonObj.get("result").toString();//json里面获得json字符串
//			System.out.println(result);
			JSONObject resultObj = JSON.parseObject(result);
			
			//可能为空
//			String zip = resultObj.get("zip").toString();
//			String areacode = resultObj.get("areacode").toString();
//			String card = resultObj.get("card").toString();
			String province = resultObj.get("province").toString();
			resMap.put("scopeName", province);//省份
			
			String company = resultObj.get("company").toString();
			String chargeDetail = province + company;//省份和运营商（地区）
			resMap.put("chargeTelDetail", chargeDetail);//归属地
//			//获得运营商编码
			for (Map<String, Object> typeMap : OperatorTypeEnum.toList()) {
				if(typeMap.get("desc").toString().equals(company))
				{
					String otypeInt = typeMap.get("value").toString();
					resMap.put("operatorType", otypeInt);//编码
				}
			}
			
			String city = resultObj.get("city").toString();
			//直辖市用省份名称代替
			if(StringHelper.isNotEmpty(city)){
				resMap.put("chargeTelCity", city);//城市
			}else{
				resMap.put("chargeTelCity", province);//城市
			}
			return resMap;
        }else{
            System.out.println(jsonObj.get("error_code")+":"+jsonObj.get("reason"));
            return null;
        }
	}
	/**
	 * @description:随机多条获得笑话数据
	 * @param telphone
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月15日 下午4:05:30
	 */
//	public static Map<String, Object> getJokeByRand(String urlShufix){
//		String res = null;
//		try {
//			URL u=new URL(urlShufix);
//			InputStream in=u.openStream();
//			ByteArrayOutputStream out=new ByteArrayOutputStream();
//			try {
//				byte buf[]=new byte[1024];
//				int read = 0;
//				while ((read = in.read(buf)) > 0) {
//					out.write(buf, 0, read);
//				}
//			}  finally {
//				if (in != null) {
//					in.close();
//				}
//			}
//			byte b[]=out.toByteArray( );
//			res = new String(b,"utf-8");
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if(StringHelper.isEmpty(res)){
//			return null;
//		}
//		JSONObject jsonObj = JSON.parseObject(res);
////		System.out.println(res);
//		if(jsonObj.getIntValue("error_code")==0){
//			Map<String, Object> resMap = new HashMap<String, Object>();
//			
//			JSONArray jsonArray = jsonObj.getJSONArray("result");
//			
//			for (Object object : jsonArray) {
//				JSONObject jsonObj2 = (JSONObject)object;
//				String content = jsonObj2.get("content").toString();
//				System.out.println(content);
//				String unixtime = jsonObj2.get("unixtime").toString();
////				System.out.println("unixTime:"+unixtime);
//				resMap.put("content", content);//内容
//				resMap.put("updateTime", DateUtil.format(Long.parseLong(unixtime)));//归属地
//			}
//			String result = jsonObj.get("result").toString();//json里面获得json字符串
//			System.out.println(result);
////			
//			return resMap;
//		}else{
//			System.out.println(jsonObj.get("error_code")+":"+jsonObj.get("reason"));
//			return null;
//		}
//	}
	/**
	 * @description:随机多条获得最新笑话数据
	 * @param telphone
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月15日 下午4:05:30
	 */
	public static Map<String, Object> getJokeForNow(String urlShufix){
		String res = null;
		try {
			URL u=new URL(urlShufix);
			InputStream in=u.openStream();
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			try {
				byte buf[]=new byte[1024];
				int read = 0;
				while ((read = in.read(buf)) > 0) {
					out.write(buf, 0, read);
				}
			}  finally {
				if (in != null) {
					in.close();
				}
			}
			byte b[]=out.toByteArray( );
			res = new String(b,"utf-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(StringHelper.isEmpty(res)){
			return null;
		}
		JSONObject jsonObj = JSON.parseObject(res);
//		System.out.println(res);
		if(jsonObj.getIntValue("error_code")==0){
			Map<String, Object> resMap = new HashMap<String, Object>();
			JSONObject jsonObj1 = jsonObj.getJSONObject("result");
			
			JSONArray jsonArray = jsonObj1.getJSONArray("data");
			
			for (Object object : jsonArray) {
				JSONObject jsonObj2 = (JSONObject)object;
				String content = jsonObj2.get("content").toString();
				System.out.println(content);
//				System.out.println("unixTime:"+unixtime);
				resMap.put("content", content);//内容
//				String unixtime = jsonObj2.get("unixtime").toString();
//				resMap.put("updateTime", DateUtil.format(Long.parseLong(unixtime)));//归属地
				String updatetime = jsonObj2.get("updatetime").toString();
				resMap.put("updatetime", updatetime);//归属地
				
			}
			String result = jsonObj.get("result").toString();//json里面获得json字符串
			System.out.println(result);
//			
			return resMap;
		}else{
			System.out.println(jsonObj.get("error_code")+":"+jsonObj.get("reason"));
			return null;
		}
	}
	/**
	 * @description:
	 * @param todayTime
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月15日 下午4:42:41
	 */
//	public static Map<String, Object> todayOnhistory(Long todayTime){
//		String res = null;
//		try {
//			String time = DateUtil.formatPramm(todayTime, "MM/dd");
//			System.out.println(time);
//			URL u=new URL("http://v.juhe.cn/todayOnhistory/queryEvent.php?key=22beb53e91875768a74c8161d2e4d981&date="+time);
//			InputStream in=u.openStream();
//			ByteArrayOutputStream out=new ByteArrayOutputStream();
//			try {
//				byte buf[]=new byte[1024];
//				int read = 0;
//				while ((read = in.read(buf)) > 0) {
//					out.write(buf, 0, read);
//				}
//			}  finally {
//				if (in != null) {
//					in.close();
//				}
//			}
//			byte b[]=out.toByteArray( );
//			res = new String(b,"utf-8");
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if(StringHelper.isEmpty(res)){
//			return null;
//		}
//		JSONObject jsonObj = JSON.parseObject(res);
////		System.out.println(res);
//		if(jsonObj.getIntValue("error_code")==0){
//			Map<String, Object> resMap = new HashMap<String, Object>();
//			JSONArray jsonArray = jsonObj.getJSONArray("result");
//			
//			for (Object object : jsonArray) {
//				JSONObject jsonObj2 = (JSONObject)object;
//				String day = jsonObj2.get("day").toString();
//				System.out.println(day);
//				String date = jsonObj2.get("date").toString();
//				System.out.println(date);
//				String title = jsonObj2.get("title").toString();
//				System.out.println(title);
//				String e_id = jsonObj2.get("e_id").toString();
//				System.out.println(e_id);
//			}
//			String result = jsonObj.get("result").toString();//json里面获得json字符串
//			System.out.println(result);
////			
//			return resMap;
//		}else{
//			System.out.println(jsonObj.get("error_code")+":"+jsonObj.get("reason"));
//			return null;
//		}
//	}
	
	

}
