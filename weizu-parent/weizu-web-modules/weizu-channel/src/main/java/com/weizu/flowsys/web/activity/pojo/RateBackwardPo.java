package com.weizu.flowsys.web.activity.pojo;

import org.weizu.web.foundation.core.annotation.po.TableName;
import org.weizu.web.foundation.core.beans.Po;

@TableName(name="rate_backward")
public class RateBackwardPo extends Po {
    private Long id;

    private String rateName;

    private Integer rootAgencyId;

    private String ratePrice0;	//移动-费率列表

    private String ratePrice1;	//联通-费率列表

    private String ratePrice2;	//电信-费率列表

    private Integer rateState;
    
    private Integer billType;		//票务 1-带票，0-不带票

    public RateBackwardPo(String rateName, Integer rootAgencyId,
			String ratePrice0, String ratePrice1, String ratePrice2,
			Integer rateState) {
		super();
		this.rateName = rateName;
		this.rootAgencyId = rootAgencyId;
		this.ratePrice0 = ratePrice0;
		this.ratePrice1 = ratePrice1;
		this.ratePrice2 = ratePrice2;
		this.rateState = rateState;
	}

	public RateBackwardPo(String rateName, Integer rootAgencyId,
			String ratePrice0, String ratePrice1, String ratePrice2,
			Integer rateState, Integer billType) {
		super();
		this.rateName = rateName;
		this.rootAgencyId = rootAgencyId;
		this.ratePrice0 = ratePrice0;
		this.ratePrice1 = ratePrice1;
		this.ratePrice2 = ratePrice2;
		this.rateState = rateState;
		this.billType = billType;
	}


	public RateBackwardPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName == null ? null : rateName.trim();
    }

    public Integer getRootAgencyId() {
        return rootAgencyId;
    }

    public void setRootAgencyId(Integer rootAgencyId) {
        this.rootAgencyId = rootAgencyId;
    }

    public String getRatePrice0() {
        return ratePrice0;
    }

    public void setRatePrice0(String ratePrice0) {
        this.ratePrice0 = ratePrice0 == null ? null : ratePrice0.trim();
    }

    public String getRatePrice1() {
        return ratePrice1;
    }

    public void setRatePrice1(String ratePrice1) {
        this.ratePrice1 = ratePrice1 == null ? null : ratePrice1.trim();
    }

    public String getRatePrice2() {
        return ratePrice2;
    }

    public void setRatePrice2(String ratePrice2) {
        this.ratePrice2 = ratePrice2 == null ? null : ratePrice2.trim();
    }

    public Integer getRateState() {
        return rateState;
    }

    public void setRateState(Integer rateState) {
        this.rateState = rateState;
    }

}