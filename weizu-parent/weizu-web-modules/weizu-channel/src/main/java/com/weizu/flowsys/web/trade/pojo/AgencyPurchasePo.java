package com.weizu.flowsys.web.trade.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 代理商订单绑定实体
 * @projectName:weizu-channel
 * @className:AgencyPurchasePo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年8月2日 下午5:24:58
 * @version 1.0
 */
@TableName(name="agency_purchase")
public class AgencyPurchasePo extends Po{
    private Long id;

    private Integer agencyId;

    private Long purchaseId;

    private Long rateDiscountId;

    private Double orderAmount;

    private Integer billType;

    private Long recordId;
    
    private Integer orderResult;		//	订单状态
    
    private Integer orderPlatformPath;			//充值方式(0-网页，1-接口)

	public AgencyPurchasePo(Integer agencyId, Long purchaseId,
			Long rateDiscountId, Double orderAmount, Integer billType,
			Long recordId, Integer orderResult, Integer orderPlatformPath) {
		super();
		this.agencyId = agencyId;
		this.purchaseId = purchaseId;
		this.rateDiscountId = rateDiscountId;
		this.orderAmount = orderAmount;
		this.billType = billType;
		this.recordId = recordId;
		this.orderResult = orderResult;
		this.orderPlatformPath = orderPlatformPath;
	}

	public AgencyPurchasePo() {
		super();
	}

	public Integer getOrderPlatformPath() {
		return orderPlatformPath;
	}


	public void setOrderPlatformPath(Integer orderPlatformPath) {
		this.orderPlatformPath = orderPlatformPath;
	}


	public Integer getOrderResult() {
		return orderResult;
	}

	public void setOrderResult(Integer orderResult) {
		this.orderResult = orderResult;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getRateDiscountId() {
        return rateDiscountId;
    }

    public void setRateDiscountId(Long rateDiscountId) {
        this.rateDiscountId = rateDiscountId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
}