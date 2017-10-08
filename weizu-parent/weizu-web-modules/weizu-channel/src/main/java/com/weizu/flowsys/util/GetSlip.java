package com.weizu.flowsys.util;

import com.weizu.web.foundation.DateUtil;

/**
 * @description: 获得时间戳（转账）凭条
 * @projectName:weizu-channel
 * @className:GetSlip.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月8日 上午10:34:12
 * @version 1.0
 */
public class GetSlip {
	
//	public static void main(String[] args) {
//		Long nowTime = System.currentTimeMillis();
//		nowTime = nowTime << 2;
//		System.out.println(nowTime);
//		System.out.println(String.valueOf(nowTime).length());
//	}
	
	/**
	 * @description:13位转账凭条
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月8日 上午10:56:07
	 */
	public static Long getSlip(){
//		Long nowTime = System.currentTimeMillis() << 2;
		return System.currentTimeMillis() << 2;
	}
}
