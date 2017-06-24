package crud.aotest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.web.activity.dao.IOperatorDiscountDao;
import com.weizu.flowsys.web.activity.pojo.OperatorDiscountPo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class OperatorDiscountTest {
	@Resource
	private IOperatorDiscountDao operatorDiscountDao;
	@Test
	public void testGetOneDiscount(){
		OperatorDiscountPo po = new OperatorDiscountPo();
		po.setScopeName("浙江");
		po.setRateId(12L);
		
		OperatorDiscountPo res = operatorDiscountDao.selectOneDiscountByPo(po);
		System.out.println(res);
	}
}
