//package crud.aotest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.weizu.web.foundation.MD5;
//import org.weizu.web.foundation.http.HttpRequest;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class APITest {
//	
//	@Test
//	public void testAccountAPI(){
//		String requestUrl = "http://139.224.70.161:32001/api/v1/getBalance";
//		String username = "CS111111";
//		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
//		String sign = MD5.getMd5("username="+username+"&apikey="+ apikey);
//		String params = "username="+username+"&sign="+ sign;
//		String resultStr = HttpRequest.sendGet(requestUrl, params);
//		System.out.println(resultStr);
//	}
////	@Test
////	public void testChargeAPI(){
////		String requestUrl = "http://127.0.0.1:8080/weizuAPI/chargePg.do";
////		String sign = MD5.getMd5("402880ef5cd2b925015cd2b925b90000");
////		String params = "userName=456&number=15858343638&pgSize=6144&scope=0&sign="+ sign;
////		String resultStr = HttpRequest.sendGet(requestUrl, params);
////		System.out.println(resultStr);
////	}
////	@Test
////	public void testOrderStateAPI(){
////		String requestUrl = "http://127.0.0.1:8080/weizuAPI/myOrderState.do";
////		String sign = MD5.getMd5("402880ef5cd2b925015cd2b925b90000");
////		String params = "userName=456&sign="+ sign+"&orderId=705162055119802368&number=15858343638";
////		String resultStr = HttpRequest.sendGet(requestUrl, params);
////		System.out.println(resultStr);
////	}
//}
