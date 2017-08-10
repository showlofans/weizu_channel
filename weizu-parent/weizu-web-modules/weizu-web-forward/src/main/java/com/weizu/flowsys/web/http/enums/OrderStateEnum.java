package com.weizu.flowsys.web.http.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OrderStateEnum {
	
	/**
	 * 未充值
	 */
	WEICHONG("未充",4),
	/**
	 * 等待充值
	 */
	DAICHONG("待充",3),
	/**
	 * 正在充值
	 */
	CHARGING("正在充值",2),
	/**
	 * 充值成功
	 */
	CHARGED("成功",1),
	/**
	 * 充值失败
	 */
	UNCHARGE("失败",0);
	
	private String desc;
	private int value;
	
	private OrderStateEnum(String desc, int value) {
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
	public static OrderStateEnum getEnum(Integer value)
	{

		if(value == null){
			return null;
		}
		OrderStateEnum resultEnum = null;

		// 获取附件类型枚举数组
		OrderStateEnum[] enumArray = OrderStateEnum.values();

		for (OrderStateEnum orderStateEnum : enumArray)
		{
			if(value == orderStateEnum.getValue())
			{
				resultEnum = orderStateEnum;
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
		OrderStateEnum[] enumArray = OrderStateEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (OrderStateEnum orderStateEnum : enumArray)
		{
			String key = String.valueOf(getEnum(orderStateEnum.getValue()));

			Map<String, Object> orderStateMap = new HashMap<String, Object>(2);
			orderStateMap.put("desc", orderStateEnum.getDesc());
			orderStateMap.put("value", orderStateEnum.getValue());

			enumMap.put(key, orderStateMap);
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
		OrderStateEnum[] enumArray = OrderStateEnum.values();

		// 定义枚举list
		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (OrderStateEnum orderStateEnum : enumArray)
		{
			Map<String, Object> orderStateMap = new HashMap<String, Object>(2);
			orderStateMap.put("desc", orderStateEnum.getDesc());
			orderStateMap.put("value", orderStateEnum.getValue());

			operatorNameMapList.add(orderStateMap);
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
