//package crud.aotest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.aiyi.base.pojo.PageParam;
//import com.weizu.flowsys.operatorPg.enums.OrderStateEnum;
//import com.weizu.flowsys.operatorPg.enums.PgServiceTypeEnum;
//import com.weizu.flowsys.util.Pagination;
//import com.weizu.flowsys.web.trade.ao.PurchaseAO;
//import com.weizu.flowsys.web.trade.dao.PurchaseDao;
//import com.weizu.flowsys.web.trade.pojo.PurchasePo;
//import com.weizu.flowsys.web.trade.pojo.PurchaseVO;
//import com.weizu.web.foundation.DateUtil;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class PurchaseAOImplTest {
//	@Resource
//	private PurchaseDao purchaseDAO;
//	
//	@Resource
//	private PurchaseAO purchaseAO;
//	
////	@Test
////	public void testAdd(){
////		PurchasePo purchasePo = new PurchasePo();
////		purchasePo.setOrderId(123L);
////		purchaseDAO.addPurchase(purchasePo);
////	}
//	
////	@Test
////	public void testGetPurchase(){
////		PurchaseVO purchaseVO = new PurchaseVO();
////		purchaseVO.setAgencyId(1);
//////		purchaseVO.setPgServiceType(PgServiceTypeEnum.PGCHARGE.getValue());
//////		purchaseVO.setPgServiceType(PgServiceTypeEnum.TELCHARGE.getValue());
//////		purchaseVO.setOrderState(OrderStateEnum.CHARGED.getValue());
////		purchaseVO.setPurchaseFor(PgServiceTypeEnum.PGCHARGE.getValue());
////		Map<String, Object> params = new HashMap<String, Object>();
////		Pagination<PurchaseVO> pagination = purchaseAO.getPurchase(params,purchaseVO, new PageParam(1L, 10));
////		List<PurchaseVO> records = pagination.getRecords();
////		
////		for (PurchaseVO purchaseVO2 : records) {
//////			System.out.println(purchaseVO2.getApDiscount());
////			System.out.println(purchaseVO2.getAgencyId());
//////			System.out.println(purchaseVO2.getEp().getEpName());
////		}
////		
////		System.out.println(pagination.getTotalRecordLong());		
////	}
////	@Test
////	public void testDate(){
////		PurchasePo purPo = purchaseDAO.getLatestOneByTel("15024732435", PgServiceTypeEnum.PGCHARGE.getValue());
////		int minutes = (int) ((System.currentTimeMillis() - purPo.getOrderArriveTime()) / (1000*60));//h
////		System.out.println(minutes);
////	}
//	/**
//	 * @description:测试通过产品编码向原系统下单
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月16日 下午12:23:17
//	 */
////	@Test
////	public void testPurchase(){
////		//浙江移动的通道（号码）：15858343638
////		//apikey: 	722c16de0a83e5bd2f988e3c7bc9fee8
////		String username="CS111111";
////		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
////		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
////		System.out.println(sign);
////		String number = "15858343638";
////		
////		ParamsEntityWeiZu httpEntity = new ParamsEntityWeiZu(username, number, "500", sign);
//////		String resTel = HttpRequest.sendGet("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm", "tel=" + number);
////		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/sendOrder", httpEntity.toString());
////		System.out.println(resMsg);
//////		System.out.println(resTel);
////	}
//	
//	/**
//	 * @description: 测试余额接口
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月16日 下午5:20:32
//	 */
////	@Test
////	public void testBalance(){
////		//用户名： CS111111
////		//apikey: 722c16de0a83e5bd2f988e3c7bc9fee8
////		String username="CS111111";
////		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
////		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
////		//解析返回的json数据
////		//获得账户余额
////		//获得订单详情
////		
////		//利用单例模式，对某一个系统生成唯一的sign（根据url分配apikey）
////		//利用反射自动生成toString的方法
////		//Json可以统一解析的Json对象
////		System.out.println(sign);
////		GetBalanceParams gbp = new GetBalanceParams(username, sign);
////		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/getBalance", gbp.toString());
////		System.out.println(resMsg);
////	}
//	/**
//	 * @description: 测试回调，订单状态
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月16日 下午5:20:58
//	 */
////	@Test
////	public void testOrderState(){
////		//用户名： CS111111
////		//apikey: 722c16de0a83e5bd2f988e3c7bc9fee8
////		String username="CS111111";
////		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
////		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
////		//解析返回的json数据
////		//获得账户余额
////		//获得订单详情
////		
////		//利用单例模式，对某一个系统生成唯一的sign（根据url分配apikey）
////		//利用反射自动生成toString的方法
////		//Json可以统一解析的Json对象
////		System.out.println(sign);
////		String order_id = "20170622122808967868";
////		OrderStateParams osp = new OrderStateParams(username,order_id, sign);
////		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/orderState", osp.toString());
////		OrderStateResult osr = JSON.parseObject(resMsg, OrderStateResult.class);
////		System.out.println(osr.getOrder().getStatus());//订单状态
////		System.out.println(osr.getOrder().getMsg());//订单状态
////		System.out.println(osr.getErrmsg());
////		System.out.println(osr.getErrcode());//返回参数
//////		System.out.println(resMsg);
////	}
//	/**
//	 * @description:测试通过发来的地址分发apikey
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月16日 下午4:45:16
//	 */
////	@Test
////	public void testAPIkey(){
////		//浙江移动的通道（号码）：15858343638
//	//本地IP：192.168.0.111
////		//apikey: 	722c16de0a83e5bd2f988e3c7bc9fee8
////		String username="CS111111";
////		String apikey = "722c16de0a83e5bd2f988e3c7bc9fee8";
////		String sign = MD5.getMd5("username="+username+"&apikey="+apikey);
////		System.out.println(sign);
////		String number = "15858343638";
////		
////		ParamsEntityWeiZu httpEntity = new ParamsEntityWeiZu(username, number, "500", sign);
//////		String resTel = HttpRequest.sendGet("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm", "tel=" + number);
////		String resMsg = HttpRequest.sendGet("http://139.224.70.161:32001/api/v1/sendOrder", httpEntity.toString());
////		System.out.println(resMsg);
//////		System.out.println(resTel);
////	}
////	@Test
////	public void testGetPurchaseById(){
//////		PurchasePo po = purchaseDAO.getOnePurchase(705129750095470592l);
////		PurchasePo po = purchaseDAO.getOnePurchase("20180120181412461518");
////		if(po != null)
////		{
////			System.out.println("success");
////		}
////	}
////	@Test
////	public void testUpdate(){
////		PurchasePo purchasePo = new PurchasePo();
////		purchasePo.setOrderIdApi("723257145881006080");;
////		
////		purchaseDAO.updateLocal(purchasePo, new WherePrams("order_id", "=", 723257145881006080L));
////	}
//	/**
//	 * @description: Weizu充值接口测试
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月17日 下午5:44:38
//	 */
////	@Test
////	public void testChargeByFacet(){
////		ExchangePlatformPo epPo = new ExchangePlatformPo();
////		ProductCodePo dataPo = new ProductCodePo();
////		String epEngId = "Weizu";
////		epPo.setEpEngId(epEngId);
////		epPo.setEpPurchaseIp("123");
////		 ChargeDTO chargeDTO = null;
////		try {
////			chargeDTO = purchaseAO.chargeByFacet(epPo,dataPo);
////		} catch (ClassNotFoundException | InstantiationException
////				| IllegalAccessException | IllegalArgumentException
////				| InvocationTargetException | NoSuchMethodException
////				| SecurityException e) {
////			e.printStackTrace();
////		}
////		System.out.println(chargeDTO.getOrderIdApi());//测试打印出对应平台的提单地址
////	}
////	@Test
////	public void testTotal(){
//////		Map<String, Object> params = new HashMap<String, Object>();
////		PurchaseVO pvo = new PurchaseVO();
////		pvo.setAgencyId(21);
////		TotalResult totalResult = purchaseAO.getTotalResultFromSuccess(pvo);
////		System.out.println(totalResult.getTotalCost());
////	}
////	@Test
////	public void testAjaxPurchase(){
////		List<ChargeChannelPo> chargeList = purchaseAO.ajaxChargeChannel(new ChargeChannelParamsPo("广东移动", "19", "Weizu"));
////		String listJsonStr = JSON.toJSONString(chargeList);
////		System.out.println(listJsonStr);
////		System.out.println(chargeList.size());
//////		for (ChargeChannelPo chargeChannelPo : chargeList) {
//////			List<OperatorPgDataPo> pgList = chargeChannelPo.getList();
//////			for (OperatorPgDataPo operatorPgDataPo : pgList) {
//////				System.out.println(operatorPgDataPo.getPgName());
//////			}
//////		}
////
////	}
////	@Test
////	public void testAjaxCommit(){
////		String res = purchaseAO.ajaxCommitOrder(729886956942528512l, 4, "广东移动", BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
////		System.out.println(res);
////	}
////	@Test
////	public void ajaxChageList(){
////		ChargeChannelParamsPo ccp = new ChargeChannelParamsPo();
////		ccp.setChannelId(4l);
////		ccp.setCarrier("广东移动");
////		List<OperatorPgDataPo> pgList = purchaseAO.ajaxChargePg(ccp);
////		if(pgList != null){
////			System.out.println(pgList.size());
////		}
////	}
////	@Test
////	public void hastDoublePurchase(){
////		PurchasePo purPo = purchaseDAO.hasDoublePurchase(null, "20171018101302237750");
////		boolean hasD = purPo != null;
////		if(hasD){
////			System.out.println(purPo.getChargeTel());
////		}
////	}
////	@Test
////	public void testGetLatestPur(){
////		Long highTime = System.currentTimeMillis() - 1000*60;//一分钟之前的时间
////		PurchasePo purchasePo =  purchaseDAO.getLatestOneByTel("13902009999", PgServiceTypeEnum.PGCHARGE.getValue(), highTime);
////		if(purchasePo != null){
////			System.out.println("一分钟以内有过该号码");
////		}
////	}
////	@Test
////	public void countTelNum(){
////		Map<String,Object> paramsMap = new HashMap<String, Object>();
////		paramsMap.put("startTime", DateUtil.getStartTime().getTime());
////		paramsMap.put("endTime", DateUtil.getEndTime().getTime());
////		String chargeTel = "15999707221";
////		paramsMap.put("chargeTel", chargeTel);
////		paramsMap.put("accountId", 1);
//////		paramsMap.put("orderResult", 1);
////		
////		long telNum = purchaseDAO.countPurchase(paramsMap);
////		System.out.println(chargeTel + "提交成功次数："+telNum);
////	}
//	@Test
//	public void listPur(){
//		Map<String,Object> paramsMap = new HashMap<String, Object>();
//		paramsMap.put("orderResultIsNull", 1);
//		paramsMap.put("purchaseFor", 1);
//		paramsMap.put("pgcharge", 1);
////		paramsMap.put("chargeTel", "15999707221");
//		List<PurchaseVO> purchaseList = purchaseDAO.getPurchase(paramsMap);
//		for (PurchaseVO purchaseVO : purchaseList) {
//			System.out.println(purchaseVO.getChargeTel()+":"+DateUtil.formatAll(purchaseVO.getOrderArriveTime()));
//		}
//		System.out.println();
//	}
//}
