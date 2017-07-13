package crud.aotest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.AgencyActiveChannelAO;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveChannelPo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class AgencyActiveChannelAOTest {
	@Resource
	private AgencyActiveChannelAO agencyActiveChannelAO;
	
//	@Test
//	public void testList(){
//		AgencyActiveChannelPo activePo = new AgencyActiveChannelPo();
//		activePo.setAgencyName("456");
//		
//		List<AgencyActiveChannelPo> list = agencyActiveChannelAO.listActive(new PageParam(1, 10), activePo).getRecords();
//		System.out.println(list.size());
//	}
	/*@Test
	public void testList(){
		AgencyActiveChannelPo activePo = new AgencyActiveChannelPo();
		activePo.setAgencyName("456");
		
		List<AgencyActiveChannelPo> list = agencyActiveChannelAO.listActiveDiscount(new PageParam(1, 10), activePo);
		System.out.println(list.size());
	}*/
	@Test
	public void testListActiveRate(){
		RateDiscountPo rdp = new RateDiscountPo();
		rdp.setChannelId(12l);
		rdp.setOperatorType(0);
		rdp.setServiceType(0);
		
		Pagination<AgencyActiveChannelPo> pagination = agencyActiveChannelAO.listActiveRate(new PageParam(1, 10), rdp);
		List<AgencyActiveChannelPo> records = pagination.getRecords();
//		List<AgencyActiveChannelPo> list = agencyActiveChannelAO.listActiveDiscount(new PageParam(1, 10), activePo);
		System.out.println(records.size());
	}
}
