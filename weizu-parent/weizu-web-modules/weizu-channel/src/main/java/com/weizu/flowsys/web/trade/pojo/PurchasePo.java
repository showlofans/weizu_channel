package com.weizu.flowsys.web.trade.pojo;

import com.weizu.web.foundation.core.annotation.po.TableName;
import com.weizu.web.foundation.core.annotation.po.TempField;
import com.weizu.web.foundation.core.beans.Po;

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
    
    private Integer agencyId;					//代理id（外键）

    private String chargeTel;					//手机号

    private Integer pgId;						//流量包id（外键）

    private Long orderArriveTime;				//提交时间（本平台获得该数据请求的时间）
    @TempField
    private Long orderBackTime;					//充值时间（本平台获得返回结果，或者返回给下游平台结果的时间戳）

    private String chargeTelDetail;				//号码归属（：江西移动）

    private String chargeTelCity;				//号码归属具体城市
    @TempField
    private Integer orderResult;				//结果（enum:）(0-失败，1-成功，3-待充，4-为充)

    private Long channelId;					//通道id（外键）
    @TempField
    private String orderResultDetail;			//结果描述(失败原因)
    @TempField
    private Double orderAmount;					//扣款:用与判断订单价格是否高于余额
    @TempField
    private Long recordId;						//消费记录id-外键
    @TempField
    private Integer billType;					//票务类型
	
	public PurchasePo() {
		super();
	}
	
	
/**  根据页面订单参数初始化订单实体用
 * @param chargeTel
 * @param pgId
 * @param chargeTelDetail
 * @param orderAmount
 */
public PurchasePo(String chargeTel, Integer pgId,
			String chargeTelDetail) {
		super();
		this.chargeTel = chargeTel;
		this.pgId = pgId;
		this.chargeTelDetail = chargeTelDetail;
	}





public PurchasePo(Long orderId, String orderIdApi, String orderIdFrom,
		Integer agencyId, String chargeTel, Integer pgId, Long orderArriveTime,
		Long orderBackTime, String chargeTelDetail, String chargeTelCity,
		Long channelId, String orderResultDetail) {
	super();
	this.orderId = orderId;
	this.orderIdApi = orderIdApi;
	this.orderIdFrom = orderIdFrom;
	this.agencyId = agencyId;
	this.chargeTel = chargeTel;
	this.pgId = pgId;
	this.orderArriveTime = orderArriveTime;
	this.orderBackTime = orderBackTime;
	this.chargeTelDetail = chargeTelDetail;
	this.chargeTelCity = chargeTelCity;
	this.channelId = channelId;
	this.orderResultDetail = orderResultDetail;
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

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
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

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getChargeTel() {
        return chargeTel;
    }

    public void setChargeTel(String chargeTel) {
        this.chargeTel = chargeTel == null ? null : chargeTel.trim();
    }

    public Integer getPgId() {
        return pgId;
    }

    public void setPgId(Integer pgId) {
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

    public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

    public Long getChannelId() {
		return channelId;
	}

	public String getOrderResultDetail() {
        return orderResultDetail;
    }

    public void setOrderResultDetail(String orderResultDetail) {
        this.orderResultDetail = orderResultDetail == null ? null : orderResultDetail.trim();
    }
}
