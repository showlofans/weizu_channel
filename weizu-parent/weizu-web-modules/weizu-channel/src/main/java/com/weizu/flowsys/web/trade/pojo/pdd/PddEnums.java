package com.weizu.flowsys.web.trade.pojo.pdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 代理商类型枚举
 * @projectName:weizu-channel
 * @className:AgencyTagEnum.java
 * @author:POP产品研发部 宁强
 * @createTime:2017年7月25日 上午10:30:05
 * @version 1.0
 */
public enum PddEnums {
	/**
	 * 处理成功-0
	 */
	success("处理成功",0),
	
	/**
	 * 处理异常- -1
	 */
	exception("处理异常",-1),
//	/**
//	 * 商品不存在-15
//	 */
//	pc_not_fund("商品不存在",15),
	/**
	 * 余额不足-20
	 */
	out_of_balance("余额不足",20),
	/**
	 * 未知错误-21
	 */
	unknwon_pro("未知错误",21),
	/**
	 * 签名错误-12
	 */
	sign_error("签名错误",12);
	/**
	 * 枚举名称
	 */
	private String desc;
	/**
	 * 枚举值
	 */
	private Integer value;
	
	private PddEnums(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	public static PddEnums getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		PddEnums resultEnum = null;

		// 获取附件类型枚举数组
		PddEnums[] enumArray = PddEnums.values();

		for (PddEnums agencyTagEnum : enumArray)
		{
			if(value.equals(agencyTagEnum.getValue()))
			{
				resultEnum = agencyTagEnum;
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
		PddEnums[] enumArray = PddEnums.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (PddEnums agencyTagEnum : enumArray)
		{
			String key = String.valueOf(getEnum(agencyTagEnum.getValue()));

			Map<String, Object> agencyTagMap = new HashMap<String, Object>(2);
			agencyTagMap.put("desc", agencyTagEnum.getDesc());
			agencyTagMap.put("value", agencyTagEnum.getValue());

			enumMap.put(key, agencyTagMap);
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
		PddEnums[] enumArray = PddEnums.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (PddEnums agencyTagEnum : enumArray)
		{
			Map<String, Object> agencyTagMap = new HashMap<String, Object>(2);
			agencyTagMap.put("desc", agencyTagEnum.getDesc());
			agencyTagMap.put("value", agencyTagEnum.getValue());

			attachmentTypeMapList.add(agencyTagMap);
		}

		return attachmentTypeMapList;
	}
	/**
	 * @description:将枚举转换成list，其中每个值为一个Map，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:27
	 */
//	public static List<Map<String, Object>> toBindList()
//	{
//		// 获取附件类型枚举数组
//		AgencyTagEnum[] enumArray = AgencyTagEnum.values();
//		
//		// 定义枚举list
//		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);
//		
//		for (AgencyTagEnum agencyTagEnum : enumArray)
//		{
//			if(agencyTagEnum!=BIND){
//				Map<String, Object> agencyTagMap = new HashMap<String, Object>(2);
//				agencyTagMap.put("desc", agencyTagEnum.getDesc());
//				agencyTagMap.put("value", agencyTagEnum.getValue());
//				attachmentTypeMapList.add(agencyTagMap);
//			}
//		}
//		
//		return attachmentTypeMapList;
//	}
	
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