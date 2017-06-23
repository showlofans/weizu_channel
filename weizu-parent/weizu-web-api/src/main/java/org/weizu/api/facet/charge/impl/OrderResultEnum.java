package org.weizu.api.facet.charge.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 订单返回接口枚举
 * @projectName:crud
 * @className:OrderResultEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月12日 下午6:04:01
 * @version 1.0
 */
public enum OrderResultEnum {
	
	/**
	 * 充值成功
	 */
	SUCCESS("充值成功",0),
	
	/**
	 * 充值失败
	 */
	ERROR("充值失败",1001);
	
	private String msg;
	
	private Integer code;
	
	private OrderResultEnum(String msg, Integer code) {
		this.msg = msg;
		this.code = code;
	}

	public static OrderResultEnum getEnum(Integer code)
	{
		if (code == null)
		{
			return null;
		}

		OrderResultEnum resultEnum = null;

		// 获取附件类型枚举数组
		OrderResultEnum[] enumArray = OrderResultEnum.values();

		for (OrderResultEnum orderResultEnum : enumArray)
		{
			if(code.equals(orderResultEnum.getCode()))
			{
				resultEnum = orderResultEnum;
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
		OrderResultEnum[] enumArray = OrderResultEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (OrderResultEnum orderResultEnum : enumArray)
		{
			String key = String.valueOf(getEnum(orderResultEnum.getCode()));

			Map<String, Object> orderResultMap = new HashMap<String, Object>(2);
			orderResultMap.put("msg", orderResultEnum.getMsg());
			orderResultMap.put("code", orderResultEnum.getCode());

			enumMap.put(key, orderResultMap);
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
		OrderResultEnum[] enumArray = OrderResultEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (OrderResultEnum orderResultEnum : enumArray)
		{
			Map<String, Object> orderResultMap = new HashMap<String, Object>(2);
			orderResultMap.put("msg", orderResultEnum.getMsg());
			orderResultMap.put("code", orderResultEnum.getCode());

			attachmentTypeMapList.add(orderResultMap);
		}

		return attachmentTypeMapList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	
}
