package com.weizu.flowsys.api.singleton;

import java.util.List;

/**
 * @description: 接口获取产品返回
 * @projectName:weizu-channel
 * @className:ProductDTO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月14日 上午11:33:42
 * @version 1.0
 */
public class ProductDTO {
	private int rspCode;			//返回状态
	private String rspMsg;			//返回状态描述
	
	private List<ProductIn> productInList;		//包体实体

	public ProductDTO(int rspCode, String rspMsg, List<ProductIn> productInList) {
		super();
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
		this.productInList = productInList;
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRspCode() {
		return rspCode;
	}

	public void setRspCode(int rspCode) {
		this.rspCode = rspCode;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	public List<ProductIn> getProductInList() {
		return productInList;
	}

	public void setProductInList(List<ProductIn> productInList) {
		this.productInList = productInList;
	}
}
