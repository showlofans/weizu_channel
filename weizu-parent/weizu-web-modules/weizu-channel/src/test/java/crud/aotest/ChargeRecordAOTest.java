package crud.aotest;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.web.agency.ao.ChargeRecordAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class ChargeRecordAOTest {
	
	@Resource
	private ChargeRecordAO chargeRecordAO;
	
//	 @Test
//	 public void testListChargeRecord(){
////		 Map<String, Object> params = new HashMap<String, Object>();
//		 ChargeRecordPo chargeRecordPo = new ChargeRecordPo();
////		 params.put("userName", "xiao");
//		 PageParam pageParam = new PageParam(1, 10);
//		 Pagination<ChargeRecordPo> pagination = chargeRecordAO.listChargeRecord(chargeRecordPo, pageParam);
//		 List<ChargeRecordPo> list = pagination.getRecords();	
//		 System.out.println(list.size());
//		 for (ChargeRecordPo po : list) {
//			 System.out.println(po.getUserName());
////			System.out.println("username:"+chargeRecordPo.getUserName());
//		}
//	 }
//	 @Test
//	 public void testAddCharge(){
//		 ChargeRecordPo chargeRecordPo = new ChargeRecordPo();
//		 Date date = new Date();
//		 chargeRecordPo.setRemittanceTime(date.getTime()); 
//		 chargeRecordPo.setAccountId(1);
//		 chargeRecordPo.setAccountType(0);
//		 chargeRecordPo.setRechargeAmount(1000d);
//		 chargeRecordPo.setChargeFor(0);
//		 
//		 System.out.println(chargeRecordAO.addCharge(chargeRecordPo));
//	 }



}
