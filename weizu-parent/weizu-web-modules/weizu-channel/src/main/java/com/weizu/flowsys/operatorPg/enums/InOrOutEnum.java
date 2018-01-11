package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:发票类型枚举
 * @projectName:crud
 * @className:BillTypeEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 上午11:23:52
 * @version 1.0
 */
public enum InOrOutEnum {
	
	/**
	 * 转入业务-0
	 */
	IN("转入",0),
	/**
	 * 转出业务-1
	 */
	OUT("转出",1);
	
	private String desc;
	private Integer value;
	
	private InOrOutEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	
	public static InOrOutEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		InOrOutEnum resultEnum = null;

		// 获取附件类型枚举数组
		InOrOutEnum[] enumArray = InOrOutEnum.values();

		for (InOrOutEnum BillTypeEnum : enumArray)
		{
			if(value.equals(BillTypeEnum.getValue()))
			{
				resultEnum = BillTypeEnum;
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
		InOrOutEnum[] enumArray = InOrOutEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (InOrOutEnum billTypeEnum : enumArray)
		{
			String key = String.valueOf(getEnum(billTypeEnum.getValue()));

			Map<String, Object> billTypeMap = new HashMap<String, Object>(2);
			billTypeMap.put("desc", billTypeEnum.getDesc());
			billTypeMap.put("value", billTypeEnum.getValue());
			
			enumMap.put(key, billTypeMap);
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
		InOrOutEnum[] enumArray = InOrOutEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (InOrOutEnum billTypeEnum : enumArray)
		{
			Map<String, Object> billTypeMap = new HashMap<String, Object>(2);
			billTypeMap.put("desc", billTypeEnum.getDesc());
			billTypeMap.put("value", billTypeEnum.getValue());

			attachmentTypeMapList.add(billTypeMap);
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
