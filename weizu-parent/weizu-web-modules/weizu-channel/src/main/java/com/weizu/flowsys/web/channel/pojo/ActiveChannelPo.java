package com.weizu.flowsys.web.channel.pojo;

import java.util.List;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.web.activity.pojo.ScopeDiscount;


/**
 * @description: 活动通道实体
 * @projectName:weizu-channel
 * @className:ActiveChannelPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月4日 下午3:22:51
 * @version 1.0
 */
@TableName(name="agency_activeChannel")
public class ActiveChannelPo extends Po implements Cloneable {
	
    private Integer id;					//通道id

    private String channelName;			//通道名称

    private Integer billType;				//票务类型：1-带票，0-不带票
    
    private Long activeTime;				//活动时间
    
    private Integer operatorType;			//运营商类型（0-移动，1-联通，2-电信）
    
    private String serviceId;			//范围id(外键)
    @TempField
    private Integer serviceType;			//业务类型（0-全国，1-省内，2-省漫游，3-转赠，4-红包,5-日包）
    
    private String pgSize;				//包体大小列表（通道规格）

    private Integer agencyId;			//通道所属代理商Id
    
    @TempField
    private String scopeCityName;			//包城市名
    
    
    private Double channelDiscount = 1.00d;	//折扣
    
    @TempField
    private List<ScopeDiscount> discountList;	//城市名+折扣

    private Integer epId;				//平台所属ID（外键）

    private Integer channelTotalUse = 0;	//通道交易总单数

    private Double channelTotalAmount = 0.0d;	//通道交易总额（在这条通道上的总交易额）

	private Double channelBalance = 0.0d;		//通道余额

    private Integer channelState;		//通道状态（0-运行 1-暂停）
    
    private Integer channelUseState = 0;		//通道使用状态（0-已使用 1-已暂停）
    
    
    @Override
	public ActiveChannelPo clone() {
    	ActiveChannelPo channelForwardPo = null; 
    	 try{  
    		 channelForwardPo = (ActiveChannelPo)super.clone();  
         }catch(CloneNotSupportedException e) {  
             e.printStackTrace();  
         }  
		return channelForwardPo;
	}

    
    /**
     * @description:通道使用数++
     * @author:POP产品研发部 宁强
     * @createTime:2017年6月13日 上午9:43:11
     */
    public void addTotalUse(){
    	this.channelTotalUse++;
    }
    /**
     * @description:余额减款
     * @param cutAmount
     * @author:POP产品研发部 宁强
     * @createTime:2017年6月13日 上午9:59:03
     */
    public void cutChannelBalance(double amount){
    	
    	this.channelBalance = NumberTool.sub(this.channelBalance, amount);
    }
    
    public void addTotalAmount(double amount){
    	this.channelTotalAmount = NumberTool.add(this.channelTotalAmount, amount);
    }
    
	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Integer getChannelUseState() {
		return channelUseState;
	}

	public void setChannelUseState(Integer channelUseState) {
		this.channelUseState = channelUseState;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}


	public List<ScopeDiscount> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<ScopeDiscount> discountList) {
		this.discountList = discountList;
	}

	public Double getChannelDiscount() {
		return channelDiscount;
	}

	public void setChannelDiscount(Double channelDiscount) {
		this.channelDiscount = channelDiscount;
	}
    
    public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public String getScopeCityName() {
		return scopeCityName;
	}

	public void setScopeCityName(String scopeCityName) {
		this.scopeCityName = scopeCityName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
