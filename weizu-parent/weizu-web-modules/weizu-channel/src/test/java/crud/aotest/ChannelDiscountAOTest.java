//package crud.aotest;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.web.channel.ao.ChannelDiscountAO;
//import com.weizu.flowsys.web.channel.dao.ChannelDiscountDao;
//import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ChannelDiscountAOTest {
//	
//	@Resource
//	private ChannelDiscountAO channelDiscountAO;
//	@Resource
//	private ChannelDiscountDao channelDiscountDao;
//	
////	@Test
////	public void testGetDiscountList(){
////		ChannelDiscountPo cdp = new ChannelDiscountPo();
////		cdp.setChannelId(7l);
////		Pagination<ChannelDiscountPo> pagination = channelDiscountAO.getDiscountList(cdp, new PageParam(1, 10));
////		for(ChannelDiscountPo cdp1:pagination.getRecords()){
////			System.out.println(cdp1.getDiscountType());
////		}
////	}
////	@Test
////	public void testGetByAP(){
////		ChannelDiscountPo cd = channelDiscountDao.getCDbyAP(726614433270337536l, 21);
////		System.out.println(cd.getServiceType());
////	}
//	@Test
//	public void listOpenChannel(){
//		ChannelDiscountPo cpo = new ChannelDiscountPo();
//		cpo.setBillType(0);
//		cpo.setBelongAgencyId(2);
//		List<ChannelDiscountPo> list =channelDiscountAO.listOpenChannel(cpo);
//		if(list != null && list.size() > 0){
//			System.out.println(list.size());
//		}
//		System.out.println(list.size());
//	}
//}
