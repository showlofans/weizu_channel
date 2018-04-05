//package crud.aotest.apiTest;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Map;
//import java.util.TreeMap;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.alibaba.fastjson.JSON;
//import com.weizu.flowsys.api.weizu.charge.ChargeTelParams;
//import com.weizu.flowsys.core.util.NumberTool;
//import com.weizu.flowsys.operatorPg.enums.TelServiceTypeEnum;
//import com.weizu.flowsys.operatorPg.enums.TelchargeSpeedEnum;
//import com.weizu.flowsys.web.http.url.PDDApiURL;
//import com.weizu.flowsys.web.trade.ao.PDDChargeAO;
//import com.weizu.flowsys.web.trade.pojo.pdd.PDDChargeTelPo;
//import com.weizu.flowsys.web.trade.pojo.pdd.PddPgParams;
//import com.weizu.web.foundation.MD5;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class PddChargeAOTest {
//
//	@Resource
//	private PDDChargeAO pddChargeAO;
//	
////	@Test
////	public void testPddCharge(){
////		StringBuffer signBuff = new StringBuffer();
////		//amount,mctNo,mobile,notifyUrl,outOrderNo,proNo,signType,
////		Integer amount = 1;
////		String mctNo = "123";
////		String mobile = "18390606122";
////		//String notifyUrl = "ttp://open.yangkeduo.com/api/router";
////		String outOrderNo = "110208-123010101000001";
////		String proNo = "41";
////		String signType = "MD5";
////		
////		signBuff.append("amount=").append(amount);
////		signBuff.append("&mctNo=").append(mctNo);
////		signBuff.append("&mobile=").append(mobile);
////		signBuff.append("&notifyUrl=").append(notifyUrl);
////		signBuff.append("&outOrderNo=").append(outOrderNo);
////		signBuff.append("&proNo=").append(proNo);
////		
////		signBuff.append("&signType=").append(signType);
////		signBuff.append("&key=").append(PDDApiURL.API_KEY);
////		System.out.println("签名串1："+signBuff.toString());
////		String sign = ""; 
////		try {
////	 			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
////	 		} catch (UnsupportedEncodingException e) {
////	 			e.printStackTrace();
////	 		}
////		
////		String getSign = getSign(mctNo, signType, outOrderNo, proNo, amount, mobile, notifyUrl, null, null, null);
////		System.out.println(sign.equals(getSign));
////		
//////		PDDChargePo ppdChargePo = pddChargeAO.chargePg(new PddPgParams(outOrderNo, proNo, amount, mobile, notifyUrl, null, null, null, mctNo, sign, signType));
//////		System.out.println(JSON.toJSONString(ppdChargePo));
////		
////	}
////	private String getSign(String mctNo, String signType, String outOrderNo, String proNo, Integer amount, String mobile, String notifyUrl, 
////			Integer resType, Integer dataFloat, Integer expireDay)
////	{
////		 Map<String, Object> treeMap = new TreeMap<String, Object>();
////         treeMap.put("mctNo", mctNo);
////         treeMap.put("outOrderNo", outOrderNo);
////         treeMap.put("proNo", proNo);
////         if(amount != null){
////        	 treeMap.put("amount", amount);
////         }
////         treeMap.put("mobile", mobile);
////         treeMap.put("notifyUrl", notifyUrl);
////         if(resType != null){
////        	 treeMap.put("resType", resType);
////         }
////         if(dataFloat != null){
////        	 treeMap.put("dataFloat", dataFloat);
////         }
////         if(expireDay != null){
////        	 treeMap.put("expireDay", expireDay);
////         }
////         
////         String params = treeMap.toString();
////         params = params.substring(1,params.length()-1);
////         String [] paramsA = params.split(",");
////         StringBuffer tempStr =  new StringBuffer();
////         for (String pa : paramsA) {
////        	 tempStr.append(pa.trim()).append("&");
////		}
//////        String temp = tempStr.toString().substring(0, tempStr.length()-1);
////         tempStr.append("signType=").append(signType);
////         tempStr.append("&key=").append(PDDApiURL.API_KEY);
////         String signStr = tempStr.toString();
////         System.out.println("签名串2："+tempStr.toString());
////         String sign = "";
////         try {
//// 			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
//// 		} catch (UnsupportedEncodingException e) {
//// 			e.printStackTrace();
//// 		}
////		return sign;
////	}
//	@Test
//	public void testPddChargeTel(){
//		StringBuffer signBuff = new StringBuffer();
//		//amount,mctNo,mobile,notifyUrl,outOrderNo,parPrice
//		Integer amount = 1;
//		String mctNo = "123";
//		String mobile = "15766767636";
////		String notifyUrl = "ttp://open.yangkeduo.com/api/router";
//		String outOrderNo = "110208-123010101000001";
//		String signType = "MD5";
//		int parPrice = 50;
//		
//		signBuff.append("amount=").append(amount);
//		signBuff.append("&mctNo=").append(mctNo);
//		signBuff.append("&mobile=").append(mobile);
//		signBuff.append("&notifyUrl=").append(notifyUrl);
//		signBuff.append("&outOrderNo=").append(outOrderNo);
//		signBuff.append("&parPrice=").append(parPrice);
//		
//		signBuff.append("&signType=").append(signType);
//		signBuff.append("&key=").append(PDDApiURL.API_KEY);
//		System.out.println("签名串1："+signBuff.toString());
//		String sign = ""; 
//		try {
//			sign = MD5.getMd5(signBuff.toString(), MD5.LOWERCASE, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
////		String getSign = getSign(mctNo, signType, outOrderNo, parPrice, amount, mobile, notifyUrl);
////		System.out.println(sign.equals(getSign));
//		
//		Double price = NumberTool.mul(parPrice, 1.0d);
//		PDDChargeTelPo ppdChargeTelPo = pddChargeAO.chargeTel(new ChargeTelParams(mobile, sign, TelServiceTypeEnum.PROVINCE.getValue(), TelchargeSpeedEnum.FAST.getValue(), notifyUrl, outOrderNo, price));
//		System.out.println(JSON.toJSONString(ppdChargeTelPo));
//		
//	}
//	
//	private String getSign(String mctNo, String signType, String outOrderNo, Integer parPrice, Integer amount, String mobile, String notifyUrl)
//	{
//		Map<String, Object> treeMap = new TreeMap<String, Object>();
//		treeMap.put("mctNo", mctNo);
//		treeMap.put("outOrderNo", outOrderNo);
//		if(parPrice != null){
//			treeMap.put("parPrice", parPrice);
//		}
//		if(amount != null){
//			treeMap.put("amount", amount);
//		}
//		treeMap.put("mobile", mobile);
//		treeMap.put("notifyUrl", notifyUrl);
//		
//		String params = treeMap.toString();
//		params = params.substring(1,params.length()-1);
//		String [] paramsA = params.split(",");
//		StringBuffer tempStr =  new StringBuffer();
//		for (String pa : paramsA) {
//			tempStr.append(pa.trim()).append("&");
//		}
////        String temp = tempStr.toString().substring(0, tempStr.length()-1);
//		tempStr.append("signType=").append(signType);
//		tempStr.append("&key=").append(PDDApiURL.API_KEY);
//		String signStr = tempStr.toString();
//		System.out.println("signStr:"+signStr);
//		String sign = "";
//		try {
//			sign = MD5.getMd5(signStr, MD5.LOWERCASE, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return sign;
//	}
//}
