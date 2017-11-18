package com.weizu.flowsys.web.channel.pojo;

import java.util.List;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 话费通道实体
 * @projectName:weizu-channel
 * @className:TelChannelPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月11日 上午10:27:49
 * @version 1.0
 */
@TableName(name="telchannel")
public class TelChannelPo extends Po {
	
	private Long id;							//id
	
	private Double telchannelDiscount;			//通道价
	
	private Long telProductId;					//话费编码id
	
	private Integer billType;					//商务类型
	
	private Long lastAccess;					//更新时间
	
	private Integer telchannelTotalUse;			//通道使用量

    private Double telchannelTotalAmount;			//交易总金额

    private Double telchannelTotalProfit;			//总利润
	
    private Integer telchannelState;				//通道状态

    private Integer telchannelUseState;			//通道使用状态
    @TempField
    private String ids;							//页面实体：话费编码id列表
    @TempField
    private String discounts;					//页面实体：通道折扣列表
//    private List<Long> ids;						//页面实体：话费编码id列表

//	public List<Long> getIds() {
//		return ids;
//	}
//
//	public void setIds(List<Long> ids) {
//		this.ids = ids;
//	}

    
    
	public Long getId() {
		return id;
	}
	/** 批量添加构造函数
	 * @param telchannelDiscount
	 * @param telProductId
	 * @param billType
	 * @param lastAccess
	 * @param channelUseState
	 */
	public TelChannelPo(Double telchannelDiscount, Long telProductId,
		Integer billType, Long lastAccess, Integer telchannelUseState) {
	super();
	this.telchannelDiscount = telchannelDiscount;
	this.telProductId = telProductId;
	this.billType = billType;
	this.lastAccess = lastAccess;
	this.telchannelUseState = telchannelUseState;
}
	public TelChannelPo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}
	
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public String getDiscounts() {
		return discounts;
	}
	
	public void setDiscounts(String discounts) {
		this.discounts = discounts;
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
	public Integer getTelchannelTotalUse() {
		return telchannelTotalUse;
	}
	public void setTelchannelTotalUse(Integer telchannelTotalUse) {
		this.telchannelTotalUse = telchannelTotalUse;
	}
	public Double getTelchannelTotalAmount() {
		return telchannelTotalAmount;
	}
	public void setTelchannelTotalAmount(Double telchannelTotalAmount) {
		this.telchannelTotalAmount = telchannelTotalAmount;
	}
	public Double getTelchannelTotalProfit() {
		return telchannelTotalProfit;
	}
	public void setTelchannelTotalProfit(Double telchannelTotalProfit) {
		this.telchannelTotalProfit = telchannelTotalProfit;
	}
	public Integer getTelchannelState() {
		return telchannelState;
	}
	public void setTelchannelState(Integer telchannelState) {
		this.telchannelState = telchannelState;
	}
	public Integer getTelchannelUseState() {
		return telchannelUseState;
	}
	public void setTelchannelUseState(Integer telchannelUseState) {
		this.telchannelUseState = telchannelUseState;
	}
}
