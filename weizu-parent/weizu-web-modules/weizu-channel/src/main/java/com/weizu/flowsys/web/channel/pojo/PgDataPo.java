package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

@TableName(name="operator_pg_data")
public class PgDataPo extends Po {
	private Integer id;						//流量包id
    
    private Integer operatorType;		//运营商类型（0-移动，1-联通，电信）
    
    private String operatorName;		//运营商名称

    private Integer pgSize;				//流量包大小

    private Double pgPrice;				//流量包价格（原价）

    private String pgName;				//流量包业务名称（100元3072MB）

    private Integer pgInService;		//开通状态（0-开通，1-关闭）
   
    private Integer serviceType;		//业务类型（0-全国，1-省内，2-省漫游，//3-转赠,4-红包）
    
    private Integer pgType;				//流量类型（1-流量包，2-流量池）
    
    private Integer circulateWay;				//流通方式（1-普通通道包，2-红包通道，3-转移包，4-共享包）
    
    private String pgValidity;			//流量有效期(PgValidityEnum)
    
    private Integer pgServiceType;		//包体业务类型 (PgServiceTypeEnum)
    @TempField
    private Long channelId;				//通道id
    @TempField
    private String productCode;		//产品编码

	/** 验证包体是否存在的必须参数
	 * @param operatorType
	 * @param pgSize
	 * @param serviceType
	 * @param pgType
	 * @param pgValidity
	 */
	public PgDataPo(Integer operatorType, Integer pgSize, Integer serviceType,
			Integer pgType, String pgValidity,Integer circulateWay, Integer pgServiceType) {
		super();
		this.operatorType = operatorType;
		this.pgSize = pgSize;
		this.serviceType = serviceType;
		this.pgType = pgType;
		this.pgValidity = pgValidity;
		this.circulateWay = circulateWay;
		this.pgServiceType = pgServiceType;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getPgServiceType() {
		return pgServiceType;
	}

	public void setPgServiceType(Integer pgServiceType) {
		this.pgServiceType = pgServiceType;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public PgDataPo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getCirculateWay() {
		return circulateWay;
	}

	public void setCirculateWay(Integer circulateWay) {
		this.circulateWay = circulateWay;
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
		this.operatorName = operatorName;
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

	public Integer getPgInService() {
		return pgInService;
	}

	public void setPgInService(Integer pgInService) {
		this.pgInService = pgInService;
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
