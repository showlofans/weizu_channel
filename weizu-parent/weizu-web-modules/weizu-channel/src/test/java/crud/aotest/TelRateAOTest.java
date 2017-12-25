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
//import com.weizu.flowsys.web.activity.dao.ITelRateDao;
//import com.weizu.flowsys.web.trade.pojo.GetTelRatePo;
//
///**
// * @description: 话费折扣测试
// * @projectName:weizu-channel
// * @className:TelRateAOTest.java
// * @author:微族通道代码设计人 宁强
// * @createTime:2017年12月1日 下午5:34:19
// * @version 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class TelRateAOTest {
//
//	@Resource
//	private ITelRateDao telRateDao;
//	
//	@Test
//	public void getTelRateForCharge(){
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("agencyId", 3);
//		map.put("provinceid", 440000);
//		map.put("cityid", 440100);
//		map.put("rootAgencyId", 2);
//		List<GetTelRatePo> getTelRateList = telRateDao.getTelRateForCharge(map);
//		System.out.println("id\tactive_discount\tbill_type\tcharge_value\ttel_code");
//		for (GetTelRatePo getTelRatePo : getTelRateList) {
//			System.out.println(getTelRatePo.getId()+ "\t"+getTelRatePo.getActiveDiscount()+ "\t"+getTelRatePo.getBillType()+ "\t"+getTelRatePo.getChargeValue()+ "\t" + getTelRatePo.getTelCode());
//		}
//	}
//}
