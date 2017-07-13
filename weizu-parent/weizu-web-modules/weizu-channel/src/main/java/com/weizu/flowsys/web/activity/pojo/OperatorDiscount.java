package com.weizu.flowsys.web.activity.pojo;

import java.util.List;

/**
 * @description:运营商范围折扣
 * @projectName:crud
 * @className:OperatorScopeDiscount.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月17日 下午4:55:20
 * @version 1.0
 */
public class OperatorDiscount {
	/**
	 * 运营商类型
	 */
	private String operatorType;
	
	private Integer operatorT;
	/**
	 * 地区折扣列表
	 */
	private List<ScopeDiscount> list;
	
	
	
	public OperatorDiscount(String operatorType, List<ScopeDiscount> list) {
		super();
		this.operatorType = operatorType;
		this.list = list;
	}
	public OperatorDiscount() {
		super();
	}
	
	public OperatorDiscount(Integer operatorT, List<ScopeDiscount> list) {
		super();
		this.operatorT = operatorT;
		this.list = list;
	}
	public Integer getOperatorT() {
		return operatorT;
	}
	public void setOperatorT(Integer operatorT) {
		this.operatorT = operatorT;
	}
	public String getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}
	public List<ScopeDiscount> getList() {
		return list;
	}
	public void setList(List<ScopeDiscount> list) {
		this.list = list;
	}
	
}
