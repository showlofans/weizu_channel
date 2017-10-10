//package crud.aotest;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
//import com.weizu.flowsys.web.agency.dao.impl.ChargeAccountDao;
//import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ChargeAccountAoTest {
//	
//	@Resource
//	private ChargeAccountAo chargeAccountAO;
//	
//	@Resource
//	private ChargeAccountDao chargeAccountDao;
////	
////	 @Test
////	 public void testCreateAccount(){
////		 ChargeAccountPo cap = new ChargeAccountPo();
////		 cap.setAgencyId(1);
////		 cap.setRemittanceBankAccount("21564152465452");
////		 chargeAccountAo.createAccount(cap);
////	 }
////	@Test
////	public void testupdateByAgencyId(){
////		 ChargeAccountPo cap = new ChargeAccountPo();
////		 cap.setRemittanceWay("建行");
////		 cap.setAgencyId(4);
////		int res = chargeAccountAo.updateAccount(cap);
////		System.out.println(res);
////	}
//	
////	@Test
////	public void testGetUnconfirmedAccount(){
////		List<CompanyCredentialsPo> list = chargeAccountAo.getUnconfirmedAccount(4);
////		System.out.println(list.size());
////	}
//	/**
//	 * @description: 查询父级代理商的相关账户
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年8月3日 下午4:21:35
//	 */
////	@Test
////	public void testGetAccountByAgencyId(){
////		ChargeAccountPo accouontPo = chargeAccountDao.selectRootAccountByAgencyId(21, 0);
////		System.out.println(accouontPo.getAccountBalance());
////	}
//	@Test
//	public void getRootAccountById(){
//		ChargeAccountPo accouontPo = chargeAccountDao.getRootAccountById(2, 0);
//		System.out.println(accouontPo.getAccountBalance());
//	}
//
//}
