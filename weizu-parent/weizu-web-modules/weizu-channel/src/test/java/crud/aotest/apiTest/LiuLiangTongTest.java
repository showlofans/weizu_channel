//package crud.aotest.apiTest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;
//import com.weizu.web.foundation.http.HttpRequest;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class LiuLiangTongTest {
//
//	@Test
//	public void testGetProduct(){
//		StringBuffer sbparam = new StringBuffer();
//		sbparam.append("v=H1.0&action=getPackage&account=");
//		sbparam.append("kehu");
//		sbparam.append("&password=");
//		sbparam.append("my123456");
//		String jsonStr = HttpRequest.sendPost("http://114.215.241.61:8083/telapi.aspx", sbparam.toString());
//		paraseResult(jsonStr);
//	}
//	
//	private void paraseResult(String resultStr){
//		try {  
//	        JSONObject obj = JSON.parseObject(resultStr);
//	        System.out.println(obj);
//	        int tipCode = obj.getIntValue("Code");
//	        String tipMsg = obj.getString("Message");
//	        //JSONObject obj2 = obj.getJSONObject("Packages");
//	        JSONArray array = obj.getJSONArray("Packages");
//	        for (Object object : array) {
//	        	JSONObject jsonObj = (JSONObject)object;
//	        	String name = jsonObj.getString("Name");
//	        	System.out.println(name);
//			}
//	        //JSONObject obj2 = JSON.parseObject(packages);
//		    // 最后输出到控制台  
//	        System.out.println(tipCode+"<--->"+tipMsg);  
//		
//	    } catch (JSONException e) {  
//	        e.printStackTrace();  
//	    }  
//	}
//	
//	//	param.put("clientId",10000);
//////param.put("merchant",10210);
//////param.put("sign",sign);
//////param.put("ts",ts);
//////param.put("version","V100");
//////System.out.println(param.toString());
//////String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//}
