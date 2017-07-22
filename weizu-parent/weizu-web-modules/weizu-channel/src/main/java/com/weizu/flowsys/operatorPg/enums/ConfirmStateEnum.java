package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 认证信息审核状态枚举
 * @projectName:weizu-channel
 * @className:ConfirmStateEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月21日 下午4:49:18
 * @version 1.0
 */
public enum ConfirmStateEnum {
	
	/**
	 * 认证失败
	 */
	FAIL_CONFIRM("认证失败",0),
	/**
	 * 待验证
	 */
	ON_CONFIRM("待验证",2),
	/**
	 * 认证信息待完善:草稿）
	 */
	INCOMPLETE_CONFIRM("待完善",3),
	/**
	 * 认证通过
	 */
	CONFIRM_PASS("通过",1);
	
	private String desc;
	private Integer value;
	
	private ConfirmStateEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	
	public static ConfirmStateEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		ConfirmStateEnum resultEnum = null;

		// 获取附件类型枚举数组
		ConfirmStateEnum[] enumArray = ConfirmStateEnum.values();

		for (ConfirmStateEnum BillTypeEnum : enumArray)
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
		ConfirmStateEnum[] enumArray = ConfirmStateEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (ConfirmStateEnum confirmStateEnum : enumArray)
		{
			String key = String.valueOf(getEnum(confirmStateEnum.getValue()));

			Map<String, Object> ConfirmStateMap = new HashMap<String, Object>(2);
			ConfirmStateMap.put("desc", confirmStateEnum.getDesc());
			ConfirmStateMap.put("value", confirmStateEnum.getValue());

			enumMap.put(key, ConfirmStateMap);
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
		ConfirmStateEnum[] enumArray = ConfirmStateEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (ConfirmStateEnum confirmStateEnum : enumArray)
		{
			Map<String, Object> ConfirmStateMap = new HashMap<String, Object>(2);
			ConfirmStateMap.put("desc", confirmStateEnum.getDesc());
			ConfirmStateMap.put("value", confirmStateEnum.getValue());

			attachmentTypeMapList.add(ConfirmStateMap);
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
