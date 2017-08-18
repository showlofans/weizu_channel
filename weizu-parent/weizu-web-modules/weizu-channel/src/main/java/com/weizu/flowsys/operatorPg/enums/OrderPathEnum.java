package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 流量充值方式枚举
 * @projectName:crud
 * @className:OrderPathEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月12日 下午5:54:37
 * @version 1.0
 */
public enum OrderPathEnum {
	
	/**
	 * 网页充值
	 */
	WEB_PAGE("网页",0),
	/**
	 * 网页充值
	 */
	CHILD_WEB_PAGE("下级代理商网页",2),
	/**
	 * 接口充值
	 */
	CHARGE_SOCKET("接口",1);
	
	private String desc;
	private Integer value;
	
	private OrderPathEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	
	public static OrderPathEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		OrderPathEnum resultEnum = null;

		// 获取附件类型枚举数组
		OrderPathEnum[] enumArray = OrderPathEnum.values();

		for (OrderPathEnum orderPathEnum : enumArray)
		{
			if(value.equals(orderPathEnum.getValue()))
			{
				resultEnum = orderPathEnum;
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
		OrderPathEnum[] enumArray = OrderPathEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (OrderPathEnum orderPathEnum : enumArray)
		{
			String key = String.valueOf(getEnum(orderPathEnum.getValue()));

			Map<String, Object> orderPathMap = new HashMap<String, Object>(2);
			orderPathMap.put("desc", orderPathEnum.getDesc());
			orderPathMap.put("value", orderPathEnum.getValue());

			enumMap.put(key, orderPathMap);
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
		OrderPathEnum[] enumArray = OrderPathEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (OrderPathEnum orderPathEnum : enumArray)
		{
			Map<String, Object> orderPathMap = new HashMap<String, Object>(2);
			orderPathMap.put("desc", orderPathEnum.getDesc());
			orderPathMap.put("value", orderPathEnum.getValue());

			attachmentTypeMapList.add(orderPathMap);
		}

		return attachmentTypeMapList;
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
