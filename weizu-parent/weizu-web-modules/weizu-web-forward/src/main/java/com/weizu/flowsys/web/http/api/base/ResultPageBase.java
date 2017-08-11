package com.weizu.flowsys.web.http.api.base;

/**
 * @description:页面必须返回的数据（含所有api）
 * @projectName:testHttpInterface
 * @className:ResultPageBase.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月19日 下午4:03:37
 * @version 1.0
 */
public class ResultPageBase {
	
	public int tipCode;
	
	public String tipMsg;

	public ResultPageBase(int tipCode, String tipMsg) {
		super();
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
	}

	
	
}
