//package crud.aotest;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedList;
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
//import com.aiyi.base.pojo.PageParam;
//import com.weizu.flowsys.core.util.NumberTool;
//import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.AgencyLevelEnum;
//import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
//import com.weizu.flowsys.util.Pagination;
//import com.weizu.flowsys.web.agency.ao.ChargeRecordAO;
//import com.weizu.flowsys.web.agency.dao.ChargeAccountDaoInterface;
//import com.weizu.flowsys.web.agency.dao.ChargeRecordDaoInterface;
//import com.weizu.flowsys.web.agency.pojo.ChargeAccountPo;
//import com.weizu.flowsys.web.agency.pojo.ChargeRecordPo;
//import com.weizu.flowsys.web.agency.pojo.ConsumeRecordPo;
//import com.weizu.flowsys.web.agency.pojo.GroupAgencyRecordPo;
//import com.weizu.flowsys.web.agency.pojo.GroupAgencyRecordVo;
//import com.weizu.web.foundation.DateUtil;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ChargeRecordAOTest {
//	
//	@Resource
//	private ChargeRecordAO chargeRecordAO;
//	@Resource
//	private ChargeRecordDaoInterface chargeRecordDao;
//	@Resource
//	private ChargeAccountDaoInterface chargeAccountDao;
//	
////	 @Test
////	 public void testListChargeRecord(){
////		 Map<String, Object> params = new HashMap<String, Object>();
////		 ChargeRecordPo chargeRecordPo = new ChargeRecordPo();
//////		 params.put("userName", "xiao");
////		 PageParam pageParam = new PageParam(1, 10);
////		 Pagination<ChargeRecordPo> pagination = chargeRecordAO.listChargeRecord(params,4,chargeRecordPo, pageParam);
////		 List<ChargeRecordPo> list = pagination.getRecords();	
////		 System.out.println(list.size());
////		 for (ChargeRecordPo po : list) {
////			 System.out.println(po.getUserName());
//////			System.out.println("username:"+chargeRecordPo.getUserName());
////		}
////	 }
////	 @Test
////	 public void testAddCharge(){
////		 ChargeRecordPo chargeRecordPo = new ChargeRecordPo();
////		 Date date = new Date();
////		 chargeRecordPo.setRemittanceTime(date.getTime()); 
////		 chargeRecordPo.setAccountId(1);
////		 chargeRecordPo.setAgencyId(4);
////		 chargeRecordPo.setAccountType(0);
////		 chargeRecordPo.setRechargeAmount(1000d);
////		 chargeRecordPo.setPurchaseId(703710166008205312l);
////		 chargeRecordPo.setChargeFor(0);
////		 System.out.println(chargeRecordDao.add(chargeRecordPo));
////	 }
//	
//	/**
//	 * @description: 查询消费记录
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年8月4日 下午4:08:26
//	 */
//	@Test
//	public void testListConsumeRecord(){
////		ConsumeRecordPo crp = new ConsumeRecordPo();
//////		crp.setAgencyId(4);
//		Map<String,Object> parmasMap = new HashMap<String,Object>();
////		parmasMap.put("agencyId", 1);
//		parmasMap.put("supperAgencyId", 1);
//		parmasMap.put("userName", "saiduosai");
////		parmasMap.put("userName", "saiduosai");
//		parmasMap.put("accountType", AccountTypeEnum.Replenishment.getValue());
////		Pagination<ConsumeRecordPo> pagination = chargeRecordAO.listConsumeRecord(parmasMap,4, crp, new PageParam(1, 10));
////		List<ConsumeRecordPo> list = pagination.getRecords();	
//////		 System.out.println(list.size());
////		 System.out.println(list.get(0).getRemittanceTimeStr());
////		 System.out.println(list.get(0).getRemittanceTime());
////		 System.out.println(list.get(0).getPurchaseId());
////		System.out.println(chargeRecordDao.countConsume(parmasMap));
//		long startTime = DateUtil.strToDate("2018-02-08 00:00:00", null).getTime();
//		long endTime = DateUtil.strToDate("2018-02-13 00:00:00", null).getTime();
//		System.out.println("startTIme:"+startTime+"\t endTime:"+endTime);
//		parmasMap.put("startTime", startTime);
//		parmasMap.put("endTime", endTime);
//		List<ConsumeRecordPo> list = chargeRecordDao.getConsume(parmasMap);
//		 for (ConsumeRecordPo po : list) {
//			 System.out.println(po.getChargeTel()+"\t"+po.getPurchaseId());
////			 System.out.println(po.getRemittanceTimeStr());
////			System.out.println("username:"+chargeRecordPo.getUserName());
//		}
//	}
//	
//	/**
//	 * @description: 批量添加
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月21日 上午9:52:39
//	 */
////	@Test
////	public void testCrt_addList(){
////		List<ChargeRecordPo> recordPoList = new LinkedList<ChargeRecordPo>();
////		int accountId = 2;
////		ChargeAccountPo accPo = chargeAccountDao.get(accountId);
////		Double chargeBeforeBalance = accPo.getAccountBalance();
////		int agencyId = accPo.getAgencyId();
////		Double chargeAfterBalance = null;
////		//给123的对私账户，为719330701316460544l这个订单号加上批量加上10笔记录
////		for (int i = 0; i < 5; i++) {
////			chargeAfterBalance = NumberTool.sub(chargeBeforeBalance,i);
////			ChargeRecordPo crtPo = new ChargeRecordPo(System.currentTimeMillis(), i+0.0d, chargeBeforeBalance, chargeAfterBalance, accPo.getBillType(), AccountTypeEnum.DECREASE.getValue(), accountId, agencyId, 1, 719330701316460544l);
////			recordPoList.add(crtPo);
////		}
////		int res = chargeRecordDao.crt_addList(recordPoList);
////		System.out.println(res);
////	}
//
////	@Test
////	public void testGroupAgencyList(){
////		ConsumeRecordPo consumeRecordPo = new ConsumeRecordPo();
//////		consumeRecordPo.setAccountType(AccountTypeEnum.DECREASE.getValue());
////		consumeRecordPo.setShowModel(AgencyLevelEnum.SUPPER_USER.getValue());
////		consumeRecordPo.setChargeFor(PgServiceTypeEnum.PGCHARGE.getValue());
//////		consumeRecordPo.setStartTime(DateUtil.getStartTime().getTime());
//////		consumeRecordPo.setEndTime(DateUtil.getEndTime().getTime());
////		String startTimeStr = DateUtil.formatAll(DateUtil.getStartTime().getTime());
////		String endTimeStr = DateUtil.formatAll(DateUtil.getEndTime().getTime());
////		consumeRecordPo.setStartTimeStr(startTimeStr);
////		consumeRecordPo.setEndTimeStr(endTimeStr);
////		System.out.println("startTime:"+DateUtil.getStartTime().getTime());
////		System.out.println("endTime:"+DateUtil.getEndTime().getTime());
////		List<GroupAgencyRecordVo> groupAgencyList =chargeRecordAO.groupAgencyRecord(1, consumeRecordPo);
////		System.out.println(groupAgencyList.size());
////		double totalAmount = 0d;
////		for (GroupAgencyRecordVo groupAgencyRecordVo : groupAgencyList) {
////			System.out.println(groupAgencyRecordVo.getAgencyName()+":"+groupAgencyRecordVo.getTotalAmount()+":"+groupAgencyRecordVo.getNumb());
////			System.out.println(groupAgencyRecordVo.getDecreaseAmount()+":"+groupAgencyRecordVo.getDecreaseNumb());
////		}
////	}
//
//
//}
