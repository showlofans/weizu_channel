package com.weizu.flowsys.web.channel.pojo;

import java.util.List;

/**
 * @description: 通道充值页面返回实体
 * @projectName:weizu-channel
 * @className:ChargeChannelPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年8月28日 下午3:35:00
 * @version 1.0
 */
public class ChargeChannelPo {
	private Long id;
	private String pgSize;					//包体大小
    private String channelName;
	private Integer epId;
	private String epName;					//平台名字
	private String specialTag;				//平台特殊
	private Double channelDiscount;			//通道折扣
	private Long cdId;						//通道折扣id
	private List<OperatorPgDataPo> list;	//包体列表
	
	public String getSpecialTag() {
		return specialTag;
	}
	public void setSpecialTag(String specialTag) {
		this.specialTag = specialTag;
	}
	public Long getCdId() {
		return cdId;
	}
	public void setCdId(Long cdId) {
		this.cdId = cdId;
	}
	public List<OperatorPgDataPo> getList() {
		return list;
	}
	public void setList(List<OperatorPgDataPo> list) {
		this.list = list;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPgSize() {
		return pgSize;
	}
	public void setPgSize(String pgSize) {
		this.pgSize = pgSize;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Integer getEpId() {
		return epId;
	}
	public void setEpId(Integer epId) {
		this.epId = epId;
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
