package crud.aotest.apiTest;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.weizu.flowsys.api.singleton.BalanceDTO;
import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.OrderDTO;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
import com.weizu.flowsys.web.channel.dao.IProductCodeDAO;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
import com.weizu.flowsys.web.channel.pojo.ProductCodePo;
import com.weizu.web.foundation.DateUtil;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.http.HttpRequest;

/**
 * @description: 河南趣闻-顽兔平台接口测试
 * @projectName:weizu-channel
 * @className:WantullTest.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月11日 上午11:03:15
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class MaiyuanTest implements BaseAPITest {
	@Resource
	private ExchangePlatformAO exchangePlatformAO;
	@Resource
	private IProductCodeDAO productDAO;
	
//	private BaseInterface biCharge = null;
//	@Before
//	public void initBi(){
//		ExchangePlatformPo epPo = exchangePlatformAO.getEpByEpName("仁智迈远");
//		biCharge = SingletonFactory.getSingleton(epPo.getEpEngId(), new BaseP("10",766467363703885824l,"18300309834",0,epPo));//充值api测试
//	}
	
	@Test
	@Override
	public void testGetBalance(){
		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("仁智迈远");
		ProductCodePo pc = productDAO.selectByPrimaryKey(278l);
		BaseInterface bi = SingletonFactory.getSingleton(platformPo.getEpEngId(), new BaseP(pc,726633391352451072l,null,platformPo,DateUtil.formatPramm(System.currentTimeMillis(), "yyyy-MM-dd")));
		BalanceDTO balanceDTO = bi.getBalance();
		System.out.println(balanceDTO == null ? "": balanceDTO.getAccountBalance());
//		String [] tipSign = new String[]{"app_key"};
//		
//		for (String key : tipSign) {
//			String valueSample = StringUtil2.getParamsByCharSeq(platformPo.getEpOtherParams(), key);
//			System.out.println(valueSample);
//		}
	}
	
//	@Test
	public void testGetOrderState(){
		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("仁智迈远");
		ProductCodePo pc = productDAO.selectByPrimaryKey(278l);
		
		BaseInterface bi = SingletonFactory.getSingleton(platformPo.getEpEngId(), new BaseP(pc,"18561135",null,platformPo,DateUtil.formatPramm(System.currentTimeMillis(), "yyyy-MM-dd")));
		OrderDTO orderDTO = bi.getOrderState();
		if(orderDTO != null){
			System.out.println(orderDTO.getRspCode() + "<------>" + orderDTO.getRspMsg());	
			System.out.println(orderDTO.getOrderIn() == null?"":orderDTO.getOrderIn().toString());
		}
	}
//	@Test
	public void testCharge(){
		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("仁智迈远");
		ProductCodePo pc = productDAO.selectByPrimaryKey(278l);
		//全国移动 10M编码
		BaseInterface bi = SingletonFactory.getSingleton(platformPo.getEpEngId(), new BaseP(pc,766467363703885824l,"15754710513",platformPo,DateUtil.formatPramm(System.currentTimeMillis(), "yyyy-MM-dd")));
		ChargeDTO chargeDTO = bi.charge();
		System.out.println(chargeDTO.getTipMsg() + "<------>" + chargeDTO.getTipCode());
		if(chargeDTO.getChargeOrder() != null){
			System.out.println(chargeDTO.getChargeOrder().toString());
		}
	}
	
	/**
	 * @description: 通过调用余额接口获得产品列表
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月14日 下午5:07:41
	 */
//	@Test
	public void testGetProduct(){
		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("仁智迈远");
		ProductCodePo pc = productDAO.selectByPrimaryKey(278l);
		BaseInterface bi = SingletonFactory.getSingleton(platformPo.getEpEngId(), new BaseP(pc,766467363703885824l,"15754710513",platformPo,DateUtil.formatPramm(System.currentTimeMillis(), "yyyy-MM-dd")));
		BalanceDTO balanceDTO = bi.getBalance();
		System.out.println(balanceDTO == null ? "": balanceDTO.getAccountBalance());
//		String [] tipSign = new String[]{"app_key"};
//		
//		for (String key : tipSign) {
//			String valueSample = StringUtil2.getParamsByCharSeq(platformPo.getEpOtherParams(), key);
//			System.out.println(valueSample);
//		}
	}
	@Override
	public void paraseBalanceJson(String resultStr) {
	try {  
	    JSONObject obj = JSON.parseObject(resultStr);
	    int tipCode = obj.getIntValue("code");
	    String tipMsg = obj.getString("msg");
	    String balance = obj.getString("balance");
	    System.out.println(obj);
	    // 最后输出到控制台  
	    System.out.println(tipCode+"<--->"+tipMsg + ":" + balance);  
	    } catch (JSONException e) {  
	        e.printStackTrace();  
	    }  
	}
//	@Test
	@Override
	public void testAPI() {
		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("仁智迈远");
		String account = platformPo.getEpUserName();
		String app_secret = platformPo.getEpApikey();
		String sign = "";
		System.out.println("account="+account+"&app_secret="+app_secret);
		try {
			sign = MD5.getMd5("account="+account+"&app_secret="+app_secret, MD5.LOWERCASE, "utf-8");
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}
		System.out.println(platformPo.toString());
		System.out.println("sign="+sign);
		StringBuffer param = new StringBuffer();
		param.append("account=");
		param.append(account);
		param.append("&sign=");
		param.append(sign);
		System.out.println(param.toString());
		String resultStr = HttpRequest.sendGet(platformPo.getEpBalanceIp(), param.toString());
		System.out.println(resultStr);
		paraseBalanceJson(resultStr);
	}
	
//	@Test
//	public void testCharge(){
//		ChargeDTO chargeDTO = biCharge.charge();
//		if(chargeDTO != null && chargeDTO.getChargeOrder() != null){
//			ChargeOrder co = chargeDTO.getChargeOrder();
//			System.out.println(co.getOrderIdApi());
//		}
//	}
	
}
