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
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
//import com.weizu.flowsys.web.channel.ao.AgencyEpAO;
//import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
//import com.weizu.flowsys.web.channel.dao.ExchangePlatformDaoInterface;
//import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
//import com.weizu.web.foundation.hash.Hash;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ExchangePlatformAOTest {
//	
//	@Resource
//	private ExchangePlatformAO exchangePlatformAO;
//	@Resource
//	private AgencyEpAO agencyEpAO;
//	@Resource
//	private ExchangePlatformDaoInterface exchangePlatformDao;
//	
////	 @Test
////	 public void testListAgencyByRoot(){
////		 Map<String, Object> params = new HashMap<String, Object>();
////		 params.put("userName", "xiao");
////		 PageParam pageParam = new PageParam(0, 10);
////		 Pagination<AgencyBackwardVO> pagination = agencyAO.ListAgencyByRoot(1, params, pageParam);
////		 List<AgencyBackwardVO> list = pagination.getRecords();	
////		 System.out.println(list.size());
////		 for (AgencyBackwardVO agencyBackwardVO : list) {
////			System.out.println("username:"+agencyBackwardVO.getUserName());
////		}
////	 }
//	@Test
//	public void testGetEpByEpName(){
//		String name = "河南趣闻分省";
//		ExchangePlatformPo epPo = exchangePlatformAO.getEpByEpName(name);
//		if(epPo != null){
////			String userPass2 = Hash.BASE_UTIL.decode(epPo.getEpUserPass());
////			System.out.println("userName="+ epPo.getEpUserName()+" ,userPass="+ userPass2);
//			System.out.println("userName="+ epPo.getEpUserName()+" ,userPass="+ epPo.getEpUserPass());
//		}else{
//			System.out.println("没有该平台信息");
//		}
//	}
////	@Test
////	public void testGetEp(){
//////		Pagination<ExchangePlatformPo>  pagination = exchangePlatformAO.getEp(4, null, null);
//////		System.out.println(pagination.getRecords().size());
////		List<ExchangePlatformPo> list = exchangePlatformDao.list(new WherePrams("id", "!=", "32"));
////		for (ExchangePlatformPo exchangePlatformPo : list) {
////			String epUserPass = exchangePlatformPo.getEpUserPass();
////			epUserPass = Hash.BASE_UTIL.encode(epUserPass);
////			exchangePlatformPo.setEpUserPass(epUserPass);
////			exchangePlatformDao.updateLocal(exchangePlatformPo);
////		}
////		System.out.println(list!= null? list.size():"空");
////	}
////	@Test
////	public void testAddEp(){
////		int epId = new Long(exchangePlatformDao.nextId()).intValue();
//////		exchangePlatformPo.setId(epId);
////		ExchangePlatformPo exchangePlatformPo = new ExchangePlatformPo();
////		int res2 = exchangePlatformDao.add(exchangePlatformPo);
////		System.out.println(epId + "\t" + res2);
////	}
//	
////	public void testCheckEpEngId(){
////		System.out.println(exchangePlatformAO.checkEpEngId("weizu"));
////	}
////	@Test
////	public void GetEpByRateId(){
////		ExchangePlatformPo epPO = exchangePlatformAO.getEpByRateId(21l);
////		if(epPO != null){
////			System.out.println(epPO.getEpName());
////		}
////	}
////	@Test
////	public void updateEpUserPass(){
//////		List<ExchangePlatformPo> list = exchangePlatformDao.list(new WherePrams("1", "=", "1"));
////		int upd = 0;
//////		for (ExchangePlatformPo exchangePlatformPo : list) {
//////			String epUserPass = exchangePlatformPo.getEpUserPass();
////////			epUserPass = Hash.BASE_UTIL.decode(epUserPass);
//////			epUserPass = Hash.BASE_UTIL.encode(epUserPass);
//////			exchangePlatformPo.setEpUserPass(epUserPass);
//////			exchangePlatformPo.setEpFor(PgServiceTypeEnum.TELCHARGE.getValue());
//////			upd += exchangePlatformDao.updateLocal(exchangePlatformPo);
////////			System.out.println(epUserPass);
//////		}
////		ExchangePlatformPo exchangePlatformPo = exchangePlatformAO.getEpByEpName("河南趣闻分省");
//////		String epUserPass = exchangePlatformPo.getEpUserPass();
////		String epUserPass = "123456";
//////		epUserPass = Hash.BASE_UTIL.decode(epUserPass);
////		epUserPass = Hash.BASE_UTIL.encode(epUserPass);
////		exchangePlatformPo.setEpUserPass(epUserPass);
////		exchangePlatformPo.setEpFor(PgServiceTypeEnum.PGCHARGE.getValue());
////		upd += exchangePlatformDao.updateLocal(exchangePlatformPo);
////		System.out.println(upd);
////	}
//	
////	@Test
////	public void getEpByChannelD(){
////		ExchangePlatformPo epPo = exchangePlatformDao.getEpByCDiscountId(46l);
////		System.out.println(epPo == null?"12":epPo.getEpName());
////	}
//
//}
