package com.weizu.web.domain.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:流量包开通状态枚举
 * @projectName:crud
 * @className:PgInServiceEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月26日 下午2:33:19
 * @version 1.0
 */
public enum PgInServiceEnum {
	/**
	 * 开通状态
	 */
	OPEN("开通",1),
	/**
	 * 关闭状态
	 */
	CLOSE("关闭",0);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private PgInServiceEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static PgInServiceEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		PgInServiceEnum resultEnum = null;

		// 获取附件类型枚举数组
		PgInServiceEnum[] enumArray = PgInServiceEnum.values();

		for (PgInServiceEnum pgInServiceEnum : enumArray)
		{
			if(value.equals(pgInServiceEnum.getValue()))
			{
				resultEnum = pgInServiceEnum;
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
		PgInServiceEnum[] enumArray = PgInServiceEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (PgInServiceEnum pgInServiceEnum : enumArray)
		{
			String key = String.valueOf(getEnum(pgInServiceEnum.getValue()));

			Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
			pgInServiceMap.put("desc", pgInServiceEnum.getDesc());
			pgInServiceMap.put("value", pgInServiceEnum.getValue());

			enumMap.put(key, pgInServiceMap);
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
		PgInServiceEnum[] enumArray = PgInServiceEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (PgInServiceEnum pgInServiceEnum : enumArray)
		{
			Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
			pgInServiceMap.put("desc", pgInServiceEnum.getDesc());
			pgInServiceMap.put("value", pgInServiceEnum.getValue());

			attachmentTypeMapList.add(pgInServiceMap);
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
