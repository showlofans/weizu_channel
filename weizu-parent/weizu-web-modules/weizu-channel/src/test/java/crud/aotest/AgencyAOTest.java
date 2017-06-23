package crud.aotest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class AgencyAOTest {
	
//	@Resource
//	private AgencyAO agencyAO;
	
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



}
