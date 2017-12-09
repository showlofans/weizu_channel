package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 账户事件枚举
 * @projectName:weizu-channel
 * @className:EventTypeEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月8日 下午4:12:43
 * @version 1.0
 */
public enum EventTypeEnum {
	
	/**
	 * 登陆-1
	 */
	AGENCY_LOGIN("登陆",1),
	/**
	 * 申请加款-2
	 */
	ACCOUNT_CHARGE("申请加款",2),
	/**
	 * 订单充值-3
	 */
	PURCHASE_CHARGE("订单充值",3),
	/**
	 * 订单退款-4
	 */
	PURCHASE_FAIL("订单退款",4),
	/**
	 * 有新代理商注册-5
	 */
	AGENCY_REGISTER("新代理商注册",5),
	/**
	 * 修改密码-8
	 */
	RESET_PASS("修改密码",8);
	
	private String desc;
	private Integer value;
	
	/**
	 * @description:通过枚举值获取枚举
	 * @param value
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:33:32
	 */
	public static EventTypeEnum getEnum(Integer value)
	{

		if(value == null){
			return null;
		}
		EventTypeEnum resultEnum = null;

		// 获取附件类型枚举数组
		EventTypeEnum[] enumArray = EventTypeEnum.values();

		for (EventTypeEnum accountTypeEnum : enumArray)
		{
			if(value == accountTypeEnum.getValue())
			{
				resultEnum = accountTypeEnum;
				break;
			}
		}

		return resultEnum;
	}
	
	/**
	 * @description:将枚举转换为MAP，转换成的MAP的key值为枚举值，value值为一个MAP，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:17
	 */
	public static Map<String, Map<String, Object>> toMap()
	{
		// 获取附件类型枚举数组
		EventTypeEnum[] enumArray = EventTypeEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (EventTypeEnum accountTypeEnum : enumArray)
		{
			String key = String.valueOf(getEnum(accountTypeEnum.getValue()));

			Map<String, Object> accountTypeMap = new HashMap<String, Object>(2);
			accountTypeMap.put("desc", accountTypeEnum.getDesc());
			accountTypeMap.put("value", accountTypeEnum.getValue());

			enumMap.put(key, accountTypeMap);
		}

		return enumMap;
	}
	
	/**
	 * @description:将枚举转换成list，其中每个值为一个Map，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:27
	 */
	public static List<Map<String, Object>> toList()
	{
		// 获取附件类型枚举数组
		EventTypeEnum[] enumArray = EventTypeEnum.values();

		// 定义枚举list
		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (EventTypeEnum accountTypeEnum : enumArray)
		{
			Map<String, Object> accountTypeMap = new HashMap<String, Object>(2);
			accountTypeMap.put("desc", accountTypeEnum.getDesc());
			accountTypeMap.put("value", accountTypeEnum.getValue());

			operatorNameMapList.add(accountTypeMap);
		}

		return operatorNameMapList;
	}
	
	
	private EventTypeEnum(String desc, Integer value) {
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
