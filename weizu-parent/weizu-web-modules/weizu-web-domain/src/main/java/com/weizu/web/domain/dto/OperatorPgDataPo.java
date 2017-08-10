package com.weizu.web.domain.dto;

import org.weizu.web.foundation.core.annotation.po.TableName;
import org.weizu.web.foundation.core.annotation.po.TempField;
import org.weizu.web.foundation.core.beans.Po;


/**
 * @description:订购流量包种类实体类
 * @projectName:crud
 * @className:OperatorPgData.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月26日 上午11:27:54
 * @version 1.0
 */
@TableName(name="operator_pg_data")
public class OperatorPgDataPo extends Po {
	
    private Integer id;				//流量包id
    
    private Integer operatorType;		//运营商类型（0-移动，1-联通，电信）
    
    private String operatorName;		//运营商名称

    private Integer pgSize;				//流量包大小

    private Double pgPrice;				//流量包价格（原价）

    private String pgName;				//流量包业务名称（100元3072MB）

    private Integer pgInService;		//开通状态（0-开通，1-关闭）
   
    private Integer serviceType;			//业务类型（0-全国，1-省内，2-省漫游，3-转赠,4-红包）
    
    @TempField
    private Double pgDiscountPrice;		//流量包价格（折扣）
    @TempField
    private String productCode;				//产品编码

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getPgDiscountPrice() {
		return pgDiscountPrice;
	}

	public void setPgDiscountPrice(Double pgDiscountPrice) {
		this.pgDiscountPrice = pgDiscountPrice;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Integer getPgSize() {
        return pgSize;
    }

    public void setPgSize(Integer pgSize) {
        this.pgSize = pgSize;
    }

    public Double getPgPrice() {
        return pgPrice;
    }

    public void setPgPrice(Double pgPrice) {
        this.pgPrice = pgPrice;
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName == null ? null : pgName.trim();
    }

    public Integer getPgInService() {
        return pgInService;
    }

    public void setPgInService(Integer pgInService) {
        this.pgInService = pgInService;
    }
    public static void main(String[] args) {
    	OperatorPgDataPo po = new OperatorPgDataPo();
    	
    	System.out.println(po);;
	}
}