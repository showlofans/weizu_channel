package com.weizu.flowsys.web.http.weizu;

import com.weizu.flowsys.web.http.BaseParams;

/**
 * @description:获得余额
 * @projectName:crud
 * @className:GetBalanceParams.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月16日 下午4:58:22
 * @version 1.0
 */
public class GetBalanceParams extends BaseParams {
	
	private String username;//用户名
	
	private String sign;//签名

	public GetBalanceParams(String username, String sign) {
		super();
		this.username = username;
		this.sign = sign;
	}

	public GetBalanceParams() {
		super();
	}

	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @description:
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年6月16日 下午5:16:55
	 */
	@Override
	public String toString() {
		return "username="+username+"&sign="+sign;
	}
	
	
	
}
