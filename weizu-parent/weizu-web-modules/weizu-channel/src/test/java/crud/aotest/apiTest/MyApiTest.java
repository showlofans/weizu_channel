package crud.aotest.apiTest;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.weizu.facet.IBalanceFacet;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.web.foundation.MD5;

/**
 * @description:
 * @projectName:weizu-channel
 * @className:MyApiTest.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月31日 下午4:37:19
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class MyApiTest {
	@Resource
	private IBalanceFacet balanceFacade;
	@Resource
	private AgencyVODaoInterface agencyVODao;
	
	
	/**
	 * @description: 查询余额
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月31日 下午4:46:04
	 */
//	@Test
//	public void testBalance(){
//		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("456");
//		String sign = "";
//		String apikey =backPo.getUserApiKey(); 
//		try {
//			sign = MD5.getMd5("username="+backPo.getUserName()+"&apikey="+apikey,null,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		BalanceDTO balanceDTO = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		System.out.println(balanceDTO.getAccountBalance());
//		System.out.println(balanceDTO.getRspMsg());
//	}
	
}
