package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 话费基本标准价业务枚举
 * @projectName:weizu-channel
 * @className:ChargeTelEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年11月10日 下午4:18:28
 * @version 1.0
 */
public enum ChargeTelEnum {
	
	/**
	 *  30元话费
	 */
	Thirty("30元",30),
	/**
	 *  50元话费
	 */
	fifty("50元",50),
	/**
	 *  100元话费
	 */
	one_hundred("100元",100),
	/**
	 *  10元话费
	 */
	ten("10元",10),
	/**
	 *  20元话费
	 */
	tweenty("20元",20),
	/**
	 *  200元话费
	 */
	two_hundred("200元",200),
	/**
	 *  300元话费
	 */
	three_hundred("300元",300),
	/**
	 *  400元话费
	 */
	four_hundred("400元",400),
	/**
	 * 500元话费
	 */
	five_hundred("500元",500),
	/**
	 * 任意价格：根据页面输入价格去设置任意价格的值
	 */
	INCREASE("任意价格",-1);
	
	private String desc;
	private Integer value;
	
	/**
	 * @description:通过枚举值获取枚举
	 * @param value
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:33:32
	 */
	public static ChargeTelEnum getEnum(Integer value)
	{

		if(value == null){
			return null;
		}
		ChargeTelEnum resultEnum = null;

		// 获取附件类型枚举数组
		ChargeTelEnum[] enumArray = ChargeTelEnum.values();

		for (ChargeTelEnum accountTypeEnum : enumArray)
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
		ChargeTelEnum[] enumArray = ChargeTelEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (ChargeTelEnum accountTypeEnum : enumArray)
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
		ChargeTelEnum[] enumArray = ChargeTelEnum.values();

		// 定义枚举list
		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (ChargeTelEnum accountTypeEnum : enumArray)
		{
			Map<String, Object> accountTypeMap = new HashMap<String, Object>(2);
			accountTypeMap.put("desc", accountTypeEnum.getDesc());
			accountTypeMap.put("value", accountTypeEnum.getValue());

			operatorNameMapList.add(accountTypeMap);
		}

		return operatorNameMapList;
	}
	/**
	 * @description:订单消费账户类型枚举
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年9月21日 上午11:48:21
	 */
	public static List<Map<String, Object>> toConsumeList()
	{
		// 获取附件类型枚举数组
		ChargeTelEnum[] enumArray = ChargeTelEnum.values();
		
		// 定义枚举list
		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);
		
		for (ChargeTelEnum accountTypeEnum : enumArray)
		{
			if(accountTypeEnum.getValue() == INCREASE.getValue()){
				continue;
			}
			Map<String, Object> accountTypeMap = new HashMap<String, Object>(2);
			accountTypeMap.put("desc", accountTypeEnum.getDesc());
			accountTypeMap.put("value", accountTypeEnum.getValue());
			
			operatorNameMapList.add(accountTypeMap);
		}
		
		return operatorNameMapList;
	}
	
	
	private ChargeTelEnum(String desc, Integer value) {
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
