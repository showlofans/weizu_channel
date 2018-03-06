//package crud.aotest;
//
//import java.io.UnsupportedEncodingException;
//import java.security.SecureRandom;
//
//import javax.annotation.Resource;
//
//import org.bouncycastle.crypto.params.KeyParameter;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.weizu.flowsys.util.apiEncode.Encrypt;
//import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
//import com.weizu.flowsys.web.trade.constant.WXPayConfig;
//import com.weizu.web.foundation.MD5;
//import com.weizu.web.foundation.StringUtil;
//import com.weizu.web.foundation.hash.Hash;
//import com.weizu.web.foundation.hash.aes.AESUtil;
//import com.weizu.web.foundation.hash.base64.Base64Util;
//
///**
// * @description:测试hash工具类
// * 
// * @projectName:crud
// * @className:HashTest.java
// * @author:POP产品研发部 宁强
// * @createTime:2017年6月1日 上午11:56:51
// * @version 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class HashTest {
//	
//	@Resource
//	private AgencyVODaoInterface agencyVODao;
//	
//	/**
//	 * @description: 更新密码为加密后的密码（批量更新不能用，好像会有死锁）
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月1日 下午12:14:08
//	 */
////	@Test
////	public  void testBase64Util(){
//////		WherePrams where = new WherePrams("id", ">", 2);
//////		Integer startNum = 100;
//////		List<AgencyBackwardPo> list = agencyVODao.list(where.limit(startNum, 10));
//////		System.out.println(list.size());
//////		System.out.println(list.get(0).getId());
//////		//更新为加密后的密码
//////		for (AgencyBackwardPo agencyBackwardPo : list) {
//////			String oringinalPass = agencyBackwardPo.getUserPass();
//////			String userPass = Hash.BASE_UTIL.encode(oringinalPass);
//////			System.out.println("加密前的密码:" + oringinalPass + "\t加密后的密码："+ userPass);
//////			agencyVODao.updatePass(agencyBackwardPo.getId(), userPass);
//////		}
//////		WherePrams where1 = new WherePrams("id", ">", 2);
//////		List<AgencyBackwardPo> list1 = agencyVODao.list(where.limit(startNum, 10));
//////		System.out.println(list1.size());
////////		//打印原来的密码
//////		for (AgencyBackwardPo backPo : list1) {
//////			String oringinalPass = backPo.getUserPass();
//////			String userPass = Hash.BASE_UTIL.decode(oringinalPass);
//////			System.out.println("解密前的密码:" + oringinalPass + "\t解密后的密码："+ userPass);
//////			/*System.out.println(backPo.getUserName() + ":" + userPass);*/
//////		}
////		String oringinalPass = "jeff123";
////		String userPass = Hash.BASE_UTIL.encode(oringinalPass);
////		System.out.println("加密前的密码:" + oringinalPass + "\t加密后的密码："+ userPass); 
//////		agencyVODao.updatePass(2, userPass);
////		
//////		System.out.println(list.get(0).getUserName());
//////		System.out.println(list.get(list.size()-1).getUserName());
////		
//////		Base64Util baseUtil = Hash.BASE_UTIL; 
//////		String encodeBase64 = Hash.BASE_UTIL.encode("123");
//////		System.out.println("base加密后结果："+ encodeBase64 +"\t总位数："+ encodeBase64.length());
//////		//aHR0cDovLzEyMC43Ni4xOTQuNDU6ODA4MC9hcGkuYXNweA==
//////		System.out.println("base解密后结果："+ Hash.BASE_UTIL.decode(encodeBase64));
////	}
////	
////	/**
////	 * @description:一个密码加密
////	 * @author:POP产品研发部 宁强
////	 * @createTime:2017年6月1日 下午12:13:59
////	 */
////	public static void getDesUtil(){
////		DESUtil desUtil = Hash.getDesUtil();
////		String encodeDes = desUtil.encrypt("http://120.76.194.45:8080/api.aspx");
////		System.out.println("des加密后结果："+ encodeDes+"\t总位数："+ encodeDes.length());
////		//vJC1Ew5T+9UxVhqxmFy54W3Ew+SX/3yl6hcGXVdy6By017K88CpTQQ==
////		System.out.println("des解密后结果："+ desUtil.decrypt(encodeDes));
////	}
////	
//	/**
//	 * @description:两个密码加密
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年6月1日 下午12:13:50
//	 */
//	public static void testAESUtil(){
//		AESUtil aesUtil =  Hash.AES_UTIL;
//		String encodeAes = aesUtil.encryptOfString("http://120.76.194.45:8080/api.aspx", "123");
//		System.out.println("aes加密后结果："+ encodeAes+"\t总位数："+ encodeAes.length());
//		//gkaxLfcDN9DYDWP8AWY6EocUoSVQJ7z31IGcM7DMU7B4VPreEbCPU2XSyLX0AnUA
//		System.out.println("aes解密后结果："+ aesUtil.decryptOfString(encodeAes, "123"));
//	}
//	/**
//	 * @description:两个密码加密256
//	 * @author:POP产品研发部 宁强
//	 * @throws UnsupportedEncodingException 
//	 * @createTime:2017年6月1日 下午12:13:50
//	 */
//	public static void testEncrpt() throws UnsupportedEncodingException{
////		SecureRandom random = new SecureRandom();
////		byte[] key = random.generateSeed(128);
////		System.out.println(key);
////		String keygen = StringUtil.byte2hex(key);
//////		System.out.println(keygen.length());
////		KeyParameter keyParam = new KeyParameter(key);
////		byte[] keys = keyParam.getKey();
////		byte[] keys = MD5.getMd5(WXPayConfig.KEY, MD5.LOWERCASE, "UTF-8").getBytes();
//		byte[] keys = MD5.getMd5("2IBtBXdrqC3kCBs4gaceL7nl2nnFadQv", MD5.LOWERCASE, "UTF-8").getBytes();
////		System.out.println(keys.length);
////		String str = "<root>"+
////        "<out_refund_no><![CDATA[2531340110812300]]></out_refund_no>"+
////        "<out_trade_no><![CDATA[2531340110812100]]></out_trade_no>"+
////        "<refund_account><![CDATA[REFUND_SOURCE_RECHARGE_FUNDS]]></refund_account>"+
////        "<refund_fee><![CDATA[1]]></refund_fee>"+
////        "<refund_id><![CDATA[50000505542018011003064518841]]></refund_id>"+
////        "<refund_recv_accout><![CDATA[支付用户零钱]]></refund_recv_accout>"+
////        "<refund_request_source><![CDATA[API]]></refund_request_source>"+
////        "<refund_status><![CDATA[SUCCESS]]></refund_status>"+
////        "<settlement_refund_fee><![CDATA[1]]></settlement_refund_fee>"+
////        "<settlement_total_fee><![CDATA[1]]></settlement_total_fee>"+
////        "<success_time><![CDATA[2018-01-10 10:31:24]]></success_time>"+
////        "<total_fee><![CDATA[1]]></total_fee>"+
////        "<transaction_id><![CDATA[4200000052201801101409025381]]></transaction_id>"+
////        "</root>";
//		String str = "http://120.76.194.45:8080/api.aspx";
//		byte[] encodeAesB = Encrypt.Aes256Encode(str, keys);
//		String aesStr = new String(encodeAesB,"UTF-8");
//		System.out.println("aes加密："+aesStr);
////		String baseStr = Hash.BASE_UTIL.encode(aesStr);
//////		byte[] encodeAesB = Encrypt.Aes256Encode("http://120.76.194.45:8080/api.aspx", keys);
//////		String encodeAes = new String(encodeAesB, "UTF-8");
////		System.out.println("BASE_UTIL加密后结果："+ baseStr+"\t总位数："+ baseStr.length());
////		String reqInfo = "m4NnwrtY0jhpDgNp65H1V/0OWMtSoTYhhY89MHbflhmnaHq9ZKjx9ABq6Jpg4SccA876HVy7J9P85NpdvCMNGInZ4fANDRE+YfZe4HeF+bbFj6JETcEFPpE9YW+bTbC0D+gl/otScJfvB2QUK7+EeBGPHN1EWX9zbr2Gw6AUaORdFk3mGxV5dtjuwWQrv5juzkXDs33Z2dUMslO+i3j0cTDHqwS4hptx2j6h2HvzgzltFbjo7nysU+4rArqJvrGW/9r18e1St9XgG21NALqixfaSmqetOR4zLVL4/+z3CEz8cg5r+/4GUOTf3XFmLCZ/wEkRQhKRNVibG0NFfiG3KnqArMJ/dheQHCd7qL+XX/ZV6tj8RLMgL7R6hOiR03Ljyikdxq9M3K9CTYgf03pHJd3geXX1LgXrLxc1flL6NW+zD3ZayGYpr1WpLsSMG7z8W5j1pme6cRj3n2+CwSFnOnOkxaFuLKoJAJIqM3gbC0eN++vY73RKphlI4zZqg6o5s3MXI6ju1yoi/ZQ+XbTg2JttsdbU0aySernKwkt0rYMf0j/Mcvo2axgHbI3w/iTm141WxHUjkQ+ga2X1pOWdGifGhSmMP8oGaA/WD5MAsK1qXX0eFvUWS/PTauCSTWq5Cmr8loA/KL3jgvB0nyR4mfccB+tPy4Ny7kzOlr/VNeb0ULf96R0AWFWCtdt8AmujAP0DYiM5FSmYLI0XRhpSDjnEbBM8+isNE1GlAVR3NzzemwQORihScovpAktbRSN/d3N+NgTjSoVDiJvCOxCs3thX9qt9iwYbA+/X/gv8lza2FZyIzwkQxGRcYl8JWKpXzNW8EWUNVnSLdHvQttDeV3CvgP/x579RGd6whyFYS6AaI0qw7oTjCFh2EHS/VzGvFuv166ZlVIJ4MNvg79O9h63ZOSE1LzVqEsVh8fDCfM2GgJ9aUdl95Djgunit4yIZOdoigR3f/BEHKrYCEham11rYohaAXs4XAXWihsV3WD5j4G/P+txvjAwujvf4HDwzHgFsmSml013U2mUiy+v4zw==";
////		String baseDecode = Hash.BASE_UTIL.decode(reqInfo);
////		System.out.println("BASE_UTIL解密结果："+ baseDecode);
////		System.out.println("base64解密："+str);
//		//gkaxLfcDN9DYDWP8AWY6EocUoSVQJ7z31IGcM7DMU7B4VPreEbCPU2XSyLX0AnUA
////		System.out.println("aes解密后结果："+ Encrypt.Aes256Decode(baseDecode.getBytes(), keys));
//		System.out.println("aes解密后结果："+ Encrypt.Aes256Decode(encodeAesB, keys));
////		System.out.println("aes解密后结果："+ Encrypt.Aes256Decode(str.getBytes(), keys));
//	}
//	public static void main(String[] args) {
//		//原系统是32位
////		HashTest.getDesUtil();//56
////		HashTest.testBase64Util();//48
////		HashTest.testAESUtil();//双密码 64
//		try {
//			HashTest.testEncrpt();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//双密码 64
////		System.out.println("des加密的keydata"+"ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789-_.".length());
////		System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".length());
////		System.out.println("402880ef5cd2b925015cd2b925b90000".equals("402880ef5cd2b925015cd2b925b90000"));
//	}
//}
