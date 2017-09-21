//package crud.aotest;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.operatorPg.enums.OrderPathEnum;
//import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
//import com.weizu.flowsys.web.trade.dao.AgencyPurchaseDao;
//import com.weizu.flowsys.web.trade.pojo.AgencyPurchasePo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class AgencyPurchaseAOTest {
//	@Resource
//	private AgencyPurchaseDao agencyPurchaseDao;
//	
//	/**
//	 * @description: 批量添加
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月21日 上午11:50:10
//	 */
////	@Test
////	public void testAddList(){
////		List<AgencyPurchasePo> list = new LinkedList<AgencyPurchasePo>();
////		for (int i = 0; i < 5; i++) {
////			AgencyPurchasePo apPo = new AgencyPurchasePo(4, 724429670308646912L, 46l, 25.5d, 0, 27d, "456", OrderPathEnum.CHILD_WEB_PAGE.getValue(), OrderStateEnum.CHARGING.getValue());
//////			chargeAfterBalance = NumberTool.sub(chargeBeforeBalance,i);
//////			ChargeRecordPo crtPo = new ChargeRecordPo(System.currentTimeMillis(), i+0.0d, chargeBeforeBalance, chargeAfterBalance, accPo.getBillType(), AccountTypeEnum.DECREASE.getValue(), accountId, agencyId, 1, 719330701316460544l);
////			list.add(apPo);
////		}
////		int res = agencyPurchaseDao.ap_addList(list);
//////		System.out.println(res);
////	}
//	@Test
//	public void getOrderAmount(){
//		Double orderAmount = agencyPurchaseDao.getOrderAmount(735696780196319232l, 1);
//		System.out.println(orderAmount);
//	}
//}
