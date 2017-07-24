package crud.aotest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.operatorPg.enums.ConfirmStateEnum;
import com.weizu.flowsys.web.agency.ao.CompanyCredentialsAO;
import com.weizu.flowsys.web.agency.pojo.CompanyCredentialsPo;

/**
 * @description:
 * @projectName:weizu-channel
 * @className:CompanyCredentialsAOImplTest.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月21日 下午3:20:51
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class CompanyCredentialsAOImplTest {
	@Resource
	private CompanyCredentialsAO companyCredentialsAO; 
	
//	@Test
//	public void testAddCompanyCredential(){
//		CompanyCredentialsPo ccpo = new CompanyCredentialsPo(21, 4, ConfirmStateEnum.INCOMPLETE_CONFIRM.getValue());
//		ccpo.setCompanyName("南昌微族科技");
//		ccpo.setCorporateIdentityBack("/upload/credentials/123/idBack.jpg");
//		String res = companyCredentialsAO.addCompanyCredential(ccpo);
//		System.out.println(res);
//	}
	@Test
	public void testUpdateCompanyCredential(){
		CompanyCredentialsPo ccpo = new CompanyCredentialsPo();
//		ccpo.setCommitTime(System.currentTimeMillis());
		ccpo.setConfirmTime(System.currentTimeMillis());
		ccpo.setId(2);
		companyCredentialsAO.updateCompanyCredential(ccpo);
	}
}
