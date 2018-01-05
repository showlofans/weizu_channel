package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:交易类型枚举
 * @projectName:crud
 * @className:AccountTypeEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年5月11日 上午11:16:05
 * @version 1.0
 */
public enum BusinessOperatorEnum {
	
	/**
	 * tao-移动
	 */
	XIAO_TAO(0, "tao"),
	/**
	 *  bing-移动
	 */
	XIAO_BING(0, "bing"),
	/**
	 * zhan-联通
	 */
	XIAO_ZHAN(1, "zhan"),
	/**
	 *  bing-移动
	 */
	TelCome(2, "telCome");
	
	private Integer value;
	private String desc;
	
	/**
	 * @description: 通过值，获得键
	 * @param desc
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月30日 下午3:36:28
	 */
	public static Integer getValueByDesc(String desc){
		BusinessOperatorEnum[] enumAry = BusinessOperatorEnum.values();
		for (BusinessOperatorEnum businessOperatorEnum : enumAry) {
			if(businessOperatorEnum.desc.contains(desc) ){
				return businessOperatorEnum.value;
			}
		}
		return null;
	}
	
	/**
	 * @description:通过枚举值获取枚举
	 * @param value
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:33:32
	 */
	public static BusinessOperatorEnum getEnum(Integer value)
	{

		if(value == null){
			return null;
		}
		BusinessOperatorEnum resultEnum = null;

		// 获取附件类型枚举数组
		BusinessOperatorEnum[] enumArray = BusinessOperatorEnum.values();

		for (BusinessOperatorEnum accountTypeEnum : enumArray)
		{
			if(value == accountTypeEnum.getValue())
			{
				resultEnum = accountTypeEnum;
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
		BusinessOperatorEnum[] enumArray = BusinessOperatorEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (BusinessOperatorEnum accountTypeEnum : enumArray)
		{
			String key = String.valueOf(getEnum(accountTypeEnum.getValue()));

			Map<String, Object> accountTypeMap = new HashMap<String, Object>(2);
			accountTypeMap.put("desc", accountTypeEnum.getDesc());
			accountTypeMap.put("value", accountTypeEnum.getValue());

			enumMap.put(key, accountTypeMap);
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
		BusinessOperatorEnum[] enumArray = BusinessOperatorEnum.values();

		// 定义枚举list
		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (BusinessOperatorEnum accountTypeEnum : enumArray)
		{
			Map<String, Object> accountTypeMap = new HashMap<String, Object>(2);
			accountTypeMap.put("desc", accountTypeEnum.getDesc());
			accountTypeMap.put("value", accountTypeEnum.getValue());

			operatorNameMapList.add(accountTypeMap);
		}

		return operatorNameMapList;
	}
	
	private BusinessOperatorEnum(Integer value, String desc) {
		this.desc = desc;
		this.value = value;
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
