package crud.aotest;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.weizu.web.foundation.String.StringHelper;

import com.aiyi.base.pojo.PageParam;
import com.alibaba.fastjson.JSON;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.activity.ao.RateBackwardAO;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;
import com.weizu.flowsys.web.activity.pojo.ScopeDiscount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class RateAOTest {
	
	@Resource
	private RateBackwardAO rateBackwardAO;
	
	@Test
	public void testSelectByPo(){
		Pagination<RateBackwardPo> pagination = rateBackwardAO.selectByPo(null,  new PageParam(1, 10));
		List<RateBackwardPo> list = pagination.getRecords();
		Map<String,Object> map = JSON.parseObject(list.get(0).getRatePrice0(),Map.class);
//		System.out.println(map.get(""));
		System.out.println(JSON.toJSONString(list));
//		for (RateBackwardPo rateBackwardPo : list) {
//			String rate0 = rateBackwardPo.getRatePrice0();
//			String rate1 = rateBackwardPo.getRatePrice1();
//			String rate2 = rateBackwardPo.getRatePrice2();
//			if(StringHelper.isNotEmpty(rate0))
//			{
//				List<ScopeDiscount> list0 = JSON.parseArray(rate0, ScopeDiscount.class);
//				for (ScopeDiscount scopeDiscount : list0) {
//					System.out.println(scopeDiscount.getScopeCityName()+":"+scopeDiscount.getChannelDiscount());
//				}
//			}
//			if(StringHelper.isNotEmpty(rate1))
//			{
//				List<ScopeDiscount> list1 = JSON.parseArray(rate1, ScopeDiscount.class);
//				for (ScopeDiscount scopeDiscount : list1) {
//					System.out.println(scopeDiscount.getScopeCityName()+":"+scopeDiscount.getChannelDiscount());
//				}
//			}
//			if(StringHelper.isNotEmpty(rate2))
//			{
//				List<ScopeDiscount> list2 = JSON.parseArray(rate2, ScopeDiscount.class);
//				for (ScopeDiscount scopeDiscount : list2) {
//					System.out.println(scopeDiscount.getScopeCityName()+":"+scopeDiscount.getChannelDiscount());
//				}
//			}
//			
//		}
		if(pagination == null){
			System.out.println("no");
		}
		System.out.println(pagination.getRecords().size());
	}
//	@Test
//	public void testGetRateById(){
//		RateBackwardPo rate = rateBackwardAO.getByPoId(7L);
//		String ratePrice0 = rate.getRatePrice0();
//		System.out.println(ratePrice0);
////		rate.get
//	}
	
}
