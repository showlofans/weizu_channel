//package crud.aotest.log;
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
//import com.weizu.flowsys.operatorPg.enums.EventTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.LoginStateEnum;
//import com.weizu.flowsys.web.log.AccountEventPo;
//import com.weizu.flowsys.web.log.ao.AccountEventAO;
//import com.weizu.flowsys.web.log.dao.IAccountEventDao;
//import com.weizu.flowsys.web.trade.ao.ChargeLogAO;
//import com.weizu.flowsys.web.trade.dao.ChargeLogDao;
//import com.weizu.flowsys.web.trade.pojo.ChargeLog;
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
//public class ChargeLogDaoTest {
//	@Resource
//	private ChargeLogDao chargeLogDao;
//	@Resource
//	private ChargeLogAO chargeLogAO;
//	
//	@Test
//	public void testLogin(){
//		Map<String,Object> params = new HashMap<String, Object>();
////		params.put("logInContent", "广州彩趣流量");
//		params.put("secondOrderId", 782307011936129024l);
//		params.put("orderId", 782260406755266560l);
//		List<ChargeLog> records = chargeLogDao.listChargeLog(params);
//		for (ChargeLog chargeLog : records) {
//			System.out.println(chargeLog.getChargeTel());
//		}
//	}
//}
