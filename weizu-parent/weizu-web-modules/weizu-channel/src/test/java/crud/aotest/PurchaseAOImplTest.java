package crud.aotest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiyi.base.pojo.PageParam;
import com.weizu.flowsys.util.Pagination;
import com.weizu.flowsys.web.trade.ao.PurchaseAO;
import com.weizu.flowsys.web.trade.dao.PurchaseDao;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class PurchaseAOImplTest {
	@Resource
	private PurchaseDao purchaseDAO;
	
	@Resource
	private PurchaseAO purchaseAO;
	
//	@Test
//	public void testAdd(){
//		PurchasePo purchasePo = new PurchasePo();
//		purchasePo.setOrderId(123L);
//		purchaseDAO.addPurchase(purchasePo);
//	}
	
//	@Test
//	public void testGetPurchase(){
//		PurchaseVO purchaseVO = new PurchaseVO();
//		purchaseVO.setRootAgencyId(4);
//		
//		Pagination<PurchaseVO> pagination = purchaseAO.getPurchase(purchaseVO, new PageParam(1, 10));
//		List<PurchaseVO> records = pagination.getRecords();
//		for (PurchaseVO purchaseVO2 : records) {
//			System.out.println(purchaseVO2.getEp().getEpName());
//		}
//		
//		System.out.println(pagination.getTotalRecord());		
//	}
	/**
	 * @description:测试通过产品编码向原系统下单
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月16日 下午12:23:17
	 */
//	@Test
//	public void testPurchase(){
//		//浙江移动的通道（号码）：15858343638
//		//apikey: 	722c16de0a83e5bd2f988e3c7bc9fee8
//		String username="CS111111";
//		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
//		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
//		System.out.println(sign);
//		String number = "15858343638";
//		
//		ParamsEntityWeiZu httpEntity = new ParamsEntityWeiZu(username, number, "500", sign);
////		String resTel = HttpRequest.sendGet("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm", "tel=" + number);
//		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/sendOrder", httpEntity.toString());
//		System.out.println(resMsg);
////		System.out.println(resTel);
//	}
	
	/**
	 * @description: 测试余额接口
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月16日 下午5:20:32
	 */
//	@Test
//	public void testBalance(){
//		//用户名： CS111111
//		//apikey: 722c16de0a83e5bd2f988e3c7bc9fee8
//		String username="CS111111";
//		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
//		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
//		//解析返回的json数据
//		//获得账户余额
//		//获得订单详情
//		
//		//利用单例模式，对某一个系统生成唯一的sign（根据url分配apikey）
//		//利用反射自动生成toString的方法
//		//Json可以统一解析的Json对象
//		System.out.println(sign);
//		GetBalanceParams gbp = new GetBalanceParams(username, sign);
//		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/getBalance", gbp.toString());
//		System.out.println(resMsg);
//	}
	/**
	 * @description: 测试回调，订单状态
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月16日 下午5:20:58
	 */
//	@Test
//	public void testOrderState(){
//		//用户名： CS111111
//		//apikey: 722c16de0a83e5bd2f988e3c7bc9fee8
//		String username="CS111111";
//		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
//		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
//		//解析返回的json数据
//		//获得账户余额
//		//获得订单详情
//		
//		//利用单例模式，对某一个系统生成唯一的sign（根据url分配apikey）
//		//利用反射自动生成toString的方法
//		//Json可以统一解析的Json对象
//		System.out.println(sign);
//		String order_id = "20170622122808967868";
//		OrderStateParams osp = new OrderStateParams(username,order_id, sign);
//		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/orderState", osp.toString());
//		OrderStateResult osr = JSON.parseObject(resMsg, OrderStateResult.class);
//		System.out.println(osr.getOrder().getStatus());//订单状态
//		System.out.println(osr.getOrder().getMsg());//订单状态
//		System.out.println(osr.getErrmsg());
//		System.out.println(osr.getErrcode());//返回参数
////		System.out.println(resMsg);
//	}
	/**
	 * @description:测试通过发来的地址分发apikey
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月16日 下午4:45:16
	 */
//	@Test
//	public void testAPIkey(){
//		//浙江移动的通道（号码）：15858343638
	//本地IP：192.168.0.111
//		//apikey: 	722c16de0a83e5bd2f988e3c7bc9fee8
//		String username="CS111111";
//		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
//		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
//		System.out.println(sign);
//		String number = "15858343638";
//		
//		ParamsEntityWeiZu httpEntity = new ParamsEntityWeiZu(username, number, "500", sign);
////		String resTel = HttpRequest.sendGet("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm", "tel=" + number);
//		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/sendOrder", httpEntity.toString());
//		System.out.println(resMsg);
////		System.out.println(resTel);
//	}
//	@Test
//	public void testGetPurchaseById(){
//		PurchasePo po = purchaseDAO.getOnePurchase("705129750095470592");
//		if(po != null)
//		{
//			System.out.println("success");
//		}
//	}
	
}
