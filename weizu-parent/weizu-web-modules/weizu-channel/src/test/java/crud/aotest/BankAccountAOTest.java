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
//
//import com.weizu.flowsys.web.agency.ao.BankAccountAO;
//import com.weizu.flowsys.web.agency.pojo.BankAccountPo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class BankAccountAOTest {
//	
//	@Resource
//	private BankAccountAO bankAccountAO;
//	
//	@Test
//	public void getBankList(){
//		Map<String,Object> resultMap = new HashMap<String,Object>();
//		bankAccountAO.getBankList(1, resultMap);
//		List<BankAccountPo> bankList = (List<BankAccountPo>) resultMap.get("bankList");
//		System.out.println(bankList.size());
//	}
//}
