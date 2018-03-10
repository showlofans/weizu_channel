//package crud.aotest.util;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
//import com.weizu.flowsys.web.channel.pojo.PgDataPo;
//import com.weizu.flowsys.web.http.ao.ValiUser;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ValiUserTest {
//	@Resource
//	private ValiUser valiUser;
//	@Test
//	public void testFindPg(){
//		PgDataPo pgDataPo = valiUser.findPg(new PgDataPo(OperatorTypeEnum.MOBILE.getValue(),  1024, ServiceTypeEnum.PROVINCE_ROAMING.getValue(), PgServiceTypeEnum.PGCHARGE.getValue(), "30",ChannelTypeEnum.ORDINARY.getValue()));
//		System.out.println(pgDataPo != null);
//	}
//}
