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
//import com.aiyi.base.pojo.PageParam;
//import com.weizu.flowsys.util.Pagination;
//import com.weizu.flowsys.web.channel.ao.TelProductAO;
//import com.weizu.flowsys.web.channel.dao.ITelProductDao;
//import com.weizu.flowsys.web.channel.pojo.TelProductPo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class TelProductAOTest {
//	@Resource
//	private TelProductAO telProductAO;
//	
//	@Resource
//	private ITelProductDao telProductDao;
//	
//	@Test
//	public void testList(){
//		Pagination<TelProductPo> pagination = telProductAO.listTelProduct(new TelProductPo(), new PageParam(1l,10));
//		List<TelProductPo> telProductList =  pagination.getRecords();
//		for (TelProductPo telProductPo : telProductList) {
//			System.out.println(telProductPo.getCity() + ":" + telProductPo.getProvince());
//		}
//	}
//}
