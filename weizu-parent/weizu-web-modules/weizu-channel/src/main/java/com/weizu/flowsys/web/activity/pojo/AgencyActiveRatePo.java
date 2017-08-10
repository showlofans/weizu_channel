package com.weizu.flowsys.web.activity.pojo;

import java.util.List;

import org.weizu.web.foundation.core.annotation.po.TableName;
import org.weizu.web.foundation.core.annotation.po.TempField;
import org.weizu.web.foundation.core.beans.Po;

/**
 * @description: 通道连接代理商实体
 * @projectName:weizu-channel
 * @className:AgencyActiveChannelPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月5日 下午5:53:47
 * @version 1.0
 */
@TableName(name="agency_active_rate")
public class AgencyActiveRatePo extends Po {
	
    private Long id;

    private Integer agencyId;					//子代理商id

    private String agencyName;

    private Long rateDiscountId;

    private Long activeTime;
    
    private Integer bindState;					//绑定状态：0-已绑定，1-已解绑，2-未绑定
    
    private Integer bindAgencyId;				//绑定人 
    
    @TempField
    private String channelName;				//页面参数
    
    @TempField
    private String activeTimeStr;				//（页面参数）
    
    @TempField
    private Double channelDiscount;				//通道折扣（active_discount）
    
    @TempField
    private DiscountPo discountPo;				//页面折扣实体（移动，联通，电信）
    
    @TempField//插入的时候不添加进去
    private List<RateDiscountPo> rateList0;		//批量添加折扣的数据（移动）
    
    @TempField//插入的时候不添加进去
    private List<RateDiscountPo> rateList1;		//批量添加折扣的数据（联通）
    
    @TempField//插入的时候不添加进去
    private List<RateDiscountPo> rateList2;		//批量添加折扣的数据（电信）
    
    @TempField
    private List<RateDiscountPo> rateList;		//数据库查询返回的参数(通道包涵的所有折扣)-页面参数
    
//    @TempField
//    private RateDiscountPo rateDiscountPo;		//新增一个地区的折扣-页面参数
    
    @TempField
    private Integer operatorType;				//运营商类型（页面参数）
    
    @TempField
    private Integer serviceType;				//业务类型
    
    @TempField
    private String ScopeCityCode;
    
    @TempField
    private Integer billTypeRate;				//费率折扣类型
    @TempField
    private Integer billTypeChannel;				//通道折扣类型
    
//    @TempField
//    private Long rateId;						//查询参数：费率折扣id
    
//	public RateDiscountPo getRateDiscountPo() {
//		return rateDiscountPo;
//	}
//
//	public void setRateDiscountPo(RateDiscountPo rateDiscountPo) {
//		this.rateDiscountPo = rateDiscountPo;
//	}
    
	public List<RateDiscountPo> getRateList() {
		return rateList;
	}

	public Integer getBillTypeChannel() {
		return billTypeChannel;
	}

	public void setBillTypeChannel(Integer billTypeChannel) {
		this.billTypeChannel = billTypeChannel;
	}

	public Integer getBillTypeRate() {
		return billTypeRate;
	}

	public void setBillTypeRate(Integer billTypeRate) {
		this.billTypeRate = billTypeRate;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	/*public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}*/

	public String getScopeCityCode() {
		return ScopeCityCode;
	}

	public void setScopeCityCode(String scopeCityCode) {
		ScopeCityCode = scopeCityCode;
	}

	public Double getChannelDiscount() {
		return channelDiscount;
	}

	public void setChannelDiscount(Double channelDiscount) {
		this.channelDiscount = channelDiscount;
	}

	public Integer getBindState() {
		return bindState;
	}

	public void setBindState(Integer bindState) {
		this.bindState = bindState;
	}

	public Integer getBindAgencyId() {
		return bindAgencyId;
	}

	public void setBindAgencyId(Integer bindAgencyId) {
		this.bindAgencyId = bindAgencyId;
	}

	public void setRateList(List<RateDiscountPo> rateList) {
		this.rateList = rateList;
	}

	public List<RateDiscountPo> getRateList0() {
		return rateList0;
	}

	public void setRateList0(List<RateDiscountPo> rateList0) {
		this.rateList0 = rateList0;
	}

	public List<RateDiscountPo> getRateList1() {
		return rateList1;
	}

	public void setRateList1(List<RateDiscountPo> rateList1) {
		this.rateList1 = rateList1;
	}

	public List<RateDiscountPo> getRateList2() {
		return rateList2;
	}

	public void setRateList2(List<RateDiscountPo> rateList2) {
		this.rateList2 = rateList2;
	}

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
	
	public String getActiveTimeStr() {
		return activeTimeStr;
	}

	public void setActiveTimeStr(String activeTimeStr) {
		this.activeTimeStr = activeTimeStr;
	}

	public DiscountPo getDiscountPo() {
		return discountPo;
	}

	public void setDiscountPo(DiscountPo discountPo) {
		this.discountPo = discountPo;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Long getRateDiscountId() {
		return rateDiscountId;
	}

	public void setRateDiscountId(Long rateDiscountId) {
		this.rateDiscountId = rateDiscountId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
        this.agencyName = agencyName == null ? null : agencyName.trim();
    }


    public Long getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Long activeTime) {
        this.activeTime = activeTime;
    }
}