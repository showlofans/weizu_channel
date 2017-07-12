package crud.aotest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.web.activity.dao.RateDiscountDao;
import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class RateDiscountDaoTest {
	@Resource
	private RateDiscountDao rateDiscountDao;
	
//	@Test
//	public void testGetDiscountList(){
//		RateDiscountPo ratePo = new RateDiscountPo(0, 0, null, null, null);
//		ratePo.setChannelId(7l);
//		List<RateDiscountPo> resList = rateDiscountDao.getRateDiscountList(ratePo);
//		System.out.println(resList.size());
//	}
}
