package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:包体编码实体
 * @projectName:crud
 * @className:ProductCodePo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月8日 上午10:28:46
 * @version 1.0
 */
@TableName(name="product_code")
public class ProductCodePo extends Po{
	
    private Long id;				//通道编码ID

    private String productName;		//产品编码名称
    
    private Integer pgId;			//包体ID

    private String scopeCityCode;	//地区编码

    private Double pgEncodePrice;	//包体编码价格

    private Integer epId;			//平台ID

    private String productCode;		//产品编码
    @TempField
    private Integer pgSize;			//包体大小
    @TempField
    private Double pgPrice;			//包体价格
    @TempField
    private String pgName;			//包体名称
    @TempField
    private Integer operatorType;	//包体运营商类型
    @TempField
    private Integer serviceType;	//包体类型
    @TempField
    private Integer pgType;				//流量类型（1-流量包，2-流量池）
    @TempField
    private String pgValidity;			//流量有效期(PgValidityEnum)
    @TempField
    private Integer circulateWay;				//流通方式（1-普通通道包，2-红包通道，3-转移包，4-共享包）ChannelTypeEnum
    @TempField
    private String epName;			//平台名称

    public Integer getCirculateWay() {
		return circulateWay;
	}

	public void setCirculateWay(Integer circulateWay) {
		this.circulateWay = circulateWay;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
		this.pgName = pgName;
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

	public String getEpName() {
		return epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPgId() {
        return pgId;
    }

    public void setPgId(Integer pgId) {
        this.pgId = pgId;
    }

    public String getScopeCityCode() {
        return scopeCityCode;
    }

    public void setScopeCityCode(String scopeCityCode) {
        this.scopeCityCode = scopeCityCode == null ? null : scopeCityCode.trim();
    }

    public Double getPgEncodePrice() {
        return pgEncodePrice;
    }

    public void setPgEncodePrice(Double pgEncodePrice) {
        this.pgEncodePrice = pgEncodePrice;
    }

    public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }
}