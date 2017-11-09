//package crud.aotest;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.web.channel.dao.IProcincesDAO;
//import com.weizu.flowsys.web.channel.pojo.Cities;
//import com.weizu.flowsys.web.channel.pojo.Provinces;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ProvincesDAOTest {
//	
//	@Resource
//	private IProcincesDAO procincesDAO;
//	
//	@Test
//	public void testGetList(){
//		List<Provinces> provinces = procincesDAO.getProvinces();
//		int citiesNum = 0;
//		for (Provinces provinces2 : provinces) {
//			System.out.print("省份:" + provinces2.getProvince() + "\r城市：");
//			List<Cities> cities = provinces2.getCities();
//			for (Cities cities2 : cities) {
//				System.out.print(cities2.getCity() + "\t");
//			}
////			System.out.println(JSON.toJSONString());
//			System.out.println("\r");
//			citiesNum += cities.size();
//			
//		}
//		System.out.println(citiesNum);
////		System.out.println(JSON.toJSONString(provinces));
//	}
//	
//}
