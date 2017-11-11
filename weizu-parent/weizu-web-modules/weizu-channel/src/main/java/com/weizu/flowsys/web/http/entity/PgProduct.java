package com.weizu.flowsys.web.http.entity;

import java.util.List;

/**
 * @description: 接口返回流量产品列表实体
 * @projectName:weizu-channel
 * @className:PgProduct.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月9日 上午11:45:20
 * @version 1.0
 */
public class PgProduct {
	
	private Integer tipCode;				//提示信息编码:
	
	private String tipMsg;					//提示信息
	
	List<PgProductPo> pgList;				//产品列表
	
	public PgProduct(Integer tipCode, String tipMsg, List<PgProductPo> pgList) {
		super();
		this.tipCode = tipCode;
		this.tipMsg = tipMsg;
		this.pgList = pgList;
	}
	public PgProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getTipCode() {
		return tipCode;
	}
	public void setTipCode(Integer tipCode) {
		this.tipCode = tipCode;
	}
	public String getTipMsg() {
		return tipMsg;
	}
	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
	public List<PgProductPo> getPgList() {
		return pgList;
	}
	public void setPgList(List<PgProductPo> pgList) {
		this.pgList = pgList;
	}
	
}
