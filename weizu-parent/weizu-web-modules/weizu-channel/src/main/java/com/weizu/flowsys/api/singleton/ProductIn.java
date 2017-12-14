package com.weizu.flowsys.api.singleton;

/**
 * @description: 包体信息
 * @projectName:weizu-channel
 * @className:Packages.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月14日 上午11:30:47
 * @version 1.0
 */
public class ProductIn {
	private Integer operator;//operator
	
	private String pg;	//包体
	
	private String name;//包体名称
	
	private Double price;//包体原价

	public ProductIn(Integer operator, String pg, String name, Double price) {
		super();
		this.operator = operator;
		this.pg = pg;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductIn [operator=" + operator + ", pg=" + pg + ", name="
				+ name + ", price=" + price + "]";
	}



	public ProductIn() {
		super();
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
