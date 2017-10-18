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
//import org.springframework.transaction.annotation.Transactional;
//
//import com.weizu.flowsys.core.beans.WherePrams;
//import com.weizu.flowsys.web.agency.dao.AgencyVODaoInterface;
//import com.weizu.flowsys.web.agency.pojo.AgencyBackwardPo;
//import com.weizu.web.foundation.hash.Hash;
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
//	@Test
//	public  void testBase64Util(){
////		WherePrams where = new WherePrams("id", ">", 2);
////		Integer startNum = 100;
////		List<AgencyBackwardPo> list = agencyVODao.list(where.limit(startNum, 10));
////		System.out.println(list.size());
////		System.out.println(list.get(0).getId());
////		//更新为加密后的密码
////		for (AgencyBackwardPo agencyBackwardPo : list) {
////			String oringinalPass = agencyBackwardPo.getUserPass();
////			String userPass = Hash.BASE_UTIL.encode(oringinalPass);
////			System.out.println("加密前的密码:" + oringinalPass + "\t加密后的密码："+ userPass);
////			agencyVODao.updatePass(agencyBackwardPo.getId(), userPass);
////		}
////		WherePrams where1 = new WherePrams("id", ">", 2);
////		List<AgencyBackwardPo> list1 = agencyVODao.list(where.limit(startNum, 10));
////		System.out.println(list1.size());
//////		//打印原来的密码
////		for (AgencyBackwardPo backPo : list1) {
////			String oringinalPass = backPo.getUserPass();
////			String userPass = Hash.BASE_UTIL.decode(oringinalPass);
////			System.out.println("解密前的密码:" + oringinalPass + "\t解密后的密码："+ userPass);
////			/*System.out.println(backPo.getUserName() + ":" + userPass);*/
////		}
//		String oringinalPass = "jeff123";
//		String userPass = Hash.BASE_UTIL.encode(oringinalPass);
//		System.out.println("加密前的密码:" + oringinalPass + "\t加密后的密码："+ userPass); 
////		agencyVODao.updatePass(2, userPass);
//		
////		System.out.println(list.get(0).getUserName());
////		System.out.println(list.get(list.size()-1).getUserName());
//		
////		Base64Util baseUtil = Hash.BASE_UTIL; 
////		String encodeBase64 = Hash.BASE_UTIL.encode("123");
////		System.out.println("base加密后结果："+ encodeBase64 +"\t总位数："+ encodeBase64.length());
////		//aHR0cDovLzEyMC43Ni4xOTQuNDU6ODA4MC9hcGkuYXNweA==
////		System.out.println("base解密后结果："+ Hash.BASE_UTIL.decode(encodeBase64));
//	}
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
////	/**
////	 * @description:两个密码加密
////	 * @author:POP产品研发部 宁强
////	 * @createTime:2017年6月1日 下午12:13:50
////	 */
////	public static void testAESUtil(){
////		AESUtil aesUtil =  Hash.AES_UTIL;
////		String encodeAes = aesUtil.encryptOfString("http://120.76.194.45:8080/api.aspx", "123");
////		System.out.println("aes加密后结果："+ encodeAes+"\t总位数："+ encodeAes.length());
////		//gkaxLfcDN9DYDWP8AWY6EocUoSVQJ7z31IGcM7DMU7B4VPreEbCPU2XSyLX0AnUA
////		System.out.println("aes解密后结果："+ aesUtil.decryptOfString(encodeAes, "123"));
////	}
////	public static void main(String[] args) {
////		//原系统是32位
//////		HashTest.getDesUtil();//56
////		HashTest.testBase64Util();//48
//////		HashTest.testAESUtil();//双密码 64
//////		System.out.println("des加密的keydata"+"ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789-_.".length());
//////		System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".length());
//////		System.out.println("402880ef5cd2b925015cd2b925b90000".equals("402880ef5cd2b925015cd2b925b90000"));
////	}
//}
