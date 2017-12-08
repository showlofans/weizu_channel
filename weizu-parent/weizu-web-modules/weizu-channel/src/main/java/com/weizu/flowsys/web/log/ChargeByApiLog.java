package com.weizu.flowsys.web.log;

/**
 * @description: 接口传单日志
 * @projectName:weizu-channel
 * @className:ChargeByApiLog.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月8日 下午4:34:47
 * @version 1.0
 */
public class ChargeByApiLog {
	
	private Integer chargeFor;			//pgServiceTypeEnum
	
	private String otherParams;			//其他参数
	
	private String chargeTel;			//传单号码
	
	private Integer accountId;			//传单账户id
	
	private Long orderArriveTime;		//传单时间
	
	private String productCode;			//所传产品编码
	
	private String sign;				//数字签名
	//TODO 
	
}
