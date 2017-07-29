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
import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
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
//	@Test
//	public void testCountRateDisocunt(){
//		RateDiscountPo ratePo = new RateDiscountPo();
//		ratePo.setActiveDiscount(0.95);
//		ratePo.setBillType(1);
//		ratePo.setChannelDiscountId(12l);
//		String t = rateDiscountAO.addRateDiscount(ratePo);//添加一定要有billType，通道折扣id和费率折扣
//		System.out.println(t);
//		
//	}
	
//	@Test
//	public void testGetShowRate(){
//		Map<String,Object>  dtoMap = rateDiscountAO.getShowRate(27);
//		RateDiscountShowDTO dto = (RateDiscountShowDTO) dtoMap.get("billDTO");
//		RateDiscountShowDTO dto1 = (RateDiscountShowDTO) dtoMap.get("noDTO");
//		System.out.println(dto.getBillType());;
//		System.out.println(dto.getDiscountPo().getDiscount0());;
//		System.out.println(dto.getDiscountPo().getDiscount1());;
//		System.out.println(dto.getDiscountPo().getDiscount2());;
//		System.out.println(dto1.getBillType());;
//		System.out.println(dto1.getDiscountPo().getDiscount0());;
//		System.out.println(dto1.getDiscountPo().getDiscount1());;
//		System.out.println(dto1.getDiscountPo().getDiscount2());;
//	}
	@Test
	public void testAddMyRate(){
		RateDiscountPo ratePo = new RateDiscountPo();
		ratePo.setId(46L);
//		ratePo.setActiveDiscount(0.99);
		ratePo.setBillType(0);
		String res = rateDiscountAO.updateRateDiscount(ratePo);
		System.out.println(res);
	}
//	@Test
//	public void testUpdateMyRate(){
//		RateDiscountPo ratePo = new RateDiscountPo();
//		ratePo.setId(46L);
////		ratePo.setActiveDiscount(0.99);
//		ratePo.setBillType(0);
//		String res = rateDiscountAO.updateRateDiscount(ratePo);
//		System.out.println(res);
//	}
//	@Test
//	public void testGetMyRateList(){
//		RateDiscountPo ratePo = new RateDiscountPo();
//		Pagination<RateDiscountPo>  pagination = rateDiscountAO.getMyRateList(ratePo, new PageParam(1, 10));
//		List<RateDiscountPo> records = pagination.getRecords();
//		for (RateDiscountPo rateDiscountPo : records) {
//			
//		}
//	}
}
