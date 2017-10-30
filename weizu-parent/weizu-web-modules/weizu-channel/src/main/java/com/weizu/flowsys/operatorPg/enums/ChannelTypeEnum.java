package com.weizu.flowsys.operatorPg.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.weizu.flowsys.web.channel.pojo.SpecialCnelType;
import com.weizu.flowsys.web.channel.pojo.SpecialCnelType;

/**
 * @description: 通道类型枚举
 * @projectName:weizu-channel
 * @className:ChannelTypeEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2017年10月26日 上午11:42:59
 * @version 1.0
 */
public enum ChannelTypeEnum {
	
	/**
	 * 普通流量	
	 */
	ORDINARY("普通流量",1),
	/**
	 * 红包流量	
	 */
	RED_PACKET("红包流量",2),
	/**
	 * 转移流量	
	 */
	MOBILE("转移流量",3),//通道类型（1-普通通道包，2-红包通道，3-转移包，4-共享包）
	/**
	 * 对公业务
	 */
	PUBLIC_SHARE("共享流量",4);
	
	private String desc;
	private Integer value;
	
	private ChannelTypeEnum(String desc, Integer value) {
		this.desc = desc;
		this.value = value;
	}
	
	public static ChannelTypeEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		ChannelTypeEnum resultEnum = null;

		// 获取附件类型枚举数组
		ChannelTypeEnum[] enumArray = ChannelTypeEnum.values();

		for (ChannelTypeEnum BillTypeEnum : enumArray)
		{
			if(value.equals(BillTypeEnum.getValue()))
			{
				resultEnum = BillTypeEnum;
				break;
			}
		}

		return resultEnum;
	}
	
	/**
	 * @description: 获得特别的备注
	 * @param value
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年10月27日 下午12:23:22
	 */
	public static String getSpecialDesc(int value){
		// 获取附件类型枚举数组
		ChannelTypeEnum[] enumArray = ChannelTypeEnum.values();
		for (ChannelTypeEnum ChannelTypeEnum : enumArray) {
			if(ChannelTypeEnum.getValue().equals(value)  && ChannelTypeEnum.ORDINARY.getValue() != value){
				return ChannelTypeEnum.getDesc();
			}
		}
		return null;
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
		ChannelTypeEnum[] enumArray = ChannelTypeEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (ChannelTypeEnum billTypeEnum : enumArray)
		{
			String key = String.valueOf(getEnum(billTypeEnum.getValue()));

			Map<String, Object> billTypeMap = new HashMap<String, Object>(2);
			billTypeMap.put("desc", billTypeEnum.getDesc());
			billTypeMap.put("value", billTypeEnum.getValue());
			
			enumMap.put(key, billTypeMap);
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
		ChannelTypeEnum[] enumArray = ChannelTypeEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (ChannelTypeEnum billTypeEnum : enumArray)
		{
			Map<String, Object> billTypeMap = new HashMap<String, Object>(2);
			billTypeMap.put("desc", billTypeEnum.getDesc());
			billTypeMap.put("value", billTypeEnum.getValue());

			attachmentTypeMapList.add(billTypeMap);
		}

		return attachmentTypeMapList;
	}
	
	public static List<Map<String, Object>> toSpecialList(List<SpecialCnelType> specialCnelList, List<Long> agnecyCnelList)
	{
		if(specialCnelList == null || specialCnelList.size() == 0){
			return null;
		}
		
		// 获取附件类型枚举数组
		ChannelTypeEnum[] enumArray = ChannelTypeEnum.values();
	    Set<Integer> result = new HashSet<Integer>();
		
		Set<Integer> allCnelType = new HashSet<Integer>();
		for (ChannelTypeEnum cnelTypeEnum : enumArray) {
			allCnelType.add(cnelTypeEnum.getValue()) ;
		}
		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);
		
		//先添加第一个普通的
		Map<String, Object> pgInServiceMap1 = new HashMap<String, Object>(2);
		pgInServiceMap1.put("desc", ChannelTypeEnum.ORDINARY.getDesc());
		pgInServiceMap1.put("value", ChannelTypeEnum.ORDINARY.getValue());
		attachmentTypeMapList.add(pgInServiceMap1);
		
		Set<Integer> getChannelType = new HashSet<Integer>();	//set2
		
		for (Long agencyCnelId : agnecyCnelList) {
			for (SpecialCnelType cnelType : specialCnelList) {
				if(cnelType.getChannelId() == agencyCnelId){// && !ChannelTypeEnum.ORDINARY.getValue().equals(cnelType.getChannelType()
					getChannelType.add(cnelType.getChannelType());
				}
			}
		} 
		//差集运算
		result.clear();
        result.addAll(allCnelType);
        result.retainAll(getChannelType);
		
        for (ChannelTypeEnum cnelTypeEnum : enumArray) {
			 Iterator<Integer> i = result.iterator();//先迭代出来  
	        while(i.hasNext()){//遍历  
//	            System.out.println(i.next()); 
	            if(i.next().equals(cnelTypeEnum.getValue())){
	            	Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
	            	pgInServiceMap.put("desc", cnelTypeEnum.getDesc());
	            	pgInServiceMap.put("value", cnelTypeEnum.getValue());
	            	attachmentTypeMapList.add(pgInServiceMap);
	            }
	        }  
		}
		
        
//		for (Long agencyCnelId : agnecyCnelList) {
//			for (SpecialCnelType cnelType : specialCnelList) {
//				
//				
//				if(cnelType.getChannelId() == agencyCnelId){
//					ChannelTypeEnum pgInServiceEnum = getEnum(cnelType.getChannelType());
//					if(pgInServiceEnum != null){
//						Map<String, Object> pgInServiceMap = new HashMap<String, Object>(2);
//						pgInServiceMap.put("desc", pgInServiceEnum.getDesc());
//						pgInServiceMap.put("value", pgInServiceEnum.getValue());
//						attachmentTypeMapList.add(pgInServiceMap);
//					}
//				}
//			}
//		} 
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
