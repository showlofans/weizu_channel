//package crud.aotest.apiTest.hua;
//
//import java.io.UnsupportedEncodingException;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.weizu.api.util.HttpRequest;
//
//import com.weizu.flowsys.api.hsingleton.TelBaseInterface;
//import com.weizu.flowsys.util.StringUtil2;
//import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
//import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
//import com.weizu.web.foundation.MD5;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class UnicomAyncTest {
//	@Resource
//	private ExchangePlatformAO exchangePlatformAO;
//	
////	public static void main(String[] args) {
////		
////	}
//	@Test
//	public void getBalance(){
//		ExchangePlatformPo epPo = exchangePlatformAO.getEpByEpName("连城连");
////		String requestUrl = epPo.getEpPurchaseIp();
//		String requestUrl = epPo.getEpBalanceIp();
//		String privateKey = epPo.getEpApikey();
//		String userId = epPo.getEpOtherParams();
////		userId = StringUtil2.getParamsByCharSeq(userId, "userId");
//		userId = userId.substring(userId.indexOf("=")+1,userId.indexOf("&"));
//		
//		
//		String signStr = userId + privateKey;
////		System.out.println(userId);
//		System.out.println("签名串："+signStr);
//		
////		String signStr = "20170807145557102119147208558113964888095123550e8400e29b41d4a716446655440000"; 
//		String sign = null;
//		try {
//			sign = MD5.getMd5(signStr,MD5.LOWERCASE,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		System.out.println("签名："+sign+"\t签名长度："+sign.length());
////		System.out.println("e000cb78b4bcb9b5c56cc146e2059fac".equals(sign));
//		String params = "userId="+userId+"&sign="+sign;
//    	String jsonStr = HttpRequest.sendGet(requestUrl, params);
//		System.out.println(jsonStr);
//	}
////	@Test
////	public void testChargeTel(){
////		
////	}
//	
//}
