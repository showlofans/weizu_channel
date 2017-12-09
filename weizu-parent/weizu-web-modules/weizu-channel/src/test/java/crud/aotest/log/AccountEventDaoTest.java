//package crud.aotest.log;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.operatorPg.enums.EventTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.LoginStateEnum;
//import com.weizu.flowsys.web.log.AccountEventPo;
//import com.weizu.flowsys.web.log.ao.AccountEventAO;
//import com.weizu.flowsys.web.log.dao.IAccountEventDao;
//
///**
// * @description: 日志测试类
// * @projectName:weizu-channel
// * @className:AccountEventDaoTest.java
// * @author:微族通道代码设计人 宁强
// * @createTime:2017年12月8日 下午5:21:42
// * @version 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class AccountEventDaoTest {
//	@Resource
//	private IAccountEventDao accountEventDao;
//	@Resource
//	private AccountEventAO accountEventAO;
//	
//	@Test
//	public void testLogin(){
//		//得到上一次的登陆日志
//		WherePrams where = new WherePrams("agency_id", "=", 2).and("event_state", "=", LoginStateEnum.ING.getValue());
//		where.orderBy("event_time",WherePrams.DESC);
//		where.limit(0, 1);
//		AccountEventPo eventPo = accountEventDao.get(where);
//		if(eventPo != null){
//			System.out.println(eventPo.getEventLocation());
//		}else{
//			eventPo = new AccountEventPo(2, EventTypeEnum.AGENCY_LOGIN.getValue(), System.currentTimeMillis(), "南昌", "120.55.162.224", LoginStateEnum.ING.getValue());
//			System.out.println("123");
//			accountEventDao.add(eventPo);
//		}
//	}
//	@Test
//	public void testUpdate(){
//		int res = accountEventAO.updateLastByAgency(2, EventTypeEnum.AGENCY_LOGIN.getValue(), LoginStateEnum.ED.getValue());	
//		System.out.println(res);
//		}
//}
