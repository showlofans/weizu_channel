//package crud.aotest.apiTest;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.api.singleton.BalanceDTO;
//import com.weizu.flowsys.api.singleton.BaseInterface;
//import com.weizu.flowsys.api.singleton.BaseP;
//import com.weizu.flowsys.api.singleton.OrderDTO;
//import com.weizu.flowsys.api.singleton.SingletonFactory;
//import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
//import com.weizu.flowsys.operatorPg.enums.OrderResultEnum;
//import com.weizu.flowsys.util.StringUtil2;
//import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
//import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
//import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
//import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
//import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
//import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
//import com.weizu.web.foundation.DateUtil;
//
///**
// * @description: Zxpay 接口测试
// * @projectName:weizu-channel
// * @className:ZxpayTest.java
// * @author:微族通道代码设计人 宁强
// * @createTime:2017年12月21日 下午4:48:26
// * @version 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class LiuLiangHuiTest {
//	
//	@Resource
//	private ExchangePlatformDao exchangePlatformDao;
//	@Resource
//	private ExchangePlatformAO exchangePlatformAO;
//	@Resource
//	private IProductCodeDAO productDAO;
//	@Resource
//	private ProductCodeAO productCodeAO;
//	
////	@Test
////	public void testBalance(){
//////		ExchangePlatformPo epPo = exchangePlatformDao.get(43);
//////		System.out.println("apikey:"+epPo.getEpApikey());
////		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("红茄科技测试");
////		ProductCodePo pc = productCodeAO.getOneProductCodeByPg(41);//3元10M省漫游移动
////		BaseInterface bi = SingletonFactory.getSingleton(platformPo.getEpEngId(), new BaseP(pc,726633391352451072l,null,platformPo,DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss")));
//////		System.out.println(bi.toParams());
//////		System.out.println(bi.toBalanceParams());
////		BalanceDTO balanceDTO = bi.getBalance();
//////		System.out.println(balanceDTO.getTipCode() + "<----->" + balanceDTO.getTipMsg());
//////		System.out.println(balanceDTO.getAccountBalance());
////	}
////	
//	@Test
//	public void testGetState(){
//		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("广州彩趣流量");
//		String mchId = StringUtil2.getParamsByCharSeq(platformPo.getEpOtherParams(), "mch_id");
//		System.out.println(mchId.substring(mchId.indexOf("=")+1));
////		ProductCodePo dataPo = productCodeAO.getOneProductCodeByPg(41);//3元10M省漫游移动  
////		ProductCodePo dataPo = new ProductCodePo();
////		dataPo.setProductCode("2003");
////		BaseP baseP = new BaseP(dataPo,"123",null,platformPo,DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss"));
////		baseP.setOrderId(776978753887670272l);
////		BaseInterface bi = SingletonFactory.getSingleton(platformPo.getEpEngId(), baseP);//其它参数用订单实际到达时间代替
////		
////		OrderDTO orderDTO = bi.getOrderState();
////		if(orderDTO != null){
////			System.out.println(orderDTO.getRspCode() + "<------>" + orderDTO.getRspMsg());	
////			System.out.println(orderDTO.getOrderIn() == null?"":orderDTO.getOrderIn().toString());
////		}
//	}
////	@Test
////	public void testCharge(){
//////	orderIdApi 20171222135332792463890
//////			ChargeOrder [orderIdApi=20171222135332792463890, number=13699562589, pgSize=10, billType=0, otherParams=null]
////		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("广州彩趣流量-测试");
//////		ProductCodePo dataPo = productCodeAO.getOneProductCodeByPg(66);//3元10M省内移动
//////		ProductCodePo dataPo = productCodeAO.getOneProductCodeByPg(41);//3元10M省漫游移动
////		ProductCodePo dataPo = new ProductCodePo();
////		dataPo.setProductCode("2003");
////		BaseInterface bi = SingletonFactory.getSingleton(platformPo.getEpEngId(), new BaseP(dataPo,776978753887670272l,"15112799915",platformPo,DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss")));//其它参数用订单实际到达时间代替
////		ChargeDTO chargeDTO = bi.charge();
////		if(chargeDTO != null){
////			System.out.println(OrderResultEnum.getEnum(chargeDTO.getTipCode()).getMsg() + "：" + chargeDTO.getTipMsg());
////			if(chargeDTO.getChargeOrder() != null){
////				System.out.println(chargeDTO.getChargeOrder().toString());
////			}
////		}
////	}
//	
//	
//}
