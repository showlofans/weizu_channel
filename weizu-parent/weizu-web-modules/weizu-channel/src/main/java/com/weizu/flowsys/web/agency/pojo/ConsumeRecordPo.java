package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;
import com.weizu.web.foundation.DateUtil;

/**
 * @description:账户消费记录实体
 * @projectName:crud
 * @className:ChargeRecordPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月6日 上午10:01:10
 * @version 1.0
 */
@TableName(name = "charge_record")
public class ConsumeRecordPo extends Po implements Cloneable{

	private long id; 					// 记录id

	private Long remittanceTime; 		// 发生时间（信息更新时间）
	@TempField
	private String remittanceTimeStr; 		// 发生时间（信息更新时间）
	
	private Double rechargeAmount; 		// 充值额

	private Double chargeBefore; 		// 交易前余额

	private Double chargeAfter; 		// 交易后余额

	private Integer billType; 			// 发票类型（1-对公，0-对私）

	private Integer accountType; 		// 交易类型（1-给上家扣款，0-给下家充值)

	private Integer accountId; 			// 账户id
	
	private Integer agencyId; 			// 代理商id
	
	private String userName;			//代理商名称
	
	private Integer chargeFor; 			// 发生原因

	@TempField
	private Long startTime; 			// 开始时间
	
	@TempField
	private String startTimeStr;		// 开始时间str
	
	@TempField
	private String endTimeStr;			// 结束时间str
	
	@TempField
	private Long endTime; 				// 结束时间
	
	private Long orderId;				//订单号
	
	private String chargeTel;			//充值手机号
	
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
	 */
	public ConsumeRecordPo(Long remittanceTime, Double rechargeAmount,
			Double chargeBefore, Double chargeAfter, Integer billType,
			Integer accountType, Integer accountId, Integer agencyId, Integer chargeFor) {
		super();
		this.agencyId = agencyId;
		this.remittanceTime = remittanceTime;
		this.rechargeAmount = rechargeAmount;
		this.chargeBefore = chargeBefore;
		this.chargeAfter = chargeAfter;
		this.billType = billType;
		this.accountType = accountType;
		this.accountId = accountId;
		this.chargeFor = chargeFor;
	}

	@Override
	public ConsumeRecordPo clone() throws CloneNotSupportedException {
		ConsumeRecordPo chargeRecordPo = null; 
   	 try{  
   		chargeRecordPo = (ConsumeRecordPo)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
		return chargeRecordPo;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getChargeTel() {
		return chargeTel;
	}

	public void setChargeTel(String chargeTel) {
		this.chargeTel = chargeTel;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
		this.startTime = DateUtil.strToDate(startTimeStr, null).getTime();
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
		this.endTime = DateUtil.strToDate(endTimeStr, null).getTime();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemittanceTimeStr() {
		return remittanceTimeStr;
	}

	public void setRemittanceTimeStr(String remittanceTimeStr) {
		this.remittanceTimeStr = remittanceTimeStr;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

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

	public ConsumeRecordPo() {
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
