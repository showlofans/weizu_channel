package org.weizu.api.base;

/**
 * @description:api查询必须的参数
 * @projectName:testHttpInterface
 * @className:ParamsAPIBase.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午3:41:53
 * @version 1.0
 */
public abstract class ParamsAPIBase {
	
	public String username;//用户名
	
	public String apikey;//apikey
	
	public String url;
	
	public String epName;	//平台名称

	public ParamsAPIBase(String username, String apikey, String url,
			String epName) {
		super();
		this.username = username;
		this.apikey = apikey;
		this.url = url;
		this.epName = epName;
	}

	public abstract String toParams();

//	public ParamsAPIBase() {
//		super();
//	}
}
