package crud.aotest;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.AgencyActiveChannelAO;
import com.weizu.flowsys.web.activity.dao.AgencyActiveChannelDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRatePo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class AgencyActiveChannelAOTest {
	@Resource
	private AgencyActiveChannelAO agencyActiveChannelAO;
	@Resource
	private AgencyActiveChannelDao agencyActiveChannelDao;
	
//	@Test
//	public void testList(){
//		AgencyActiveRatePo activePo = new AgencyActiveRatePo();
//		activePo.setAgencyName("456");
//		
//		List<AgencyActiveRatePo> list = agencyActiveChannelAO.listActive(new PageParam(1, 10), activePo).getRecords();
//		System.out.println(list.size());
//	}
	/*@Test
	public void testList(){
		AgencyActiveRatePo activePo = new AgencyActiveRatePo();
		activePo.setAgencyName("456");
		
		List<AgencyActiveRatePo> list = agencyActiveChannelAO.listActiveDiscount(new PageParam(1, 10), activePo);
		System.out.println(list.size());
	}*/
//	@Test
//	public void testListActiveRate(){
//		RateDiscountPo rdp = new RateDiscountPo();
////		rdp.setChannelId(12l);
//		rdp.setOperatorType(0);
//		rdp.setServiceType(0);
//		
//		Pagination<AgencyActiveRatePo> pagination = agencyActiveChannelAO.listActiveRate(new PageParam(1, 10), rdp);
//		List<AgencyActiveRatePo> records = pagination.getRecords();
////		List<AgencyActiveRatePo> list = agencyActiveChannelAO.listActiveDiscount(new PageParam(1, 10), activePo);
//		System.out.println(records.size());
//		for (AgencyActiveRatePo agencyActiveRatePo : records) {
//			System.out.println(agencyActiveRatePo.getAgencyName());
//		}
//	}
	
	@Test
	public void testListBindAgency(){
		List<AgencyActiveRatePo> list = agencyActiveChannelDao.listBindAgency(12l);
//		java.util.List.Iterator<Integer> it = list.iterator();
//		while(it.hasNext()) {
//		  System.out.println(it.next);
//		}
		System.out.println(list.size());
		for (AgencyActiveRatePo agencyActiveRatePo : list) {
			System.out.print(agencyActiveRatePo.getAgencyName());
			System.out.println(agencyActiveRatePo.getAgencyId());
		}
		
//		agencyActiveChannelDao
		
//		for (Integer m : list) {
//			System.out.println(m);
//		}
//		System.out.println(list.size());
		
//		List<Integer> list1 = new Arr
		
	}
}
