package crud.aotest.apiTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.flowsys.api.singleton.BaseInterface;
import com.weizu.flowsys.api.singleton.BaseP;
import com.weizu.flowsys.api.singleton.SingletonFactory;
import com.weizu.flowsys.web.channel.dao.impl.ExchangePlatformDao;
import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description: Lliypt 接口测试
 * @projectName:weizu-channel
 * @className:TestLliypt.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月30日 上午10:54:06
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class LliyptTest {
	
	@Resource
	private ExchangePlatformDao exchangePlatformDao;
	
	@Test
	public void testBalance(){
		ExchangePlatformPo epPo = exchangePlatformDao.get(43);
//		System.out.println("apikey:"+epPo.getEpApikey());
		BaseInterface bi = SingletonFactory.getSingleton("Lljypt", new BaseP("pc123123","726633391352451072","15014369834",1,epPo));
		System.out.println(bi.toParams());
		System.out.println(bi.toBalanceParams());
		//		bi.getBalance();
		
//		String params = getBalanceP();
		
//		Long ts = System.currentTimeMillis();
//		
//		
//		String signStr = "clientId10000merchant10210ts"+ts + "versionV100KKIGoAFUTxoIFfC";
//		System.out.println(signStr);
//		String sign = null;
//		try {
//			sign = MD5.getMd5(signStr,MD5.LOWERCASE,MD5.ENCODE);
//			System.out.println(sign);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		JSONObject param = new JSONObject();
		//"merchant=" + 10210 + "&clientId=" + 10000
//		+ "&version=V100&ts=" + ts
//		+ "&sign=" + sign;
		
		
//		param.put("clientId",10000);
//        param.put("merchant",10210);
//        param.put("sign",sign);
//        param.put("ts",ts);
//        param.put("version","V100");
//        System.out.println(param.toString());
//		String resultStr = HttpRequest.sendPost("http://api.lljypt.com/capi/query.balance", param.toString());
//		System.out.println(resultStr);
//		System.out.println(resultStr);
//		System.out.println("url:"+ "http://api.lljypt.com/capi/query.balance");
//		System.out.println("params:"+params);
//		System.out.println("http://api.lljypt.com/capi/query.balance?"+params);
//		paraseResult(resultStr);
		
		//f06113b6e9bb9c377b147d2783471ebe
//		System.out.println(bi.toParams()); //http参数
	}
//	private void paraseResult(String resultStr){
//		try {  
//            JSONObject obj = JSON.parseObject(resultStr);
//            int tipCode = obj.getIntValue("rspCode");
//            String tipMsg = obj.getString("rspMsg");
//            String orderIdApi = obj.getString("balance");
//            System.out.println(obj);
//		    // 最后输出到控制台  
//            System.out.println(tipCode+"<--->"+tipMsg);  
//  
//        } catch (JSONException e) {  
//            e.printStackTrace();  
//        }  
//	}
//	
//	private String getBalanceP(){
//		Long ts = System.currentTimeMillis();
//		String signStr = "clientId10000merchant10210ts"+ts + "versionV100";
//		String sign = null;
//		try {
//			sign = MD5.getMd5(signStr,MD5.LOWERCASE,MD5.ENCODE);
////			System.out.println(sign);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		//merchant=10210&clientId=10000&version=V100&
//		
//		return "merchant=" + 10210 + "&clientId=" + 10000
//				+ "&version=V100&ts=" + ts
//				+ "&sign=" + sign;
//	}
}
