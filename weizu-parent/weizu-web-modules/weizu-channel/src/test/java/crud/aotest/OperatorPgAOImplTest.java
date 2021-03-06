//package crud.aotest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.aiyi.base.pojo.PageParam;
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.operatorPg.enums.ChannelTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.ChannelUseStateEnum;
//import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.PgTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.PgValidityEnum;
//import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
//import com.weizu.flowsys.util.Pagination;
//import com.weizu.flowsys.web.channel.ao.OperatorPgAO;
//import com.weizu.flowsys.web.channel.dao.OperatorPgDaoInterface;
//import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
//import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
//import com.weizu.flowsys.web.channel.pojo.PgDataPo;
//import com.weizu.flowsys.web.http.entity.PgProductPo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class OperatorPgAOImplTest {
//	
//	@Resource
//	private OperatorPgAO operatorPgAO;
//	@Resource
//	private OperatorPgDaoInterface operatorPgDao;
//	
////	@Test
////	public void testAddPgList(){
////		
//////		List<Map<String,Object>> serviceTypeEnum = ServiceTypeEnum.toList();//业务类型
//////		
//////		List<Map<String,Object>> operatorTypeEnum = OperatorTypeEnum.toList();//运营商类型
//////		
//////		List<Map<String,Object>> pgSizeEnum = PgSizeEnum.toList();		//流量包大小
//////		
//////		String operatorName =  "";//运营商名称
//////		
//////		for (Map<String, Object> map1 : operatorTypeEnum) {
//////			Integer operatorType = null;
//////			String operatorTypeStr = map1.get("value").toString();
//////			if(StringHelper.isNotEmpty(operatorTypeStr)){
//////				operatorType = Integer.parseInt(operatorTypeStr);
//////				//根据运营商类型选择运营商名称
//////				switch (operatorType) {
//////				case 0:
//////					operatorName = OperatorNameEnum.CHINAMOBILE.getValue();
//////					break;
//////				case 1:
//////					operatorName = OperatorNameEnum.CHINALINK.getValue();
//////					break;
//////				case 2:
//////					operatorName = OperatorNameEnum.CHINATELECOME.getValue();
//////					break;
//////				default:
//////					break;
//////				}
//////				
//////			}
//////			for (Map<String, Object> map2 : serviceTypeEnum) {
//////				Integer serviceType = null;
//////				String serviceTypeStr = map2.get("value").toString();
//////				if(StringHelper.isNotEmpty(serviceTypeStr)){
//////					serviceType = Integer.parseInt(serviceTypeStr);
//////				}
//////				for (Map<String, Object> map3 : scopeCityEnum) {
//////					String scopeCityName =  map3.get("desc").toString();
//////					String scopeCityCode = map3.get("value").toString();
//////					StringBuffer sbId = new StringBuffer();
//////					String id = sbId.append(scopeCityCode).append(operatorType).append(serviceType).toString();//业务范围ID
//////					ServiceScopePo serviceScopePo = new ServiceScopePo(id, scopeCityCode, serviceType, operatorType, operatorName, scopeCityName);
//////					list.add(serviceScopePo);
//////				}}
//////			}
////	}
//	
////	@Test
////	public void testListPg(){
////		PageParam pageParam = new PageParam(1,10);
//////		Map<String,Object> params = new HashMap<String, Object>();
////		OperatorPgDataPo pgPo = new OperatorPgDataPo();
////		Pagination<PgDataPo> pagination =  operatorPgAO.listPg(pgPo, pageParam);
////		List<PgDataPo> pgList = pagination.getRecords();
////		for (PgDataPo pgData : pgList) {
////			System.out.println("pgType:" + pgData.getPgType());
////			System.out.println("getPgValidity:" + pgData.getPgValidity());
////			System.out.println("getCirculateWay:" + pgData.getCirculateWay());
////		}
////	}
////	@Test
////	public void pg_list_for_purchase(){
////		ChargeChannelParamsPo paramsPo = new ChargeChannelParamsPo(null, ServiceTypeEnum.PROVINCE.getValue(), PgTypeEnum.PGDATA.getValue(), PgValidityEnum.MONTH_DAY_DATA.getValue(), ChannelTypeEnum.ORDINARY.getValue());
////		paramsPo.setOperatorType(OperatorTypeEnum.MOBILE.getValue());
////		paramsPo.setScopeCityCode("26");
////		List<PgDataPo> pgList = operatorPgAO.pg_list_for_purchase(paramsPo, 101);
////		for (PgDataPo pgDataPo : pgList) {
////			System.out.println(pgDataPo.getPgName());
////			System.out.println(pgDataPo.getChannelId());
////		}
////	}
//	
//	/**
//	 * @description:
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年11月9日 上午11:12:34
//	 */
//	@Test
//	public void getProductList(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("agencyId", 2);
//		map.put("bindState", 0);
//		map.put("channelUseState", ChannelUseStateEnum.OPEN.getValue());
//		List<PgProductPo> pgList =  operatorPgDao.getProductPgList(map);
////		System.out.println(JSON.toJSON(pgList));
//		int size = 0;
//		for (PgProductPo pgProductPo : pgList) {
//			size += pgProductPo.getPgDataList().size();
//			System.out.println("" + pgProductPo.getChannelName() + ":" + pgProductPo.getScopeCityCode() + "\t" + JSON.toJSONString(pgProductPo.getPgDataList()));
//		}
//		System.out.println(size);
//	}
//	
////	@Test
////	public void testPgList_forPurchase(){
////		OperatorPgDataPo operatorPgPo = new OperatorPgDataPo();
////		operatorPgPo.setOperatorType(0);
////		operatorPgPo.setServiceType(0);
//////		operatorPgPo.set
////		List<OperatorPgDataPo> list = operatorPgAO.pgList_forPurchase(operatorPgPo,"19", 4);
////		System.out.println(list == null ?"": list.size());
////		if(list != null && list.size() > 0){
////			for (OperatorPgDataPo operatorPgDataPo : list) {
//////				System.out.println(operatorPgDataPo.getRteId());
//////				System.out.println(operatorPgDataPo.getChannelId());
////				System.out.println(operatorPgDataPo.getOperatorType());
////			}
////		}
////	}
//	
//	/**
//	 * @description:查询通道规格列表
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年5月16日 下午12:08:08
//	 */
////	@Test
////	public void testPgSizeList(){
////		List pgSize = operatorPgAO.pgSizeList(0,0);
////		for (Object object : pgSize) {
////			System.out.println(Integer.parseInt(object.toString()));
////		}
////	}
////	@Test
////	public void testPgListNoCode(){
////		List<OperatorPgDataPo> list = operatorPgDao.listPgListNotInPcode(2, ServiceTypeEnum.PROVINCE_ROAMING.getValue(), 0,"19");
////		System.out.println(list.size());
////	}
////	@Test
////	public void testPgListCode(){
////		Map<String,Object> map = operatorPgAO.getBy(new SuperPurchaseParam("广东移动", "0", "Weizu"));
////		List<OperatorPgDataPo> list = (List<OperatorPgDataPo>) map.get("pgList");
////		System.out.println(list.size());
////		if(list != null && list.size() > 0){
////			for (OperatorPgDataPo operatorPgDataPo : list) {
////				System.out.println(operatorPgDataPo.getCdisId());
////				System.out.println(operatorPgDataPo.getChannelId());
////			}
////		}
////	}
////	@Test
////	public void testGetPgByChannel(){
////		Map<String,Object> map= new HashMap<String, Object>();
////		map.put("channelId", 16);
////		List<OperatorPgDataPo> list = operatorPgDao.getPgByChanel(map);
////		if(list!= null && list.size() > 0){
////			for (OperatorPgDataPo operatorPgDataPo : list) {
////				System.out.println(operatorPgDataPo.getPgName());
////			}
////		}
////	}
//}
