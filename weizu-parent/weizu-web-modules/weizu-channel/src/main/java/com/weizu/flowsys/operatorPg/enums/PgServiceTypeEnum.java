package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.weizu.flowsys.web.channel.pojo.SpecialOpdType;
import com.weizu.web.foundation.String.StringHelper;


/**
 * @description: 流量业务类型枚举
 * @projectName:weizu-channel
 * @className:PgServiceTypeEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月8日 下午4:32:06
 * @version 1.0
 */
public enum PgServiceTypeEnum {
	/**
	 * 流量包
	 */
	PGCHARGE("流量",1),
	/**
	 * 话费
	 */
	TELCHARGE("话费",2);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private PgServiceTypeEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	
	public static PgServiceTypeEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		PgServiceTypeEnum resultEnum = null;

		// 获取附件类型枚举数组
		PgServiceTypeEnum[] enumArray = PgServiceTypeEnum.values();

		for (PgServiceTypeEnum pgInServiceEnum : enumArray)
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
		PgServiceTypeEnum[] enumArray = PgServiceTypeEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (PgServiceTypeEnum pgInServiceEnum : enumArray)
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
		PgServiceTypeEnum[] enumArray = PgServiceTypeEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (PgServiceTypeEnum pgInServiceEnum : enumArray)
		{
			Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
			pgInServiceMap.put("desc", pgInServiceEnum.getDesc());
			pgInServiceMap.put("value", pgInServiceEnum.getValue());

			attachmentTypeMapList.add(pgInServiceMap);
		}

		return attachmentTypeMapList;
	}
	
	/**
	 * @description: 获得特别的备注
	 * @param value
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月27日 下午12:23:22
	 */
	public static String getSpecialDesc(int value){
		// 获取附件类型枚举数组
		PgServiceTypeEnum[] enumArray = PgServiceTypeEnum.values();
		for (PgServiceTypeEnum pgTypeEnum : enumArray) {
			if(pgTypeEnum.getValue() == value && pgTypeEnum.getValue() != 1){
				return pgTypeEnum.getDesc();
			}
		}
		return null;
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