//package crud.aotest.apiTest;
//
//import java.io.UnsupportedEncodingException;
//
//import javax.annotation.Resource;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;
//import com.weizu.flowsys.api.singleton.BaseInterface;
//import com.weizu.flowsys.api.singleton.BaseP;
//import com.weizu.flowsys.api.singleton.SingletonFactory;
//import com.weizu.flowsys.api.weizu.charge.ChargeDTO;
//import com.weizu.flowsys.api.weizu.charge.ChargeOrder;
//import com.weizu.flowsys.util.StringUtil2;
//import com.weizu.flowsys.web.channel.ao.ExchangePlatformAO;
//import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;
//import com.weizu.web.foundation.MD5;
//import com.weizu.web.foundation.http.HttpRequest;
//
///**
// * @description: 河南趣闻-顽兔平台接口测试
// * @projectName:weizu-channel
// * @className:WantullTest.java
// * @author:微族通道代码设计人 宁强
// * @createTime:2017年12月11日 上午11:03:15
// * @version 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class WantullTest implements BaseAPITest {
//	@Resource
//	private ExchangePlatformAO exchangePlatformAO;
//	
//	private BaseInterface biCharge = null;
//	@Before
//	public void initBi(){
//		ExchangePlatformPo epPo = exchangePlatformAO.getEpByEpName("河南趣闻分省");
//		biCharge = SingletonFactory.getSingleton(epPo.getEpEngId(), new BaseP("10",766467363703885824l,"18300309834",0,epPo));//充值api测试
//	}
//	
////	@Test
//	@Override
//	public void testGetBalance(){
//		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("河南趣闻分省");
////		BaseInterface bi = SingletonFactory.getSingleton("Lljypt", new BaseP("pc123123",726633391352451072l,"15014369834",1,epPo));
//		
////		BaseInterface bi = SingletonFactory.getSingleton("Wantull", new BaseP(null,726633391352451072l,null,1,platformPo));
////		BalanceDTO balanceDTO = bi.getBalance();
////		System.out.println(balanceDTO == null ? "": balanceDTO.getAccountBalance());
//		String [] tipSign = new String[]{"app_key"};
//		
//		for (String key : tipSign) {
//			String valueSample = StringUtil2.getParamsByCharSeq(platformPo.getEpOtherParams(), key);
//			System.out.println(valueSample);
//		}
//		
//	}
//	@Override
//	public void paraseBalanceJson(String resultStr) {
//	try {  
//	    JSONObject obj = JSON.parseObject(resultStr);
//	    int tipCode = obj.getIntValue("code");
//	    String tipMsg = obj.getString("msg");
//	    String balance = obj.getString("balance");
//	    System.out.println(obj);
//	    // 最后输出到控制台  
//	    System.out.println(tipCode+"<--->"+tipMsg + ":" + balance);  
//	
//	    } catch (JSONException e) {  
//	        e.printStackTrace();  
//	    }  
//	}
////	@Test
//	@Override
//	public void testAPI() {
//		ExchangePlatformPo platformPo = exchangePlatformAO.getEpByEpName("河南趣闻全国");
//		String account = platformPo.getEpUserName();
//		String app_secret = platformPo.getEpApikey();
//		String sign = "";
//		System.out.println("account="+account+"&app_secret="+app_secret);
//		try {
//			sign = MD5.getMd5("account="+account+"&app_secret="+app_secret, MD5.LOWERCASE, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//		
//			e.printStackTrace();
//		}
//		System.out.println(platformPo.toString());
//		System.out.println("sign="+sign);
//		StringBuffer param = new StringBuffer();
//		param.append("account=");
//		param.append(account);
//		param.append("&sign=");
//		param.append(sign);
//		System.out.println(param.toString());
//		String resultStr = HttpRequest.sendGet(platformPo.getEpBalanceIp(), param.toString());
//		System.out.println(resultStr);
//		paraseBalanceJson(resultStr);
//	}
//	
//	@Test
//	public void testCharge(){
//		ChargeDTO chargeDTO = biCharge.charge();
//		if(chargeDTO != null && chargeDTO.getChargeOrder() != null){
//			ChargeOrder co = chargeDTO.getChargeOrder();
//			System.out.println(co.getOrderIdApi());
//		}
//	}
//	
//}
