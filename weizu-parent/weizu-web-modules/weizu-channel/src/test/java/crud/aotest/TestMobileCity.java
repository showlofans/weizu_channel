package crud.aotest;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.weizu.web.foundation.http.HttpRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestMobileCity {

      
//    //得到归属地  
//    public static String getCity(String tel) {  
//        //获取返回结果  
//        String json = httpRequest(tel).toString();  
//        //拆分xml页面代码  
//        String[] a = json.split("city");  
//        //得到归属地  
//        String city = a[1].replace(">", "").replace("</", "");  
//        return city;  
//    }  
//      
//    //得到运营商  
//    public static String getCarrier(String tel) {  
//  
//        //获取返回结果  
//        String json = httpRequest(tel).toString();  
//        //拆分xml页面代码  
//        String[] a = json.split("city");  
//        String[] b = a[1].split("supplier");  
//        //得到运营商  
//        String carrier = b[0].replace(">", "").replace("</", "");  
//        return carrier;  
//    }  
//      
//    /**  
//    * 发起http请求获取返回结果  
//    * @param tel 待查询手机号  
//    * @return String 结果字符串  
//    */  
//    public static String httpRequest(String tel) {  
//          
//        //组装查询地址(requestUrl 请求地址)  
//        String requestUrl = "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="+tel;  
//        StringBuffer buffer = new StringBuffer();  
//        try {  
//            URL url = new URL(requestUrl);  
////            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
////            httpUrlConn.setDoOutput(false);  
////            httpUrlConn.setDoInput(true);  
////            httpUrlConn.setUseCaches(false);  
////            httpUrlConn.setRequestMethod("GET");  
//            InputStream in = url.openStream();
////            httpUrlConn.connect();  
////            //将返回的输入流转换成字符串  
////            InputStream inputStream = httpUrlConn.getInputStream();  
//            InputStreamReader inputStreamReader = new InputStreamReader(in, "GBK");  
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
//              
//            String str = null;  
//            while ((str = bufferedReader.readLine()) != null) {  
//                buffer.append(str);  
//            }  
//            bufferedReader.close();  
//            in.close();  
//            //释放资源  
////            inputStream.close();  
////            inputStream = null;  
////            httpUrlConn.disconnect();  
//        }  
//        catch (Exception e) {  
//            return "发起http请求后，获取返回结果失败！";  
//        }  
//        return buffer.toString();  
//    }  
//    public static void testJson(){
//    	JSONArray obj = (JSONArray)JSONObject.parse("['bestChannelPo','errorMsg','error']");
//		System.out.println(obj.get(0));
//    }
//    public static void testMobile(){
//    	System.out.println(TestMobileCity.httpRequest("18729293693"));
//    }
//    /**
//     * @description:获取小数究竟有几位
//     * @param s
//     * @author:POP产品研发部 宁强
//     * @createTime:2017年5月19日 下午12:38:36
//     */
//    public static void testFloat(String s){
//    	int size = s.trim().length()-s.indexOf(".")-1;
//    	System.out.println(size);
//    	System.out.println(s.indexOf("."));
//    	if(size ==2){
//    		
//    	}
////    	int position = s.length() -  + 1;
////    	System.out.println(position);
//    }
//    
	public static void main(String[] args) throws IOException {
		URL u=new URL("http://api.k780.com/?app=phone.get&phone=13699562589&appkey=26408&sign=39c448bd783fea5ecbe7a1047b3c5113&format=json");
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
        String res = new String(b,"utf-8");
        System.out.println(res);
        JSONObject jsonObj = JSON.parseObject(res);
       String result = jsonObj.get("result").toString();
       String status = JSON.parseObject(result).get("status").toString();
       if("ALREADY_ATT".equals(status))
       {
    	   System.out.println("有归属地");
       }else if("NOT_ATT".equals(status)){
    	   System.out.println(JSON.parseObject(result).get("msg").toString());
    	   //暂无相关归属地信息
       }else{
    	   System.out.println(1);
       }
       String att = JSON.parseObject(result).get("att").toString();
       String operators = JSON.parseObject(result).get("operators").toString();
       String[] atts = att.split(",");//
	   String otype = operators.substring(2); //去掉中国得到移动两字
	   String chargeDetail = atts[1] + otype;//省份和运营商（地区）
      System.out.println(chargeDetail);
      System.out.println(atts[atts.length-1]);//城市
       
//       System.out.println(JSON.parseObject(result).get("style_citynm").toString());//中华人民共和国,江西省,南昌市
//       System.out.println(JSON.parseObject(result).get("att").toString());//中国,江西,南昌
//       System.out.println(JSON.parseObject(result).get("operators").toString());//中国移动
//       
       
//       String city = JSON.parseArray(res).parseObject("result").get("att").toString();
       
//       System.out.println(result);
//       System.out.println(city);
    }
		
//		try {
//			String jsonStr = HttpRequest.sendGet("http://www.ip138.com:8080/search.asp","action=mobile&mobile=13888888888");
//			System.out.println(jsonStr);
//			
////			String ajax = httpRequest("13699562589");
////			System.out.println(ajax);
//////			JSONObject json =  (JSONObject) JSON.parse(ajax);
//////			String province = json.get("province").toString();
//////			  
//////			for(int i = 0; i< 1000 ; i++){
//////				
//////				System.out.println(OrderUril.getIntegerOrder());
//////			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

}
