package crud.aotest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.web.channel.ao.OperatorPgAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class OperatorPgAOImplTest {
	
	@Resource
	private OperatorPgAO operatorPgAO;
	
//	@Test
//	public void testAddPgList(){
//		
////		List<Map<String,Object>> serviceTypeEnum = ServiceTypeEnum.toList();//业务类型
////		
////		List<Map<String,Object>> operatorTypeEnum = OperatorTypeEnum.toList();//运营商类型
////		
////		List<Map<String,Object>> pgSizeEnum = PgSizeEnum.toList();		//流量包大小
////		
////		String operatorName =  "";//运营商名称
////		
////		for (Map<String, Object> map1 : operatorTypeEnum) {
////			Integer operatorType = null;
////			String operatorTypeStr = map1.get("value").toString();
////			if(StringHelper.isNotEmpty(operatorTypeStr)){
////				operatorType = Integer.parseInt(operatorTypeStr);
////				//根据运营商类型选择运营商名称
////				switch (operatorType) {
////				case 0:
////					operatorName = OperatorNameEnum.CHINAMOBILE.getValue();
////					break;
////				case 1:
////					operatorName = OperatorNameEnum.CHINALINK.getValue();
////					break;
////				case 2:
////					operatorName = OperatorNameEnum.CHINATELECOME.getValue();
////					break;
////				default:
////					break;
////				}
////				
////			}
////			for (Map<String, Object> map2 : serviceTypeEnum) {
////				Integer serviceType = null;
////				String serviceTypeStr = map2.get("value").toString();
////				if(StringHelper.isNotEmpty(serviceTypeStr)){
////					serviceType = Integer.parseInt(serviceTypeStr);
////				}
////				for (Map<String, Object> map3 : scopeCityEnum) {
////					String scopeCityName =  map3.get("desc").toString();
////					String scopeCityCode = map3.get("value").toString();
////					StringBuffer sbId = new StringBuffer();
////					String id = sbId.append(scopeCityCode).append(operatorType).append(serviceType).toString();//业务范围ID
////					ServiceScopePo serviceScopePo = new ServiceScopePo(id, scopeCityCode, serviceType, operatorType, operatorName, scopeCityName);
////					list.add(serviceScopePo);
////				}}
////			}
//	}
	
//	@Test
//	public void testListPg(){
//		PageParam pageParam = new PageParam(1,10);
//		Map<String,Object> params = new HashMap<String, Object>();
//		Pagination<OperatorPgDataPo> pagination =  operatorPgAO.listPg(params, pageParam);
//		System.out.println(pagination.getRecords().get(1));
//		
//	}
	/**
	 * @description:查询通道规格列表
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月16日 下午12:08:08
	 */
//	@Test
//	public void testPgSizeList(){
//		List pgSize = operatorPgAO.pgSizeList(0,0);
//		for (Object object : pgSize) {
//			System.out.println(Integer.parseInt(object.toString()));
//		}
//	}
}
