//package crud.aotest.apiTest;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.api.singleton.BalanceDTO;
//import com.weizu.flowsys.api.singleton.BaseInterface;
//import com.weizu.flowsys.api.singleton.BaseP;
//import com.weizu.flowsys.api.singleton.SingletonFactory;
//import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
//import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
//import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
//import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
//import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
//import com.weizu.web.foundation.DateUtil;
//
///**
// * @description: Zxpay 接口测试
// * @projectName:weizu-channel
// * @className:ZxpayTest.java
// * @author:微族通道代码设计人 宁强
// * @createTime:2017年12月21日 下午4:48:26
// * @version 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ZxpayTest {
//	
//	@Resource
//	private ExchangePlatformDao exchangePlatformDao;
//	@Resource
//	private ExchangePlatformAO exchangePlatformAO;
//	@Resource
//	private IProductCodeDAO productDAO;
//	
//	@Test
//	public void testBalance(){
//		ExchangePlatformPo epPo = exchangePlatformDao.get(43);
////		System.out.println("apikey:"+epPo.getEpApikey());
//		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("ai智信省网资源");
//		ProductCodePo pc = productDAO.selectByPrimaryKey(278l);
//		BaseInterface bi = SingletonFactory.getSingleton(platformPo.getEpEngId(), new BaseP(pc,726633391352451072l,null,platformPo,DateUtil.formatPramm(System.currentTimeMillis(), "yyyy-MM-dd")));
////		System.out.println(bi.toParams());
////		System.out.println(bi.toBalanceParams());
//		BalanceDTO balanceDTO = bi.getBalance();
//		System.out.println(balanceDTO.getTipCode() + "<----->" + balanceDTO.getTipMsg());
//		System.out.println(balanceDTO.getAccountBalance());
//	}
//	
//	
//}
