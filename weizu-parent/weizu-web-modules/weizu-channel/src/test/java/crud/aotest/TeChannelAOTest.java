package crud.aotest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.operatorPg.enums.AgencyTagEnum;
import com.weizu.flowsys.operatorPg.enums.HuaServiceTypeEnum;
import com.weizu.flowsys.operatorPg.enums.ServiceTypeEnum;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.ao.TelChannelAO;
import com.weizu.flowsys.web.channel.ao.TelProductAO;
import com.weizu.flowsys.web.channel.dao.ITelChannelDao;
import com.weizu.flowsys.web.channel.dao.ITelProductDao;
import com.weizu.flowsys.web.channel.pojo.TelChannelParams;
import com.weizu.flowsys.web.channel.pojo.TelProductPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class TeChannelAOTest {
	@Resource
	private ITelChannelDao telChannelDao;
	
	@Resource
	private TelChannelAO telChannelAO;
	
//	@Test
//	public void testList(){
//		TelChannelParams telParams = new TelChannelParams();
//		telParams.setEpName("123");
//		telParams.setServiceType(HuaServiceTypeEnum.CITY.getValue());
//		Pagination<TelChannelParams> pagination = telChannelAO.getTelChannel (telParams, new PageParam(1l,10));
//		List<TelChannelParams> telProductList =  pagination.getRecords();
////		for (TelChannelParams telProductPo : telProductList) {
//////			System.out.println(TelChannelParams.getCity() + ":" + TelChannelParams.get);
////		}
//		System.out.println(telProductList==null ? 0:telProductList.size());
//	}
//	@Test
//	public void testMyList(){
//		//{negative=0, positive=1, serviceType=2, bind=0, useOpen=0}
//		TelChannelParams telParams = new TelChannelParams();
////		telParams.setEpName("123");
//		telParams.setServiceType(HuaServiceTypeEnum.CITY.getValue());
//		telParams.setRateFor(AgencyTagEnum.DATA_USER.getValue());
////		telParams.set
//		Pagination<TelChannelParams> pagination = telChannelAO.getAgencyTelChannel(new PageParam(1l,10), telParams, 2);
//		List<TelChannelParams> telProductList =  pagination.getRecords();
//		System.out.println(telProductList==null ? 0:telProductList.size());
//	}
	@Test
	public void testCountMyList(){
		//{negative=0, positive=1, serviceType=2, bind=0, useOpen=0}
		TelChannelParams telParams = new TelChannelParams();
//		telParams.setEpName("123");
		telParams.setServiceType(HuaServiceTypeEnum.PROVINCE.getValue());
		telParams.setRateFor(AgencyTagEnum.DATA_USER.getValue());
//		telParams.set
		Pagination<TelChannelParams> pagination = telChannelAO.getAgencyTelChannel(new PageParam(1l,10), telParams, 2);
		List<TelChannelParams> telProductList =  pagination.getRecords();
		System.out.println(telProductList==null ? 0:telProductList.size());
	}
}
