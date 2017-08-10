package com.aiyi.base.pojo;

import org.weizu.web.foundation.core.beans.Po;

/**
 * @description:订单实体
 * @projectName:crud
 * @className:PurchasePo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月26日 下午5:59:42
 * @version 1.0
 */
public class PurchasePo extends Po {
	
    private Long orderId;						//订单号

    private Integer agencyId;					//代理id（外键）

    private String chargeTel;					//手机号

    private Integer pgId;						//流量包id（外键）

    private Long orderArriveTime;				//提交时间（本平台获得该数据请求的时间）

    private Long orderBackTime;					//充值时间（本平台获得返回结果，或者返回给下游平台结果的时间戳）

    private String chargeTelDetail;				//号码归属（：江西移动）

    private String chargeTelCity;				//号码归属具体城市

    private Integer orderPlatformPath;			//充值方式(0-接口，1-本平台)

    private Integer orderResult;				//结果（enum:）

    private Integer channelId;					//通道id（外键）

    private String orderResultDetail;			//结果描述

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

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getOrderResultDetail() {
        return orderResultDetail;
    }

    public void setOrderResultDetail(String orderResultDetail) {
        this.orderResultDetail = orderResultDetail == null ? null : orderResultDetail.trim();
    }
}
