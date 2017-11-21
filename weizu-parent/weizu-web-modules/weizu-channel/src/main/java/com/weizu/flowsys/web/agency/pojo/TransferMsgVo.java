package com.weizu.flowsys.web.agency.pojo;

import java.io.Serializable;

/**
 * @description: 转账消息展示实体
 * @projectName:weizu-channel
 * @className:TransferMsgVo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月13日 下午1:00:11
 * @version 1.0
 */
public class TransferMsgVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String remmitanceBankAccount;			//银行卡账号
	
	private Long id;								//银行卡id
	
	private Long  tfnum;							//消息总数

	public String getRemmitanceBankAccount() {
		return remmitanceBankAccount;
	}

	public void setRemmitanceBankAccount(String remmitanceBankAccount) {
		this.remmitanceBankAccount = remmitanceBankAccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTfnum() {
		return tfnum;
	}

	public void setTfnum(Long tfnum) {
		this.tfnum = tfnum;
	}
	
}
