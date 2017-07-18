package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:代理商注册登陆实体类
 * @projectName:crud
 * @className:AgencyBackwardPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月25日 上午11:42:07
 * @version 1.0
 */
@TableName(name="agency_backward")
public class AgencyBackwardPo extends Po{

    private Integer id;						//带票费率id

    private Integer rootAgencyId;			//带票费率id

    private String userName;				//带票费率id

    private String userPass;				//带票费率id

    private String userRealName;			//带票费率id

    private String agencyTel;				//带票费率id

    private String userEmail;				//带票费率id

    private String agencyIp;				//代理商系统主页地址

    private Long rateId;					//不带票费率id
    
    private Long billRateId;				//带票费率id
    
    
    @TempField
    private Double accountCredit;
    @TempField
    private String rateName;
    
    
	private Long createTime;
	
	private String verifyCode;				//注册邀请码
	
	private String userApiKey;				//用户对接系统的apikey
	@TempField
	private int[] agencyIds;				//批量操作代理商
	
	public AgencyBackwardPo(Integer id, Integer rootAgencyId, String userName,
			String userPass, String userRealName, String agencyTel,
			String userEmail, String agencyIp, Long rateId,
			Double accountCredit, String rateName, Long createTime,
			String verifyCode) {
		super();
		this.id = id;
		this.rootAgencyId = rootAgencyId;
		this.userName = userName;
		this.userPass = userPass;
		this.userRealName = userRealName;
		this.agencyTel = agencyTel;
		this.userEmail = userEmail;
		this.agencyIp = agencyIp;
		this.rateId = rateId;
		this.accountCredit = accountCredit;
		this.rateName = rateName;
		this.createTime = createTime;
		this.verifyCode = verifyCode;
	}
	public int[] getAgencyIds() {
		return agencyIds;
	}

	public void setAgencyIds(int[] agencyIds) {
		this.agencyIds = agencyIds;
	}

	public Long getBillRateId() {
		return billRateId;
	}

	public void setBillRateId(Long billRateId) {
		this.billRateId = billRateId;
	}

	public String getUserApiKey() {
		return userApiKey;
	}

	public void setUserApiKey(String userApiKey) {
		this.userApiKey = userApiKey;
	}

	public AgencyBackwardPo() {
		super();
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public Double getAccountCredit() {
		return accountCredit;
	}

	public void setAccountCredit(Double accountCredit) {
		this.accountCredit = accountCredit;
	}

	public Long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRootAgencyId() {
        return rootAgencyId;
    }

    public void setRootAgencyId(Integer rootAgencyId) {
        this.rootAgencyId = rootAgencyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getAgencyTel() {
        return agencyTel;
    }

    public void setAgencyTel(String agencyTel) {
        this.agencyTel = agencyTel == null ? null : agencyTel.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getAgencyIp() {
        return agencyIp;
    }

    public void setAgencyIp(String agencyIp) {
        this.agencyIp = agencyIp == null ? null : agencyIp.trim();
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

}
