//package crud.aotest.apiTest;
//
//import java.io.UnsupportedEncodingException;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.weizu.api.outter.enums.ChargeStatusEnum;
//
//import com.weizu.flowsys.api.weizu.charge.ChargeParams;
//import com.weizu.flowsys.api.weizu.charge.ChargeTelParams;
//import com.weizu.flowsys.api.weizu.facet.IBalanceFacet;
//import com.weizu.flowsys.api.weizu.facet.IChargeFacet;
//import com.weizu.flowsys.api.weizu.facet.IOrderFacet;
//import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.TelServiceTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
//import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
//import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
//import com.weizu.flowsys.web.http.entity.Charge;
//import com.weizu.flowsys.web.http.entity.ChargeTel;
//import com.weizu.web.foundation.MD5;
//import com.weizu.web.foundation.hash.Hash;
//
///**
// * @description:
// * @projectName:weizu-channel
// * @className:MyApiTest.java
// * @author:微族通道代码设计人 宁强
// * @createTime:2017年8月31日 下午4:37:19
// * @version 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class MyApiTest {
//	@Resource
//	private IBalanceFacet balanceFacade;
//	@Resource
//	private AgencyVODaoInterface agencyVODao;
//	@Resource
//	private IChargeFacet chargeImpl;
//	@Resource
//	private IOrderFacet orderFacade;
//	
//	
////	/**
////	 * @description: 查询余额
////	 * @author:微族通道代码设计人 宁强
////	 * @createTime:2017年8月31日 下午4:46:04
////	 */
////	@Test
////	public void testBalance(){
////		
//////		String apikey =backPo.getUserApiKey(); 
////		String sign = "";
////		try {
////			sign = MD5.getMd5("userName="+"123&userPass=123456"+"&apikey="+"8a982a8a5e9fd1c1015e9fd1c1900000",null,null);
////		} catch (UnsupportedEncodingException e) {
////			e.printStackTrace();
////		}
////		BalanceDTO balanceDTO = balanceFacade.myBalance("123", sign, 1);
////		System.out.println(balanceDTO.getTipMsg());
////		System.out.println(balanceDTO.getTipCode());
////		System.out.println(balanceDTO.getAccountBalance());
//////		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("123");
//////		if(backPo == null){
//////			System.out.println("不是二级代理商");
//////		}else{
//////			String sign = "";
//////			BalanceDTO balanceDTO = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//////			System.out.println(BillTypeEnum.getEnum(balanceDTO.getBillType()).getDesc() + ":" + balanceDTO.getAccountBalance());
//////			System.out.println(balanceDTO.getRspMsg());
//////			
//////			BalanceDTO balanceDTO1 = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.CORPORATE_BUSINESS.getValue());
////////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//////			System.out.println(BillTypeEnum.getEnum(balanceDTO1.getBillType()).getDesc() + ":" + balanceDTO1.getAccountBalance());
//////			System.out.println(balanceDTO1.getRspMsg());
//////		}
////	}
//	/**
//	 * @description: 测试订单状态
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年9月1日 下午6:14:37
//	 */
////	@Test
////	public void testOrder(){
////		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("123");
////		if(backPo == null){
////			System.out.println("不是二级代理商");
////		}else{
////			String sign = "";
////			String apikey =backPo.getUserApiKey(); 
////			String userPass = "";
////			try {
////				userPass = Hash.BASE_UTIL.decode(backPo.getUserPass());
////				sign = MD5.getMd5("userName="+backPo.getUserName() +"&userPass="+ userPass +"&apikey="+apikey,null,null);
////			} catch (UnsupportedEncodingException e) {
////				e.printStackTrace();
////			}
////			Order order = orderFacade.getOrder(new QueryOrderParams(backPo.getUserName(), sign, 746904607271161856l, null));
////			OrderPo orderPo = order.getOrderPo();
//////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//////			System.out.println(balanceDTO.getAccountBalance());
//////			System.out.println(orderPo.toString());
////			System.out.println(order.getTipMsg());
////			System.out.println(orderPo.getStatus());
////			System.out.println(orderPo.getStatusMSg());
//////			System.out.println(orderPo.getStatusMSg());
//////			System.out.println(orderPo.getNumber());
////		}
////	}
//	/**
//	 * @description: 测试充值
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年9月1日 下午6:14:45
//	 */
////	@Test
////	public void testCharge(){
////		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("xiaoning");
////		String sign = "";
////		String apikey =backPo.getUserApiKey(); 
////		String userPass = "";
////		try {
////			userPass = Hash.BASE_UTIL.decode(backPo.getUserPass());
////			sign = MD5.getMd5("userName="+backPo.getUserName()+"&userPass="+ userPass + "&apikey="+apikey,null,null);
////		} catch (UnsupportedEncodingException e) {
////			e.printStackTrace();
////		}
////		
////		Charge charge = null;
////		try {
////			charge = chargeImpl.charge(new ChargeParams(backPo.getUserName(), "13804828479", 10, 2, sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue(), System.currentTimeMillis()));
////		} catch (Exception e) {
////			charge = new Charge(ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc(), null);
////			System.out.println();
////			e.printStackTrace();
////		}
////		if(charge != null){
////			System.out.println(charge.getTipMsg());
////		}
//////		System.out.println(ChargeStatusEnum.CHANNEL_CLOSED.getDesc());
////		
//////		BalanceDTO balanceDTO = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////		
//////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//////		System.out.println(balanceDTO.getAccountBalance());
////	}
//	//下游充值
//	@Test
//	public void testChargeTel(){
//		String userName = "xiaoning";
//		AgencyBackwardPo backPo = agencyVODao.getSecondAgency(userName);
//		String sign = "";
//		String apikey =backPo.getUserApiKey(); 
//		String userPass = "";
//		try {
//			userPass = Hash.BASE_UTIL.decode(backPo.getUserPass());
//			sign = MD5.getMd5("userName="+backPo.getUserName()+"&userPass="+ userPass + "&apikey="+apikey,null,null);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		ChargeTel chargeTelPo = null;
//		ChargeTelParams ctp = new ChargeTelParams("13699562589", userName, sign, 10d);
//		ctp.setChargeSpeed(TelchargeSpeedEnum.FAST.getValue());
//		ctp.setServiceType(TelServiceTypeEnum.NATION_WIDE.getValue());
//		ctp.setBillType(BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		try {
//			chargeTelPo = chargeImpl.charge(ctp);
//		} catch (Exception e) {
//			chargeTelPo = new ChargeTel(ChargeStatusEnum.CHARGE_INNER_ERROR.getValue(), ChargeStatusEnum.CHARGE_INNER_ERROR.getDesc(), null);
//			System.out.println("1");
//			e.printStackTrace();
//		}
//		if(chargeTelPo != null){
//			if(chargeTelPo.getChargeTelPo() != null){
//				System.out.println(chargeTelPo.getChargeTelPo().getOrderId());
//			}
//			System.out.println(chargeTelPo.getTipMsg());
//		}else{
//			System.out.println("chargeTelPo:"+chargeTelPo==null);
//		}
////		System.out.println(ChargeStatusEnum.CHANNEL_CLOSED.getDesc());
//		
////		BalanceDTO balanceDTO = balanceFacade.myBalance(backPo.getUserName(), sign, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		
////		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
////		System.out.println(balanceDTO.getAccountBalance());
//	}
////	@Test
////	public void testCallBack(){
////		String res = HttpRequest.sendGet("https://www.91weizu.cn/flowsys/callBack/weizu.do", "errcode=1&transaction_id=2&user_order_id=2&number=1&status=1");
////		System.out.println(res);
////	}
////	@Test
////	public void testGetProductList(){
////		AgencyBackwardPo backPo = agencyVODao.getSecondAgency("xiaoning");
////		String sign = "";
////		String apikey =backPo.getUserApiKey(); 
////		String userPass = "";
////		try {
////			userPass = Hash.BASE_UTIL.decode(backPo.getUserPass());
////			sign = MD5.getMd5("userName="+backPo.getUserName()+"&userPass="+ userPass + "&apikey="+apikey,null,null);
////		} catch (UnsupportedEncodingException e) {
////			e.printStackTrace();
////		}
//////		String res =WxPaySendPost.sendGet("https://www.91weizu.cn/flowsys/weizuAPI/my_pgproduct_list", "userName=xiaoning&sign="+sign);
////		String res =HttpRequest.sendGet("https://www.91weizu.cn/flowsys/weizuAPI/my_pgproduct_list", "userName=xiaoning&sign="+sign);
////		
////		System.out.println(res);
////	}
//	
//}
