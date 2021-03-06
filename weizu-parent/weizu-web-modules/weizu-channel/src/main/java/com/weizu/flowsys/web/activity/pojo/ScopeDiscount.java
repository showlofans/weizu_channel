package com.weizu.flowsys.web.activity.pojo;

/**
 * @description:地区折扣实体
 * @projectName:crud
 * @className:ScopeDiscount.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月10日 下午5:13:13
 * @version 1.0
 */
public class ScopeDiscount {
	
	private String scopeCityName;				//包城市名
	
	private String channelDiscount = "1.00";		//折扣
	
	private String scopeCityCode;				//城市编码
	
	public ScopeDiscount(String scopeCityName, String channelDiscount,
			String scopeCityCode) {
		super();
		this.scopeCityName = scopeCityName;
		this.channelDiscount = channelDiscount;
		this.scopeCityCode = scopeCityCode;
	}

	public String getScopeCityCode() {
		return scopeCityCode;
	}

	public void setScopeCityCode(String scopeCityCode) {
		this.scopeCityCode = scopeCityCode;
	}

	public ScopeDiscount() {
		super();
	}
	public String getScopeCityName() {
		return scopeCityName;
	}
	public void setScopeCityName(String scopeCityName) {
		this.scopeCityName = scopeCityName;
	}
	public String getChannelDiscount() {
		return channelDiscount;
	}
	public void setChannelDiscount(String channelDiscount) {
		this.channelDiscount = channelDiscount;
	}
	
}
