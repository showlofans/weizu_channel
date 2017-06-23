package com.weizu.flowsys.util;

import org.weizu.web.foundation.StringUtil;

import com.weizu.flowsys.web.base.ATT;

/**
 * 字符串操作工具类整理
 * @author 郭胜凯
 * @time 2016年6月3日下午2:21:40
 * @email 719348277@qq.com
 *
 */
public class StringUtil2 {

	/**
	 * 获取字符串摘要
	 * @param text 富文本字符串
	 * @param length 摘要长度
	 * @param omit 超出部分省略符
	 * @return
	 */
	public static String getPaper(String text, int length, String omit){
		text = text.replaceAll("</?[^>]+>", ""); 
		text = text.replaceAll("<a>\\s*|t|r|n</a>", "");
		
		if (text.length() > length) {
			return text.substring(0, length - omit.length()) + omit;
		}
		return text;
	}
	/**
	 * @description:根据前台传的字符串转成相应的折扣
	 * @param channelDiscount
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年5月18日 下午7:38:53
	 */
	public static Double getDiscount(String channelDiscount){
		double discount = 1.00d;
		if(channelDiscount != null){
			if(channelDiscount.substring(0).equals("0") || channelDiscount.trim().length() == 1){//只有一个数字，或者第一个数字是0
				discount = StringUtil.getDouble(channelDiscount)/ATT.SINGLE_NUMBER_DIVIDE;
			}else if(channelDiscount.trim().length() == 2){//有两位数字
				discount = StringUtil.getDouble(channelDiscount)/ATT.DOUBLE_NUMBER_DIVIDE;
			}else if(channelDiscount.trim().length() == 3){
				discount = StringUtil.getDouble(channelDiscount)/ATT.TRIPLE_NUMBER_DIVIDE;
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
	public static String getDiscountVO(Double discountD){
		String channelDiscount = discountD + "";
		int bit = channelDiscount.trim().length()-channelDiscount.indexOf(".")-1;//位数
		double discount = 1.00d;
		if(channelDiscount != null){
			if(bit == 1){//只有位小数字
				discount = StringUtil.getDouble(channelDiscount) * ATT.SINGLE_NUMBER_DIVIDE;
			}else if(bit == 2){//有两位数字
				discount = StringUtil.getDouble(channelDiscount) * ATT.DOUBLE_NUMBER_DIVIDE;
			}else if(bit == 3){
				discount = StringUtil.getDouble(channelDiscount) * ATT.TRIPLE_NUMBER_DIVIDE;
			}
		}
		return discount+"";
	}
}
