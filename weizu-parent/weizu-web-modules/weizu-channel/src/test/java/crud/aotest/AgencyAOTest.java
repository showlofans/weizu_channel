package crud.aotest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class AgencyAOTest {
	
	@Resource
	private AgencyAO agencyAO;
	
//	 @Test
//	 public void testListAgencyByRoot(){
//		 Map<String, Object> params = new HashMap<String, Object>();
////		 params.put("userName", "xiao");
//		 PageParam pageParam = new PageParam(1, 10);
//		 Pagination<AgencyBackwardVO> pagination = agencyAO.ListAgencyByRoot(1, new AgencyBackwardVO(), pageParam);
//		 List<AgencyBackwardVO> list = pagination.getRecords();	
//		 System.out.println(list.size());
//		 for (AgencyBackwardVO agencyBackwardVO : list) {
//			System.out.println("username:"+agencyBackwardVO.getUserName());
//		}
//	 }
	 
	 @Test
	 public void testCheckSecondAgency(){
		 int res = agencyAO.checkSecondAgency(4);
		 System.out.println(res);
	 }



}
