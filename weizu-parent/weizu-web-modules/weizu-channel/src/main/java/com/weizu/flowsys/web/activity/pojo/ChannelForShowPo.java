package com.weizu.flowsys.web.activity.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 通道（费率）折扣展示实体
 * @projectName:weizu-channel
 * @className:ChannelForShowPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月30日 上午9:57:05
 * @version 1.0
 */
@TableName(name="channel_for_show")
public class ChannelForShowPo extends Po {
	
    private Long id;				//id

    private String scopeCityCode;		//包城市编码
    
    private Integer serviceType;		//业务类型（0-全国，1-省内，2-省漫游）
    
    private Integer operatorType;		//运营商类型（0-移动，1-联通，电信）
    
    private String productDesc;			//产品大小描述
    
    private Double billRate;			//带票折扣
    
    private Double privateRate;			//不带票折扣
    
    private Integer limitPrice;			//是否限价 limitPriceEnum
    
    private String bussinessMan;		//商务
    
    private Integer channelBill;		//拿货价格票务 billTypeEnum
    
    private Double channelPrice;		//拿货折扣
    
    private String channelCompany;		//拿货公司（渠道）
    
    private Integer showRateState;		//是否维护
    
    @TempField
    private String lastAccessStr;		//最后更新时间
    
    private Long lastAccess;			//最后更新时间
    @TempField
    private String billRateStr;			//带票折扣Str
    @TempField
    private String privateRateStr;		//不带票折扣Str
    @TempField
    private String channelPriceStr;		//拿货折扣Str
    
    
//    private String operatorName;		//运营商名称

//    private String scopeCityName;		//城市名
    
    
    public ChannelForShowPo() {
		super();
	}
    
    
    
    /** 通过通道信息得到展示通道添加
     * @param scopeCityCode
     * @param serviceType
     * @param operatorType
     * @param channelBill
     * @param channelPrice
     */
    public ChannelForShowPo(String scopeCityCode, Integer serviceType,
		Integer operatorType, Integer channelBill, Double channelPrice,String channelPriceStr) {
	super();
	this.scopeCityCode = scopeCityCode;
	this.serviceType = serviceType;
	this.operatorType = operatorType;
	this.channelBill = channelBill;
	this.channelPrice = channelPrice;
	this.channelPriceStr= channelPriceStr;
}



	/** 更新通道状态构造函数
     * @param id
     * @param showRateState
     */
    public ChannelForShowPo(Long id, Integer showRateState, Long lastAccess) {
    	super();
    	this.id = id;
    	this.showRateState = showRateState;
    	this.lastAccess = lastAccess;
    }
   


	public Integer getShowRateState() {
		return showRateState;
	}



	public void setShowRateState(Integer showRateState) {
		this.showRateState = showRateState;
	}

	public String getChannelPriceStr() {
		return channelPriceStr;
	}

	public void setChannelPriceStr(String channelPriceStr) {
		this.channelPriceStr = channelPriceStr;
	}

	public String getBillRateStr() {
		return billRateStr;
	}


	public void setBillRateStr(String billRateStr) {
		this.billRateStr = billRateStr;
	}


	public String getPrivateRateStr() {
		return privateRateStr;
	}


	public void setPrivateRateStr(String privateRateStr) {
		this.privateRateStr = privateRateStr;
	}


	public Long getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Long lastAccess) {
		this.lastAccess = lastAccess;
	}

	public String getLastAccessStr() {
		return lastAccessStr;
	}

	public void setLastAccessStr(String lastAccessStr) {
		this.lastAccessStr = lastAccessStr;
	}

	public String getScopeCityCode() {
        return scopeCityCode;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Double getBillRate() {
		return billRate;
	}

	public void setBillRate(Double billRate) {
		this.billRate = billRate;
	}

	public Double getPrivateRate() {
		return privateRate;
	}

	public void setPrivateRate(Double privateRate) {
		this.privateRate = privateRate;
	}

	public Integer getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(Integer limitPrice) {
		this.limitPrice = limitPrice;
	}

	public String getBussinessMan() {
		return bussinessMan;
	}

	public void setBussinessMan(String bussinessMan) {
		this.bussinessMan = bussinessMan;
	}

	public Integer getChannelBill() {
		return channelBill;
	}

	public void setChannelBill(Integer channelBill) {
		this.channelBill = channelBill;
	}

	public Double getChannelPrice() {
		return channelPrice;
	}

	public void setChannelPrice(Double channelPrice) {
		this.channelPrice = channelPrice;
	}

	public String getChannelCompany() {
		return channelCompany;
	}

	public void setChannelCompany(String channelCompany) {
		this.channelCompany = channelCompany;
	}

	public void setScopeCityCode(String scopeCityCode) {
        this.scopeCityCode = scopeCityCode == null ? null : scopeCityCode.trim();
    }
//
//    public String getScopeCityName() {
//        return scopeCityName;
//    }
//
//    public void setScopeCityName(String scopeCityName) {
//        this.scopeCityName = scopeCityName == null ? null : scopeCityName.trim();
//    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

//    public String getOperatorName() {
//        return operatorName;
//    }
//
//    public void setOperatorName(String operatorName) {
//        this.operatorName = operatorName == null ? null : operatorName.trim();
//    }

}