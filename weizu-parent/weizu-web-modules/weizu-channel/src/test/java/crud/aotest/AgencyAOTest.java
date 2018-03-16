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
//import com.weizu.flowsys.web.agency.ao.AgencyAO;
//import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
//import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
//import com.weizu.flowsys.web.http.ao.ValiUser;
//import com.weizu.web.foundation.hash.Hash;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class AgencyAOTest {
//	
//	@Resource
//	private AgencyAO agencyAO;
//	@Resource
//	private AgencyVODaoInterface agencyVODao;
//	@Resource
//	private ValiUser valiUser;
//	
////	 @Test
////	 public void testListAgencyByRoot(){
////		 Map<String, Object> params = new HashMap<String, Object>();
//////		 params.put("userName", "xiao");
////		 PageParam pageParam = new PageParam(1, 10);
////		 Pagination<AgencyBackwardVO> pagination = agencyAO.ListAgencyByRoot(4, new AgencyBackwardVO(), pageParam);
////		 List<AgencyBackwardVO> list = pagination.getRecords();	
////		 System.out.println(list.size());
////		 for (AgencyBackwardVO agencyBackwardVO : list) {
////			System.out.println("username:"+agencyBackwardVO.getUserName());
////			System.out.println("accountId:"+agencyBackwardVO.getAccountId());
////		}
////	 }
////	@Test
////	public void testListAgencyByRoot(){
////		PageParam pageParam = new PageParam(2, 10);
////		 Pagination<AgencyBackwardVO> pagination = agencyAO.ListAgencyByRoot(1, new AgencyBackwardVO(), pageParam);
////		 List<AgencyBackwardVO> list = pagination.getRecords();	
////		 System.out.println(list.size());
////	}
//	 
////	 @Test
////	 public void testCheckSecondAgency(){
////		 int res = agencyAO.checkSecondAgency(4);
////		 System.out.println(res);
////	 }
//	 /**
//	 * @description: 修改密码
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年7月11日 上午10:15:01
//	 */
////	@Test
////	 public void updateUserPass(){
//////		 int res = agencyAO.updatePass(1, "333221...");
//////		 int res = agencyAO.updatePass(2, "123456");
////		 int res = agencyAO.updatePass(3, "456");
////		 System.out.println(res);
////	 }
//	/**
//	 * @description: 测试查询未绑定和已解绑的代理商列表
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年7月18日 上午11:51:52
//	 */
////	@Test
////	public void testGetUnbindAgency(){
//////		List<AgencyBackwardVO> list = agencyVODao.getUnbindAgency( 1);
////		AgencyActiveRateDTO aardto = new AgencyActiveRateDTO();
//////		aardto.setAgencyName("w");
////		aardto.setBindState(BindStateEnum.UNBIND.getValue());
////		aardto.setRateDiscountId(22l);
////		Pagination<AgencyBackwardVO> pagination = agencyAO.getUnbindAgency(4, aardto, null);
////		System.out.println(pagination.getRecords().size());
////		System.out.println(pagination.getTotalRecord());
////	}
//	/**
//	 * @description:测试查询未绑定和已解绑话费折扣的代理商列表
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年11月23日 下午4:06:13
//	 */
////	@Test
////	public void testGetUnbindTelAgency(){
//////		List<AgencyBackwardVO> list = agencyVODao.getUnbindAgency( 1);
////		TelrateBindAccountVO telrateBindAccountVO = new TelrateBindAccountVO(); 
//////		aardto.setAgencyName("w");
////		telrateBindAccountVO.setBindState(BindStateEnum.NO.getValue());
////		telrateBindAccountVO.setTelRateId(3l);
////		telrateBindAccountVO.setBillType(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////		Pagination<AgencyBackwardVO> pagination = agencyAO.getUnbindTelAgency(1, telrateBindAccountVO, null);
////		System.out.println(pagination.getRecords().size());
////		System.out.println(pagination.getTotalRecord());
////	}
////	@Test
////	public void testBindStateEnum(){
////		System.out.println(BindStateEnum.toBindList().size());
////	}
//	@Test
//	public void testLogin(){
////		String userName = "博爱小强";// Lxq19930620
////		String userName = "流量代理";// xing081500
////		String userName = "罗大大";// 201103 48
////		String userName = "18706732390";// hou77833
////		String userName = "A661844";// 123456 
////		String userName = "xiao";// MzMzMjIxLi4u 密码编译
////		String userName = "renzhi";// MzMzMjIxLi4u 密码编译
////		String userName = "q284408088";// qq13542377481 密码编译
////		String userName = "123";// 123456
////		String userName = "456";// 123456
////		String userName = "WZ123";// 123456
////		String userName = "haiyi";// 123456
////		String userName = "郭大大";// 123456
////		String userName = "hy123";// 960528hy
////		String userName = "wl123";// 960528 
////		String userName = "13433777966";// 960528 
////		String userName = "wzkj";// wzkj 
////		String userName = "王小贱";// 201103
//		String userName = "184545468";// 00000000
////		String userName = "wechat";// 123456 id231
////		String userName = "gzyl";// d9sjfwa@a99d7
////		String userName = "xiaoning";// d9sjfwa@a99d7
//		
////		String userName = "15735651540";// 123456
////		String userName = "LufuLL";// 123456
////		String userName = "15766286668";// 123456 id 200
//		
//		AgencyBackwardPo agencyPo = agencyVODao.get(new WherePrams("user_name", "=", userName));
//		System.out.println(agencyPo.getId());
////		String supperUserName = agencyVODao.get(agencyPo.getRootAgencyId()).getUserName();
////		System.out.println( "suppperUserName:" + supperUserName);
//		//得到密码
////		System.out.println("8a982a8a5f7bd4d7015f7bd4d7c90000".equals("8a982a8a5f7bd4d7015f7bd4d7c90000"));
////		System.out.println(userName);//15754715147
//		System.out.println("pass:"+agencyPo.getUserPass());
//		String userPass = Hash.BASE_UTIL.decode(agencyPo.getUserPass());
//		System.out.println("decodePass:"+userPass);
////		System.out.println(agencyPo.getCallBackIp());
////		System.out.println(agencyPo.getAgencyTag());
////		System.out.println(agencyPo.getUserApiKey());
////		agencyPo.setUserPass(userPass);//948109abc
////		Map<String, Object> resultMap = agencyAO.login(agencyPo);
////		AgencyBackwardPo resultPo = (AgencyBackwardPo) resultMap.get("entity");// 获得返回的登陆实体
////		System.out.println(resultPo.getAgencyTel());
//	}
////	@Test
////	public void testcheckChargeTel(){
////		boolean is = valiUser.checkChargeTel("13670430162", 1);
////		System.out.println(is);
////	}
////	@Test
////	public void testCheckName(){
////		boolean isExist = agencyAO.checkName("xiao");
////		System.out.println(isExist);
////	}
////	@Test
////	public void checkVerifyCode(){
////		boolean isExist = agencyAO.checkVerifyCode("123",null);
////		System.out.println(isExist);
////	}
////	@Test
////	public void testGetRootAgencyById(){
////		AgencyBackwardPo agencyPo = agencyVODao.getRootAgencyById(21);
////		System.out.println(agencyPo.getId()+":"+agencyPo.getUserName());
////	}
////	@Test
////	public void testGetSecondAgency(){
////		AgencyBackwardPo abPo = agencyVODao.getSecondAgency("13500608885");
////		System.out.println(abPo == null?"1":abPo.getUserRealName());
////	}
////	@Test
////	public void findUser(){
////		AgencyBackwardPo agencyPo = valiUser.findAgency("123", "3527956B61387FEF9919FAD2F85C55E8");//3527956B61387FEF9919FAD2F85C55E8
////		System.out.println(agencyPo == null);
////	}
//	/**
//	 * @description: 是否有下级代理商
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2018年1月5日 上午10:20:14
//	 */
////	@Test
////	public void testHasSecondAgency(){
////		String userName = "流量代理";
////		int res = agencyVODao.countSecondAgency(userName);//1
//////		if(res > 0){
//////			System.out.println("二级代理商有"+res);
//////		}else{
//////			System.out.println();
//////		}
////		System.out.println("二级代理商有"+res+"个");
////	}
////	@Test
////	public void testListChildrenAgency(){
//////		String userName = "流量代理";//096223
//////		String userName = "LufuLL";//无
//////		String userName = "啊橙";//4
////		String userName = "wechat";
////		List<AgencyBackwardPo> agencyList = agencyVODao.getChildrenAgency(userName);
////		for (AgencyBackwardPo agencyBackwardPo : agencyList) {
////			System.out.println(agencyBackwardPo.getUserName());
//////			System.out.println(agencyBackwardPo.getId());
////		}
////		System.out.println(agencyList.size());
//////		if(res > 0){
//////			System.out.println("二级代理商有"+res);
//////		}else{
//////			System.out.println();
//////		}
//////		System.out.println("二级代理商有"+res+"个");
////	}
//
//}
