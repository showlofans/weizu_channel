package com.weizu.flowsys.web.agency.pojo;

import java.io.Serializable;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.beans.Po;
import com.weizu.flowsys.core.util.NumberTool;
import com.weizu.flowsys.web.trade.pojo.PurchaseVO;

/**
 * @description:代理商充值账户实体
 * @projectName:crud
 * @className:ChargeAccountPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月5日 下午6:02:22
 * @version 1.0
 */
@TableName(name="charge_account")
public class ChargeAccountPo extends Po implements Cloneable,Serializable {
//	private static final long serialVersionUID = 1L;

	private Integer id;						//账户id

    private Integer agencyId;				//所属代理商id
    
    private Integer supperAgencyId;			//所属父级代理商id
    
    private String remittanceWay;			//常用汇款方式

    private String remittanceBankAccount;	//汇款账号(银行卡)

    private Double accountBalance = 0.00d;			//账户余额
    
    private Double accountCredit = 0.00d;			//透支额
    
    private Integer billType;				//票务类型
    
    private String certificationImg;		//认证图片	
    
    private Long createTime;				//账户创建时间
    
    private String agencyName;				//所属代理商名称

    
    public ChargeAccountPo(Integer agencyId, Double accountBalance,
			Double accountCredit) {
		super();
		this.agencyId = agencyId;
		this.accountBalance = accountBalance;
		this.accountCredit = accountCredit;
	}
    @Override
   	public ChargeAccountPo clone() {
    	ChargeAccountPo accountPo = null;
       	try{  
       		accountPo = (ChargeAccountPo)super.clone();  
           }catch(CloneNotSupportedException e) {  
               e.printStackTrace();  
           }  
   		return accountPo;
   	}
    

	/**  createCompanyAccount 创建一个默认的对公账户
	 * @param agencyId
	 * @param accountBalance
	 * @param billType
	 * @param createTime
	 * @param agencyName
	 */
	public ChargeAccountPo(Integer agencyId,Integer supperAgencyId, Double accountBalance,
			Integer billType, Long createTime, String agencyName) {
		super();
		this.agencyId = agencyId;
		this.accountBalance = accountBalance;
		this.billType = billType;
		this.createTime = createTime;
		this.supperAgencyId = supperAgencyId;
		this.agencyName = agencyName;
	}



	public ChargeAccountPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     * @description:实例化加款后的账户
     * @param addBalance 加款额
     * @return
     * @author:POP产品研发部 宁强
     * @createTime:2017年5月8日 上午10:48:31
     */
    public double addBalance(double addBalance,int flag){
    	if(flag == -1){
    		this.accountBalance = NumberTool.sub(this.accountBalance, addBalance);
    	}else{
    		this.accountBalance = NumberTool.add(this.accountBalance, addBalance);
    	}
    	return this.accountBalance;
    }
    
    public Integer getSupperAgencyId() {
		return supperAgencyId;
	}
	public void setSupperAgencyId(Integer supperAgencyId) {
		this.supperAgencyId = supperAgencyId;
	}
	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public String getCertificationImg() {
		return certificationImg;
	}

	public void setCertificationImg(String certificationImg) {
		this.certificationImg = certificationImg;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getRemittanceWay() {
        return remittanceWay;
    }

    public void setRemittanceWay(String remittanceWay) {
        this.remittanceWay = remittanceWay == null ? null : remittanceWay.trim();
    }

    public String getRemittanceBankAccount() {
        return remittanceBankAccount;
    }

    public void setRemittanceBankAccount(String remittanceBankAccount) {
        this.remittanceBankAccount = remittanceBankAccount == null ? null : remittanceBankAccount.trim();
    }

    public Double getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(Double accountCredit) {
        this.accountCredit = accountCredit;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }
}
