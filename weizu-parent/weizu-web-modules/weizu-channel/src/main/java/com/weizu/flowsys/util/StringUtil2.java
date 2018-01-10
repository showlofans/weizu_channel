package com.weizu.flowsys.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.weizu.flowsys.web.base.ATT;
import com.weizu.web.foundation.StringUtil;
import com.weizu.web.foundation.String.StringHelper;

/**
 * @description: 字符串操作工具类整理
 * @projectName:weizu-channel
 * @className:StringUtil2.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月30日 上午11:56:51
 * @version 1.0
 */
public class StringUtil2 {

	/**
	 * 获取字符串摘要
	 * 
	 * @param text
	 *            富文本字符串
	 * @param length
	 *            摘要长度
	 * @param omit
	 *            超出部分省略符
	 * @return
	 */
	public static String getPaper(String text, int length, String omit) {
		text = text.replaceAll("</?[^>]+>", "");
		text = text.replaceAll("<a>\\s*|t|r|n</a>", "");

		if (text.length() > length) {
			return text.substring(0, length - omit.length()) + omit;
		}
		return text;
	}
	
	public   static   String filterString(String   str)   throws   PatternSyntaxException   {      
        // 只允许字母和数字        
        // String   regEx  =  "[^a-zA-Z0-9]";                      
           // 清除掉所有特殊字符   
		  String regEx="[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";   
		  Pattern   p   =   Pattern.compile(regEx);      
		  Matcher   m   =   p.matcher(str);      
		  return   m.replaceAll("").trim();      
	  }      

	/**
	 * @description:根据前台传的字符串转成相应的折扣
	 * @param channelDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 下午7:38:53
	 */
	public static Double getDiscount(String channelDiscount) {
		double discount = 1.00d;
		if (channelDiscount != null) {
			if (channelDiscount.substring(0).equals("0")
					|| channelDiscount.trim().length() == 1) {// 只有一个数字，或者第一个数字是0
				discount = StringUtil.getDouble(channelDiscount)
						/ ATT.SINGLE_NUMBER_DIVIDE;
			} else if (channelDiscount.trim().length() == 2) {// 有两位数字
				discount = StringUtil.getDouble(channelDiscount)
						/ ATT.DOUBLE_NUMBER_DIVIDE;
			} else if (channelDiscount.trim().length() == 3) {
				discount = StringUtil.getDouble(channelDiscount)
						/ ATT.TRIPLE_NUMBER_DIVIDE;
			}
		}
		return discount;
	}

	/**
	 * @description: 根据前台传的double转成相应的折扣(56.0转成0.56)
	 * @param channelDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月5日 上午11:11:31
	 */
	public static Double getDiscount(Double channelDiscount) {
		double discount = 1.00d;
		String discountStr = channelDiscount + "";
		int indexDot = discountStr.trim().indexOf(".");
		String discountIndex = discountStr.substring(0, indexDot);
		if (channelDiscount != null) {
			if (discountIndex.substring(0).equals("0")
					|| discountIndex.length() == 1) {// 只有一个数字，或者第一个数字是0
				discount = StringUtil.getDouble(discountIndex)
						/ ATT.SINGLE_NUMBER_DIVIDE;
			} else if (discountIndex.trim().length() == 2) {// 有两位数字
				discount = StringUtil.getDouble(discountIndex)
						/ ATT.DOUBLE_NUMBER_DIVIDE;
			} else if (discountIndex.length() == 3) {
				discount = StringUtil.getDouble(discountIndex)
						/ ATT.TRIPLE_NUMBER_DIVIDE;
			}
		}
		return discount;
	}

	/**
	 * @description:0.22返回22
	 * @param channelDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月19日 下午12:46:37
	 */
	public static String getDiscountVO(Double discountD) {
		String channelDiscount = discountD + "";
		int bit = channelDiscount.trim().length()
				- channelDiscount.indexOf(".") - 1;// 位数
		Double discount = 1.00d;
		if (channelDiscount != null) {
			if (bit == 1) {// 只有位小数字
				discount = StringUtil.getDouble(channelDiscount)
						* ATT.SINGLE_NUMBER_DIVIDE;
			} else if (bit == 2) {// 有两位数字
				discount = StringUtil.getDouble(channelDiscount)
						* ATT.DOUBLE_NUMBER_DIVIDE;
			} else if (bit == 3) {
				discount = StringUtil.getDouble(channelDiscount)
						* ATT.TRIPLE_NUMBER_DIVIDE;
			}
		}
		return discount.toString();
	}

	/**
	 * @description: 转换成类名字符串
	 * @see ：把“weizu_tec”换成WeizuTec
	 * @param epEngId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月17日 上午11:45:48
	 */
	public static String toUpperClass(String epEngId) {
		StringBuffer sb = new StringBuffer();
		// 如果后面没有下划线，就直接加上剩余部分，如果有下划线，就先加上第一个下划线之前的部分
		if (epEngId.lastIndexOf("_") == -1) {// 不带下划线
			sb.append(epEngId.substring(0, 1).toUpperCase());
			sb.append(epEngId.substring(1));
		} else {
			int indexOfXiaHua = epEngId.indexOf("_");
			String first = epEngId;
			do {
				if (first.lastIndexOf("_") == -1) {
					sb.append(first.substring(0, 1).toUpperCase());
					sb.append(first.substring(1));
					break;
				} else {
					indexOfXiaHua = first.indexOf("_");
					sb.append(first.substring(0, 1).toUpperCase());
					sb.append(first.substring(1, indexOfXiaHua));
				}
				first = first.substring(indexOfXiaHua + 1);
			} while (indexOfXiaHua != -1);
		}
		return sb.toString();
	}

	/**
	 * @description: 通过字段和参考参数组合字符串，找到与这个字段相关的参数
	 * @param referStr
	 * @param charSeq
	 *            字段
	 * @return clientId=10000
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年8月30日 上午11:59:41
	 */
	public static String getParamsByCharSeq(String referStr, String charSeq) {
		if(StringHelper.isNotEmpty(referStr)){
			int charSeqInd = referStr.indexOf(charSeq); // 字段索引
			if(charSeqInd == -1){
				return null;
			}
			String seperatorRefer = referStr.substring(charSeqInd);// 以便找到这个字段后面的第一个&
			String params = seperatorRefer
					.substring(0, seperatorRefer.indexOf("&"));
			return params;
		}else{
			return referStr;
		}
	}
	/**
	 * @description: 根据get形式字符串获得参数数组
	 * @param referStr
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月21日 下午3:26:02
	 */
	public static String[] getArrayByCharSeq(String referStr) {
		String [] firstArray = referStr.split("&");//mrch_no=10084
		String [] secondArray = new String[firstArray.length];
		for (int i = 0; i < firstArray.length; i++) {
			String firstStr = firstArray[i];
			secondArray[i] = firstStr.substring(0, firstStr.indexOf("="));
		}
		return secondArray;
	}
	
	/**
	 * @description: 根据get形参数获得键值对形式参数-HashMap
	 * @param referStr
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月21日 下午3:55:36
	 */
	public static Map<String,Object> getHashMapByStr(String referStr) {
		String [] firstArray = referStr.split("&");//mrch_no=10084
		Map<String,Object> map = new HashMap<String, Object>();
		for (int i = 0; i < firstArray.length; i++) {
			String firstStr = firstArray[i];
			String key = firstStr.substring(0, firstStr.indexOf("="));
			String value = firstStr.substring(firstStr.indexOf("=")+1, firstStr.length());
			map.put(key, value);
		}
		return map;
	}
	/**
	 * @description: 根据get形参数获得键值对形式参数-TreeMap
	 * @param referStr
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月21日 下午3:55:36
	 */
	public static Map<String,Object> getTreeMapByStr(String referStr) {
		String [] firstArray = referStr.split("&");//mrch_no=10084
		Map<String,Object> map = new TreeMap<String, Object>();
		for (int i = 0; i < firstArray.length; i++) {
			String firstStr = firstArray[i];
			String key = firstStr.substring(0, firstStr.indexOf("="));
			String value = firstStr.substring(firstStr.indexOf("=")+1, firstStr.length());
			map.put(key, value);
		}
		return map;
	}
	/**
	 * @description: 打印升序排列的数组
	 * @param attr
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年1月10日 下午4:41:24
	 */
	public static void printSortedArr(String[] attr) {
		Arrays.sort(attr);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (String string : attr) {
			sb.append("\"");
			sb.append(string);
			sb.append("\",");
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	
	
	

//	public boolean validateSign(Map<String, Object> map, String sign)
//			throws Exception {
//		String s = "";
//		Iterator ir = map.keySet().iterator();// 获取hashMap的键值，并进行遍历
//		while (ir.hasNext()) {// 千万不要用map.keyset，无序的set你懂得，再次打乱你的排序
//			String key = ir.next().toString();
//			s += key;
//			s += "=";
//			s += map.get(key);
//		}
//		Token token = tokenDao.findByCode(map.get("companyCode") + "_"
//				+ map.get("equipmentCode"));
//		s += "token=" + token.getToken();
//		MessageDigest md5 = MessageDigest.getInstance("MD5");
//		BASE64Encoder base64 = new BASE64Encoder();
//		String string = base64.encode(md5.digest(s.getBytes("utf-8")));
//		if (string.equals(sign)) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	// 客户端将参数排序进行MD5加密后，得到sign。
//	// 服务端再次将你的参数排序进行MD5加密，比较两次得到的值，相同校验成功。为了防止抓包，然后不停发送攻击的包，可以把
//	// 时间戳当做参数加入其中。
//
//	public boolean validateTimeStamp(String TimeStamp) throws Exception {
//		Date dt = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		Date timestamp = sdf.parse(TimeStamp);
//		if ((dt.getTime() - timestamp.getTime()) / 60000 > 5) {// 验证时间戳是否超过五分钟
//			return false;
//		} else {
//			return true;
//		}
//	}

	// public static String toUpperClass(String epEngId){
	// StringBuffer sb = new StringBuffer();
	// //如果后面没有下划线，就直接加上剩余部分，如果有下划线，就先加上第一个下划线之前的部分
	// if(epEngId.lastIndexOf("_") == -1){//不带下划线
	// sb.append(epEngId.substring(0, 1).toUpperCase());
	// sb.append(epEngId.substring(1));
	// }else{
	// String first = epEngId;
	// do{
	// int indexOfNextXiaHua = first.indexOf("_");
	// if(indexOfNextXiaHua != -1){//包涵下划线
	// if(indexOfNextXiaHua == 0){//需要重新修改值（_second_fisrt）
	// first = first.substring(1);
	// indexOfNextXiaHua = first.indexOf("_");
	// if(indexOfNextXiaHua == -1){//最后一个
	// sb.append(first.substring(0, 1).toUpperCase());
	// sb.append(first.substring(1));
	// break;
	// }
	// }
	// sb.append(first.substring(0, 1).toUpperCase());
	// sb.append(first.substring(1,indexOfNextXiaHua));
	// }
	// first = first.substring(indexOfNextXiaHua);
	// }while(first.indexOf("_")!=-1);
	// }
	//
	// return sb.toString();
	// }
}
