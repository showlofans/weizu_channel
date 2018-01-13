//package crud.aotest;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.operatorPg.enums.OperatorTypeEnum;
//import com.weizu.flowsys.web.activity.ao.RateDiscountAO;
//import com.weizu.flowsys.web.activity.pojo.RateDiscountPo;
//import com.weizu.flowsys.web.channel.ao.ProductCodeAO;
//import com.weizu.flowsys.web.channel.dao.ChannelChannelDao;
//import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
//import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
//import com.weizu.flowsys.web.channel.pojo.ChargeChannelParamsPo;
//import com.weizu.flowsys.web.channel.pojo.OneCodePo;
//import com.weizu.flowsys.web.channel.pojo.OperatorPgDataPo;
//import com.weizu.flowsys.web.channel.pojo.PgDataPo;
//import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
//import com.weizu.flowsys.web.http.ao.ValiUser;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ProductCodeAOTest {
//	
//	@Resource
//	private ProductCodeAO productCodeAO;
//	@Resource
//	private IProductCodeDAO productCodeDAO;
//	
//	@Resource
//	private RateDiscountAO rateDiscountAO;
//	@Resource
//	private ChannelChannelDao channelChannelDao;
//	@Resource
//	private ValiUser valiUser;
//	
////	@Test
////	public void testGetproductCode(){
////		
////		List<ProductCodePo> list = productCodeAO.getProductCode(null, null).getRecords();
////		System.out.println(list.size());
////	}
////	@Test
////	public void testGetOneProductCode(){
////		ProductCodePo  po = productCodeAO.getOneProductCode(new OneCodePo("14", 6144, 0, 0));
////		if(po != null){
////			System.out.println(po.getProductCode());
////		}
////	}
////	@Deprecated
////	@Test
////	public void testinitPgList(){
////		List<OperatorPgDataPo> pgList = productCodeAO.initPgList(13, 0, 0);
////		if (pgList != null) {
////			System.out.println(pgList.size());
////		}
////	}
////	@Test
////	public void testselectByPrimaryKey(){
////		ProductCodePo productPo = productCodeDAO.selectByPrimaryKey(349l);
////		if(productPo != null){
////			System.out.println(productPo.getPgValidity() + "\tserviceType=" + productPo.getServiceType()+ "\tcode=" + productPo.getScopeCityCode());
////		}else{
////			System.out.println("1");
////		}
////	}
//	@Test
//	public void testGetOneByPg(){
//		RateDiscountPo ratePo = rateDiscountAO.getRateForCharge(new ChargeChannelParamsPo("广东移动", 1, 1,"20", 2), 115,false);
//		ChannelChannelPo channelPo = channelChannelDao.get(new WherePrams("id", "=", ratePo.getChannelId()));
//		PgDataPo pgData = valiUser.findPg(new PgDataPo(OperatorTypeEnum.MOBILE.getValue(),  200, 1, 1, "20",2));
//		ProductCodePo productPo = productCodeAO.getOneProductCode(new OneCodePo("19", channelPo.getEpId(), pgData.getId()));
//		
////		ProductCodePo productPo = productCodeAO.getOneProductCodeByPg(50);
//		if(productPo != null){
//			System.out.print(productPo.getPgValidity() + "\tserviceType=" + productPo.getServiceType());
//			System.out.println(productPo.getProductCode() + "\t id=" + productPo.getId());
//		}else{
//			System.out.println("1");
//		}
//	}
//}
