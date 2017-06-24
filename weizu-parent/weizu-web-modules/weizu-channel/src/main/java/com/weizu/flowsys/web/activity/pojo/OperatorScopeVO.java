package com.weizu.flowsys.web.activity.pojo;

/**
 * @description:地区运营商实体（异步请求最优通道）
 * @projectName:crud
 * @className:OperatorScopePo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月18日 上午9:54:58
 * @version 1.0
 */
public class OperatorScopeVO {
	
	private String operatorType;
	
	private String scopeCityName;
	
//	private String scopeCityCode;
	
	private String agencyId;
	
	private Integer aid;		//代理商id查询参数
	
	private Integer otype;		//运营商类型查询参数
	
	public OperatorScopeVO() {
		super();
	}

	public OperatorScopeVO(String operatorType, String scopeCityName,
			String agencyId) {
		super();
		this.operatorType = operatorType;
		this.scopeCityName = scopeCityName;
		this.agencyId = agencyId;
	}
	
	public OperatorScopeVO(String scopeCityName, Integer aid, Integer otype) {
		super();
		this.scopeCityName = scopeCityName;
		this.aid = aid;
		this.otype = otype;
	}

//	public String getScopeCityCode() {
//		return scopeCityCode;
//	}
//
//	public void setScopeCityCode(String scopeCityCode) {
//		this.scopeCityCode = scopeCityCode;
//	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getOtype() {
		return otype;
	}

	public void setOtype(Integer otype) {
		this.otype = otype;
	}

	public String getAgencyId() {
		return agencyId;
	}


	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}


	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public String getScopeCityName() {
		return scopeCityName;
	}

	public void setScopeCityName(String scopeCityName) {
		this.scopeCityName = scopeCityName;
	}
	
	
}
