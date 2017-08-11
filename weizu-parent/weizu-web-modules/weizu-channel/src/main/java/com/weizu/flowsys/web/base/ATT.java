package com.weizu.flowsys.web.base;

import com.weizu.web.foundation.MD5;

/**
 * 公共字段类
 * @author 郭胜凯
 * @time 2016年6月27日下午2:32:56
 * @email 719348277@qq.com
 *
 */
public class ATT {

	
	public static final String PROJECT_NAME = "Mybatis封装测试工程";
	
	/**
	 * 参数要统一生成
	 */
	public static final String sign = MD5.getMd5("");
	
	/**
	 * 折扣只有一个数字的除数
	 */
	public static final int SINGLE_NUMBER_DIVIDE = 10;			
	/**
	 * 折扣有两位数字的除数
	 */
	public static final int DOUBLE_NUMBER_DIVIDE = 100;			
	/**
	 * 折扣有三位数字的除数
	 */
	public static final int TRIPLE_NUMBER_DIVIDE = 1000;			
	
	
	
}
