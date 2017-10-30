package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

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
   
    private Integer serviceType;			//业务类型（0-全国，1-省内，2-省漫游，//3-转赠,4-红包）
    
    private Integer pgType;				//流量类型（1-流量包，2-流量池）
    
    private Integer circulateWay;				//流通方式（1-普通通道包，2-红包通道，3-转移包，4-共享包）
    
    private String pgValidity;			//流量有效期(PgValidityEnum)
    
    @TempField
    private Double pgDiscountPrice;		//流量包价格（折扣）
    @TempField
    private String productCode;				//产品编码
//    @TempField
//    private String scopeCityCode;				//产品编码
    @TempField
    private Long channelId;				//通道id
    @TempField
    private String cnelName;			//通道名字
    @TempField
    private Double cdis;				//通道折扣
    @TempField
    private Long cdisId;				//通道折扣id
    @TempField
    private Long rteId;					//费率id
    @TempField
    private Double rteDis;				//费率折扣

	public OperatorPgDataPo(Integer id, Integer operatorType,
			String operatorName, Integer pgSize, Double pgPrice, String pgName,
			Integer pgInService, Integer serviceType, Integer pgType,
			String pgValidity,Integer circulateWay) {
		super();
		this.id = id;
		this.operatorType = operatorType;
		this.operatorName = operatorName;
		this.pgSize = pgSize;
		this.pgPrice = pgPrice;
		this.pgName = pgName;
		this.pgInService = pgInService;
		this.serviceType = serviceType;
		this.pgType = pgType;
		this.circulateWay = circulateWay;
		this.pgValidity = pgValidity;
	}
	
	public Integer getCirculateWay() {
		return circulateWay;
	}

	public void setCirculateWay(Integer circulateWay) {
		this.circulateWay = circulateWay;
	}
	public OperatorPgDataPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCdisId() {
		return cdisId;
	}

	public void setCdisId(Long cdisId) {
		this.cdisId = cdisId;
	}

	public Long getRteId() {
		return rteId;
	}

	public void setRteId(Long rteId) {
		this.rteId = rteId;
	}

	public Double getRteDis() {
		return rteDis;
	}

	public void setRteDis(Double rteDis) {
		this.rteDis = rteDis;
	}

	public String getCnelName() {
		return cnelName;
	}

	public void setCnelName(String cnelName) {
		this.cnelName = cnelName;
	}

	public Double getCdis() {
		return cdis;
	}

	public void setCdis(Double cdis) {
		this.cdis = cdis;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

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
//    public static void main(String[] args) {
//    	OperatorPgDataPo po = new OperatorPgDataPo();
//    	
//    	System.out.println(po);;
//	}

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