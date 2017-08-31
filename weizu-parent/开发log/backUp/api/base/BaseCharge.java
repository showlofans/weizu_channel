package com.weizu.flowsys.api.base;

import com.weizu.flowsys.api.weizu.charge.ChargeDTO;

/**
 * @description: 对上充值方式基类
 * @projectName:weizu-channel
 * @className:BaseCharge.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月16日 下午3:50:23
 * @version 1.0
 */
//public abstract class BaseCharge {
//	protected String url;												//请求地址
//	protected String apiKey;											//钥匙
//	protected String pCode;												//包体编码
//	protected StringBuffer paramsBuffer = new StringBuffer();			//请求参数
//	
//	public BaseCharge(String url, String apiKey, String pCode) {
//		super();
//		this.url = url;
//		this.apiKey = apiKey;
//		this.pCode = pCode;
//	}
//
//	public BaseCharge() {
//		super();
//	}
//
//
//	/**
//	 * @description: 获得钥匙获得相应的密钥
//	 * @param apiKey 来自数据库数据
//	 * @return 根据不同平台相应密钥生成策略生成的密钥
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月16日 下午3:41:04
//	 */
//	protected String generateSign(){
//		
//		return null;
//	}
//	
//	/**
//	 * @description: 初始化参数
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月16日 下午3:52:11
//	 */
//	protected void initParamsBuffer(){
//		String sign = generateSign();//密钥
//		//把密钥放入参数中
//	}
//	
//	/**
//	 * @description:充值
//	 * @return
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月16日 下午3:51:13
//	 */
//	protected String charge(String method){
//		if("GET".equals(method)){
////			return HttpRequest.sendGet(url, paramsBuffer.toString());
//		}else{
////			return HttpRequest.sendPost(url, paramsBuffer.toString());
//		}
//		return url;
//	}
//	
//	protected ChargeDTO getChargeDTO(String resultStr){
////		String resultStr = charge("GET");
//		//把结果解析出来返回
//		return null;
//	}
//	
//	
//	
//}
