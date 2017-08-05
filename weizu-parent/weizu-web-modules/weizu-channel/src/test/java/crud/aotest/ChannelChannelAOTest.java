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
//import com.aiyi.base.pojo.PageParam;
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.operatorPg.enums.BillTypeEnum;
//import com.weizu.flowsys.util.Pagination;
//import com.weizu.flowsys.web.channel.ao.ChannelChannelAO;
//import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
//import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class ChannelChannelAOTest {
//	@Resource
//	private ChannelChannelAO channelChannelAO;
//	
////	@Test
////	public void listChannel()
////	{
////		Pagination<ChannelChannelPo> pagination = channelChannelAO.listChannel(new PageParam(1, 10), new ChannelChannelPo());
////		for(ChannelChannelPo channelPo:pagination.getRecords())
////		{
////			System.out.println(channelPo.getId());
//////			for(ChannelDiscountPo discountPo:channelPo.getDiscountList())
//////			{
//////				System.out.println("{"+discountPo.getScopeCityCode()+":"+discountPo.getChannelDiscount()+"}");
//////				System.out.println(discountPo.getOperatorType());
//////			}
////			System.out.println("移动:"+channelPo.getDiscount0());
////			System.out.println("联通:"+channelPo.getDiscount1());
////			System.out.println("电信:"+channelPo.getDiscount2());
////			
////		}
////	}
////	@Test
////	public void listSimpleChannel()
////	{
//////		ChannelChannelPo channelPo = new ChannelChannelPo();
//////		channelPo.setBelongAgencyId(4);
////		List<ChannelChannelPo> records = channelChannelAO.listChannel(4, BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////		if(records != null){
////			for(ChannelChannelPo channelPo1 : records)
////			{
////				System.out.println("通道名称:"+channelPo1.getChannelName());
////				System.out.println("通道Id:"+channelPo1.getId());
////				System.out.println("地区:"+channelPo1.getScopeCityCode());
////				
////			}
////		}else
////		{
////			System.out.println("为空");
////		}
////		System.out.println(JSON.toJSONString(records)); 
////		
////	}
//}
