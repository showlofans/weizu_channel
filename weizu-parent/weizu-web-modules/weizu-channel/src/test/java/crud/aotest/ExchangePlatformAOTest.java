package crud.aotest;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.web.channel.ao.AgencyEpAO;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class ExchangePlatformAOTest {
	
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private AgencyEpAO agencyEpAO;
	@Resource
	private ExchangePlatformDao exchangePlatformDao;
	
//	 @Test
//	 public void testListAgencyByRoot(){
//		 Map<String, Object> params = new HashMap<String, Object>();
//		 params.put("userName", "xiao");
//		 PageParam pageParam = new PageParam(0, 10);
//		 Pagination<AgencyBackwardVO> pagination = agencyAO.ListAgencyByRoot(1, params, pageParam);
//		 List<AgencyBackwardVO> list = pagination.getRecords();	
//		 System.out.println(list.size());
//		 for (AgencyBackwardVO agencyBackwardVO : list) {
//			System.out.println("username:"+agencyBackwardVO.getUserName());
//		}
//	 }
//	@Test
//	public void testGetEpByEpName(){
//		String name = "迈远";
//		ExchangePlatformPo epPo = exchangePlatformAO.getEpByEpName(name);
//		System.out.println(epPo.getEpApikey());
//	}
//	@Test
//	public void testGetEp(){
//		Pagination<ExchangePlatformPo>  pagination = exchangePlatformAO.getEp(4, null, null);
//		System.out.println(pagination.getRecords().size());
//	}
//	@Test
//	public void testAddEp(){
//		int epId = new Long(exchangePlatformDao.nextId()).intValue();
////		exchangePlatformPo.setId(epId);
//		ExchangePlatformPo exchangePlatformPo = new ExchangePlatformPo();
//		int res2 = exchangePlatformDao.add(exchangePlatformPo);
//		System.out.println(epId + "\t" + res2);
//	}
	
//	public void testCheckEpEngId(){
//		System.out.println(exchangePlatformAO.checkEpEngId("weizu"));
//	}



}
