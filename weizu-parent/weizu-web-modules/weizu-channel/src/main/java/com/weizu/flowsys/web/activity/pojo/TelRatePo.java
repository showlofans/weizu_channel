package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 话费费率实体
 * @projectName:weizu-channel
 * @className:TelRatePo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月16日 下午2:58:06
 * @version 1.0
 */
@TableName(name="tel_rate")
public class TelRatePo extends Po {
	
	private Long id;
    
    private Double activeDiscount;			//折扣

    private Long activeId;					//父级折扣Id
    
    private Integer billType;				//是否带票（0-一般不带票，1-带票高级）
    
    private Long telchannelId;					//话费通道id
    
    private Integer rateFor;				//平台用户0，接口用户1 TelChannelTagEnum
    
    private Integer rateType;				//费率属性：PgServiceTypeEnum
    
    private Integer rateForPlatform;			//CallBackEnum 是否配置了平台折扣标志 1-平台级折扣
    
    private Integer createAgency;			//折扣创建者
//    @TempField
//    private TelRatePo childTelRatePo;		//子代理商折扣实体
    
	/** 话费折扣列表查询参数
	 * @param billType
	 * @param telchannelId
	 * @param rateFor
	 */
	public TelRatePo(Integer billType, Long telchannelId, Integer rateFor) {
		super();
		this.billType = billType;
		this.telchannelId = telchannelId;
		this.rateFor = rateFor;
	}
	
	public Integer getRateForPlatform() {
		return rateForPlatform;
	}

	public void setRateForPlatform(Integer rateForPlatform) {
		this.rateForPlatform = rateForPlatform;
	}

	public Integer getCreateAgency() {
		return createAgency;
	}



	public void setCreateAgency(Integer createAgency) {
		this.createAgency = createAgency;
	}



	public TelRatePo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public TelRatePo getChildTelRatePo() {
//		return childTelRatePo;
//	}
//
//	public void setChildTelRatePo(TelRatePo childTelRatePo) {
//		this.childTelRatePo = childTelRatePo;
//	}

	public Integer getRateType() {
		return rateType;
	}

	public void setRateType(Integer rateType) {
		this.rateType = rateType;
	}

	public Integer getRateFor() {
		return rateFor;
	}

	public void setRateFor(Integer rateFor) {
		this.rateFor = rateFor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getActiveDiscount() {
		return activeDiscount;
	}

	public void setActiveDiscount(Double activeDiscount) {
		this.activeDiscount = activeDiscount;
	}

	public Long getActiveId() {
		return activeId;
	}

	public void setActiveId(Long activeId) {
		this.activeId = activeId;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Long getTelchannelId() {
		return telchannelId;
	}

	public void setTelchannelId(Long telchannelId) {
		this.telchannelId = telchannelId;
	}
}
