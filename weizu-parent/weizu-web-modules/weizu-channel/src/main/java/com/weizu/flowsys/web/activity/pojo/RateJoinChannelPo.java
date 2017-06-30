package com.weizu.flowsys.web.activity.pojo;

/**
 * @description: 给代理商配置费率实体
 * @projectName:weizu-channel
 * @className:RateJoinChannelPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月30日 上午11:38:03
 * @version 1.0
 */
public class RateJoinChannelPo {
	
    private Long id;					//配置id
    
    private Long rateId;				//费率id

    private Integer channelId;			//通道id

    private Long joinTime;				//配置时间

    private Integer billType;			//票务类型

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }
}