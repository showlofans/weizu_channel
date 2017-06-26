package org.weizu.api.outter.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 对下充值接口状态枚举
 * @projectName:weizu-web-api
 * @className:ChargeStatusEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月26日 下午2:04:18
 * @version 1.0
 */
public enum OrderStateCheckEnum {
	
	/**
	 * 用户验证失败
	 */
	AUTHENTICATION_FAILURE("用户验证失败",0),
	
	/**
	 * 订单号为空
	 */
	ORDERID_ISNULL("订单号为空",7),
	
	/**
	 * 没有找到该订单
	 */
	ORDER_NOT_FOUND("没有找到该订单",8),
	/**
	 * 手机号不对！
	 */
	TELPHONE_ERROR("手机号不对！",3),
	/**
	 * 参数正确
	 */
	PARAMS_SUCCESS("参数正确",1);
	
	private String desc;
	private Integer value;
	
	private OrderStateCheckEnum(String desc, Integer value) {
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
	public static OrderStateCheckEnum getEnum(Integer value)
	{

		if(value == null){
			return null;
		}
		OrderStateCheckEnum resultEnum = null;

		// 获取附件类型枚举数组
		OrderStateCheckEnum[] enumArray = OrderStateCheckEnum.values();

		for (OrderStateCheckEnum chargeStatusEnum : enumArray)
		{
			if(value == chargeStatusEnum.getValue())
			{
				resultEnum = chargeStatusEnum;
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
		OrderStateCheckEnum[] enumArray = OrderStateCheckEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (OrderStateCheckEnum orderStateCheckEnum : enumArray)
		{
			String key = String.valueOf(getEnum(orderStateCheckEnum.getValue()));

			Map<String, Object> orderStateCheckMap = new HashMap<String, Object>(2);
			orderStateCheckMap.put("desc", orderStateCheckEnum.getDesc());
			orderStateCheckMap.put("value", orderStateCheckEnum.getValue());

			enumMap.put(key, orderStateCheckMap);
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
		OrderStateCheckEnum[] enumArray = OrderStateCheckEnum.values();

		// 定义枚举list
		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (OrderStateCheckEnum orderStateCheckEnum : enumArray)
		{
			Map<String, Object> orderStateCheckMap = new HashMap<String, Object>(2);
			orderStateCheckMap.put("desc", orderStateCheckEnum.getDesc());
			orderStateCheckMap.put("value", orderStateCheckEnum.getValue());

			operatorNameMapList.add(orderStateCheckMap);
		}

		return operatorNameMapList;
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
