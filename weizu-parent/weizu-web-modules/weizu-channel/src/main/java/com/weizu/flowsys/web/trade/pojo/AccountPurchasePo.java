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
@TableName(name="account_purchase")
public class AccountPurchasePo extends Po implements Cloneable{
    private Long id;

    private Integer accountId;

    private Long purchaseId;

    private Long rateDiscountId;

    private Double orderAmount;

//    private Integer billType;

    private Long recordId;
    
//    
    private Double orderPrice;		//	订单扣款
//    
    private String fromAgencyName;	//订单来源代理商名称
    
    private Integer orderPlatformPath;			//充值方式(0-网页，1-接口)
    
    private Integer orderState;		////订单返回结果
    
    private String orderStateDetail;	//订单返回结果详情
    
    private Integer fromAccountId;		//订单来源账户id
    
    private Double apDiscount;			//折扣
    
//    private Long orderBackTime;			//订单返回结果
//    @TempField
//    private String orderBackTimeStr;	//订单返回时间

	public AccountPurchasePo(
			Integer accountId, 
			Long purchaseId,
			Long rateDiscountId, Double orderAmount, 
//			Integer billType,
			Integer fromAccountId, 
			Long recordId,
			Double orderPrice, String fromAgencyName, Integer orderPlatformPath,Integer orderState) {
		super();
		this.accountId = accountId;
		this.purchaseId = purchaseId;
		this.rateDiscountId = rateDiscountId;
		this.orderAmount = orderAmount;
		this.fromAccountId = fromAccountId;
		this.recordId = recordId;
//		this.billType = billType;
		this.orderPrice = orderPrice;
		this.fromAgencyName = fromAgencyName;
		this.orderPlatformPath = orderPlatformPath;
		this.orderState = orderState;
	}
	
	

	@Override
	public AccountPurchasePo clone() {
		AccountPurchasePo pvo = null;
    	try{  
    		pvo = (AccountPurchasePo)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
		return pvo;
	}

	public Double getApDiscount() {
		return apDiscount;
	}

	public void setApDiscount(Double apDiscount) {
		this.apDiscount = apDiscount;
	}

	public Long getRecordId() {
		return recordId;
	}


	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}


	public Integer getFromAccountId() {
		return fromAccountId;
	}


	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
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

	public AccountPurchasePo() {
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

    public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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

//    public Integer getBillType() {
//        return billType;
//    }
//
//    public void setBillType(Integer billType) {
//        this.billType = billType;
//    }
}