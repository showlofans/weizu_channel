package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 通道实体
 * @projectName:weizu-channel
 * @className:ChannelChannelPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月4日 下午5:45:35
 * @version 1.0
 */
@TableName(name="channel_channel")
public class ChannelChannelPo extends Po {
    
	private Long id;

    private String channelName;

    private String pgSize;

    private Integer epId;

    private Integer channelTotalUse;

    private Double channelTotalAmount;

    private Double channelTotalProfit;

    private Double channelBalance;

    private Integer channelState;

    private Integer channelUseState;

    private Integer billType;

    private Long lastAccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getPgSize() {
        return pgSize;
    }

    public void setPgSize(String pgSize) {
        this.pgSize = pgSize == null ? null : pgSize.trim();
    }

    public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    public Integer getChannelTotalUse() {
        return channelTotalUse;
    }

    public void setChannelTotalUse(Integer channelTotalUse) {
        this.channelTotalUse = channelTotalUse;
    }

    public Double getChannelTotalAmount() {
        return channelTotalAmount;
    }

    public void setChannelTotalAmount(Double channelTotalAmount) {
        this.channelTotalAmount = channelTotalAmount;
    }

    public Double getChannelTotalProfit() {
        return channelTotalProfit;
    }

    public void setChannelTotalProfit(Double channelTotalProfit) {
        this.channelTotalProfit = channelTotalProfit;
    }

    public Double getChannelBalance() {
        return channelBalance;
    }

    public void setChannelBalance(Double channelBalance) {
        this.channelBalance = channelBalance;
    }

    public Integer getChannelState() {
        return channelState;
    }

    public void setChannelState(Integer channelState) {
        this.channelState = channelState;
    }

    public Integer getChannelUseState() {
        return channelUseState;
    }

    public void setChannelUseState(Integer channelUseState) {
        this.channelUseState = channelUseState;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }
}