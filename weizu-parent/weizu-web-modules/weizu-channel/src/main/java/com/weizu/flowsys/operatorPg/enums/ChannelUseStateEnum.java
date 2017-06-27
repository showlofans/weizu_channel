package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 通道使用状态枚举
 * @projectName:weizu-channel
 * @className:ChannelUseStateEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年6月27日 上午11:30:30
 * @version 1.0
 */
public enum ChannelUseStateEnum {
	/**
	 * 运行状态
	 */
	OPEN("已启用",0),
	/**
	 * 暂停状态
	 */
	CLOSE("已暂停",1);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private ChannelUseStateEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static ChannelUseStateEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		ChannelUseStateEnum resultEnum = null;

		// 获取附件类型枚举数组
		ChannelUseStateEnum[] enumArray = ChannelUseStateEnum.values();

		for (ChannelUseStateEnum channelUseStateEnum : enumArray)
		{
			if(value.equals(channelUseStateEnum.getValue()))
			{
				resultEnum = channelUseStateEnum;
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
		ChannelUseStateEnum[] enumArray = ChannelUseStateEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (ChannelUseStateEnum channelUseStateEnum : enumArray)
		{
			String key = String.valueOf(getEnum(channelUseStateEnum.getValue()));

			Map<String, Object> channelUseStateMap = new HashMap<String, Object>(2);
			channelUseStateMap.put("desc", channelUseStateEnum.getDesc());
			channelUseStateMap.put("value", channelUseStateEnum.getValue());

			enumMap.put(key, channelUseStateMap);
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
		ChannelUseStateEnum[] enumArray = ChannelUseStateEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (ChannelUseStateEnum channelUseStateEnum : enumArray)
		{
			Map<String, Object> channelUseStateMap = new HashMap<String, Object>(2);
			channelUseStateMap.put("desc", channelUseStateEnum.getDesc());
			channelUseStateMap.put("value", channelUseStateEnum.getValue());

			attachmentTypeMapList.add(channelUseStateMap);
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
