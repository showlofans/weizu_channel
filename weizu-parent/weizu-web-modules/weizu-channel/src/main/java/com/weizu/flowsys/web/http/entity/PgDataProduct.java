package com.weizu.flowsys.web.http.entity;

/**
 * @description: 流量产品实体
 * @projectName:weizu-channel
 * @className:PgDataProduct.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月9日 下午1:07:11
 * @version 1.0
 */
public class PgDataProduct {
	
	 private String productCode;		//产品编码
	 
	 private String operatorName;		//运营商名称

	 private Integer pgSize;				//流量包大小
    
	 private String pgName;				//流量包业务名称（100元3072MB）

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getPgSize() {
		return pgSize;
	}

	public void setPgSize(Integer pgSize) {
		this.pgSize = pgSize;
	}

	public String getPgName() {
		return pgName;
	}

	public void setPgName(String pgName) {
		this.pgName = pgName;
	}
	 
}
