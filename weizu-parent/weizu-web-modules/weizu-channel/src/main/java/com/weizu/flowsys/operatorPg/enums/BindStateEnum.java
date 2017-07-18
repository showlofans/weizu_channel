package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:通道代理商绑定状态枚举
 * @projectName:crud
 * @className:bindStateEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月26日 下午2:33:19
 * @version 1.0
 */
public enum BindStateEnum {
	/**
	 * 绑定状态
	 */
	BIND("已绑定",0),
	/**
	 * 解绑状态
	 */
	UNBIND("已解绑",1),
	/**
	 * 未绑定
	 */
	NO("未绑定",2);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private BindStateEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static BindStateEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		BindStateEnum resultEnum = null;

		// 获取附件类型枚举数组
		BindStateEnum[] enumArray = BindStateEnum.values();

		for (BindStateEnum bindStateEnum : enumArray)
		{
			if(value.equals(bindStateEnum.getValue()))
			{
				resultEnum = bindStateEnum;
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
		BindStateEnum[] enumArray = BindStateEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (BindStateEnum bindStateEnum : enumArray)
		{
			String key = String.valueOf(getEnum(bindStateEnum.getValue()));

			Map<String, Object> bindStateMap = new HashMap<String, Object>(2);
			bindStateMap.put("desc", bindStateEnum.getDesc());
			bindStateMap.put("value", bindStateEnum.getValue());

			enumMap.put(key, bindStateMap);
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
		BindStateEnum[] enumArray = BindStateEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (BindStateEnum bindStateEnum : enumArray)
		{
			Map<String, Object> bindStateMap = new HashMap<String, Object>(2);
			bindStateMap.put("desc", bindStateEnum.getDesc());
			bindStateMap.put("value", bindStateEnum.getValue());

			attachmentTypeMapList.add(bindStateMap);
		}

		return attachmentTypeMapList;
	}
	/**
	 * @description:将枚举转换成list，其中每个值为一个Map，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:27
	 */
	public static List<Map<String, Object>> toBindList()
	{
		// 获取附件类型枚举数组
		BindStateEnum[] enumArray = BindStateEnum.values();
		
		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);
		
		for (BindStateEnum bindStateEnum : enumArray)
		{
			if(bindStateEnum!=BIND){
				Map<String, Object> bindStateMap = new HashMap<String, Object>(2);
				bindStateMap.put("desc", bindStateEnum.getDesc());
				bindStateMap.put("value", bindStateEnum.getValue());
				attachmentTypeMapList.add(bindStateMap);
			}
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
