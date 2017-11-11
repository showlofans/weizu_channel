package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 话费通道实体
 * @projectName:weizu-channel
 * @className:TelChannelPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月11日 上午10:27:49
 * @version 1.0
 */
public class TelChannelPo extends Po {
	
	private Long id;							//id
	
	private Double telchannelDiscount;			//通道价
	
	private Long telProductId;					//话费编码id
	
	private Integer billType;					//商务类型
	
	private Long lastAccess;					//商务类型
	
	private Integer channelTotalUse;			//通道使用量

    private Double channelTotalAmount;			//交易总金额

    private Double channelTotalProfit;			//总利润
	
    private Integer channelState;				//通道状态

    private Integer channelUseState;			//通道使用状态

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTelchannelDiscount() {
		return telchannelDiscount;
	}

	public void setTelchannelDiscount(Double telchannelDiscount) {
		this.telchannelDiscount = telchannelDiscount;
	}

	public Long getTelProductId() {
		return telProductId;
	}

	public void setTelProductId(Long telProductId) {
		this.telProductId = telProductId;
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
}
