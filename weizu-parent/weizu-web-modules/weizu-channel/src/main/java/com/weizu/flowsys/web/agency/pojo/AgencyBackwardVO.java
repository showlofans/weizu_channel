package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description:下游代理商实体类
 * @projectName:crud
 * @className:AgencyBackwardPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月25日 上午11:42:07
 * @version 1.0
 */
@TableName(name = "agency_backward")
public class AgencyBackwardVO extends Po {

	private Integer id;

	private Integer rootAgencyId;

	private String userName;

	private String userRealName;
	
	private String userPasss;

	private String agencyTel;

	private String userEmail;

	private String agencyIp;

	private Double accountBalance; // 账户余额

	private Double accountCredit; // 透支额

	private Long rateId;
	private String rateName;
	
	private Long billRateId;
	private String billRateName;

	private Long createTime;		//注册时间
	@TempField
	private String createTimeStr;
	
//	private Long startTime
	
	private String verifyCode;				//注册邀请码
	
	private String userApiKey;				//用户对接系统的apikey
	
	/**生成VO实体*/
	public AgencyBackwardVO(Integer id, Integer rootAgencyId, String userName,
			String userRealname, String userPasss, String agencyTel,
			String userEmail, String agencyIp, Double accountBalance,
			Double accountCredit, Long createTime,
			String verifyCode) {
		super();
		this.id = id;
		this.rootAgencyId = rootAgencyId;
		this.userName = userName;
		this.userRealName = userRealname;
		this.userPasss = userPasss;
		this.agencyTel = agencyTel;
		this.userEmail = userEmail;
		this.agencyIp = agencyIp;
		this.accountBalance = accountBalance;
		this.accountCredit = accountCredit;
		this.createTime = createTime;
		this.verifyCode = verifyCode;
	}
	
	public Long getBillRateId() {
		return billRateId;
	}

	public void setBillRateId(Long billRateId) {
		this.billRateId = billRateId;
	}

	public String getBillRateName() {
		return billRateName;
	}



	public void setBillRateName(String billRateName) {
		this.billRateName = billRateName;
	}



	public String getUserApiKey() {
		return userApiKey;
	}

	public void setUserApiKey(String userApiKey) {
		this.userApiKey = userApiKey;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;//createTimeStr不为空
	}

	public String getRateName() {
		return rateName;
	}


	public void setRateName(String rateName) {
		this.rateName = rateName;
	}



	public AgencyBackwardVO() {
		super();
	}

	public String getUserPasss() {
		return userPasss;
	}

	public void setUserPasss(String userPasss) {
		this.userPasss = userPasss;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Integer getRootAgencyId() {
		return rootAgencyId;
	}

	public void setRootAgencyId(Integer rootAgencyId) {
		this.rootAgencyId = rootAgencyId;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getAccountCredit() {
		return accountCredit;
	}

	public void setAccountCredit(Double accountCredit) {
		this.accountCredit = accountCredit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
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
