package crud.aotest;

import java.util.Random;

import org.junit.Test;

import com.weizu.flowsys.util.StringUtil2;
import com.weizu.flowsys.util.UUIDGenerator;
import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.MD5Util;

public class StringTest {

//	//使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
//    public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
//    private static Random random = new Random();
// 
// 
//    /**
//     * 使用系统默认字符源生成验证码
//     * @param verifySize    验证码长度
//     * @return
//     */
//    public static String generateVerifyCode(int verifySize){
//        return generateVerifyCode(verifySize, VERIFY_CODES);
//    }
//    /**
//     * 使用指定源生成验证码
//     * @param verifySize    验证码长度
//     * @param sources   验证码字符源
//     * @return
//     */
//    public static String generateVerifyCode(int verifySize, String sources){
//        if(sources == null || sources.length() == 0){
//            sources = VERIFY_CODES;
//        }
//        int codesLen = sources.length();
//        Random rand = new Random(System.currentTimeMillis());
//        StringBuilder verifyCode = new StringBuilder(verifySize);
//        for(int i = 0; i < verifySize; i++){
//            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));
//        }
//        return verifyCode.toString();
//    }
//	/**
//	 * @description:折扣计算测试
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年5月12日 下午4:26:11
//	 */
////	@Test
////	public void testInteger() {
////		String test = "09";
////		int testInt = StringUtil.getInt(test);
////		double printTest = StringUtil.getDouble(test);
////		System.out.println((double) testInt / 10);
////		System.out.println(printTest / 10);
////	}
//    
//    /**
//     * @description:获得字符串长度
//     * @param str
//     * @return
//     * @author:POP产品研发部 宁强
//     * @createTime:2017年6月1日 上午11:46:04
//     */
//    public static int getStringLength(String str){
//    	return str.length();
//    }
//
//	@Test
//	public void testToUppseClass(){
//		String str = StringUtil2.toUpperClass("zero_fisr_sec");
//		String str1 = StringUtil2.toUpperClass("zero_sec");
//		String str2 = StringUtil2.toUpperClass("zero");
//		System.out.println(str);
//		System.out.println(str1);
//		System.out.println(str2);
//	}
//	@Test
//	public void testToUppseClass1(){
//		String str = StringUtil2.toUpperClass("zero_fisr_sec");
//		String str1 = StringUtil2.toUpperClass("zero_sec");
//		String str2 = StringUtil2.toUpperClass("zero");
//		System.out.println(str);
//		System.out.println(str1);
//		System.out.println(str2);
//	}
//	public static void main(String[] args) {
//		String str = StringUtil2.toUpperClass("zero_fisr_sec");
//		System.out.println(str);
		
//		UUIDGenerator generator = new UUIDGenerator();
//		String userApiKey = generator.generate().toString();
//		System.out.println("098f6bcd4621d373cade4e832627b4f6".length());//待md5编码的32位字符串
//		String text1 = MD5.getMd5("456"+"&098f6bcd4621d373cade4e832627b4f6");
//		System.out.println(text1);
//		String text = MD5.getMd5("456"+"&098f6bcd4621d373cade4e832627b4f6");
//		System.out.println(text);
//		System.out.println(text.equals(text1));
//		String test = "内蒙古移动";
//		System.out.println(test.substring(0, test.length()-2));
//		System.out.println(StringUtil2.getDiscount(21d));
////		Random r = new Random(1+5);
////		System.out.println(r.nextInt());
////		System.out.println(generateVerifyCode(4));
////		System.out.println(getStringLength("60efa0eca5a38e56b65ae75afa4760b6"));
////		double res = NumberTool.mul(180.0d, 0.56d);
////		System.out.println(res);
////		 System.out.println(DateUtil.formatAll(DateUtil.getStartTime()));
////		 System.out.println(DateUtil.formatAll(DateUtil.getEndTime()));
////		List<String> list = new ArrayList<String>(100);
////		list.add("1");
////		System.out.println(list.size());
//		String longStr = "1111111	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1";
//		String t = longStr.replaceAll(" ", "");
//		
//		System.out.println(t);
//		System.out.println(longStr.trim().length());
//		
////		Calendar todayStart = Calendar.getInstance();
////		System.out.println(DateUtil.formatAll(todayStart.getTime()));
	}
//}
