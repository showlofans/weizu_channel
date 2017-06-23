package crud.aotest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.web.activity.ao.RateBackwardAO;
import com.weizu.flowsys.web.activity.pojo.RateBackwardPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class RateAOTest {
	
	@Resource
	private RateBackwardAO rateBackwardAO;
	
//	@Test
//	public void testSelectByPo(){
//		Pagination<RateBackwardPo> pagination = rateBackwardAO.selectByPo(null,  new PageParam(1, 10));
//		
//		if(pagination == null){
//			System.out.println("no");
//		}
//		System.out.println(pagination.getRecords().size());
//	}
//	@Test
//	public void testGetRateById(){
//		RateBackwardPo rate = rateBackwardAO.getByPoId(7L);
//		String ratePrice0 = rate.getRatePrice0();
//		System.out.println(ratePrice0);
////		rate.get
//	}
}
