//package crud.aotest;
//
//import java.util.LinkedList;
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
//import com.weizu.flowsys.operatorPg.enums.OperatorNameEnum;
//import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.ScopeCityEnum;
//import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
//import com.weizu.flowsys.web.activity.ao.ServiceScopeAO;
//import com.weizu.flowsys.web.activity.pojo.ServiceScopePo;
//import com.weizu.web.foundation.String.StringHelper;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ServiceScopeAOTest {
//	
//	@Resource
//	private ServiceScopeAO serviceScopeAO;
//	
//	@Test
//	public void testList(){
//		List operatorTypes = serviceScopeAO.listOperatorType();
//		List scopeCityNames = serviceScopeAO.listScopeCityName();
//		List serviceTypes = serviceScopeAO.listServiceType();
//		
//		for (Object object : serviceTypes) {
//			System.out.println((int)object);
//		}
//		for (Object object : scopeCityNames) {
//			System.out.println(object.toString());
//		}
//		for (Object object : operatorTypes) {
//			System.out.println((int)object);
//		}
//	}
//	
////	@Test
////	public void testGetScopeId(){
////		ServiceScopePo serviceScopePo = new ServiceScopePo();
////		serviceScopePo.setOperatorType(0);	//运营商：移动
////		serviceScopePo.setScopeCityName("广东");
////		serviceScopePo.setServiceType(0);//流量类型：全国
////		//要求只能返回一个（地区，流量类型，运营商只能对应一个流量包范围ID）
////		String scopeId = serviceScopeAO.getServiceScopeId(serviceScopePo);
////		System.out.println(scopeId);
////	}
//	
////	@Test
////	public void testScope_addList(){
////		List<ServiceScopePo> list = new LinkedList<ServiceScopePo>();
////		
////		List<Map<String,Object>> scopeCityEnum = ScopeCityEnum.toList();//城市名和城市编码
////		
////		List<Map<String,Object>> serviceTypeEnum = ServiceTypeEnum.toList();//业务类型
////		
////		List<Map<String,Object>> operatorTypeEnum = OperatorTypeEnum.toList();//运营商类型
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
////				}
////			}
////		}
////		
////		int result = serviceScopeAO.scope_addList(list);
////		System.out.println("总记录数："+ result);
////	}
//}
