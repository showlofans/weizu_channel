package com.weizu.flowsys.web.channel.pojo;

/**
 * @description:查詢參數封裝
 * @projectName:crud
 * @className:OneCodePo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月10日 下午6:04:26
 * @version 1.0
 */
public class OneCodePo {
	
	private String scopeCityCode;
	
	private Integer pgSize;
	
	private Integer operatorType;
	
	private Integer serviceType;
	
	private Integer epId;
	
	private Integer pgId;				//包体Id
	
	private Integer pgType;				//流量类型（1-流量包，2-流量池）
    
    private String pgValidity;			//流量有效期(PgValidityEnum)
    
	/** 查询是否存在该包体参数
	 * @param epId
	 * @param serviceType
	 * @param operatorType
	 * @param scopeCityCode
	 * @param pgType
	 * @param pgValidity
	 */
	public OneCodePo(Integer epId, Integer serviceType,
			Integer operatorType, String scopeCityCode, Integer pgType,
			String pgValidity) {
		super();
		this.epId = epId;
		this.serviceType = serviceType;
		this.operatorType = operatorType;
		this.scopeCityCode = scopeCityCode;
		this.pgType = pgType;
		this.pgValidity = pgValidity;
	}
	
	public OneCodePo() {
		super();
	}

	/** 查询唯一编码参数
	 * @param scopeCityCode
	 * @param pgSize
	 * @param operatorType
	 * @param serviceType
	 * @param epId
	 */
	public OneCodePo(String scopeCityCode, Integer pgSize,
			Integer operatorType, Integer serviceType, Integer epId,Integer pgType,Integer pgValidity) {
		super();
		this.epId = epId;
		this.scopeCityCode = scopeCityCode;
		this.pgSize = pgSize;
		this.operatorType = operatorType;
		this.serviceType = serviceType;
	}
	
	/** 查询唯一编码参数
	 * @param scopeCityCode
	 * @param epId
	 * @param pgId
	 */
	public OneCodePo(String scopeCityCode, Integer epId, Integer pgId) {
		super();
		this.scopeCityCode = scopeCityCode;
		this.epId = epId;
		this.pgId = pgId;
	}
	
	public Integer getPgId() {
		return pgId;
	}

	public void setPgId(Integer pgId) {
		this.pgId = pgId;
	}

	public Integer getEpId() {
		return epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public String getScopeCityCode() {
		return scopeCityCode;
	}

	public void setScopeCityCode(String scopeCityCode) {
		this.scopeCityCode = scopeCityCode;
	}

	public Integer getPgSize() {
		return pgSize;
	}

	public void setPgSize(Integer pgSize) {
		this.pgSize = pgSize;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getPgType() {
		return pgType;
	}

	public void setPgType(Integer pgType) {
		this.pgType = pgType;
	}

	public String getPgValidity() {
		return pgValidity;
	}

	public void setPgValidity(String pgValidity) {
		this.pgValidity = pgValidity;
	}
}
