package org.weizu.api.outter.enums;

/**
 * @description: 余额查询状态枚举
 * @projectName:weizu-web-api
 * @className:BalanceCheckEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月26日 下午2:38:31
 * @version 1.0
 */
public enum BalanceCheckEnum {
	/**
	 * 用户验证失败
	 */
	AUTHENTICATION_FAILURE("用户验证失败",0),
	/**
	 * 用户验证成功
	 */
	AUTHENTICATION_SUCCESS("用户验证成功",1),
	/**
	 * 没有该账户类型
	 */
	BILL_TYPE_ERROR("账户类型不存在",3),
	/**
	 * 未开通该类型账户
	 */
	ACCOUNT_NOT_FOUND("未开通该类型账户",5);
	private String desc;
	private Integer value;
	
	private BalanceCheckEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
}
