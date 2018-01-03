//package crud.aotest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
//import com.weizu.flowsys.web.agency.ao.CompanyReferenceAO;
//import com.weizu.flowsys.web.agency.dao.CompanyReferenceDao;
//import com.weizu.flowsys.web.agency.pojo.CompanyReferencePo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class CompanyReferenceAIOTest {
//	
//	@Resource
//	private CompanyReferenceDao companyReferenceDao;
//	@Resource
//	private CompanyReferenceAO companyReferenceAO;
//	
////	@Test
////	public void testAdd(){
////		String crmForwardDesc = "crmForwardDesc";
////		String crmBackwardDesc = "crmBackwardDesc";
////		int res = companyReferenceDao.add(new CompanyReferencePo("河南趣闻", crmForwardDesc, crmBackwardDesc, "河南趣闻", AgencyTagEnum.DATA_USER.getValue(), System.currentTimeMillis()));
////		System.out.println(res);
////	}
//	@Test
//	public void testList(){
////		CompanyReferencePo crmPo = new CompanyReferencePo();
//		Map<String,Object> params = new HashMap<String,Object>();
////		params.put("crmName", "河南趣闻");
//		List<CompanyReferencePo> list = companyReferenceDao.listCRM(params);
//		for (CompanyReferencePo companyReferencePo : list) {
//			System.out.println(companyReferencePo.getCrmBackwardDesc());
//		}
//	}
//	
//	
//}
