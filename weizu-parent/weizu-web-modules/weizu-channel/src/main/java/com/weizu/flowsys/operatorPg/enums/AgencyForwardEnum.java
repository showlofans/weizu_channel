package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 代理商朝向枚举
 * @projectName:weizu-channel
 * @className:AgencyForwardEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月6日 下午3:30:46
 * @version 1.0
 */
public enum AgencyForwardEnum {
	/**
	 * 上游-1
	 */
	FOWARD("上游",1),
	/**
	 * 下游-0
	 */
	BACKWARD("下游",0);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private AgencyForwardEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static AgencyForwardEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		AgencyForwardEnum resultEnum = null;

		// 获取附件类型枚举数组
		AgencyForwardEnum[] enumArray = AgencyForwardEnum.values();

		for (AgencyForwardEnum agencyTagEnum : enumArray)
		{
			if(value.equals(agencyTagEnum.getValue()))
			{
				resultEnum = agencyTagEnum;
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
		AgencyForwardEnum[] enumArray = AgencyForwardEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (AgencyForwardEnum agencyTagEnum : enumArray)
		{
			String key = String.valueOf(getEnum(agencyTagEnum.getValue()));

			Map<String, Object> agencyTagMap = new HashMap<String, Object>(2);
			agencyTagMap.put("desc", agencyTagEnum.getDesc());
			agencyTagMap.put("value", agencyTagEnum.getValue());

			enumMap.put(key, agencyTagMap);
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
		AgencyForwardEnum[] enumArray = AgencyForwardEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (AgencyForwardEnum agencyTagEnum : enumArray)
		{
			Map<String, Object> agencyTagMap = new HashMap<String, Object>(2);
			agencyTagMap.put("desc", agencyTagEnum.getDesc());
			agencyTagMap.put("value", agencyTagEnum.getValue());

			attachmentTypeMapList.add(agencyTagMap);
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
//		AgencyTagEnum[] enumArray = AgencyTagEnum.values();
//		
//		// 定义枚举list
//		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);
//		
//		for (AgencyTagEnum agencyTagEnum : enumArray)
//		{
//			if(agencyTagEnum!=BIND){
//				Map<String, Object> agencyTagMap = new HashMap<String, Object>(2);
//				agencyTagMap.put("desc", agencyTagEnum.getDesc());
//				agencyTagMap.put("value", agencyTagEnum.getValue());
//				attachmentTypeMapList.add(agencyTagMap);
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
