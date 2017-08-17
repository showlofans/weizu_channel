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
import com.weizu.flowsys.operatorPg.enums.BindStateEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRateDTO;
import com.weizu.flowsys.web.agency.ao.AgencyAO;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
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
//		 Pagination<AgencyBackwardVO> pagination = agencyAO.ListAgencyByRoot(4, new AgencyBackwardVO(), pageParam);
//		 List<AgencyBackwardVO> list = pagination.getRecords();	
//		 System.out.println(list.size());
//		 for (AgencyBackwardVO agencyBackwardVO : list) {
//			System.out.println("username:"+agencyBackwardVO.getUserName());
//			System.out.println("accountId:"+agencyBackwardVO.getAccountId());
//		}
//	 }
	
//	public void testListAgencyByRoot(){
//		PageParam pageParam = new PageParam(1, 10);
//		 Pagination<AgencyBackwardVO> pagination = agencyAO.ListAgencyByRoot(4, new AgencyBackwardVO(), pageParam);
//		 List<AgencyBackwardVO> list = pagination.getRecords();	
//		 System.out.println(list.size());
//	}
	 
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
	/**
	 * @description: 测试查询未绑定和已解绑的代理商列表
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月18日 上午11:51:52
	 */
//	@Test
//	public void testGetUnbindAgency(){
////		List<AgencyBackwardVO> list = agencyVODao.getUnbindAgency( 1);
//		AgencyActiveRateDTO aardto = new AgencyActiveRateDTO();
////		aardto.setAgencyName("w");
//		aardto.setBindState(BindStateEnum.UNBIND.getValue());
//		aardto.setRateDiscountId(22l);
//		Pagination<AgencyBackwardVO> pagination = agencyAO.getUnbindAgency(4, aardto, null);
//		System.out.println(pagination.getRecords().size());
//		System.out.println(pagination.getTotalRecord());
//	}
//	@Test
//	public void testBindStateEnum(){
//		System.out.println(BindStateEnum.toBindList().size());
//	}
//	@Test
//	public void testLogin(){
//		AgencyBackwardPo agencyPo =  new AgencyBackwardPo();
//		agencyPo.setUserName("456");
//		agencyPo.setUserPass("123");
//		Map<String, Object> resultMap = agencyAO.login(agencyPo);
//		AgencyBackwardPo resultPo = (AgencyBackwardPo) resultMap.get("entity");// 获得返回的登陆实体
//		System.out.println(resultPo.getAgencyTel());
//	}
//	@Test
//	public void testCheckName(){
//		boolean isExist = agencyAO.checkName("wang");
//		System.out.println(isExist);
//	}



}
