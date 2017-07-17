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
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class AgencyAOTest {
	
	@Resource
	private AgencyAO agencyAO;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
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
	 
//	 @Test
//	 public void testCheckSecondAgency(){
//		 int res = agencyAO.checkSecondAgency(4);
//		 System.out.println(res);
//	 }
	 /**
	 * @description: 修改密码
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月11日 上午10:15:01
	 */
//	@Test
//	 public void updateUserPass(){
//		 int res = agencyAO.updatePass(4, "123");
//		 System.out.println(res);
//	 }
//	@Test
//	public void testGetUnbindAgency(){
////		List<AgencyBackwardVO> list = agencyVODao.getUnbindAgency( 1);
//		Pagination<AgencyBackwardVO> pagination = agencyAO.getUnbindAgency(4, "22", null);
//		System.out.println(pagination.getRecords().size());
//		System.out.println(pagination.getTotalRecord());
//	}



}
