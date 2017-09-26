package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;
//import com.weizu.web.foundation.DateUtil;

/**
 * @description:账户发生金额记录实体
 * @projectName:crud
 * @className:ChargeRecordPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月6日 上午10:01:10
 * @version 1.0
 */
@TableName(name = "charge_record")
public class ChargeRecordPo extends Po implements Cloneable{

	private long id; 					// 记录id

	private Long remittanceTime; 		// 发生时间（信息更新时间）
	@TempField
	private String remittanceTimeStr; 		// 发生时间（信息更新时间）
	
	private Double rechargeAmount; 		// 充值额

	private Double chargeBefore; 		// 交易前余额

	private Double chargeAfter; 		// 交易后余额
	@TempField
	private Integer billType; 			// 发票类型（1-对公，0-对私）

	private Integer accountType; 		// 交易类型（1-给上家扣款，0-给下家充值)

	private Integer accountId; 			// 账户id
	
//	private Integer agencyId; 			// 代理商id
	
	private Long purchaseId;			//订单号
	
	@TempField
	private String userName;			//代理商名称
	@TempField
	private String userRealName;		//代理商真实姓名
	
	private Integer chargeFor; 			// 发生原因

	@TempField
	private Long startTime; 			// 开始时间
	
	@TempField
	private String startTimeStr;		// 开始时间str
	
	@TempField
	private String endTimeStr;			// 结束时间str
	
	@TempField
	private Long endTime; 				// 结束时间

	/**
	 * 充值所需参数
	 * 
	 * @param remittanceTime
	 * @param rechargeAmount
	 * @param chargeBefore
	 * @param chargeAfter
	 * @param billType
	 * @param accountType
	 * @param accountId
	 * @param chargeFor
	 * @param purchaseId
	 */
	public ChargeRecordPo(Long remittanceTime, Double rechargeAmount,
			Double chargeBefore, Double chargeAfter,
//			Integer billType,
			Integer accountType, Integer accountId, 
//			Integer agencyId, 
			Integer chargeFor, Long purchaseId) {
		super();
//		this.agencyId = agencyId;
		this.remittanceTime = remittanceTime;
		this.rechargeAmount = rechargeAmount;
		this.chargeBefore = chargeBefore;
		this.chargeAfter = chargeAfter;
//		this.billType = billType;
		this.accountType = accountType;
		this.accountId = accountId;
		this.chargeFor = chargeFor;
		this.purchaseId = purchaseId;
	}
	
	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}



	@Override
	public ChargeRecordPo clone() throws CloneNotSupportedException {
		ChargeRecordPo chargeRecordPo = null; 
   	 try{  
   		chargeRecordPo = (ChargeRecordPo)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
		return chargeRecordPo;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
//		this.startTime = DateUtil.strToDate(startTimeStr, null).getTime();
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
//		this.endTime = DateUtil.strToDate(endTimeStr, null).getTime();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserRealName() {
		return userRealName;
	}


	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}


	public String getRemittanceTimeStr() {
		return remittanceTimeStr;
	}


	public void setRemittanceTimeStr(String remittanceTimeStr) {
		this.remittanceTimeStr = remittanceTimeStr;
	}



//	public Integer getAgencyId() {
//		return agencyId;
//	}
//
//	public void setAgencyId(Integer agencyId) {
//		this.agencyId = agencyId;
//	}

	public Double getChargeBefore() {
		return chargeBefore;
	}

	public void setChargeBefore(Double chargeBefore) {
		this.chargeBefore = chargeBefore;
	}

	public Double getChargeAfter() {
		return chargeAfter;
	}

	public void setChargeAfter(Double chargeAfter) {
		this.chargeAfter = chargeAfter;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public ChargeRecordPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getRemittanceTime() {
		return remittanceTime;
	}

	public void setRemittanceTime(Long remittanceTime) {
		this.remittanceTime = remittanceTime;
	}

	public Double getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getChargeFor() {
		return chargeFor;
	}

	public void setChargeFor(Integer chargeFor) {
		this.chargeFor = chargeFor;
	}
}
