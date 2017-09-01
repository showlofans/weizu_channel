package crud.aotest.apiTest;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.weizu.facet.IBalanceFacet;
import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
import com.weizu.flowsys.api.weizu.facet.IOrderFacet;
import com.weizu.flowsys.api.weizu.order.QueryOrderParams;
import com.weizu.flowsys.operatorPg.enums.AccountTypeEnum;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.http.HttpRequest;

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
	@Resource
	private IChargeFacet chargeImpl;
	@Resource
	private IOrderFacet orderFacade;
	
	
//	/**
//	 * @description: 查询余额
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月31日 下午4:46:04
//	 */
//	@Test
//	public void testBalance(){
//		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("123");
//		if(backPo == null){
//			System.out.println("不是二级代理商");
//		}else{
//			String sign = "";
//			String apikey =backPo.getUserApiKey(); 
//			try {
//				sign = MD5.getMd5("username="+backPo.getUserName()+"&apikey="+apikey,null,null);
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			BalanceDTO balanceDTO = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//			System.out.println(BillTypeEnum.getEnum(balanceDTO.getBillType()).getDesc() + ":" + balanceDTO.getAccountBalance());
//			System.out.println(balanceDTO.getRspMsg());
//			
//			BalanceDTO balanceDTO1 = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.CORPORATE_BUSINESS.getValue());
////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//			System.out.println(BillTypeEnum.getEnum(balanceDTO1.getBillType()).getDesc() + ":" + balanceDTO1.getAccountBalance());
//			System.out.println(balanceDTO1.getRspMsg());
//		}
//	}
	/**
	 * @description: 测试订单状态
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午6:14:37
	 */
	@Test
	public void testOrder(){
		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("123");
		if(backPo == null){
			System.out.println("不是二级代理商");
		}else{
			String sign = "";
			String apikey =backPo.getUserApiKey(); 
			try {
				sign = MD5.getMd5("username="+backPo.getUserName()+"&apikey="+apikey,null,null);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			OrderDTO orderDTO = orderFacade.getOrderDTO(new QueryOrderParams(backPo.getUserName(), sign, 726614433270337536l, "15014369834"));
			
//		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//			System.out.println(balanceDTO.getAccountBalance());
			System.out.println(orderDTO.getRspMsg());
			System.out.println(orderDTO.getOrderIn().getNumber());
		}
	}
	/**
	 * @description: 测试充值
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午6:14:45
	 */
//	@Test
//	public void testCharge(){
//		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("456");
//		String sign = "";
//		String apikey =backPo.getUserApiKey(); 
//		try {
//			sign = MD5.getMd5("username="+backPo.getUserName()+"&apikey="+apikey,null,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		BalanceDTO balanceDTO = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		
////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//		System.out.println(balanceDTO.getAccountBalance());
//		System.out.println(balanceDTO.getRspMsg());
//	}
	
}
