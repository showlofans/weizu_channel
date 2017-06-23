package org.weizu.api.outter.pojo;

/**
 * @description: 代理商账户余额实体
 * @projectName:weizu-web-api
 * @className:BalanceDTO.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月23日 下午2:35:51
 * @version 1.0
 */
public class BalanceDTO {
	/**
	 * 账户余额
	 */
	private String accountBalance;
	/**
	 * 账户信用值
	 */
	private String accountCredit;
	
	private Integer tipCode;			//提示编码
				
	private String tipMSg;				//提示信息
	
	/** 验证失败
	 * @param tipCode
	 * @param tipMSg
	 */
//	public BalanceDTO(Integer tipCode, String tipMSg) {
//		super();
//		this.tipCode = tipCode;
//		this.tipMSg = tipMSg;
//	}
	/** 用户验证成功
	 * @param accountBalance
	 * @param accountCredit
	 * @param tipCode
	 * @param tipMSg
	 */
	public BalanceDTO(Integer tipCode, String tipMSg, 
			String accountBalance, String accountCredit) {
		super();
		this.accountBalance = accountBalance;
		this.accountCredit = accountCredit;
		this.tipCode = tipCode;
		this.tipMSg = tipMSg;
	}
	
	public BalanceDTO() {
		super();
	}
	public Integer getTipCode() {
		return tipCode;
	}
	public void setTipCode(Integer tipCode) {
		this.tipCode = tipCode;
	}
	public String getTipMSg() {
		return tipMSg;
	}
	public void setTipMSg(String tipMSg) {
		this.tipMSg = tipMSg;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountCredit() {
		return accountCredit;
	}
	public void setAccountCredit(String accountCredit) {
		this.accountCredit = accountCredit;
	}
}
