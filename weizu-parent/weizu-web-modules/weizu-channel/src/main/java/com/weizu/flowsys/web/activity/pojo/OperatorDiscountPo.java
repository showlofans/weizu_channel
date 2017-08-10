package com.weizu.flowsys.web.activity.pojo;

import java.util.List;
import java.util.Map;

import org.weizu.web.foundation.core.annotation.po.TableName;
import org.weizu.web.foundation.core.annotation.po.TempField;
import org.weizu.web.foundation.core.beans.Po;

/**
 * @description:费率（运营商地区折扣）实体
 * @projectName:crud
 * @className:OperatorDiscountPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月18日 下午4:04:14
 * @version 1.0
 */
@TableName(name="operator_discount")
public class OperatorDiscountPo extends Po {
  
	private Long id;

    private Integer operatorType;

    private String scopeName;			//地区名字

    private Double discount;			//地区折扣

    private String rateName;			//费率名称

    private Long rateId;		//费率id

    private Integer rootAgencyId;		//费率所属代理商id
    
    @TempField
    private String operatorScope;	//地区和运营商
    @TempField
    private List<Map<String,Object>> scopeCityNames;
    
    public OperatorDiscountPo(Integer operatorType, String scopeName,
			Double discount, String rateName, Integer rootAgencyId) {
		super();
		this.operatorType = operatorType;
		this.scopeName = scopeName;
		this.discount = discount;
		this.rateName = rateName;
		this.rootAgencyId = rootAgencyId;
	}

	public List<Map<String, Object>> getScopeCityNames() {
		return scopeCityNames;
	}

	public void setScopeCityNames(List<Map<String, Object>> scopeCityNames) {
		this.scopeCityNames = scopeCityNames;
	}



	public String getOperatorScope() {
		return operatorScope;
	}

	public void setOperatorScope(String operatorScope) {
		this.operatorScope = operatorScope;
	}


	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}



	public OperatorDiscountPo() {
		super();
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName == null ? null : scopeName.trim();
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName == null ? null : rateName.trim();
    }

    public Integer getRootAgencyId() {
        return rootAgencyId;
    }

    public void setRootAgencyId(Integer rootAgencyId) {
        this.rootAgencyId = rootAgencyId;
    }
}