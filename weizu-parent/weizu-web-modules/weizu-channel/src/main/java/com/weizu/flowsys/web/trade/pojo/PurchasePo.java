package com.weizu.flowsys.web.trade.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:订单实体
 * @projectName:crud
 * @className:PurchasePo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月26日 下午5:59:42
 * @version 1.0
 */
@TableName(name="purchase")
public class PurchasePo extends Po {
	
    private Long orderId;						//订单号
    
    private String orderIdApi;					//其他系统返回的订单id
    
    private String orderIdFrom;					//下级代理商传过来的订单号
    
    private Integer accountId;					//订单来源代理商账户id（外键）

    private String chargeTel;					//手机号

    private String pgId;						//流量包id（外键）

    private Long orderArriveTime;				//提交时间（本平台获得该数据请求的时间）
    
    private Long orderBackTime;					//充值时间（本平台获得返回结果，或者返回给下游平台结果的时间戳）

    private String chargeTelDetail;				//号码归属（：江西移动）

    private String chargeTelCity;				//号码归属具体城市
    
    private Integer orderResult;				//结果（超管enum:）(0-失败，1-成功，3-待充，4-为充)
    
    private Integer hasCallBack;				//是否已经接收到了回调(枚举：orderResultEnum)

//    private Long channelId;						//通道id（外键）
    private String channelName;					//通道名称

    private String orderResultDetail;			//结果描述(超管失败原因)
    
    private Double orderAmount;					//扣款:用与判断订单价格是否高于余额

    private Double pgPrice;					//扣款:用与判断订单价格是否高于余额
//    @TempField
//    private Long recordId;						//消费记录id-外键
    @TempField
    private Integer billType;					//票务类型
    
    private String agencyCallIp;				//代理商回调地址
    
    private Double chargeValue;					//订单原价

    public Double getChargeValue() {
    	return chargeValue;
    }
    
    public void setChargeValue(Double chargeValue) {
    	this.chargeValue = chargeValue;
    }
	
	public PurchasePo() {
		super();
	}
	
	
/**  根据页面订单参数初始化订单实体用
 * @param chargeTel
 * @param pgId
 * @param chargeTelDetail
 * @param orderAmount
 */
public PurchasePo(String chargeTel, String pgId,
			String chargeTelDetail) {
		super();
		this.chargeTel = chargeTel;
		this.pgId = pgId;
		this.chargeTelDetail = chargeTelDetail;
	}

public String getAgencyCallIp() {
	return agencyCallIp;
}


public void setAgencyCallIp(String agencyCallIp) {
	this.agencyCallIp = agencyCallIp;
}


public Double getPgPrice() {
	return pgPrice;
}


public void setPgPrice(Double pgPrice) {
	this.pgPrice = pgPrice;
}


/** 接口充值构造订单
 * @param orderId
 * @param orderIdFrom
 * @param agencyId
 * @param chargeTel
 * @param pgId
 * @param orderArriveTime
 * @param chargeTelDetail
 * @param chargeTelCity
 * @param orderResult
 * @param channelId
 * @param orderResultDetail
 * @param orderAmount
 * @param billType
 */
public PurchasePo(Long orderId, String orderIdFrom, 
		Integer accountId,
		String chargeTel, String pgId, Long orderArriveTime,
		String chargeTelDetail, String chargeTelCity, Integer orderResult,
		String channelName,
		String orderResultDetail, Double orderAmount,
		Integer billType) {
	super();
	this.orderId = orderId;
	this.orderIdFrom = orderIdFrom;
	this.accountId = accountId;
	this.chargeTel = chargeTel;
	this.pgId = pgId;
	this.orderArriveTime = orderArriveTime;
	this.chargeTelDetail = chargeTelDetail;
	this.chargeTelCity = chargeTelCity;
	this.orderResult = orderResult;
	this.channelName = channelName;
	this.orderResultDetail = orderResultDetail;
	this.orderAmount = orderAmount;
	this.billType = billType;
}


public PurchasePo(Long orderId, String orderIdApi, String orderIdFrom,
		Integer accountId, 
		String chargeTel, String pgId, Long orderArriveTime,
		Long orderBackTime, String chargeTelDetail, String chargeTelCity,
		String channelName,
		String orderResultDetail) {
	super();
	this.orderId = orderId;
	this.orderIdApi = orderIdApi;
	this.orderIdFrom = orderIdFrom;
	this.accountId = accountId;
	this.chargeTel = chargeTel;
	this.pgId = pgId;
	this.orderArriveTime = orderArriveTime;
	this.orderBackTime = orderBackTime;
	this.chargeTelDetail = chargeTelDetail;
	this.chargeTelCity = chargeTelCity;
	this.channelName = channelName;
	this.orderResultDetail = orderResultDetail;
}



	
/** 订单回调构造函数
 * @param orderId
 * @param orderIdApi
 * @param orderBackTime
 * @param orderResult
 * @param hasCallBack
 * @param orderResultDetail
 */
public PurchasePo(Long orderId, String orderIdApi, Long orderBackTime,
		Integer orderResult, Integer hasCallBack, String orderResultDetail) {
	super();
	this.orderId = orderId;
	this.orderIdApi = orderIdApi;
	this.orderBackTime = orderBackTime;
	this.orderResult = orderResult;
	this.hasCallBack = hasCallBack;
	this.orderResultDetail = orderResultDetail;
}
/** 订单回调构造函数api
 * @param orderId
 * @param orderIdApi
 * @param orderBackTime
 * @param orderResult
 * @param hasCallBack
 * @param orderResultDetail
 */
//public PurchasePo(Long orderId, String orderIdApi, Long orderBackTime,
//		Integer orderResult, String orderResultDetail) {
//	super();
//	this.orderId = orderId;
//	this.orderIdApi = orderIdApi;
//	this.orderBackTime = orderBackTime;
//	this.orderResult = orderResult;
//	this.orderResultDetail = orderResultDetail;
//}


public Integer getHasCallBack() {
	return hasCallBack;
}


public void setHasCallBack(Integer hasCallBack) {
	this.hasCallBack = hasCallBack;
}


	public String getOrderIdFrom() {
		return orderIdFrom;
	}

	public void setOrderIdFrom(String orderIdFrom) {
		this.orderIdFrom = orderIdFrom;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public String getOrderIdApi() {
		return orderIdApi;
	}

	public void setOrderIdApi(String orderIdApi) {
		this.orderIdApi = orderIdApi;
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

	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getChargeTel() {
        return chargeTel;
    }

    public void setChargeTel(String chargeTel) {
        this.chargeTel = chargeTel == null ? null : chargeTel.trim();
    }

    public String getPgId() {
        return pgId;
    }

    public void setPgId(String pgId) {
        this.pgId = pgId;
    }

    public Long getOrderArriveTime() {
        return orderArriveTime;
    }

    public void setOrderArriveTime(Long orderArriveTime) {
        this.orderArriveTime = orderArriveTime;
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

    public Integer getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(Integer orderResult) {
        this.orderResult = orderResult;
    }

	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getOrderResultDetail() {
        return orderResultDetail;
    }

    public void setOrderResultDetail(String orderResultDetail) {
        this.orderResultDetail = orderResultDetail == null ? null : orderResultDetail.trim();
    }
}
