package crud.aotest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.channel.ao.ChannelChannelAO;
import com.weizu.flowsys.web.channel.pojo.ChannelChannelPo;
import com.weizu.flowsys.web.channel.pojo.ChannelDiscountPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class ChannelChannelAOTest {
	@Resource
	private ChannelChannelAO channelChannelAO;
	
//	@Test
//	public void listChannel()
//	{
//		Pagination<ChannelChannelPo> pagination = channelChannelAO.listChannel(new PageParam(1, 10), new ChannelChannelPo());
//		for(ChannelChannelPo channelPo:pagination.getRecords())
//		{
//			System.out.println(channelPo.getId());
////			for(ChannelDiscountPo discountPo:channelPo.getDiscountList())
////			{
////				System.out.println("{"+discountPo.getScopeCityCode()+":"+discountPo.getChannelDiscount()+"}");
////				System.out.println(discountPo.getOperatorType());
////			}
//			System.out.println("移动:"+channelPo.getDiscount0());
//			System.out.println("联通:"+channelPo.getDiscount1());
//			System.out.println("电信:"+channelPo.getDiscount2());
//			
//		}
//	}
}
