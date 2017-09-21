package com.weizu.flowsys.web.agency.pojo;

import com.weizu.flowsys.core.annotation.po.TableName;
import com.weizu.flowsys.core.annotation.po.TempField;
import com.weizu.flowsys.core.beans.Po;

/**
 * @description: 代理商认证实体
 * @projectName:weizu-channel
 * @className:CompanyCredentialsPo.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月19日 下午4:34:38
 * @version 1.0
 */
@TableName(name="company_credentials")
public class CompanyCredentialsPo extends Po{
    private Integer id;

    private Integer agencyId;							//待验证代理商id 

    private Integer confirmAgencyId;					//验证人Id(一般是rootAgencyId)

    private Integer confirmState;						//验证状态（1-验证通过，0-验证失败，2-待验证，3-待完善:草稿）

    private String businessExecutiveName;				//商务负责人姓名

    private String beTel;								//商务联系电话

    private String emergencyContact;					//紧急联系人

    private String ecTel;								//紧急联系人电话

    private String companyAddress;						//企业现居地址

    private Integer taxpayerIsQualification;			//是否具备增值税一般纳税人资格

    private String companyName;							//公司名称

    private String companyLocation;						//公司地址

    private String corporateTel;						//公司（负责人）联系电话

    private String depositBankName;						//开户行名称

    private String bankAccount;							//银行账号

    private String taxRegistrationCertificate;			//税务登记证号

    private String billingContent;						//开票内容

    private Double infoServiceFee;						//信息服务费

    private String billRecipientsName;					//发票收件人

    private String billRecipientsTel;					//收件人电话

    private String billRecipientsAddress;				//收件地址

    private String businessLicense;						//营业执照

    private String depositBankPhoto;					//银行开户信息

    private String corporateIdentityFront;				//法定人身份证(正面)

    private String corporateIdentityBack;				//法定人身份证(反面)
    
    private Long commitTime;							//提交时间
    @TempField
    private String commitTimeStr;						//提交时间str
    @TempField
    private String confirmTimeStr;						//审核时间str

    private String agencyName;							//待验证代理商名字
    
    private Long confirmTime;							//审核时间

    
    /** 上传图片必须加到数据库的参数
     * @param agencyId
     * @param confirmAgencyId
     * @param confirmState
     */
    public CompanyCredentialsPo(Integer agencyId, Integer confirmAgencyId,
			Integer confirmState) {
		super();
		this.agencyId = agencyId;
		this.confirmAgencyId = confirmAgencyId;
		this.confirmState = confirmState;
	}
    
    public void initBase(Integer agencyId,String agencyName, Integer confirmAgencyId,
			Integer confirmState){
    	this.agencyId = agencyId;
		this.confirmAgencyId = confirmAgencyId;
		this.confirmState = confirmState;
		this.agencyName = agencyName;
    }
    
	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getCommitTimeStr() {
		return commitTimeStr;
	}

	public void setCommitTimeStr(String commitTimeStr) {
		this.commitTimeStr = commitTimeStr;
	}

	public String getConfirmTimeStr() {
		return confirmTimeStr;
	}

	public void setConfirmTimeStr(String confirmTimeStr) {
		this.confirmTimeStr = confirmTimeStr;
	}

	public Long getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(Long commitTime) {
		this.commitTime = commitTime;
	}

	public Long getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Long confirmTime) {
		this.confirmTime = confirmTime;
	}

	public CompanyCredentialsPo() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Integer getConfirmAgencyId() {
        return confirmAgencyId;
    }

    public void setConfirmAgencyId(Integer confirmAgencyId) {
        this.confirmAgencyId = confirmAgencyId;
    }

    public Integer getConfirmState() {
        return confirmState;
    }

    public void setConfirmState(Integer confirmState) {
        this.confirmState = confirmState;
    }

    public String getBusinessExecutiveName() {
        return businessExecutiveName;
    }

    public void setBusinessExecutiveName(String businessExecutiveName) {
        this.businessExecutiveName = businessExecutiveName == null ? null : businessExecutiveName.trim();
    }

    public String getBeTel() {
        return beTel;
    }

    public void setBeTel(String beTel) {
        this.beTel = beTel == null ? null : beTel.trim();
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact == null ? null : emergencyContact.trim();
    }

    public String getEcTel() {
        return ecTel;
    }

    public void setEcTel(String ecTel) {
        this.ecTel = ecTel == null ? null : ecTel.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public Integer getTaxpayerIsQualification() {
        return taxpayerIsQualification;
    }

    public void setTaxpayerIsQualification(Integer taxpayerIsQualification) {
        this.taxpayerIsQualification = taxpayerIsQualification;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation == null ? null : companyLocation.trim();
    }

    public String getCorporateTel() {
        return corporateTel;
    }

    public void setCorporateTel(String corporateTel) {
        this.corporateTel = corporateTel == null ? null : corporateTel.trim();
    }

    public String getDepositBankName() {
        return depositBankName;
    }

    public void setDepositBankName(String depositBankName) {
        this.depositBankName = depositBankName == null ? null : depositBankName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getTaxRegistrationCertificate() {
        return taxRegistrationCertificate;
    }

    public void setTaxRegistrationCertificate(String taxRegistrationCertificate) {
        this.taxRegistrationCertificate = taxRegistrationCertificate == null ? null : taxRegistrationCertificate.trim();
    }

    public String getBillingContent() {
        return billingContent;
    }

    public void setBillingContent(String billingContent) {
        this.billingContent = billingContent == null ? null : billingContent.trim();
    }

    public Double getInfoServiceFee() {
        return infoServiceFee;
    }

    public void setInfoServiceFee(Double infoServiceFee) {
        this.infoServiceFee = infoServiceFee;
    }

    public String getBillRecipientsName() {
        return billRecipientsName;
    }

    public void setBillRecipientsName(String billRecipientsName) {
        this.billRecipientsName = billRecipientsName == null ? null : billRecipientsName.trim();
    }

    public String getBillRecipientsTel() {
        return billRecipientsTel;
    }

    public void setBillRecipientsTel(String billRecipientsTel) {
        this.billRecipientsTel = billRecipientsTel == null ? null : billRecipientsTel.trim();
    }

    public String getBillRecipientsAddress() {
        return billRecipientsAddress;
    }

    public void setBillRecipientsAddress(String billRecipientsAddress) {
        this.billRecipientsAddress = billRecipientsAddress == null ? null : billRecipientsAddress.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getDepositBankPhoto() {
        return depositBankPhoto;
    }

    public void setDepositBankPhoto(String depositBankPhoto) {
        this.depositBankPhoto = depositBankPhoto == null ? null : depositBankPhoto.trim();
    }

    public String getCorporateIdentityFront() {
        return corporateIdentityFront;
    }

    public void setCorporateIdentityFront(String corporateIdentityFront) {
        this.corporateIdentityFront = corporateIdentityFront == null ? null : corporateIdentityFront.trim();
    }

    public String getCorporateIdentityBack() {
        return corporateIdentityBack;
    }

    public void setCorporateIdentityBack(String corporateIdentityBack) {
        this.corporateIdentityBack = corporateIdentityBack == null ? null : corporateIdentityBack.trim();
    }
}