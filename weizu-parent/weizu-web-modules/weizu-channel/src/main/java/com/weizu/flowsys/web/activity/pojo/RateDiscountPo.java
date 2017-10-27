package com.weizu.flowsys.web.activity.pojo;

import java.util.List;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 费率折扣
 * @projectName:weizu-channel
 * @className:RateDiscountPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月6日 下午6:12:52
 * @version 1.0
 */
@TableName(name="rate_discount")
public class RateDiscountPo extends Po {
    private Long id;
    
    private Double activeDiscount;

    private Long activeId;					//父级折扣Id
    
    private Long channelDiscountId;
    @TempField
    private String specialTag;				//通道特殊类型
    
    private Integer billType;				//是否带票（0-一般不带票，1-带票高级）
    
    @TempField
    private Integer operatorType;			//运营商类型
    @TempField
    private Integer serviceType;			//流量类型
    @TempField
    private String scopeCityCode;			//地区编码
    @TempField
    private DiscountPo discountPo;			//折扣
    
    private Long channelId;					//通道id
    @TempField
    private Integer accountId;				//子代理商账户id
    @TempField
    private Integer agencyId;				//子代理商账户id
    @TempField
    private String scopeCityName;
    @TempField
    private String billTypeDesc;			//费率描述
//    @TempField
//    private List<RateDiscountPo> discountList;			//活动折扣列表
    @TempField
    private RateDiscountPo childRatePo;			//子费率活动折扣
    
    public RateDiscountPo() {
		super();
	}
    
    
    
//	public List<RateDiscountPo> getDiscountList() {
//		return discountList;
//	}
//
//	public void setDiscountList(List<RateDiscountPo> discountList) {
//		this.discountList = discountList;
//	}
    
	public Integer getAgencyId() {
		return agencyId;
	}

	public String getSpecialTag() {
		return specialTag;
	}

	public void setSpecialTag(String specialTag) {
		this.specialTag = specialTag;
	}



	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public RateDiscountPo getChildRatePo() {
		return childRatePo;
	}

	public void setChildRatePo(RateDiscountPo childRatePo) {
		this.childRatePo = childRatePo;
	}

	public RateDiscountPo(Double activeDiscount, Long activeId,
			Long channelDiscountId, Integer billType) {
		super();
		this.activeDiscount = activeDiscount;
		this.activeId = activeId;
		this.channelDiscountId = channelDiscountId;
		this.billType = billType;
	}
	
	public String getBillTypeDesc() {
		return billTypeDesc;
	}

	public void setBillTypeDesc(String billTypeDesc) {
		this.billTypeDesc = billTypeDesc;
	}

	public DiscountPo getDiscountPo() {
		return discountPo;
	}

	public void setDiscountPo(DiscountPo discountPo) {
		this.discountPo = discountPo;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
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

	public String getScopeCityCode() {
		return scopeCityCode;
	}

	public void setScopeCityCode(String scopeCityCode) {
		this.scopeCityCode = scopeCityCode;
	}

	public Long getChannelDiscountId() {
		return channelDiscountId;
	}

	public void setChannelDiscountId(Long channelDiscountId) {
		this.channelDiscountId = channelDiscountId;
	}

	public String getScopeCityName() {
		return scopeCityName;
	}

	public void setScopeCityName(String scopeCityName) {
		this.scopeCityName = scopeCityName;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getActiveDiscount() {
        return activeDiscount;
    }

    public void setActiveDiscount(Double activeDiscount) {
        this.activeDiscount = activeDiscount;
    }

	public Long getActiveId() {
		return activeId;
	}

	public void setActiveId(Long activeId) {
		this.activeId = activeId;
	}
}