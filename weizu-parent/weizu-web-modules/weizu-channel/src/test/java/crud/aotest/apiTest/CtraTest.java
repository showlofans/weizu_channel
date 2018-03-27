//package crud.aotest.apiTest;
//
//import javax.annotation.Resource;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.api.singleton.BalanceDTO;
//import com.weizu.flowsys.api.singleton.BaseInterface;
//import com.weizu.flowsys.api.singleton.BaseP;
//import com.weizu.flowsys.api.singleton.OrderDTO;
//import com.weizu.flowsys.api.singleton.SingletonFactory;
//import com.weizu.flowsys.api.weizu.charge.PgProductParams;
//import com.weizu.flowsys.api.weizu.facet.IPgProductFacet;
//import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
//import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
//import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
//import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
//import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
//import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class CtraTest {
//	
//	@Resource
//	private ExchangePlatformDao exchangePlatformDao;
//	@Resource
//	private ExchangePlatformAO exchangePlatformAO;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
//	
//	private BaseInterface biCharge = null;
//	private BaseInterface biOrder = null;
//	private BaseInterface bi = null;
//	
//	@Before
//	public void initBi(){
//		ExchangePlatformPo epPo = exchangePlatformAO.getEpByEpName("杭州弯流流量");
////		BaseP baseP = new BaseP();
//		ProductCodePo productCodePo = productCodeDAO.get(372l);
//		BaseP baseP = new BaseP(productCodePo, orderId, chargeTel, epo, otherParams)
//		baseP.setEpo(epPo);
//		bi = SingletonFactory.getSingleton("Ctra", baseP);//充值api测试
////		biOrder = SingletonFactory.getSingleton("Weizu", new BaseP(null,"20171211142556265504","15771776700",ServiceTypeEnum.NATION_WIDE.getValue(),epPo));//方便查询订单详情
//	}
//	
////	@Test
////	public void testBalance(){
//////		ExchangePlatformPo epPo = exchangePlatformDao.get(32);
//////		BaseInterface bi = SingletonFactory.getSingleton("Weizu", new BaseP("pc123123","726633391352451072","15014369834",1,epPo));
//////		System.out.println(bi.toBalanceParams());
////		BalanceDTO balanceDTO = bi.getBalance();
////		System.out.println(balanceDTO.getAccountBalance());
////	}
//	
//	public void testCharge(){
//		
//	}
////	@Test
////	public void testOrder(){
////		OrderDTO orderDTO = biOrder.getOrderState();
////		System.out.println(orderDTO.getRspCode());
////		System.out.println(orderDTO.getRspMsg());
//////		System.out.println(orderDTO.getOrderIn().getMsg());
//////		System.out.println(orderDTO.getOrderIn().getCharge_fee());
////		System.out.println(orderDTO.getOrderIn().getStatus());
//////		System.out.println(orderDTO.getOrderIn().getUser_order_id());
////		
//////		System.out.println(bi.getOrderState().getRspMsg());
////	}
//	
//}
