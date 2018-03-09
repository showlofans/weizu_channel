package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 话费类型枚举
 * @projectName:weizu-channel
 * @className:HuaServiceTypeEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月15日 下午3:46:10
 * @version 1.0
 */
public enum TelServiceTypeEnum {
	/**
	 * 市内话费-2
	 */
	CITY("市内",2),
	/**
	 * 省内话费-1
	 */
	PROVINCE("省内",1),
	/**
	 * 全国话费-0
	 */
	NATION_WIDE("全国",0);
	
	private String desc;
	private int value;
	
	private TelServiceTypeEnum(String desc, int value) {
		this.desc = desc;
		this.value = value;
	}

	public static TelServiceTypeEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		TelServiceTypeEnum resultEnum = null;

		// 获取附件类型枚举数组
		TelServiceTypeEnum[] enumArray = TelServiceTypeEnum.values();

		for (TelServiceTypeEnum serviceTypeEnum : enumArray)
		{
			if(value.equals(serviceTypeEnum.getValue()))
			{
				resultEnum = serviceTypeEnum;
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
		TelServiceTypeEnum[] enumArray = TelServiceTypeEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (TelServiceTypeEnum serviceTypeEnum : enumArray)
		{
			String key = String.valueOf(getEnum(serviceTypeEnum.getValue()));

			Map<String, Object> serviceTypeMap = new HashMap<String, Object>(2);
			serviceTypeMap.put("desc", serviceTypeEnum.getDesc());
			serviceTypeMap.put("value", serviceTypeEnum.getValue());

			enumMap.put(key, serviceTypeMap);
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
		TelServiceTypeEnum[] enumArray = TelServiceTypeEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (TelServiceTypeEnum serviceTypeEnum : enumArray)
		{
			Map<String, Object> serviceTypeMap = new HashMap<String, Object>(2);
			serviceTypeMap.put("desc", serviceTypeEnum.getDesc());
			serviceTypeMap.put("value", serviceTypeEnum.getValue());

			attachmentTypeMapList.add(serviceTypeMap);
		}

		return attachmentTypeMapList;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
