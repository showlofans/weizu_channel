//package crud.aotest;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletContext;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.alibaba.fastjson.JSONArray;
//import com.weizu.flowsys.util.CreateFileUtil;
//import com.weizu.flowsys.web.channel.dao.IProcincesDAO;
//import com.weizu.flowsys.web.channel.pojo.Provinces;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ProvincesDAOTest {
//	
//	@Resource
//	private IProcincesDAO procincesDAO;
//	
////	@Test
////	public void testGetList(){
////		List<Provinces> provinces = procincesDAO.getProvinces();
//////		int citiesNum = 0;
//////		for (Provinces provinces2 : provinces) {
//////			System.out.print("省份:" + provinces2.getProvince() + "\r城市：");
//////			List<Cities> cities = provinces2.getCities();
//////			for (Cities cities2 : cities) {
//////				System.out.print(cities2.getCity() + "\t");
//////			}
////////			System.out.println(JSON.toJSONString());
//////			System.out.println("\r");
//////			citiesNum += cities.size();
//////			
//////		}
//////		System.out.println(citiesNum);
////		
//////		System.out.println(JSON.toJSONString(provinces));
////		System.out.println(JSONArray.toJSONString(provinces));
////	}
//	/**
//	 * @description: 生成城市json库
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年11月10日 上午11:45:13
//	 */
//	@Test
//	public void testGetJsonFile(){
//		List<Provinces> provinces = procincesDAO.getProvinces();
//		String jsonStr = JSONArray.toJSONString(provinces);
////		System.out.println();
////		HttpSer
//		String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		System.out.println("path========" + filePath);
//		Boolean isCreated = CreateFileUtil.createJsonFile(jsonStr, filePath.substring(1)+"/WEB-INF", "cityData");
//		System.out.println(isCreated);
//		
//	}
//	
//}
