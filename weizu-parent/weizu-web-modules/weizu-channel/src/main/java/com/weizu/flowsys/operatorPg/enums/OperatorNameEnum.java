package com.weizu.flowsys.operatorPg.enums;

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
	CHINAMOBILE("中国移动",0),//china_mobile
	
	/**
	 * 中国联通
	 */
	CHINALINK("中国联通",1),
	
	/**
	 * 中国电信
	 */
	CHINATELECOME("中国电信",2);//china_telecome
	
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private int value;
	
	private OperatorNameEnum(String desc, int value) {
		this.desc = desc;
		this.value = value;
	}
	
	/**
	 * @description: 根据移动得到中国移动
	 * @param desct
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月2日 下午2:44:30
	 */
	public static String getDescBy(String desct){
		String desc = "中国移动";
		// 获取附件类型枚举数组
		OperatorNameEnum[] enumArray = OperatorNameEnum.values();

		for (OperatorNameEnum OperatorNameEnum : enumArray)
		{
			if(OperatorNameEnum.getDesc().indexOf(desct) != -1)
			{
				desc = OperatorNameEnum.getDesc();
				break;
			}
		}
		return desc;
	}

	/**
	 * @description:通过枚举值获取枚举
	 * @param value
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:33:32
	 */
	public static OperatorNameEnum getEnum(int value)
	{

		OperatorNameEnum resultEnum = null;

		// 获取附件类型枚举数组
		OperatorNameEnum[] enumArray = OperatorNameEnum.values();

		for (OperatorNameEnum OperatorNameEnum : enumArray)
		{
			if(OperatorNameEnum.getValue() == value)
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
