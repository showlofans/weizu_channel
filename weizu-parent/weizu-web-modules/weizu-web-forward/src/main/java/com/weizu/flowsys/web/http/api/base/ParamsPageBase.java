package com.weizu.flowsys.web.http.api.base;

/**
 * @description: 基本的page准备参数（含所有api）
 * @projectName:testHttpInterface
 * @className:ParamsPageBase.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午3:49:19
 * @version 1.0
 */
public abstract class ParamsPageBase {
	
	public String requestUrl; //余额地址

	public String epName;	//平台名称
	
	public String epUserName;//平台用户名
	
	public String apikey;	//平台apikey

	public ParamsPageBase(String requestUrl, String epName, String epUserName,
			String apikey) {
		super();
		this.requestUrl = requestUrl;
		this.epName = epName;
		this.epUserName = epUserName;
		this.apikey = apikey;
	}
}
