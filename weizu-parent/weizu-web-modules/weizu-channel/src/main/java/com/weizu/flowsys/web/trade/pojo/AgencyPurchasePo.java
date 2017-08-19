package com.weizu.flowsys.web.trade.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
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

//    private Long recordId;
    
//    
    private Double orderPrice;		//	订单扣款
//    
    private String fromAgencyName;	//订单来源代理商名称
    
    private Integer orderPlatformPath;			//充值方式(0-网页，1-接口)
    
    private Integer orderState;		////订单返回结果
    
    private String orderStateDetail;	//订单返回结果详情
    
//    private Long orderBackTime;			//订单返回结果
//    @TempField
//    private String orderBackTimeStr;	//订单返回时间

	public AgencyPurchasePo(Integer agencyId, Long purchaseId,
			Long rateDiscountId, Double orderAmount, Integer billType,
			Double orderPrice, String fromAgencyName, Integer orderPlatformPath,Integer orderState) {
		super();
		this.agencyId = agencyId;
		this.purchaseId = purchaseId;
		this.rateDiscountId = rateDiscountId;
		this.orderAmount = orderAmount;
		this.billType = billType;
		this.orderPrice = orderPrice;
		this.fromAgencyName = fromAgencyName;
		this.orderPlatformPath = orderPlatformPath;
		this.orderState = orderState;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getFromAgencyName() {
		return fromAgencyName;
	}

	public void setFromAgencyName(String fromAgencyName) {
		this.fromAgencyName = fromAgencyName;
	}
	
	

//	public String getOrderBackTimeStr() {
//		return orderBackTimeStr;
//	}
//
//	public void setOrderBackTimeStr(String orderBackTimeStr) {
//		this.orderBackTimeStr = orderBackTimeStr;
//	}
//
//
//
//	public Long getOrderBackTime() {
//		return orderBackTime;
//	}
//
//	public void setOrderBackTime(Long orderBackTime) {
//		this.orderBackTime = orderBackTime;
//	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public String getOrderStateDetail() {
		return orderStateDetail;
	}

	public void setOrderStateDetail(String orderStateDetail) {
		this.orderStateDetail = orderStateDetail;
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
}