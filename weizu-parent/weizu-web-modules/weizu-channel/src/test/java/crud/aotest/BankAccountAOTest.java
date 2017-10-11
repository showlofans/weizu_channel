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
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.web.agency.ao.BankAccountAO;
//import com.weizu.flowsys.web.agency.dao.BankAccountDaoInterface;
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
//	@Resource
//	private BankAccountDaoInterface bankAccountDao;
//	
////	@Test
////	public void getMyBankList(){
////		Map<String,Object> resultMap = new HashMap<String,Object>();
////		bankAccountAO.getMyBankList(1, resultMap);
////		List<BankAccountPo> bankList = (List<BankAccountPo>) resultMap.get("bankList");
////		System.out.println(bankList.size());
////	}
//	@Test
//	public void getAttachBankList(){
//		Map<String,Object> resultMap = new HashMap<String,Object>();
//		bankAccountAO.getAttachBankList(61, 1, resultMap);
//		List<BankAccountPo> unattachList = (List<BankAccountPo>) resultMap.get("unattachList");
//		List<BankAccountPo> attachList = (List<BankAccountPo>) resultMap.get("attachList");
//		System.out.println(unattachList.size());
//		System.out.println(attachList.size());
//	}
////	@Test
////	public void existBankPo(){
////		BankAccountPo bankPo = bankAccountDao.get(new WherePrams("agency_id", "=", 1).and("account_id", "=", 61).and("remittance_bank_account", "=", 123));
////		System.out.println(bankPo == null ? "Kong":bankPo.getRemittanceBankAccount());
////	}
//}
