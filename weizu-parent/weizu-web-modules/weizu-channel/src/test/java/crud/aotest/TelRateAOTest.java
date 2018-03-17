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
//import org.weizu.api.outter.enums.ChargeStatusEnum;
//
//import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
//import com.weizu.flowsys.util.StringUtil2;
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
////		map.put("agencyId", 3);
////		map.put("provinceid", 440000);
////		map.put("cityid", 440100);
////		map.put("rootAgencyId", 2);
////		List<GetTelRatePo> getTelRateList = telRateDao.getTelRateForCharge(map);
////		System.out.println("id\tactive_discount\tbill_type\tcharge_value\ttel_code");
////		String mapStr = "{chargeSpeed=2, dataUser=null, rootAgencyId=1, platformUser=0, provinceid=440000, negative=0, positive=1, serviceType=1, bind=0, agencyId=4, useOpen=0}";
////		Map<String,Object> map = StringUtil2.mapStringToMap(mapStr);
//		
//		
//		map.put("chargeSpeed", TelchargeSpeedEnum.FAST.getValue());
//		map.put("rootAgencyId", 1);
//		map.put("platformUser", 0);
//		map.put("agencyId", 2);
//		map.put("negative", 0);
//		map.put("positive", 1);
//		map.put("serviceType", 1);
//		map.put("bind", 0);
//		map.put("provinceid", 440000);
//		map.put("useOpen", 0);
//		List<GetTelRatePo> getTelRateList = telRateDao.getTelRateForCharge(map);
//		for (GetTelRatePo getTelRatePo : getTelRateList) {
//			System.out.println(getTelRatePo.getId()+ "\t"+getTelRatePo.getActiveDiscount()+ "\t"+getTelRatePo.getBillType()+ "\t"+getTelRatePo.getChargeValue()+ "\t" + getTelRatePo.getTelCode());
//		}
//		
//	}
//	
//	
//}
