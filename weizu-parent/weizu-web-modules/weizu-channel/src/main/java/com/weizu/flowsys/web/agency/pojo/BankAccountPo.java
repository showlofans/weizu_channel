package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

/**
 * @description: 引用账户信息实体
 * @projectName:weizu-channel
 * @className:BankAccountPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月8日 上午11:10:45
 * @version 1.0
 */
@TableName(name="bank_account")
public class BankAccountPo extends Po implements Cloneable{
	
	private Long id;
	
	private Integer accountId;			//待充值账户Id
	
	private String remittanceWay;		//汇款方式 
	
	private String remittanceBankAccount;	//汇款账号
	
	private String accountName;				//汇款账号真实姓名
	
	private Double referenceBalance;		//对账余额
	
	private Integer agencyId;			//待充值账户所属代理商id
	
	private Integer polarity;			//使用方式（1-加款卡，0-被加卡）
	
	private Integer useState;			//使用状态
	
	
	@TempField
	private Integer billType;			//页面参数：绑定账户带票类型
	@TempField
	private Double accountBalance;		//页面参数：绑定账户余额带票类型
	
	private Long lastAccess;			//最后更新时间
	@TempField
	private String lastAccessStr;		//页面展示时间

	public BankAccountPo(Integer accountId, String remittanceWay,
			String remittanceBankAccount, String accountName,
			Double referenceBalance, Integer agencyId, Integer polarity,
			Integer useState) {
		super();
		this.accountId = accountId;
		this.remittanceWay = remittanceWay;
		this.remittanceBankAccount = remittanceBankAccount;
		this.accountName = accountName;
		this.referenceBalance = referenceBalance;
		this.agencyId = agencyId;
		this.polarity = polarity;
		this.useState = useState;
	}

	@Override
	public BankAccountPo clone() {
		BankAccountPo pvo = null;
    	try{  
    		pvo = (BankAccountPo)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
		return pvo;
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

	/**
	 * @description: 修改引用账户余额
	 * @param minusAmount
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月12日 上午11:22:34
	 */
	public Double minusReferenceBalance(double minusAmount,int flag){
		if(flag == -1){
    		this.referenceBalance = NumberTool.sub(this.referenceBalance, minusAmount);
    	}else{
    		this.referenceBalance = NumberTool.add(this.referenceBalance, minusAmount);
    	}
    	return this.referenceBalance;
	}

	public BankAccountPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUseState() {
		return useState;
	}

	public void setUseState(Integer useState) {
		this.useState = useState;
	}

	public Integer getPolarity() {
		return polarity;
	}

	public void setPolarity(Integer polarity) {
		this.polarity = polarity;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getRemittanceWay() {
		return remittanceWay;
	}

	public void setRemittanceWay(String remittanceWay) {
		this.remittanceWay = remittanceWay;
	}

	public String getRemittanceBankAccount() {
		return remittanceBankAccount;
	}

	public void setRemittanceBankAccount(String remittanceBankAccount) {
		this.remittanceBankAccount = remittanceBankAccount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getReferenceBalance() {
		return referenceBalance;
	}

	public void setReferenceBalance(Double referenceBalance) {
		this.referenceBalance = referenceBalance;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}
	
}
