package crud.aotest.apiTest;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.weizu.api.outter.enums.ChargeStatusEnum;

import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeParams;
import com.weizu.flowsys.api.weizu.facet.IBalanceFacet;
import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
import com.weizu.flowsys.api.weizu.facet.IOrderFacet;
import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
import com.weizu.flowsys.web.http.entity.Charge;
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
//	@Test
//	public void testOrder(){
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
//			Order order = orderFacade.getOrder(new QueryOrderParams(backPo.getUserName(), sign, 726614433270337536l, "15014369834"));
//			OrderPo orderPo = order.getOrderPo();
////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
////			System.out.println(balanceDTO.getAccountBalance());
////			System.out.println(orderPo.toString());
//			System.out.println(order.getRspMsg());
////			System.out.println(orderPo.getStatusMSg());
////			System.out.println(orderPo.getNumber());
//		}
//	}
	/**
	 * @description: 测试充值
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月1日 下午6:14:45
	 */
//	@Test
//	public void testCharge(){
//		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("123");
//		String sign = "";
//		String apikey =backPo.getUserApiKey(); 
//		try {
//			sign = MD5.getMd5("username="+backPo.getUserName()+"&apikey="+apikey,null,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		Charge charge = null;
//		try {
//			charge = chargeImpl.charge(new ChargeParams(backPo.getUserName(), "15014369834", 500, 0, sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue(), "123456123"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if(charge != null){
//			System.out.println(charge.getTipMsg());
//		}
////		System.out.println(ChargeStatusEnum.CHANNEL_CLOSED.getDesc());
//		
////		BalanceDTO balanceDTO = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		
////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
////		System.out.println(balanceDTO.getAccountBalance());
//	}
	
}
