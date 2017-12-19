package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 平台编码配置形式枚举
 * @projectName:weizu-channel
 * @className:EpEncodeTypeEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年12月18日 上午9:28:30
 * @version 1.0
 */
public enum EpEncodeTypeEnum {
	/**
	 * 有编码-0
	 */
	WITH_CODE("有编码",0),
//	/**
//	 * 支持回调
//	 */
//	UNBIND("支持回调",1),
	/**
	 * 无编码-1
	 */
	WITHOUT_CODE("无编码",1);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private EpEncodeTypeEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static EpEncodeTypeEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		EpEncodeTypeEnum resultEnum = null;

		// 获取附件类型枚举数组
		EpEncodeTypeEnum[] enumArray = EpEncodeTypeEnum.values();

		for (EpEncodeTypeEnum callBackEnum : enumArray)
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
		EpEncodeTypeEnum[] enumArray = EpEncodeTypeEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (EpEncodeTypeEnum callBackEnum : enumArray)
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
		EpEncodeTypeEnum[] enumArray = EpEncodeTypeEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (EpEncodeTypeEnum callBackEnum : enumArray)
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
