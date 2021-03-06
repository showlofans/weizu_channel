package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 代理商类型枚举
 * @projectName:weizu-channel
 * @className:AgencyLevelEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年1月4日 下午2:20:13
 * @version 1.0
 */
public enum AgencyLevelEnum {
	/**
	 * 超管模式-1
	 */
	SUPPER_USER("超管模式",1),
	/**
	 * 一般用户-0
	 */
	PLAT_USER("一般用户",0);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private AgencyLevelEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static AgencyLevelEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		AgencyLevelEnum resultEnum = null;

		// 获取附件类型枚举数组
		AgencyLevelEnum[] enumArray = AgencyLevelEnum.values();

		for (AgencyLevelEnum agencyTagEnum : enumArray)
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
		AgencyLevelEnum[] enumArray = AgencyLevelEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (AgencyLevelEnum agencyTagEnum : enumArray)
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
		AgencyLevelEnum[] enumArray = AgencyLevelEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (AgencyLevelEnum agencyTagEnum : enumArray)
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
