//package crud.aotest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
//import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
//import com.weizu.flowsys.web.trade.ao.AccountPurchaseAO;
//import com.weizu.flowsys.web.trade.dao.AccountPurchaseDao;
//import com.weizu.flowsys.web.trade.pojo.AccountPurchasePo;
//import com.weizu.flowsys.web.trade.pojo.PurchasePo;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class AcountPurchaseAOTest {
//	@Resource
//	private AccountPurchaseDao accountPurchaseDao;
//	@Resource
//	private AccountPurchaseAO accountPurchaseAO;
//	
//	/**
//	 * @description: 批量添加
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月21日 上午11:50:10
//	 */
////	@Test
////	public void testAddList(){
////		List<AccountPurchasePo> list = new LinkedList<AccountPurchasePo>();
////		for (int i = 0; i < 5; i++) {
////			AccountPurchasePo apPo = new AccountPurchasePo(4, 724429670308646912L, 46l, 25.5d, 0, 27d, "456", OrderPathEnum.CHILD_WEB_PAGE.getValue(), OrderStateEnum.CHARGING.getValue());
//////			chargeAfterBalance = NumberTool.sub(chargeBeforeBalance,i);
//////			ChargeRecordPo crtPo = new ChargeRecordPo(System.currentTimeMillis(), i+0.0d, chargeBeforeBalance, chargeAfterBalance, accPo.getBillType(), AccountTypeEnum.DECREASE.getValue(), accountId, agencyId, 1, 719330701316460544l);
////			list.add(apPo);
////		}
////		int res = agencyPurchaseDao.ap_addList(list);
//////		System.out.println(res);
////	}
////	@Test
////	public void getAPByAccountType(){
////		AccountPurchasePo apPo = agencyPurchaseDao.getAPByAccountType(744784836631203840l, 1,1);
////		System.out.println(apPo.getOrderAmount());
////	}
////	@Test
////	public void testUpdateState(){
////		//wl123 hy123
//////		String res = accountPurchaseAO.updatePurchaseStateByMe(735701276200800256l, OrderStateEnum.UNCHARGE.getValue(), OrderStateEnum.UNCHARGE.getDesc(), System.currentTimeMillis());//
//////		String res = accountPurchaseAO.updatePurchaseStateByMe(735696780196319232l, OrderStateEnum.CHARGED.getValue(), OrderStateEnum.CHARGED.getDesc(), System.currentTimeMillis());//
//////		String res = accountPurchaseAO.updatePurchaseStateByMe(735696617457324032l, OrderStateEnum.CHARGED.getValue(), OrderStateEnum.CHARGED.getDesc(), System.currentTimeMillis());//
////		String res = accountPurchaseAO.updatePurchaseStateByMe(735691086504136704l, OrderStateEnum.CHARGED.getValue(), OrderStateEnum.CHARGED.getDesc(), System.currentTimeMillis());//
////		System.out.println(res);
////	}
////	@Test
////	public void testAGetApByAccountType(){
////		 accountPurchaseDao.getAPByAccountType(798318209164906496l, 289, AccountTypeEnum.DECREASE.getValue());
////	}
//	
//	@Test
//	public void testListAP(){
////		Long[] orderIds = new Long[]{808405367410135040l, 808403930391252992l};
//		List<Long> orderIds = new ArrayList<Long>();
//		orderIds.add(808405367410135040l);
//		orderIds.add(808403930391252992l);
//		List<AccountPurchasePo> list = accountPurchaseDao.selectByOrderIds(orderIds);
////		String sqlStr = "808405367410135040, 808403930391252992";
//		for (AccountPurchasePo accountPurchasePo : list) {
//			System.out.println(accountPurchasePo.getApDiscount());
//		}
//		
//	}
////	@Test
////	public void getOrderAmount(){
////		Double orderAmount = agencyPurchaseDao.getOrderAmount(735696780196319232l, 1);
////		System.out.println(orderAmount);
////	}
//}
