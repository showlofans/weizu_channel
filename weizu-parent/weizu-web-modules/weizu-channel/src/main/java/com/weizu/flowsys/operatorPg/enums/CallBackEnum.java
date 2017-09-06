package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 是否支持回调枚举
 * @projectName:weizu-channel
 * @className:CallBackEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年9月2日 下午1:50:07
 * @version 1.0
 */
public enum CallBackEnum {
	/**
	 * 不支持回调
	 */
	NEGATIVE("不支持回调",0),
//	/**
//	 * 支持回调
//	 */
//	UNBIND("支持回调",1),
	/**
	 * 支持回调
	 */
	POSITIVE("支持回调",1);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private CallBackEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static CallBackEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		CallBackEnum resultEnum = null;

		// 获取附件类型枚举数组
		CallBackEnum[] enumArray = CallBackEnum.values();

		for (CallBackEnum callBackEnum : enumArray)
		{
			if(value.equals(callBackEnum.getValue()))
			{
				resultEnum = callBackEnum;
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
		CallBackEnum[] enumArray = CallBackEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (CallBackEnum callBackEnum : enumArray)
		{
			String key = String.valueOf(getEnum(callBackEnum.getValue()));

			Map<String, Object> callBackMap = new HashMap<String, Object>(2);
			callBackMap.put("desc", callBackEnum.getDesc());
			callBackMap.put("value", callBackEnum.getValue());

			enumMap.put(key, callBackMap);
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
		CallBackEnum[] enumArray = CallBackEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (CallBackEnum callBackEnum : enumArray)
		{
			Map<String, Object> callBackMap = new HashMap<String, Object>(2);
			callBackMap.put("desc", callBackEnum.getDesc());
			callBackMap.put("value", callBackEnum.getValue());

			attachmentTypeMapList.add(callBackMap);
		}

		return attachmentTypeMapList;
	}
	/**
	 * @description:将枚举转换成list，其中每个值为一个Map，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:27
	 */
//	public static List<Map<String, Object>> toBindList()
//	{
//		// 获取附件类型枚举数组
//		CallBackEnum[] enumArray = CallBackEnum.values();
//		
//		// 定义枚举list
//		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);
//		
//		for (CallBackEnum callBackEnum : enumArray)
//		{
//			if(callBackEnum!=BIND){
//				Map<String, Object> callBackMap = new HashMap<String, Object>(2);
//				callBackMap.put("desc", callBackEnum.getDesc());
//				callBackMap.put("value", callBackEnum.getValue());
//				attachmentTypeMapList.add(callBackMap);
//			}
//		}
//		
//		return attachmentTypeMapList;
//	}
	
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
