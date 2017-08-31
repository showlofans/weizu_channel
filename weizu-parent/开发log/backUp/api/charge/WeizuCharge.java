package com.weizu.flowsys.api.charge;


/**
 * @description: 微族充值
 * @projectName:weizu-channel
 * @className:ParamsCharge.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月16日 下午3:17:41
 * @version 1.0
 */
//public class WeizuCharge extends BaseCharge implements IChargeFacet {
//
//	//private String url;					//充值地址
//	
//	private String sign;				//密钥
//	
//	private String userName;			//用户名
//	
//	public WeizuCharge(String url, String apiKey, String pCode, String userName) {
//		super(url, apiKey, pCode);
//		this.userName = userName;
//	}
//
//	public WeizuCharge() {
//		super();
//	}
//
//	/**
//	 * @description:生成密钥
//	 * @return
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月16日 下午4:06:45
//	 */
//	@Override
//	protected String generateSign() {
//		sign = MD5.getMd5("apiKey="+apiKey+"&userName="+userName);
//		return sign;
//	}
//
//	/**
//	 * @description: 封装查询参数
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月16日 下午4:07:05
//	 */
//	@Override
//	protected void initParamsBuffer() {
//		//设置充值地址，
//		
//		paramsBuffer.append("");
//	}
//
//	/**
//	 * @description: 发送请求，调用充值接口
//	 * @return
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月16日 下午4:09:17
//	 */
//	@Override
//	public ChargeDTO charge() {
//		//初始化参数
//		initParamsBuffer();
//		//调用父类进行充值
//		String resultStr = super.charge("GET");
//		//把结果解析出来返回
//		
//		return getChargeDTO(resultStr);
//	}
//
//	/**
//	 * @description: 把结果解析出来返回
//	 * @param resultStr
//	 * @return
//	 * @author:微族通道代码设计人 宁强
//	 * @createTime:2017年8月17日 上午10:35:50
//	 */
//	@Override
//	protected ChargeDTO getChargeDTO(String resultStr) {
//		ChargeDTO chargeDTO = new ChargeDTO();
//		
//		chargeDTO.setOrderIdApi(resultStr);
//		
//		return chargeDTO;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	public void setSign(String sign) {
//		this.sign = sign;
//	}
//
//	public String getSign() {
//		return sign;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//}
