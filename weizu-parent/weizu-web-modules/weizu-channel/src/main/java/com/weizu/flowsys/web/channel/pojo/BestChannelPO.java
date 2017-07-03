package com.weizu.flowsys.web.channel.pojo;

import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:最优通道实体
 * @projectName:crud
 * @className:BestChannelPO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月18日 上午10:31:17
 * @version 1.0
 */
public class BestChannelPO extends Po {
	private Integer channeld;		//通道id
	
	private Integer epd;	//平台id
	
	private String epName; //平台名字
	
	private Double channelDiscount = 0.0d;
	
	private Integer billType;		//票务类型
	
	@TempField
	private String discount;

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Integer getChanneld() {
		return channeld;
	}

	public void setChanneld(Integer channeld) {
		this.channeld = channeld;
	}

	public Integer getEpd() {
		return epd;
	}

	public void setEpd(Integer epd) {
		this.epd = epd;
	}

	public String getEpName() {
		return epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public Double getChannelDiscount() {
		return channelDiscount;
	}

	public void setChannelDiscount(Double channelDiscount) {
		this.channelDiscount = channelDiscount;
	}

}
