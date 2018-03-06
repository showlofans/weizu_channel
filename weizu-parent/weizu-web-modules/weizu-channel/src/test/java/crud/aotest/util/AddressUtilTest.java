//package crud.aotest.util;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.util.AddressUtils;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class AddressUtilTest {
//	@Resource
//	private AddressUtils addressUtils;
//	
//	@Test
//	public void testGetAddress(){
//		String addressMap="";
//		try {
//			addressMap = addressUtils.getAddresses("ip=59.52.204.193", "utf-8");
//			System.out.println(addressMap);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
//	
//}
