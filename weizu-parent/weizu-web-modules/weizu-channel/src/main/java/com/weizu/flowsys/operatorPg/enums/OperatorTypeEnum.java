package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:运营商类型枚举
 * @projectName:crud
 * @className:OperatorTypeEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月26日 下午12:23:56
 * @version 1.0
 */
public enum OperatorTypeEnum {
	
	/**
	 * 移动运营
	 */
	MOBILE("移动",0),
	/**
	 * 联通运营
	 */
	LINK("联通",1),
	/**
	 * 电信运营
	 */
	TELECOME("电信",2);

	/**
	 * 枚举名称
	 */
	private String desc;

	/**
	 * 枚举值
	 */
	private Integer value;

	private OperatorTypeEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	
	/**
	 * @description: 通过描述获得值
	 * @param desc
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月1日 下午5:48:55
	 */
	public static Integer getValueByDesc(String desc){
		OperatorTypeEnum[] enumArray = OperatorTypeEnum.values();
		Integer value = 0;
		for (OperatorTypeEnum operatorTypeEnum : enumArray)
		{
			if(desc.contains(operatorTypeEnum.getDesc()))
			{
				value = operatorTypeEnum.getValue();
				break;
			}
		}
		return value;
	}
	/**
	 * @description:通过枚举值获取枚举
	 * @param value
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:33:32
	 */
	public static OperatorTypeEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		OperatorTypeEnum resultEnum = null;

		// 获取附件类型枚举数组
		OperatorTypeEnum[] enumArray = OperatorTypeEnum.values();

		for (OperatorTypeEnum operatorTypeEnum : enumArray)
		{
			if(value.equals(operatorTypeEnum.getValue()))
			{
				resultEnum = operatorTypeEnum;
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
		OperatorTypeEnum[] enumArray = OperatorTypeEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (OperatorTypeEnum operatorTypeEnum : enumArray)
		{
			String key = String.valueOf(getEnum(operatorTypeEnum.getValue()));

			Map<String, Object> attachmentTypeMap = new HashMap<String, Object>(2);
			attachmentTypeMap.put("desc", operatorTypeEnum.getDesc());
			attachmentTypeMap.put("value", operatorTypeEnum.getValue());

			enumMap.put(key, attachmentTypeMap);
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
		OperatorTypeEnum[] enumArray = OperatorTypeEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (OperatorTypeEnum operatorTypeEnum : enumArray)
		{
			Map<String, Object> attachmentTypeMap = new HashMap<String, Object>(2);
			attachmentTypeMap.put("desc", operatorTypeEnum.getDesc());
			attachmentTypeMap.put("value", operatorTypeEnum.getValue());

			attachmentTypeMapList.add(attachmentTypeMap);
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
