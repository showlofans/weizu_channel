package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

@TableName(name="operator_pg_data")
public class PgDataPo extends Po {
private Integer id;				//流量包id
    
    private Integer operatorType;		//运营商类型（0-移动，1-联通，电信）
    
    private String operatorName;		//运营商名称

    private Integer pgSize;				//流量包大小

    private Double pgPrice;				//流量包价格（原价）

    private String pgName;				//流量包业务名称（100元3072MB）

    private Integer pgInService;		//开通状态（0-开通，1-关闭）
   
    private Integer serviceType;			//业务类型（0-全国，1-省内，2-省漫游，3-转赠,4-红包）

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
}
