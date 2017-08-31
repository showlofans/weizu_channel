package crud.aotest.apiTest;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class WeizuTest {
	@Resource
	private ExchangePlatformDao exchangePlatformDao;
	
	private BaseInterface bi = null;
	
	@Before
	public void initBi(){
		ExchangePlatformPo epPo = exchangePlatformDao.get(32);
		bi = SingletonFactory.getSingleton("Weizu", new BaseP("pc123123","20170829141510693712","15014369834",1,epPo));
	}
	
	@Test
	public void testBalance(){
//		ExchangePlatformPo epPo = exchangePlatformDao.get(32);
//		BaseInterface bi = SingletonFactory.getSingleton("Weizu", new BaseP("pc123123","726633391352451072","15014369834",1,epPo));
		System.out.println(bi.toParams());
		System.out.println(bi.toBalanceParams());
		BalanceDTO balanceDTO = bi.getBalance();
		System.out.println(balanceDTO.getRspMsg());
		System.out.println(balanceDTO.getAccountBalance());
	}
	
//	public void testCharge(){
//		
//	}
//	@Test
//	public void testOrder(){
//		OrderDTO orderDTO = bi.getOrderState();
//		System.out.println(orderDTO.getCreated_at());
//		System.out.println(orderDTO.getMsg());
//		
////		System.out.println(bi.getOrderState().getRspMsg());
//	}
}
