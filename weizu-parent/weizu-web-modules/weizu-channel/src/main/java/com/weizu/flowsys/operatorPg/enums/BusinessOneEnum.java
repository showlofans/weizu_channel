package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.weizu.flowsys.web.channel.pojo.SpecialOpdType;

/**
 * @description: 包体有效期枚举
 * @projectName:weizu-channel
 * @className:PgValidityEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月25日 下午3:39:31
 * @version 1.0
 */
public enum BusinessOneEnum {
	
	/**
	 * 月包
	 */
	xiao_tao("小陶", "tao"),
	/**
	 * 月包
	 */
	xiao_bing("小兵", "bing"),
//	/**
//	 * 月包
//	 */
//	MONTH_DAY_DATA("月包", "30"),
	
	/**
	 * 年包
	 */
	xiao_zhan("小占", "zhan");
	

	/** 描述 */
	private String desc;

	/** 枚举值 */
	private String value;

	private BusinessOneEnum(String desc, String value)
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
		BusinessOneEnum[] enumAry = BusinessOneEnum.values();
		for (BusinessOneEnum scopeCityEnum : enumAry) {
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
		BusinessOneEnum[] enumAry = BusinessOneEnum.values();
		String [] valueArray = new String[enumAry.length];
		for (int i = 0; i < enumAry.length; i++) {
			valueArray[i] = enumAry[i].getValue();
		}
		return valueArray;
	}
	
	public static BusinessOneEnum getEnum(String value)
	{
		BusinessOneEnum resultEnum = null;
		BusinessOneEnum[] enumAry = BusinessOneEnum.values();

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
		BusinessOneEnum[] ary = BusinessOneEnum.values();
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
		BusinessOneEnum[] ary = BusinessOneEnum.values();
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
