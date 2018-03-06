package com.weizu.flowsys.web.trade.pojo;

import java.io.Serializable;

import com.weizu.flowsys.web.channel.pojo.ExchangePlatformPo;

/**
 * @description: 订单页面展示
 * @projectName:crud
 * @className:PurchaseVO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月13日 下午12:16:36
 * @version 1.0
 */
public class PurchaseVO implements Cloneable,Serializable {
	
    private Long orderId;						//订单号
    
    private String orderIdApi;					//其他系统返回的订单id
    
    private String orderIdFrom;					//下级代理商传过来的订单号

    private String agencyName;					//代理商名称

    private String chargeTel;					//手机号

    private Integer pgSize;						//包体大小
    
    private String pgSizeStr;						//包体大小
    
    private Double chargeValue;						//包体原价
    
    private Integer operatorType;				//运营商名称
    
    private Integer operatorName;				//运营商
    
    private Integer serviceType;				//业务范围
    
    private Integer purchaseFor;				//业务类型：pgServiceTypeEnum

    private Long orderArriveTime;				//提交时间（本平台获得该数据请求的时间）
    
    private String orderArriveTimeStr;  		// 提交时间字符串
    
    
    private String arriveEndTimeStr;			//提交开始时间字符串
    
    private String arriveStartTimeStr;			//提交结束时间字符串
    
    private String backEndTimeStr;			//充值开始时间字符串
    
    private String backStartTimeStr;			//充值结束时间字符串
    
    private Integer accountId;				//当前登陆id（外键）：数据库返回参数
    
    private Integer fromAccountId;				//来源账户id
    
    private Integer agencyId;					//登陆代理商id（数据库查询参数）

    private Long orderBackTime;					//充值时间（本平台获得返回结果，或者返回给下游平台结果的时间戳）
    
    private String orderBackTimeStr;			//充值时间字符串

    private String chargeTelDetail;				//号码归属（：江西移动）

    private String chargeTelCity;				//号码归属具体城市

    private Integer orderPlatformPath;			//充值方式(0-接口，1-本平台)
    
    private String channelName;					//通道名称
    
//    private Long channelId;					//通道ID
    
    private Integer orderResult;				//结果（管理员enum:）

    private String orderResultDetail;			//结果描述:管理员
    
    private Double orderAmount;					//成本
    
    private Double orderPrice;					//下级代理商扣款
    
    private Integer orderState;					//结果（enum:）
    
    private String orderStateDetail;			//结果描述
    
//    private ExchangePlatformPo ep;				//平台信息
    
    private Integer billType;					//账户类型（搜索和展示参数）
    
    private Long channelDiscountId;						//通道折扣id
    
    private Double apDiscount;					//实际折扣
    
    private String agencyCallIp;				//代理商回调地址
    
    private Integer chargeSpeed;				//充值速度
    
    private Integer hasCallBack;				//是否已经接收到了回调(枚举：orderResultEnum)
    
    private Integer epId;						//订单流向平台id
    
    private Long secondOrderId;					//第二次订单号
    
    @Override
	public PurchaseVO clone() {
    	PurchaseVO pvo = null;
    	try{  
    		pvo = (PurchaseVO)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
		return pvo;
	}
    
	public String getPgSizeStr() {
		return pgSizeStr;
	}

	public void setPgSizeStr(String pgSizeStr) {
		this.pgSizeStr = pgSizeStr;
	}

	public Integer getEpId() {
		return epId;
	}
	
	public void setEpId(Integer epId) {
		this.epId = epId;
	}
	

	public Long getSecondOrderId() {
		return secondOrderId;
	}

	public void setSecondOrderId(Long secondOrderId) {
		this.secondOrderId = secondOrderId;
	}

	public Integer getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Integer getHasCallBack() {
		return hasCallBack;
	}

	public void setHasCallBack(Integer hasCallBack) {
		this.hasCallBack = hasCallBack;
	}

	public Integer getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(Integer operatorName) {
		this.operatorName = operatorName;
	}



	public Integer getChargeSpeed() {
		return chargeSpeed;
	}

	public void setChargeSpeed(Integer chargeSpeed) {
		this.chargeSpeed = chargeSpeed;
	}
	
//	public Integer getPgServiceType() {
//		return pgServiceType;
//	}
//
//	public void setPgServiceType(Integer pgServiceType) {
//		this.pgServiceType = pgServiceType;
//	}

	public String getAgencyCallIp() {
		return agencyCallIp;
	}

	public Integer getPurchaseFor() {
		return purchaseFor;
	}


	public void setPurchaseFor(Integer purchaseFor) {
		this.purchaseFor = purchaseFor;
	}


	public void setAgencyCallIp(String agencyCallIp) {
		this.agencyCallIp = agencyCallIp;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Double getApDiscount() {
		return apDiscount;
	}

	public void setApDiscount(Double apDiscount) {
		this.apDiscount = apDiscount;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public Long getChannelDiscountId() {
		return channelDiscountId;
	}

	public void setChannelDiscountId(Long channelDiscountId) {
		this.channelDiscountId = channelDiscountId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

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

	public String getBackEndTimeStr() {
		return backEndTimeStr;
	}

	public void setBackEndTimeStr(String backEndTimeStr) {
		this.backEndTimeStr = backEndTimeStr;
	}

	public String getBackStartTimeStr() {
		return backStartTimeStr;
	}

	public void setBackStartTimeStr(String backStartTimeStr) {
		this.backStartTimeStr = backStartTimeStr;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public String getOrderIdFrom() {
		return orderIdFrom;
	}

	public void setOrderIdFrom(String orderIdFrom) {
		this.orderIdFrom = orderIdFrom;
	}

//	public ExchangePlatformPo getEp() {
//		return ep;
//	}
//
//	public void setEp(ExchangePlatformPo ep) {
//		this.ep = ep;
//	}

	public String getOrderIdApi() {
		return orderIdApi;
	}

	public void setOrderIdApi(String orderIdApi) {
		this.orderIdApi = orderIdApi;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getPgSize() {
		return pgSize;
	}

	public void setPgSize(Integer pgSize) {
		this.pgSize = pgSize;
	}

	public Double getChargeValue() {
		return chargeValue;
	}

	public void setChargeValue(Double chargeValue) {
		this.chargeValue = chargeValue;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getOrderBackTimeStr() {
		return orderBackTimeStr;
	}

	public void setOrderBackTimeStr(String orderBackTimeStr) {
		this.orderBackTimeStr = orderBackTimeStr;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getChargeTel() {
        return chargeTel;
    }

    public void setChargeTel(String chargeTel) {
        this.chargeTel = chargeTel == null ? null : chargeTel.trim();
    }

    public Long getOrderArriveTime() {
        return orderArriveTime;
    }

    public void setOrderArriveTime(Long orderArriveTime) {
        this.orderArriveTime = orderArriveTime;
    }

    public String getArriveEndTimeStr() {
		return arriveEndTimeStr;
	}
    
	public String getOrderArriveTimeStr() {
		return orderArriveTimeStr;
	}

	public void setOrderArriveTimeStr(String orderArriveTimeStr) {
		this.orderArriveTimeStr = orderArriveTimeStr;
	}

	public void setArriveEndTimeStr(String arriveEndTimeStr) {
		this.arriveEndTimeStr = arriveEndTimeStr;
//		if(StringHelper.isNotEmpty(arriveEndTimeStr)){
//			this.orderArriveTime = DateUtil.strToDate(arriveStartTimeStr, null).getTime();
//		}
	}

	public String getArriveStartTimeStr() {
		return arriveStartTimeStr;
	}

	public void setArriveStartTimeStr(String arriveStartTimeStr) {
		this.arriveStartTimeStr = arriveStartTimeStr;//不为空
//		if(StringHelper.isNotEmpty(arriveStartTimeStr)){
//			this.orderArriveTime = DateUtil.strToDate(arriveStartTimeStr, null).getTime();
//		}
	}

	public Long getOrderBackTime() {
        return orderBackTime;
    }

    public void setOrderBackTime(Long orderBackTime) {
        this.orderBackTime = orderBackTime;
    }

    public String getChargeTelDetail() {
        return chargeTelDetail;
    }

    public void setChargeTelDetail(String chargeTelDetail) {
        this.chargeTelDetail = chargeTelDetail == null ? null : chargeTelDetail.trim();
    }

    public String getChargeTelCity() {
        return chargeTelCity;
    }

    public void setChargeTelCity(String chargeTelCity) {
        this.chargeTelCity = chargeTelCity == null ? null : chargeTelCity.trim();
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

    public String getOrderResultDetail() {
        return orderResultDetail;
    }

    public void setOrderResultDetail(String orderResultDetail) {
        this.orderResultDetail = orderResultDetail == null ? null : orderResultDetail.trim();
    }
}
