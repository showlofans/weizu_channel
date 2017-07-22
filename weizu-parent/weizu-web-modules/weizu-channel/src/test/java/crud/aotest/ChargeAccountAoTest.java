package crud.aotest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.web.agency.ao.ChargeAccountAo;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class ChargeAccountAoTest {
	
	@Resource
	private ChargeAccountAo chargeAccountAo;
//	
//	 @Test
//	 public void testCreateAccount(){
//		 ChargeAccountPo cap = new ChargeAccountPo();
//		 cap.setAgencyId(1);
//		 cap.setRemittanceBankAccount("21564152465452");
//		 chargeAccountAo.createAccount(cap);
//	 }
//	@Test
//	public void testupdateByAgencyId(){
//		 ChargeAccountPo cap = new ChargeAccountPo();
//		 cap.setRemittanceWay("建行");
//		 cap.setAgencyId(4);
//		int res = chargeAccountAo.updateAccount(cap);
//		System.out.println(res);
//	}
	
//	@Test
//	public void testGetUnconfirmedAccount(){
//		List<CompanyCredentialsPo> list = chargeAccountAo.getUnconfirmedAccount(4);
//		System.out.println(list.size());
//	}

}
