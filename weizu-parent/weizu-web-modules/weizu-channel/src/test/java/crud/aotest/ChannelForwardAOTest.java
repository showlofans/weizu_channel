package crud.aotest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.web.activity.pojo.OperatorScopeVO;
import com.weizu.flowsys.web.channel.ao.ChannelForwardAO;
import com.weizu.flowsys.web.channel.pojo.BestChannelPO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class ChannelForwardAOTest {
	
	@Resource
	private ChannelForwardAO channelForwardAO;
	
//	@Test
//	public void testListChannel(){
//		
//		Pagination<ChannelForwardPo> pagination = channelForwardAO.listChannel(new PageParam(1, 10), null);
//		
//		ChannelForwardPo po = pagination.getRecords().get(0);
//		System.out.println(po.getChannelName());
//		System.out.println(pagination.getRecords().size());
//	}
	/**
	 * @description:测试最优通道信息
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 下午7:51:05
	 */
//	@Test
//	public void testGetBestChannel(){
//		OperatorScopeVO scopeVO = new OperatorScopeVO("江西省",4,0 );
//		BestChannelPO bcp = channelForwardAO.getBestChannel(scopeVO);
//		if(bcp != null){
//			System.out.println("最优通道折扣："+bcp.getChannelDiscount());
//		}else{
//			System.out.println("没找到记录！！");
//		}
//	}
}
