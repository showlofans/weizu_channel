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
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
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
	 * @description:聚合数据 
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

}
