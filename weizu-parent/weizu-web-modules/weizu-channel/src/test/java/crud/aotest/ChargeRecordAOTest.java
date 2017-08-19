package crud.aotest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.ao.ChargeRecordAO;
import com.weizu.flowsys.web.agency.dao.ChargeRecordDaoInterface;
import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class ChargeRecordAOTest {
	
	@Resource
	private ChargeRecordAO chargeRecordAO;
	@Resource
	private ChargeRecordDaoInterface chargeRecordDao;
	
//	 @Test
//	 public void testListChargeRecord(){
//		 Map<String, Object> params = new HashMap<String, Object>();
//		 ChargeRecordPo chargeRecordPo = new ChargeRecordPo();
////		 params.put("userName", "xiao");
//		 PageParam pageParam = new PageParam(1, 10);
//		 Pagination<ChargeRecordPo> pagination = chargeRecordAO.listChargeRecord(params,4,chargeRecordPo, pageParam);
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
//		 chargeRecordPo.setAgencyId(4);
//		 chargeRecordPo.setAccountType(0);
//		 chargeRecordPo.setRechargeAmount(1000d);
//		 chargeRecordPo.setPurchaseId(703710166008205312l);
//		 chargeRecordPo.setChargeFor(0);
//		 System.out.println(chargeRecordDao.add(chargeRecordPo));
//	 }
	
	/**
	 * @description: 查询消费记录
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月4日 下午4:08:26
	 */
//	@Test
//	public void testListConsumeRecord(){
//		ConsumeRecordPo crp = new ConsumeRecordPo();
////		crp.setAgencyId(4);
//		Map<String,Object> parmasMap = new HashMap<String,Object>();
//		Pagination<ConsumeRecordPo> pagination = chargeRecordAO.listConsumeRecord(parmasMap,4, crp, new PageParam(1, 10));
//		List<ConsumeRecordPo> list = pagination.getRecords();	
////		 System.out.println(list.size());
//		 System.out.println(list.get(0).getRemittanceTimeStr());
//		 System.out.println(list.get(0).getRemittanceTime());
//		 System.out.println(list.get(0).getPurchaseId());
////		 for (ConsumeRecordPo po : list) {
////			 System.out.println(po.getRemittanceTimeStr());
//////			System.out.println("username:"+chargeRecordPo.getUserName());
////		}
//	}



}
