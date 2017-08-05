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
//import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
//import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ProductCodeAOTest {
//	
//	@Resource
//	private ProductCodeAO productCodeAO;
//	
////	@Test
////	public void testGetproductCode(){
////		
////		List<ProductCodePo> list = productCodeAO.getProductCode(null, null).getRecords();
////		System.out.println(list.size());
////	}
////	@Test
////	public void testGetOneProductCode(){
////		ProductCodePo  po = productCodeAO.getOneProductCode(new OneCodePo("14", 6144, 0, 0));
////		if(po != null){
////			System.out.println(po.getProductCode());
////		}
////	}
//	@Test
//	public void testinitPgList(){
//		List<OperatorPgDataPo> pgList = productCodeAO.initPgList(13, 0, 0);
//		if (pgList != null) {
//			System.out.println(pgList.size());
//		}
//	}
//}
