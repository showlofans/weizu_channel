package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 包体有效期枚举
 * @projectName:weizu-channel
 * @className:PgValidityEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月25日 下午3:39:31
 * @version 1.0
 */
public enum PgValidityEnum {
	
	/**
	 * 月包
	 */
	month_day_data("月包", "30"),
	/**
	 * 1日包
	 */
	one_day_data("1日包", "01"),
	/**
	 * 3日包
	 */
	three_day_data("3日包", "03"),
	/**
	 * 7日包
	 */
	seven_day_data("7日包", "07"),
	/**
	 * 季度包
	 */
	one_season_data("季度包", "90"),
	/**
	 * 半年包
	 */
	half_year_data("半年包", "180"),
	/**
	 * 年包
	 */
	one_year_data("年包", "365");
	

	/** 描述 */
	private String desc;

	/** 枚举值 */
	private String value;

	private PgValidityEnum(String desc, String value)
	{
		this.desc = desc;
		this.value = value;
	}
	
	/**
	 * @description: 通过值，获得键
	 * @param desc
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年8月2日 上午11:49:03
	 */
	public static String getValueByDesc(String desc){
		PgValidityEnum[] enumAry = PgValidityEnum.values();
		for (PgValidityEnum scopeCityEnum : enumAry) {
			if(scopeCityEnum.desc.contains(desc) ){
				return scopeCityEnum.value;
			}
		}
		return null;
	}
	
	/**
	 * @description: 获得值数组
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年7月6日 下午3:49:25
	 */
	public static String[] getValues(){
		PgValidityEnum[] enumAry = PgValidityEnum.values();
		String [] valueArray = new String[enumAry.length];
		for (int i = 0; i < enumAry.length; i++) {
			valueArray[i] = enumAry[i].getValue();
		}
		return valueArray;
	}

	public static PgValidityEnum getEnum(String value)
	{
		PgValidityEnum resultEnum = null;
		PgValidityEnum[] enumAry = PgValidityEnum.values();

		for (int i = 0; i < enumAry.length; i++)
		{
			if (enumAry[i].getValue().equals(value))
			{
				resultEnum = enumAry[i];
				break;
			}
		}

		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap()
	{
		PgValidityEnum[] ary = PgValidityEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();

		for (int num = 0; num < ary.length; num++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("desc", ary[num].getDesc());
			map.put("value", ary[num].getValue());

			enumMap.put(key, map);
		}

		return enumMap;
	}

	public static List<Map<String, Object>> toList()
	{
		PgValidityEnum[] ary = PgValidityEnum.values();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < ary.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("desc", ary[i].getDesc());
			map.put("value", ary[i].getValue());

			list.add(map);
		}

		return list;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

}
