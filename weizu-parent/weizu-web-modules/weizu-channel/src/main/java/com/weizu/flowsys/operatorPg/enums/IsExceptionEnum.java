package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 异常情况
 * @projectName:weizu-channel
 * @className:IsExceptionEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月13日 下午3:16:16
 * @version 1.0
 */
public enum IsExceptionEnum {
	/**
	 * 正常-0
	 */
	NEGATIVE("正常",0),
//	/**
//	 * 支持回调
//	 */
//	UNBIND("支持回调",1),
	/**
	 * 异常-1
	 */
	POSITIVE("异常",1);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private IsExceptionEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static IsExceptionEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		IsExceptionEnum resultEnum = null;

		// 获取附件类型枚举数组
		IsExceptionEnum[] enumArray = IsExceptionEnum.values();

		for (IsExceptionEnum callBackEnum : enumArray)
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
		IsExceptionEnum[] enumArray = IsExceptionEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (IsExceptionEnum callBackEnum : enumArray)
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
		IsExceptionEnum[] enumArray = IsExceptionEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (IsExceptionEnum callBackEnum : enumArray)
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
