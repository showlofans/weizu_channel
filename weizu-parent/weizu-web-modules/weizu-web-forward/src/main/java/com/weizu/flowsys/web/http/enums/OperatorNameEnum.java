package com.weizu.flowsys.web.http.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:运营商名称枚举类
 * @projectName:crud
 * @className:OperatorNameEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年4月26日 下午12:45:07
 * @version 1.0
 */
public enum OperatorNameEnum {
	/**
	 * 中国移动
	 */
	CHINAMOBILE("china_mobile","中国移动"),
	
	/**
	 * 中国联通
	 */
	CHINALINK("china_link","中国联通"),
	
	/**
	 * 中国电信
	 */
	CHINATELECOME("china_telecome","中国电信");
	
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private String value;
	
	private OperatorNameEnum(String desc, String value) {
		this.desc = desc;
		this.value = value;
	}

	/**
	 * @description:通过枚举值获取枚举
	 * @param value
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:33:32
	 */
	public static OperatorNameEnum getEnum(String value)
	{
		if (value == null)
		{
			return null;
		}

		OperatorNameEnum resultEnum = null;

		// 获取附件类型枚举数组
		OperatorNameEnum[] enumArray = OperatorNameEnum.values();

		for (OperatorNameEnum OperatorNameEnum : enumArray)
		{
			if(value.equals(OperatorNameEnum.getValue()))
			{
				resultEnum = OperatorNameEnum;
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
		OperatorNameEnum[] enumArray = OperatorNameEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (OperatorNameEnum operatorNameEnum : enumArray)
		{
			String key = String.valueOf(getEnum(operatorNameEnum.getValue()));

			Map<String, Object> operatorNameMap = new HashMap<String, Object>(2);
			operatorNameMap.put("desc", operatorNameEnum.getDesc());
			operatorNameMap.put("value", operatorNameEnum.getValue());

			enumMap.put(key, operatorNameMap);
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
		OperatorNameEnum[] enumArray = OperatorNameEnum.values();

		// 定义枚举list
		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (OperatorNameEnum operatorNameEnum : enumArray)
		{
			Map<String, Object> operatorNameMap = new HashMap<String, Object>(2);
			operatorNameMap.put("desc", operatorNameEnum.getDesc());
			operatorNameMap.put("value", operatorNameEnum.getValue());

			operatorNameMapList.add(operatorNameMap);
		}

		return operatorNameMapList;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
