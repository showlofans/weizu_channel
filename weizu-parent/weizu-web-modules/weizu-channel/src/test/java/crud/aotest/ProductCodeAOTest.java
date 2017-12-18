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
//import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
//import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
//import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ProductCodeAOTest {
//	
//	@Resource
//	private ProductCodeAO productCodeAO;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
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
////	@Deprecated
////	@Test
////	public void testinitPgList(){
////		List<OperatorPgDataPo> pgList = productCodeAO.initPgList(13, 0, 0);
////		if (pgList != null) {
////			System.out.println(pgList.size());
////		}
////	}
////	@Test
////	public void testselectByPrimaryKey(){
////		ProductCodePo productPo = productCodeDAO.selectByPrimaryKey(349l);
////		if(productPo != null){
////			System.out.println(productPo.getPgValidity() + "\tserviceType=" + productPo.getServiceType()+ "\tcode=" + productPo.getScopeCityCode());
////		}else{
////			System.out.println("1");
////		}
////	}
//	@Test
//	public void testGetOneByPg(){
//		ProductCodePo productPo = productCodeAO.getOneProductCodeByPg(50);
//		if(productPo != null){
//			System.out.print(productPo.getPgValidity() + "\tserviceType=" + productPo.getServiceType());
//			System.out.println(productPo.getProductCode() + "\t id=" + productPo.getId());
//		}else{
//			System.out.println("1");
//		}
//	}
//}
