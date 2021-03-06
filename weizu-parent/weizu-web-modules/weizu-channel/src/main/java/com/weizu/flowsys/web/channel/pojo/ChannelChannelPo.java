package com.weizu.flowsys.web.channel.pojo;

import java.util.List;
import java.util.Map;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;
import com.weizu.flowsys.web.activity.pojo.DiscountPo;

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
		
	private Integer belongAgencyId;						//通道所属代理商id（数据库字段）

    private String channelName;

    private String specialTag;
    @TempField
    private String pgSize;								//pgSizeStr:页面参数

    private Integer epId;

    private Integer channelTotalUse;

    private Double channelTotalAmount;

    private Double channelTotalProfit;

    private Double channelBalance;

    private Integer channelState;

    private Integer channelUseState;
    @TempField
    private Integer channelType;						//通道类型（页面参数：1-普通通道包，2-红包通道，3-转移包，4-共享包）
    
    private Long lastAccess;
    @TempField
    private String lastAccessStr;						//最后更新时间
    
    @TempField
    private String epName;								//平台名字
    
    @TempField
    private Integer billType;
    
    @TempField
    private Integer operatorType;								//运营商类型（查询参数）
    @TempField
    private Integer serviceType;								//流量类型（查询参数）
    @TempField
    private Integer pgType;				//流量类型（1-流量包，2-流量池）
    @TempField
    private String pgValidity;			//流量有效期(PgValidityEnum)
    
    @TempField
    private List<ChannelDiscountPo> discountList;				//通道折扣（添加和页面参数）
   
    @TempField
    private List<PgDataPo> pgList;				//包体列表（页面参数）
    
    @TempField
    private Map<String,Object> scopeCityCodes;				//查询参数
   
    /*@TempField
    private String discount0;					//移动折扣（页面参数）
    @TempField
    private String discount1;					//联通折扣（页面参数）
    @TempField
    private String discount2;					//电信折扣（页面参数）
*/    
    @TempField
    private DiscountPo discountPo;				//折扣实体（包括移动,联通,电信）
    
    @TempField
    private String scopeCityName;				//省份名称（查询参数）
    @TempField
    private String scopeCityCode;				//省份编码（查询参数）
    
    public String getLastAccessStr() {
		return lastAccessStr;
	}

	public void setLastAccessStr(String lastAccessStr) {
		this.lastAccessStr = lastAccessStr;
	}

	public String getPgSize() {
		return pgSize;
	}

	public void setPgSize(String pgSize) {
		this.pgSize = pgSize;
	}

	public Integer getChannelType() {
		return channelType;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	public List<PgDataPo> getPgList() {
		return pgList;
	}

	public void setPgList(List<PgDataPo> pgList) {
		this.pgList = pgList;
	}

	public Integer getPgType() {
		return pgType;
	}

	public void setPgType(Integer pgType) {
		this.pgType = pgType;
	}

	public String getPgValidity() {
		return pgValidity;
	}

	public void setPgValidity(String pgValidity) {
		this.pgValidity = pgValidity;
	}

	public String getEpName() {
		return epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Map<String, Object> getScopeCityCodes() {
		return scopeCityCodes;
	}

	public void setScopeCityCodes(Map<String, Object> scopeCityCodes) {
		this.scopeCityCodes = scopeCityCodes;
	}

	public String getScopeCityCode() {
		return scopeCityCode;
	}

	public void setScopeCityCode(String scopeCityCode) {
		this.scopeCityCode = scopeCityCode;
	}

	public String getScopeCityName() {
		return scopeCityName;
	}

	public void setScopeCityName(String scopeCityName) {
		this.scopeCityName = scopeCityName;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public DiscountPo getDiscountPo() {
		return discountPo;
	}

	public void setDiscountPo(DiscountPo discountPo) {
		this.discountPo = discountPo;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getBelongAgencyId() {
		return belongAgencyId;
	}

	public void setBelongAgencyId(Integer belongAgencyId) {
		this.belongAgencyId = belongAgencyId;
	}

	public List<ChannelDiscountPo> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<ChannelDiscountPo> discountList) {
		this.discountList = discountList;
	}

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

    public String getSpecialTag() {
		return specialTag;
	}

	public void setSpecialTag(String specialTag) {
		this.specialTag = specialTag;
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

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }
}