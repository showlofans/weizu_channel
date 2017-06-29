package org.weizu.api.facet.orderState;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

/**
 * @description: 订单返回状态枚举
 * @projectName:weizu-web-api
 * @className:OrderStateAPIEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月29日 上午9:40:18
 * @version 1.0
 */
public enum OrderStatePageEnum {
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
	
	private OrderStatePageEnum(String desc, int value) {
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
	public static OrderStatePageEnum getEnum(Integer value)
	{

		if(value == null){
			return null;
		}
		OrderStatePageEnum resultEnum = null;

		// 获取附件类型枚举数组
		OrderStatePageEnum[] enumArray = OrderStatePageEnum.values();

		for (OrderStatePageEnum orderStatePageEnum : enumArray)
		{
			if(value == orderStatePageEnum.getValue())
			{
				resultEnum = orderStatePageEnum;
				break;
			}
		}

		return resultEnum;
	}
	
//	/**
//	 * @description:将枚举转换为MAP，转换成的MAP的key值为枚举值，value值为一个MAP，包含desc和value两个key，值分别为枚举的desc和value值
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年4月26日 下午12:36:17
//	 */
//	public static Map<String, Map<String, Object>> toMap()
//	{
//		// 获取附件类型枚举数组
//		OrderStateAPIEnum[] enumArray = OrderStateAPIEnum.values();
//
//		// 定义枚举MAP
//		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);
//
//		for (OrderStateAPIEnum OrderStateAPIEnum : enumArray)
//		{
//			String key = String.valueOf(getEnum(OrderStateAPIEnum.getValue()));
//
//			Map<String, Object> orderStateMap = new HashMap<String, Object>(2);
//			orderStateMap.put("desc", OrderStateAPIEnum.getDesc());
//			orderStateMap.put("value", OrderStateAPIEnum.getValue());
//
//			enumMap.put(key, orderStateMap);
//		}
//
//		return enumMap;
//	}
//	
//	/**
//	 * @description:将枚举转换成list，其中每个值为一个Map，包含desc和value两个key，值分别为枚举的desc和value值
//	 * @return
//	 * @author:POP产品研发部 宁强
//	 * @createTime:2017年4月26日 下午12:36:27
//	 */
//	public static List<Map<String, Object>> toList()
//	{
//		// 获取附件类型枚举数组
//		OrderStateAPIEnum[] enumArray = OrderStateAPIEnum.values();
//
//		// 定义枚举list
//		List<Map<String, Object>> operatorNameMapList = new ArrayList<Map<String, Object>>(enumArray.length);
//
//		for (OrderStateAPIEnum OrderStateAPIEnum : enumArray)
//		{
//			Map<String, Object> orderStateMap = new HashMap<String, Object>(2);
//			orderStateMap.put("desc", OrderStateAPIEnum.getDesc());
//			orderStateMap.put("value", OrderStateAPIEnum.getValue());
//
//			operatorNameMapList.add(orderStateMap);
//		}
//
//		return operatorNameMapList;
//	}
	
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
