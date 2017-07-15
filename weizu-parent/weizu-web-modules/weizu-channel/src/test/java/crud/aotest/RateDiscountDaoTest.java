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
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.AgencyActiveRatePo;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class RateDiscountDaoTest {
	@Resource
	private RateDiscountDao rateDiscountDao;
	
	@Resource
	private RateDiscountAO rateDiscountAO;
	
	@Resource
	private AgencyActiveChannelAO agencyActiveChannelAO;
	
//	@Test
//	public void testGetDiscountList(){
////		RateDiscountPo ratePo = new RateDiscountPo(0, 0,,null, null, null, null);
//		List<RateDiscountPo> resList = rateDiscountDao.getListByCDiscountId(13l,1);
////		RateDiscountPo ratePo = new RateDiscountPo();
////		ratePo.setChannelId(12l);
////		List<RateDiscountPo> resList = rateDiscountDao.getRateDiscountList(ratePo);
//		System.out.println(resList.size());
//	}
	
//	@Test
//	public void testGetDisocuntRateList(){
//		RateDiscountPo ratePo = new RateDiscountPo(0, 0, null, null, null);
//		Map<String,Object> mapt = rateDiscountAO.getOperatorListRate(ratePo);
////		Pagination<AgencyActiveChannelPo> pagination = agencyActiveChannelAO.listActiveRate(new PageParam(1, 10), ratePo);
////		List<AgencyActiveChannelPo> records = pagination.getRecords();
//		
//		
////		for(Map<String,Object> scope: ScopeCityEnum.toList()){
////			Map<String,Object> map = mapt.get(scope.get("value"));
////			if(map == null){
////				
////			}else{
////				System.out.println(scope.get("value").toString());;//获得折扣
////			}
////		}
//	}
	
//	@Test
//	public void testGetListByCDiscountId(){
//		List<RateDiscountPo> rateList = rateDiscountDao.getListByCDiscountId(l);
//		System.out.println(rateList.size());
//	}
}
